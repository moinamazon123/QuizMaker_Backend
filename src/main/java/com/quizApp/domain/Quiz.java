package com.quizApp.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
public class Quiz implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String quiz_title;

    private String introduction_message;

    private String conclusion_message;

    private int max_attempt;

    public int getRandomQuestions() {
        return randomQuestions;
    }

    public void setRandomQuestions(int randomQuestions) {
        this.randomQuestions = randomQuestions;
    }

    private int passMark;

    private int randomQuestions;

    public int getPassMark() {
        return passMark;
    }

    public void setPassMark(int passMark) {
        this.passMark = passMark;
    }

    private String status;

    public int getQuizIndex() {
        return quizIndex;
    }

    public void setQuizIndex(int quizIndex) {
        this.quizIndex = quizIndex;
    }

    private String level;

    private int quizIndex;

    public int getSurveyIndex() {
        return surveyIndex;
    }

    public void setSurveyIndex(int surveyIndex) {
        this.surveyIndex = surveyIndex;
    }

    private int surveyIndex;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    private String comment;

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDate_schedule() {
        return date_schedule;
    }

    public void setDate_schedule(String date_schedule) {
        this.date_schedule = date_schedule;
    }

    public String getTime_schedule() {
        return time_schedule;
    }

    public void setTime_schedule(String time_schedule) {
        this.time_schedule = time_schedule;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    private String  date_schedule;

    private String  time_schedule;

    public String getScheduleDateTime() {
        return scheduleDateTime;
    }

    public void setScheduleDateTime(String scheduleDateTime) {
        this.scheduleDateTime = scheduleDateTime;
    }

    private String  scheduleDateTime;

    private Long creator;

    public Long getCreatorId() {
        return creator;
    }

    public void setCreatorId(Long creatorId) {
        this.creator = creatorId;
    }

    public int getTime() {
        return quiz_time;
    }

    public void setTime(int time) {
        this.quiz_time = time;
    }

    /** Time in Min **/
    private int quiz_time;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**  @OneToOne(mappedBy = "quiz")
    @JsonIgnore
    private User reviewer;
**/
    @OneToOne(cascade = CascadeType.MERGE)

    private Category category;




    private boolean show_answer;


    private boolean show_score;

    public String getAssigneeUserList() {
        return assigneeUserList;
    }

    public void setAssigneeUserList(String assigneeUserList) {
        this.assigneeUserList = assigneeUserList;
    }

    @OneToMany(mappedBy = "quiz" ,fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JsonManagedReference

    private Set<Question> questionList;

    @OneToMany(mappedBy = "quiz" ,fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JsonManagedReference

    private List<QuizUserMap> quizUserMapList;



    //@OneToOne(mappedBy = "quiz",cascade = CascadeType.ALL)

    private Long  reviewer_id;

   //@OneToOne(mappedBy = "quiz",cascade = CascadeType.ALL)

   private Long  invigilator_id;

   // @OneToMany(mappedBy = "quiz" ,fetch = FetchType.EAGER,cascade=CascadeType.ALL)
   // @ManyToMany(targetEntity = User.class, mappedBy = "quizList", cascade = CascadeType.PERSIST)
    //@JsonManagedReference
    private String assigneeUserList;

    public String getAssigneeStateList() {
        return assigneeStateList;
    }

    public void setAssigneeStateList(String assigneeStateList) {
        this.assigneeStateList = assigneeStateList;
    }

    private String assigneeStateList;

    public String getAssigneeRoleList() {
        return assigneeRoleList;
    }

    public void setAssigneeRoleList(String assigneeRoleList) {
        this.assigneeRoleList = assigneeRoleList;
    }

    public String getAssigneeCityList() {
        return assigneeCityList;
    }

    public void setAssigneeCityList(String assigneeCityList) {
        this.assigneeCityList = assigneeCityList;
    }

    private String assigneeRoleList;

    private String assigneeCityList;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @OneToOne(cascade = CascadeType.ALL)
    private Audit audit;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuiz_title() {
        return quiz_title;
    }

    public void setQuiz_title(String quiz_title) {
        this.quiz_title = quiz_title;
    }

    public String getIntroduction_message() {
        return introduction_message;
    }

    public void setIntroduction_message(String introduction_message) {
        this.introduction_message = introduction_message;
    }

    public String getConclusion_message() {
        return conclusion_message;
    }

    public void setConclusion_message(String conclusion_message) {
        this.conclusion_message = conclusion_message;
    }

    public int getMax_attempt() {
        return max_attempt;
    }

    public void setMax_attempt(int max_attempt) {
        this.max_attempt = max_attempt;
    }


  public Long getReviewer() {
        return reviewer_id;
    }

    public void setReviewer(Long reviewer_id) {
        this.reviewer_id = reviewer_id;
    }


    public boolean isShow_answer() {
        return show_answer;
    }

    public void setShow_answer(boolean show_answer) {
        this.show_answer = show_answer;
    }

    public boolean isShow_score() {
        return show_score;
    }

    public void setShow_score(boolean show_score) {
        this.show_score = show_score;
    }

    public Set<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(Set<Question> questionList) {
        this.questionList = questionList;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    public Long getInvigilator() {
        return invigilator_id;
    }

    public void setInvigilator(Long invigilator_id) {
        this.invigilator_id = invigilator_id;
    }

    public QuizSetting getQuizSetting() {
        return setting;
    }

    public void setQuizSetting(QuizSetting setting) {
        this.setting = setting;
    }

    public int getQuiz_time() {
        return quiz_time;
    }

    public void setQuiz_time(int quiz_time) {
        this.quiz_time = quiz_time;
    }

    @OneToOne(cascade = CascadeType.ALL)
    private QuizSetting setting;

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    @OneToOne(cascade = CascadeType.MERGE)
    private Activity activity;

    public Long getReviewer_id() {
        return reviewer_id;
    }

    public void setReviewer_id(Long reviewer_id) {
        this.reviewer_id = reviewer_id;
    }

    public Long getInvigilator_id() {
        return invigilator_id;
    }

    public void setInvigilator_id(Long invigilator_id) {
        this.invigilator_id = invigilator_id;
    }

    public QuizSetting getSetting() {
        return setting;
    }

    public void setSetting(QuizSetting setting) {
        this.setting = setting;
    }

    @OneToOne(cascade = CascadeType.ALL)
    private Grade grade;


}
