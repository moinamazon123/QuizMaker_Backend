package com.quizApp.model;

import com.quizApp.domain.Category;

public class QBankCategoryMap {

    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getQuestionBankcount() {
        return questionBankcount;
    }

    public void setQuestionBankcount(Long questionBankcount) {
        this.questionBankcount = questionBankcount;
    }

    private Long questionBankcount;

}
