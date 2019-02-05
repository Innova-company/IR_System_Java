
package model3;

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
import java.util.Spliterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class Model3 
{

    

    public static void main(String[] args) 
    {
       Start us =new Start();
        
       // us.setVisible(true);
        Model3 m=new Model3();
       
        String namesfiles[]={"d1.txt","d2.txt","d3.txt","d4.txt"}; 
       ArrayList<String> wordslist[] =  new ArrayList[4];
       for(int i = 0 ;i < 4 ; i++)
       {
         wordslist[i] = new ArrayList<String>();
         wordslist[i] = m.token(m.readFile(namesfiles[i]));
       }
       
     // m.docQuery2("rise in july",namesfiles, wordslist[0], wordslist[1], wordslist[2], wordslist[3]);
      //System.out.println(m.docQueryPos("adel ahmed kotp",namesfiles, wordslist[0], wordslist[1], wordslist[2], wordslist[3]));
          m.matchQuery(m.docQueryPos("rise in july",namesfiles, wordslist[0], wordslist[1], wordslist[2], wordslist[3]),"rise in july");
   
    }
    
    
    
 public String readFile(String name)
 {
      String everything = null;
      BufferedReader br = null;
      String line = null;
        try {
            br = new BufferedReader(new FileReader(name));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Model3.class.getName()).log(Level.SEVERE, null, ex);
        }
try {
    StringBuilder sb = new StringBuilder();
          try {
              line = br.readLine();
          } catch (IOException ex) {
              Logger.getLogger(Model3.class.getName()).log(Level.SEVERE, null, ex);
          }

    while (line != null) {
        sb.append(line);
        sb.append(System.lineSeparator());
        try {
            line = br.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Model3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     everything = sb.toString();
} finally {
          try {
              br.close();
          } catch (IOException ex) {
              Logger.getLogger(Model3.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Model3.class.getName()).log(Level.SEVERE, null, ex);
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
 


 
  public ArrayList<String>  []docQuery(String Query,String namesfiles[],ArrayList<String>wordsFile1,ArrayList<String> wordsFile2,ArrayList<String> wordsFile3,ArrayList<String> wordsFile4)
 {
     Model3 m=new Model3();
     //ArrayList<String> listindex1=new ArrayList<String>();
     //ArrayList<String> listindex2=new ArrayList<String>();
     //ArrayList<String> listindex3=new ArrayList<String>();
     //ArrayList<String> listindex4=new ArrayList<String>();
     
     //ArrayList <String> list = m.notreapetWordsDocument(wordsFile1,wordsFile2,wordsFile3,wordsFile4);

     
     String []qulist=Query.split(" ");
     ArrayList<String> arr[] = new ArrayList[qulist.length];
     for(int i = 0 ; i<qulist.length;i++)
     {
         arr[i] = new ArrayList<String>();
     }
     int i = 0;
     for(String word : qulist)
     {
         
         arr[i].add(word+"->>>  ");
         if(wordsFile1.contains(word))
         {
             
             for(int y=0;y<wordsFile1.size();y++)
             {
                 if(wordsFile1.get(y).equals(word))
                 {
                  arr[i].add(" ( "+namesfiles[0]+" ) "+"  index is -> ( "+y+" )");
                 }
                
             }
           
            
         }
   
         i++;
     }
     
     
     
     i = 0;
     for(String word : qulist)
     {
         
         
         if(wordsFile2.contains(word))
         {
             
             for(int y=0;y<wordsFile2.size();y++)
             {
                 if(wordsFile2.get(y).equals(word))
                 {
                  arr[i].add(" ( "+namesfiles[1]+" ) "+"  index is -> ( "+y+" )");
                 }
                
             }
           
            
         }
   
         i++;
     }
     
     
     i = 0;
     for(String word : qulist)
     {
         
         
         if(wordsFile3.contains(word))
         {
             
             for(int y=0;y<wordsFile3.size();y++)
             {
                 if(wordsFile3.get(y).equals(word))
                 {
                  arr[i].add(" ( "+namesfiles[2]+" ) "+"  index is -> ( "+y+" )");
                 }
                
             }
           
            
         }
   
         i++;
     }
     
     i = 0;
     for(String word : qulist)
     {
         
         
         if(wordsFile4.contains(word))
         {
             
             for(int y=0;y<wordsFile4.size();y++)
             {
                 if(wordsFile4.get(y).equals(word))
                 {
                 arr[i].add(" ( "+namesfiles[3]+" ) "+"  index is -> ( "+y+" )");
                 }
                
             }
           
            
         }
   
         i++;
     }
     
    /* 
     for(int l =0 ; l<qulist.length;l++)
     {
         for(String s : arr[l])
        { 
           System.out.print(s+" / ");
        }
        System.out.print("\n");

     
     }*/
    
    return arr;
     
 }
  
  
  public ArrayList<String>  []docQueryPos(String Query,String namesfiles[],ArrayList<String>wordsFile1,ArrayList<String> wordsFile2,ArrayList<String> wordsFile3,ArrayList<String> wordsFile4)
 {
     Model3 m=new Model3();
     //ArrayList<String> listindex1=new ArrayList<String>();
     //ArrayList<String> listindex2=new ArrayList<String>();
     //ArrayList<String> listindex3=new ArrayList<String>();
     //ArrayList<String> listindex4=new ArrayList<String>();
     
     //ArrayList <String> list = m.notreapetWordsDocument(wordsFile1,wordsFile2,wordsFile3,wordsFile4);

     
     String []qulist=Query.split(" ");
     ArrayList<String> arr[] = new ArrayList[qulist.length];
     for(int i = 0 ; i<qulist.length;i++)
     {
         arr[i] = new ArrayList<String>();
     }
     int i = 0;
     for(String word : qulist)
     {
         
         arr[i].add(word);
         if(wordsFile1.contains(word))
         {
             
             for(int y=0;y<wordsFile1.size();y++)
             {
                 if(wordsFile1.get(y).equals(word))
                 {
                  arr[i].add(namesfiles[0]+","+y);
                  
                 }
                
             }
           
            
         }
   
         i++;
     }
     
     
     
     i = 0;
     for(String word : qulist)
     {
         
         
         if(wordsFile2.contains(word))
         {
             
             for(int y=0;y<wordsFile2.size();y++)
             {
                 if(wordsFile2.get(y).equals(word))
                 {
                  arr[i].add(namesfiles[1]+","+y);
                 }
                
             }
           
            
         }
   
         i++;
     }
     
     
     i = 0;
     for(String word : qulist)
     {
         
         
         if(wordsFile3.contains(word))
         {
             
             for(int y=0;y<wordsFile3.size();y++)
             {
                 if(wordsFile3.get(y).equals(word))
                 {
                  arr[i].add(namesfiles[2]+","+y);
                 }
                
             }
           
            
         }
   
         i++;
     }
     
     i = 0;
     for(String word : qulist)
     {
         
         
         if(wordsFile4.contains(word))
         {
             
             for(int y=0;y<wordsFile4.size();y++)
             {
                 if(wordsFile4.get(y).equals(word))
                 {
                 arr[i].add(namesfiles[3]+","+y);
                 }
                
             }
           
            
         }
   
         i++;
     }
     
    /* 
     for(int l =0 ; l<qulist.length;l++)
     {
         for(String s : arr[l])
        { 
           System.out.print(s+" / ");
        }
        System.out.print("\n");

     
     }*/
    
    return arr;
     
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
   

 
 public void matchQuery( ArrayList []all,String Query)
 {
     ArrayList splitall=new ArrayList();
     String []splitQ=Query.split(" ");
     for(String word : splitQ)
     {
         splitall.add(word);
 

           System.out.println(splitall);
          
             
         

     }
     
 }

 

   


}
