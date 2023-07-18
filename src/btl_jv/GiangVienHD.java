/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl_jv;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Ngo Manh Hung
 */
public class GiangVienHD implements Serializable{
    private int id;
    private String trinhDoHocVan;
    private String hoTen;
    private String sdt;
    private String email;
    private int slsv;

    public GiangVienHD() {
        this.id = 0;
        this.trinhDoHocVan = "";
        this.hoTen = "";
        this.sdt = "";
        this.email = "";
        this.slsv = 0;
    }

    public GiangVienHD(int id, String trinhDoHocVan, String hoTen, String sdt, String email, int slsv) {
        this.id = id;
        this.trinhDoHocVan = trinhDoHocVan;
        this.hoTen = hoTen;
        this.sdt = sdt;
        this.email = email;
        this.slsv = slsv;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTrinhDoHocVan() {
        return trinhDoHocVan;
    }

    public void setTrinhDoHocVan(String trinhDoHocVan) {
        this.trinhDoHocVan = trinhDoHocVan;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSlsv() {
        return slsv;
    }
    public String getTen(){
       String[] tu=this.hoTen.split(" ");
       return tu[tu.length-1];
    }
    public void setSlsv(int slsv) {
        this.slsv = slsv;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GiangVienHD other = (GiangVienHD) obj;
        return Objects.equals(this.id, other.id);
    }
    
    
}
