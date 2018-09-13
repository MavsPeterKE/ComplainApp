package com.example.peter.workcomplain.retrofit.model;

public class ComplainModel {
    String identity;
    String department;
    String complainTitle;
    String complainBody;
    String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getComplainTitle() {
        return complainTitle;
    }

    public void setComplainTitle(String complainTitle) {
        this.complainTitle = complainTitle;
    }

    public String getComplainBody() {
        return complainBody;
    }

    public void setComplainBody(String complainBody) {
        this.complainBody = complainBody;
    }
}
