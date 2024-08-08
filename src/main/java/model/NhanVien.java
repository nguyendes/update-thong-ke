/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Vector;

/**
 *
 * @author maytinh
 */
public class NhanVien {
    private String MaNV;
    private String hoTen;
    private int ChucVu;
    private String Email;
    private String SDT;
    private int GioiTinh;
    private int TrangThai;
    private String DiaChi;

    public NhanVien() {
    }

    public NhanVien(String MaNV, String hoTen, int ChucVu, String Email, String SDT, int GioiTinh, int TrangThai, String DiaChi) {
        this.MaNV = MaNV;
        this.hoTen = hoTen;
        this.ChucVu = ChucVu;
        this.Email = Email;
        this.SDT = SDT;
        this.GioiTinh = GioiTinh;
        this.TrangThai = TrangThai;
        this.DiaChi = DiaChi;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getChucVu() {
        return ChucVu;
    }

    public void setChucVu(int ChucVu) {
        this.ChucVu = ChucVu;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    
  
    
  
    @Override
    public String toString() {
        return "NhanVien{" + "MaNV=" + MaNV + ", hoTen=" + hoTen + ", ChucVu=" + ChucVu + ", Email=" + Email + ", SDT=" + SDT  + ", GioiTinh=" +GioiTinh + ", TrangThai=" +TrangThai + ", DiaChi=" +DiaChi +'}';
    }
    
//    public Object[] toDataRow(){
//        return new Object[]{this.getMaNV(),this.getHoTen(),this.getChucVu(),this.getEmail(),this.getSDT(),this.getGioiTinh(), this.getTrangThai(),this.getDiaChi()};
//    }
    
    public Object[] toRowTable(){
        return new Object[]{
            MaNV,hoTen,ChucVu == 1 ? "Quản Lý":"Nhân Viên",Email,SDT, GioiTinh == 1 ? "Nam":"Nữ" ,TrangThai == 1 ? "Đang làm việc":"Nghỉ việc", DiaChi
        };
    }
    
}
