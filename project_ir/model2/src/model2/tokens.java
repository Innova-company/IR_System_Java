/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model2;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static model2.Model2.getPosting;
import static model2.Model2.notreapetWordsDocument;
import static model2.files.notreapet;
import static model2.files.readFile;
import static model2.files.token;

/**
 *
 * @author ahmed khaled
 */
public class tokens extends JFrame implements ActionListener {
      public static HashMap<String, ArrayList<Integer>> tokensWDocsId = new HashMap<String, ArrayList<Integer>>();  
      public static ArrayList<String> wordslist12[] = new ArrayList[4];  
      JButton start = new JButton("show tokens");
        JButton next = new JButton("show posting");
      Label l = new Label();  

    public tokens()
    { 
         this.setTitle("Tokens of documents");
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
        
        
      //this.remove(query);    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<String> wordslist[] = new ArrayList[4];
        if (e.getSource() == start)
    {
        
        String [] docsName = files.names1;
        Label label [] = new Label[4];
       int Height = 10;
       ArrayList<String>[] wordslist1 = new ArrayList[4];
       for (int i = 0; i < 4; i++) {
           wordslist1[i] = new ArrayList<String>();
            try {
                wordslist1[i] = notreapet(token(readFile(docsName[i])));
            } catch (IOException ex) {
                Logger.getLogger(tokens.class.getName()).log(Level.SEVERE, null, ex);
            }
           //System.out.println(docsName[i] + wordslist[i] + "\n");
           label [i]= new Label(docsName[i] + wordslist1[i]) ;
           label [i].setBounds(10, Height+45, 120, 40);
           this.add(label [i]);
           Height +=40;
       }
        tokens.wordslist12 = wordslist1;
        
    } 
        else if(e.getSource() == next)
    {
        
        posting q=new posting();
        q.setVisible(true);
        this.setVisible(false);
      /*ArrayList<String> docs = notreapetWordsDocument(wordslist[0], wordslist[1], wordslist[2], wordslist[3]);
        Collections.sort(docs);
        ArrayList<Integer> Posting = new ArrayList<Integer>();
        HashMap<String, ArrayList<Integer>> tokensWDocsId = new HashMap<String, ArrayList<Integer>>();
        for (int i = 0; i < docs.size(); i++) {
            Posting = getPosting(docs.get(i), wordslist);
            System.out.println(docs.get(i) + " " + Posting);
            tokensWDocsId.put(docs.get(i), Posting);
        }
        this.tokensWDocsId = tokensWDocsId;
      */
    }   
    }
    
    public static ArrayList<Integer> getPosting(String token, ArrayList<String> docs[]) {

        ArrayList<Integer> Posting = new ArrayList<Integer>();

        if (docs[0].contains(token)) {
            Posting.add(1);
        }
        if (docs[1].contains(token)) {
            Posting.add(2);
        }
        if (docs[2].contains(token)) {
            Posting.add(3);
        }
        if (docs[3].contains(token)) {
            Posting.add(4);
        }

        return Posting;
    }
    
     public static ArrayList<String> notreapetWordsDocument(ArrayList<String> wordsFile1, ArrayList<String> wordsFile2, ArrayList<String> wordsFile3, ArrayList<String> wordsFile4) {
        String[] stopWords = {"!","@","#","$","%","^","&","*","(",")","_","+","=","-","÷","×","?","[","]","{","}","\"","|","||",";",":"};
        ArrayList<String> listword = new ArrayList<String>();
        for (String word : wordsFile1) {
            if (!listword.contains(word)) {
                listword.add(word);
            }
        }
        for (String word : wordsFile2) {
            if (!listword.contains(word)) {
                listword.add(word);
            }
        }
        for (String word : wordsFile3) {
            if (!listword.contains(word)) {
                listword.add(word);
            }
        }
        for (String word : wordsFile4) {
            if (!listword.contains(word)) {
                listword.add(word);
            }
        }
        for (int i = 0; i < stopWords.length; i++) {
            listword.remove(stopWords[i]);
        }
        return listword;
    }
  
}
