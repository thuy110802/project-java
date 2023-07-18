/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl_jv;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Thuy
 */
public class TableKeHoach extends AbstractTableModel{
    private String name[]={"Tiêu đề","Trạng thái","Ngày bắt đầu","Ngày kết thúc","Hạn đăng ký","Hạn nộp báo cáo","Ngày đi thực tập","Ngày hết thực tập","Nôi dung" };
    private Class classess[]={String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class};
    
    ArrayList<KeHoach> dskh= new ArrayList<>();
    
    public TableKeHoach(ArrayList<KeHoach> ds){
        this.dskh=ds;
    }

    @Override
    public int getRowCount() {
        return dskh.size();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getColumnCount() {
        return name.length;
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return dskh.get(rowIndex).getTieuDe();
            case 1: return dskh.get(rowIndex).getTrangThai();    
            case 2: return dskh.get(rowIndex).getNgayBatDau();
            case 3: return dskh.get(rowIndex).getNgayKetThuc();
            case 4: return dskh.get(rowIndex).getHanDangKy();
            case 5: return dskh.get(rowIndex).getHanNopBC();
            case 6: return dskh.get(rowIndex).getNgayBatDau();
            case 7: return dskh.get(rowIndex).getNgayKetThuc();
            case 8: return dskh.get(rowIndex).getNoidung();
            default:return null;
        }
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public Class getColumnClass(int columnIndex) {
        return classess[columnIndex]; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String getColumnName(int column) {
        return name[column]; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
