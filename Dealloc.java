/*
*
* Project Name: 	SMART BUS MANAGEMENT
* Author List: 		SIDDHARTH SHRIVASTAVA, RAJESHWARI KAUSHAL
* Filename: 		Dealloc.java
* Functions: 		init(),processRequest()
* Global Variables:	
*
*/

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.ConnectionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author SIDDHARTH
 */
public class Dealloc extends HttpServlet {

Connection con=null;
    @Override
public void init()
{
    try{
   con =ConnectionDB.giveConnection();
    //JOptionPane.showMessageDialog(null,"1");
      //  System.out.println("1");
    }
    catch(Exception ex)
    {
       JOptionPane.showMessageDialog(null,ex);
       
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
         
       RequestDispatcher rd=req.getRequestDispatcher("Dashboard_U.jsp");
       res.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = res.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if(req.getParameter("enr").equals(""))
                     {
                                      JOptionPane.showMessageDialog(null,"Field is empty...!!!");
                                      res.sendRedirect("alloc_dealloc.jsp");
                     }
            else{
                    try{
                          Statement st = con.createStatement();
                          String enr=req.getParameter("enr");
                                   st.executeUpdate("Update reg_stud set book=0 where challan in ("+enr+")");
                                    st.executeUpdate("Update reg_stud set bus=0 where challan in ("+enr+")");
                                    JOptionPane.showMessageDialog(null,"Deallocation Successfull");
                                                                         res.sendRedirect("alloc_dealloc.jsp");
                   
                    
                    }
                    catch(Exception ex)
                    {
                                      JOptionPane.showMessageDialog(null,ex);
                                      res.sendRedirect("alloc_dealloc.jsp");
                    }
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
