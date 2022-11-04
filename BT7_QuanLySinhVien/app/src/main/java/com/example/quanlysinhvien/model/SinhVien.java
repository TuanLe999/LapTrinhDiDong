package com.example.quanlysinhvien.model;

public class SinhVien {

    private  int MaSV;
    private  String HoTen;
    private  int GioiTinh;
    private  String DienThoai;
    private  String Email;


    public  SinhVien(){
    }

    public SinhVien(int maSV, String hoTen, int gioiTinh, String dienThoai, String email) {
        MaSV = maSV;
        HoTen = hoTen;
        GioiTinh = gioiTinh;
        DienThoai = dienThoai;
        Email = email;
    }

    public SinhVien(String hoTen, int gioiTinh, String dienThoai, String email) {
        HoTen = hoTen;
        GioiTinh = gioiTinh;
        DienThoai = dienThoai;
        Email = email;
    }

    public int getMaSV() {
        return MaSV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public String getEmail() {
        return Email;
    }

    public void setMaSV(int maSV) {
        MaSV = maSV;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public void setGioiTinh(int gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public void setDienThoai(String dienThoai) {
        DienThoai = dienThoai;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
