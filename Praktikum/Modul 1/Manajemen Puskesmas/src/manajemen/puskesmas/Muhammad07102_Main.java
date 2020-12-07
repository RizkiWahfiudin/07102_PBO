/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manajemen.puskesmas;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Muhammad07102_Main {
    ArrayList <Muhammad07102_Orang> datauser = new ArrayList();
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Selamat Datang Di Aplikasi Sistem Informasi Manajemen Puskesmas");
        Muhammad07102_Main fungsiMenu = new Muhammad07102_Main();
        fungsiMenu.dataAdmin();
        fungsiMenu.menu();
    }
    
    void menu() {
        int Muhammad07102_menu;
        System.out.println("\nDaftar Menu : ");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.println("3. Exit");
        System.out.print("Pilih Menu : ");
        Muhammad07102_menu = input.nextInt();
        if(Muhammad07102_menu == 1) register(false);
        else if(Muhammad07102_menu == 2) {
            System.out.print("NIK : ");
            int Muhammad07102_nik = input.nextInt();
            System.out.print("Password : ");
            String Muhammad07102_pass = input.next();
            login(Muhammad07102_nik,Muhammad07102_pass);
        }
        else System.exit(0);
    }

    void register(boolean Muhammad07102_isRegister) {
        System.out.print("Input NIK = ");
        int Muhammad07102_nik = input.nextInt();
        System.out.print("Input Nama = ");
        String Muhammad07102_nama = input.next();
        System.out.print("Input Password = ");
        String Muhammad07102_pass = input.next();
        System.out.print("Input Tanggal Lahir (dd/mm/yyyy) = ");
        Date Muhammad07102_tanggal = new Date(input.next());
        Muhammad07102_Type type = new Muhammad07102_Type();
        for(int i=1;i<type.Muhammad07102_TypeUser.length;i++) {
            System.out.println(i+". "+type.Muhammad07102_TypeUser[i]);
        }
        System.out.print("Type = ");
        int Muhammad07102_type = input.nextInt();
        System.out.print("Alamat = ");
        String Muhammad07102_alamat = input.next();
        for(int i=0;i<type.Muhammad07102_Gender.length;i++) {
            System.out.println(i+". "+type.Muhammad07102_Gender[i]);
        }
        System.out.print("Jenis Kelamin = ");
        int Muhammad07102_jenisKelamin = input.nextInt();
        datauser.add(new Muhammad07102_Orang(Muhammad07102_nik,Muhammad07102_nama,Muhammad07102_pass,Muhammad07102_tanggal,Muhammad07102_type,Muhammad07102_alamat,Muhammad07102_jenisKelamin));
        System.out.println("Proses Pendaftaran Berhasil!");
        if(Muhammad07102_isRegister == true) loginAdmin();
        else menu();
    }

    void login(int Muhammad07102_nik, String Muhammad07102_password) {
        for(int i=0;i<datauser.size();i++) {
            if(Muhammad07102_nik == datauser.get(i).getNik() && Muhammad07102_password.equals(datauser.get(i).getPassword())) {
                System.out.println("\nSelamat Datang "+datauser.get(i).getNama());
                System.out.println("==========================");
                if(datauser.get(i).getType() == 0) loginAdmin();
                else {
                    System.out.println("NIK : "+datauser.get(i).getNik());
                    System.out.println("Nama : "+datauser.get(i).getNama());
                    System.out.println("Tanggal Lahir = "+new SimpleDateFormat("MM-dd-yyyy").format(datauser.get(i).getDate()));
                    System.out.println("Alamat : "+datauser.get(i).getAlamat());
                    int Muhammad07102_gender = datauser.get(i).isJenisKelamin();
                    if(Muhammad07102_gender == 0) System.out.println("Jenis Kelamin : Laki-Laki");
                    else System.out.println("Jenis Kelamin : Perempuan");
                    int Muhammad07102_dataType = datauser.get(i).getType();
                    if(Muhammad07102_dataType == 1) System.out.println("Type User : Dokter\n");
                    else if(Muhammad07102_dataType == 2) System.out.println("Type User : Perawat\n");
                    else System.out.println("Type User : Pasien\n");
                    menu();
                }
            }
        }
    }
    
    void loginAdmin() {
        System.out.println("Action : ");
        System.out.println("1. Create");
        System.out.println("2. Edit");
        System.out.println("3. Delete");
        System.out.println("4. View");
        System.out.println("5. Kembali Ke Menu Utama");
        System.out.println("6. Exit");
        System.out.print("Pilih Menu : ");
        int Muhammad07102_aksi = input.nextInt();
        if(Muhammad07102_aksi == 1) register(true);
        else if(Muhammad07102_aksi == 2) edit();
        else if(Muhammad07102_aksi == 3) delete();
        else if(Muhammad07102_aksi == 4) view(false);
        else if(Muhammad07102_aksi == 5) menu();
        else System.exit(0);
    }
    
    void edit() {
        view(true);
        System.out.print("Pilih Data Yang Di Edit : ");
        int Muhammad07102_isData = input.nextInt();
        System.out.print("Input NIK = ");
        int Muhammad07102_nik = input.nextInt();
        System.out.print("Input Nama = ");
        String Muhammad07102_nama = input.next();
        System.out.print("Input Password = ");
        String Muhammad07102_pass = input.next();
        System.out.print("Input Tanggal Lahir (dd/mm/yyyy) = ");
        Date Muhammad07102_tanggal = new Date(input.next());
        Muhammad07102_Type type = new Muhammad07102_Type();
        for(int i=0;i<type.Muhammad07102_TypeUser.length;i++) {
            System.out.println(i+". "+type.Muhammad07102_TypeUser[i]);
        }
        System.out.print("Type = ");
        int Muhammad07102_type = input.nextInt();
        System.out.print("Alamat = ");
        String Muhammad07102_alamat = input.next();
        for(int i=0;i<type.Muhammad07102_Gender.length;i++) {
            System.out.println(i+". "+type.Muhammad07102_Gender[i]);
        }
        System.out.print("Jenis Kelamin = ");
        int Muhammad07102_jenisKelamin = input.nextInt();
        datauser.set(Muhammad07102_isData, new Muhammad07102_Orang(Muhammad07102_nik,Muhammad07102_nama,Muhammad07102_pass,Muhammad07102_tanggal,Muhammad07102_type,Muhammad07102_alamat,Muhammad07102_jenisKelamin));
        System.out.println("Update Data Berhasil!");
        loginAdmin();
    }
    
    void delete() {
        view(true);
        System.out.print("Masukkan Data Yang Di Hapus : ");
        int Muhammad07102_isData = input.nextInt();
        if(!datauser.isEmpty()) {
            datauser.remove(Muhammad07102_isData);
            System.out.println("Data Berhasil Dihapus!\n");
            if(datauser.isEmpty()) System.exit(0);
            else loginAdmin();
        }
        else System.exit(0);
    }
    
    void view(boolean Muhammad07102_isEdit) {
        System.out.println("==============");
        System.out.println("Daftar User");
        System.out.println("==============");
        for(int i=0;i<datauser.size();i++) {
            System.out.println("Data Ke - "+i);
            System.out.println("NIK : "+datauser.get(i).getNik());
            System.out.println("Nama : "+datauser.get(i).getNama());
            System.out.println("Tanggal Lahir = "+new SimpleDateFormat("MM-dd-yyyy")
                    .format(datauser.get(i).getDate()));
            System.out.println("Alamat : "+datauser.get(i).getAlamat());
            int Muhammad07102_gender = datauser.get(i).isJenisKelamin();
            if(Muhammad07102_gender == 0) System.out.println("Jenis Kelamin : Laki-Laki");
            else System.out.println("Jenis Kelamin : Perempuan");
            int Muhammad07102_dataType = datauser.get(i).getType();
            if(Muhammad07102_dataType == 0) System.out.println("Type User : Admin\n");
            else if(Muhammad07102_dataType == 1) System.out.println("Type User : Dokter\n");
            else if(Muhammad07102_dataType == 2) System.out.println("Type User : Perawat\n");
            else System.out.println("Type User : Pasien\n");
        }
        if(Muhammad07102_isEdit == false) loginAdmin();
    }
    
    void dataAdmin() {
        int Muhammad07102_nik[] = {123,456};
        String Muhammad07102_nama[] = {"Admin","Dokter"};
        String Muhammad07102_password[] = {"admin","dokter"};
        String Muhammad07102_tglLahir[] = {"04/05/2000","01/12/2000"};
        int Muhammad07102_type[] = {0,1};
        String Muhammad07102_alamat[] = {"Surabaya","Sidoarjo"};
        int Muhammad07102_jenisKelamin[] = {0,1};
        for(int i=0;i<Muhammad07102_nik.length;i++) {
            datauser.add(new Muhammad07102_Orang(Muhammad07102_nik[i],Muhammad07102_nama[i],Muhammad07102_password[i],new Date(Muhammad07102_tglLahir[i]),Muhammad07102_type[i],Muhammad07102_alamat[i],Muhammad07102_jenisKelamin[i]));
        }
    }
}
