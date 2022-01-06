/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import java.awt.BorderLayout;
import java.text.SimpleDateFormat;  
import java.util.Date;    


/**
 *
 * @author SNIR
 */
public class PanelChange {
    

    public void  changePanel (javax.swing.JPanel container,javax.swing.JPanel pnl )
    {
      
        pnl.setSize(1200,1200);
        pnl.setLocation(0,0);
        container.removeAll();
        container.add(pnl,BorderLayout.CENTER);
        container.revalidate();
        container.repaint();
        
    }
    
    public String gettime ()
    { 
        
        Date date = new Date();
        SimpleDateFormat  formate = new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss"); 
        String day =formate.format(date);
        
        return "DATA: "+day;
    }
    
}
