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
 * @author Ngo Manh Hung
 */
public class TableGiangVienHD extends AbstractTableModel implements Serializable{
     private String name[] = {"Mã giảng viên","Trình độ học vấn","Họ tên","SĐT","Email","Số lượng Sinh viên"};
    
     private Class classes[] = {Integer.class,String.class,String.class,String.class,String.class,Integer.class};
   
    ArrayList<GiangVienHD> listGV = new ArrayList<>();


    public TableGiangVienHD(ArrayList<GiangVienHD> gvhd) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        listGV = gvhd;
    }
        
    @Override
    public int getRowCount() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return listGV.size();
    }

    @Override
    public int getColumnCount() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return name.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        switch(columnIndex){
            case 0: return listGV.get(rowIndex).getId();
            case 1: return listGV.get(rowIndex).getTrinhDoHocVan();
            case 2: return listGV.get(rowIndex).getHoTen();        
            case 3: return listGV.get(rowIndex).getSdt();    
            case 4: return listGV.get(rowIndex).getEmail();      
            case 5: return listGV.get(rowIndex).getSlsv();
            default : return null;
        }
    }
    
    @Override
    public Class getColumnClass(int columnIndex)
    {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int column)
    {
        return name[column];
    }
}
