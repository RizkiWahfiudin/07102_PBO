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
    private ArrayList<Muhammad07102_DokterEntity> dokterEntityArrayList;
    
    public Muhammad07102_DokterModel() {
        dokterEntityArrayList = new ArrayList<>();
    }
    
    public int viewAll() {
        return dokterEntityArrayList.size();
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
    
    public boolean isEmptyData(){
        return dokterEntityArrayList.isEmpty();
    }
}
