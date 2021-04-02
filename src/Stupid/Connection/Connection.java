/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stupid.Connection;

import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author A
 */
public class Connection {

    protected java.sql.Connection con = null;

    public Connection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionurl = "jdbc:sqlserver://localhost:1433;databaseName=phonggym;";
            con = DriverManager.getConnection(connectionurl, "sa", "123");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
