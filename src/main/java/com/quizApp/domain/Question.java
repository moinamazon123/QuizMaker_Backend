package com.quizApp.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity

public class Question implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String question_type;

    private String question;

    private int question_mark;

    public String getBlobUrl() {
        return blobUrl;
    }

    public void setBlobUrl(String blobUrl) {
        this.blobUrl = blobUrl;
    }

    private String blobUrl;

    public Long getQuestionSeq() {
        return questionSeq;
    }

    public void setQuestionSeq(Long questionSeq) {
        this.questionSeq = questionSeq;
    }

    private Long questionSeq;

    @JsonIgnore
    private ResponseType response_type;

    @OneToOne(cascade = CascadeType.ALL)
    public ResponseType getResponse_type() {
        return response_type;
    }

    public void setResponse_type(ResponseType response_type) {
        this.response_type = response_type;
    }

    @OneToOne(cascade = CascadeType.ALL)
    private FeedBack feedBack;

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

    public String getQuestion_title() {
        return question;
    }

    public void setQuestion_title(String question_title) {
        this.question = question_title;
    }

    public int getQuestion_mark() {
        return question_mark;
    }

    public void setQuestion_mark(int question_mark) {
        this.question_mark = question_mark;
    }

    public FeedBack getFeedBack() {
        return feedBack;
    }

    public void setFeedBack(FeedBack feedBack) {
        this.feedBack = feedBack;
    }

    public Set<Response> getResponseList() {
        return responseList;
    }

    public void setResponseList(Set<Response> responseList) {
        this.responseList = responseList;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }


    @OneToMany(mappedBy = "question" ,fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JsonManagedReference
    private Set<Response> responseList;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "quiz_id")

    private Quiz quiz;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public QuizUser getQuizUser() {
        return quizUser;
    }

    public void setQuizUser(QuizUser quizUser) {
        this.quizUser = quizUser;
    }

   @JsonBackReference("a")
    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.DETACH)
    @JoinColumn(name = "quiz_user_id")

    private QuizUser quizUser;

    @OneToOne(cascade = CascadeType.ALL)
    private Audit audit;

}
