/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

public class Muhammad07102_AdminGUI {
    private static Muhammad07102_DokterController dokter = new Muhammad07102_DokterController();
    JFrame Admin = new JFrame();
    JTable tabeldokter = new JTable();
    JScrollPane scrolldokter = new JScrollPane(tabeldokter);
    JButton update,delete,back;
    JRadioButton radiopria,radiowanita;
    JLabel userdokter,labelnik,labelnama,labelpass,labeltgllahir,labelalamat,labeljeniskelamin,labelspesialis;
    JTextField nomor,textnik,textnama,textpass,texttgllahir,textalamat,textspesialis;
    
    public Muhammad07102_AdminGUI() {
    	Admin.setSize(800, 700);
    	Admin.setLayout(null);
    	Admin.getContentPane().setBackground(Color.ORANGE);
        
        userdokter = new JLabel("Data Dokter");
    	userdokter.setBounds(250,30,350,30);
    	userdokter.setFont(new Font("Times New Roman",Font.BOLD,40));
    	Admin.add(userdokter);
        
    	scrolldokter.setBounds(30,100,720,150);
    	tabeldokter.setModel(dokter.daftardokter());
    	Admin.add(scrolldokter);
        
        nomor = new JTextField();
    	nomor.setBounds(0,0,0,0);
    	Admin.add(nomor);

    	labelnik = new JLabel("NIK");
    	labelnik.setBounds(50,270,150,30);
    	Admin.add(labelnik);
    	textnik = new JTextField();
    	textnik.setBounds(50,300,150,30);
    	Admin.add(textnik);
        
        labelnama = new JLabel("Nama");
    	labelnama.setBounds(220,270,150,30);
    	Admin.add(labelnama);
    	textnama = new JTextField();
    	textnama.setBounds(220,300,150,30);
    	Admin.add(textnama);

    	labelpass = new JLabel("Password");
    	labelpass.setBounds(50,330,150,30);
    	Admin.add(labelpass);
    	textpass = new JTextField();
    	textpass.setBounds(50,360,150,30);
    	Admin.add(textpass);
        
        labeltgllahir = new JLabel("Tanggal Lahir (dd/mm/yyyy)");
    	labeltgllahir.setBounds(220,330,150,30);
    	Admin.add(labeltgllahir);
    	texttgllahir = new JTextField();
    	texttgllahir.setBounds(220,360,150,30);
    	Admin.add(texttgllahir);

    	labelalamat = new JLabel("Alamat");
    	labelalamat.setBounds(50,390,150,30);
    	Admin.add(labelalamat);
    	textalamat = new JTextField();
    	textalamat.setBounds(50,420,150,30);
    	Admin.add(textalamat);
        
        labeljeniskelamin = new JLabel("Jenis Kelamin");
    	labeljeniskelamin.setBounds(220,390,150,30);
    	Admin.add(labeljeniskelamin);
        radiopria = new JRadioButton("Pria");
    	radiopria.setBounds(220,420,70,30);
    	radiopria.setBackground(Color.CYAN);
    	Admin.add(radiopria);
        radiowanita = new JRadioButton("Wanita");
    	radiowanita.setBounds(300,420,70,30);
    	radiowanita.setBackground(Color.CYAN);
    	Admin.add(radiowanita);
        
        labelspesialis = new JLabel("Spesialis");
        labelspesialis.setBounds(50,450,150,30);
        Admin.add(labelspesialis);
        textspesialis = new JTextField();
        textspesialis.setBounds(50,480,150,30);
        Admin.add(textspesialis);

    	update = new JButton("Update");
    	update.setBounds(520,600,100,30);
    	update.setBackground(Color.CYAN);
    	Admin.add(update);
        
        delete = new JButton("Delete");
    	delete.setBounds(650,600,100,30);
    	delete.setBackground(Color.YELLOW);
    	Admin.add(delete);

    	back = new JButton("Back");
    	back.setBounds(50,600,100,30);
    	back.setBackground(Color.LIGHT_GRAY);
    	Admin.add(back);
    	
    	Admin.setLocationRelativeTo(null);
    	Admin.setVisible(true);
    	Admin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tabeldokter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabeldokter.getSelectedRow();
                nomor.setText(Muhammad07102_Allobjctrl.dokter.daftardokter().getValueAt(i,0).toString());
                textnik.setText(Muhammad07102_Allobjctrl.dokter.daftardokter().getValueAt(i,1).toString());
                textnama.setText(Muhammad07102_Allobjctrl.dokter.daftardokter().getValueAt(i,2).toString());
                textpass.setText(Muhammad07102_Allobjctrl.dokter.daftardokter().getValueAt(i,3).toString());
                texttgllahir.setText(Muhammad07102_Allobjctrl.dokter.daftardokter().getValueAt(i,4).toString());
                textalamat.setText(Muhammad07102_Allobjctrl.dokter.daftardokter().getValueAt(i,5).toString());
                radiopria.setSelected(true);
                radiowanita.setSelected(false);
                if(Muhammad07102_Allobjctrl.dokter.daftardokter().getValueAt(i,6).toString() == "Perempuan") {
                    radiowanita.setSelected(true);
                    radiopria.setSelected(false);
                }
                textspesialis.setText(Muhammad07102_Allobjctrl.dokter.daftardokter().getValueAt(i,7).toString());
            }
    	});
        radiopria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(radiopria.isSelected()) radiowanita.setSelected(false);
            }
    	});
        radiowanita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(radiowanita.isSelected()) radiopria.setSelected(false);
            }
    	});
    	back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Admin.dispose();
                Muhammad07102_GUI index = new Muhammad07102_GUI();
            }
    	});
    	update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int index = Integer.parseInt(nomor.getText());
                int nik = Integer.parseInt(textnik.getText());
                String nama = textnama.getText();
                String pass = textpass.getText();
                Date tglLahir = new Date(texttgllahir.getText());
                String alamat = textalamat.getText();
                int jenisKelamin = radiopria.isSelected()?0:1;
                String spesialis = textspesialis.getText();
                Muhammad07102_Allobjctrl.dokter.update(index,nik,nama,pass,tglLahir,alamat,jenisKelamin,spesialis);
                JOptionPane.showMessageDialog(null, "Update Data Berhasil!","Status",JOptionPane.INFORMATION_MESSAGE);
                Admin.dispose();
                Muhammad07102_AdminGUI gui = new Muhammad07102_AdminGUI();
            }
    	});
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int index = Integer.parseInt(nomor.getText());
                Muhammad07102_Allobjctrl.dokter.delete(index);
                JOptionPane.showMessageDialog(null, "Delete Data Berhasil!","Status",JOptionPane.INFORMATION_MESSAGE);
                Admin.dispose();
                Muhammad07102_AdminGUI gui = new Muhammad07102_AdminGUI();
            }
    	});
    }
}