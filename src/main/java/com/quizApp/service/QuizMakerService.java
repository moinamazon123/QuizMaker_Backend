package com.quizApp.service;

import com.quizApp.domain.*;
import com.quizApp.model.ActivityLog;
import com.quizApp.model.QBankCategoryMap;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface QuizMakerService {

    List<Activity> save(Activity activity);
    void removeActivityById(Long id);
    List<Activity> findAll();

    List<Category> saveCategory(Category activity);
    void removeCategoryById(Long id) throws ConstraintViolationException;
    List<Category> findAllCategory();

    Quiz saveQuiz(Quiz quiz);

    void saveQuizUser(QuizUser quizUser);

    List<Quiz> findAllQuiz();

    Quiz findQuizById(Long id);

    void removeQuizById(int id);

    void removeSurveyById(int id);

    public Audit getAuditById(Long id);

    public Quiz getQuizCategoryById(Long id);

    public Category findCategoryByTitle(String title);

    public Category findCategoryById(Long id);

    public List<User> fetchAssigneeList(Long id);

    User getReviewer(Long quizId);

    Set<Question> fetchQuestionSet(Long quizId);

    public ActivityLog getActivityByUserId(Long userId);



    List<QBankCategoryMap> getQuestionBankCount();

    boolean checkQUizExists(Long id);

    boolean checkSurveyExists(Long quizId,int surveyIndex);

    void updateQuestionForBlob(Long id, String s, String s1);

    List<QuizUser>  getQuizUserList(Long categoryId);

    List<QuizUser> findAllQuizResult();

    List<Object[]> stateWisePassResult();

    List<Object[]> stateWiseFailResult();

    List<Object[]> cityWisePassResult(String state);

    List<Object[]> cityWiseFailResult(String state);

    List<Object[]> getStateWisePassCountByCategory(Long categoryId);

    List<Object[]> getStateWiseFailCountByCategory(Long categoryId);

     List<Object[]> getQuizUserByCategory(Long categoryId);

     List<QuizUser> getQuizResultByQuizId(int quizId);

    List<QuizUser> getQuizResultByUserId(int userId);

    List<Object[]> getPassByQuizIdCityWise(int quizId, String state);

    List<Object[]> getFailByQuizIdCityWise(int quizId, String state);

    List<String> getQuizPerUserRole(List<String> states, List<String>  roleids);


    List<Object[]> getUserDetailsById( Long userId);

    QuizUser getMaxAttempt(Long userId, int quizId);

    List<QuizUser> getAttemptNumber(Long userId, int quizId);

    SurveyUser getSurveyPartcipate(Long userId, int surey);

    SurveyUser saveSurveyUser(SurveyUser surveyUser);

    List<SurveyUser> findAllSurveyUser();

    List<UserQuestionMap> getUserQuestionMap(Long userId, int quizId);

    List<Audit>  getActivityLog();

    void saveAll(List<UserQuestionMap> userQuestionMapList );
}