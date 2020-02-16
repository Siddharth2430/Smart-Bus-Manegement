/*
*
* Project Name: 	SMART BUS MANAGEMENT
* Author List:		SIDDHARTH SHRIVASTAVA, RAJESHWARI KAUSHAL
* Filename: 		  ConnetionDB.java
* Functions: 		
* Global Variables:	
*
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
  
    /*
                            *
                            * Function Name: 	giveConnection()
                            * Input: 		
                            * Output: 		It returns an object of Connection type.
                            * Logic: 		Connects to the database and if successfull, it returns connection object
                            * Example Call:		ConnectionDB.giveConnection();
                            *
                            */
    public static Connection giveConnection()
    {
      //con is 
        Connection  con=null;
        try{
            showMessageDialog(null,"1");
             Class.forName("com.mysql.jdbc.Driver");
             showMessageDialog(null,"2");
         con =DriverManager.getConnection("jdbc:mysql://eparkm.mysql.database.azure.com:3306/sbmanage", "chetan@eparkm","devvrat@01");
showMessageDialog(null,"3");         
//           con =DriverManager.getConnection("jdbc:mysql://localhost:3306/bmrwh7xhwgbrqzkq4r5z", "root","siddharth"); 
        }
        catch(Exception ex)
        {
            showMessageDialog(null,"CON "+ex);
            
        }
        return con;
    }
        
}
