package com.example.harvard.oop;

public class TeachingInfor {
    private String chuyenNganh;
    private String monDay;
    public TeachingInfor(){}
    public TeachingInfor(String chuyenNganh, String monday) {
        this.chuyenNganh = chuyenNganh;
        this.monDay = monday;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public String getMonday() {
        return monDay;
    }

    public void setMonday(String monday) {
        this.monDay = monday;
    }
}
