package com.example.harvard.oop;

public class Subject {
    private String subjectID;
    private String subjectName;
    private String numberOfPriod;
    private String semester;
    private String academicYear;
    private String status;
    public Subject(){}
    public Subject(String subjectID, String subjectName, String numberOfPriod, String semester, String academicYear, String status) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.numberOfPriod = numberOfPriod;
        this.semester = semester;
        this.academicYear = academicYear;
        this.status = status;
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

    public String getNumberOfPriod() {
        return numberOfPriod;
    }

    public void setNumberOfPriod(String numberOfPriod) {
        this.numberOfPriod = numberOfPriod;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
