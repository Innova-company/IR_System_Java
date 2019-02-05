/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pkg1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Ahmed
 */
public class Query extends JFrame implements ActionListener
{
    public static String UserQuery ;
    JTextArea query=new JTextArea();
     JButton next = new JButton("Next");
    
    public Query ()
    {
        this.setTitle("Insert Query");
        this.setSize(500,500);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        query.setBounds(15, 100 , 430 , 40);
        this.add(query);
        next.setBounds(180, 220, 120 , 50);
        this.add(next);
        next.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        this.setVisible(false);
        model_test m=new model_test();
        m.setVisible(true);
        this.UserQuery = query.getText();
        
        
    }
    
}
