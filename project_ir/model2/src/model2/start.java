/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
 import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author ahmed khaled
 */
public class start extends JFrame implements ActionListener {
    

    JButton Start_b=new JButton("Start Model");
    public start()
    {
         this.setTitle("Start Model");
        this.setSize(500,500);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        Start_b.setBounds(215, 200, 120 , 50);
        this.add(Start_b);
        Start_b.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        //this.setVisible(false);
     files f = new files();
     f.setVisible(true);
     this.setVisible(false);
  //      .setVisible(true);
        
        
    }


    
    
}
    
