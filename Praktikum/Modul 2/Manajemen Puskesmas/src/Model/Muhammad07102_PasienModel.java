/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Muhammad07102_PasienEntity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class Muhammad07102_PasienModel implements Muhammad07102_ModelInterfaces {
    private ArrayList<Muhammad07102_PasienEntity> pasienEntityArrayList = new ArrayList();
    
    public void DokterModel() {
        pasienEntityArrayList = new ArrayList<Muhammad07102_PasienEntity>();
    }
    
    public void insertPasien(Muhammad07102_PasienEntity pasien) {
        pasienEntityArrayList.add((Muhammad07102_PasienEntity) pasien);
    }
    
    public void updatePasien(int isData, Muhammad07102_PasienEntity pasien) {
        pasienEntityArrayList.set(isData, (Muhammad07102_PasienEntity) pasien);
    }
    
    public void deletePasien(int isData) {
        pasienEntityArrayList.remove(isData);
    }
    
    @Override
    public void view(boolean isViewAll) {
        int i=0;
        if(pasienEntityArrayList.isEmpty()) System.out.println("Data Kosong!\n");
        for(Muhammad07102_PasienEntity pasienEntity : pasienEntityArrayList) {
            if(isViewAll == true) System.out.println("Data Ke "+i);
            if(isViewAll == true) System.out.println("=================================");
            System.out.println("NIK : "+pasienEntity.getNik());
            System.out.println("Nama Pasien : "+pasienEntity.getNama());
            System.out.println("Tanggal Lahir : "+new SimpleDateFormat("dd-MM-yyyy").format(pasienEntity.getTglLahir()));
            System.out.println("No. Telepon : "+pasienEntity.getNoTelp());
            System.out.println("Alamat : "+pasienEntity.getAlamat());
            if(pasienEntity.getJenisKelamin() == 0) System.out.println("Jenis Kelamin : Laki-Laki");
            else System.out.println("Jenis Kelamin : Perempuan");
            if(isViewAll == true) System.out.println("=================================");
            if(isViewAll == true) System.out.println();
            i++;
        }
    }
    
    @Override
    public int cekData(int nik, String password) {
        int loop = 0;
        boolean isLogin = false;
        for(Muhammad07102_PasienEntity pasienEntity : pasienEntityArrayList) {
            if(pasienEntity.getNik() == nik && pasienEntity.getPassword().equals(password)) {
                isLogin = true;
                break;
            } else {
                loop++;
            }
        }
        if(isLogin == false) loop = -1;
        return loop;
    }
    
    public Muhammad07102_PasienEntity showDataPasien(int index) {
        return pasienEntityArrayList.get(index);
    }
    
    public ArrayList<Muhammad07102_PasienEntity> isEmptyData(){
        return pasienEntityArrayList;
    }
}
