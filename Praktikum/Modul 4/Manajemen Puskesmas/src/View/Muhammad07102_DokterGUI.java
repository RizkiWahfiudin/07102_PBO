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

public class Muhammad07102_DokterGUI {
    private static Muhammad07102_PasienController pasien = new Muhammad07102_PasienController();
    JFrame Dokter = new JFrame();
    JTable tabelpasien = new JTable();
    JScrollPane scrolldokter = new JScrollPane(tabelpasien);
    JButton submit,back;
    JLabel dokter,niklabel,passlabel;
    JTextField niktext,passtext;
    
    public Muhammad07102_DokterGUI() {
    	Dokter.setSize(650, 500);
    	Dokter.setLayout(null);
    	Dokter.getContentPane().setBackground(Color.MAGENTA);
        
    	dokter = new JLabel("Dokter");
    	dokter.setBounds(250,30,200,30);
    	dokter.setFont(new Font("Times New Roman",Font.BOLD,40));
    	Dokter.add(dokter);

    	scrolldokter.setBounds(30,100,570,200);
    	tabelpasien.setModel(pasien.daftarperiksa());
    	Dokter.add(scrolldokter);

    	niklabel = new JLabel("NIK");
    	niklabel.setBounds(50,320,100,30);
    	Dokter.add(niklabel);

    	niktext = new JTextField();
    	niktext.setBounds(50,350,100,30);
    	Dokter.add(niktext);

    	passlabel = new JLabel("Password");
    	passlabel.setBounds(200,320,100,30);
    	Dokter.add(passlabel);

    	passtext = new JTextField();
    	passtext.setBounds(200,350,100,30);
    	Dokter.add(passtext);

    	submit = new JButton("Accept");
    	submit.setBounds(350,350,100,30);
    	submit.setBackground(Color.GREEN);
    	Dokter.add(submit);

    	back = new JButton("Back");
    	back.setBounds(50,400,100,30);
    	back.setBackground(Color.YELLOW);
    	Dokter.add(back);
    	
    	Dokter.setLocationRelativeTo(null);
    	Dokter.setVisible(true);
    	Dokter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Dokter.dispose();
                Muhammad07102_GUI index = new Muhammad07102_GUI();
            }
    	});
    	submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int nik = Integer.parseInt(niktext.getText());
                String pass = passtext.getText();
                int index = Muhammad07102_AllObjectModel.daftarPeriksaModel.cekData(nik,pass);
                Muhammad07102_Allobjctrl.dokter.submitData(index, Muhammad07102_Allobjctrl.pasien.showDaftarPeriksa(index).getIndexPeriksa(), Muhammad07102_Allobjctrl.pasien.showDaftarPeriksa(index).getPasien());
                tabelpasien.setModel(pasien.daftarperiksa());
            }
    	});
    	tabelpasien.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tabelpasien.getSelectedRow();
                niktext.setText(Muhammad07102_Allobjctrl.pasien.daftarperiksa().getValueAt(i,0).toString());
                passtext.setText(Muhammad07102_Allobjctrl.pasien.daftarperiksa().getValueAt(i,2).toString());
            }
    	});
    }
}
