/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;


public class payment {
        public void calcHours(){
         Date dt=new Date();
    SimpleDateFormat myf=new SimpleDateFormat("hh:mm");
        System.out.println(myf.format(dt));
    }
}
