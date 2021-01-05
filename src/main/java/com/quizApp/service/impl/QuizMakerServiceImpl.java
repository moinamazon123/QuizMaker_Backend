package com.quizApp.service.impl;

import com.quizApp.domain.*;
import com.quizApp.model.ActivityLog;
import com.quizApp.model.QBankCategoryMap;
import com.quizApp.repository.*;


import com.quizApp.service.QuizMakerService;
import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class QuizMakerServiceImpl implements QuizMakerService {

    @Autowired
    private QuizMakerService quizMakerService;

    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private AuditRepository auditRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private SurveyUserRepository surveyUserRepository;

    @Autowired
    private QuizUserRepository quizUserRepository;

    @Autowired
    private UserQuestionMapRepository userQuestionMapRepository;


    @Autowired
    private UserRepository userRepository;

    /** The application logger */
    private static final Logger LOG = LoggerFactory.getLogger(QuizMakerServiceImpl.class);

    @Override
    public List<Activity> save(Activity activity) {

        activityRepository.save(activity);

        List<Activity> activityList= (List<Activity>) activityRepository.findAll();


        return activityList;

    }

    @Override
    public void removeActivityById(Long id) {

        activityRepository.delete(id);

    }

    @Override
    public List<Activity> findAll() {
        List<Activity> activityList = (List<Activity>)  activityRepository.findAll();
        return activityList ;
    }

    @Override
    public List<Category> saveCategory(Category category) {
        categoryRepository.save(category);

        List<Category> categoryList= (List<Category>) categoryRepository.findAll();


        return categoryList;

    }

    @Override
    public void removeCategoryById(Long id) throws ConstraintViolationException
    {

        categoryRepository.delete(id);
    }

    @Override
    public List<Category> findAllCategory() {
        List<Category> categoryList= (List<Category>) categoryRepository.findAll();
        categoryList = categoryList.stream().filter(x-> x.getcategory_title()!="").collect(Collectors.toList());

        return categoryList;
    }

    @Override
    @Transactional
    public Quiz saveQuiz(Quiz quiz) {

      return  quizRepository.save(quiz);
        //return (List<Quiz>)quizRepository.findAll();
    }

    @Override
    public void saveQuizUser(QuizUser quizUser) {
        quizUserRepository.save(quizUser);
    }

    @Override
    public List<Quiz> findAllQuiz() {
       return  (List<Quiz>)quizRepository.findAll();
    }

    @Override
    public Quiz findQuizById(Long id) {

        return quizRepository.findOne(id);

    }

    @Override
    @Transactional
    public void removeQuizById(int id) {

       Long quizId=  quizRepository.getQuizIdByIndex(id);
        quizRepository.delete(quizId);
    }
    @Override
    @Transactional
    public void removeSurveyById(int id) {

        Long quizId=  quizRepository.getSurveyIdByIndex(id);
        quizRepository.delete(quizId);
    }

    @Override
    public Audit getAuditById(Long id) {
       return auditRepository.findOne(id);
    }

    @Override
    public Quiz getQuizCategoryById(Long id) {
        return quizRepository.findOne(id);
    }

    @Override
    public Category findCategoryByTitle(String title) {
        List<Category> categoryList = ( List<Category>)categoryRepository.findAll();
        Category catg = new Category();
        for(Category category:categoryList){
            if(category.getcategory_title().equals(title)){
                catg = category;
            }

        }

       return catg;
    }

    @Override
    public Category findCategoryById(Long id) {
        List<Category> categoryList = ( List<Category>)categoryRepository.findAll();
        Category catg = new Category();
        for(Category category:categoryList){
            if(category.getcategory_id().equals(id)){
                catg = category;
                break;
            }

        }

        return catg;
    }

    @Override
    public List<User> fetchAssigneeList(Long id) {

       String assignee = quizRepository.fetchAssigneeListById(id);
        List<String> assigneeList = Stream.of(assignee.split(",", -1))
                .collect(Collectors.toList());
        LOG.info("User Assignee List "+assigneeList.toString());
       List<User> userList = new ArrayList<User>();
       for(String userId: assigneeList ){
           User user = userRepository.findOne(Long.valueOf(userId));
           userList.add(user);
       }

       return userList;

    }

    @Override
    public User getReviewer(Long quizId) {
      String reviewer = quizRepository.fetchReviewer(quizId);
      return userRepository.findOne(Long.valueOf(reviewer));
    }

    @Override
    public Set<Question> fetchQuestionSet(Long quizId) {

        Quiz quiz = quizRepository.findOne(quizId);

        return quiz.getQuestionList();

    }

    @Override
    public ActivityLog getActivityByUserId(Long userId) {
        ActivityLog activityLog = new ActivityLog();
        activityLog.setAuditing(auditRepository.findByUserId(userId));
        activityLog.setReviewingQuiz(quizRepository.fetchReviewingQuizById(userId));
        activityLog.setInvigilatingQuiz(quizRepository.fetchInvigilatingQuizById(userId));
        return activityLog;
    }



    @Override
    public   List<QBankCategoryMap> getQuestionBankCount() {

        List<Category> categoryIdList = quizRepository.getDistinctCategories();
        QBankCategoryMap qBankCategoryMap =null;
        List<QBankCategoryMap> questionBankCountList = new ArrayList<QBankCategoryMap>();
        for(Category category : categoryIdList){
          qBankCategoryMap =  new QBankCategoryMap();
            qBankCategoryMap.setCategory(category);
            qBankCategoryMap.setQuestionBankcount(quizRepository.getBankPerCategory(category.getcategory_id()));
            questionBankCountList.add(qBankCategoryMap);
        }
return questionBankCountList;

    }

    @Override
    public boolean checkQUizExists(Long id) {
        boolean flag = false;
        if(quizRepository.findOne(id)!=null){
            flag =  true;
        }

       return flag;
    }


    @Override
    public boolean checkSurveyExists(Long quizId,int surveyIndex) {
        boolean flag = false;
      Quiz survey = quizRepository.findOne(quizId);
         if(survey.getSurveyIndex()!=0 && survey.getSurveyIndex()==surveyIndex){
             flag =  true;
         }


        return flag;
    }

    @Override
    @Transactional
    public void updateQuestionForBlob(Long id, String s, String s1) {

        Long questionId = Long.parseLong(s.split("_")[0]);
        quizRepository.updateBlobUrl(id,questionId,s1);

    }

    @Override
    public List<QuizUser> getQuizUserList(Long categoryId) {
        return quizUserRepository.getQuizUserList(categoryId);
    }

    @Override
    public List<QuizUser> findAllQuizResult() {

        return (List<QuizUser>)quizUserRepository.findAll();

    }

    @Override
    public List<Object[]> stateWisePassResult() {
        return quizUserRepository.getStateWisePassCount();
    }

    @Override
    public List<Object[]> stateWiseFailResult() {
        return quizUserRepository.getStateWiseFailCount();
    }

    @Override
    public List<Object[]> cityWisePassResult(String state) {
        return quizUserRepository.getCityWisePassCount(state);
    }

    @Override
    public List<Object[]> cityWiseFailResult(String state) {
        return quizUserRepository.getCityWiseFailCount(state);
    }

    @Override
    public List<Object[]> getStateWisePassCountByCategory(Long categoryId) {
        return quizUserRepository.getStateWisePassCountByCategory(categoryId);
    }

    @Override
    public List<Object[]> getStateWiseFailCountByCategory(Long categoryId) {
        return quizUserRepository.getStateWiseFailCountByCategory(categoryId);
    }

    @Override
    public List<Object[]> getQuizUserByCategory(Long categoryId) {

        return quizUserRepository.getQuizByCategory(categoryId);


    }

    @Override
    public List<QuizUser> getQuizResultByQuizId(int quizId) {
        return quizUserRepository.getResultByQuizId( quizId);
    }

    @Override
    public List<QuizUser> getQuizResultByUserId(int userId) {
        return quizUserRepository.fetchResultByUser(userId);
    }

    @Override
    public List<Object[]> getPassByQuizIdCityWise(int quizId, String state) {
        return quizUserRepository.getPassByQuizIdCityWise(quizId,state);
    }

    @Override
    public List<Object[]> getFailByQuizIdCityWise(int quizId, String state) {
        return quizUserRepository.getFailByQuizIdCityWise(quizId,state);
    }

    @Override
    public List<String> getQuizPerUserRole(List<String> states, List<String> roleids) {
        return quizUserRepository.getQuizPerUserRole(states,roleids);
    }

    @Override
    public   List<Object[]> getUserDetailsById(Long userId) {
        return quizUserRepository.getUserDetailsById(userId);
    }

    @Override
    public QuizUser getMaxAttempt(Long userId, int quizId) {
        return quizUserRepository.getMaxAttempt(userId,quizId);
    }

    @Override
    public List<QuizUser> getAttemptNumber(Long userId, int quizId) {
        return quizUserRepository.getAttemptNumber(userId,quizId);
    }

    @Override
    public SurveyUser getSurveyPartcipate(Long userId, int surveyIndex) {
        return surveyUserRepository.getSurveyParticipate(userId,surveyIndex);
    }

    @Override
    public SurveyUser saveSurveyUser(SurveyUser surveyUser) {
        return surveyUserRepository.save(surveyUser);
    }

    @Override
    public List<SurveyUser> findAllSurveyUser() {

        return (List<SurveyUser>)surveyUserRepository.findAll();
    }

    @Override
    public List<UserQuestionMap> getUserQuestionMap(Long userId, int quizId) {
        return (List<UserQuestionMap>)userQuestionMapRepository.getUserQuestionMap(userId,quizId);
    }

    @Override
    public List<Audit> getActivityLog() {
        return (List<Audit>)auditRepository.findAll();
    }

    @Override
    public void saveAll(List<UserQuestionMap> userQuestionMapList) {
        userQuestionMapRepository.save(userQuestionMapList);
    }

}
