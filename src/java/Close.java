/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 *
 * @author upadhyays
 */
public class Close extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           
            /* TODO output your page here. You may use following sample code. */
            try { 
                Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_order","root","");
     
                    Connection conq = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_order","root","");
                    String email;
                    
                    Cookie ck[]=request.getCookies();  
                    if(ck!=null){  
                        email=ck[0].getValue(); 
                        
                        if(!email.equals("")||email!=null){
                            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM temp_cart WHERE email=?");
                            
                            pstmt.setString(1, email);
                            ResultSet rs1 = pstmt.executeQuery();
                            PreparedStatement ps=conq.prepareStatement("INSERT INTO order_table values(?,?,?,?)");
                            while(rs1.next()) {
                                String p = rs1.getString("item");
                    
                          
                                
                                String n= rs1.getString("email");
                                
                                int price=rs1.getInt("price");
                                
                                ps.setString(1, n);
                                ps.setString(2, p);
                                ps.setInt(3, price);
                                Date date = new Date();
                                ps.setString(4, date.toString());
                                int i = ps.executeUpdate();
                                
                               
                            }
                           pstmt = con.prepareStatement("DELETE FROM temp_cart WHERE email=?");
                           pstmt.setString(1, email);
                           int i = pstmt.executeUpdate();
                           request.getRequestDispatcher("menu.html").include(request, response);
                        }
                    }
                            
                    
                    
                    
            }
            catch(Exception e) {} 
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
