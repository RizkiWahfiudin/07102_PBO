/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.*;
import java.util.Date;

public class Muhammad07102_PasienController implements Muhammad07102_ControllerInterface {
    int indexLogin = 0;
    
    public Muhammad07102_PasienController() {
    }
    
    public int view() {
        return Muhammad07102_AllObjectModel.pasienModel.viewAll();
    }
    
    public Muhammad07102_PasienEntity getData(int index) {
        return Muhammad07102_AllObjectModel.pasienModel.showDataPasien(index);
    }
    
    public void insert(int nik,String nama,String pass,Date tanggal,String alamat,int jenisKelamin,int noTelp) {
        Muhammad07102_PasienEntity pasien = new Muhammad07102_PasienEntity();
        pasien.setNik(nik);
        pasien.setNama(nama);
        pasien.setPassword(pass);
        pasien.setTglLahir(tanggal);
        pasien.setAlamat(alamat);
        pasien.setJenisKelamin(jenisKelamin);
        pasien.setNoTelp(noTelp);
        Muhammad07102_AllObjectModel.pasienModel.insertPasien(pasien);
    }
    
    public void update(int isData,int nik,String nama,String pass,Date tanggal,String alamat,int jenisKelamin,int noTelp) {
        Muhammad07102_PasienEntity pasien = new Muhammad07102_PasienEntity();
        pasien.setNik(nik);
        pasien.setNama(nama);
        pasien.setPassword(pass);
        pasien.setTglLahir(tanggal);
        pasien.setAlamat(alamat);
        pasien.setJenisKelamin(jenisKelamin);
        pasien.setNoTelp(noTelp);
        Muhammad07102_AllObjectModel.pasienModel.updatePasien(isData,pasien);
    }
    
    public void delete(int isData) {
        Muhammad07102_AllObjectModel.pasienModel.deletePasien(isData);
    }
    
    @Override
    public void login(int nik, String password) {
        indexLogin = Muhammad07102_AllObjectModel.pasienModel.cekData(nik,password);
    }
    
    public Muhammad07102_PasienEntity pasienEntity() {
        return Muhammad07102_AllObjectModel.pasienModel.showDataPasien(indexLogin);
    }
    
    public int cekPasien(int nik, String password) {
        return Muhammad07102_AllObjectModel.pasienModel.cekData(nik,password);
    }
    
    public boolean isNull() {
        return Muhammad07102_AllObjectModel.pasienModel.isEmptyData();
    }
}
