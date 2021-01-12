/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
public class Muhammad07102_PasienController implements Muhammad07102_ControllerInterface {
    int indexLogin = 0;
    public Muhammad07102_PasienController() {
    }
    public int view() {
        return Muhammad07102_AllObjectModel.pasienModel.viewAll();
    }
    public Muhammad07102_PasienEntity getData() {
        return Muhammad07102_AllObjectModel.pasienModel.showDataPasien(indexLogin);
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
    public int cekDaftarPeriksa(int nik) {
        int cek = Muhammad07102_AllObjectModel.daftarPeriksaModel.cekData(nik,null);
        return cek;
    }
    public Muhammad07102_DaftarPeriksaEntity showDaftarPeriksa(int index) {
        return Muhammad07102_AllObjectModel.daftarPeriksaModel.showDaftarPeriksa(index);
    }
    public boolean isNull() {
        return Muhammad07102_AllObjectModel.pasienModel.isEmptyData();
    }
    public void daftarPeriksa(int indexPeriksa, Muhammad07102_PasienEntity pasienEntity, boolean isAccept) {
        Muhammad07102_AllObjectModel.daftarPeriksaModel.insertDaftarPeriksa(new Muhammad07102_DaftarPeriksaEntity(indexPeriksa,pasienEntity,isAccept));
    }
    public DefaultTableModel daftarperiksa() {
        DefaultTableModel dtmdaftarperiksa = new DefaultTableModel();
        Object[] kolom = {"NIK","Nama","Password","No Telp","Tgl Lahir","Status"};
        dtmdaftarperiksa.setColumnIdentifiers(kolom);
        int size = Muhammad07102_AllObjectModel.daftarPeriksaModel.alldataperiksa().size();
        String status = "Not Accepted!";
        for(int i=0;i<size;i++) {
            if(Muhammad07102_AllObjectModel.daftarPeriksaModel.alldataperiksa().get(i).isAccept() == true) {
                status = "Accepted!";
            }
            Object[] data = new Object[6];
            data[0] = Muhammad07102_AllObjectModel.daftarPeriksaModel.alldataperiksa().get(i).getPasien().getNik();
            data[1] = Muhammad07102_AllObjectModel.daftarPeriksaModel.alldataperiksa().get(i).getPasien().getNama();
            data[2] = Muhammad07102_AllObjectModel.daftarPeriksaModel.alldataperiksa().get(i).getPasien().getPassword();
            data[3] = Muhammad07102_AllObjectModel.daftarPeriksaModel.alldataperiksa().get(i).getPasien().getNoTelp();
            data[4] = new SimpleDateFormat("dd-MM-yyyy").format(Muhammad07102_AllObjectModel.daftarPeriksaModel.alldataperiksa().get(i).getPasien().getTglLahir());
            data[5] = status;
            dtmdaftarperiksa.addRow(data);   
        }
        return dtmdaftarperiksa;
    }
}
