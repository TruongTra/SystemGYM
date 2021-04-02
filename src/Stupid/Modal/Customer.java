/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stupid.Modal;

import java.util.Date;

/**
 *
 * @author A
 */
public class Customer {

    private String makh;
    private String hovaten;
    private Date ngaysinh;
    private String gioitinh;
    private String sodienthoai;
    private String socmnd;
    private float donphi;
    private String ghichu;

    private String image;
    private String history;

    public Customer(String makh, String hovaten, Date ngaysinh, String gioitinh, String sodienthoai, String socmnd, float donphi, String ghichu, String image, String history) {
        this.makh = makh;
        this.hovaten = hovaten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.sodienthoai = sodienthoai;
        this.socmnd = socmnd;
        this.donphi = donphi;
        this.ghichu = ghichu;
        this.image = image;
        this.history = history;
    }
  
    

    public Customer() {
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getHovaten() {
        return hovaten;
    }

    public void setHovaten(String hovaten) {
        this.hovaten = hovaten;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public String getSocmnd() {
        return socmnd;
    }

    public void setSocmnd(String socmnd) {
        this.socmnd = socmnd;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

   

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public float getDonphi() {
        return donphi;
    }

    public void setDonphi(float donphi) {
        this.donphi = donphi;
    }
    
    
}
