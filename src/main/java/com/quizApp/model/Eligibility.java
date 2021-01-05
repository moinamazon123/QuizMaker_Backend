package com.quizApp.model;

import java.util.List;

public class Eligibility {

    private List<QuizDetails> activeQuizDetailsList;

    private List<QuizDetails> upcomingQuizDetailsList;

    private List<QuizDetails> expiredQuizDetailsList;

    private List<QuizDetails> upcomingSurveyList;

    public List<QuizDetails> getUpcomingSurveyList() {
        return upcomingSurveyList;
    }

    public void setUpcomingSurveyList(List<QuizDetails> upcomingSurveyList) {
        this.upcomingSurveyList = upcomingSurveyList;
    }

    public List<QuizDetails> getActiveSurveyList() {
        return activeSurveyList;
    }

    public void setActiveSurveyList(List<QuizDetails> activeSurveyList) {
        this.activeSurveyList = activeSurveyList;
    }

    private List<QuizDetails> activeSurveyList;

    public List<QuizDetails> getActiveQuizDetailsList() {
        return activeQuizDetailsList;
    }

    public void setActiveQuizDetailsList(List<QuizDetails> activeQuizDetailsList) {
        this.activeQuizDetailsList = activeQuizDetailsList;
    }

    public List<QuizDetails> getUpcomingQuizDetailsList() {
        return upcomingQuizDetailsList;
    }

    public void setUpcomingQuizDetailsList(List<QuizDetails> upcomingQuizDetailsList) {
        this.upcomingQuizDetailsList = upcomingQuizDetailsList;
    }

    public List<QuizDetails> getExpiredQuizDetailsList() {
        return expiredQuizDetailsList;
    }

    public void setExpiredQuizDetailsList(List<QuizDetails> expiredQuizDetailsList) {
        this.expiredQuizDetailsList = expiredQuizDetailsList;
    }
}
