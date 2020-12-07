/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Muhammad07102_AdminEntity;
import java.util.ArrayList;
public class Muhammad07102_AdminModel implements Muhammad07102_ModelInterfaces {
    private ArrayList<Muhammad07102_AdminEntity> adminEntityArrayList = new ArrayList();
    
    public void DokterModel() {
        adminEntityArrayList = new ArrayList<Muhammad07102_AdminEntity>();
    }
    
    public void insertAdmin(Muhammad07102_AdminEntity admin) {
        adminEntityArrayList.add((Muhammad07102_AdminEntity) admin);
    }
    
    @Override
    public void view(boolean isViewAll) {
        
    }
    
    @Override
    public int cekData(int nik, String password) {
        int loop = 0;
        boolean isLogin = false;
        for(Muhammad07102_AdminEntity adminEntity : adminEntityArrayList) {
            if(adminEntity.getNik() == nik && adminEntity.getPassword().equals(password)) {
                isLogin = true;
                break;
            } else {
                loop++;
            }
        }
        if(isLogin == false) loop = -1;
        return loop;
    }
    
    public Muhammad07102_AdminEntity showDataAdmin(int index) {
        return adminEntityArrayList.get(index);
    }
}
