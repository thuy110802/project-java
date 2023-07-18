/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl_jv;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Admin
 */
public class TableHD extends AbstractTableModel{
    private String name []={"Mã hợp đồng", "Tên hợp đồng", "Doanh nghiệp","Năm", "Lĩnh vực", "Mức độ","Loại thực tập"};
    private Class classes[] = {String.class, String.class,String.class, int.class, String.class, String.class, String.class};
    ArrayList<HopDong> dshd =new ArrayList<>();
    
    public TableHD(ArrayList<HopDong> ds){
        dshd=ds;
    }


    @Override
    public int getRowCount() {
        return dshd.size();
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
            case 0:return dshd.get(rowIndex).getMaHD();
            case 1:return dshd.get(rowIndex).getTenHopDong();
            case 2:return dshd.get(rowIndex).getDoanhnghiep();
            case 3:return dshd.get(rowIndex).getNam();
            case 4:return dshd.get(rowIndex).getLinhVuc();
            case 5:return dshd.get(rowIndex).getMucDo();
            case 6:return dshd.get(rowIndex).getLoaiThucTap();
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
