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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author A
 */
public class TicketDAO extends Connection {

    public ArrayList<Ticket> loadList(String makh) {
        ArrayList<Ticket> dskh = new ArrayList<Ticket>();
        try {
            String sql = "SELECT * FROM the where makh = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, makh);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Ticket tk = new Ticket();
                tk.setMathe(rs.getString(1));
                tk.setMakh(rs.getString(2));
                tk.setBatdau(rs.getDate(3));
                tk.setKetthuc(rs.getDate(4));
                tk.setNgay1(rs.getBoolean(5));
                tk.setNgay2(rs.getBoolean(6));
                tk.setNgay3(rs.getBoolean(7));
                tk.setNgay4(rs.getBoolean(8));
                tk.setNgay5(rs.getBoolean(9));
                tk.setNgay6(rs.getBoolean(10));
                tk.setNgay7(rs.getBoolean(11));
                tk.setNgay8(rs.getBoolean(12));
                tk.setNgay9(rs.getBoolean(13));
                tk.setNgay10(rs.getBoolean(14));
                tk.setNgay11(rs.getBoolean(15));
                tk.setNgay12(rs.getBoolean(16));
                tk.setNgay13(rs.getBoolean(17));
                tk.setNgay14(rs.getBoolean(18));
                tk.setNgay15(rs.getBoolean(19));
                tk.setNgay16(rs.getBoolean(20));
                tk.setNgay17(rs.getBoolean(21));
                tk.setNgay18(rs.getBoolean(22));
                tk.setNgay19(rs.getBoolean(23));
                tk.setNgay20(rs.getBoolean(24));
                tk.setNgay21(rs.getBoolean(25));
                tk.setNgay22(rs.getBoolean(26));
                tk.setNgay23(rs.getBoolean(27));
                tk.setNgay24(rs.getBoolean(28));
                tk.setNgay25(rs.getBoolean(29));
                tk.setNgay26(rs.getBoolean(30));
                tk.setNgay27(rs.getBoolean(31));
                tk.setNgay28(rs.getBoolean(32));
                tk.setNgay29(rs.getBoolean(33));
                tk.setNgay30(rs.getBoolean(34));
                tk.setNgay31(rs.getBoolean(35));
                tk.setActive(rs.getBoolean(36));
                dskh.add(tk);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dskh;
    }

    public boolean addTicket(String mathe, String makh, String batdau, String ketthuc, boolean ngay1, boolean ngay2, boolean ngay3, boolean ngay4, boolean ngay5, boolean ngay6, boolean ngay7, boolean ngay8, boolean ngay9, boolean ngay10, boolean ngay11, boolean ngay12, boolean ngay13, boolean ngay14, boolean ngay15, boolean ngay16, boolean ngay17, boolean ngay18, boolean ngay19, boolean ngay20, boolean ngay21, boolean ngay22, boolean ngay23, boolean ngay24, boolean ngay25, boolean ngay26, boolean ngay27, boolean ngay28, boolean ngay29, boolean ngay30, boolean ngay31, boolean active) {
        try {
            String sql = "INSERT INTO the VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, mathe);
            pstm.setString(2, makh);
            pstm.setString(3, batdau);
            pstm.setString(4, ketthuc);
            pstm.setBoolean(5, ngay1);
            pstm.setBoolean(6, ngay2);
            pstm.setBoolean(7, ngay3);
            pstm.setBoolean(8, ngay4);
            pstm.setBoolean(9, ngay5);
            pstm.setBoolean(10, ngay6);
            pstm.setBoolean(11, ngay7);
            pstm.setBoolean(12, ngay8);
            pstm.setBoolean(13, ngay9);
            pstm.setBoolean(14, ngay10);
            pstm.setBoolean(15, ngay11);
            pstm.setBoolean(16, ngay12);
            pstm.setBoolean(17, ngay13);
            pstm.setBoolean(18, ngay14);
            pstm.setBoolean(19, ngay15);
            pstm.setBoolean(20, ngay16);
            pstm.setBoolean(21, ngay17);
            pstm.setBoolean(22, ngay18);
            pstm.setBoolean(23, ngay19);
            pstm.setBoolean(24, ngay20);
            pstm.setBoolean(25, ngay21);
            pstm.setBoolean(26, ngay22);
            pstm.setBoolean(27, ngay23);
            pstm.setBoolean(28, ngay24);
            pstm.setBoolean(29, ngay25);
            pstm.setBoolean(30, ngay26);
            pstm.setBoolean(31, ngay27);
            pstm.setBoolean(32, ngay28);
            pstm.setBoolean(33, ngay29);
            pstm.setBoolean(34, ngay30);
            pstm.setBoolean(35, ngay31);
            pstm.setBoolean(36, active);
            
            
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean deleteTicket(String mathe) {
        try {
            String sql = "Delete from the where mathe = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, mathe);
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public boolean deleteTicket2(String makh) {
        try {
            String sql = "Delete from the where makh = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, makh);
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean updateTicket(String mathe, String makh, String batdau, String ketthuc, boolean ngay1, boolean ngay2, boolean ngay3, boolean ngay4, boolean ngay5, boolean ngay6, boolean ngay7, boolean ngay8, boolean ngay9, boolean ngay10, boolean ngay11, boolean ngay12, boolean ngay13, boolean ngay14, boolean ngay15, boolean ngay16, boolean ngay17, boolean ngay18, boolean ngay19, boolean ngay20, boolean ngay21, boolean ngay22, boolean ngay23, boolean ngay24, boolean ngay25, boolean ngay26, boolean ngay27, boolean ngay28, boolean ngay29, boolean ngay30, boolean ngay31, boolean active) {
        try {
            String sql = "UPDATE the SET makh= ?, batdau = ?, hethan = ?, ngay1 = ?, ngay2= ?, ngay3 =?,ngay4=?,ngay5=?,ngay6=?,ngay7=?,ngay8=?,ngay9=?,ngay10=?,ngay11=?,ngay12=?,ngay13=?,ngay14=?,ngay15=?,ngay16=?,ngay17=?,ngay18=?,ngay19=?,ngay20=?,ngay21=?,ngay22=?,ngay23=?,ngay24=?,ngay25=?,ngay26=?,ngay27=?,ngay28=?,ngay29=?,ngay30=?,ngay31=?,active=? WHERE mathe = ?";
            PreparedStatement pstm = con.prepareStatement(sql);

            
            pstm.setString(1, makh);
            pstm.setString(2, batdau);
            pstm.setString(3, ketthuc);
            pstm.setBoolean(4, ngay1);
            pstm.setBoolean(5, ngay2);
            pstm.setBoolean(6, ngay3);
            pstm.setBoolean(7, ngay4);
            pstm.setBoolean(8, ngay5);
            pstm.setBoolean(9, ngay6);
            pstm.setBoolean(10, ngay7);
            pstm.setBoolean(11, ngay8);
            pstm.setBoolean(12, ngay9);
            pstm.setBoolean(13, ngay10);
            pstm.setBoolean(14, ngay11);
            pstm.setBoolean(15, ngay12);
            pstm.setBoolean(16, ngay13);
            pstm.setBoolean(17, ngay14);
            pstm.setBoolean(18, ngay15);
            pstm.setBoolean(19, ngay16);
            pstm.setBoolean(20, ngay17);
            pstm.setBoolean(21, ngay18);
            pstm.setBoolean(22, ngay19);
            pstm.setBoolean(23, ngay20);
            pstm.setBoolean(24, ngay21);
            pstm.setBoolean(25, ngay22);
            pstm.setBoolean(26, ngay23);
            pstm.setBoolean(27, ngay24);
            pstm.setBoolean(28, ngay25);
            pstm.setBoolean(29, ngay26);
            pstm.setBoolean(30, ngay27);
            pstm.setBoolean(31, ngay28);
            pstm.setBoolean(32, ngay29);
            pstm.setBoolean(33, ngay30);
            pstm.setBoolean(34, ngay31);
            pstm.setBoolean(35, active);
            pstm.setString(36, mathe);
            
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
public ArrayList<Ticket> searchTicket(int day, int month, int year ,String hovaten) {
        ArrayList<Ticket> dsTick = new ArrayList<Ticket>();
        try {
            String sql = "select khachhang.hovaten, the.mathe, the.makh , the.batdau, the.hethan from khachhang,the where (khachhang.makh = the.makh) and ((DAY(the.hethan) <= "+ day +" and MONTH(the.hethan) <= "+month+" and YEAR(the.hethan) <= "+year+") OR the.active = 'true') and hovaten like N'" + hovaten + "%'";// có chữ N ĐẰNG TRƯỚC LÀ TÌM UNICODE
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
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
public ArrayList<Ticket> searchTicketFilter(int day, int month, int year) {
        ArrayList<Ticket> dsTick = new ArrayList<Ticket>();
        try {
            String sql = "select khachhang.hovaten, the.mathe, the.makh , the.batdau, the.hethan from khachhang,the where (khachhang.makh = the.makh) and ((DAY(the.hethan) <= "+ day +" and MONTH(the.hethan) <= "+month+" and YEAR(the.hethan) <= "+year+") OR the.active = 'true')";// có chữ N ĐẰNG TRƯỚC LÀ TÌM UNICODE
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
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
}
