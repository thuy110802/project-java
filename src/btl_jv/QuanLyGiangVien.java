/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package btl_jv;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Ngo Manh Hung
 */
public class QuanLyGiangVien extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyGiangVien
     */
    String filename = "QuanLyGiangVien.txt";
    DBEngine db = new DBEngine();
    ArrayList<GiangVienHD> listGV= new ArrayList<>();
    
    File fileName;
    public void fakeData(){
        GiangVienHD gv1 = new GiangVienHD(1, "Thạc sĩ", "ThS.Nguyễn Lan Anh", "0399595050","nglananh1107@gmail.com", 16);
        listGV.add(gv1);
        GiangVienHD gv2 = new GiangVienHD(2, "Thạc sĩ", "ThS.Phạm Thế Anh", "0372881182","anhpt@fit-haui.edu.vn", 15);
        listGV.add(gv2);
        GiangVienHD gv3 = new GiangVienHD(3, "Tiến sĩ", "TS.Nguyễn Thị Mỹ Bình", "0977901596","binhdungminhkhue@gmail.com", 19);
        listGV.add(gv3);
        GiangVienHD gv4 = new GiangVienHD(4, "Thạc sĩ", "ThS.Nguyễn Thái Cường", "0909846639","cuongnt81hn@gmail.com", 16);
        listGV.add(gv4);
        GiangVienHD gv5 = new GiangVienHD(5, "Tiến sĩ", "TS.Nguyễn Mạnh Cường", "0977901596","manhcuong.nguyen@gmail.com", 16);
        listGV.add(gv5);
    }
    public QuanLyGiangVien() {
        initComponents();
        fakeData();
        loadTableGiangVien();
    }
    public void luuFile() {
        try {
            db.luuFile(filename, listGV);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void docFile() {
        try {
            listGV = (ArrayList<GiangVienHD>) db.docFile(filename);
        } catch (Exception e) {
            System.out.printf(e.toString());
        }
    }
    public GiangVienHD docForm(){
        String name=txtTen.getText();
        int id = Integer.parseInt(txtID.getText());
        String tdhv=txtTDHV.getText();
        String email=txtEmail.getText();
        String sdt=txtSDT.getText();
        int slsv=Integer.parseInt(txtSLSV.getText());
        GiangVienHD gv= new GiangVienHD(id, tdhv, name, sdt, email, slsv);
        return gv;
    }
    public boolean checkId() {
        int id = Integer.parseInt(txtID.getText().trim());
        for (GiangVienHD g : listGV) {
            if (g.getId()==id) {
                JOptionPane.showMessageDialog(this, "Đã tồn tại sinh viên có mã: " + id);
                return false;
            }
        }
        return true;
    }
    public void loadTableGiangVien() {
        TableGV.setModel(new TableGiangVienHD(listGV));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtSLSV = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        BtnSearch = new javax.swing.JButton();
        BtnAdd = new javax.swing.JButton();
        BtnEdit = new javax.swing.JButton();
        BtnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableGV = new javax.swing.JTable();
        BtnClear = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtTDHV = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        importExcel = new javax.swing.JButton();
        BtnSortbyTen = new javax.swing.JButton();
        BtnSearchBySL = new javax.swing.JButton();
        btnLuuFile = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        trangchu = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 700));

        jLabel1.setText("Tên giảng viên");

        jLabel4.setText("Email");

        jLabel5.setText("Số lượng sinh viên");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTen, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(txtEmail)
                    .addComponent(txtSLSV))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSLSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setText("Tìm kiếm ");

        BtnSearch.setText("Search");
        BtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSearchActionPerformed(evt);
            }
        });

        BtnAdd.setText("Thêm mới");
        BtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAddActionPerformed(evt);
            }
        });

        BtnEdit.setText("Sửa");
        BtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditActionPerformed(evt);
            }
        });

        BtnDelete.setText("Xóa");
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });

        TableGV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã giảng viên", "Trình độ học vấn", "Họ Tên", "SĐT", "Email", "Số lượng SV"
            }
        ));
        TableGV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableGVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableGV);

        BtnClear.setText("Clear");
        BtnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnClearActionPerformed(evt);
            }
        });

        jLabel3.setText("SĐT");

        jLabel6.setText("Trình độ học vấn");

        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        importExcel.setText("Xuất file Excel");
        importExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importExcelActionPerformed(evt);
            }
        });

        BtnSortbyTen.setText("Sắp xếp theo tên");
        BtnSortbyTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSortbyTenActionPerformed(evt);
            }
        });

        BtnSearchBySL.setText("Sắp xếp theo số lượng SV");
        BtnSearchBySL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSearchBySLActionPerformed(evt);
            }
        });

        btnLuuFile.setText("Lưu file .txt");
        btnLuuFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuFileActionPerformed(evt);
            }
        });

        jLabel7.setText("Mã giảng viên");

        txtID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 102));
        jLabel9.setText("Quản lý giảng viên");

        trangchu.setText("Trang chủ");
        trangchu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trangchuMouseClicked(evt);
            }
        });
        jMenuBar1.add(trangchu);

        jMenu2.setText("Refresh");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnSearch)
                .addGap(108, 108, 108)
                .addComponent(BtnSearchBySL)
                .addGap(18, 18, 18)
                .addComponent(BtnSortbyTen, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                            .addComponent(txtID)
                                            .addComponent(txtTDHV)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(BtnAdd)
                                        .addGap(44, 44, 44)
                                        .addComponent(BtnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(BtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49)
                                        .addComponent(BtnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(39, 39, 39)
                                        .addComponent(importExcel)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnLuuFile))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(182, 182, 182)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(392, 392, 392)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(168, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(importExcel)
                            .addComponent(btnLuuFile)))
                    .addComponent(BtnDelete, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtTDHV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BtnAdd, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(BtnEdit, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnSortbyTen)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnSearch)
                    .addComponent(BtnSearchBySL))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void BtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSearchActionPerformed
        ArrayList<GiangVienHD> dstim = new ArrayList<>();
        try {
            for (GiangVienHD a : listGV) {
                if (a.getHoTen().contains(txtSearch.getText().trim())) {
                    dstim.add(a);
                }
            }
            TableGV.setModel(new TableGiangVienHD(dstim));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(QuanLyGiangVien.this, e.toString(), "Error:", JOptionPane.ERROR_MESSAGE);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_BtnSearchActionPerformed

    private void BtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAddActionPerformed
         try {
            GiangVienHD gv = new GiangVienHD(Integer.parseInt(getID().getText()), getTrinhDoHocVan().getText(), getTxtTenGV().getText(), getSDT().getText(), getEmail().getText(), Integer.parseInt(getSLSV().getText()));
            if (!listGV.contains(gv)) {
                listGV.add(gv);
                loadTableGiangVien();
                JOptionPane.showMessageDialog(QuanLyGiangVien.this, "Thêm giảng viên thành công", "", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(QuanLyGiangVien.this, "Giảng viên đã tồn tại", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(QuanLyGiangVien.this, "Lỗi " + e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BtnAddActionPerformed
    Workbook workbook = new XSSFWorkbook(); // tạo mới đối tượng đại diện cho excel.
    Sheet sheet = (Sheet) workbook.createSheet("Giảng_Viên"); // tạo 1 đối tượng sheet, đại diện cho sheet bên trong file Excel
    public void refresh(){
        txtEmail.setText(null);
        txtID.setText(null);
        txtSDT.setText(null);
        txtSLSV.setText(null);
        txtTDHV.setText(null);
        txtTen.setText(null);
    } 
    public JTextField getTxtTenGV() throws Exception {
        if (txtTen.getText().equals("")) {
            throw new Exception("Không được để trống tên giảng viên");
        }
        return txtTen;
    }
    public JTextField getTrinhDoHocVan() throws Exception {
        if (txtTDHV.getText().equals("")) {
            throw new Exception("Không được để trống trình độ học vấn");
        }
        return txtTDHV;
    }
    public JTextField getSDT() throws Exception {
        if (txtSDT.getText().equals("")) {
            throw new Exception("Không được để trống số điện thoại");
        }
   
        if (!txtSDT.getText().startsWith("0") && txtSDT.getText().length()<9) {
            throw new Exception("Số điện thoại phải bắt đầu bằng số 0 và lớn hơn 9 kí tự");
        }
        return txtSDT;
    }
    public JTextField getSLSV() throws Exception {
        if (Integer.parseInt(txtSLSV.getText()) < 0) {
            throw new Exception("Số lượng sinh viên quản lý phải >= 0");
        }
        return txtSLSV;
    }
    public JTextField getID() throws Exception {
        if (Integer.parseInt(txtID.getText()) < 0) {
            throw new Exception("ID phải  >= 0");
        }
        if (txtID.getText().equals("")) {
            throw new Exception("Không được để trống ID");
        }
        return txtID;
    }
    public static boolean isValidEmail(String email) {
        // Mẫu regex để kiểm tra địa chỉ email
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        // Tạo một đối tượng Pattern từ mẫu regex
         Pattern pattern = Pattern.compile(emailPattern);

        // Kiểm tra tính hợp lệ của địa chỉ email
        return pattern.matcher(email).matches();
    }
    public JTextField getEmail() throws Exception{
        if (isValidEmail(txtEmail.getText())==false){
            throw new Exception("Email nhập vào không hợp lệ");
        }
        return txtEmail;
        
    }
     public void xoaGiangVien() {
        int index = TableGV.getSelectedRow();
        if (index >= 0) {
            listGV.remove(index);
            loadTableGiangVien();
            refresh();
            JOptionPane.showMessageDialog(this, "Đã xóa");
        } else {
            JOptionPane.showConfirmDialog(this, "Chọn đối tượng cần xóa");
        }
    }
    private void TableGVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableGVMouseClicked
        // TODO add your handling code here:
        duaDuLieuTuBangLenForm();
    }//GEN-LAST:event_TableGVMouseClicked
    public void duaDuLieuTuBangLenForm() {

        int index = TableGV.getSelectedRow();
        txtTen.setText(listGV.get(index).getHoTen());
        txtEmail.setText(listGV.get(index).getEmail());
        txtID.setText(String.valueOf(listGV.get(index).getId()));
        txtSDT.setText(listGV.get(index).getSdt());
        txtTDHV.setText(listGV.get(index).getTrinhDoHocVan());
        txtSLSV.setText(String.valueOf(listGV.get(index).getSlsv()));
        
    }
    public void suaDuLieu(){
        int index = TableGV.getSelectedRow();
        if (index != -1) {
            try {
                GiangVienHD gv = listGV.get(index);
                GiangVienHD ugv = new GiangVienHD();
                ugv.setId(Integer.parseInt(getID().getText()));
                if (ugv.getId()!=gv.getId()){
                    JOptionPane.showMessageDialog(QuanLyGiangVien.this, "Không thể sửa Mã Giảng Viên", "ERROR", JOptionPane.ERROR_MESSAGE);
                }   
                else {
                    ugv.setId(gv.getId());
                    ugv.setEmail(getEmail().getText() + "");
                    ugv.setHoTen(getTxtTenGV().getText() + "");
                    ugv.setSlsv(Integer.parseInt(getSLSV().getText()));
                    ugv.setTrinhDoHocVan(getTrinhDoHocVan().getText());
                    ugv.setSdt(getSDT().getText());
                    listGV.set(index, ugv);
                    loadTableGiangVien();
                    JOptionPane.showMessageDialog(QuanLyGiangVien.this, "Sửa thành công", "", JOptionPane.INFORMATION_MESSAGE);
                }    
               
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(QuanLyGiangVien.this, "Có lỗi " + e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else
            JOptionPane.showMessageDialog(QuanLyGiangVien.this, "Vui lòng chọn gv muốn sửa", "ERROR", JOptionPane.ERROR_MESSAGE);
        
    }
    private void BtnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnClearActionPerformed
        refresh();
    }//GEN-LAST:event_BtnClearActionPerformed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        xoaGiangVien();        // TODO add your handling code here:
    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditActionPerformed
        suaDuLieu();
    }//GEN-LAST:event_BtnEditActionPerformed

    private void importExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importExcelActionPerformed
        try {
            // TODO add your handling code here:
            XuatFileExcel(TableGV);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }        // TODO add your handling code here:
    }//GEN-LAST:event_importExcelActionPerformed

    private void BtnSortbyTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSortbyTenActionPerformed
        sapXepTen();// TODO add your handling code here:
    }//GEN-LAST:event_BtnSortbyTenActionPerformed

    private void BtnSearchBySLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSearchBySLActionPerformed
        sapXepSLSV();// TODO add your handling code here:
    }//GEN-LAST:event_BtnSearchBySLActionPerformed
    public void ghiFile() {
        if (listGV.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Thêm dữ liệu trước khi ghi");
        } else {
            try {
                db.luuFile("GiangVien_Data", listGV);
                JOptionPane.showMessageDialog(this, "Đã cập nhật file");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    private void btnLuuFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuFileActionPerformed
          listGV.add(docForm());
                loadTableGiangVien();
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                ghiFile();        // TODO add your handling code here:
    }//GEN-LAST:event_btnLuuFileActionPerformed

    private void txtIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDActionPerformed

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void trangchuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trangchuMouseClicked
        // TODO add your handling code here:
         new Admin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_trangchuMouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_jMenu2MouseClicked
     public void XuatFileExcel(JTable table) throws IOException {

        // tạo tên cột 
         Row headerRow = sheet.createRow(0);
        for (int i = 0; i < table.getColumnCount(); i++) {
            Cell headerCell = headerRow.createCell(i);
            headerCell.setCellValue(table.getColumnName(i));
            // tạo font chữ đận cho tên cột 
            org.apache.poi.ss.usermodel.Font font = workbook.createFont();
            //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
            org.apache.poi.ss.usermodel.CellStyle style = workbook.createCellStyle();
            style.setFont(font);
            headerCell.setCellStyle(style);
        }

        // thêm dữ liệu trong jtable vào trong file
        for (int i = 0; i < table.getRowCount(); i++) {
            Row row = sheet.createRow(i + 1);
            for (int j = 0; j < table.getColumnCount(); j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(table.getValueAt(i, j).toString());
            }
        }
        FileOutputStream fileOut = new FileOutputStream("Giang_Vien.xlsx");
        workbook.write(fileOut);
        fileOut.close();
        JOptionPane.showMessageDialog(null, "Đã xuất ra file: Giang_Vien.xlsx");
    }
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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyGiangVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyGiangVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyGiangVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyGiangVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyGiangVien().setVisible(true);
            }
        });
    }
    public void sapXepTen() {
        Collections.sort(listGV, (gv1, gv2) -> (gv1.getTen().compareTo(gv2.getTen())));
        loadTableGiangVien();
    }

    public void sapXepSLSV() {
        Collections.sort(listGV, (gv1, gv2) -> (int) (gv1.getSlsv() - (gv2.getSlsv())));
        loadTableGiangVien();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAdd;
    private javax.swing.JButton BtnClear;
    private javax.swing.JButton BtnDelete;
    private javax.swing.JButton BtnEdit;
    private javax.swing.JButton BtnSearch;
    private javax.swing.JButton BtnSearchBySL;
    private javax.swing.JButton BtnSortbyTen;
    private javax.swing.JTable TableGV;
    private javax.swing.JButton btnLuuFile;
    private javax.swing.JButton importExcel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu trangchu;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSLSV;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTDHV;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
