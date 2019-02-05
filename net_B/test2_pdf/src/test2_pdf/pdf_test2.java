/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2_pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Ahmed
 */
public class pdf_test2 extends JFrame implements ActionListener 
{
    JLabel file_name = new JLabel("Enter Document name : ");
    JTextField content_file_name = new JTextField(2);
    
    JLabel document = new JLabel("Enter Document Content : ");
    JTextArea document_content = new JTextArea();
    
    JButton generate = new JButton("Generate Document");
    JButton close = new JButton("Close");


    public pdf_test2() 
    {
    
        this.setTitle("Generate Document");
        this.setSize(600,600);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        content_file_name.setBounds(250,140, 100, 30);
        document_content.setBounds(250,280, 300, 100);
        this.add(content_file_name);
        this.add(document_content);
        file_name.setBounds(100, 100, 200 ,100);
        this.add(file_name);
        document.setBounds(100, 250 , 200 ,100);
        this.add(document);
        generate.setBounds(200, 500 , 200 , 20);
        this.add(generate);
        
        close.setBounds(250, 530 , 100 , 20);
        this.add(close);
        close.addActionListener(this);
        generate.addActionListener(this);
        
        
    }

              

    @Override
    public void actionPerformed(ActionEvent ae) 
    {
    if (ae.getSource() == generate)
    {    
    String filename = content_file_name.getText();
    String documentcontent = document_content.getText();
    Generate_document(filename+".ppt",documentcontent);
    }
    else if (ae.getSource() == close)
    {
        WindowEvent close_btn= new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(close_btn);
    }
    }
    
    

    
   public static void Generate_document(String file_name , String doc_content)
   {
     try{ 
      Document document=new Document();
      PdfWriter.getInstance(document,new FileOutputStream(file_name));
      document.open();  
      document.add(new Paragraph(doc_content));
      document.close();
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e);
       }
    
    }
}
