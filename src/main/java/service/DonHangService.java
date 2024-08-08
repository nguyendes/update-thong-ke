/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Interface.iThongKe;
import exceptions.dbexception;
import model.ThongKe;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DonHang;

public class DonHangService implements iThongKe {

    private final DatabaseConnectionManager dcm;
    private static final Logger logger = Logger.getLogger(DonHangService.class.getName());

    public DonHangService() {
        try {
            this.dcm = new DatabaseConnectionManager();
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize DatabaseConnectionManager", e);
        }
    }

    @Override
    public ThongKe getThongKe() {
        ThongKe thongKe = new ThongKe();
        String sql = "SELECT " +
                     "    (SELECT COUNT(*) FROM DonHang) AS TotalOrders, " +
                     "    (SELECT SUM(TongTien) FROM DonHang WHERE TrangThai = 'Hoàn thành') AS TotalRevenue";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            if (rs.next()) {
                thongKe.setTotalOrders(rs.getInt("TotalOrders"));
                thongKe.setTotalRevenue(rs.getDouble("TotalRevenue"));
            }
            logger.log(Level.INFO, "Load thống kê thành công");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Load thống kê thất bại", e);
            throw new dbexception("Lỗi khi lấy thống kê", e);
        }
        return thongKe;
    }
    
   @Override
public List<ThongKe> getThongKeTheoThoiGian() {
    List<ThongKe> listtk = new ArrayList<>();
    String sql = "SELECT " +
                 "    YEAR(NgayMua) AS Nam, " +
                 "    MONTH(NgayMua) AS Thang, " +
                 "    COUNT(MaDH) AS SoHoaDon, " +
                 "    SUM(TongTien) AS DoanhThu " +
                 "FROM DonHang " +
                 "GROUP BY YEAR(NgayMua), MONTH(NgayMua) " +
                 "ORDER BY YEAR(NgayMua), MONTH(NgayMua);";
    try (Connection cnt = dcm.getConnection();
         PreparedStatement pre = cnt.prepareStatement(sql);
         ResultSet rs = pre.executeQuery()) {

        while (rs.next()) {
            ThongKe tk = new ThongKe();
            tk.setYear(rs.getInt("Nam")); // Set year
            tk.setMonth(rs.getInt("Thang")); // Set month
            tk.setTotalOrders(rs.getInt("SoHoaDon"));
            tk.setTotalRevenue(rs.getDouble("DoanhThu"));
            listtk.add(tk);
        }
        logger.log(Level.INFO, "Load thống kê thành công theo thời gian");
    } catch (SQLException e) {
        logger.log(Level.SEVERE, "Load thống kê thất bại theo thời gian", e);
        throw new dbexception("Lỗi khi lấy thống kê theo thời gian", e);
    }
    return listtk;
}

   
    @Override
     public List<DonHang> getAllDH() {
        List<DonHang> donHangList = new ArrayList<>();
        String sql = "SELECT * FROM DonHang";
        try (Connection cnt = dcm.getConnection();
             PreparedStatement pre = cnt.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            while (rs.next()) {
                DonHang donHang = new DonHang();
                donHang.setMaDH(rs.getString("MaDH"));
                donHang.setMaNV(rs.getString("MaNV"));
                donHang.setMaKH(rs.getString("MaKH"));
                donHang.setNgayMua(rs.getDate("NgayMua"));
                donHang.setTrangThai(rs.getString("TrangThai"));
                donHang.setTongTien(rs.getDouble("TongTien"));
                donHang.setPhuongThucTT(rs.getString("PhuongThucTT"));

                donHangList.add(donHang);
            }
            logger.log(Level.INFO, "Load tất cả đơn hàng thành công");
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Load tất cả đơn hàng thất bại", e);
            throw new dbexception("Lỗi khi lấy tất cả đơn hàng", e);
        }
        return donHangList;
    }

    
}



    



