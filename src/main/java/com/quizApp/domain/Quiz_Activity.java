package com.quizApp.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Quiz_Activity implements Serializable {

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

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public Quiz_Feedback getQuiz_feedback() {
        return quiz_feedback;
    }

    public void setQuiz_feedback(Quiz_Feedback quiz_feedback) {
        this.quiz_feedback = quiz_feedback;
    }

    private String result;

    private int score;

    private int quizId;

    @OneToOne(cascade = CascadeType.MERGE)

    private Quiz_Feedback quiz_feedback;
}
