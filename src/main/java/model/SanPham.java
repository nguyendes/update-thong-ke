/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author maytinh
 */
public class SanPham {
    private String MaSP;
    private String TenSP;
    private float Gia;
    private int SoLuong;
    private int trangThai;
    private String tenLoai;
    private String XuatXu;
    private Date NgayNhap; 

    public SanPham() {
    }

    public SanPham(String MaSP, String TenSP, float Gia, int SoLuong, int trangThai, String tenLoai, String XuatXu, Date NgayNhap) {
        this.MaSP = MaSP;
        this.TenSP = TenSP;
        this.Gia = Gia;
        this.SoLuong = SoLuong;
        this.trangThai = trangThai;
        this.tenLoai = tenLoai;
        this.XuatXu = XuatXu;
        this.NgayNhap = NgayNhap;
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public float getGia() {
        return Gia;
    }

    public void setGia(float Gia) {
        this.Gia = Gia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenLoai() {
        return tenLoai;
    }

    public void setTenLoai(String tenLoai) {
        this.tenLoai = tenLoai;
    }

    public String getXuatXu() {
        return XuatXu;
    }

    public void setXuatXu(String XuatXu) {
        this.XuatXu = XuatXu;
    }

    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date NgayNhap) {
        this.NgayNhap = NgayNhap;
    }

    

   

    @Override
    public String toString() {
        return "SanPham{" + "MaSP=" + MaSP + ", TenSP=" + TenSP + ", Gia=" + Gia + ", SoLuong=" + SoLuong + ", NgayNhap=" + NgayNhap + ", tenLoai=" + tenLoai + ", trangThai=" + trangThai + ", XuatXu=" + XuatXu + '}';
    }
    
//    public Object[] toDataRow(){
//        return new Object[]{this.getMaSP(),this.getTenSP(),this.getGia(),this.getSoLuong(),this.getNgayNhap()};
//    }
    
    
    
    public Object[] toRowTable(){
        return new Object[]{
            MaSP,TenSP,Gia,SoLuong, NgayNhap , tenLoai, trangThai == 1 ? "Còn hàng":"Hết hàng", XuatXu
        };
    }
}
