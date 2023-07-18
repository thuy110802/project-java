/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package btl_jv;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Admin
 */
public class QLHopDong extends javax.swing.JFrame {

    ArrayList<HopDong> dshd = new ArrayList<>();
    HopDong hd = new HopDong();
    DBEngine doc = new DBEngine();
    String file = "Quan_Ly_hop_dong.txt";
    File fileName = new File("HopDong_Excel.xls");
    int chon = -1;

    void cbxLinhVuc() {
        String linhVuc[] = {"Chuyển giao công nghệ", "Tài trợ học bổng", "Tài trợ trang thiết bị", "Tuyển dụng sinh viên","Tiếp nhận sinh viên thực tập","Tham gia đào tạo với nhà trường", "Cung cấp dịch vụ/ trang thiết bị","Hợp tác nghiên cứu khoa học","Đào tạo nâng cao"};
        cbxLinhVuc.setModel(new DefaultComboBoxModel<>(linhVuc));
    }

    void cbxMucDo() {
        String mucDo[] = {"Mức 1: Có ít chương trình hợp tác và không thường xuyên", "Mức 2: Thường xuyên có chương trình hợp tác", "Mức 3: Có nhiều chương trình hợp tác và thường xuyên"};
        cbxMucDo.setModel(new DefaultComboBoxModel<>(mucDo));
    }

    void cbxLoaiTT() {
        String thucTap[] = {"Thực tập cơ sở ngành", "Thực tập sản xuất", "Thực tập doanh nghiệp", "Trải nghiệm thực tế", "Thực tập tốt nghiệp"};
        cbxLoaiTT.setModel(new DefaultComboBoxModel<>(thucTap));
    }

    void cbxDN() {
        String dn[] = {"Công Ty Cổ Phần Đào Tạo Quản Lý Trực Tuyến Omt",
            "Công ty Cổ phần RikkeiSoft",
            "Công ty TNHH phần mềm FPT",
            "Công ty cổ phần Misa"};
        cbxDoanhNghiep.setModel(new DefaultComboBoxModel<>(dn));
    }

    public void fakeData() {
        HopDong hd1 = new HopDong("HD1", "Quản lý thực tập", "Công ty A", 2022, "CNTT", "Mức 1", "Thực tập cơ sở ngành");
        dshd.add(hd1);
        HopDong hd2 = new HopDong("HD2", "Quản lý thực tập", "Công ty B", 2021, "CNTT", "Mức 2", "Thực tập sản xuất");
        dshd.add(hd2);
        HopDong hd3 = new HopDong("HD3", "Quản lý thực tập", "Công ty C", 2023, "CNTT", "Mức 3", "Thực tập doanh nghiệp");
        dshd.add(hd3);
    }

    public QLHopDong() {
        initComponents();
        cbxLinhVuc();
        cbxMucDo();
        cbxLoaiTT();
        cbxDN();
        fakeData();
        loadTableHD();
        ButtonGroup gr = new ButtonGroup();
        gr.add(jRadioButtonTang);
        gr.add(jRadioButtonGiam);

    }

    public void luuFile() {
        try {
            doc.luuFile(file, dshd);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void docFile() {
        try {
            dshd = (ArrayList) doc.docFile(file);
        } catch (Exception e) {
            System.out.println("Có lỗi: " + e.toString());
        }
    }

    public void loadTableHD() {
        tblHopDong.setModel(new TableHD(dshd));
        luuFile();
    }

    public void close() {
        WindowEvent closeWindow = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(closeWindow);
    }

    public JTextField gettxtMaHD() throws Exception {
        if (txtMaHD.getText().equals("")) {
            throw new Exception("Không được để trống mã hợp đồng!");
        }
        return txtMaHD;
    }

    public JTextField gettxtNam() throws Exception {
        if (txtNam.getText().equals("")) {
            throw new Exception("Không được để trống năm hợp tác!");
        }
        return txtNam;
    }

    public JTextField gettxtTenHopDong() throws Exception {
        if (txtTenHopDong.getText().equals("")) {
            throw new Exception("Không được để trống tên hợp đồng!");
        }
        return txtTenHopDong;
    }

    public JTextField gettxtTimKiem() throws Exception {
        if (txtTimKiem.getText().equals("")) {
            throw new Exception("Vui lòng nhập mã hợp đồng cần tìm!");
        }
        return txtTimKiem;
    }

    //lam viec voi file excel
    //tao 1 doi tuong cho excel
    Workbook workbook = new XSSFWorkbook();
    //tao 1 sheet
    Sheet sheet = (Sheet) workbook.createSheet("HopDong");

    //Excel WBook = new XSSFWorkbook(ExcelFile);
    public void xuatFileExel(JTable table) throws IOException {
        //tao ten cot
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < table.getColumnCount(); i++) {
            Cell headerCell = headerRow.createCell(i);
            headerCell.setCellValue(table.getColumnName(i));

            //tao font chữ đậm
            org.apache.poi.ss.usermodel.Font font = workbook.createFont();
            font.setBold(true);
            //font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

            //tạo font chữ cho CellStyle
            CellStyle style = workbook.createCellStyle();
            style.setFont(font);

            //áp dụng CellStyle cho tên cột
            headerCell.setCellStyle(style);
        }
        //thêm dữ liệu tring jtable vào trong file
        for (int i = 0; i < table.getRowCount(); i++) {
            Row row = sheet.createRow(i + 1);
            for (int j = 0; j < table.getColumnCount(); j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(table.getValueAt(i, j).toString());
            }
        }
        FileOutputStream fos = new FileOutputStream("Hop_Dong.xlsx");
        workbook.write(fos);
        fos.close();
        JOptionPane.showMessageDialog(null, "da xuat file: Hop_Dong.xlsx");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbxDoanhNghiep = new javax.swing.JComboBox<>();
        cbxLoaiTT = new javax.swing.JComboBox<>();
        cbxMucDo = new javax.swing.JComboBox<>();
        cbxLinhVuc = new javax.swing.JComboBox<>();
        txtNam = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtTenHopDong = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnDatLai = new javax.swing.JButton();
        btnXuatFile = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnEnter = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHopDong = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jRadioButtonTang = new javax.swing.JRadioButton();
        jRadioButtonGiam = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        trangChu = new javax.swing.JMenu();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã hợp đồng ", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("QUẢN LÝ HỢP ĐỒNG");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Loại thực tập");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Lĩnh vực hợp tác");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Mức độ hợp tác");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã hợp đồng");

        txtMaHD.setText(" ");
        txtMaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHDActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tên doanh nghiệp");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Năm hợp tác");

        cbxDoanhNghiep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxDoanhNghiep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxDoanhNghiepActionPerformed(evt);
            }
        });

        cbxLoaiTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxMucDo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxLinhVuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Tên hợp đồng");

        txtTenHopDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenHopDongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel12))
                                .addGap(0, 65, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaHD)
                    .addComponent(cbxDoanhNghiep, 0, 169, Short.MAX_VALUE)
                    .addComponent(txtTenHopDong)
                    .addComponent(txtNam))
                .addGap(183, 183, 183)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxMucDo, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxLoaiTT, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxLinhVuc, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbxLinhVuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtTenHopDong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbxDoanhNghiep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cbxMucDo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxLoaiTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnDatLai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDatLai.setText("Đặt lại");
        btnDatLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatLaiActionPerformed(evt);
            }
        });

        btnXuatFile.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXuatFile.setText("Xuất file");
        btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatFileActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Nhập thông tin");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Tìm kiếm");

        btnEnter.setBackground(new java.awt.Color(51, 153, 255));
        btnEnter.setText("Enter");
        btnEnter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnterActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Danh sách thông tin");

        tblHopDong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã hợp đồng", "Doanh nghiệp ", "Năm hợp tác", "Lĩnh vực", "Mức độ", "Loại thực tập"
            }
        ));
        tblHopDong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHopDongMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHopDong);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Sắp xếp");

        jRadioButtonTang.setText("Tăng dần theo năm");
        jRadioButtonTang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTangActionPerformed(evt);
            }
        });

        jRadioButtonGiam.setText("Giảm dần theo năm");
        jRadioButtonGiam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonGiamActionPerformed(evt);
            }
        });

        trangChu.setText("Trang chủ");
        trangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trangChuMouseClicked(evt);
            }
        });
        trangChu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trangChuActionPerformed(evt);
            }
        });
        jMenuBar1.add(trangChu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(385, 385, 385)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel10)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnXuatFile)))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 954, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnEnter)
                                    .addGap(63, 63, 63)
                                    .addComponent(btnThem)
                                    .addGap(68, 68, 68)
                                    .addComponent(btnSua)
                                    .addGap(64, 64, 64)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btnXoa)
                                            .addGap(83, 83, 83)
                                            .addComponent(btnDatLai))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel11)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jRadioButtonTang)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jRadioButtonGiam))))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEnter)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(btnDatLai)
                    .addComponent(btnXuatFile))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jRadioButtonTang)
                    .addComponent(jRadioButtonGiam))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHDActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        try {
            hd = new HopDong(gettxtMaHD().getText(), gettxtTenHopDong().getText(), cbxDoanhNghiep.getSelectedItem().toString(), Integer.parseInt(gettxtNam().getText()), cbxLinhVuc.getSelectedItem().toString(), cbxMucDo.getSelectedItem().toString(), cbxLoaiTT.getSelectedItem().toString());
            if (!dshd.contains(hd)) {
                dshd.add(hd);
                loadTableHD();
                JOptionPane.showMessageDialog(QLHopDong.this, "Thêm hợp đồng thành công", "", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showConfirmDialog(QLHopDong.this, "Thông tin hợp đồng đã tồn tại ", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(QLHopDong.this, "Có lỗi: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void cbxDoanhNghiepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDoanhNghiepActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxDoanhNghiepActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        chon = tblHopDong.getSelectedRow();
        if (chon != -1) {
            try {
                hd = dshd.get(chon);
                HopDong hds = new HopDong();
                String newMaHD = gettxtMaHD().getText() + "";
                hds.setMaHD(newMaHD);
                hds.setNam(Integer.parseInt(gettxtNam().getText()));
                hds.setDoanhnghiep(cbxDoanhNghiep.getSelectedItem().toString());
                hds.setTenHopDong(gettxtTenHopDong().getText() + "");
                hds.setLinhVuc(cbxLinhVuc.getSelectedItem().toString());
                hds.setMucDo(cbxMucDo.getSelectedItem().toString());
                hds.setLoaiThucTap(cbxLoaiTT.getSelectedItem().toString());
                // Check if the newMaHD already exists in the list
                boolean isMaHDExists = dshd.stream().anyMatch(h -> h.getMaHD().equals(newMaHD) && !h.equals(hd));
                if (isMaHDExists) {
                    JOptionPane.showMessageDialog(QLHopDong.this, "Mã hợp đồng đã tồn tại", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    dshd.set(chon, hds);
                    loadTableHD();
                    JOptionPane.showMessageDialog(QLHopDong.this, "Sửa hợp đồng thành công!", "", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(QLHopDong.this, "Có lỗi " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(QLHopDong.this, "Vui lòng chọn hợp đồng muốn sửa", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        try {
            int row = tblHopDong.getSelectedRow();
            if (row == -1) {
                JOptionPane.showMessageDialog(QLHopDong.this, "Vui lòng chọn hợp muốn xóa", "Loi", JOptionPane.ERROR_MESSAGE);
            } else {
                int confirm = JOptionPane.showConfirmDialog(QLHopDong.this, "Bạn có chắc chắn muốn xóa hợp đồng này?", "Error", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    dshd.remove(row);
                    loadTableHD();
                    JOptionPane.showMessageDialog(QLHopDong.this, "Xóa hợp đồng thành công!", "", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Có lỗi: " + e.toString());
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnDatLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatLaiActionPerformed
        // TODO add your handling code here:
        txtMaHD.setText("");
        txtNam.setText("");
        cbxLoaiTT.setSelectedItem(0);
        txtTenHopDong.setText("");
        cbxDoanhNghiep.setSelectedItem(0);
        cbxLinhVuc.setSelectedItem(0);
        cbxMucDo.setSelectedItem(0);
    }//GEN-LAST:event_btnDatLaiActionPerformed

    private void btnXuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatFileActionPerformed
        // TODO add your handling code here:
        try {
            xuatFileExel(tblHopDong);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }//GEN-LAST:event_btnXuatFileActionPerformed

    private void btnEnterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnterActionPerformed
        // TODO add your handling code here:
        ArrayList<HopDong> dstim = new ArrayList<>();
        try {
            for (HopDong hd : dshd) {
                if (gettxtTimKiem().getText().trim().equalsIgnoreCase(hd.getMaHD())) {
                    dstim.add(hd);
                }
            }
            tblHopDong.setModel(new TableHD(dstim));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(QLHopDong.this, "Chưa nhập mã hợp đồng", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEnterActionPerformed

    private void tblHopDongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHopDongMouseClicked
        // TODO add your handling code here:
        chon = tblHopDong.getSelectedRow();
        if (chon != -1) {

            hd = dshd.get(chon);
            txtMaHD.setText(hd.getMaHD() + "");
            txtTenHopDong.setText(hd.getTenHopDong() + "");
            txtNam.setText(hd.getNam() + "");
            cbxLoaiTT.setSelectedItem(hd.getLoaiThucTap());
            cbxDoanhNghiep.setSelectedItem(hd.getDoanhnghiep());
            cbxLinhVuc.setSelectedItem(hd.getLinhVuc());
            cbxMucDo.setSelectedItem(hd.getMucDo());

        }
    }//GEN-LAST:event_tblHopDongMouseClicked

    private void jRadioButtonTangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTangActionPerformed
        // TODO add your handling code here:
        Comparator<HopDong> c = new Comparator<HopDong>() {
            @Override
            public int compare(HopDong o1, HopDong o2) {
      
                return Integer.compare(o1.getNam(), o2.getNam());
            }
        };
        Collections.sort(dshd, c);
        loadTableHD();
    }//GEN-LAST:event_jRadioButtonTangActionPerformed

    private void jRadioButtonGiamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonGiamActionPerformed
        // TODO add your handling code here:
        Comparator<HopDong> c = new Comparator<HopDong>() {
            @Override
            public int compare(HopDong o1, HopDong o2) {
      
                return Integer.compare(o2.getNam(), o1.getNam());
            }
        };
        Collections.sort(dshd, c);
        loadTableHD();
    }//GEN-LAST:event_jRadioButtonGiamActionPerformed

    private void txtTenHopDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenHopDongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenHopDongActionPerformed

    private void txtNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamActionPerformed

    private void trangChuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trangChuActionPerformed
        // TODO add your handling code here:
        new Admin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_trangChuActionPerformed

    private void trangChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trangChuMouseClicked
        // TODO add your handling code here:
        new Admin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_trangChuMouseClicked

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
            java.util.logging.Logger.getLogger(QLHopDong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLHopDong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLHopDong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLHopDong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new QLHopDong().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDatLai;
    private javax.swing.JButton btnEnter;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuatFile;
    private javax.swing.JComboBox<String> cbxDoanhNghiep;
    private javax.swing.JComboBox<String> cbxLinhVuc;
    private javax.swing.JComboBox<String> cbxLoaiTT;
    private javax.swing.JComboBox<String> cbxMucDo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButtonGiam;
    private javax.swing.JRadioButton jRadioButtonTang;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblHopDong;
    private javax.swing.JMenu trangChu;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNam;
    private javax.swing.JTextField txtTenHopDong;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
