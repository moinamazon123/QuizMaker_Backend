package com.quizApp.domain;

import javax.persistence.*;

@Entity
public class FeedBack {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long feedback_id;

    private String feedback;

    @OneToOne(cascade = CascadeType.ALL)
    private Audit audit;

    public Long getFeedback_id() {
        return feedback_id;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    public void setFeedback_id(Long feedback_id) {
        this.feedback_id = feedback_id;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}