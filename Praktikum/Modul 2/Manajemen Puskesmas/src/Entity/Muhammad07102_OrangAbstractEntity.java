/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;
public abstract class Muhammad07102_OrangAbstractEntity {
    protected String Muhammad07102_Nama, Muhammad07102_Password, Muhammad07102_Alamat;
    protected Date Muhammad07102_TanggalLahir;
    protected int Muhammad07102_NIK, Muhammad07102_JenisKelamin;

    public Muhammad07102_OrangAbstractEntity(int Muhammad07102_NIK,String Muhammad07102_Nama,String Muhammad07102_Password,Date Muhammad07102_TanggalLahir, String Muhammad07102_Alamat, int Muhammad07102_JenisKelamin) {
        this.Muhammad07102_NIK = Muhammad07102_NIK;
        this.Muhammad07102_Nama = Muhammad07102_Nama;
        this.Muhammad07102_Password = Muhammad07102_Password;
        this.Muhammad07102_TanggalLahir = Muhammad07102_TanggalLahir;
        this.Muhammad07102_Alamat = Muhammad07102_Alamat;
        this.Muhammad07102_JenisKelamin = Muhammad07102_JenisKelamin;
    }
    public Muhammad07102_OrangAbstractEntity() {
    }
    
    public void setNik(int Muhammad07102_NIK) {
        this.Muhammad07102_NIK = Muhammad07102_NIK;
    }
    public int getNik() {
        return this.Muhammad07102_NIK;
    }
    public void setNama(String Muhammad07102_Nama) {
        this.Muhammad07102_Nama = Muhammad07102_Nama;
    }
    public String getNama() {
        return this.Muhammad07102_Nama;
    }
    public void setPassword(String Muhammad07102_Password) {
        this.Muhammad07102_Password = Muhammad07102_Password;
    }
    public String getPassword() {
        return this.Muhammad07102_Password;
    }
    public void setTglLahir(Date Muhammad07102_TanggalLahir) {
        this.Muhammad07102_TanggalLahir = Muhammad07102_TanggalLahir;
    }
    public Date getTglLahir() {
        return this.Muhammad07102_TanggalLahir;
    }
    public void setAlamat(String Muhammad07102_Alamat) {
        this.Muhammad07102_Alamat = Muhammad07102_Alamat;
    }
    public String getAlamat() {
        return this.Muhammad07102_Alamat;
    }
    public void setJenisKelamin(int Muhammad07102_JenisKelamin) {
        this.Muhammad07102_JenisKelamin = Muhammad07102_JenisKelamin;
    }
    public int getJenisKelamin() {
        return this.Muhammad07102_JenisKelamin;
    }
}
