/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author ahmed khaled
 */
public class query  extends JFrame implements ActionListener {
      JLabel name1=new JLabel();
        JLabel name2=new JLabel();
        JLabel name3=new JLabel();
        JLabel name4=new JLabel();
        JButton start = new JButton("Show results");
        JButton back = new JButton("Back to Query");

    public query()
    { 
         this.setTitle("Final Result");
        this.setSize(500,500);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setForeground(Color.red);
        this.setResizable(false);
      
        name2.setBounds(100,50, 120, 20);
        this.add(name1);
        this.add(name2);
        name3.setBounds(140, 50, 120 , 20);
        this.add(name3);
        name4.setBounds(180, 50 , 120 , 20);
        this.add(name4);
        start.setBounds(350, 395, 120 , 25);
        this.add(start);
        start.addActionListener(this);
        back.setBounds(20, 395, 120 , 25);  
        this.add(back);
        back.addActionListener(this);
        
      //this.remove(query);    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
