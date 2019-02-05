/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model1;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author ahmed khaled
 */
public class gui extends JFrame implements ActionListener{
     JTextField field = new JTextField(2);
    JTextField field2 = new JTextField(4);
    JLabel Jlabel1 = new JLabel("name of file");
    JLabel Jlabel2 = new JLabel("content of file");
    JButton start = new JButton("create file");

    public gui()
    {
        this.setTitle("IR");
        this.setSize(350,350);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        field.setBounds(20, 40, 120, 20);
        field2.setBounds(150,40, 120, 40);
        this.add(field);
        this.add(field2);
        Jlabel1.setBounds(20, 20, 120 , 20);
        this.add(Jlabel1);
        Jlabel2.setBounds(150, 20 , 120 , 20);
        this.add(Jlabel2);
        start.setBounds(70, 100 , 120 , 20);
        this.add(start);
        start.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
  String name = field.getText();
  String content = field2.getText();
  write_file(name,content);
  
    }
     public static void write_file(String file_name , String doc){
    
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(file_name+".txt"));
            bw.write(doc);
            bw.close();            
        } catch (IOException ex) {
            Logger.getLogger(Model1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
