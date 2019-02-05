
package model.pkg1;

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
        JButton start = new JButton("Show results");
        JButton back = new JButton("Back to Query");

    public model_test()
    { 
         this.setTitle("Final Result");
        this.setSize(500,500);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        name1.setBounds(180,50, 120, 20);
        name2.setBounds(220,50, 120, 20);
        this.add(name1);
        this.add(name2);
        name3.setBounds(260, 50, 120 , 20);
        this.add(name3);
        name4.setBounds(300, 50 , 120 , 20);
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
    public void actionPerformed(ActionEvent ae) 
    {  
       Query q=new Query();  
    if (ae.getSource() == start)
    {
      
      //New nf=new New();
      String D1= New.names[0];
      String D2= New.names[1];
      String D3= New.names[2];
      String D4= New.names[3];
       
       
       String names[]={D1,D2,D3,D4};
       name1.setText(names[0]);
       name2.setText(names[1]);
       name3.setText(names[2]);
       name4.setText(names[3]);
       //String Query = q.query.getText(); 
       
       String UQuery =Query.UserQuery ;

       
       
       
       /*********************************************************************/
       
       
        String name1[]={D1+".txt",D2+".txt",D3+".txt",D4+".txt"};
      // Model1 m=new Model1();
       
         Model1 m=new Model1();
       ArrayList<String> wordslist[] =  new ArrayList[4];
       for(int i = 0 ;i < 4 ; i++)
       {
         wordslist[i] = new ArrayList<String>();
         wordslist[i] = m.notreapet(m.token(m.readFile(name1[i])));
       }
       ArrayList <String> list = m.notreapetWordsDocument(wordslist[0],wordslist[1],wordslist[2],wordslist[3]);
       int a = list.size();
       int True[][] = m.existINdocument(a,list,wordslist[0],wordslist[1],wordslist[2],wordslist[3]);
      System.out.print("\t");
        for(int j = 0;j<4;j++)
        {
            System.out.print(name1[j]+"\t");
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
       int [] res = m.queryResult(list,True,UQuery);
       
           System.out.print("\n\n\n"); 
       for (int l =0 ; l<4 ;l++)
           System.out.print(res[l]+"\t");
     System.out.print(m.matchQuery(res,name1));
       
       
     
     int height = 50;
     int Width  = 140;
     Label j[] = new Label[list.size()];
     Label jres[] = new Label[4];

     Label jD[][] = new Label[list.size()][4];

     
       for(int i = 0;i<list.size();i++)
       {
           j[i] = new Label(list.get(i));
           j[i].setBounds(10, height+40, 120, 40);
           this.add(j[i]);
           
        for(int l = 0;l<4;l++)
        {
            //System.out.print("\t"+True[i][j]+"\t");
            
            jD[i][l] = new Label(True[i][l]+"");
            jD[i][l].setBounds(Width+40, height+40, 30, 40);
            this.add(jD[i][l]);
            Width  += 40;
            
        }
        Width  = 140;
            height +=40; 
       }
       
       Label ji = new Label("res");
       ji.setBounds(10, height+40, 120, 40);
       this.add(ji);
       

       
       Width  = 140;
       for (int l =0 ; l<4 ;l++)
       {
            jres[l]= new Label(res[l]+"");
            jres[l].setBounds(Width+40, height+40, 30, 40);
            this.add(jres[l]);
            Width  += 40;
            
       }
        JLabel noresult =new JLabel("Query is not Exsit");
        noresult.setBounds(150,340, 120, 20);
        ArrayList<String> fin=m.matchQuery(res,name1);
        Label jm = new Label("exist in :- ");
       jm.setBounds(10,height+80, 120, 40);
       this.add(jm);   
       Width  = 140;
       Label jqu[] = new Label[fin.size()];
       
        for (int l =0 ; l<jqu.length ;l++)
       {
           
            jqu[l]= new Label(fin.get(l)+"");
            jqu[l].setBounds(Width+40, height+80, 30, 40);
          
            this.add(jqu[l]);
            Width  += 40;
            

            
       }
       


    }
    else if(ae.getSource() == back)
    {
        q.setVisible(true);
        this.setVisible(false);
        
      
    }   
     
       
    }
    
       
}
