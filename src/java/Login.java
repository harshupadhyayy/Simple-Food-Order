/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author upadhyays
 */
public class Login extends HttpServlet {

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
        
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();
        //request.getRequestDispatcher("link.html").include(request, response);  
        
        String email=request.getParameter("email");  
        String password=request.getParameter("password");  
      
        try{
            Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_order","root","");
                    Statement st = con.createStatement();
                    
                    
                    ResultSet rs = st.executeQuery("SELECT * FROM user_login");
                    int flag=0;
                    while(rs.next())
                    {
                        String n=rs.getString("email");
                        String p=rs.getString("password");
                        if(email.equals(n)){
                            if(password.equals(p)){
                            flag=1;
                            }
                    }
                    }
                    
                        
                    
                    if(flag==1){
                        Cookie ck=new Cookie("email",email);  
            response.addCookie(ck);
            HttpSession session = request.getSession();
                    session.setAttribute("email", email);
                        request.getRequestDispatcher("Menu").include(request, response);
           
             
            //request.getRequestDispatcher("afterlogin.html").include(request, response); 
                    }
                    else if(flag==0){  
            out.print("<p align='center'> Username or password error! </p>");  
            request.getRequestDispatcher("login.html").include(request, response);  
        } 
                }
                catch(Exception e){}
        
        
        
        /*if(password.equals("admin1234")){  
            out.print("You are successfully logged in!");  
            out.print("<br>Welcome, "+name);  
          */    
          out.close();    
        }
}
