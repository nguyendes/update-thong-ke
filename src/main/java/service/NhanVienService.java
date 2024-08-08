/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Interface.iNhanVien;
import exceptions.NhanVienException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.NhanVien;

/**
 *
 * @author maytinh
 */
public class NhanVienService implements iNhanVien{

    private final DatabaseConnectionManager dcm;
    private static final Logger logger = Logger.getLogger(NhanVienService.class.getName());

    public NhanVienService() {
        try {
            this.dcm = new DatabaseConnectionManager();
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize DatabaseConnectionManager", e);
        }
    }

    @Override
    public List<NhanVien> getAllNV() {
        List<NhanVien> nvs = new ArrayList<>();
        String sql = "SELECT MaNV, HoTen, ChucVu, Email, SDT, GioiTinh, TrangThai, DiaCHi FROM NhanVien";
        try (Connection conn = dcm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNV"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setChucVu(rs.getInt("ChucVu"));
                nv.setEmail(rs.getString("Email"));
                nv.setSDT(rs.getString("SDT"));
                nv.setGioiTinh(rs.getInt("GioiTinh"));
                nv.setTrangThai(rs.getInt("TrangThai"));
                nv.setDiaChi(rs.getString("DiaChi"));
                
                
                
                nvs.add(nv);
            }
            logger.log(Level.INFO, "Loaded employee data successfully");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Load nhân viên thất bại", e);
            throw NhanVienException.databaseError("Lỗi khi lấy danh sách nhân viên", e);
        }
        return nvs;
    }

    @Override
    public int them(NhanVien nv) {
        String sql = "INSERT INTO NhanVien (MaNV, HoTen, ChucVu, Email, SDT, GioiTinh, TrangThai, DiaChi) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = dcm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nv.getMaNV());
            ps.setString(2, nv.getHoTen());
            ps.setInt(3, nv.getChucVu());
            ps.setString(4, nv.getEmail());
            ps.setString(5, nv.getSDT());
            ps.setInt(6, nv.getGioiTinh());
            ps.setInt(7, nv.getTrangThai());
            ps.setString(8, nv.getDiaChi());
           

            int rowsAffected = ps.executeUpdate();
            logger.log(Level.INFO, "Added new employee: {0}", nv.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi thêm nhân viên", e);
            throw NhanVienException.databaseError("Lỗi khi thêm nhân viên", e);
        }
    }

    @Override
    public int capnhat(NhanVien nv) {
        String sql = "UPDATE NhanVien SET HoTen = ?, ChucVu = ?, Email = ?, SDT = ?, GioiTinh = ?, TrangThai = ?, DiaChi = ? WHERE MaNV = ?";
        try (Connection conn = dcm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nv.getHoTen());
            ps.setInt(2, nv.getChucVu());
            ps.setString(3, nv.getEmail());
            ps.setString(4, nv.getSDT());
            ps.setInt(5, nv.getGioiTinh());
            ps.setInt(6, nv.getTrangThai());
            ps.setString(7, nv.getDiaChi());
            ps.setString(8, nv.getMaNV());

            int rowsAffected = ps.executeUpdate();
            logger.log(Level.INFO, "Updated employee: {0}", nv.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi cập nhật nhân viên", e);
            throw NhanVienException.databaseError("Lỗi khi cập nhật nhân viên", e);
        }
    }

    @Override
    public int xoa(NhanVien nv) {
        String sql = "DELETE FROM NhanVien WHERE MaNV = ?";
        try (Connection conn = dcm.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nv.getMaNV());

            int rowsAffected = ps.executeUpdate();
            logger.log(Level.INFO, "Deleted employee: {0}", nv.toString());
            return rowsAffected;
        }  catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi xóa nhân viên", e);
            throw NhanVienException.databaseError("Lỗi khi xóa nhân viên", e);
        }
    }
}
