/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author ahmed khaled
 */

    public class write_query extends JFrame implements ActionListener
{
    public static String UserQuery ;
    JTextArea query=new JTextArea();
     JButton next = new JButton("Next");
    
    public write_query ()
    {
        this.setTitle("Insert Query");
        this.setSize(500,500);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        query.setBounds(10, 10 , 430 , 40);
        this.add(query);
        next.setBounds(215, 220, 120 , 50);
        this.add(next);
        next.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae)
    {
        
        this.UserQuery = query.getText();
   if(this.query.getText().equals("")){
        JOptionPane.showMessageDialog(this,"Enter your query");
        }  
 else{
 result re = new result();
        re.setVisible(true);
        this.setVisible(false);
 }
        
    }
    public static ArrayList<Integer> anding (ArrayList<Integer> b,ArrayList<Integer> f){
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        for(int i=0;i<f.size();i++){
            for(int j=0;j<b.size();j++)
            {
               if(f.get(i)==b.get(j))
               {
                   result.add(f.get(i));
               }
            }
        }
        return result;
    }
    
     public static ArrayList<ArrayList<Integer>> queryResult(String query, HashMap<String, ArrayList<Integer>> tokensWDocsId) {
        ArrayList<ArrayList<Integer>> allPosting = new ArrayList<ArrayList<Integer>>();
        String[] quList = query.split(" ");
        for (int i = 0; i < quList.length; i++) {
            ArrayList<Integer> postingOfNot = null;
            ArrayList<Integer> postingOfToken = null;
            if (quList[i].toUpperCase().equals("NOT")) {
                int afterNot = i + 1;
                postingOfNot = tokensWDocsId.get(quList[afterNot]);
                for (int k = 1; k < 5; k++){
                    if (postingOfNot.contains(new Integer(k))) {
                        postingOfNot.remove(new Integer(k));
                    }
                    else{
                        postingOfNot.add(new Integer(k));
                    }
                }
                allPosting.add(postingOfNot);
            }
        }

        for (int i = 0; i < quList.length; i++) {
            ArrayList<Integer> postingBeAnd = null;
            ArrayList<Integer> postingAfAnd = null;
            if (quList[i].toUpperCase().equals("AND")) {
                int afterAnd = i + 1;
                int beforAnd = i - 1;
                postingAfAnd = tokensWDocsId.get(quList[afterAnd]);
                postingBeAnd = tokensWDocsId.get(quList[beforAnd]);
                allPosting.add(anding(postingAfAnd,postingBeAnd));
            }
        }
        
        ArrayList<Integer> rrrrrrr = new ArrayList<Integer>();
        for (int i = 0;i < quList.length; i++) {
            ArrayList<Integer> postingBeOr = null;
            ArrayList<Integer> postingAfOr = null;
            
            if (quList[i].toUpperCase().equals("OR")) {
                allPosting.remove(rrrrrrr);
                int afterOr = i + 1;
                int beforeOr = i - 1;
                postingBeOr = tokensWDocsId.get(quList[beforeOr]);
                postingAfOr = tokensWDocsId.get(quList[afterOr]);
                postingAfOr.addAll(postingBeOr);
                LinkedHashSet<Integer> lhs = new LinkedHashSet<Integer>();
                lhs.addAll(postingAfOr);
                postingAfOr.clear();
                postingAfOr.addAll(lhs);
                Collections.sort(postingAfOr);
                rrrrrrr = postingAfOr;
                allPosting.add(postingAfOr);
            }
        }
        if(quList.length==1)
        {
            ArrayList<Integer> posting = null;
            posting = tokensWDocsId.get(quList[0]);
            allPosting.add(posting);
        }
       return allPosting;
        
    }
      
}
