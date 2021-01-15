/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Font;
import java.text.SimpleDateFormat;

public class Muhammad07102_PasienGUI {
    JFrame Pasien = new JFrame();
    JButton register,back;
    JTextArea area = new JTextArea();
    JLabel datadiri,daftarperiksa;
    JComboBox pilperiksa = new JComboBox(Muhammad07102_TypeEntity.Muhammad07102_Poli);
    int cek = Muhammad07102_Allobjctrl.pasien.cekDaftarPeriksa(Muhammad07102_Allobjctrl.pasien.pasienEntity().getNik());

    public Muhammad07102_PasienGUI() {
    	Pasien.setSize(720, 500);
    	Pasien.setLayout(null);
    	Pasien.getContentPane().setBackground(Color.LIGHT_GRAY);
    	datadiri = new JLabel("Data Pasien");
    	datadiri.setFont(new Font("Times New Roman",Font.BOLD,30));
    	datadiri.setBounds(90,30,200,30);
    	Pasien.add(datadiri);

    	area.setBounds(30,90,300,200);
    	Pasien.add(area);
    	daftarperiksa = new JLabel("Daftar Pasien");
    	daftarperiksa.setBounds(450,30,250,30);
    	daftarperiksa.setFont(new Font("Times New Roman",Font.BOLD,30));
    	Pasien.add(daftarperiksa);
    	pilperiksa.setBounds(450,90,230,30);
    	Pasien.add(pilperiksa);

    	register = new JButton("Daftar");
    	register.setBounds(500,200,100,30);
    	register.setBackground(Color.GREEN);
    	Pasien.add(register);

    	back = new JButton("Back");
    	back.setBounds(30,400,100,30);
    	back.setBackground(Color.YELLOW);
    	Pasien.add(back);
    	
    	Pasien.setVisible(true);
    	Pasien.setLocationRelativeTo(null);
    	Pasien.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        if(cek == -1) JOptionPane.showMessageDialog(null, "Anda Belum Mendaftar!","information",JOptionPane.INFORMATION_MESSAGE);
    	else if(cek == -2) JOptionPane.showMessageDialog(null, "Anda Belum Mendaftar!","information",JOptionPane.INFORMATION_MESSAGE);
    	else area.setText(datapasien());
    	
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int indexprak = pilperiksa.getSelectedIndex();
                Muhammad07102_Allobjctrl.pasien.daftarPeriksa(indexprak, Muhammad07102_Allobjctrl.pasien.getData(), false);
                area.setText(datapasien());
            }
    	});
    	back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Pasien.dispose();
                Muhammad07102_GUI index = new Muhammad07102_GUI();
            }
    	});
    }
    String datapasien() {
    	int cek = Muhammad07102_Allobjctrl.pasien.cekDaftarPeriksa(Muhammad07102_Allobjctrl.pasien.pasienEntity().getNik());
    	String cekstatus = "Belum Di Setujui Dokter";
    	if(Muhammad07102_Allobjctrl.pasien.showDaftarPeriksa(cek).isAccept()) {
            cekstatus = "Sudah Di Setujui Dokter";
    	}
    	String text = "NPM = "+Muhammad07102_Allobjctrl.pasien.showDaftarPeriksa(cek).getPasien().getNik()+"\n"+
    	"Nama = "+Muhammad07102_Allobjctrl.pasien.showDaftarPeriksa(cek).getPasien().getNama()+"\n"+
    	"No Telp = "+Muhammad07102_Allobjctrl.pasien.showDaftarPeriksa(cek).getPasien().getNoTelp()+"\n"+
    	"Tanggal Lahir = "+new SimpleDateFormat("dd-MM-yyyy").format(Muhammad07102_Allobjctrl.pasien.showDaftarPeriksa(cek).getPasien().getTglLahir())+"\n"+
        "Nama Poli = "+Muhammad07102_TypeEntity.Muhammad07102_Poli[Muhammad07102_Allobjctrl.pasien.showDaftarPeriksa(cek).getIndexPeriksa()]+"\n"+
    	"Status = "+cekstatus;
    	return text;
    }
}
