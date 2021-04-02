/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stupid.DAO;

import Stupid.Connection.Connection;
import Stupid.Modal.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author A
 */
public class CustomerDAO extends Connection {

    public ArrayList<Customer> loadList() {
        ArrayList<Customer> dskh = new ArrayList<Customer>();
        try {
            String sql = "SELECT * FROM khachhang ORDER BY history DESC";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                Customer kh = new Customer();
                kh.setMakh(rs.getString(1));
                kh.setHovaten(rs.getString(2));
                kh.setNgaysinh(rs.getDate(3));
                kh.setGioitinh(rs.getString(4));
                kh.setSodienthoai(rs.getString(5));
                kh.setSocmnd(rs.getString(6));
                kh.setDonphi(rs.getFloat(7));
                kh.setGhichu(rs.getString(8));
                kh.setImage(rs.getString(9));
                kh.setHistory(rs.getString(10));
                dskh.add(kh);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dskh;
    }
    
     public boolean checkMaKH(String makh) {
        try {
            String sql = "SELECT * FROM khachhang WHERE makh = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, makh);
            return pstm.executeQuery().next();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean addCustomer(String makh, String hovaten, String ngaysinh, String gioitinh, String sodienthoai, String socmnd, float donphi, String ghichu, String image, String history) {
        try {
            String sql = "INSERT INTO khachhang VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, makh);
            pstm.setString(2, hovaten);
            pstm.setString(3, ngaysinh);
            pstm.setString(4, gioitinh);
            pstm.setString(5, sodienthoai);
            pstm.setString(6, socmnd);
            pstm.setFloat(7, donphi);
            pstm.setString(8, ghichu);
            pstm.setString(9, image);
            pstm.setString(10, history);
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
     public boolean deleteCustomer(String makh) {
        try {
            String sql = "Delete from khachhang where makh = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, makh);
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean updateCustomer(String hovaten, String ngaysinh, String gioitinh, String sodienthoai, String socmnd, float donphi, String ghichu, String image,  String makh) {
        try {
            String sql = "UPDATE khachhang SET hovaten = ?, ngaysinh = ?, gioitinh = ?, sodienthoai = ?, socmnd = ?,donphi =?, ghichu=?,hinhanh=? WHERE makh = ?";
            PreparedStatement pstm = con.prepareStatement(sql);

            pstm.setString(1, hovaten);
            pstm.setString(3, gioitinh);
            pstm.setString(2, ngaysinh);
            pstm.setString(4, sodienthoai);
            pstm.setString(5, socmnd);
            pstm.setFloat(6,donphi);
            pstm.setString(7, ghichu);
            pstm.setString(8, image);
            pstm.setString(9, makh);
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
     public ArrayList<Customer> searchCustomer(String hovaten) {
        ArrayList<Customer> dskh = new ArrayList<Customer>();
        try {
            String sql = "SELECT * FROM khachhang where hovaten like N'" + hovaten + "%'";// có chữ N ĐẰNG TRƯỚC LÀ TÌM UNICODE
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Customer kh = new Customer();
                kh.setMakh(rs.getString(1));
                kh.setHovaten(rs.getString(2));
                kh.setNgaysinh(rs.getDate(3));
                kh.setGioitinh(rs.getString(4));
                kh.setSodienthoai(rs.getString(5));
                kh.setSocmnd(rs.getString(6));
                kh.setDonphi(rs.getFloat(7));
                kh.setGhichu(rs.getString(8));
                kh.setImage(rs.getString(9));
                kh.setHistory(rs.getString(10));
                dskh.add(kh);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dskh;
    }
     
    public ArrayList<Customer> loadListSN(int ngay, int thang) {
        ArrayList<Customer> dskh = new ArrayList<Customer>();
        try {
            String sql = "SELECT * from khachhang where MONTH(ngaysinh) = ? and DAY(ngaysinh)= ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, thang);
            pstm.setInt(2, ngay);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Customer kh = new Customer();
                kh.setMakh(rs.getString(1));
                kh.setHovaten(rs.getString(2));
                kh.setNgaysinh(rs.getDate(3));
                kh.setGioitinh(rs.getString(4));
                kh.setSodienthoai(rs.getString(5));
                kh.setSocmnd(rs.getString(6));
                kh.setDonphi(rs.getFloat(7));
                kh.setGhichu(rs.getString(8));
                kh.setImage(rs.getString(9));
                kh.setHistory(rs.getString(10));
                dskh.add(kh);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dskh;
    }
}
