/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package btl_jv;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Thuy
 */
public class KeHoach implements Serializable{
    String tieuDe, trangThai, ngayBatDau, ngayKetThuc, hanDangKy, 
            hanNopBC, ngayDiTT, ngayHetTT, noidung;
    public KeHoach(){
        
    }
    
    public KeHoach(String tieuDe){
        this.tieuDe=tieuDe;
    }

    public KeHoach(String tieuDe, String trangThai, String ngayBatDau, 
            String ngayKetThuc, String hanDangKy, String hanNopBC, 
            String ngayDiTT, String ngayHetTT, String noidung) {
            
        this.tieuDe = tieuDe;
        this.trangThai=trangThai;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.hanDangKy = hanDangKy;
        this.hanNopBC = hanNopBC;
        this.ngayDiTT = ngayDiTT;
        this.ngayHetTT = ngayHetTT;
        this.noidung = noidung;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    
    
    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getHanDangKy() {
        return hanDangKy;
    }

    public void setHanDangKy(String hanDangKy) {
        this.hanDangKy = hanDangKy;
    }

    public String getHanNopBC() {
        return hanNopBC;
    }

    public void setHanNopBC(String hanNopBC) {
        this.hanNopBC = hanNopBC;
    }

    public String getNgayDiTT() {
        return ngayDiTT;
    }

    public void setNgayDiTT(String ngayDiTT) {
        this.ngayDiTT = ngayDiTT;
    }

    public String getNgayHetTT() {
        return ngayHetTT;
    }

    public void setNgayHetTT(String ngayHetTT) {
        this.ngayHetTT = ngayHetTT;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.tieuDe);
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
        final KeHoach other = (KeHoach) obj;
        return Objects.equals(this.tieuDe, other.tieuDe);
    }
    
    
    
}

