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
    public void submitData(int index, int indexPeriksa, Muhammad07102_PasienEntity pasienEntity) {
        Muhammad07102_AllObjectModel.daftarPeriksaModel.submit(index, new Muhammad07102_DaftarPeriksaEntity(indexPeriksa,pasienEntity,true));
    }
    public boolean isNull() {
        return Muhammad07102_AllObjectModel.dokterModel.isEmptyData();
    }
    public DefaultTableModel daftardokter() {
        DefaultTableModel dtmdaftardokter = new DefaultTableModel();
        Object[] kolom = {"No","NIK","Nama","Password","Tgl Lahir","Alamat","Jenis Kelamin","Spesialis"};
        dtmdaftardokter.setColumnIdentifiers(kolom);
        int size = Muhammad07102_AllObjectModel.dokterModel.viewAll();
        for(int i=0;i<size;i++) {
            String jk = "Laki-Laki";
            if(Muhammad07102_AllObjectModel.dokterModel.showDataDokter(i).getJenisKelamin() == 1) jk = "Perempuan";
            Object[] data = new Object[8];
            data[0] = i;
            data[1] = Muhammad07102_AllObjectModel.dokterModel.showDataDokter(i).getNik();
            data[2] = Muhammad07102_AllObjectModel.dokterModel.showDataDokter(i).getNama();
            data[3] = Muhammad07102_AllObjectModel.dokterModel.showDataDokter(i).getPassword();
            data[4] = new SimpleDateFormat("dd-MM-yyyy").format(Muhammad07102_AllObjectModel.dokterModel.showDataDokter(i).getTglLahir());
            data[5] = Muhammad07102_AllObjectModel.dokterModel.showDataDokter(i).getAlamat();
            data[6] = jk;
            data[7] = Muhammad07102_AllObjectModel.dokterModel.showDataDokter(i).getSpesialis();
            dtmdaftardokter.addRow(data);
        }
        return dtmdaftardokter;
    }
}
