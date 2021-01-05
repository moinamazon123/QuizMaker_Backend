package com.quizApp.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class SurveyUser implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int userId;

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

    public boolean isSurveyParticipated() {
        return surveyParticipated;
    }

    public void setSurveyParticipated(boolean surveyParticipated) {
        this.surveyParticipated = surveyParticipated;
    }

    public int getSurvey_id() {
        return survey_id;
    }

    public void setSurvey_id(int survey_id) {
        this.survey_id = survey_id;
    }

    public String getCompletion_time() {
        return completion_time;
    }

    public void setCompletion_time(String completion_time) {
        this.completion_time = completion_time;
    }

    public Set<SurveyQuestion> getSurveyQuestionSet() {
        return surveyQuestionSet;
    }

    public void setSurveyQuestionSet(Set<SurveyQuestion> surveyQuestionSet) {
        this.surveyQuestionSet = surveyQuestionSet;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    private boolean surveyParticipated;

    private int survey_id;

    private String completion_time;

    @OneToMany(mappedBy = "surveyUser" ,fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JsonManagedReference

    private Set<SurveyQuestion> surveyQuestionSet;

    @OneToOne(cascade = CascadeType.ALL)
    private Audit audit;




}
