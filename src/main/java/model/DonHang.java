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


public class DonHang {
    private String MaDH;
    private String MaNV;
    private String MaKH;
    private Date NgayMua;
    private String TrangThai;
    private double TongTien;
    private String PhuongThucTT;

    public DonHang() {
    }

    public String getMaDH() {
        return MaDH;
    }

    public void setMaDH(String MaDH) {
        this.MaDH = MaDH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public Date getNgayMua() {
        return NgayMua;
    }

    public void setNgayMua(Date NgayMua) {
        this.NgayMua = NgayMua;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public String getPhuongThucTT() {
        return PhuongThucTT;
    }

    public void setPhuongThucTT(String PhuongThucTT) {
        this.PhuongThucTT = PhuongThucTT;
    }

    public DonHang(String MaDH, String MaNV, String MaKH, Date NgayMua, String TrangThai, double TongTien, String PhuongThucTT) {
        this.MaDH = MaDH;
        this.MaNV = MaNV;
        this.MaKH = MaKH;
        this.NgayMua = NgayMua;
        this.TrangThai = TrangThai;
        this.TongTien = TongTien;
        this.PhuongThucTT = PhuongThucTT;
    }

    @Override
    public String toString() {
        return "DonHang{" + "MaDH=" + MaDH + ", MaNV=" + MaNV + ", MaKH=" + MaKH + ", NgayMua=" + NgayMua + ", TrangThai=" + TrangThai + ", TongTien=" + TongTien + ", PhuongThucTT=" + PhuongThucTT + '}';
    }

    public Object[] toDataRow(){
        return new Object[]{this.getMaDH(), this.getMaNV(), this.getMaKH(), this.getNgayMua(), this.getTrangThai(), this.getTongTien(), this.getPhuongThucTT()};
    }
}
