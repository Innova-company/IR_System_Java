/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model2;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import static model2.Model2.getPosting;
import static model2.files.notreapet;
import static model2.files.readFile;
import static model2.files.token;

/**
 *
 * @author ahmed khaled
 */
public class posting extends JFrame implements ActionListener{
        JButton start = new JButton("show tokens");
        JButton next = new JButton("write query");
      Label l = new Label();  
    
    public posting(){
    this.setSize(500,500);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
       /*l.setSize(400, 400);
       this.add(l);*/
       
        start.setBounds(350, 395, 120 , 25);
        this.add(start);
        start.addActionListener(this);
        next.setBounds(200, 395, 120 , 25);
        this.add(next);
        next.addActionListener(this);
    
}
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet.");
        tokens f = new tokens();
        ArrayList<String> wordslist[] = new ArrayList[4];
        if(e.getSource() == start){
            wordslist = tokens.wordslist12 ; 
             ArrayList<String> docs = f.notreapetWordsDocument(wordslist[0], wordslist[1], wordslist[2], wordslist[3]);
        Collections.sort(docs);
        
        ArrayList<Integer> Posting = new ArrayList<Integer>();
        HashMap<String, ArrayList<Integer>> tokensWDocsId = new HashMap<String, ArrayList<Integer>>();
        Label l [] = new Label[docs.size()];
        int Height = 0;
        for (int i = 0; i < docs.size(); i++) {
            Posting = getPosting(docs.get(i), wordslist);
            System.out.println(docs.get(i) + " " + Posting); 
            l[i] = new Label(docs.get(i) + " " + Posting);
            l[i].setBounds(10, Height+50, 120, 40);
            this.add(l[i]);
            Height += 40;
            tokensWDocsId.put(docs.get(i), Posting);
        }
        }
        
       else if(e.getSource() == next)
    {
      write_query q = new write_query();
      q.setVisible(true);
      this.setVisible(false);
    }
    }
    
}
