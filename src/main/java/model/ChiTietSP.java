/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class ChiTietSP {
    private String MaSPCT;
    private String TenSP;
    private float Gia;
    private int SoLuong;
    private String ChatLieu;
    private String KichThuoc;
    private String MauSac;
    private int TrangThai;

    public ChiTietSP() {
    }

    public ChiTietSP(String MaSPCT, String TenSP, float Gia, int SoLuong, String ChatLieu, String KichThuoc, String MauSac, int TrangThai) {
        this.MaSPCT = MaSPCT;
        this.TenSP = TenSP;
        this.Gia = Gia;
        this.SoLuong = SoLuong;
        this.ChatLieu = ChatLieu;
        this.KichThuoc = KichThuoc;
        this.MauSac = MauSac;
        this.TrangThai = TrangThai;
    }

    public String getMaSPCT() {
        return MaSPCT;
    }

    public void setMaSPCT(String MaSPCT) {
        this.MaSPCT = MaSPCT;
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

    public String getChatLieu() {
        return ChatLieu;
    }

    public void setChatLieu(String ChatLieu) {
        this.ChatLieu = ChatLieu;
    }

    public String getKichThuoc() {
        return KichThuoc;
    }

    public void setKichThuoc(String KichThuoc) {
        this.KichThuoc = KichThuoc;
    }

    public String getMauSac() {
        return MauSac;
    }

    public void setMauSac(String MauSac) {
        this.MauSac = MauSac;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    @Override
    public String toString() {
        return "ChiTietSP{" + "MaSPCT=" + MaSPCT + ", TenSP=" + TenSP + ", Gia=" + Gia + ", SoLuong=" + SoLuong + ", ChatLieu=" + ChatLieu + ", KichThuoc=" + KichThuoc + ", MauSac=" + MauSac + ", TrangThai=" + TrangThai + '}';
    }

     public Object[] toRowTable(){
        return new Object[]{
            MaSPCT,TenSP,Gia ,SoLuong, KichThuoc,ChatLieu,MauSac ,TrangThai == 1 ? "Còn hàng":"Hết hàng"
        };
    }
}
