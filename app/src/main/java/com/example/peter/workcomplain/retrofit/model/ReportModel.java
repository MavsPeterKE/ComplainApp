package com.example.peter.workcomplain.retrofit.model;

public class ReportModel {
    String reportedCount;
    String warnings;
    String summons;
    String complainsCleared;

    public String getReportedCount() {
        return reportedCount;
    }

    public void setReportedCount(String reportedCount) {
        this.reportedCount = reportedCount;
    }

    public String getWarnings() {
        return warnings;
    }

    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }

    public String getSummons() {
        return summons;
    }

    public void setSummons(String summons) {
        this.summons = summons;
    }

    public String getComplainsCleared() {
        return complainsCleared;
    }

    public void setComplainsCleared(String complainsCleared) {
        this.complainsCleared = complainsCleared;
    }
}
