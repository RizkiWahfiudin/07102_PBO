/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Entity.Muhammad07102_TypeEntity;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Muhammad07102_GUI {
    JFrame Index = new JFrame();
    JLabel login,register,top;
    JLabel labelniklogin,labelnama,labelpasswordlogin,labeltgllahir,labelnikregister,labelpasswordregister,labeljeniskelamin,labelalamat,labelspesialis,labelnotelp;
    JTextField textniklogin,textnama,texttgllahir,textalamat,textnikregister,textspesialis,textnotelp;
    JRadioButton radioadmin,radiodokterlogin,radiopasienlogin;
    JButton masuk,daftar;
    JPasswordField passwordlogin,passwordregister;
    private int ceklogin = 0;
    private boolean cekregister = false;
    private int gender = 0;
    
    public Muhammad07102_GUI() {
    	Index.setSize(700, 700);
    	Index.setLayout(null);
    	Index.getContentPane().setBackground(Color.CYAN);
    	top = new JLabel("Sistem Manajemen Puskesmas");
    	top.setBounds(70,10,600,50);
    	top.setFont(new Font("Times New Roman",Font.BOLD,40));
    	Index.add(top);

    	login = new JLabel("Login");
    	login.setBounds(100,50,100,100);
    	login.setFont(new Font("Times New Roman",Font.BOLD,30));
    	Index.add(login);

    	radioadmin = new JRadioButton("Admin");
    	radioadmin.setBounds(10,150,100,30);
    	radioadmin.setBackground(Color.CYAN);
    	Index.add(radioadmin);

    	radiodokterlogin = new JRadioButton("Dokter");
    	radiodokterlogin.setBounds(110,150,100,30);
    	radiodokterlogin.setBackground(Color.CYAN);
    	Index.add(radiodokterlogin);
        
        radiopasienlogin = new JRadioButton("Pasien");
    	radiopasienlogin.setBounds(210,150,100,30);
    	radiopasienlogin.setBackground(Color.CYAN);
    	Index.add(radiopasienlogin);

    	labelniklogin = new JLabel("NIK");
    	labelniklogin.setBounds(30,180,30,30);
    	Index.add(labelniklogin);

    	textniklogin = new JTextField();
    	textniklogin.setBounds(30,210,220,30);
    	Index.add(textniklogin);

    	labelpasswordlogin = new JLabel("Password");
    	labelpasswordlogin.setBounds(30,240,100,30);
    	Index.add(labelpasswordlogin);

    	passwordlogin = new JPasswordField();
    	passwordlogin.setBounds(30,270,220,30);
    	Index.add(passwordlogin);

    	masuk = new JButton("Masuk");
    	masuk.setBounds(90,320,100,40);
    	masuk.setBackground(Color.ORANGE);
    	Index.add(masuk);

    	register = new JLabel("Register");
    	register.setFont(new Font("Times New Roman",Font.BOLD,30));
    	register.setBounds(440,50,150,100);
    	Index.add(register);
        
        String typeuser[]={"Pilih Type","Dokter","Pasien"};
        JComboBox cb = new JComboBox(typeuser);    
        cb.setBounds(440,150,110,20);
        Index.add(cb);

    	labelnikregister = new JLabel("NIK");
    	labelnikregister.setBounds(400,180,30,30);
    	Index.add(labelnikregister);

    	textnikregister = new JTextField();
    	textnikregister.setBounds(400,210,200,30);
    	Index.add(textnikregister);

    	labelnama = new JLabel("Nama");
    	labelnama.setBounds(400,240,100,30);
    	Index.add(labelnama);

    	textnama = new JTextField();
    	textnama.setBounds(400,270,200,30);
    	Index.add(textnama);

    	labelpasswordregister = new JLabel("Password");
    	labelpasswordregister.setBounds(400,300,100,30);
    	Index.add(labelpasswordregister);

    	passwordregister = new JPasswordField();
    	passwordregister.setBounds(400,330,200,30);
    	Index.add(passwordregister);

    	labeltgllahir = new JLabel("Tanggal Lahir (dd/mm/yyyy)");
    	labeltgllahir.setBounds(400,360,200,30);
    	Index.add(labeltgllahir);

    	texttgllahir = new JTextField();
    	texttgllahir.setBounds(400,390,200,30);
    	Index.add(texttgllahir);

    	labelalamat = new JLabel("Alamat");
    	labelalamat.setBounds(400,420,200,30);
    	Index.add(labelalamat);

    	textalamat = new JTextField();
    	textalamat.setBounds(400,450,200,30);
    	Index.add(textalamat);
        
        labeljeniskelamin = new JLabel("Jenis Kelamin");
    	labeljeniskelamin.setBounds(400,480,200,30);
    	Index.add(labeljeniskelamin);
        
        JComboBox jk = new JComboBox(Muhammad07102_TypeEntity.Muhammad07102_Gender);    
        jk.setBounds(400,510,200,30);
        Index.add(jk);
        
        labelspesialis = new JLabel("Spesialis");
        labelspesialis.setBounds(400,540,100,30);
        Index.add(labelspesialis);

        textspesialis = new JTextField();
        textspesialis.setBounds(400,570,200,30);
        Index.add(textspesialis);
        
        labelnotelp = new JLabel("No. Telepon");
        labelnotelp.setBounds(400,540,100,30);
        Index.add(labelnotelp);

        textnotelp = new JTextField();
        textnotelp.setBounds(400,570,200,30);
        Index.add(textnotelp);

    	daftar = new JButton("Register");
    	daftar.setBounds(460,610,100,40);
    	daftar.setBackground(Color.ORANGE);
    	Index.add(daftar);

    	Index.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Index.setVisible(true);
    	Index.setLocationRelativeTo(null);
        
        labelspesialis.setVisible(false);
        textspesialis.setVisible(false);
        labelnotelp.setVisible(false);
        textnotelp.setVisible(false);
        daftar.setVisible(false);
        
    	radioadmin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(radioadmin.isSelected()) {
                    radiodokterlogin.setSelected(false);
                    radiopasienlogin.setSelected(false);
                    ceklogin = 1;
                }
            }
    	});
    	radiodokterlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(radiodokterlogin.isSelected()) {
                    radioadmin.setSelected(false);
                    radiopasienlogin.setSelected(false);
                    ceklogin = 2;
                }
            }
    	});
        radiopasienlogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(radiopasienlogin.isSelected()) {
                    radioadmin.setSelected(false);
                    radiodokterlogin.setSelected(false);
                    ceklogin = 3;
                }
            }
    	});
    	masuk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int nik = Integer.parseInt(textniklogin.getText());
                if(ceklogin == 1) {
                    try {
                        Muhammad07102_Allobjctrl.admin.dataAdmin();
                        Muhammad07102_Allobjctrl.admin.login(nik, passwordlogin.getText());
                        String nama = Muhammad07102_Allobjctrl.admin.adminEntity().getNama();
                        JOptionPane.showMessageDialog(null, "Selamat Datang "+nama,"information",JOptionPane.INFORMATION_MESSAGE);
                        Muhammad07102_AdminGUI admin = new Muhammad07102_AdminGUI();
                        Index.dispose();
                    } catch(Exception exception) {
                        JOptionPane.showMessageDialog(null, "NIK atau Password salah!","information",JOptionPane.INFORMATION_MESSAGE);
                        setNull();
                    }
                } else if(ceklogin == 2) {
                    try {
                        Muhammad07102_Allobjctrl.dokter.login(nik, passwordlogin.getText());
                        String nama = Muhammad07102_Allobjctrl.dokter.dokterEntity().getNama();
                        JOptionPane.showMessageDialog(null, "Selamat Datang "+nama,"information",JOptionPane.INFORMATION_MESSAGE);
                        Muhammad07102_DokterGUI dokter = new Muhammad07102_DokterGUI();
                        Index.dispose();
                    } catch(Exception exception) {
                        JOptionPane.showMessageDialog(null, "NIK atau Password salah!","information",JOptionPane.INFORMATION_MESSAGE);
                        setNull();
                    }
                } else if(ceklogin == 3) {
                    try {
                        Muhammad07102_Allobjctrl.pasien.login(nik, passwordlogin.getText());
                        String nama = Muhammad07102_Allobjctrl.pasien.pasienEntity().getNama();
                        JOptionPane.showMessageDialog(null, "Selamat Datang "+nama,"information",JOptionPane.INFORMATION_MESSAGE);
                        Muhammad07102_PasienGUI pasien = new Muhammad07102_PasienGUI();
                        Index.dispose();
                    } catch(Exception exception) {
                        JOptionPane.showMessageDialog(null, "NIK atau Password Salah!","information",JOptionPane.INFORMATION_MESSAGE);
                        setNull();
                    }
                }
            }
    	});
        cb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                JComboBox comboBox = (JComboBox) event.getSource();
                Object item = event.getItem();
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    if(item.toString() == "Dokter") {
                        labelspesialis.setVisible(true);
                        textspesialis.setVisible(true);
                        labelnotelp.setVisible(false);
                        textnotelp.setVisible(false);
                        daftar.setVisible(true);
                        cekregister = true;
                    } else if(item.toString() == "Pasien") {
                        labelspesialis.setVisible(false);
                        textspesialis.setVisible(false);
                        labelnotelp.setVisible(true);
                        textnotelp.setVisible(true);
                        daftar.setVisible(true);
                        cekregister = false;
                    } else {
                        labelspesialis.setVisible(false);
                        textspesialis.setVisible(false);
                        labelnotelp.setVisible(false);
                        textnotelp.setVisible(false);
                        daftar.setVisible(false);
                        cekregister = false;
                    }
                }
            }
        });
        jk.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent event) {
                JComboBox comboBox = (JComboBox) event.getSource();
                Object item = event.getItem();
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    if(item.toString() == "Perempuan") gender = 1;
                }
            }
        });
    	daftar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(cekregister==true) {
                    try {
                        int nik = Integer.parseInt(textnikregister.getText());
                        String nama = textnama.getText();
                        String pass = passwordregister.getText();
                        Date tglLahir = new Date(texttgllahir.getText());
                        String alamat = textalamat.getText();
                        int jenisKelamin = gender;
                        String spesialis = textspesialis.getText();
                        Muhammad07102_Allobjctrl.dokter.insert(nik,nama,pass,tglLahir,alamat,jenisKelamin,spesialis);
                        JOptionPane.showMessageDialog(null, "Registrasi Dokter Berhasil!","information",JOptionPane.INFORMATION_MESSAGE);
                        setNull();
                    } catch(Exception exception) {
                        JOptionPane.showMessageDialog(null, "Format Penulisan Salah!","Registrasi Gagal",JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    try {
                        int nik = Integer.parseInt(textnikregister.getText());
                        String nama = textnama.getText();
                        String pass = passwordregister.getText();
                        Date tglLahir = new Date(texttgllahir.getText());
                        String alamat = textalamat.getText();
                        int jenisKelamin = gender;
                        int notelp = Integer.parseInt(textnotelp.getText());
                        Muhammad07102_Allobjctrl.pasien.insert(nik,nama,pass,tglLahir,alamat,jenisKelamin,notelp);
                        JOptionPane.showMessageDialog(null, "Registrasi Pasien Berhasil!","information",JOptionPane.INFORMATION_MESSAGE);
                        setNull();
                    } catch(Exception exception) {
                        JOptionPane.showMessageDialog(null, "Format Penulisan Salah!","Registrasi Gagal",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
    	});
    }
    void setNull() {
        textnikregister.setText(null);
        passwordregister.setText(null);
        textnama.setText(null);
        texttgllahir.setText(null);
        textalamat.setText(null);
        textspesialis.setText(null);
        textnotelp.setText(null);
        textniklogin.setText(null);
        passwordlogin.setText(null);
    }
}
