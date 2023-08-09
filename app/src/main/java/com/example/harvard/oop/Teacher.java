package com.example.harvard.oop;

import java.util.Calendar;
import java.util.Random;

public class Teacher {
    private String teacherID;
    private String firstName;
    private String lastName;
    private String birthDay;
    private String sex;
    private String identificationCode;
    private String schoolEmail;
    private String personalEmail;
    private String address;
    private String password;
    private TeachingInfor teachingInformation;

    public Teacher(){}

    public Teacher(String firstName, String lastName, String birthDay, String sex, String identificationCode, String schoolEmail, String personalEmail, String address, String password, TeachingInfor teachingInformation) {
        this.teacherID = Random();
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.sex = sex;
        this.identificationCode = identificationCode;
        this.schoolEmail = this.teacherID + "@st.harvard.edu.vn";
        this.personalEmail = personalEmail;
        this.address = address;
        this.password = password;
        this.teachingInformation = teachingInformation;
    }
    public String Random() {
        Random rand = new Random();
        int num = rand.nextInt(999999);
        String code = String.format("%06d", num);
        if (code.equals("000000")) {
            code = "000001";
        }


        String result = "GV" + code;
        return result;
    }
    public TeachingInfor getTeachingInformation() {
        return teachingInformation;
    }

    public void setTeachingInformation(TeachingInfor teachingInformation) {
        this.teachingInformation = teachingInformation;
    }

    public String getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(String teacherID) {
        this.teacherID = teacherID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdentificationCode() {
        return identificationCode;
    }

    public void setIdentificationCode(String identificationCode) {
        this.identificationCode = identificationCode;
    }

    public String getSchoolEmail() {
        return schoolEmail;
    }

    public void setSchoolEmail(String schoolEmail) {
        this.schoolEmail = schoolEmail;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
