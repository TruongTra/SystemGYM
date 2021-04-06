/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stupid.UI;

import Stupid.DAO.CustomerDAO;
import Stupid.DAO.StaDAO;
import Stupid.DAO.TicketDAO;
import Stupid.Modal.Customer;
import Stupid.Modal.Ticket;
import com.jtattoo.plaf.fast.FastLookAndFeel;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


/**
 *
 * @author A
 */
public class MainFrame extends javax.swing.JFrame {

    String fullPath;
    String fileanh = "hinhmacdinh.png";
    SimpleDateFormat Date_Format = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Creates new form MainJFrame
     */
    public MainFrame() {
        initComponents();
        setTitle("HỆ THỐNG");
        setLocationRelativeTo(null);
        showTableCustomer();
        showTableHetHan();
    }

    public void showTableCustomer() {
        DefaultTableModel modelCustomer = (DefaultTableModel) tblCustomer.getModel();
        CustomerDAO cDAO = new CustomerDAO();
        ArrayList<Customer> dskh = cDAO.loadList();
        modelCustomer.setRowCount(0);
        for (Customer kh : dskh) {
            Vector row = new Vector();
            row.add(kh.getMakh());
            row.add(kh.getHovaten());
            row.add(kh.getGioitinh());
            row.add(kh.getNgaysinh());
            row.add(kh.getSodienthoai());
            row.add(kh.getSocmnd());
            row.add(kh.getDonphi());
            row.add(kh.getGhichu());
            row.add(kh.getImage());
            row.add(kh.getHistory());
            modelCustomer.addRow(row);
        }
        tblCustomer.setModel(modelCustomer);
    }

    public void showTableCustomerSN() {
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        DefaultTableModel modelCustomer = (DefaultTableModel) tblCustomer.getModel();
        CustomerDAO cDAO = new CustomerDAO();
        ArrayList<Customer> dskh = cDAO.loadListSN(day, month);
        modelCustomer.setRowCount(0);
        for (Customer kh : dskh) {
            Vector row = new Vector();
            row.add(kh.getMakh());
            row.add(kh.getHovaten());
            row.add(kh.getGioitinh());
            row.add(kh.getNgaysinh());
            row.add(kh.getSodienthoai());
            row.add(kh.getSocmnd());
            row.add(kh.getDonphi());
            row.add(kh.getGhichu());
            row.add(kh.getImage());
            row.add(kh.getHistory());
            modelCustomer.addRow(row);
        }
        tblCustomer.setModel(modelCustomer);
    }

    public void showTableTick() {
        DefaultTableModel modelTicket = (DefaultTableModel) tblTicket.getModel();
        TicketDAO tDAO = new TicketDAO();
        int r = tblCustomer.getSelectedRow();
        String makh = tblCustomer.getValueAt(r, 0).toString();
        ArrayList<Ticket> dstick = tDAO.loadList(makh);
        modelTicket.setRowCount(0);
        for (Ticket tk : dstick) {
            Vector row = new Vector();
            row.add(tk.getMathe());
            row.add(tk.getMakh());
            row.add(tk.getBatdau());
            row.add(tk.getKetthuc());
            row.add(tk.getNgay1());
            row.add(tk.getNgay2());
            row.add(tk.getNgay3());
            row.add(tk.getNgay4());
            row.add(tk.getNgay5());
            row.add(tk.getNgay6());
            row.add(tk.getNgay7());
            row.add(tk.getNgay8());
            row.add(tk.getNgay9());
            row.add(tk.getNgay10());
            row.add(tk.getNgay11());
            row.add(tk.getNgay12());
            row.add(tk.getNgay13());
            row.add(tk.getNgay14());
            row.add(tk.getNgay15());
            row.add(tk.getNgay16());
            row.add(tk.getNgay17());
            row.add(tk.getNgay18());
            row.add(tk.getNgay19());
            row.add(tk.getNgay20());
            row.add(tk.getNgay21());
            row.add(tk.getNgay22());
            row.add(tk.getNgay23());
            row.add(tk.getNgay24());
            row.add(tk.getNgay25());
            row.add(tk.getNgay26());
            row.add(tk.getNgay27());
            row.add(tk.getNgay28());
            row.add(tk.getNgay29());
            row.add(tk.getNgay30());
            row.add(tk.getNgay31());
            row.add(tk.getActive());

            modelTicket.addRow(row);
        }
        tblTicket.setModel(modelTicket);
    }

    public void showTableHetHan() {
        DefaultTableModel modelHH = (DefaultTableModel) tblHetHan.getModel();
        TicketDAO tDAO = new TicketDAO();
        StaDAO stDAO = new StaDAO();
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        ArrayList<Ticket> dstick = stDAO.loadListHH(day, month, year);
        modelHH.setRowCount(0);
        for (Ticket tk : dstick) {
            Vector row = new Vector();
            row.add(tk.getHovaten());
            row.add(tk.getMathe());
            row.add(tk.getMakh());
            row.add(tk.getBatdau());
            row.add(tk.getKetthuc());

            modelHH.addRow(row);
        }
        tblHetHan.setModel(modelHH);
    }

    public void UpdateHinh(String fullPath) {
        ImageIcon image1 = new ImageIcon(fullPath);
        Image im = image1.getImage();
        ImageIcon icon = new ImageIcon(im.getScaledInstance(lblHinh.getWidth(), lblHinh.getHeight(), im.SCALE_SMOOTH));
        lblHinh.setIcon(icon);
        lblHinh.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cboHeThong = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCustomer = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblTicket = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblHetHan = new javax.swing.JTable();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        txtTimKiemHH = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        cboNgayHH = new javax.swing.JComboBox<>();
        cboNamHH = new javax.swing.JComboBox<>();
        cboThangHH = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        txtMaKH = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        txtTenKH = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        cboNgay = new javax.swing.JComboBox<>();
        cboNam = new javax.swing.JComboBox<>();
        cboThang = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        cboGioiTinh = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        txtLienHe = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        txtSoCMND = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        jPanel12 = new javax.swing.JPanel();
        txtDonPhi = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        lblHinh = new javax.swing.JLabel();
        cboQuanLy = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        cboHeThong.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cboHeThong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "THỐNG KÊ", "HẾT HẠN", "XUẤT EXCEL", "THOÁT" }));
        cboHeThong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboHeThongActionPerformed(evt);
            }
        });

        jPanel2.setLayout(new java.awt.CardLayout());

        tblCustomer.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MÃ KH", "HỌ TÊN", "SEX", "NGÀY SINH", "LIÊN HỆ", "SỐ CMND", "ĐƠN PHÍ", "CHI CHÚ", "ẢNH", "NGÀY TẠO"
            }
        ));
        tblCustomer.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCustomerMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblCustomer);
        if (tblCustomer.getColumnModel().getColumnCount() > 0) {
            tblCustomer.getColumnModel().getColumn(1).setResizable(false);
        }

        jPanel2.add(jScrollPane3, "card2");

        tblTicket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MÃ THẺ", "MÃ KH", "BẮT ĐẦU", "HẾT HẠN", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "ACTIVE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblTicket.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblTicket.setAutoscrolls(false);
        tblTicket.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTicketMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblTicket);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 742, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel14, "card4");

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        tblHetHan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "HỌ VÀ TÊN", "MÃ THẺ", "MÃ KH", "BẮT ĐẦU", "HẾT HẠN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHetHan.setAutoscrolls(false);
        jScrollPane7.setViewportView(tblHetHan);
        if (tblHetHan.getColumnModel().getColumnCount() > 0) {
            tblHetHan.getColumnModel().getColumn(1).setResizable(false);
            tblHetHan.getColumnModel().getColumn(2).setResizable(false);
            tblHetHan.getColumnModel().getColumn(3).setResizable(false);
            tblHetHan.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "TÌM KIẾM :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtTimKiemHH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemHHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtTimKiemHH)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtTimKiemHH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "CHỌN NGÀY :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        cboNgayHH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", " " }));
        cboNgayHH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNgayHHActionPerformed(evt);
            }
        });

        cboNamHH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040" }));

        cboThangHH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(cboNgayHH, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboThangHH, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboNamHH, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(cboNgayHH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cboNamHH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cboThangHH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconfinder_remove-80px_510922 (1).png"))); // NOI18N
        jButton6.setText("LỌC");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconfinder_remove-80px_510922 (1).png"))); // NOI18N
        jButton8.setText("TẤT CẢ");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(jPanel15, "card4");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("TRẠNG THÁI :");

        lblStatus.setBackground(new java.awt.Color(0, 255, 0));
        lblStatus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblStatus.setForeground(new java.awt.Color(0, 255, 0));
        lblStatus.setText("HOẠT ĐỘNG");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconfinder_social_62_566756 (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "MÃ KH :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtMaKH)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "HỌ VÀ TÊN :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtTenKH)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "NGÀY SINH : ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        cboNgay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        cboNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040" }));

        cboThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(cboNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboNam, 0, 73, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(cboNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cboNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(cboThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconfinder_rotate-forward-80px_510921 (4).png"))); // NOI18N
        jButton1.setText("SỬA");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconfinder_remove-80px_510922 (1).png"))); // NOI18N
        jButton2.setText("XÓA");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconfinder_add-80px_510912.png"))); // NOI18N
        jButton3.setText("MỚI ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/iconfinder_check-mark-80px_510930.png"))); // NOI18N
        jButton4.setText("LƯU");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "GIỚI TÍNH : ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        cboGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NAM", "NỮ" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cboGioiTinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cboGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "LIÊN HỆ : ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtLienHe)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtLienHe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "SỐ CHỨNG MINH : ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSoCMND)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtSoCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "GHI CHÚ : ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(3);
        jScrollPane2.setViewportView(txtGhiChu);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "ĐƠN PHÍ :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtDonPhi)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(txtDonPhi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "ẢNH ĐẠI DIỆN ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        lblHinh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHinh.setText("Chọn ảnh");
        lblHinh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHinhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );

        cboQuanLy.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cboQuanLy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "THÊM", "XÓA" }));
        cboQuanLy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboQuanLyActionPerformed(evt);
            }
        });

        txtTimKiem.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        jButton5.setText("TRỞ LẠI");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblStatus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboHeThong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboQuanLy, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboHeThong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(lblStatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboQuanLy, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                            .addComponent(txtTimKiem)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboQuanLyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboQuanLyActionPerformed
        // TODO add your handling code here:

        Object obj = evt.getSource();
        if (obj == cboQuanLy) {
            String luachon = cboQuanLy.getSelectedItem().toString().trim();

            int r = tblCustomer.getSelectedRow();

            if (r < 0) {
                lblStatus.setForeground(Color.red);
                lblStatus.setText("VUI LÒNG CHỌN DÒNG !!!");

            } else {

                if (luachon.equals("THÊM")) {

                    String makh = tblCustomer.getValueAt(r, 0).toString();
                    TicketJFrame tj = new TicketJFrame();
                    tj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    tj.txtMaKH.setText(makh);
                    tj.setVisible(true);

                } else if (luachon.equals("SỬA")) {
                    int r2 = tblTicket.getSelectedRow();
                    if (r2 < 0) {
                        lblStatus.setForeground(Color.red);
                        lblStatus.setText("VUI LÒNG CHỌN ĐỂ SỬA !!!");
                    } else {
                        TicketJFrame tj = new TicketJFrame();
                        tj.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                        tj.txtMaThe.setText(tblTicket.getValueAt(r2, 0).toString());
                        tj.txtMaKH.setText(tblTicket.getValueAt(r2, 1).toString());
                        String batdau = tblTicket.getValueAt(r, 2).toString().trim();
                        tj.cboNamBD.setSelectedItem(batdau.substring(0, 4).trim());
                        tj.cboThangBD.setSelectedItem(batdau.substring(6, 7).trim());
                        tj.cboNgayBD.setSelectedItem(batdau.substring(8, 10).trim());
                        String ketthuc = tblTicket.getValueAt(r, 3).toString().trim();
                        tj.cboNamHH.setSelectedItem(ketthuc.substring(0, 4).trim());
                        tj.cboThangHH.setSelectedItem(ketthuc.substring(6, 7).trim());
                        tj.cboNgayHH.setSelectedItem(ketthuc.substring(8, 10).trim());

                        tj.setVisible(true);
                    }
                } else if (luachon.equals("XÓA")) {
                    int r2 = tblTicket.getSelectedRow();
                    if (r2 < 0) {
                        lblStatus.setForeground(Color.red);
                        lblStatus.setText("VUI LÒNG CHỌN ĐỂ XÓA !!!");
                    } else {
                        TicketJFrame tj = new TicketJFrame();
                        if (deleteTicket() == true) {
                            lblStatus.setForeground(Color.green);
                            lblStatus.setText("XÓA THÀNH CÔNG");
                        } else {
                            lblStatus.setForeground(Color.red);
                            lblStatus.setText("XÓA THẤT BẠI");
                        }
                    }
                }
            }

        }
    }//GEN-LAST:event_cboQuanLyActionPerformed

    private void lblHinhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHinhMouseClicked
        // TODO add your handling code here:
        JFileChooser fchooser = new JFileChooser();
        int result = fchooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fchooser.getSelectedFile();
            fullPath = file.getAbsolutePath();
            fileanh = fchooser.getSelectedFile().getName();
            UpdateHinh(fullPath);
            try {
                Path src = Paths.get(fullPath);
                Path dest = Paths.get("src\\Images\\" + fileanh);
                Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_lblHinhMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        boolean check = true;
        try {
            float donphi = Float.parseFloat(txtDonPhi.getText());
            check = true;
        } catch (Exception ex) {
            check = false;
        }
        if (new CustomerDAO().checkMaKH(txtMaKH.getText())) {
            lblStatus.setForeground(Color.red);
            lblStatus.setText("MÃ ĐÃ TỒN TẠI");
            txtMaKH.requestFocus();
            check = false;
        } else if (txtMaKH.getText().length() == 0) {
            lblStatus.setForeground(Color.red);
            lblStatus.setText("KHÔNG BỎ TRỐNG");
            txtMaKH.requestFocus();
            check = false;
        } else if (txtTenKH.getText().length() == 0) {
            lblStatus.setForeground(Color.red);
            lblStatus.setText("KHÔNG BỎ TRỐNG");
            txtTenKH.requestFocus();
            check = false;
        } else if (txtLienHe.getText().length() == 0) {
            lblStatus.setForeground(Color.red);
            lblStatus.setText("KHÔNG BỎ TRỐNG");
            txtLienHe.requestFocus();
            check = false;
        } else if (txtSoCMND.getText().length() == 0) {
            lblStatus.setForeground(Color.red);
            lblStatus.setText("KHÔNG BỎ TRỐNG");
            txtSoCMND.requestFocus();
            check = false;
        } else if (txtDonPhi.getText().length() == 0) {
            lblStatus.setForeground(Color.red);
            lblStatus.setText("KHÔNG BỎ TRỐNG");
            txtDonPhi.requestFocus();
        } else if (txtGhiChu.getText().length() == 0) {
            lblStatus.setForeground(Color.red);
            lblStatus.setText("KHÔNG BỎ TRỐNG");
            txtGhiChu.requestFocus();
            check = false;
        } else if (check = false) {
            lblStatus.setForeground(Color.red);
            lblStatus.setText("SAI ĐỊNH DẠNG");
            txtTenKH.requestFocus();
            check = false;
        } else {
            if (addCustomer() == true) {
                lblStatus.setForeground(Color.green);
                lblStatus.setText("THÊM THÀNH CÔNG");
            } else {
                lblStatus.setForeground(Color.red);
                lblStatus.setText("THÊM THẤT BẠI");
            }
        }

    }//GEN-LAST:event_jButton4ActionPerformed

    private void tblCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCustomerMouseClicked
        // TODO add your handling code here:
        int r = tblCustomer.getSelectedRow();
        txtMaKH.setText(tblCustomer.getValueAt(r, 0).toString());
        txtTenKH.setText(tblCustomer.getValueAt(r, 1).toString());
        cboGioiTinh.setSelectedItem(tblCustomer.getValueAt(r, 2).toString().trim());
        String ngaysinh = tblCustomer.getValueAt(r, 3).toString().trim();
        cboNam.setSelectedItem(ngaysinh.substring(0, 4).trim());
        cboThang.setSelectedItem(ngaysinh.substring(6, 7).trim());
        cboNgay.setSelectedItem(ngaysinh.substring(8, 10).trim());
        txtLienHe.setText(tblCustomer.getValueAt(r, 4).toString());
        txtSoCMND.setText(tblCustomer.getValueAt(r, 5).toString());
        txtDonPhi.setText(tblCustomer.getValueAt(r, 6).toString());
        txtGhiChu.setText(tblCustomer.getValueAt(r, 7).toString());
        UpdateHinh("src\\Images\\" + tblCustomer.getValueAt(r, 8).toString());
        txtMaKH.setEditable(false);
        showTableTick();
        jPanel2.removeAll();
        jPanel2.add(jPanel14);
        jPanel2.repaint();
        jPanel2.revalidate();
    }//GEN-LAST:event_tblCustomerMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        jPanel2.removeAll();
        jPanel2.add(jScrollPane3);
        jPanel2.repaint();
        jPanel2.revalidate();
        showTableCustomer();
        showTableHetHan();
//        showTableCustomerSN();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void cboHeThongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboHeThongActionPerformed
        // TODO add your handling code here:
        Object objj = evt.getSource();
        if (objj == cboHeThong) {
            String luachon2 = cboHeThong.getSelectedItem().toString().trim();
            if (luachon2 == "THỐNG KÊ") {
                TableJFrame ta = new TableJFrame();
                ta.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                ta.setVisible(true);
                lblStatus.setForeground(Color.green);
                lblStatus.setText("THỐNG KÊ");
            } else if (luachon2 == "SINH NHẬT") {
                showTableCustomerSN();
            } else if (luachon2 == "HẾT HẠN") {
                jPanel2.removeAll();
                jPanel2.add(jPanel15);
                jPanel2.repaint();
                jPanel2.revalidate();
            } else if (luachon2 == "XUẤT EXCEL") {
                xuatExcel();
                lblStatus.setForeground(Color.green);
                lblStatus.setText("ĐÃ XUẤT FILE");
            } else if (luachon2 == "GỬI EMAIL") {
                SendMail e = new SendMail();
                e.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                e.setVisible(true);
                lblStatus.setForeground(Color.green);
                lblStatus.setText("GỬI EMAIL");
            } else if (luachon2 == "THOÁT") {
                int response = JOptionPane.showConfirmDialog(null, "Bạn muốn thoát ứng dụng", "Thông báo",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    xuatExcel();
                    System.exit(0);
                }
            }
        }
    }//GEN-LAST:event_cboHeThongActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        txtMaKH.setEditable(true);
        txtMaKH.setText("");
        txtTenKH.setText("");
        cboGioiTinh.setSelectedItem(0);
        cboNgay.setSelectedItem(0);
        cboThang.setSelectedItem(0);
        cboNam.setSelectedItem(0);
        txtLienHe.setText("");
        txtSoCMND.setText("");
        txtDonPhi.setText("");
        txtGhiChu.setText("");
        fileanh = "hinhmacdinh.png";
        lblStatus.setForeground(Color.green);
        lblStatus.setText("LÀM MỚI THÀNH CÔNG");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if (deleteCustomer() == true) {
            lblStatus.setForeground(Color.green);
            lblStatus.setText("XÓA THÀNH CÔNG");
        } else {
            lblStatus.setForeground(Color.red);
            lblStatus.setText("XÓA THẤT BẠI");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        boolean check = true;
        try {
            float donphi = Float.parseFloat(txtDonPhi.getText());
            check = true;
        } catch (Exception ex) {
            check = false;
        }
        if (txtMaKH.getText().length() == 0) {
            lblStatus.setForeground(Color.red);
            lblStatus.setText("KHÔNG BỎ TRỐNG");
            txtMaKH.requestFocus();
            check = false;
        } else if (txtTenKH.getText().length() == 0) {
            lblStatus.setForeground(Color.red);
            lblStatus.setText("KHÔNG BỎ TRỐNG");
            txtTenKH.requestFocus();
            check = false;
        } else if (txtLienHe.getText().length() == 0) {
            lblStatus.setForeground(Color.red);
            lblStatus.setText("KHÔNG BỎ TRỐNG");
            txtLienHe.requestFocus();
            check = false;
        } else if (txtSoCMND.getText().length() == 0) {
            lblStatus.setForeground(Color.red);
            lblStatus.setText("KHÔNG BỎ TRỐNG");
            txtSoCMND.requestFocus();
            check = false;
        } else if (txtDonPhi.getText().length() == 0) {
            lblStatus.setForeground(Color.red);
            lblStatus.setText("KHÔNG BỎ TRỐNG");
            txtDonPhi.requestFocus();
        } else if (txtGhiChu.getText().length() == 0) {
            lblStatus.setForeground(Color.red);
            lblStatus.setText("KHÔNG BỎ TRỐNG");
            txtGhiChu.requestFocus();
            check = false;
        } else if (check = false) {
            lblStatus.setForeground(Color.red);
            lblStatus.setText("SAI ĐỊNH DẠNG");
            txtTenKH.requestFocus();
            check = false;
        } else {
            if (updateCustomer() == true) {
                lblStatus.setForeground(Color.green);
                lblStatus.setText("CẬP NHẬT THÀNH CÔNG");
            } else {
                lblStatus.setForeground(Color.red);
                lblStatus.setText("CẬP NHẬT THẤT BẠI");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelCustomer = (DefaultTableModel) tblCustomer.getModel();
        String noidung = txtTimKiem.getText();
        CustomerDAO cDAO = new CustomerDAO();
        ArrayList<Customer> dskh = cDAO.searchCustomer(noidung);
        modelCustomer.setRowCount(0);
        for (Customer kh : dskh) {
            Vector row = new Vector();
            row.add(kh.getMakh());
            row.add(kh.getHovaten());
            row.add(kh.getGioitinh());
            row.add(kh.getNgaysinh());
            row.add(kh.getSodienthoai());
            row.add(kh.getSocmnd());
            row.add(kh.getDonphi());
            row.add(kh.getGhichu());
            row.add(kh.getImage());
            row.add(kh.getHistory());
            modelCustomer.addRow(row);
        }
        tblCustomer.setModel(modelCustomer);

    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void cboNgayHHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNgayHHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboNgayHHActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:

        DefaultTableModel modelHH = (DefaultTableModel) tblHetHan.getModel();
        TicketDAO tDAO = new TicketDAO();
        StaDAO stDAO = new StaDAO();
        int day = Integer.parseInt(cboNgayHH.getSelectedItem().toString().trim());
        int month = Integer.parseInt(cboThangHH.getSelectedItem().toString().trim());
        int year = Integer.parseInt(cboNamHH.getSelectedItem().toString().trim());
        ArrayList<Ticket> dstick = tDAO.searchTicketFilter(day, month, year);
        modelHH.setRowCount(0);
        for (Ticket tk : dstick) {
            Vector row = new Vector();
            row.add(tk.getHovaten());
            row.add(tk.getMathe());
            row.add(tk.getMakh());
            row.add(tk.getBatdau());
            row.add(tk.getKetthuc());

            modelHH.addRow(row);
        }
        tblHetHan.setModel(modelHH);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        showTableHetHan();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void tblTicketMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTicketMouseClicked
        // TODO add your handling code here:
        if (updateTicket() == true) {
            lblStatus.setForeground(Color.green);
            lblStatus.setText("ĐIỂM DANH THÀNH CÔNG");
        } else {
            lblStatus.setForeground(Color.red);
            lblStatus.setText("ĐIỂM DANH THẤT BẠI");
        }
    }//GEN-LAST:event_tblTicketMouseClicked

    private void txtTimKiemHHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemHHActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelHH = (DefaultTableModel) tblHetHan.getModel();
        TicketDAO tDAO = new TicketDAO();
        StaDAO stDAO = new StaDAO();
        Calendar cal = Calendar.getInstance();
        int day = cal.get(Calendar.DATE);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        String hovaten = txtTimKiemHH.getText();
        ArrayList<Ticket> dstick = tDAO.searchTicket(day, month, year, hovaten);
        modelHH.setRowCount(0);
        for (Ticket tk : dstick) {
            Vector row = new Vector();
            row.add(tk.getHovaten());
            row.add(tk.getMathe());
            row.add(tk.getMakh());
            row.add(tk.getBatdau());
            row.add(tk.getKetthuc());

            modelHH.addRow(row);
        }
        tblHetHan.setModel(modelHH);
    }//GEN-LAST:event_txtTimKiemHHActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {

            Properties props = new Properties();
            props.put("logoString", "");
            FastLookAndFeel.setCurrentTheme(props);

            UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
        } catch (Exception ex) {
        }
        //</editor-fold

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboGioiTinh;
    private javax.swing.JComboBox<String> cboHeThong;
    private javax.swing.JComboBox<String> cboNam;
    javax.swing.JComboBox<String> cboNamHH;
    private javax.swing.JComboBox<String> cboNgay;
    javax.swing.JComboBox<String> cboNgayHH;
    private javax.swing.JComboBox<String> cboQuanLy;
    private javax.swing.JComboBox<String> cboThang;
    javax.swing.JComboBox<String> cboThangHH;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lblHinh;
    private javax.swing.JLabel lblStatus;
    javax.swing.JTable tblCustomer;
    javax.swing.JTable tblHetHan;
    javax.swing.JTable tblTicket;
    private javax.swing.JTextField txtDonPhi;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtLienHe;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSoCMND;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTimKiem;
    javax.swing.JTextField txtTimKiemHH;
    // End of variables declaration//GEN-END:variables

    public boolean addCustomer() {
        boolean check = false;
        try {
            String makh = txtMaKH.getText();
            String hovaten = txtTenKH.getText();
            String gioitinh = cboGioiTinh.getSelectedItem().toString().trim();
            String ngaysinh;
            String ngay = cboNgay.getSelectedItem().toString().trim();
            String thang = cboThang.getSelectedItem().toString().trim();
            String nam = cboNam.getSelectedItem().toString().trim();
            ngaysinh = nam + "/" + thang + "/" + ngay;
            String sodienthoai = txtLienHe.getText();
            String socmnd = txtSoCMND.getText();
            float donphi = Float.parseFloat(txtDonPhi.getText());
            String ghichu = txtGhiChu.getText();
            String image = fileanh;
            String history = Date_Format.format(new Date());

            CustomerDAO cDAO = new CustomerDAO();
            if (cDAO.addCustomer(makh, hovaten, ngaysinh, gioitinh, sodienthoai, socmnd, donphi, ghichu, image, history)) {
                showTableCustomer();
                check = true;
            } else {
                check = false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            check = false;
        }

        return check;
    }

    public boolean updateCustomer() {
        boolean check = false;
        try {

            String makh = txtMaKH.getText();
            String hovaten = txtTenKH.getText();
            String gioitinh = cboGioiTinh.getSelectedItem().toString().trim();
            String ngaysinh;
            String ngay = cboNgay.getSelectedItem().toString().trim();
            String thang = cboThang.getSelectedItem().toString().trim();
            String nam = cboNam.getSelectedItem().toString().trim();
            ngaysinh = nam + "/" + thang + "/" + ngay;
            String sodienthoai = txtLienHe.getText();
            String socmnd = txtSoCMND.getText();
            float donphi = Float.parseFloat(txtDonPhi.getText());
            String ghichu = txtGhiChu.getText();
            String image = fileanh;
            CustomerDAO cDAO = new CustomerDAO();
            if (cDAO.updateCustomer(hovaten, ngaysinh, gioitinh, sodienthoai, socmnd, donphi, ghichu, image, makh)) {
                showTableCustomer();
                jPanel2.removeAll();
                jPanel2.add(jScrollPane3);
                jPanel2.repaint();
                jPanel2.revalidate();
                check = true;
            } else {
                check = false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            check = false;
        }

        return check;
    }
    public boolean deleteCustomer() {
        boolean check = false;
        try {

            int r = tblCustomer.getSelectedRow();
            String makh = tblCustomer.getValueAt(r, 0).toString().trim();
            CustomerDAO cDAO = new CustomerDAO();
            TicketDAO tDAO = new TicketDAO();
            ArrayList<Ticket> dsTick = tDAO.loadList(makh);
            if (dsTick.size() > 0) {
                if (tDAO.deleteTicket2(makh)) {
                    if (cDAO.deleteCustomer(makh)) {
                        showTableCustomer();

                        check = true;
                    } else {
                        check = false;
                    }
                }
            } else {
                if (cDAO.deleteCustomer(makh)) {
                    showTableCustomer();

                    check = true;
                } else {
                    check = false;
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            check = false;
        }

        return check;
    }

    public boolean updateTicket() {
        boolean check = false;

        try {

            int r = tblTicket.getSelectedRow();
            String mathe = tblTicket.getValueAt(r, 0).toString().trim();
            String makh = tblTicket.getValueAt(r, 1).toString().trim();
            String batdau = tblTicket.getValueAt(r, 2).toString().trim();
            String ketthuc = tblTicket.getValueAt(r, 3).toString().trim();
            boolean ngay1 = (boolean) tblTicket.getValueAt(r, 4);
            boolean ngay2 = (boolean) tblTicket.getValueAt(r, 5);
            boolean ngay3 = (boolean) tblTicket.getValueAt(r, 6);
            boolean ngay4 = (boolean) tblTicket.getValueAt(r, 7);
            boolean ngay5 = (boolean) tblTicket.getValueAt(r, 8);
            boolean ngay6 = (boolean) tblTicket.getValueAt(r, 9);
            boolean ngay7 = (boolean) tblTicket.getValueAt(r, 10);
            boolean ngay8 = (boolean) tblTicket.getValueAt(r, 11);
            boolean ngay9 = (boolean) tblTicket.getValueAt(r, 12);
            boolean ngay10 = (boolean) tblTicket.getValueAt(r, 13);
            boolean ngay11 = (boolean) tblTicket.getValueAt(r, 14);
            boolean ngay12 = (boolean) tblTicket.getValueAt(r, 15);
            boolean ngay13 = (boolean) tblTicket.getValueAt(r, 16);
            boolean ngay14 = (boolean) tblTicket.getValueAt(r, 17);
            boolean ngay15 = (boolean) tblTicket.getValueAt(r, 18);
            boolean ngay16 = (boolean) tblTicket.getValueAt(r, 19);
            boolean ngay17 = (boolean) tblTicket.getValueAt(r, 20);
            boolean ngay18 = (boolean) tblTicket.getValueAt(r, 21);
            boolean ngay19 = (boolean) tblTicket.getValueAt(r, 22);
            boolean ngay20 = (boolean) tblTicket.getValueAt(r, 23);
            boolean ngay21 = (boolean) tblTicket.getValueAt(r, 24);
            boolean ngay22 = (boolean) tblTicket.getValueAt(r, 25);
            boolean ngay23 = (boolean) tblTicket.getValueAt(r, 26);
            boolean ngay24 = (boolean) tblTicket.getValueAt(r, 27);
            boolean ngay25 = (boolean) tblTicket.getValueAt(r, 28);
            boolean ngay26 = (boolean) tblTicket.getValueAt(r, 29);
            boolean ngay27 = (boolean) tblTicket.getValueAt(r, 30);
            boolean ngay28 = (boolean) tblTicket.getValueAt(r, 31);
            boolean ngay29 = (boolean) tblTicket.getValueAt(r, 32);
            boolean ngay30 = (boolean) tblTicket.getValueAt(r, 33);
            boolean ngay31 = (boolean) tblTicket.getValueAt(r, 34);
            boolean active = (boolean) tblTicket.getValueAt(r, 35);

            TicketDAO tDAO = new TicketDAO();
            if (tDAO.updateTicket(mathe, makh, batdau, ketthuc, ngay1, ngay2, ngay3, ngay4, ngay5, ngay6, ngay7, ngay8, ngay9, ngay10, ngay11, ngay12, ngay13, ngay14, ngay15, ngay16, ngay17, ngay18, ngay19, ngay20, ngay21, ngay22, ngay23, ngay24, ngay25, ngay26, ngay27, ngay28, ngay29, ngay30, ngay31, active)) {
                showTableTick();
                check = true;
            } else {
                check = false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Lỗi hệ thống ...", "Thông báo", 0);
            check = false;
        }
        return check;
    }

    public boolean deleteTicket() {
        boolean check = false;

        try {

            int r = tblTicket.getSelectedRow();
            String mathe = tblTicket.getValueAt(r, 0).toString().trim();
            TicketDAO tDAO = new TicketDAO();
            if (tDAO.deleteTicket(mathe)) {
                showTableTick();
                check = true;
            } else {
                check = false;
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Lỗi hệ thống ...", "Thông báo", 0);
            check = false;
        }
        return check;
    }

    

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public void xuatExcel() {
        try {
            CustomerDAO khDAO = new CustomerDAO();
            ArrayList<Customer> listKH = khDAO.loadList();
            FileOutputStream file = new FileOutputStream("danhsach.xls");
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet worksheet = workbook.createSheet("Khách Hàng");
            HSSFDataFormat formatt = workbook.createDataFormat();
            HSSFCellStyle dateStyle = workbook.createCellStyle();
            dateStyle.setDataFormat(formatt.getFormat("yyyy/MM/dd"));
            HSSFCellStyle style = createStyleForTitle(workbook);
            HSSFRow row;
            row = worksheet.createRow(0);

            HSSFCell makh;
            makh = row.createCell(0);
            makh.setCellValue("MÃ");
            makh.setCellStyle(style);
            HSSFCell hovaten;
            hovaten = row.createCell(1);
            hovaten.setCellValue("HỌ VÀ TÊN");
            hovaten.setCellStyle(style);
            HSSFCell ngaysinh;
            ngaysinh = row.createCell(2);
            ngaysinh.setCellValue("NGÀY SINH");
            ngaysinh.setCellStyle(style);
            HSSFCell gioitinh;
            gioitinh = row.createCell(3);
            gioitinh.setCellValue("GIỚI TÍNH");
            gioitinh.setCellStyle(style);
            HSSFCell sodienthoai;
            sodienthoai = row.createCell(4);
            sodienthoai.setCellValue("LIÊN LẠC");
            sodienthoai.setCellStyle(style);
            HSSFCell socmnd;
            socmnd = row.createCell(5);
            socmnd.setCellValue("SỐ CHỨNG MINH");
            socmnd.setCellStyle(style);
            HSSFCell donphi;
            donphi = row.createCell(6);
            donphi.setCellValue("ĐƠN PHÍ");
            donphi.setCellStyle(style);
            HSSFCell ghichu;
            ghichu = row.createCell(7);
            ghichu.setCellValue("GHI CHÚ");
            ghichu.setCellStyle(style);
            HSSFCell image;
            image = row.createCell(8);
            image.setCellValue("HÌNH ẢNH");
            image.setCellStyle(style);
            HSSFCell history;
            history = row.createCell(9);
            history.setCellValue("HISTORY");
            history.setCellStyle(style);

            int r = 1;
            for (Customer kh : listKH) {
                row = worksheet.createRow(r++);
                makh = row.createCell(0);
                makh.setCellValue(kh.getMakh());
                hovaten = row.createCell(1);
                hovaten.setCellValue(kh.getHovaten());
                gioitinh = row.createCell(3);
                gioitinh.setCellValue(kh.getGioitinh());
                ngaysinh = row.createCell(2);
                ngaysinh.setCellValue(kh.getNgaysinh());
                ngaysinh.setCellStyle(dateStyle);
                sodienthoai = row.createCell(4);
                sodienthoai.setCellValue(kh.getSodienthoai());
                socmnd = row.createCell(5);
                socmnd.setCellValue(kh.getDonphi());
                donphi = row.createCell(6);
                donphi.setCellValue(kh.getDonphi());
                ghichu = row.createCell(7);
                ghichu.setCellValue(kh.getGhichu());
                image = row.createCell(8);
                image.setCellValue(kh.getImage());
                history = row.createCell(9);
                history.setCellValue(kh.getHistory());
                worksheet.autoSizeColumn(r);
            }
            workbook.write(file);
            workbook.close();
            file.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            lblStatus.setForeground(Color.red);
            lblStatus.setText("XUẤT THẤT BẠI");
        }
    }
}
