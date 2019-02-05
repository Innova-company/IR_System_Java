
package model3;

import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Start extends JFrame implements ActionListener
{

    JButton Start_b=new JButton("Start Model");
    public Start()
    {
         this.setTitle("Start Model");
        this.setSize(500,500);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        Start_b.setBounds(185, 200, 120 , 50);
        this.add(Start_b);
        Start_b.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae) 
    {
        this.setVisible(false);
        New ns=new New();
        ns.setVisible(true);
        
        
    }


    
    
}

