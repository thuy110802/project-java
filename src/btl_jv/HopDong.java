/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl_jv;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Admin
 */
public class HopDong implements Serializable {

    private String maHD, tenHopDong, doanhnghiep, linhVuc, mucDo, loaiThucTap;
    private int nam;
    

    public HopDong() {
    }

    public HopDong(String maHD, String tenHopDong, String doanhnghiep, int nam, String linhVuc, String mucDo, String loaiThucTap) {
        
        this.maHD = maHD;
        this.tenHopDong = tenHopDong;
        this.doanhnghiep = doanhnghiep;
        this.nam = nam;
        this.linhVuc = linhVuc;
        this.mucDo = mucDo;
        this.loaiThucTap = loaiThucTap;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getDoanhnghiep() {
        return doanhnghiep;
    }

    public void setDoanhnghiep(String doanhnghiep) {
        this.doanhnghiep = doanhnghiep;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public String getLinhVuc() {
        return linhVuc;
    }

    public void setLinhVuc(String linhVuc) {
        this.linhVuc = linhVuc;
    }

    public String getMucDo() {
        return mucDo;
    }

    public void setMucDo(String mucDo) {
        this.mucDo = mucDo;
    }

    public String getLoaiThucTap() {
        return loaiThucTap;
    }

    public void setLoaiThucTap(String loaiThucTap) {
        this.loaiThucTap = loaiThucTap;
    }

    public String getTenHopDong() {
        return tenHopDong;
    }

    public void setTenHopDong(String tenHopDong) {
        this.tenHopDong = tenHopDong;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.maHD);
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
        final HopDong other = (HopDong) obj;
        return Objects.equals(this.maHD, other.maHD);
    }

    @Override
    public String toString() {
        return "HopDong{" + "maHD=" + maHD + ", tenHopDong=" + tenHopDong + ", doanhnghiep=" + doanhnghiep + ", nam=" + nam + ", linhVuc=" + linhVuc + ", mucDo=" + mucDo + ", loaiThucTap=" + loaiThucTap + '}';
    }

    

}
