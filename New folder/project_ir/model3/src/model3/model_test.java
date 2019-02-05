
package model3;

import java.awt.Label;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


public class model_test extends JFrame implements ActionListener
{
        JLabel name1=new JLabel();
        JLabel name2=new JLabel();
        JLabel name3=new JLabel();
        JLabel name4=new JLabel();
        JLabel namequery=new JLabel();
        
        JButton start = new JButton("Show results");
        JButton back = new JButton("Back to Query");

    public model_test()
    { 
         this.setTitle("Final Result");
        this.setSize(900,600);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        start.setBounds(570, 500, 120 , 25);
        this.add(start);
        start.addActionListener(this);
        back.setBounds(22, 500, 120 , 25);
        this.add(back);
        back.addActionListener(this);
        
    }


    @Override
    public void actionPerformed(ActionEvent ae) 
    {  
       Query q=new Query();  
    if (ae.getSource() == start)
    {
      String D1= New.names[0];
      String D2= New.names[1];
      String D3= New.names[2];
      String D4= New.names[3];
       
       
       String names[]={D1,D2,D3,D4};
       name1.setText(names[0]);
       name2.setText(names[1]);
       name3.setText(names[2]);
       name4.setText(names[3]);
       
        String UQuery =Query.UserQuery ;
        String name1[]={D1+".txt",D2+".txt",D3+".txt",D4+".txt"};       
         Model3 m=new Model3();
       ArrayList<String> wordslist[] =  new ArrayList[4];
       for(int i = 0 ;i < 4 ; i++)
       {
         wordslist[i] = new ArrayList<String>();
         wordslist[i] = m.token(m.readFile(name1[i]));
       }
       
       ArrayList[] arr = m.docQuery(UQuery, name1, wordslist[0], wordslist[1], wordslist[2], wordslist[3]);

     int height = 50;
     int Width  = 140;
       height = 0;
       Width  = 20;
       Label jqu[] = new Label[arr.length];
         
        for (int l =0 ; l<arr.length ;l++)
       {
           
            jqu[l]= new Label(arr[l]+"");
            jqu[l].setBounds(Width+40, height+10, 900, 40);
            
            this.add(jqu[l]);
            height  += 40;   
       }
    }
    else if(ae.getSource() == back)
    {
        q.setVisible(true);
        this.setVisible(false);    
    }   
    }
    
    
}
