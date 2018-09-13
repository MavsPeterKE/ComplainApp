package com.example.peter.workcomplain.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ComplainResponseModel {
    @SerializedName("complain_title")
    @Expose
    private String complainTitle;
    @SerializedName("complain_body")
    @Expose
    private String complainBody;
    @SerializedName("department")
    @Expose
    private String department;
    @SerializedName("identity")
    @Expose
    private String identity;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("status")
    @Expose
    private String status;

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

