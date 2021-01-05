package com.quizApp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class SatishfyLevel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String surveyResponse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSurveyResponse() {
        return surveyResponse;
    }

    public void setSurveyResponse(String surveyResponse) {
        this.surveyResponse = surveyResponse;
    }

    public int getSatishfyLevel() {
        return satishfyLevel;
    }

    public void setSatishfyLevel(int satishfyLevel) {
        this.satishfyLevel = satishfyLevel;
    }

    private int satishfyLevel;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "questionnaire_id")
    private Questionnaire questionnaire;


    public Questionnaire getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(Questionnaire questionnaire) {
        this.questionnaire = questionnaire;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    @OneToOne(cascade = CascadeType.ALL)
    private Audit audit;

}
