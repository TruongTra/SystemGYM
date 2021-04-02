/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stupid.DAO;

import Stupid.Connection.Connection;
import Stupid.Modal.DSEmail;
import Stupid.Modal.Email;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author A
 */
public class EmailDAO extends Connection {
    public ArrayList<Email> loadList() {
        ArrayList<Email> dsEmail = new ArrayList<Email>();
        try {
            String sql = "SELECT * FROM email ";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                Email e = new Email();
                e.setTaikhoan(rs.getString(1));
                e.setMatkhau(rs.getString(1));
                dsEmail.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dsEmail;
    }
    public ArrayList<DSEmail> loadListEmail() {
        ArrayList<DSEmail> dsEmail = new ArrayList<DSEmail>();
        try {
            String sql = "SELECT hovaten,sodienthoai FROM khachhang ";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                DSEmail e = new DSEmail();
                e.setHovaten(rs.getString(1));
                e.setEmail(rs.getString(2));
                dsEmail.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return dsEmail;
    }
    
    public boolean addEmail(String taikhoan, String matkhau) {
        try {
            String sql = "INSERT INTO email VALUES (?,?)";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, taikhoan);
            pstm.setString(2, matkhau);
            
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public boolean deleteEmail(String taikhoan) {
        try {
            String sql = "Delete from email where username = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, taikhoan);
            return pstm.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public String matkhauEmail(String taikhoan){
        String matkhau = null;
        try {
            String sql = "SELECT password FROM email where username = ?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, taikhoan);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                matkhau = rs.getString(1);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return matkhau;
    }
    
    
}
