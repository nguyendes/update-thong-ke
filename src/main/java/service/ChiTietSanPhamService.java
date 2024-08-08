/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Interface.iChiTietSP;
import exceptions.chitietsanphamexceptions;
import exceptions.dbexception;
import exceptions.sanphamexception;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ChiTietSP;


/**
 *
 * @author Admin
 */
public class ChiTietSanPhamService implements iChiTietSP {

     private final DatabaseConnectionManager dcm;
    private static final Logger logger = Logger.getLogger(KhuyenMaiService.class.getName());

    public ChiTietSanPhamService() {
        try {
            this.dcm = new DatabaseConnectionManager();
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize DatabaseConnectionManager", e);
        }
    }
    
    
    
    public List<ChiTietSP> getAllCTSP() {
        List<ChiTietSP> ctsp = new ArrayList<>();
        String sql = "SELECT * FROM ChiTietSanPham";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            while (rs.next()) {
                ChiTietSP ct = new ChiTietSP();
                ct.setMaSPCT(rs.getString("MaSPCT"));
                ct.setTenSP(rs.getString("TenSP"));
                ct.setGia((float) rs.getDouble("Gia"));
                ct.setSoLuong(rs.getInt("SoLuong"));
                ct.setChatLieu(rs.getString("ChatLieu"));
                ct.setKichThuoc(rs.getString("KichThuoc"));
                ct.setMauSac(rs.getString("MauSac"));
                ct.setTrangThai(rs.getInt("TrangThai"));
                
                ctsp.add(ct);
            }
            logger.log(Level.INFO, "Load sản phẩm thành công");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Load sản phẩm thất bại", e);
            throw new dbexception("Lỗi khi lấy danh sách sản phẩm", e);
        }
        return ctsp;
    }
    
    public int them(ChiTietSP ctsp) {
        String sql = "INSERT INTO ChiTietSanPham (MaSPCT, TenSP, Gia, SoLuong, ChatLieu, KichThuoc, MauSac, TrangThai ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql)) {

            pre.setString(1, ctsp.getMaSPCT());
            pre.setString(2, ctsp.getTenSP());
            pre.setDouble(3, ctsp.getGia());
            pre.setInt(4, ctsp.getSoLuong());
            pre.setString(5, ctsp.getChatLieu());
            pre.setString(6, ctsp.getKichThuoc());
            pre.setString(8, ctsp.getMauSac());
            pre.setInt(7, ctsp.getTrangThai());
           

            int rowsAffected = pre.executeUpdate();
            logger.log(Level.INFO, "Thêm sản phẩm mới: {0}", ctsp.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi thêm sản phẩm", e);
            throw new chitietsanphamexceptions("Lỗi khi thêm sản phẩm", e);
        }
    }

    public int capnhat(ChiTietSP ctsp) {
        String sql = "UPDATE SanPham SET TenSP = ?, Gia = ?, SoLuong = ?, ChatLieu = ?, KichThuoc = ? , MauSac = ?, TrangThai = ? WHERE MaSPCT = ?";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql)) {

            pre.setString(1, ctsp.getTenSP());
            pre.setDouble(2, ctsp.getGia());
            pre.setInt(3, ctsp.getSoLuong());
            pre.setString(4, ctsp.getChatLieu());
            pre.setString(5, ctsp.getKichThuoc());
            pre.setString(6, ctsp.getMauSac());
            pre.setInt(7, ctsp.getTrangThai());
            pre.setString(8, ctsp.getMaSPCT());

            int rowsAffected = pre.executeUpdate();
            logger.log(Level.INFO, "Cập nhật sản phẩm: {0}", ctsp.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi cập nhật sản phẩm", e);
            throw new chitietsanphamexceptions("Lỗi khi cập nhật sản phẩm", e);
        }
    }
    
    public int xoa(ChiTietSP ctsp) {
        String sql = "DELETE FROM ChiTietSanPham WHERE MaSPCT = ?";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql)) {

           pre.setString(1, ctsp.getMaSPCT());

            int rowsAffected = pre.executeUpdate();
            logger.log(Level.INFO, "Xóa sản phẩm: {0}", ctsp.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi xóa sản phẩm", e);
            throw new chitietsanphamexceptions("Lỗi khi xóa sản phẩm", e);
        }
    }

   
    
}
