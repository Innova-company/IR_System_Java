/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.pkg1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


/**
 *
 * @author ahmed khaled
 */
public class Model1 extends JFrame {
    
    
    public Model1()
    {
       /* setSize(800,700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Boolean Model");
        this.setLocationRelativeTo(null);*/
    }

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) 
    {   
       
        Start us =new Start();
        
        us.setVisible(true);
        
        Model1 m=new Model1();

      //String namesfiles[] = {"D1.txt","D2.txt","D3.txt","D4.txt"};
      //m.PrintAll(namesfiles,"ahmed not adel"); 
        //System.out.print(Arrays.toString(m.queryResult("Ahmed AND Magdy NOT khaled")));  
    }
    
    
 public String readFile(String name)
 {
      String everything = null;
      BufferedReader br = null;
      String line = null;
        try {
            br = new BufferedReader(new FileReader(name));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Model1.class.getName()).log(Level.SEVERE, null, ex);
        }
try {
    StringBuilder sb = new StringBuilder();
          try {
              line = br.readLine();
          } catch (IOException ex) {
              Logger.getLogger(Model1.class.getName()).log(Level.SEVERE, null, ex);
          }

    while (line != null) {
        sb.append(line);
        sb.append(System.lineSeparator());
        try {
            line = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Model1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     everything = sb.toString();
} finally {
          try {
              br.close();
          } catch (IOException ex) {
              Logger.getLogger(Model1.class.getName()).log(Level.SEVERE, null, ex);
          }
}
     
     return everything;
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
 
 public ArrayList<String> token(String document)
 {
     String words[];
     ArrayList<String> word =new ArrayList<String>();
     String [] lines=document.split(System.lineSeparator());

     for(int i=0;i<lines.length;i++)
     {
         words = lines[i].split(" ");
        for(int j=0;j<words.length;j++)
        {
            word.add(words[j]);
        }
     }
     
     return word;
 }
 
 public ArrayList<String> notreapet(ArrayList<String> wordsFile)
 {
     String[] stopWords = {"are", "too", "is", "and", "or", "the", "a", "we", "an", ",", "than", " ", "?", "!", "not", "then", "@", "$", "%", "as",
            "able", "about", "above", "away", "awfully", "be", "became", "because", "become", "becomes", "becoming", "been", "before",
            "beforehand", "behind", "being", "believe", "below", "beside", "besides", "best", "better", "between", "beyond", "both",
            "brief", "but", "by", "cannot", "her", "his", "there","but","BUT","But","these", "that", "those", "its", "can","!","\"","#","$","%","&","'","*","+",",",".","-","/",":",";","<","=",">","?","@","[","","\\","]","^","_","`","{","","","|","}","~"};
     ArrayList<String> listword= new ArrayList<String>();
     for(String word : wordsFile)
     {
         if(!listword.contains(word))
         {
             listword.add(word);
         }
     }
     for (int i = 0; i < stopWords.length; i++) 
        {
            listword.remove(stopWords[i]);
        }
     
     return listword;
 }
 
  public ArrayList<String> notreapetWordsDocument(ArrayList<String> wordsFile1,ArrayList<String> wordsFile2,ArrayList<String> wordsFile3,ArrayList<String> wordsFile4)
 {
     String[] stopWords = {"are", "too", "is", "and", "or", "the", "a", "we", "an", ",", "than", " ", "?", "!", "not", "then", "@", "$", "%", "as",
            "able", "about", "above", "away", "awfully", "be", "became", "because", "become", "becomes", "becoming", "been", "before",
            "beforehand", "behind", "being", "believe", "below", "beside", "besides", "best", "better", "between", "beyond", "both",
            "brief", "but", "by", "cannot", "her", "his", "there", "these", "that","But","but","BUT","those", "its", "can","!","\"","#","$","%","&","'","*","+",",",".","-","/",":",";","<","=",">","?","@","[","","\\","]","^","_","`","{","","","|","}","~"};
     ArrayList<String> listword= new ArrayList<String>();
     for(String word : wordsFile1)
     {
         if(!listword.contains(word))
         {
             listword.add(word);
         }
     }
     for(String word : wordsFile2)
     {
         if(!listword.contains(word))
         {
             listword.add(word);
         }
     }
     for(String word : wordsFile3)
     {
         if(!listword.contains(word))
         {
             listword.add(word);
         }
     }
     for(String word : wordsFile4)
     {
         if(!listword.contains(word))
         {
             listword.add(word);
         }
     }
     for (int i = 0; i < stopWords.length; i++) 
     {
            listword.remove(stopWords[i]);
      }
     
     return listword;
 }
   public int[][]  existINdocument(int a,ArrayList<String> wordsFile10,ArrayList<String> wordsFile1,ArrayList<String> wordsFile2,ArrayList<String> wordsFile3,ArrayList<String> wordsFile4)
   {
    int [][] exist = new int[a][4];
    int n = 0;
    for(String word : wordsFile10)
     {
         if(!wordsFile1.contains(word))
         {
             exist[n][0] = 0;
         }
         else
         {
             exist[n][0] = 1;
         }
         
         
         if(!wordsFile2.contains(word))
         {
             exist[n][1] = 0;
         }
         else
         {
             exist[n][1] = 1;
         }
         
         if(!wordsFile3.contains(word))
         {
             exist[n][2] = 0;
         }
         else
         {
             exist[n][2] = 1;
         }
         if(!wordsFile4.contains(word))
         {
             exist[n][3] = 0;
         }
         else
         {
             exist[n][3] = 1;
         }
         n++;
     }
       return exist;
   }
   
 public int [] queryResult(ArrayList<String> Querylist,int[][] Queryexistlist,String query)
 {
    int [] result = new int[4];  
    String []quList =query.toLowerCase().split(" ");
    
    for(int i=0;i<quList.length;i++)
    { 
        
        if(quList[i].toUpperCase().equals("NOT"))
        {
           int afterNot = i+1;
           
           int num = Querylist.indexOf(quList[afterNot]);
           //for(int j = 0;j<num;j++)
           //{
               for(int l = 0;l<4;l++)
               {
                   if(Queryexistlist[num][l]==0)
                   {
                       Queryexistlist[num][l] = 1;
                   }
                   else if(Queryexistlist[num][l]==1)
                   {
                       Queryexistlist[num][l] = 0;
                   }
                   
               //}
            }

           if (quList[0].toUpperCase().equals("NOT"))
           {
               
                quList[0] = "";
           }
           else{
            quList[i] = "AND";

           }
           
        }
    }
    
    
    
    for(int i=0;i<quList.length;i++)
    {
        if(quList[i].toUpperCase().equals("AND"))
        {
           int afterAnd = i+1;
           int beforAnd = i-1;                      
           int beforenum = Querylist.indexOf(quList[beforAnd]);
           int afternum = Querylist.indexOf(quList[afterAnd]);
           
           //for(int j = 0;j<num;j++)
           //{
               for(int l = 0;l<4;l++)
               {
                   if(Queryexistlist[beforenum][l]==1 && Queryexistlist[afternum][l]==1)
                   {
                       Queryexistlist[afternum][l] = 1;
                   }
                   else
                   {
                       Queryexistlist[afternum][l] = 0;
                   }
                   
               }
            //}
           quList[i]= ""; 
           quList[beforenum] = "";

           
           
        }
    }
    
    
    for(int i=0;i<quList.length;i++)
    {
        if(quList[i].toUpperCase().equals("OR"))
        {
           int afterOr = i+1;
           int beforeOr = i-1;                      
           int beforenum = Querylist.indexOf(quList[beforeOr]);
           int afternum = Querylist.indexOf(quList[afterOr]);
            //for(int j = 0;j<num;j++)
           //{
               for(int l = 0;l<4;l++)
               {
                   if(Queryexistlist[beforenum][l]==0 && Queryexistlist[afternum][l]==0)
                   {
                       Queryexistlist[afternum][l] = 0;
                   }
                   else
                   {
                       Queryexistlist[afternum][l] = 1;
                   }
                   
               }
            //}
           quList[i] = ""; 
           quList[beforenum] = "";

           
           
        }
    }
    
    
    
    for(int i=0;i<quList.length;i++)
    {
        if(!(quList[i].equals("")))
        {
            int num = Querylist.indexOf(quList[i]);
            for(int l = 0;l<4;l++)
               {
                  result[l] = Queryexistlist[num][l];
                   
               }
            
           
           
        }
    }
    
    
    return result; 
 }
 
 public ArrayList<String> matchQuery(int []result,String Doc_names[])
 {
     ArrayList<String> final_result=new ArrayList<String>();
     for(int i=0;i<result.length;i++)
     {
         if(result[i]==1)
         {
             final_result.add(Doc_names[i]);
         }
     }
     return final_result;
 }
 
  public void PrintAll(String namesfiles[],String Query)
 {
     Model1 m=new Model1();
       ArrayList<String> wordslist[] =  new ArrayList[4];
       for(int i = 0 ;i < 4 ; i++)
       {
         wordslist[i] = new ArrayList<String>();
         wordslist[i] = m.notreapet(m.token(m.readFile(namesfiles[i])));
       }
       ArrayList <String> list = m.notreapetWordsDocument(wordslist[0],wordslist[1],wordslist[2],wordslist[3]);
       int a = list.size();
       int True[][] = m.existINdocument(a,list,wordslist[0],wordslist[1],wordslist[2],wordslist[3]);
       System.out.print("\t");
        for(int j = 0;j<4;j++)
        {
            System.out.print(namesfiles[j]+"\t");
        }
        System.out.print("\n");
       for(int i = 0;i<list.size();i++)
       {
           System.out.print(list.get(i)+"\t");
        for(int j = 0;j<4;j++)
        {
            System.out.print("\t"+True[i][j]+"\t");
        }
        System.out.print("\n");
       }
       /*
        ahmed OR ibrahim AND adel AND ali
       ahmed OR "" "" "" ""  ali
       */
       int [] res = m.queryResult(list,True,Query);
       
           System.out.print("\n\n\n\n\n\n"); 
       for (int l =0 ; l<4 ;l++)
           System.out.print(res[l]+"\t");
     System.out.print(m.matchQuery(res,namesfiles));
       
     
 }
 




         

}
