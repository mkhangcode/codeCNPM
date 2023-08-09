package com.example.harvard.oop;

public class Information {
    private String danToc;
    private String tonGiao;
    private String quocGia;
    private String tinhThanh;
    private String quanHuyen;
    private String diDong;
    private String thanNhan;
    private String diDongThanNhan;
    private String diachiThanNhan;
    private String diachiThuongTru;
    public Information(){}

    public Information(String danToc, String tonGiao, String quocGia, String tinhThanh, String quanHuyen, String diDong, String thanNhan, String diDongThanNhan, String diachiThanNhan, String diachiThuongTru) {
        this.danToc = danToc;
        this.tonGiao = tonGiao;
        this.quocGia = quocGia;
        this.tinhThanh = tinhThanh;
        this.quanHuyen = quanHuyen;
        this.diDong = diDong;
        this.thanNhan = thanNhan;
        this.diDongThanNhan = diDongThanNhan;
        this.diachiThanNhan = diachiThanNhan;
        this.diachiThuongTru = diachiThuongTru;
    }

    public String getDanToc() {
        return danToc;
    }

    public void setDanToc(String danToc) {
        this.danToc = danToc;
    }

    public String getTonGiao() {
        return tonGiao;
    }

    public void setTonGiao(String tonGiao) {
        this.tonGiao = tonGiao;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public String getTinhThanh() {
        return tinhThanh;
    }

    public void setTinhThanh(String tinhThanh) {
        this.tinhThanh = tinhThanh;
    }

    public String getQuanHuyen() {
        return quanHuyen;
    }

    public void setQuanHuyen(String quanHuyen) {
        this.quanHuyen = quanHuyen;
    }

    public String getDiDong() {
        return diDong;
    }

    public void setDiDong(String diDong) {
        this.diDong = diDong;
    }

    public String getThanNhan() {
        return thanNhan;
    }

    public void setThanNhan(String thanNhan) {
        this.thanNhan = thanNhan;
    }

    public String getDiDongThanNhan() {
        return diDongThanNhan;
    }

    public void setDiDongThanNhan(String diDongThanNhan) {
        this.diDongThanNhan = diDongThanNhan;
    }

    public String getDiachiThanNhan() {
        return diachiThanNhan;
    }

    public void setDiachiThanNhan(String diachiThanNhan) {
        this.diachiThanNhan = diachiThanNhan;
    }

    public String getDiachiThuongTru() {
        return diachiThuongTru;
    }

    public void setDiachiThuongTru(String diachiThuongTru) {
        this.diachiThuongTru = diachiThuongTru;
    }
}
