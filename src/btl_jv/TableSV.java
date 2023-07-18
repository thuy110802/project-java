package btl_jv;


//import btl_jvtl_jv.Sinhvien;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author NTHT
 */


public class TableSV extends AbstractTableModel{

    private String name []={"Mã sinh viên","Tên sinh viên","Ngành","Giáo viên HD","Cơ sở thực tập","Trạng thái"};
    private Class classes[] = {String.class, String.class, String.class, String.class, String.class, String.class};
    ArrayList<Sinhvien> dssv =new ArrayList<>();
    
    public TableSV(ArrayList<Sinhvien> ds){
        dssv=ds;
    }
    
    @Override
    public int getRowCount() {
        return dssv.size();
    }

    @Override
    public int getColumnCount() {
        return name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:return dssv.get(rowIndex).getMaSV();
            case 1:return dssv.get(rowIndex).getTenSV();
            case 2:return dssv.get(rowIndex).getNganh();
            case 3:return dssv.get(rowIndex).getGiaoVienHD();
            case 4:return dssv.get(rowIndex).getCoSoTT();
            case 5:return dssv.get(rowIndex).getTrangThai();
            default:
                return null;
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Class getColumnClass(int columnIndex) {
        return classes[columnIndex]; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    
    @Override
    public String getColumnName(int column) {
        return name[column]; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    
}
