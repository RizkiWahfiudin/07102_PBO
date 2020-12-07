/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manajemen.puskesmas;

public class Muhammad07102_Poli {
    String Muhammad07102_Nama;
    int Muhammad07102_JumlahPegawai,Muhammad07102_JumlahPasien;

    public Muhammad07102_Poli(String Muhammad07102_Nama,int Muhammad07102_JumlahPegawai,int Muhammad07102_JumlahPasien) {
        this.Muhammad07102_Nama = Muhammad07102_Nama;
        this.Muhammad07102_JumlahPegawai = Muhammad07102_JumlahPegawai;
        this.Muhammad07102_JumlahPasien = Muhammad07102_JumlahPasien;
    }
    
    String getNama() {
        return this.Muhammad07102_Nama;
    }

    int getJumlahPegawai() {
        return this.Muhammad07102_JumlahPegawai;
    }

    int getJumlahPasien() {
        return this.Muhammad07102_JumlahPasien;
    }
}
