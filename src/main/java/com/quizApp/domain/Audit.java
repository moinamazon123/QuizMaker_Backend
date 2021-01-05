package com.quizApp.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Audit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long audit_id;

    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /** @ManyToOne
    @JoinColumn(name = "Id")
    private User user;
**/
    private String audit_event;

    public String getAudit_event() {
        return audit_event;
    }

    public void setAudit_event(String audit_event) {
        this.audit_event = audit_event;
    }

    private String  date_created;

    private String  time_created;

    public Long getAudit_id() {
        return audit_id;
    }

    public void setAudit_id(Long audit_id) {
        this.audit_id = audit_id;
    }

   /**  public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
**/
    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getTime_created() {
        return time_created;
    }

    public void setTime_created(String time_created) {
        this.time_created = time_created;
    }

    public String getDate_updated() {
        return date_updated;
    }

    public void setDate_updated(String date_updated) {
        this.date_updated = date_updated;
    }

    public String getTime_updated() {
        return time_updated;
    }

    public void setTime_updated(String time_updated) {
        this.time_updated = time_updated;
    }

    private String  date_updated;
    private String  time_updated;

    private boolean showStatus;

    public boolean isShowStatus() {
        return showStatus;
    }

    public void setShowStatus(boolean showStatus) {
        this.showStatus = showStatus;
    }
}
