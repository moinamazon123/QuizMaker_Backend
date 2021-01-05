package com.quizApp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class SurveyQuestion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String question_type;

    private String questionFlag;

    public String getQuestionFlag() {
        return questionFlag;
    }

    public void setQuestionFlag(String questionFlag) {
        this.questionFlag = questionFlag;
    }

    public SurveyUser getSurveyUser() {
        return surveyUser;
    }

    public void setSurveyUser(SurveyUser surveyUser) {
        this.surveyUser = surveyUser;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion_type() {
        return question_type;
    }

    public void setQuestion_type(String question_type) {
        this.question_type = question_type;
    }

    public String getSurvey_question() {
        return survey_question;
    }

    public void setSurvey_question(String survey_question) {
        this.survey_question = survey_question;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }



    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    private String survey_question;

    private String response;

    private int rating ;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "survey_user_id")

    private SurveyUser surveyUser;



    @OneToOne(cascade = CascadeType.ALL)
    private Audit audit;

}
