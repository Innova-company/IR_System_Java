/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model2;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static model2.write_query.queryResult;

/**
 *
 * @author ahmed khaled
 */
public class result extends JFrame implements ActionListener{
      JLabel name1=new JLabel();
        JLabel name2=new JLabel();
        JLabel name3=new JLabel();
        JLabel name4=new JLabel();
        JButton start = new JButton("Show results");
        JButton back = new JButton("Back to Query");

    public result()
    { 
         this.setTitle("Final Result");
        this.setSize(500,500);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
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
       if(e.getSource() == start){
           String query = write_query.UserQuery;
       HashMap<String, ArrayList<Integer>> tokensWDocsId = files.tokensWDocsId;
      
          
       /*ArrayList<ArrayList<Integer>> result = queryResult(query,tokensWDocsId);
        
       Label[] l = new Label[result.size()];
       for(int q = 0 ; q < (result.get(0)).size();q++ )
       {
           String s = files.names1[((result.get(0)).get(q))-1];
           l[q] = new Label(s);
           l[q].setBounds(10, 10, 120, 60);
           this.add(l[q]);
       }*/
       
         
       ArrayList<ArrayList<Integer>> result = queryResult(query,tokensWDocsId);

      Label l = new Label(result+"");
       l.setBounds(10, 10, 120, 60);
       this.add(l);
       }
       // System.out.println(result);
      else if(e.getSource() == back)
    {
        write_query q=new write_query();
        q.setVisible(true);
        this.setVisible(false);
        
      
    }     
        
    }
}
