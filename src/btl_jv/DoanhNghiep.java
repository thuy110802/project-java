package btl_jv;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Đỗ Huy Hoàng
 */
public class DoanhNghiep implements Serializable, Comparable<DoanhNghiep> {
    private String maDN, tenDN, diaChi, nguoiLH, soDT, email, loai;

    public DoanhNghiep() {
    }
    
    public DoanhNghiep(String maDN) {
        this.maDN = maDN;
    }

    public DoanhNghiep(String maDN, String tenDN, String diaChi, String nguoiLH, String soDT, String email, String loai) {
        this.maDN = maDN;
        this.tenDN = tenDN;
        this.diaChi = diaChi;
        this.nguoiLH = nguoiLH;
        this.soDT = soDT;
        this.email = email;
        this.loai = loai;
    }

    public String getMaDN() {
        return maDN;
    }

    public void setMaDN(String maDN) {
        this.maDN = maDN;
    }

    public String getTenDN() {
        return tenDN;
    }

    public void setTenDN(String tenDN) {
        this.tenDN = tenDN;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNguoiLH() {
        return nguoiLH;
    }

    public void setNguoiLH(String nguoiLH) {
        this.nguoiLH = nguoiLH;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.maDN);
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
        final DoanhNghiep other = (DoanhNghiep) obj;
        return Objects.equals(this.maDN, other.maDN);
    }

    @Override
    public String toString() {
        return maDN + "," + tenDN + "," + diaChi + "," + nguoiLH + "," + soDT + "," + email + "," + loai; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public int compareTo(DoanhNghiep o) {
        return maDN.compareToIgnoreCase(o.maDN);
    }
}
