/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package btl_jv;

import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.sort;
import java.util.Comparator;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Thuy
 */
public class QuanLyKeHoach extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyKeHoach
     */
    DBEngine db = new DBEngine();
    String fName = "KeHoach.txt";
    ArrayList<KeHoach> dskh= new ArrayList<>();
    int dongchon = -1;
    KeHoach kh= new KeHoach();
    
    public void fakeData(){
        KeHoach kh1= new KeHoach("Thực tập tốt nghiệp Đại học Khóa 13 HK2 2020-2021","Đã kết thúc",
                "11-1-2021","20-3-2021","18-1-2021","13-3-2021","15-1-2021",
                "28-2-2021","▪ Từ ngày 10/01/2022 đến 14/01/2022 SV liên hệ với GVDH để nhận đề tài TTTN\n" +
            "▪ Từ 17/01/2020 đến 22/01/2021: Giáo viên hướng dẫn gửi danh sách đề \n" +
            "tài (bản mềm) về khoa cho đồng chí Huệ và nộp phiếu giao đề tài về VP Khoa để duyệt.\n");
        dskh.add(kh1);
        
        KeHoach kh2= new KeHoach("Thực tập tốt nghiệp Đại học Khóa 14 HK2 2018-2019","Đã kết thúc",
                "10-1-2019","19-3-2019","17-1-2019","11-3-2019","14-1-2019",
                "28-2-2019","▪ Từ ngày 10/01/2019 đến 17/01/2019 SV liên hệ với Công ty để nhận \n" +
            "nhiệm vụ và cung cấp thông tin liên hệ để phối hợp hướng dẫn của doanh nghiệp cho GVHD.\n" +           
            "▪ Từ 10/01/2019 đến 22/01/2019: GVHD liên hệ với doanh nghiệp để nắm \n" +
            "bắt thông tin thực tập của sinh viên và đưa ra yêu cầu của học phần (theo \n" +
            "đề cương) để doanh nghiệp phối hợp giao nhiệm vụ và cùng hướng dẫn SV thực hiện.\n");
        dskh.add(kh2);
 
        KeHoach kh3= new KeHoach("Thực tập tốt nghiệp Đại học Khóa 15 HK2 2023-2024","Chưa diễn ra",
                "9-1-2024","20-3-2024","16-1-2024","11-3-2024","13-1-2024",
                "27-2-2024","▪ Từ ngày 10/01/2024 đến 17/01/2024 SV liên hệ với Công ty để nhận \n" +
            "nhiệm vụ và cung cấp thông tin liên hệ để phối hợp hướng dẫn của doanh nghiệp cho GVHD.\n" +           
            "▪ Từ 10/01/2024 đến 22/01/2024: GVHD liên hệ với doanh nghiệp để nắm \n" +
            "bắt thông tin thực tập của sinh viên và đưa ra yêu cầu của học phần (theo \n" +
            "đề cương) để doanh nghiệp phối hợp giao nhiệm vụ và cùng hướng dẫn SV thực hiện.\n");
        dskh.add(kh3);
        
        KeHoach kh4= new KeHoach("Thực tập tốt nghiệp Đại học Khóa 16 HK2 2022-2023","Đang diễn ra",
                "11-1-2023","20-3-2023","17-1-2023","12-3-2023","16-1-2023",
                "28-2-2023","▪ Từ ngày 10/01/2023 đến 17/01/2023 SV liên hệ với Công ty để nhận \n" +
            "nhiệm vụ và cung cấp thông tin liên hệ để phối hợp hướng dẫn của doanh nghiệp cho GVHD.\n" +           
            "▪ Từ 10/01/2023 đến 22/01/2023: GVHD liên hệ với doanh nghiệp để nắm \n" +
            "bắt thông tin thực tập của sinh viên và đưa ra yêu cầu của học phần (theo \n" +
            "đề cương) để doanh nghiệp phối hợp giao nhiệm vụ và cùng hướng dẫn SV thực hiện.\n");
        dskh.add(kh4);
        
        KeHoach kh5= new KeHoach("Thực tập tốt nghiệp Đại học Khóa 12 HK2 2019-2020","Đã kết thúc",
                "11-1-2020","20-3-2020","17-1-2020","12-3-2020","15-1-2020",
                "28-2-2020","▪ Từ ngày 10/01/2020 đến 17/01/2020 SV liên hệ với Công ty để nhận \n" +
            "nhiệm vụ và cung cấp thông tin liên hệ để phối hợp hướng dẫn của doanh nghiệp cho GVHD.\n" +           
            "▪ Từ 10/01/2020 đến 22/01/2020: GVHD liên hệ với doanh nghiệp để nắm \n" +
            "bắt thông tin thực tập của sinh viên và đưa ra yêu cầu của học phần (theo \n" +
            "đề cương) để doanh nghiệp phối hợp giao nhiệm vụ và cùng hướng dẫn SV thực hiện.\n");
        dskh.add(kh5);
    }
    public QuanLyKeHoach() {
        initComponents();
        fakeData();
        LoadTableKH(dskh);
        iniTrangThai();
        ButtonGroup gr = new ButtonGroup();
        gr.add(radDang);
        gr.add(radChua);
        gr.add(radDa);
    }
    
    private void LoadTableKH(ArrayList<KeHoach> dskh){
        bangKeHoach.setModel(new TableKeHoach(dskh));
    }
    
    public void luuFile(java.awt.event.ActionEvent evt) {
        try {
            db.luuFile(fName, dskh);            
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public void docFile(java.awt.event.ActionEvent evt) {        
        try {
            dskh = (ArrayList) db.docFile(fName);
        } catch (Exception e) {
            System.out.println("Có lỗi: " + e.toString());
        }        
    }
    
    public JTextField getTxtTieuDe() throws Exception {
        if (txtTieuDe.getText().equals("")) {
            throw new Exception("Không được để trống mã sản phẩm");
        }
        return txtTieuDe;
    }
    
    private void iniTrangThai(){
        String[] ten= new String[]{"Đang diễn ra","Đã kết thúc","Chưa diễn ra"};
        DefaultComboBoxModel<String> cbxTT= new DefaultComboBoxModel<>(ten);
        cbxTrangThai.setModel(cbxTT);
    }
    
    public JTextArea getTxtNoiDung() throws Exception {
        if (txtNoiDung.getText().equals("")) {
            throw new Exception("Không được để trống nội dung");
        }
        return txtNoiDung;
    }
    
    private String iniNgayBD() throws IllegalArgumentException{
        //Lấy giá trị ngày tháng từ thành phần 'txtDate'
        Date date= txtNgayBD.getDate();
        if(date == null){
            throw new IllegalArgumentException("Không để trống ngày tháng");
        }
        //Khởi tạo 1 đối tượng với mẫu ngày tháng "dd-MM-yyyy"
        SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
        //Chuyển đối giá trị "date" thành chuỗi theo định dạng "dd-MM-yyyy"
        String dateString = sdf.format(date);
        //trả về chuỗi ngày tháng 
        return dateString;
    }
    
    private String iniNgayKT()throws IllegalArgumentException{      
        Date date= txtNgayKT.getDate();
        if(date == null) throw new IllegalArgumentException("Không để trống ngày tháng");  
        SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
        String dateString = sdf.format(date);
        return dateString;
    }
    
    private String iniHanDK()throws IllegalArgumentException{      
        Date date= txtHanDK.getDate();
        if(date == null){
            throw new IllegalArgumentException("Không để trống ngày tháng");
        }
        SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
        String dateString = sdf.format(date);
        return dateString;
    }
    
    private String iniHanNop()throws IllegalArgumentException{      
        Date date= txtHanNop.getDate();
        if(date == null){
            throw new IllegalArgumentException("Không để trống ngày tháng");
        }
        SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
        String dateString = sdf.format(date);
        return dateString;
    }
    
    private String iniNgayDi()throws IllegalArgumentException{      
        Date date= txtNgayDi.getDate();
        if(date == null){
            throw new IllegalArgumentException("Không để trống ngày tháng");
        }
        SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
        String dateString = sdf.format(date);
        return dateString;
    }
    
    private String iniNgayHet()throws IllegalArgumentException{      
        Date date= txtNgayHet.getDate();
        if(date == null){
            throw new IllegalArgumentException("Không để trống ngày tháng");
        }
        SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");
        String dateString = sdf.format(date);
        return dateString;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTieuDe = new javax.swing.JTextField();
        txtNgayBD = new com.toedter.calendar.JDateChooser();
        txtNgayKT = new com.toedter.calendar.JDateChooser();
        cbxTrangThai = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtHanDK = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        txtHanNop = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        txtNgayDi = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        txtNgayHet = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtNoiDung = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        btnReset = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnTim = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        radDang = new javax.swing.JRadioButton();
        radChua = new javax.swing.JRadioButton();
        butdoc = new javax.swing.JButton();
        butghi = new javax.swing.JButton();
        radDa = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bangKeHoach = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        trangChu = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý kế hoạch");
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Quản lý kế hoạch");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tiêu đề:");
        jLabel2.setMaximumSize(new java.awt.Dimension(85, 17));
        jLabel2.setMinimumSize(new java.awt.Dimension(85, 17));
        jLabel2.setPreferredSize(new java.awt.Dimension(85, 17));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Từ ngày:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Trạng thái:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Đến ngày:");

        txtTieuDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTieuDeActionPerformed(evt);
            }
        });

        txtNgayBD.setDateFormatString("dd-MM-yyyy");

        txtNgayKT.setDateFormatString("dd-MM-yyyy");

        cbxTrangThai.setPreferredSize(new java.awt.Dimension(244, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Hạn đăng ký:");

        txtHanDK.setDateFormatString("dd-MM-yyyy");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Hạn nộp báo cáo:");

        txtHanNop.setDateFormatString("dd-MM-yyyy");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Ngày đi thực tập:");

        txtNgayDi.setDateFormatString("dd-MM-yyyy");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Ngày hết thực tập:");

        txtNgayHet.setDateFormatString("dd-MM-yyyy");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Nội dung:");

        txtNoiDung.setColumns(20);
        txtNoiDung.setRows(5);
        jScrollPane3.setViewportView(txtNoiDung);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtNgayDi, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addComponent(txtHanDK, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(64, 64, 64)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTieuDe)
                                    .addComponent(txtNgayBD, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))))
                        .addGap(94, 94, 94)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNgayHet, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNgayKT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbxTrangThai, 0, 286, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtHanNop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jScrollPane3)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtTieuDe, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNgayBD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNgayKT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtHanDK, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                    .addComponent(txtHanNop, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNgayDi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNgayHet, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        btnReset.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Tìm kiếm:");

        btnTim.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Lọc:");

        radDang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radDang.setText("Đang diễn ra");
        radDang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radDangActionPerformed(evt);
            }
        });

        radChua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radChua.setText("Chưa diễn ra");
        radChua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radChuaActionPerformed(evt);
            }
        });

        butdoc.setText("Đọc file");
        butdoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butdocActionPerformed(evt);
            }
        });

        butghi.setText("Ghi file");
        butghi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butghiActionPerformed(evt);
            }
        });

        radDa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radDa.setText("Đã kết thúc");
        radDa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radDaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radChua)
                        .addGap(18, 18, 18)
                        .addComponent(radDang)
                        .addGap(18, 18, 18)
                        .addComponent(radDa, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(butdoc, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(butghi, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(150, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa)
                    .addComponent(butdoc)
                    .addComponent(butghi))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(btnTim)
                    .addComponent(radChua)
                    .addComponent(radDang)
                    .addComponent(radDa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bangKeHoach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        bangKeHoach.setRowHeight(50);
        bangKeHoach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bangKeHoachMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(bangKeHoach);

        trangChu.setText("Trang chủ");
        trangChu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trangChuMouseClicked(evt);
            }
        });
        jMenuBar1.add(trangChu);

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(391, 391, 391))
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTieuDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTieuDeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTieuDeActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtTieuDe.setText("");
        cbxTrangThai.setSelectedIndex(0);
        txtNgayBD.setDate(null);
        txtNgayKT.setDate(null);
        txtHanDK.setDate(null);
        txtHanNop.setDate(null);
        txtNgayDi.setDate(null);
        txtNgayHet.setDate(null);
        txtNoiDung.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
         try {
            kh= new KeHoach(getTxtTieuDe().getText(),cbxTrangThai.getSelectedItem().toString(),iniNgayBD(),iniNgayKT(),iniHanDK(),iniHanNop(),iniNgayDi(),iniNgayHet(),getTxtNoiDung().getText());
            if(!dskh.contains(kh)){
                dskh.add(kh);
                LoadTableKH(dskh);
                JOptionPane.showMessageDialog(QuanLyKeHoach.this, "Thêm kế hoạch thành công", "", JOptionPane.INFORMATION_MESSAGE);
            }else {
                JOptionPane.showMessageDialog(QuanLyKeHoach.this, "Kế hoạch đã tồn tại", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
         } catch (Exception e) {
             JOptionPane.showMessageDialog(QuanLyKeHoach.this, "Lỗi " + e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }                                        
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        dongchon = bangKeHoach.getSelectedRow();
        if(dongchon != -1){
            try {
                kh= new KeHoach(getTxtTieuDe().getText(),cbxTrangThai.getSelectedItem().toString()
                        ,iniNgayBD(),iniNgayKT(),iniHanDK(),iniHanNop(),
                        iniNgayDi(),iniNgayHet(),getTxtNoiDung().getText());
                dskh.set(dongchon, kh);
                JOptionPane.showMessageDialog(this, "Sua thanh cong",
                        "Thong bao",JOptionPane.WIDTH);
                LoadTableKH(dskh);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.toString());
            }
         } else
            JOptionPane.showMessageDialog(QuanLyKeHoach.this, "Vui lòng chọn sản phẩm muốn sửa",
                    "ERROR", JOptionPane.ERROR_MESSAGE);        
    }//GEN-LAST:event_btnSuaActionPerformed
    
     
    private void bangKeHoachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bangKeHoachMouseClicked
        // TODO add your handling code here:
        dongchon= bangKeHoach.getSelectedRow();
        if(dongchon != -1){
            kh= dskh.get(dongchon);
            txtTieuDe.setText(kh.getTieuDe());
            cbxTrangThai.setSelectedItem(kh.getTrangThai());
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");    
            String ngayBatDau = kh.getNgayBatDau();               
            try {
                 Date dateNgayBatDau = sdf.parse(ngayBatDau);
                 txtNgayBD.setDate(dateNgayBatDau);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Lỗi: Không thể chuyển đổi ngày", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
              
            String ngayKetThuc = kh.getNgayKetThuc();               
            try {
                 Date dateNgayKetThuc = sdf.parse(ngayKetThuc);
                 txtNgayKT.setDate(dateNgayKetThuc);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Lỗi: Không thể chuyển đổi ngày", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            
            String hanDangKi = kh.getHanDangKy();               
            try {
                 Date dateHanDangki = sdf.parse(hanDangKi);
                 txtHanDK.setDate(dateHanDangki);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Lỗi: Không thể chuyển đổi ngày", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            String hanNopBC = kh.getHanNopBC();               
            try {
                 Date datehanNopBC = sdf.parse(hanNopBC);
                 txtHanNop.setDate(datehanNopBC);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Lỗi: Không thể chuyển đổi ngày", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            String ngayDi = kh.getNgayDiTT();               
            try {
                 Date dateNgayDi = sdf.parse(ngayDi);
                 txtNgayDi.setDate(dateNgayDi);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Lỗi: Không thể chuyển đổi ngày", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }
            String ngayNgayHet= kh.getNgayHetTT();               
            try {
                 Date dateNgayHet = sdf.parse(ngayNgayHet);
                 txtNgayHet.setDate(dateNgayHet);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Lỗi: Không thể chuyển đổi ngày", "Lỗi", JOptionPane.ERROR_MESSAGE);
            } 
            
            txtNoiDung.setText(kh.getNoidung());
        }
    }//GEN-LAST:event_bangKeHoachMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        try {
            int hang= bangKeHoach.getSelectedRow();
            if(hang == -1){
                JOptionPane.showMessageDialog(QuanLyKeHoach.this, 
                        "Vui lòng chọn kế hoạch muốn xóa", "Lỗi", JOptionPane.ERROR_MESSAGE);
            }else{
                int xacNhan= JOptionPane.showConfirmDialog(QuanLyKeHoach.this,
                        "Bạn có chắc muốn xóa sản phẩm này?",
                        "Xác nhận",
                        JOptionPane.YES_NO_OPTION);
            
            if ( xacNhan== JOptionPane.YES_OPTION) {
                    dskh.remove(hang);
                    LoadTableKH(dskh);
                    JOptionPane.showMessageDialog(QuanLyKeHoach.this, 
                            "Xóa kế hoạch thành công", "", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (Exception e) {
           JOptionPane.showMessageDialog(null, "Error: " + e.toString());
        }               
    }//GEN-LAST:event_btnXoaActionPerformed

    public JTextField getTxtTimKiem() throws Exception {
        if (txtTimKiem.getText().equals("")) {
            throw new Exception("Nhập tiêu đề cần tìm");
        }
        return txtTimKiem;
    }
    
    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        // TODO add your handling code here:
        ArrayList<KeHoach> dstim = new ArrayList<>();
        try {
            String tieuDe= getTxtTimKiem().getText();
            KeHoach k= new KeHoach(tieuDe);
            if(dskh.contains(k)){
                for(KeHoach s: dskh){
                    if(s.getTieuDe().equals(tieuDe)){
                        dstim.add(s);
                        bangKeHoach.setModel(new TableKeHoach(dstim));
                        txtTimKiem.setText("");
                    }
                }
            }else{            
                JOptionPane.showMessageDialog(this,
                     "Kế hoạch không tồn tại!", "Thông báo", WIDTH);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.toString(), "Thong bao", 0);            
        }
    }//GEN-LAST:event_btnTimActionPerformed


    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        // TODO add your handling code here:
        LoadTableKH(dskh);
        txtTieuDe.setText("");
        cbxTrangThai.setSelectedIndex(-1);
        txtNgayBD.setDate(null);
        txtNgayKT.setDate(null);
        txtHanDK.setDate(null);
        txtHanNop.setDate(null);
        txtNgayDi.setDate(null);
        txtNgayHet.setDate(null);
        txtNoiDung.setText(null);
    }//GEN-LAST:event_jMenu2MouseClicked

    private void trangChuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trangChuMouseClicked
        // TODO add your handling code here:
        new Admin().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_trangChuMouseClicked

    private void butdocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butdocActionPerformed
        // TODO add your handling code here:
        ArrayList<KeHoach> kh= null;
        try {
            kh = (ArrayList<KeHoach>) db.docFile(fName);
        } catch (Exception e) {
            System.out.println("Có lỗi: " + e.toString());
        }
        LoadTableKH(kh);
    }//GEN-LAST:event_butdocActionPerformed

    private void butghiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butghiActionPerformed
        // TODO add your handling code here:
        try {
            db.luuFile(fName, dskh);
            JOptionPane.showMessageDialog(QuanLyKeHoach.this, "Ghi vào file thành công", "", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }       
    }//GEN-LAST:event_butghiActionPerformed

    private void radDangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radDangActionPerformed
        // TODO add your handling code here:
        ArrayList<KeHoach> danhSachDangDienRa = new ArrayList<>();
        for (KeHoach kh : dskh) {
            if (kh.getTrangThai().equals("Đang diễn ra")) {
                danhSachDangDienRa.add(kh);
            }
        }
    
        // Hiển thị danh sách kết quả
        LoadTableKH(danhSachDangDienRa);
    }//GEN-LAST:event_radDangActionPerformed

    private void radChuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radChuaActionPerformed
        /// TODO add your handling code here:
            ArrayList<KeHoach> danhSachChuaDienRa = new ArrayList<>();
            for (KeHoach kh : dskh) {
                if (kh.getTrangThai().equals("Chưa diễn ra")) {
                    danhSachChuaDienRa.add(kh);
                }
            }
    
            // Hiển thị danh sách kết quả
            LoadTableKH(danhSachChuaDienRa);
    }//GEN-LAST:event_radChuaActionPerformed

    private void radDaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radDaActionPerformed
        // TODO add your handling code here:
        ArrayList<KeHoach> danhSachDaDienRa = new ArrayList<>();
            for (KeHoach kh : dskh) {
                if (kh.getTrangThai().equals("Đã kết thúc")) {
                    danhSachDaDienRa.add(kh);
                }
            }
    
            // Hiển thị danh sách kết quả
            LoadTableKH(danhSachDaDienRa);
    }//GEN-LAST:event_radDaActionPerformed

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
            java.util.logging.Logger.getLogger(QuanLyKeHoach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyKeHoach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyKeHoach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyKeHoach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyKeHoach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable bangKeHoach;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton butdoc;
    private javax.swing.JButton butghi;
    private javax.swing.JComboBox<String> cbxTrangThai;
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
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JRadioButton radChua;
    private javax.swing.JRadioButton radDa;
    private javax.swing.JRadioButton radDang;
    private javax.swing.JMenu trangChu;
    private com.toedter.calendar.JDateChooser txtHanDK;
    private com.toedter.calendar.JDateChooser txtHanNop;
    private com.toedter.calendar.JDateChooser txtNgayBD;
    private com.toedter.calendar.JDateChooser txtNgayDi;
    private com.toedter.calendar.JDateChooser txtNgayHet;
    private com.toedter.calendar.JDateChooser txtNgayKT;
    private javax.swing.JTextArea txtNoiDung;
    private javax.swing.JTextField txtTieuDe;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
