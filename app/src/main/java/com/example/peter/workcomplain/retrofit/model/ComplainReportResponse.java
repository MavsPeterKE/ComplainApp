package com.example.peter.workcomplain.retrofit.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ComplainReportResponse {

    @SerializedName("reported_times")
    @Expose
    private String reportedTimes;
    @SerializedName("summons")
    @Expose
    private String summons;
    @SerializedName("warnings")
    @Expose
    private String warnings;
    @SerializedName("cleared")
    @Expose
    private String cleared;

    public String getReportedTimes() {
        return reportedTimes;
    }

    public void setReportedTimes(String reportedTimes) {
        this.reportedTimes = reportedTimes;
    }

    public String getSummons() {
        return summons;
    }

    public void setSummons(String summons) {
        this.summons = summons;
    }

    public String getWarnings() {
        return warnings;
    }

    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }

    public String getCleared() {
        return cleared;
    }

    public void setCleared(String cleared) {
        this.cleared = cleared;
    }

}
