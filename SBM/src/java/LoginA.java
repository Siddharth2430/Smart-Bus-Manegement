/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author SIDDHARTH
 */
public class LoginA extends HttpServlet {

Connection con=null;
    @Override
public void init()
{
    try{
   con =ConnectionDB.giveConnection();
    //showMessageDialog(null,"con done");
      //  System.out.println("1");
    }
    catch(Exception ex)
    {
        showMessageDialog(null,"con "+ex);
    }
}
            
           
           
            
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param req
     * @param res
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
         
       RequestDispatcher rd=req.getRequestDispatcher("Dashboard_A.jsp");
       res.setContentType("text/html;charset=UTF-8");
      // showMessageDialog(null,"#0");
        try (PrintWriter out = res.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
        //    showMessageDialog(null,"0");
           try{
          //     showMessageDialog(null,"1");
                     if(req.getParameter("eid").equals("")||req.getParameter("password").equals(""))
                     {
                                      JOptionPane.showMessageDialog(null,"Field are empty...!!!");
                                      res.sendRedirect("LoginA.html");
                     }
                     else{
            //   showMessageDialog(null,"2");          
                     
            //   out.println("2");
              Statement st= con.createStatement();
            //  showMessageDialog(null,"3");
              //out.println("3");
            ResultSet rs=st.executeQuery("Select eid,password from admin where eid='"+req.getParameter("eid")+"'");
           // showMessageDialog(null,"4");
          //out.println("4");
            if(rs.next())
            {
                if(rs.getString(1).equals(req.getParameter("eid"))&&rs.getString(2).equals(req.getParameter("password")))
                {
                    
                        
                       
                        HttpSession session = req.getSession();
                        session.setAttribute("eid", rs.getString(1));
                        

                      
                   // req.setAttribute("enroll", rs.getString(1));
                    //req.setAttribute("name", rs.getString(2));
                    rd.forward(req, res);
                    } // res.sendRedirect("Dashboard.html");
                  
                
                else
                {
                                                    JOptionPane.showMessageDialog(null,"Invalid");
                       res.sendRedirect("LoginA.html");
                }
            }
            else{
                                               JOptionPane.showMessageDialog(null,"No data Found");
                                               res.sendRedirect("LoginA.html");
            }
                     }
           }
           catch(Exception ex)
           {
                             JOptionPane.showMessageDialog(null,"log "+ex);
                             res.sendRedirect("LoginA.html");
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
