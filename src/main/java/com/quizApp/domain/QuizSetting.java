package com.quizApp.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
public class QuizSetting implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String checkBoxStyle;

    private String fontFace;

    private String radioStyle;

    private boolean defaultCheck;
    private boolean materialCheck;
    private boolean filledCheck;

    public boolean isDefaultCheck() {
        return defaultCheck;
    }

    public void setDefaultCheck(boolean defaultCheck) {
        this.defaultCheck = defaultCheck;
    }

    public boolean isMaterialCheck() {
        return materialCheck;
    }

    public void setMaterialCheck(boolean materialCheck) {
        this.materialCheck = materialCheck;
    }

    public boolean isFilledCheck() {
        return filledCheck;
    }

    public void setFilledCheck(boolean filledCheck) {
        this.filledCheck = filledCheck;
    }

    public boolean isNormalRadio() {
        return normalRadio;
    }

    public void setNormalRadio(boolean normalRadio) {
        this.normalRadio = normalRadio;
    }

    public boolean isAnimatedRadio() {
        return animatedRadio;
    }

    public void setAnimatedRadio(boolean animatedRadio) {
        this.animatedRadio = animatedRadio;
    }

    public boolean isSquareRadio() {
        return squareRadio;
    }

    public void setSquareRadio(boolean squareRadio) {
        this.squareRadio = squareRadio;
    }

    private boolean normalRadio;
    private boolean animatedRadio;
    private boolean squareRadio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCheckBoxStyle() {
        return checkBoxStyle;
    }

    public void setCheckBoxStyle(String checkBoxStyle) {
        this.checkBoxStyle = checkBoxStyle;
    }

    public String getFontFace() {
        return fontFace;
    }

    public void setFontFace(String fontFace) {
        this.fontFace = fontFace;
    }

    public String getRadioStyle() {
        return radioStyle;
    }

    public void setRadioStyle(String radioStyle) {
        this.radioStyle = radioStyle;
    }

    public String getDropdownStyle() {
        return dropdownStyle;
    }

    public void setDropdownStyle(String dropdownStyle) {
        this.dropdownStyle = dropdownStyle;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public String getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(String totalTime) {
        this.totalTime = totalTime;
    }

    public boolean isReviewQuestionFlag() {
        return reviewQuestionFlag;
    }

    public void setReviewQuestionFlag(boolean reviewQuestionFlag) {
        this.reviewQuestionFlag = reviewQuestionFlag;
    }

/*    public Set<User> getAssignedUsers() {
        return assignedUsers;
    }

    public void setAssignedUsers(Set<User> assignedUsers) {
        this.assignedUsers = assignedUsers;
    }*/

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    private String dropdownStyle;

    private String backgroundColor;

    private String fontColor;

    private String totalTime;

    private boolean reviewQuestionFlag;

   /* @OneToMany(mappedBy = "quizSetting" ,fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)

    private Set<User> assignedUsers;*/

    @OneToOne(cascade = CascadeType.ALL)
    private Audit audit;

}
