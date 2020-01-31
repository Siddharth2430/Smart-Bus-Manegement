/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import connection.ConnectionDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class Addadmin extends HttpServlet {

    Connection con=null;
      /*
                            *
                            * Function Name: 	init
                            * Input: 		
                            * Output: 		
                            * Logic: 		initialize the components defined in it only once
                            * Example Call:		init(); - it is automatically provoked by the process.
                            *
                            */
    @Override
public void init()
{
    try{
   con =ConnectionDB.giveConnection();
     
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
    
      /*
                            *
                            * Function Name: 	processRequest
                            * Input: 		HttpServletRequest req - for request processing, HttpServletResponse res - - for response processing
                            * Output: 		
                            * Logic: 		it executes the code in it whenever this servlet is requested
                            * Example Call:		processRequest(Request, Response) - automatically invoked
                            *
                            */
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd= req.getRequestDispatcher("Dashboard_A.jsp");
        try (PrintWriter out = res.getWriter()) {
               
            
                   
             try{
                       if(req.getParameter("enroll").equals("")||req.getParameter("challan").equals("")||req.getParameter("password").equals(""))
                     {
                                       JOptionPane.showMessageDialog(null,"Field are empty...!!!");
                                       res.sendRedirect("Signup.html");
                     }
                     else{       
                           
              

                                try{
                                    PreparedStatement st= con.prepareStatement("insert into complaint values(?,?)");
                                    st.setString(1, req.getParameter("eid"));
                                    st.setString(2, req.getParameter("password"));
                                    JOptionPane.showMessageDialog(null,"SignUp Successfull.");
           
                             
                                       
                    }
                    catch(Exception ex)
                    {
                                      JOptionPane.showMessageDialog(null,ex);
                                      res.sendRedirect("Signup.html");
                    }
                    

           
                       }
           }
           catch(Exception ex)
           {
                             JOptionPane.showMessageDialog(null,ex);
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
