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
public class SignUp extends HttpServlet {

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
        res.setContentType("text/html;charset=UTF-8");
        RequestDispatcher rd= req.getRequestDispatcher("Dashboard_U.jsp");
        try (PrintWriter out = res.getWriter()) {
               
            
                   
             try{
                       if(req.getParameter("enroll").equals("")||req.getParameter("challan").equals("")||req.getParameter("password").equals(""))
                     {
                                       JOptionPane.showMessageDialog(null,"Field are empty...!!!");
                                       res.sendRedirect("Signup.html");
                     }
                     else{       
                           System.out.println("2");
              Statement st= con.createStatement();
              ResultSet rs=st.executeQuery("Select enroll, challan from stud_data where enroll='"+req.getParameter("enroll")+"'");
               if(rs.next())
            {
                System.out.println("3");
                if(rs.getString(1).equals(req.getParameter("enroll"))&&rs.getString(2).equals(req.getParameter("challan")))
                {
                    System.out.println("4");
                      PreparedStatement ps=con.prepareStatement("Insert into reg_stud values(?,?,?)");
                     System.out.println("a");
                      ps.setString(1, req.getParameter("enroll"));
                      ps.setString(2, req.getParameter("challan"));
                      ps.setString(3, req.getParameter("password"));
                      ps.executeUpdate();
                    System.out.println("b");
                                try{
                                    Statement st1 = con.createStatement();
                                    ResultSet rs1=st1.executeQuery("Select bus from reg_stud where challan='"+req.getParameter("challan")+"'");
                                        rs=st.executeQuery("Select enroll,firstname,lastname,phone,route,shift from stud_data where challan='"+req.getParameter("challan")+"'");
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
                        session.setAttribute("bus",rs1.getInt(1));
// req.setAttribute("enroll", rs.getString(1));
                    //req.setAttribute("name", rs.getString(2));
                    rd.forward(req, res);
                    } // res.sendRedirect("Dashboard.html");
                    }
                    catch(Exception ex)
                    {
                                      JOptionPane.showMessageDialog(null,ex);
                                      res.sendRedirect("Signup.html");
                    }
                     // res.sendRedirect("Dashboard_U.html");
                       // res.sendRedirect("Dashboard.html");
                }
                else
                {
                                                     JOptionPane.showMessageDialog(null,"Invalid Credentials");
                       res.sendRedirect("Signup.html");
                }
            }
            else{
                                                JOptionPane.showMessageDialog(null,"No data Found");
                                                res.sendRedirect("Signup.html");
            }
               
              //out.println("3");
          
          //out.println("4");

           
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
