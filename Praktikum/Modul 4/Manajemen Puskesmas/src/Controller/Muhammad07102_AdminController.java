/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.*;
import java.util.Date;
public class Muhammad07102_AdminController implements Muhammad07102_ControllerInterface {
    int indexLogin = 0;
    public Muhammad07102_AdminController() {
    }
    public void dataAdmin() {
        int nik[] = {123};
        String nama[] = {"Admin"};
        String password[] = {"admin"};
        String tglLahir[] = {"08/05/2000"};
        String alamat[] = {"Sidoarjo"};
        int jenisKelamin[] = {0};
        for(int i=0;i<nik.length;i++) {
            Muhammad07102_AdminEntity admin = new Muhammad07102_AdminEntity();
            admin.setNik(nik[i]);
            admin.setNama(nama[i]);
            admin.setPassword(password[i]);
            admin.setTglLahir(new Date(tglLahir[i]));
            admin.setAlamat(alamat[i]);
            admin.setJenisKelamin(jenisKelamin[i]);
            Muhammad07102_AllObjectModel.adminModel.insertAdmin(admin);
        }
    }
    @Override
    public void login(int nik, String password) {
        indexLogin = Muhammad07102_AllObjectModel.adminModel.cekData(nik,password);
    }
    public Muhammad07102_AdminEntity adminEntity() {
        return Muhammad07102_AllObjectModel.adminModel.showDataAdmin(indexLogin);
    }
    public int cekAdmin(int nik, String password) {
        return Muhammad07102_AllObjectModel.adminModel.cekData(nik,password);
    }
}
