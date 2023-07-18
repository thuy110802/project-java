package btl_jv;


import java.io.Serializable;
import java.util.Objects;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author NTHT
 */
public class Sinhvien implements Serializable{

    String MaSV;
    private String TenSV, GiaoVienHD,trangThai, nganh, coSoTT;


    public Sinhvien() {
    }

    
    public Sinhvien(String MaSV, String TenSV, String GiaoVienHD, String trangThai, String nganh, String coSoTT) {
        this.MaSV = MaSV;
        this.TenSV = TenSV;
        this.GiaoVienHD = GiaoVienHD;
        this.trangThai = trangThai;
        this.nganh = nganh;
        this.coSoTT = coSoTT;
    }

    public Sinhvien(String MaSV) {
        this.MaSV = MaSV;
    }

    

    

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
    public String getMaSV() {
        return MaSV;
    }

    public void setMaSV(String MaSV) {
        this.MaSV = MaSV;
    }

    public String getTenSV() {
        return TenSV;
    }

    public void setTenSV(String TenSV) {
        this.TenSV = TenSV;
    }

    
    public String getGiaoVienHD() {
        return GiaoVienHD;
    }

    public void setGiaoVienHD(String GiaoVienHD) {
        this.GiaoVienHD = GiaoVienHD;
    }

    public String getNganh() {
        return nganh;
    }

    public void setNganh(String nganh) {
        this.nganh = nganh;
    }

    public String getCoSoTT() {
        return coSoTT;
    }

    public void setCoSoTT(String coSoTT) {
        this.coSoTT = coSoTT;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.MaSV);
        return hash;
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
        final Sinhvien other = (Sinhvien) obj;
        return Objects.equals(this.MaSV, other.MaSV);
    }

    
    
    @Override
    public String toString() {
        return "Sinhvien{" + "MaSV=" + MaSV + ", TenSV=" + TenSV + ", GiaoVienHD=" + GiaoVienHD + ", trangThai=" + trangThai + ", nganh=" + nganh + ", coSoTT=" + coSoTT + '}';
    }
    
}
