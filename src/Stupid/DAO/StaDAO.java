/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stupid.DAO;

import Stupid.Connection.Connection;
import Stupid.Modal.Customer;
import Stupid.Modal.Ticket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author A
 */
public class StaDAO extends Connection {

    public ArrayList<Customer> loadList() {
        {
            ArrayList<Customer> dskh = new ArrayList<Customer>();
            try {
                String sql = "SELECT * from khachhang";
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
    }

    public ArrayList<Ticket> loadListHH(int day, int month, int year) {
        ArrayList<Ticket> dsTick = new ArrayList<Ticket>();
        try {
            String sql = "select khachhang.hovaten, the.mathe, the.makh , the.batdau, the.hethan from khachhang,the where (khachhang.makh = the.makh) and ((DAY(the.hethan) <= ? and MONTH(the.hethan) <= ? and YEAR(the.hethan) <= ?) and the.active = 'false')";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, day);
            pstm.setInt(2, month);
            pstm.setInt(3, year);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                
                Ticket tk = new Ticket();
                tk.setHovaten(rs.getString(1));
                tk.setMathe(rs.getString(2));
                tk.setMakh(rs.getString(3));
                tk.setBatdau(rs.getDate(4));
                tk.setKetthuc(rs.getDate(5));
                dsTick.add(tk);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return dsTick;
    }

    public ArrayList<Customer> loadListSN(String sinhnhat) {
        ArrayList<Customer> dskh = new ArrayList<Customer>();
        try {
            String sql = "SELECT * from khachhang where sinhnhat = ? ";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, sinhnhat);
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

    public ArrayList<Customer> loadListGT(String gioitinh) {
        ArrayList<Customer> dskh = new ArrayList<Customer>();
        try {
            String sql = "SELECT * FROM khachhang where gioitinh = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, gioitinh);
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

    public float tinhTongDanhThu(String makh) {
        float tt = 0;
        try {
            String sql = "SELECT donphi FROM khachhang where makh = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, makh);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                tt = rs.getFloat(1);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tt;
    }
    
    public ArrayList<Customer> thongKeTheoNam(int year) {
        ArrayList<Customer> dskh = new ArrayList<Customer>();
        try {
            String sql = "select * from khachhang where Year(history) like '" + year + "%'";// có chữ N ĐẰNG TRƯỚC LÀ TÌM UNICODE
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
    public ArrayList<Customer> loadListGTtheoNam(String gioitinh,int year) {
        ArrayList<Customer> dskh = new ArrayList<Customer>();
        try {
            String sql = "SELECT * FROM khachhang where gioitinh = ? and YEAR(history) = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, gioitinh);
            pstm.setInt(2, year);
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
     public float tinhTongDanhThuTheoNam(int year) {
        float tt = 0;
        try {
            String sql = "SELECT donphi FROM khachhang where YEAR(history) = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setInt(1, year);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                tt = tt + rs.getFloat(1);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tt;
    }
}
