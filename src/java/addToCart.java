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
public class addToCart extends HttpServlet {

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
            
            if(request.getParameter("1") != null){  
                try{ 
                    
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_order","root","");
                    Statement st = con.createStatement();
                    //out.println("<h>connection done</h>");
                    PreparedStatement ps=con.prepareStatement("INSERT INTO temp_cart values(?,?,?)");
                    String email;    
                    //name =request.getParameter("name");
                    Cookie ck[]=request.getCookies();  
        if(ck!=null){  
          email=ck[0].getValue();  
        if(!email.equals("")||email!=null){ 
                            ps.setString(1,email);
				ps.setString(2, "Paneer Chilli");
				ps.setInt(3, 150);
                         int i=ps.executeUpdate();
        }
        }
                        request.getRequestDispatcher("menu.html").include(request, response); 
                }catch(Exception e){}
            }
            
            
            if(request.getParameter("2") != null){
                try{ 
                    
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_order","root","");
                    Statement st = con.createStatement();
                    //out.println("<h>connection done</h>");
                    PreparedStatement ps=con.prepareStatement("INSERT INTO temp_cart values(?,?,?)");
                    String email;    
                    //name =request.getParameter("name");
                    Cookie ck[]=request.getCookies();  
        if(ck!=null){  
          email=ck[0].getValue();  
        if(!email.equals("")||email!=null){ 
                            ps.setString(1,email);
				ps.setString(2, "Hyderabadi Biryani");
				ps.setInt(3, 300);
                         int i=ps.executeUpdate();
        }
        }
                        request.getRequestDispatcher("menu.html").include(request, response); 
                }catch(Exception e){}
            }
            
            
            if(request.getParameter("3") != null){
                try{ 
                    
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_order","root","");
                    Statement st = con.createStatement();
                    //out.println("<h>connection done</h>");
                    PreparedStatement ps=con.prepareStatement("INSERT INTO temp_cart values(?,?,?)");
                    String email;    
                    //name =request.getParameter("name");
                    Cookie ck[]=request.getCookies();  
        if(ck!=null){  
          email=ck[0].getValue();  
        if(!email.equals("")||email!=null){ 
                            ps.setString(1,email);
				ps.setString(2, "Dry Manchurian");
				ps.setInt(3, 200);
                         int i=ps.executeUpdate();
        }
        }
                        request.getRequestDispatcher("menu.html").include(request, response); 
                }catch(Exception e){}
            }
            
            
            if(request.getParameter("4") != null){
                try{ 
                    
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_order","root","");
                    Statement st = con.createStatement();
                    //out.println("<h>connection done</h>");
                    PreparedStatement ps=con.prepareStatement("INSERT INTO temp_cart values(?,?,?)");
                    String email;    
                    //name =request.getParameter("name");
                    Cookie ck[]=request.getCookies();  
        if(ck!=null){  
          email=ck[0].getValue();  
        if(!email.equals("")||email!=null){ 
                            ps.setString(1,email);
				ps.setString(2, "Caesar Salad");
				ps.setInt(3, 150);
                         int i=ps.executeUpdate();
        }
        }
                        request.getRequestDispatcher("menu.html").include(request, response); 
                }catch(Exception e){}
            }
            
            
            if(request.getParameter("5") != null){
                try{ 
                    
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_order","root","");
                    Statement st = con.createStatement();
                    //out.println("<h>connection done</h>");
                    PreparedStatement ps=con.prepareStatement("INSERT INTO temp_cart values(?,?,?)");
                    String email;    
                    //name =request.getParameter("name");
                    Cookie ck[]=request.getCookies();  
        if(ck!=null){  
          email=ck[0].getValue();  
        if(!email.equals("")||email!=null){ 
                            ps.setString(1,email);
				ps.setString(2, "Lasagna");
				ps.setInt(3, 300);
                         int i=ps.executeUpdate();
        }
        }
                        request.getRequestDispatcher("menu.html").include(request, response); 
                }catch(Exception e){}
            }
            
            
            if(request.getParameter("6") != null){
                try{ 
                    
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_order","root","");
                    Statement st = con.createStatement();
                    //out.println("<h>connection done</h>");
                    PreparedStatement ps=con.prepareStatement("INSERT INTO temp_cart values(?,?,?)");
                    String email;    
                    //name =request.getParameter("name");
                    Cookie ck[]=request.getCookies();  
        if(ck!=null){  
          email=ck[0].getValue();  
        if(!email.equals("")||email!=null){ 
                            ps.setString(1,email);
				ps.setString(2, "Cheese Corn Roll");
				ps.setInt(3, 200);
                         int i=ps.executeUpdate();
        }
        }
                        request.getRequestDispatcher("menu.html").include(request, response); 
                }catch(Exception e){}
            }
            
            
            if(request.getParameter("7") != null){
                try{ 
                    
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_order","root","");
                    Statement st = con.createStatement();
                    //out.println("<h>connection done</h>");
                    PreparedStatement ps=con.prepareStatement("INSERT INTO temp_cart values(?,?,?)");
                    String email;    
                    //name =request.getParameter("name");
                    Cookie ck[]=request.getCookies();  
        if(ck!=null){  
          email=ck[0].getValue();  
        if(!email.equals("")||email!=null){ 
                            ps.setString(1,email);
				ps.setString(2, "Greek Salad");
				ps.setInt(3, 150);
                         int i=ps.executeUpdate();
        }
        }
                        request.getRequestDispatcher("menu.html").include(request, response); 
                }catch(Exception e){}
            }
            
            
            if(request.getParameter("8") != null){
                try{ 
                    
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_order","root","");
                    Statement st = con.createStatement();
                    //out.println("<h>connection done</h>");
                    PreparedStatement ps=con.prepareStatement("INSERT INTO temp_cart values(?,?,?)");
                    String email;    
                    //name =request.getParameter("name");
                    Cookie ck[]=request.getCookies();  
        if(ck!=null){  
          email=ck[0].getValue();  
        if(!email.equals("")||email!=null){ 
                            ps.setString(1,email);
				ps.setString(2, "Spinach Salad");
				ps.setInt(3, 150);
                         int i=ps.executeUpdate();
        }
        }
                        request.getRequestDispatcher("menu.html").include(request, response); 
                }catch(Exception e){}
            }
            
            
            if(request.getParameter("9") != null){
                try{ 
                    
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online_food_order","root","");
                    Statement st = con.createStatement();
                    //out.println("<h>connection done</h>");
                    PreparedStatement ps=con.prepareStatement("INSERT INTO temp_cart values(?,?,?)");
                    String email;    
                    //name =request.getParameter("name");
                    Cookie ck[]=request.getCookies();  
        if(ck!=null){  
          email=ck[0].getValue();  
        if(!email.equals("")||email!=null){ 
                            ps.setString(1,email);
				ps.setString(2, "Chole Bhature");
				ps.setInt(3, 300);
                         int i=ps.executeUpdate();
        }
        }
                        request.getRequestDispatcher("menu.html").include(request, response); 
                }catch(Exception e){}
            }
            
            
            if(request.getParameter("placeorder") != null){
           
                        request.getRequestDispatcher("Cart").include(request, response); 
                
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
