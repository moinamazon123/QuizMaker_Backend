package com.quizApp.model;

public class QuizDetails {

    private String quizTitle;

    private String quizCategory;

    private int surveyIndex;

    private boolean surveyParticipated;

    public boolean isSurveyParticipated() {
        return surveyParticipated;
    }

    public void setSurveyParticipated(boolean surveyParticipated) {
        this.surveyParticipated = surveyParticipated;
    }

    public int getSurveyIndex() {
        return surveyIndex;
    }

    public void setSurveyIndex(int surveyIndex) {
        this.surveyIndex = surveyIndex;
    }

    public int getQuizIndex() {
        return quizIndex;
    }

    public void setQuizIndex(int quizIndex) {
        this.quizIndex = quizIndex;
    }

    private int quizIndex;

    public int getMax_attempt_left() {
        return max_attempt_left;
    }

    public void setMax_attempt_left(int max_attempt_left) {
        this.max_attempt_left = max_attempt_left;
    }

    private int max_attempt_left;

    private String status;

    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public String getQuizCategory() {
        return quizCategory;
    }

    public void setQuizCategory(String quizCategory) {
        this.quizCategory = quizCategory;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    private String level;

    private String date;



}
