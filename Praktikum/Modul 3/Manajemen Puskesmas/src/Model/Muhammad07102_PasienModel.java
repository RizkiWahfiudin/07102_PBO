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
    
    public void PasienModel() {
        pasienEntityArrayList = new ArrayList<Muhammad07102_PasienEntity>();
    }
    
    public int viewAll() {
        return pasienEntityArrayList.size();
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
    
    public boolean isEmptyData(){
        return pasienEntityArrayList.isEmpty();
    }
}
