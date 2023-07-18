package btl_jv;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Acer
 */
public class TableDN extends AbstractTableModel{
    private String[] ten = {"STT", "Mã doanh nghiệp", "Tên doanh nghiệp", "Địa chỉ", "Người liên hệ", "SĐT", "Email", "Loại thực tập"};
    private Class[] lop = {int.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class};
    ArrayList<DoanhNghiep> dsDN = new ArrayList<DoanhNghiep>();
    
    public TableDN(ArrayList<DoanhNghiep> dn) {
        dsDN = dn;
    }
    
    @Override
    public int getRowCount() {
        return dsDN.size();
    }
    
    @Override
    public int getColumnCount() {
        return ten.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: return rowIndex + 1;
            
            case 1: return dsDN.get(rowIndex).getMaDN();
            
            case 2: return dsDN.get(rowIndex).getTenDN();
            
            case 3: return dsDN.get(rowIndex).getDiaChi();
            
            case 4: return dsDN.get(rowIndex).getNguoiLH();
            
            case 5: return dsDN.get(rowIndex).getSoDT();
            
            case 6: return dsDN.get(rowIndex).getEmail();
            
            case 7: return dsDN.get(rowIndex).getLoai();
            
            default: return null;
//                throw new AssertionError();
        }
    }
    @Override
    public Class getColumnClass(int columnIndex) {
        return lop[columnIndex];
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return ten[columnIndex];
    }
}

