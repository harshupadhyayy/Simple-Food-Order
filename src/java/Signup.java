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

/**
 *
 * @author upadhyays
 */
public class Signup extends HttpServlet {

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
            response.setContentType("text/html");  
          
        //request.getRequestDispatcher("link.html").include(request, response);  
          
        String email=request.getParameter("email");  
        String password=request.getParameter("password");  
          
        try{
            Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_order","root","");
                    PreparedStatement st = con.prepareStatement("INSERT INTO user_login value(?,?)");
                    st.setString(1, email);
                    st.setString(2, password);
                    
                    int i = st.executeUpdate();
           
                    
                    if(i==1){
                        
                        request.getRequestDispatcher("login.html").forward(request, response); 
                    }
                    else {  
            out.print("<p align='center'> Username or password error! </p>");  
            request.getRequestDispatcher("signup.html").forward(request, response);  
        } 
                }
                catch(Exception e){}
        /*if(password.equals("admin1234")){  
            out.print("You are successfully logged in!");  
            out.print("<br>Welcome, "+name);  
          */    
          out.close();    
        }/*else{  
            out.print("sorry, username or password error!");  
            request.getRequestDispatcher("login.html").include(request, response);  
        }  */
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
}
