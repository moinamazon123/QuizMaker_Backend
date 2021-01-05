package com.quizApp.domain;

import javax.persistence.*;

@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String gradeAPlus;
    private String gradeAMinus;
    private String gradeA;

    private String gradeBPlus;
    private String gradeBMinus;
    private String gradeB;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

   /* public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }*/

    private String gradeCPlus;

    @OneToOne(cascade = CascadeType.ALL)
    private Audit audit;

  /*  @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;*/

    public Long getGrade_id() {
        return id;
    }

    public void setGrade_id(Long grade_id) {
        this.id = grade_id;
    }

    public String getGradeAPlus() {
        return gradeAPlus;
    }

    public void setGradeAPlus(String gradeAPlus) {
        this.gradeAPlus = gradeAPlus;
    }

    public String getGradeAMinus() {
        return gradeAMinus;
    }

    public void setGradeAMinus(String gradeAMinus) {
        this.gradeAMinus = gradeAMinus;
    }

    public String getGradeA() {
        return gradeA;
    }

    public void setGradeA(String gradeA) {
        this.gradeA = gradeA;
    }

    public String getGradeBPlus() {
        return gradeBPlus;
    }

    public void setGradeBPlus(String gradeBPlus) {
        this.gradeBPlus = gradeBPlus;
    }

    public String getGradeBMinus() {
        return gradeBMinus;
    }

    public void setGradeBMinus(String gradeBMinus) {
        this.gradeBMinus = gradeBMinus;
    }

    public String getGradeB() {
        return gradeB;
    }

    public void setGradeB(String gradeB) {
        this.gradeB = gradeB;
    }

    public String getGradeCPlus() {
        return gradeCPlus;
    }

    public void setGradeCPlus(String gradeCPlus) {
        this.gradeCPlus = gradeCPlus;
    }

    public String getGradeCMinus() {
        return gradeCMinus;
    }

    public void setGradeCMinus(String gradeCMinus) {
        this.gradeCMinus = gradeCMinus;
    }

    public String getGradeC() {
        return gradeC;
    }

    public void setGradeC(String gradeC) {
        this.gradeC = gradeC;
    }

    public String getGradeDPlus() {
        return gradeDPlus;
    }

    public void setGradeDPlus(String gradeDPlus) {
        this.gradeDPlus = gradeDPlus;
    }

    public String getGradeDMinus() {
        return gradeDMinus;
    }

    public void setGradeDMinus(String gradeDMinus) {
        this.gradeDMinus = gradeDMinus;
    }

    public String getGradeD() {
        return gradeD;
    }

    public void setGradeD(String gradeD) {
        this.gradeD = gradeD;
    }

    private String gradeCMinus;
    private String gradeC;

    private String gradeDPlus;
    private String gradeDMinus;
    private String gradeD;
}
