package com.example.harvard.oop;

public class Exercise {
    private String subjectName;
    private String classID;
    private String title;
    private String content;
    private String picture;
    public Exercise(){}

    public Exercise(String subjectName, String classID, String title, String content, String picture) {
        this.subjectName = subjectName;
        this.classID = classID;
        this.title = title;
        this.content = content;
        this.picture = picture;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
