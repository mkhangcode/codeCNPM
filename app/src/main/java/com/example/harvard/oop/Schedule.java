package com.example.harvard.oop;

public class Schedule {
    private String subjectID;
    private String subjectName;
    private String classID;
    private String numberOfPriod;
    private String lesson;
    private String lectuer;
    private String startDay;
    private String endDay;
    private String room;
    private String time;
    public Schedule(){}

    public Schedule(String subjectID, String subjectName, String classID, String numberOfPriod, String lesson, String lectuer, String startDay, String endDay, String room, String time) {
        this.subjectID = subjectID;
        this.subjectName = subjectName;
        this.classID = classID;
        this.numberOfPriod = numberOfPriod;
        this.lesson = lesson;
        this.lectuer = lectuer;
        this.startDay = startDay;
        this.endDay = endDay;
        this.room = room;
        this.time = time;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
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

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }

    public String getNumberOfPriod() {
        return numberOfPriod;
    }

    public void setNumberOfPriod(String numberOfPriod) {
        this.numberOfPriod = numberOfPriod;
    }

    public String getLectuer() {
        return lectuer;
    }

    public void setLectuer(String lectuer) {
        this.lectuer = lectuer;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
