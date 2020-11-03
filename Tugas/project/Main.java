package manajemen.puskesma;

import manajemen.puskesma.*;
import java.util.Scanner;

public class Main() {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Selamat Datang Di Aplikasi Sistem Informasi Manajemen Puskesmas");
		menu();

		static void menu() {
			System.out.println("Daftar Menu : ");
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Logout");
			System.out.println("Pilih Menu : ");
			int menu = input.nextInt();
			switch(menu) {
				case 1 :
					register();
					break;
				case 2 :
					System.out.print("NIK : ");
                    String nik = input.next();
                    System.out.print("Password : ");
                    String pass = input.next();
					login(nik,pass);
					break;
				case 3 :
					logout();
					break;
				default :
					break;
			}
		}

		static void register() {

		}

		static void login(int nik, String password) {
			
		}

		static void logout() {
			
		}
	}
}