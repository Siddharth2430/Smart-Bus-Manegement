/*
*
* Project Name: 	SMART BUS MANAGEMENT
* Author List: 		SIDDHARTH SHRIVASTAVA, RAJESHWARI KAUSHAL
* Filename: 		Feedback.java
* Functions: 		init(),processRequest()
* Global Variables:	
*
*/

import connection.ConnectionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author SIDDHARTH
 */
public class Feedback extends HttpServlet {

    Connection con=null;
    @Override
public void init()
{
    try{
   con =ConnectionDB.giveConnection();
      //  JOptionPane.showMessageDialog(null,"1");
    }
    catch(Exception ex)
    {
        System.out.println(ex);
    }
}
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        HttpSession session=req.getSession();
        RequestDispatcher rd = req.getRequestDispatcher("Feedback.html");
        try (PrintWriter out = res.getWriter()) {
        
             try{
                     if(req.getParameter("message").equals(""))
                     {
                                       JOptionPane.showMessageDialog(null,"Field is empty...!!!");
                                       res.sendRedirect("feedback.html");
                     }
                     else{
                         
                     
                          Statement st= con.createStatement();
            
            st.executeUpdate("insert into complaint values('"+session.getAttribute("challan")+"','"+req.getParameter("message")+"')");
                        JOptionPane.showMessageDialog(null,"Feedback Submmitted");
                        res.sendRedirect("feedback.html");
            
                     }
           }
           catch(Exception ex)
           {
                             JOptionPane.showMessageDialog(null,ex);
                             res.sendRedirect("feedback.html");
           }
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
