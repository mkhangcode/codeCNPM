package com.example.harvard.oop;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.harvard.common.Common;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Student {
    private String studentID;
    private String firstName;
    private String lastName;
    private String sex;
    private String identificationCode;
    private String academicStatus;
    private String schoolEmail;
    private String personalEmail;
    private String address;
    private String password;
    private Information Information;
    private CourseInfo CourseInFo;

    public Student() {

    }

    public Student(String firstName, String lastName, String sex, String identificationCode, String personalEmail, String address, com.example.harvard.oop.Information Information, com.example.harvard.oop.CourseInfo CourseInFo) {
        this.studentID = Random();
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.identificationCode = identificationCode;
        this.academicStatus = "Sinh viên năm nhất";
        this.schoolEmail = studentID + "@st.harvard.edu.vn";
        this.personalEmail = personalEmail;
        this.address = address;
        this.password = this.studentID;
        this.Information = Information;
        this.CourseInFo = CourseInFo;
    }

    public Student(String studentID, String firstName, String lastName, String sex, String identificationCode, String academicStatus, String personalEmail, String address, String password, com.example.harvard.oop.Information information, CourseInfo courseInFo) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.identificationCode = identificationCode;
        this.academicStatus = academicStatus;
        this.schoolEmail = studentID + "@st.harvard.edu.vn";
        this.personalEmail = personalEmail;
        this.address = address;
        this.password = password;
        this.Information = information;
        this.CourseInFo = courseInFo;
    }

    public String Random() {
        // lấy 2 chữ đầu: 2021 -> 21
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR); // 2021 % 100 = 21
        int lastTwoDigits = year % 100;
        String maDauMSSV = String.valueOf(lastTwoDigits);
        Random rand = new Random();
        int num = rand.nextInt(999999);
        String code = String.format("%06d", num);
        if (code.equals("000000")) {
            code = "000001";
        }


        String result = maDauMSSV + "DH" + code;
        return result;
    }
    public CourseInfo getCourseInfo() {
        return CourseInFo;
    }

    public void setCourseInfo(CourseInfo CourseInFo) {
        this.CourseInFo = CourseInFo;
    }

    public Information getInformation() {
        return Information;
    }

    public void setInformation(Information Information) {
        this.Information = Information;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
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

    public String getAcademicStatus() {
        return academicStatus;
    }

    public void setAcademicStatus(String academicStatus) {
        this.academicStatus = academicStatus;
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
