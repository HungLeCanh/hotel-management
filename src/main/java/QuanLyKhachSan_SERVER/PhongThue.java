/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QuanLyKhachSan_SERVER;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author LE CANH HUNG
 */
public class PhongThue implements Serializable{
    private int soPhong;
    private String trangThai; // "Trống" hoặc "Có khách"
    private String tenKhachHang;
    private String soCMND;
    private LocalDate thoiGianCheckIn;
    private LocalDate thoiGianCheckOut;

    public PhongThue() {
    }

    
    public PhongThue(int soPhong, String trangThai, String tenKhachHang, String soCMND, LocalDate thoiGianCheckIn, LocalDate thoiGianCheckOut) {
        this.soPhong = soPhong;
        this.trangThai = trangThai;
        this.tenKhachHang = tenKhachHang;
        this.soCMND = soCMND;
        this.thoiGianCheckIn = thoiGianCheckIn;
        this.thoiGianCheckOut = thoiGianCheckOut;
    }

    public int getSoPhong() {
        return soPhong;
    }

    public void setSoPhong(int soPhong) {
        this.soPhong = soPhong;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }

    public LocalDate getThoiGianCheckIn() {
        return thoiGianCheckIn;
    }

    public void setThoiGianCheckIn(LocalDate thoiGianCheckIn) {
        this.thoiGianCheckIn = thoiGianCheckIn;
    }

    public LocalDate getThoiGianCheckOut() {
        return thoiGianCheckOut;
    }

    public void setThoiGianCheckOut(LocalDate thoiGianCheckOut) {
        this.thoiGianCheckOut = thoiGianCheckOut;
    }

    @Override
    public String toString() {
        return "PhongThue{" + "soPhong=" + soPhong + ", trangThai=" + trangThai + ", tenKhachHang=" + tenKhachHang + ", soCMND=" + soCMND + ", thoiGianCheckIn=" + thoiGianCheckIn + ", thoiGianCheckOut=" + thoiGianCheckOut + '}';
    }
    
    
}
