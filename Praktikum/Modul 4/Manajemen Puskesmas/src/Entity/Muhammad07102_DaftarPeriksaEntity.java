/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

public class Muhammad07102_DaftarPeriksaEntity {
    private Muhammad07102_PasienEntity pasien;
    private boolean isAccept;
    private int indexPeriksa;

    public Muhammad07102_DaftarPeriksaEntity(int indexPeriksa,Muhammad07102_PasienEntity pasien, boolean isAccept) {
        this.pasien = pasien;
        this.isAccept = isAccept;
        this.indexPeriksa = indexPeriksa;
    }
    public Muhammad07102_PasienEntity getPasien() {
        return this.pasien;
    }
    public void setPasien(Muhammad07102_PasienEntity pasien) {
        this.pasien = pasien;
    }
    public boolean isAccept() {
        return isAccept;
    }
    public void setAccept(boolean verified) {
        this.isAccept = isAccept;
    }
    public int getIndexPeriksa() {
        return indexPeriksa;
    }
    public void setIndexPeriksa(int index) {
        this.indexPeriksa = index;
    }
}
