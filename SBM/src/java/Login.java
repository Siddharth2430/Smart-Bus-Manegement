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

/**
 *
 * @author SIDDHARTH
 */
public class Login extends HttpServlet {

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
           try{
                     if(req.getParameter("challan").equals("")||req.getParameter("password").equals(""))
                     {
                                      JOptionPane.showMessageDialog(null,"Field are empty...!!!");
                                      res.sendRedirect("Login.html");
                     }
                     else{
                         
                     
            //   out.println("2");
              Statement st= con.createStatement();
              //out.println("3");
            ResultSet rs=st.executeQuery("Select challan,password from reg_stud where challan='"+req.getParameter("challan")+"'");
          //out.println("4");
            if(rs.next())
            {
                if(rs.getString(1).equals(req.getParameter("challan"))&&rs.getString(2).equals(req.getParameter("password")))
                {
                    try{
                          Statement st1 = con.createStatement();
                                    ResultSet rs1=st1.executeQuery("Select bus from reg_stud where challan='"+req.getParameter("challan")+"'");
                    rs=st.executeQuery("Select enroll,firstname,lastname,phone,route,shift,stop from stud_data where challan='"+req.getParameter("challan")+"'");
                    if(rs.next()&&rs1.next())
                    {
                        String name=rs.getString(2).concat(" "+rs.getString(3));
                       
                        HttpSession session = req.getSession();
                        session.setAttribute("enroll", rs.getString(1));
                        session.setAttribute("name", name);
                        session.setAttribute("challan", req.getParameter("challan"));
                        session.setAttribute("phone", rs.getString(4));
                        session.setAttribute("route", rs.getString(5));
                        session.setAttribute("shift", rs.getString(6));
                        session.setAttribute("stop", rs.getString(7));

                        session.setAttribute("bus",rs1.getInt(1));
                   // req.setAttribute("enroll", rs.getString(1));
                    //req.setAttribute("name", rs.getString(2));
                    rd.forward(req, res);
                    } // res.sendRedirect("Dashboard.html");
                    }
                    catch(Exception ex)
                    {
                                      JOptionPane.showMessageDialog(null,ex);
                                      res.sendRedirect("Login.html");
                    }
                }
                else
                {
                                                    JOptionPane.showMessageDialog(null,"Invalid");
                     res.sendRedirect("Login.html");
                }
            }
            else{
                                               JOptionPane.showMessageDialog(null,"No data Found");
                                               res.sendRedirect("Login.html");
            }
                     }
           }
           catch(Exception ex)
           {
                             JOptionPane.showMessageDialog(null,ex);
                             res.sendRedirect("Login.html");
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
