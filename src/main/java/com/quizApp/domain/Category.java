package com.quizApp.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long category_id;

    private String category_title;

    public String getcategory_desc() {
        return category_desc;
    }

    public void setcategory_desc(String category_desc) {
        this.category_desc = category_desc;
    }

    private String category_desc;

    public Long getcategory_id() {
        return category_id;
    }

    public void setcategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getcategory_title() {
        return category_title;
    }

    public void setcategory_title(String category_title) {
        this.category_title = category_title;
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
