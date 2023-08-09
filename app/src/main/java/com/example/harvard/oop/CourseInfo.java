package com.example.harvard.oop;

public class CourseInfo {
    private String khoaHoc;
    private String loaihinhDaoTao;
    private String lop;
    private String chuyenNganh;
    private String namHocHienTai;
    private String hocKiHienTai;
    public CourseInfo(){}

    public CourseInfo(String khoaHoc, String loaihinhDaoTao, String lop, String chuyenNganh) {
        this.khoaHoc = khoaHoc;
        this.loaihinhDaoTao = loaihinhDaoTao;
        this.lop = lop;
        this.chuyenNganh = chuyenNganh;
        this.namHocHienTai = "2023 - 2024";
        this.hocKiHienTai = "Học kì 1";
    }

    public String getNamHocHienTai() {
        return namHocHienTai;
    }

    public void setNamHocHienTai(String namHocHienTai) {
        this.namHocHienTai = namHocHienTai;
    }

    public String getHocKiHienTai() {
        return hocKiHienTai;
    }

    public void setHocKiHienTai(String hocKiHienTai) {
        this.hocKiHienTai = hocKiHienTai;
    }

    public String getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(String khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public String getLoaihinhDaoTao() {
        return loaihinhDaoTao;
    }

    public void setLoaihinhDaoTao(String loaihinhDaoTao) {
        this.loaihinhDaoTao = loaihinhDaoTao;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }
}
