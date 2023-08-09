package com.example.harvard.oop;

public class Result {
    private String subjectID;
    private String subjectName;
    private String attendance;
    private String midtermPoint;
    private String endtermPoint;
    private String total;
    private String note;
    private String NumberOfPriod;
    public Result(){}
    public Result(String subjectID, String subjectName, String attendance, String midtermPoint, String endtermPoint, String total, String note, String numberOfPriod) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.attendance = attendance;
        this.midtermPoint = midtermPoint;
        this.endtermPoint = endtermPoint;
        this.total = total;
        this.note = note;
        this.NumberOfPriod = numberOfPriod;
    }

    public String getNumberOfPriod() {
        return NumberOfPriod;
    }

    public void setNumberOfPriod(String numberOfPriod) {
        NumberOfPriod = numberOfPriod;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getMidtermPoint() {
        return midtermPoint;
    }

    public void setMidtermPoint(String midtermPoint) {
        this.midtermPoint = midtermPoint;
    }

    public String getEndtermPoint() {
        return endtermPoint;
    }

    public void setEndtermPoint(String endtermPoint) {
        this.endtermPoint = endtermPoint;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
