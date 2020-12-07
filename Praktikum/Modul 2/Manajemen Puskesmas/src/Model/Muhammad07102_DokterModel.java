/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Muhammad07102_DokterEntity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class Muhammad07102_DokterModel implements Muhammad07102_ModelInterfaces {
    private ArrayList<Muhammad07102_DokterEntity> dokterEntityArrayList = new ArrayList();
    
    public void DokterModel() {
        dokterEntityArrayList = new ArrayList<Muhammad07102_DokterEntity>();
    }
    
    public void insertDokter(Muhammad07102_DokterEntity dokter) {
        dokterEntityArrayList.add((Muhammad07102_DokterEntity) dokter);
    }
    
    public void updateDokter(int isData, Muhammad07102_DokterEntity dokter) {
        dokterEntityArrayList.set(isData,(Muhammad07102_DokterEntity) dokter);
    }
    
    public void deleteDokter(int isData) {
        dokterEntityArrayList.remove(isData);
    }
    
    @Override
    public void view(boolean isViewAll) {
        int i=0;
        if(dokterEntityArrayList.isEmpty()) System.out.println("Data Kosong!\n");
        for(Muhammad07102_DokterEntity dokterEntity : dokterEntityArrayList) {
            if(isViewAll == true) System.out.println("Data Ke "+i);
            if(isViewAll == true) System.out.println("=================================");
            System.out.println("NIK : "+dokterEntity.getNik());
            System.out.println("Nama Dokter : "+dokterEntity.getNama());
            System.out.println("Tanggal Lahir : "+new SimpleDateFormat("dd-MM-yyyy").format(dokterEntity.getTglLahir()));
            System.out.println("Alamat : "+dokterEntity.getAlamat());
            if(dokterEntity.getJenisKelamin() == 0) System.out.println("Jenis Kelamin : Laki-Laki");
            else System.out.println("Jenis Kelamin : Perempuan");
            System.out.println("Spesialis : "+dokterEntity.getSpesialis());
            if(isViewAll == true) System.out.println("=================================");
            if(isViewAll == true) System.out.println();
            i++;
        }
    }
    
    @Override
    public int cekData(int nik, String password) {
        int loop = 0;
        boolean isLogin = false;
        for(Muhammad07102_DokterEntity dokterEntity : dokterEntityArrayList) {
            if(dokterEntity.getNik() == nik && dokterEntity.getPassword().equals(password)) {
                isLogin = true;
                break;
            } else {
                loop++;
            }
        }
        if(isLogin == false) loop = -1;
        return loop;
    }
    
    public Muhammad07102_DokterEntity showDataDokter(int index) {
        return dokterEntityArrayList.get(index);
    }
    
    public ArrayList<Muhammad07102_DokterEntity> isEmptyData(){
        return dokterEntityArrayList;
    }
}
