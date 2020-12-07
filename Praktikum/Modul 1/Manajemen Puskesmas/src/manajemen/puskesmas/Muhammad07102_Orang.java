/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manajemen.puskesmas;

import java.util.Date;

public class Muhammad07102_Orang {
    String Muhammad07102_Nama, Muhammad07102_Password, Muhammad07102_Alamat;
    Date Muhammad07102_TanggalLahir;
    int Muhammad07102_NIK, Muhammad07102_Type, Muhammad07102_JenisKelamin;

    public Muhammad07102_Orang(int Muhammad07102_NIK,String Muhammad07102_Nama,String Muhammad07102_Password,Date Muhammad07102_TanggalLahir, int Muhammad07102_Type, String Muhammad07102_Alamat, int Muhammad07102_JenisKelamin) {
        this.Muhammad07102_NIK = Muhammad07102_NIK;
        this.Muhammad07102_Nama = Muhammad07102_Nama;
        this.Muhammad07102_Password = Muhammad07102_Password;
        this.Muhammad07102_TanggalLahir = Muhammad07102_TanggalLahir;
        this.Muhammad07102_Type = Muhammad07102_Type;
        this.Muhammad07102_Alamat = Muhammad07102_Alamat;
        this.Muhammad07102_JenisKelamin = Muhammad07102_JenisKelamin;
    }
    
    int getNik() {
        return this.Muhammad07102_NIK;
    }

    String getNama() {
        return this.Muhammad07102_Nama;
    }
    
    String getPassword() {
        return this.Muhammad07102_Password;
    }
    
    Date getDate() {
        return this.Muhammad07102_TanggalLahir;
    }

    int getType() {
        return this.Muhammad07102_Type;
    }

    String getAlamat() {
        return this.Muhammad07102_Alamat;
    }

    int isJenisKelamin() {
        return this.Muhammad07102_JenisKelamin;
    }
}
