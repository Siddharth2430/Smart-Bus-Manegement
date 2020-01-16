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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author SIDDHARTH
 */
public class Alloc extends HttpServlet {

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
        int data_cnt=0; 
       
       res.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = res.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           try{
            Statement st= con.createStatement();
               System.out.println("1");
            ResultSet rs=st.executeQuery("Select bus_no,bus_seats,avail_seats from bus_sched where avail_seats !=0");
            System.out.println("2");
            
            ArrayList <Integer> avail= new ArrayList<>();
               Map<Integer, Integer> bus = new HashMap<Integer, Integer>();
            while(rs.next())
            {
                avail.add(rs.getInt(3));
                System.out.println("3");
                data_cnt++;
               bus.put(rs.getInt(1), rs.getInt(2));
            }
            if(data_cnt==0){
                                               JOptionPane.showMessageDialog(null,"No Bus data Found");
                                               res.sendRedirect("alloc_dealloc.jsp");
            }
            JOptionPane.showMessageDialog(null,avail);
            System.out.println("4");
            rs=st.executeQuery("Select count(challan),route from reg_stud where book=1 group by route");
            System.out.println("5");
               
              
               int scnt,min,dif,bs;
            while(rs.next())
            {
                scnt=Integer.parseInt(rs.getString(1));
                min=50;
                dif=0;
                bs=0;
                System.out.println("6");
                data_cnt++;
               
              int i=1;
               System.out.println("7");
               for(;i<=4;i++)
               {
                   if(scnt>0)
                   {
                           if(scnt<avail.get(i-1)+2)
                                {
                                     System.out.println("9");
                                      System.out.println("99");
                                       dif=avail.get(i-1)-scnt+2;
                                      System.out.println("8");
                                       if(min>dif&&dif>=0)
                                  {
                                             System.out.println("10");
                                              min=dif;
                                              bs=i;
                                  }
                                  }
                                      
                             
                   }
               }
               
               avail.remove(bs-1);
                avail.add(bs-1, bus.get(bs)-scnt);
                      System.out.println("16");
               Statement st1=con.createStatement();
               st1.executeUpdate("update bus_sched set bus_route='"+rs.getString(2)+"'where bus_no="+bs);
               System.out.println("17");
               st1.executeUpdate("update reg_stud set bus='"+bs+"'where book=1 and route='"+rs.getString(2)+"'");
               System.out.println("18");
               st1.executeUpdate("update bus_sched set avail_seats="+avail.get(bs-1)+" where bus_no="+bs);
                              System.out.println("19");
            }
            if(data_cnt==0){
                                               JOptionPane.showMessageDialog(null,"No Bus data Found");
                                               res.sendRedirect("alloc_dealloc.jsp");
            }
            
            
            
                res.sendRedirect("alloc_dealloc.jsp");
           }
           catch(Exception ex)
           {
                             JOptionPane.showMessageDialog(null,"alloc"+ex);
                             res.sendRedirect("alloc_dealloc.jsp");
           
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
