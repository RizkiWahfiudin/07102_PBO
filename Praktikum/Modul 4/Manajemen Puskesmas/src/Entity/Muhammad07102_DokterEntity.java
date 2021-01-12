/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.Date;
public class Muhammad07102_DokterEntity extends Muhammad07102_OrangAbstractEntity {
    private String Muhammad07102_Spesialis;

    public Muhammad07102_DokterEntity(int Muhammad07102_NIK, String Muhammad07102_Nama, String Muhammad07102_Password, Date Muhammad07102_TanggalLahir, String Muhammad07102_Alamat, int Muhammad07102_JenisKelamin, String Muhammad07102_Spesialis) {
        super(Muhammad07102_NIK, Muhammad07102_Nama, Muhammad07102_Password, Muhammad07102_TanggalLahir, Muhammad07102_Alamat, Muhammad07102_JenisKelamin);
        this.Muhammad07102_Spesialis = Muhammad07102_Spesialis;
    }

    public Muhammad07102_DokterEntity() {
    }
    public void setSpesialis(String Muhammad07102_Spesialis) {
        this.Muhammad07102_Spesialis = Muhammad07102_Spesialis;
    }
    public String getSpesialis() {
        return Muhammad07102_Spesialis;
    }
}
