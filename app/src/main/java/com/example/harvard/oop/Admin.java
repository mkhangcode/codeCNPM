package com.example.harvard.oop;

public class Admin {
    private String taiKhoan;
    private String password;

    public Admin(String taiKhoan, String password) {
        this.taiKhoan = taiKhoan;
        this.password = password;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
