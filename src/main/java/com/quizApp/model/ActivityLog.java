package com.quizApp.model;

import com.quizApp.domain.Audit;
import com.quizApp.domain.Quiz;

import java.util.List;

public class ActivityLog {

    private List<Quiz> reviewingQuiz;

    private List<Quiz> invigilatingQuiz;

    private List<Audit> auditing;

    public List<Quiz> getReviewingQuiz() {
        return reviewingQuiz;
    }

    public void setReviewingQuiz(List<Quiz> reviewingQuiz) {
        this.reviewingQuiz = reviewingQuiz;
    }

    public List<Quiz> getInvigilatingQuiz() {
        return invigilatingQuiz;
    }

    public void setInvigilatingQuiz(List<Quiz> invigilatingQuiz) {
        this.invigilatingQuiz = invigilatingQuiz;
    }

    public List<Audit> getAuditing() {
        return auditing;
    }

    public void setAuditing(List<Audit> auditing) {
        this.auditing = auditing;
    }
}
