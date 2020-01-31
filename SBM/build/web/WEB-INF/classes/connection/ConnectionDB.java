/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.DriverManager;
import java.sql.Connection;
import static javax.swing.JOptionPane.showMessageDialog;
/**
 *
 * @author SIDDHARTH
 */
public class ConnectionDB {
  
    public static Connection giveConnection()
    {
        Connection  con=null;
        try{
             Class.forName("com.mysql.jdbc.Driver");
         con =DriverManager.getConnection("jdbc:mysql://bmrwh7xhwgbrqzkq4r5z-mysql.services.clever-cloud.com:3306/bmrwh7xhwgbrqzkq4r5z","ulvugdvz55ka9izl","d5ED5DbpghKTQWalLWww");
            //showMessageDialog(null,"Done");
        }
        catch(Exception ex)
        {
            showMessageDialog(null,"CON "+ex);
            
        }
        return con;
    }
        
}
