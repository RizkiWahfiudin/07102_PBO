/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Muhammad07102_DaftarPeriksaEntity;
import java.util.ArrayList;
public class Muhammad07102_DaftarPeriksaModel implements Muhammad07102_ModelInterfaces {
    private ArrayList<Muhammad07102_DaftarPeriksaEntity> daftarPeriksaArrayList;
    public ArrayList<Muhammad07102_DaftarPeriksaEntity> alldataperiksa() {
        return daftarPeriksaArrayList;
    }
    public Muhammad07102_DaftarPeriksaModel() {
        daftarPeriksaArrayList = new ArrayList<Muhammad07102_DaftarPeriksaEntity>();
    }
    public void insertDaftarPeriksa(Muhammad07102_DaftarPeriksaEntity daftarPeriksa) {
        daftarPeriksaArrayList.add(daftarPeriksa);
    }
    public ArrayList<Muhammad07102_DaftarPeriksaEntity> getDaftarPeriksaArrayList() {
        return daftarPeriksaArrayList;
    }
    @Override
    public int cekData(int nik, String password) {
        int loop = 0;
        if(daftarPeriksaArrayList.size() == 0) loop = -1;
        else {
            for(int i=0;i<daftarPeriksaArrayList.size();i++) {
                if(daftarPeriksaArrayList.get(i).getPasien().getNik() == nik) {
                    loop = i;
                    break;
                } else loop = -2;
            }
        }
        return loop;
    }
    public Muhammad07102_DaftarPeriksaEntity showDaftarPeriksa(int index) {
        return daftarPeriksaArrayList.get(index);
    }
    public void submit(int index, Muhammad07102_DaftarPeriksaEntity daftarPeriksaEntity) {
        daftarPeriksaArrayList.set(index, daftarPeriksaEntity);
    }
}