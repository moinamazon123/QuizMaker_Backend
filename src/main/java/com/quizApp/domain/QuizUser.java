package com.quizApp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
public class QuizUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int userId;

    private int quiz_id;

    private int survey_id;

    public int getSurvey_id() {
        return survey_id;
    }

    public void setSurvey_id(int survey_id) {
        this.survey_id = survey_id;
    }

    public boolean isSurveyParticipated() {
        return surveyParticipated;
    }

    public void setSurveyParticipated(boolean surveyParticipated) {
        this.surveyParticipated = surveyParticipated;
    }

    private boolean surveyParticipated;

    private int max_attempt_left;

    public Long getQuiz_category_id() {
        return quiz_category_id;
    }

    public void setQuiz_category_id(Long quiz_category_id) {
        this.quiz_category_id = quiz_category_id;
    }

    private Long quiz_category_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(int quiz_id) {
        this.quiz_id = quiz_id;
    }

    public int getMax_attempt_left() {
        return max_attempt_left;
    }

    public void setMax_attempt_left(int max_attempt_left) {
        this.max_attempt_left = max_attempt_left;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getPercentage() {
        return percentage;
    }

    public void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    public String getCompletion_time() {
        return completion_time;
    }

    public void setCompletion_time(String completion_time) {
        this.completion_time = completion_time;
    }

    public int getQuizDesign() {
        return quizDesign;
    }

    public void setQuizDesign(int quizDesign) {
        this.quizDesign = quizDesign;
    }

    public int getQuestionDifficulty() {
        return questionDifficulty;
    }

    public void setQuestionDifficulty(int questionDifficulty) {
        this.questionDifficulty = questionDifficulty;
    }

    public int getTimeConstraint() {
        return timeConstraint;
    }

    public void setTimeConstraint(int timeConstraint) {
        this.timeConstraint = timeConstraint;
    }

    private int score;

    private String grade;

    private String result;

    private  int percentage;

    private int max_attempt;

    private String completion_time;

    public int getMax_attempt() {
        return max_attempt;
    }

    public void setMax_attempt(int max_attempt) {
        this.max_attempt = max_attempt;
    }
    @OneToMany(mappedBy = "quizUser" ,fetch = FetchType.EAGER,cascade=CascadeType.DETACH)
    @JsonManagedReference("a")
    private List<Question> questionList;

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public String getCompletion_date() {
        return completion_date;
    }

    public void setCompletion_date(String completion_date) {
        this.completion_date = completion_date;
    }

    private String completion_date;

    private int quizDesign;

    private int questionDifficulty;

    private int timeConstraint;

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    @OneToOne(cascade = CascadeType.ALL)
    private Audit audit;

}
