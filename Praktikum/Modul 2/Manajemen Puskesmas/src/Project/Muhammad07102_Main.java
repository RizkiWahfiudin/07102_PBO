/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import Model.*;
import Entity.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Muhammad07102_Main {
    private static Muhammad07102_AdminModel dataAdmin = new Muhammad07102_AdminModel();
    private static Muhammad07102_DokterModel dataDokter = new Muhammad07102_DokterModel();
    private static Muhammad07102_PasienModel dataPasien = new Muhammad07102_PasienModel();
    private static Scanner input = new Scanner(System.in);
    static int cekAdmin, cekDokter, cekPasien;

    public static void main(String[] args) {
        System.out.println("Selamat Datang Di Aplikasi Sistem Informasi Manajemen Puskesmas");
        dataAdmin();
        menu();
    }
    
    static void menu() {
        int Muhammad07102_menu,Muhammad07102_pilLogin,Muhammad07102_pilRegister;
        System.out.println("\nDaftar Menu : ");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Pilih Menu : ");
        Muhammad07102_menu = input.nextInt();
        if(Muhammad07102_menu == 1) {
            System.out.println("1. Register Dokter");
            System.out.println("2. Register Pasien");
            System.out.print("Pilih : ");
            Muhammad07102_pilRegister = input.nextInt();
            if(Muhammad07102_pilRegister == 1) registerDokter(false);
            else if(Muhammad07102_pilRegister == 2) registerPasien(false);
            else {
                System.out.println("Pilihan Salah!");
                menu();
            }
        }
        else if(Muhammad07102_menu == 2) {
            System.out.println("1. Login Admin");
            System.out.println("2. Login Dokter");
            System.out.println("3. Login Pasien");
            System.out.print("Pilih : ");
            Muhammad07102_pilLogin = input.nextInt();
            if(Muhammad07102_pilLogin == 1) loginAdmin(true);
            else if(Muhammad07102_pilLogin == 2) loginDokter();
            else if(Muhammad07102_pilLogin == 3) loginPasien();
            else {
                System.out.println("Pilihan Salah!");
                menu();
            }
        }
        else System.exit(0);
    }

    static void registerDokter(boolean isRegisterAdmin) {
        System.out.print("Input NIK = ");
        int Muhammad07102_nik = input.nextInt();
        System.out.print("Input Nama = ");
        String Muhammad07102_nama = input.next();
        System.out.print("Input Password = ");
        String Muhammad07102_pass = input.next();
        System.out.print("Input Tanggal Lahir (dd/mm/yyyy) = ");
        Date Muhammad07102_tanggal = new Date(input.next());
        System.out.print("Spesialis = ");
        String Muhammad07102_spesialis = input.next();
        System.out.print("Alamat = ");
        String Muhammad07102_alamat = input.next();
        for(int i=0;i<Muhammad07102_TypeEntity.Muhammad07102_Gender.length;i++) {
            System.out.println(i+". "+Muhammad07102_TypeEntity.Muhammad07102_Gender[i]);
        }
        System.out.print("Jenis Kelamin = ");
        int Muhammad07102_jenisKelamin = input.nextInt();
        dataDokter.insertDokter(new Muhammad07102_DokterEntity(Muhammad07102_nik,Muhammad07102_nama,Muhammad07102_pass,Muhammad07102_tanggal,Muhammad07102_alamat,Muhammad07102_jenisKelamin,Muhammad07102_spesialis));
        System.out.println("Registrasi Dokter "+Muhammad07102_nama+" Berhasil!");
        if(isRegisterAdmin == true) loginAdmin(false);
        else menu();
    }
    
    static void registerPasien(boolean isRegisterAdmin) {
        System.out.print("Input NIK = ");
        int Muhammad07102_nik = input.nextInt();
        System.out.print("Input Nama = ");
        String Muhammad07102_nama = input.next();
        System.out.print("Input Password = ");
        String Muhammad07102_pass = input.next();
        System.out.print("Input Tanggal Lahir (dd/mm/yyyy) = ");
        Date Muhammad07102_tanggal = new Date(input.next());
        System.out.print("No. Telepon = ");
        int Muhammad07102_noTelp = input.nextInt();
        System.out.print("Alamat = ");
        String Muhammad07102_alamat = input.next();
        for(int i=0;i<Muhammad07102_TypeEntity.Muhammad07102_Gender.length;i++) {
            System.out.println(i+". "+Muhammad07102_TypeEntity.Muhammad07102_Gender[i]);
        }
        System.out.print("Jenis Kelamin = ");
        int Muhammad07102_jenisKelamin = input.nextInt();
        dataPasien.insertPasien(new Muhammad07102_PasienEntity(Muhammad07102_nik,Muhammad07102_nama,Muhammad07102_pass,Muhammad07102_tanggal,Muhammad07102_alamat,Muhammad07102_jenisKelamin,Muhammad07102_noTelp));
        System.out.println("Registrasi Pasien "+Muhammad07102_nama+" Berhasil!");
        if(isRegisterAdmin == true) loginAdmin(false);
        else menu();
    }

    static void loginPasien() {
        System.out.print("NIK : ");
        int nik = input.nextInt();
        System.out.print("Password : ");
        String password = input.next();
        cekPasien = dataPasien.cekData(nik, password);
        if(cekPasien == -1) {
            System.out.println("User Tidak Ditemukan!");
            menu();
        }
        System.out.println("\nSelamat Datang " + dataPasien.showDataPasien(cekPasien).getNama());
        System.out.println("NIK : "+dataPasien.showDataPasien(cekPasien).getNik());
        System.out.println("Nama : "+dataPasien.showDataPasien(cekPasien).getNama());
        System.out.println("Tanggal Lahir = "+new SimpleDateFormat("MM-dd-yyyy").format(dataPasien.showDataPasien(cekPasien).getTglLahir()));
        System.out.println("No. Telepon : "+dataPasien.showDataPasien(cekPasien).getNoTelp());
        System.out.println("Alamat : "+dataPasien.showDataPasien(cekPasien).getAlamat());
        if(dataPasien.showDataPasien(cekPasien).getJenisKelamin() == 0) System.out.println("Jenis Kelamin : Laki-Laki");
        else System.out.println("Jenis Kelamin : Perempuan");
        menu();
    }
    
    static void loginDokter() {
        System.out.print("NIK : ");
        int nik = input.nextInt();
        System.out.print("Password : ");
        String password = input.next();
        cekDokter = dataDokter.cekData(nik, password);
        if(cekDokter == -1) {
            System.out.println("User Tidak Ditemukan!");
            menu();
        }
        System.out.println("\nSelamat Datang " + dataDokter.showDataDokter(cekDokter).getNama());
        System.out.println("NIK : "+dataDokter.showDataDokter(cekDokter).getNik());
        System.out.println("Nama Dokter : "+dataDokter.showDataDokter(cekDokter).getNama());
        System.out.println("Tanggal Lahir = "+new SimpleDateFormat("MM-dd-yyyy").format(dataDokter.showDataDokter(cekDokter).getTglLahir()));
        System.out.println("Alamat : "+dataDokter.showDataDokter(cekDokter).getAlamat());
        if(dataDokter.showDataDokter(cekDokter).getJenisKelamin() == 0) System.out.println("Jenis Kelamin : Laki-Laki");
        else System.out.println("Jenis Kelamin : Perempuan");
        System.out.println("Spesialis : "+dataDokter.showDataDokter(cekDokter).getSpesialis());
        menu();
    }
    
    static void loginAdmin(boolean isLoginAdmin) {
        if(isLoginAdmin == true) {
            System.out.print("NIK : ");
            int nik = input.nextInt();
            System.out.print("Password : ");
            String password = input.next();
            cekAdmin = dataAdmin.cekData(nik, password);
            if(cekAdmin == -1) {
                System.out.println("User Tidak Ditemukan!");
                menu();
            }
            System.out.println("\nSelamat Datang " + dataAdmin.showDataAdmin(cekAdmin).getNama());
            System.out.println("==============================");
        }
        System.out.println("Action : ");
        System.out.println("1. Create Data");
        System.out.println("2. Edit Data");
        System.out.println("3. Delete Data");
        System.out.println("4. View Data");
        System.out.println("5. Kembali Ke Menu Utama");
        System.out.println("6. Exit");
        System.out.print("Pilih Menu : ");
        int Muhammad07102_aksi = input.nextInt();
        if(Muhammad07102_aksi == 1) {
            System.out.println("1. Create Data Dokter");
            System.out.println("2. Create Data Pasien");
            System.out.print("Pilih : ");
            int Muhammad07102_pilRegister = input.nextInt();
            if(Muhammad07102_pilRegister == 1) registerDokter(true);
            else if(Muhammad07102_pilRegister == 2) registerPasien(true);
            else {
                System.out.println("Pilihan Salah!");
                loginAdmin(false);
            }
        }
        else if(Muhammad07102_aksi == 2) {
            System.out.println("1. Edit Data Dokter");
            System.out.println("2. Edit Data Pasien");
            System.out.print("Pilih : ");
            int Muhammad07102_pilEdit = input.nextInt();
            if(Muhammad07102_pilEdit == 1) editDokter();
            else if(Muhammad07102_pilEdit == 2) editPasien();
            else {
                System.out.println("Pilihan Salah!");
                loginAdmin(false);
            }
        }
        else if(Muhammad07102_aksi == 3) {
            System.out.println("1. Hapus Data Dokter");
            System.out.println("2. Hapus Data Pasien");
            System.out.print("Pilih : ");
            int Muhammad07102_pilHapus = input.nextInt();
            if(Muhammad07102_pilHapus == 1) deleteDokter();
            else if(Muhammad07102_pilHapus == 2) deletePasien();
            else {
                System.out.println("Pilihan Salah!");
                loginAdmin(false);
            }
        }
        else if(Muhammad07102_aksi == 4) {
            System.out.println("1. View Data Dokter");
            System.out.println("2. View Data Pasien");
            System.out.print("Pilih : ");
            int Muhammad07102_pilView = input.nextInt();
            if(Muhammad07102_pilView == 1) {
                dataDokter.view(true);
                loginAdmin(false);
            } else if(Muhammad07102_pilView == 2) {
                dataPasien.view(true);
                loginAdmin(false);
            } else {
                System.out.println("Pilihan Salah!");
                loginAdmin(false);
            }
        }
        else if(Muhammad07102_aksi == 5) menu();
        else System.exit(0);
    }
    
    static void editDokter() {
        dataDokter.view(true);
        if(!dataDokter.isEmptyData().isEmpty()) {
            System.out.print("Pilih Data Yang Di Edit : ");
            int isData = input.nextInt();
            System.out.print("Input NIK = ");
            int Muhammad07102_nik = input.nextInt();
            System.out.print("Input Nama = ");
            String Muhammad07102_nama = input.next();
            System.out.print("Input Password = ");
            String Muhammad07102_pass = input.next();
            System.out.print("Input Tanggal Lahir (dd/mm/yyyy) = ");
            Date Muhammad07102_tanggal = new Date(input.next());
            System.out.print("Spesialis = ");
            String Muhammad07102_spesialis = input.next();
            System.out.print("Alamat = ");
            String Muhammad07102_alamat = input.next();
            for(int i=0;i<Muhammad07102_TypeEntity.Muhammad07102_Gender.length;i++) {
                System.out.println(i+". "+Muhammad07102_TypeEntity.Muhammad07102_Gender[i]);
            }
            System.out.print("Jenis Kelamin = ");
            int Muhammad07102_jenisKelamin = input.nextInt();
            dataDokter.updateDokter(isData, new Muhammad07102_DokterEntity(Muhammad07102_nik,Muhammad07102_nama,Muhammad07102_pass,Muhammad07102_tanggal,Muhammad07102_alamat,Muhammad07102_jenisKelamin,Muhammad07102_spesialis));
            System.out.println("Update Data Berhasil!");
            loginAdmin(false);
        } else loginAdmin(false);
    }
    
    static void editPasien() {
        dataPasien.view(true);
        if(!dataPasien.isEmptyData().isEmpty()) {
            System.out.print("Pilih Data Yang Di Edit : ");
            int isData = input.nextInt();
            System.out.print("Input NIK = ");
            int Muhammad07102_nik = input.nextInt();
            System.out.print("Input Nama = ");
            String Muhammad07102_nama = input.next();
            System.out.print("Input Password = ");
            String Muhammad07102_pass = input.next();
            System.out.print("Input Tanggal Lahir (dd/mm/yyyy) = ");
            Date Muhammad07102_tanggal = new Date(input.next());
            System.out.print("No. Telepon = ");
            int Muhammad07102_noTelp = input.nextInt();
            System.out.print("Alamat = ");
            String Muhammad07102_alamat = input.next();
            for(int i=0;i<Muhammad07102_TypeEntity.Muhammad07102_Gender.length;i++) {
                System.out.println(i+". "+Muhammad07102_TypeEntity.Muhammad07102_Gender[i]);
            }
            System.out.print("Jenis Kelamin = ");
            int Muhammad07102_jenisKelamin = input.nextInt();
            dataPasien.updatePasien(isData, new Muhammad07102_PasienEntity(Muhammad07102_nik,Muhammad07102_nama,Muhammad07102_pass,Muhammad07102_tanggal,Muhammad07102_alamat,Muhammad07102_jenisKelamin,Muhammad07102_noTelp));
            System.out.println("Update Data Berhasil!");
            loginAdmin(false);
        } else loginAdmin(false);
    }
    
    static void deleteDokter() {
        dataDokter.view(true);
        if(!dataDokter.isEmptyData().isEmpty()) {
            System.out.print("Masukkan Data Yang Di Hapus : ");
            int isData = input.nextInt();
            dataDokter.deleteDokter(isData);
            System.out.println("Data Berhasil Dihapus!\n");
            loginAdmin(false);
        } else loginAdmin(false);
    }
    
    static void deletePasien() {
        dataPasien.view(true);
        if(!dataPasien.isEmptyData().isEmpty()) {
            System.out.print("Masukkan Data Yang Di Hapus : ");
            int isData = input.nextInt();
            dataPasien.deletePasien(isData);
            System.out.println("Data Berhasil Dihapus!\n");
            loginAdmin(false);
        } else loginAdmin(false);
    }
    
    static void dataAdmin() {
        int nik[] = {123};
        String nama[] = {"Admin"};
        String password[] = {"admin"};
        String tglLahir[] = {"08/05/2000"};
        String alamat[] = {"Sidoarjo"};
        int jenisKelamin[] = {0};
        for(int i=0;i<nik.length;i++) {
            dataAdmin.insertAdmin(new Muhammad07102_AdminEntity(nik[i],nama[i],password[i],new Date(tglLahir[i]),alamat[i],jenisKelamin[i]));
        }
    }
}
