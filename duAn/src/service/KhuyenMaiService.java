/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Interface.*;
import Interface.iChiTietKhuyenMai;
import exception.dbexception;
import exception.KhuyenMaiException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ChiTietKM;


public class KhuyenMaiService implements iChiTietKhuyenMai {

    private final DBConnect1 dcm;
    private static final Logger logger = Logger.getLogger(KhuyenMaiService.class.getName());

    public KhuyenMaiService() {
        this.dcm = new DBConnect1();
    }

    @Override
    public List<ChiTietKM> getAllCTKM() {
        List<ChiTietKM> ctkmList = new ArrayList<>();
        String sql = "SELECT c.MaKM, k.TenKM, c.MaSP, c.NgayBatDau, c.NgayKetThuc, c.TiLeGiam, c.GiamToiDa " +
                     "FROM ChiTietKM c INNER JOIN KhuyenMai k ON c.MaKM = k.MaKM";

        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            while (rs.next()) {
                ChiTietKM ctkm = new ChiTietKM();
                ctkm.setMaKM(rs.getString("MaKM"));
                ctkm.setTenKM(rs.getString("TenKM"));
                ctkm.setMaSP(rs.getString("MaSP"));
                ctkm.setNgayBatDau(rs.getDate("NgayBatDau"));
                ctkm.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                ctkm.setTiLeGiam(rs.getInt("TiLeGiam"));
                ctkm.setGiamToiDa(rs.getDouble("GiamToiDa"));
                ctkmList.add(ctkm);
            }
            logger.log(Level.INFO, "Load chi tiết khuyến mãi thành công");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Load chi tiết khuyến mãi thất bại", e);
            throw new dbexception("Lỗi khi lấy danh sách chi tiết khuyến mãi", e);
        }
        return ctkmList;
    }

    @Override
    public int them(ChiTietKM ctkm) {
        String sql = "INSERT INTO ChiTietKM (MaKM, MaSP, NgayBatDau, NgayKetThuc, TiLeGiam, GiamToiDa) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql)) {

            pre.setString(1, ctkm.getMaKM());
            pre.setString(2, ctkm.getMaSP());
            pre.setDate(3, new java.sql.Date(ctkm.getNgayBatDau().getTime()));
            pre.setDate(4, new java.sql.Date(ctkm.getNgayKetThuc().getTime()));
            pre.setInt(5, ctkm.getTiLeGiam());
            pre.setDouble(6, ctkm.getGiamToiDa());

            int rowsAffected = pre.executeUpdate();
            logger.log(Level.INFO, "Thêm chi tiết khuyến mãi mới: {0}", ctkm.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi thêm chi tiết khuyến mãi", e);
            throw new KhuyenMaiException("Lỗi khi thêm chi tiết khuyến mãi", e);
        }
    }

    @Override
    public int capnhat(ChiTietKM ctkm) {
        String sql = "UPDATE ChiTietKM SET NgayBatDau = ?, NgayKetThuc = ?, TiLeGiam = ?, GiamToiDa = ? WHERE MaKM = ? AND MaSP = ?";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql)) {

            pre.setDate(1, new java.sql.Date(ctkm.getNgayBatDau().getTime()));
            pre.setDate(2, new java.sql.Date(ctkm.getNgayKetThuc().getTime()));
            pre.setInt(3, ctkm.getTiLeGiam());
            pre.setDouble(4, ctkm.getGiamToiDa());
            pre.setString(5, ctkm.getMaKM());
            pre.setString(6, ctkm.getMaSP());

            int rowsAffected = pre.executeUpdate();
            logger.log(Level.INFO, "Cập nhật chi tiết khuyến mãi: {0}", ctkm.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi cập nhật chi tiết khuyến mãi", e);
            throw new KhuyenMaiException("Lỗi khi cập nhật chi tiết khuyến mãi", e);
        }
    }

    @Override
    public int xoa(ChiTietKM ctkm) {
        String sql = "DELETE FROM ChiTietKM WHERE MaKM = ? AND MaSP = ?";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql)) {

            pre.setString(1, ctkm.getMaKM());
            pre.setString(2, ctkm.getMaSP());

            int rowsAffected = pre.executeUpdate();
            logger.log(Level.INFO, "Xóa chi tiết khuyến mãi: {0}", ctkm.toString());
            return rowsAffected;
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Lỗi khi xóa chi tiết khuyến mãi", e);
            throw new KhuyenMaiException("Lỗi khi xóa chi tiết khuyến mãi", e);
        }
    }
}
