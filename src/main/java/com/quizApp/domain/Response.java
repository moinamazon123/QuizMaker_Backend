package com.quizApp.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Response  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private Long responseSeq;


    public String getBlobUrl() {
        return blobUrl;
    }

    public void setBlobUrl(String blobUrl) {
        this.blobUrl = blobUrl;
    }

    private String blobUrl;

    private String response;

    private boolean surveyTextOption;

    private boolean surveyRatingOption;

    public boolean isSurveyTextOption() {
        return surveyTextOption;
    }

    public void setSurveyTextOption(boolean surveyTextOption) {
        this.surveyTextOption = surveyTextOption;
    }

    public boolean isSurveyRatingOption() {
        return surveyRatingOption;
    }

    public void setSurveyRatingOption(boolean surveyRatingOption) {
        this.surveyRatingOption = surveyRatingOption;
    }

    public String getSurveyText() {
        return surveyText;
    }

    public void setSurveyText(String surveyText) {
        this.surveyText = surveyText;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    private String surveyText;

    private int rating;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    private boolean correctAnswerFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getResponseSeq() {
        return responseSeq;
    }

    public void setResponseSeq(Long responseSeq) {
        this.responseSeq = responseSeq;
    }


    public boolean isCorrectAnswerFlag() {
        return correctAnswerFlag;
    }

    public void setCorrectAnswerFlag(boolean correctAnswerFlag) {
        this.correctAnswerFlag = correctAnswerFlag;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private Question question;



    @OneToOne(cascade = CascadeType.ALL)
    private Audit audit;
}
