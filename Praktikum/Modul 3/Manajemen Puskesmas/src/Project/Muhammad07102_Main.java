/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import Model.*;
import Entity.*;
import Controller.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Muhammad07102_Main {
    private static Muhammad07102_AdminController dataAdmin = new Muhammad07102_AdminController();
    private static Muhammad07102_DokterController dataDokter = new Muhammad07102_DokterController();
    private static Muhammad07102_PasienController dataPasien = new Muhammad07102_PasienController();
    private static Scanner input = new Scanner(System.in);
    private static int cekAdmin, cekDokter, cekPasien;

    public static void main(String[] args) {
        System.out.println("Selamat Datang Di Aplikasi Sistem Informasi Manajemen Puskesmas");
        dataAdmin.dataAdmin();
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
        dataDokter.insert(Muhammad07102_nik,Muhammad07102_nama,Muhammad07102_pass,Muhammad07102_tanggal,Muhammad07102_alamat,Muhammad07102_jenisKelamin,Muhammad07102_spesialis);
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
        dataPasien.insert(Muhammad07102_nik,Muhammad07102_nama,Muhammad07102_pass,Muhammad07102_tanggal,Muhammad07102_alamat,Muhammad07102_jenisKelamin,Muhammad07102_noTelp);
        System.out.println("Registrasi Pasien "+Muhammad07102_nama+" Berhasil!");
        if(isRegisterAdmin == true) loginAdmin(false);
        else menu();
    }

    static void loginPasien() {
        System.out.print("NIK : ");
        int nik = input.nextInt();
        System.out.print("Password : ");
        String password = input.next();
        try {
            cekPasien = dataPasien.cekPasien(nik, password);
            if(cekAdmin == -1) {
                System.out.println("User Tidak Ditemukan!");
                menu();
            }
            System.out.println("\nSelamat Datang " + dataPasien.pasienEntity().getNama());
            System.out.println("NIK : "+dataPasien.pasienEntity().getNik());
            System.out.println("Nama : "+dataPasien.pasienEntity().getNama());
            System.out.println("Tanggal Lahir = "+new SimpleDateFormat("MM-dd-yyyy").format(dataPasien.pasienEntity().getTglLahir()));
            System.out.println("No. Telepon : "+dataPasien.pasienEntity().getNoTelp());
            System.out.println("Alamat : "+dataPasien.pasienEntity().getAlamat());
            if(dataPasien.pasienEntity().getJenisKelamin() == 0) System.out.println("Jenis Kelamin : Laki-Laki");
            else System.out.println("Jenis Kelamin : Perempuan");
            menu();
        } catch(Exception exception) {
            System.out.println("User Tidak Ditemukan!");
            menu();
        }
    }
    
    static void loginDokter() {
        System.out.print("NIK : ");
        int nik = input.nextInt();
        System.out.print("Password : ");
        String password = input.next();
        try {
            cekDokter = dataDokter.cekDokter(nik, password);
            if(cekAdmin == -1) {
                System.out.println("User Tidak Ditemukan!");
                menu();
            }
            System.out.println("\nSelamat Datang " + dataDokter.dokterEntity().getNama());
            System.out.println("NIK : "+dataDokter.dokterEntity().getNik());
            System.out.println("Nama Dokter : "+dataDokter.dokterEntity().getNama());
            System.out.println("Tanggal Lahir = "+new SimpleDateFormat("MM-dd-yyyy").format(dataDokter.dokterEntity().getTglLahir()));
            System.out.println("Alamat : "+dataDokter.dokterEntity().getAlamat());
            if(dataDokter.dokterEntity().getJenisKelamin() == 0) System.out.println("Jenis Kelamin : Laki-Laki");
            else System.out.println("Jenis Kelamin : Perempuan");
            System.out.println("Spesialis : "+dataDokter.dokterEntity().getSpesialis());
            menu();
        } catch(Exception exception) {
            System.out.println("User Tidak Ditemukan!");
            menu();
        }
    }
    
    static void loginAdmin(boolean isLoginAdmin) {
        if(isLoginAdmin == true) {
            System.out.print("NIK : ");
            int nik = input.nextInt();
            System.out.print("Password : ");
            String password = input.next();
            try {
                cekAdmin = dataAdmin.cekAdmin(nik, password);
                if(cekAdmin == -1) {
                    System.out.println("User Tidak Ditemukan!");
                    menu();
                }
                System.out.println("\nSelamat Datang " + dataAdmin.adminEntity().getNama());
                System.out.println("==============================");
            } catch(Exception exception) {
                System.out.println("User Tidak Ditemukan!");
                menu();
            }
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
            System.out.println("1. Create Data Dokter \n2. Create Data Pasien");
            System.out.print("Pilih : ");
            int Muhammad07102_pilRegister = input.nextInt();
            if(Muhammad07102_pilRegister == 1) registerDokter(true);
            else if(Muhammad07102_pilRegister == 2) registerPasien(true);
            else {
                System.out.println("Pilihan Salah!");
                loginAdmin(false);
            }
        } else if(Muhammad07102_aksi == 2) {
            System.out.println("1. Edit Data Dokter \n2. Edit Data Pasien");
            System.out.print("Pilih : ");
            int Muhammad07102_pilEdit = input.nextInt();
            if(Muhammad07102_pilEdit == 1) editDokter();
            else if(Muhammad07102_pilEdit == 2) editPasien();
            else {
                System.out.println("Pilihan Salah!");
                loginAdmin(false);
            }
        } else if(Muhammad07102_aksi == 3) {
            System.out.println("1. Hapus Data Dokter \n2. Hapus Data Pasien");
            System.out.print("Pilih : ");
            int Muhammad07102_pilHapus = input.nextInt();
            if(Muhammad07102_pilHapus == 1) deleteDokter();
            else if(Muhammad07102_pilHapus == 2) deletePasien();
            else {
                System.out.println("Pilihan Salah!");
                loginAdmin(false);
            }
        } else if(Muhammad07102_aksi == 4) {
            System.out.println("1. View Data Dokter \n2. View Data Pasien");
            System.out.print("Pilih : ");
            int Muhammad07102_pilView = input.nextInt();
            if(Muhammad07102_pilView == 1) {
                viewDokter(true);
                loginAdmin(false);
            } else if(Muhammad07102_pilView == 2) {
                viewPasien(true);
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
        viewDokter(true);
        if(dataDokter.isNull() == false) {
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
            dataDokter.update(isData,Muhammad07102_nik,Muhammad07102_nama,Muhammad07102_pass,Muhammad07102_tanggal,Muhammad07102_alamat,Muhammad07102_jenisKelamin,Muhammad07102_spesialis);
            System.out.println("Update Data Berhasil!");
            loginAdmin(false);
        } else loginAdmin(false);
    }
    
    static void editPasien() {
        viewPasien(true);
        if(dataPasien.isNull() == false) {
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
            dataPasien.update(isData,Muhammad07102_nik,Muhammad07102_nama,Muhammad07102_pass,Muhammad07102_tanggal,Muhammad07102_alamat,Muhammad07102_jenisKelamin,Muhammad07102_noTelp);
            System.out.println("Update Data Berhasil!");
            loginAdmin(false);
        } else loginAdmin(false);
    }
    
    static void deleteDokter() {
        viewDokter(true);
        if(dataDokter.isNull() == false) {
            System.out.print("Masukkan Data Yang Di Hapus : ");
            int isData = input.nextInt();
            dataDokter.delete(isData);
            System.out.println("Data Berhasil Dihapus!\n");
            loginAdmin(false);
        } else loginAdmin(false);
    }
    
    static void deletePasien() {
        viewPasien(true);
        if(dataPasien.isNull() == false) {
            System.out.print("Masukkan Data Yang Di Hapus : ");
            int isData = input.nextInt();
            dataPasien.delete(isData);
            System.out.println("Data Berhasil Dihapus!\n");
            loginAdmin(false);
        } else loginAdmin(false);
    }
    
    static void viewDokter(boolean isViewAll) {
        int size = dataDokter.view();
        if(size == 0) System.out.println("Data Kosong!\n");
        for(int i=0;i<size;i++) {
            if(isViewAll == true) System.out.println("Data Ke "+i);
            if(isViewAll == true) System.out.println("=================================");
            System.out.println("NIK : "+dataDokter.getData(i).getNik());
            System.out.println("Nama Dokter : "+dataDokter.getData(i).getNama());
            System.out.println("Tanggal Lahir : "+new SimpleDateFormat("dd-MM-yyyy").format(dataDokter.getData(i).getTglLahir()));
            System.out.println("Alamat : "+dataDokter.getData(i).getAlamat());
            if(dataDokter.getData(i).getJenisKelamin() == 0) System.out.println("Jenis Kelamin : Laki-Laki");
            else System.out.println("Jenis Kelamin : Perempuan");
            System.out.println("Spesialis : "+dataDokter.getData(i).getSpesialis());
            if(isViewAll == true) System.out.println("=================================");
            if(isViewAll == true) System.out.println();
        }
    }
    
    static void viewPasien(boolean isViewAll) {
        int size = dataPasien.view();
        if(size == 0) System.out.println("Data Kosong!\n");
        for(int i=0;i<size;i++) {
            if(isViewAll == true) System.out.println("Data Ke "+i);
            if(isViewAll == true) System.out.println("=================================");
            System.out.println("NIK : "+dataPasien.getData(i).getNik());
            System.out.println("Nama Pasien : "+dataPasien.getData(i).getNama());
            System.out.println("Tanggal Lahir : "+new SimpleDateFormat("dd-MM-yyyy").format(dataPasien.getData(i).getTglLahir()));
            System.out.println("No. Telepon : "+dataPasien.getData(i).getNoTelp());
            System.out.println("Alamat : "+dataPasien.getData(i).getAlamat());
            if(dataPasien.getData(i).getJenisKelamin() == 0) System.out.println("Jenis Kelamin : Laki-Laki");
            else System.out.println("Jenis Kelamin : Perempuan");
            if(isViewAll == true) System.out.println("=================================");
            if(isViewAll == true) System.out.println();
        }
    }
}
