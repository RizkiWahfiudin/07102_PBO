/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.*;
import java.util.Date;

public class Muhammad07102_DokterController implements Muhammad07102_ControllerInterface {
    int indexLogin = 0;
    
    public Muhammad07102_DokterController() {
    }
    
    public int view() {
        return Muhammad07102_AllObjectModel.dokterModel.viewAll();
    }
    
    public Muhammad07102_DokterEntity getData(int index) {
        return Muhammad07102_AllObjectModel.dokterModel.showDataDokter(index);
    }
    
    public void insert(int nik, String nama,String pass,Date tanggal,String alamat,int jenisKelamin,String spesialis) {
        Muhammad07102_DokterEntity dokter = new Muhammad07102_DokterEntity();
        dokter.setNik(nik);
        dokter.setNama(nama);
        dokter.setPassword(pass);
        dokter.setTglLahir(tanggal);
        dokter.setAlamat(alamat);
        dokter.setJenisKelamin(jenisKelamin);
        dokter.setSpesialis(spesialis);
        Muhammad07102_AllObjectModel.dokterModel.insertDokter(dokter);
    }
    
    public void update(int isData,int nik, String nama,String pass,Date tanggal,String alamat,int jenisKelamin,String spesialis) {
        Muhammad07102_DokterEntity dokter = new Muhammad07102_DokterEntity();
        dokter.setNik(nik);
        dokter.setNama(nama);
        dokter.setPassword(pass);
        dokter.setTglLahir(tanggal);
        dokter.setAlamat(alamat);
        dokter.setJenisKelamin(jenisKelamin);
        dokter.setSpesialis(spesialis);
        Muhammad07102_AllObjectModel.dokterModel.updateDokter(isData,dokter);
    }
    
    public void delete(int isData) {
        Muhammad07102_AllObjectModel.dokterModel.deleteDokter(isData);
    }
    
    @Override
    public void login(int nik, String password) {
        indexLogin = Muhammad07102_AllObjectModel.dokterModel.cekData(nik,password);
    }
    
    public Muhammad07102_DokterEntity dokterEntity() {
        return Muhammad07102_AllObjectModel.dokterModel.showDataDokter(indexLogin);
    }
    
    public int cekDokter(int nik, String password) {
        return Muhammad07102_AllObjectModel.dokterModel.cekData(nik,password);
    }
    
    public boolean isNull() {
        return Muhammad07102_AllObjectModel.dokterModel.isEmptyData();
    }
}
