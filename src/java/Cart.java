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
import javax.servlet.http.HttpSession;

/**
 *
 * @author upadhyays
 */
public class Cart extends HttpServlet {

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
                    Statement st = con.createStatement();
                    //out.println("<h>connection done</h>");
                    ResultSet rs;
                    String email;    
                    //name =request.getParameter("name");
                    Cookie ck[]=request.getCookies(); 
                    HttpSession session = request.getSession(false);
                    if(session!=null){  
                        email=ck[0].getValue();  
                        if(!email.equals("")||email!=null){ 
                            int total=0;
                            
                            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM temp_cart WHERE email=?");
                            pstmt.setString(1, email);
                            ResultSet rs1 = pstmt.executeQuery();
                            out.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"\n" +
"<head>\n" +
"  <meta charset=\"utf-8\">\n" +
"  <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">\n" +
"\n" +
"  <title>Cart</title>\n" +
"  <meta content=\"\" name=\"description\">\n" +
"  <meta content=\"\" name=\"keywords\">\n" +
"\n" +
"  <!-- Favicons -->\n" +
"  <link href=\"assets/img/favicon.png\" rel=\"icon\">\n" +
"  <link href=\"assets/img/apple-touch-icon.png\" rel=\"apple-touch-icon\">\n" +
"\n" +
"  <!-- Google Fonts -->\n" +
"  <link href=\"https://fonts.googleapis.com/css?family=Poppins:300,300i,400,400i,600,600i,700,700i|Satisfy|Comic+Neue:300,300i,400,400i,700,700i\" rel=\"stylesheet\">\n" +
"\n" +
"  <!-- Vendor CSS Files -->\n" +
"  <link href=\"assets/vendor/animate.css/animate.min.css\" rel=\"stylesheet\">\n" +
"  <link href=\"assets/vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\n" +
"  <link href=\"assets/vendor/bootstrap-icons/bootstrap-icons.css\" rel=\"stylesheet\">\n" +
"  <link href=\"assets/vendor/boxicons/css/boxicons.min.css\" rel=\"stylesheet\">\n" +
"  <link href=\"assets/vendor/glightbox/css/glightbox.min.css\" rel=\"stylesheet\">\n" +
"  <link href=\"assets/vendor/swiper/swiper-bundle.min.css\" rel=\"stylesheet\">\n" +
"\n" +
"  <!-- Template Main CSS File -->\n" +
"  <link href=\"assets/css/style.css\" rel=\"stylesheet\">\n" +
"\n" +
"  <!-- =======================================================\n" +
"  * Template Name: Delicious - v4.1.0\n" +
"  * Template URL: https://bootstrapmade.com/delicious-free-restaurant-bootstrap-theme/\n" +
"  * Author: BootstrapMade.com\n" +
"  * License: https://bootstrapmade.com/license/\n" +
"  ======================================================== -->\n" +
"</head>\n" +
"\n" +
"<body>\n" +
"\n" +
"  <!-- ======= Top Bar ======= -->\n" +
"  <section id=\"topbar\" class=\"d-flex align-items-center fixed-top \">\n" +
"    <div class=\"container-fluid container-xl d-flex align-items-center justify-content-center justify-content-lg-start\">\n" +
"      <i class=\"bi bi-phone d-flex align-items-center\"><span>+918511071764</span></i>\n" +
"      <i class=\"bi bi-clock ms-4 d-none d-lg-flex align-items-center\"><span>Mon-Sat: 11:00 AM - 23:00 PM</span></i>\n" +
"    </div>\n" +
"  </section>\n" +
"\n" +
"  <!-- ======= Header ======= -->\n" +
"  <header id=\"header\" class=\"fixed-top d-flex align-items-center \">\n" +
"    <div class=\"container-fluid container-xl d-flex align-items-center justify-content-between\">\n" +
"\n" +
"      <div class=\"logo me-auto\">\n" +
"        <h1><a href=\"CheckHome\">Delicious</a></h1>\n" +
"        <!-- Uncomment below if you prefer to use an image logo -->\n" +
"        <!-- <a href=\"CheckHome\"><img src=\"assets/img/logo.png\" alt=\"\" class=\"img-fluid\"></a>-->\n" +
"      </div>\n" +
"\n" +
"      <nav id=\"navbar\" class=\"navbar order-last order-lg-0\">\n" +
"        <ul>\n" +
"          <li><a class=\"nav-link scrollto\" href=\"CheckHome\">Home</a></li>\n" +
"          <li><a class=\"nav-link scrollto\" href=\"menu.html\">Menu</a></li>\n" +
"          <li><a class=\"nav-link scrollto\" href=\"PastOrders\">Past Orders</a></li>\n" +
"          <li><a class=\"nav-link scrollto\" href=\"Logout\">Logout</a></li>\n" +
"        </ul>\n" +
"        <i class=\"bi bi-list mobile-nav-toggle\"></i>\n" +
"      </nav><!-- .navbar -->\n" +
"    </div>\n" +
"  </header><!-- End Header -->\n" +
"\n" +
"  <main id=\"main\">\n" +
"\n" +
"    <!-- ======= Breadcrumbs Section ======= -->\n" +
"    <section class=\"breadcrumbs\">\n" +
"      <div class=\"container\">\n" +
"\n" +
"        <div class=\"d-flex justify-content-between align-items-center\">\n" +
"          <h2>Welcome</h2>\n" +
"          <ol>\n" +
"            <li><a href=\"CheckHome\">Home</a></li>\n" +
"            <li>Cart</li>\n" +
"          </ol>\n" +
"        </div>\n" +
"\n" +
"      </div>\n" +
"    </section><!-- End Breadcrumbs Section -->\n" +
"\n" + 
"    <section class=\"menu\">\n" +
"      <div class=\"container\">\n" +
"          <div class=\"row menu-container\">\n" +
"\n");          
                           while(rs1.next())
                            {   
                                String n= rs1.getString("email");
                                String p= rs1.getString("item");
                                int price=rs1.getInt("price");
                                total = total + price;
                                out.println(" <div class=\"col-lg-7 menu-item filter-starters\">\n" +
"            <div class=\"menu-content\">");
                                out.println("<a href=\"#\">" + p + "</a><span>Rs " + price + "</span>");
                                out.println("<form action=\"removeFromCart\" method=\"post\">"); 
                                out.println("<input type=\"hidden\" name=\"remove\" value=\"" + p + "\">");
                                        
                                        out.println("<button class=\"btn-nice\" type=\"submit\">Remove</button></form>");
                                out.println("</div>");
                                out.println("</div>");
                            }
out.println(" <div class=\"col-lg-7 menu-item filter-starters\">\n" +
"            <div class=\"menu-content\">");
                                out.println("<a href=\"#\"> Total" + "</a><span>Rs " + total + "</span>");
                                out.println("</div>");
                                out.println("</div>");
                                
out.println(
"    </section>\n");
out.println("<form action=\"Checkout\" method=\"post\"><button class=\"btn-nice\" style=\"margin-bottom: 60px; margin-left: 650px\" type=\"submit\">Checkout</button></form>");
out.println(
"\n" +
"  </main><!-- End #main -->\n" +
"  \n" +
"\n" +
"  <!-- ======= Footer ======= -->\n" +
"  <footer id=\"footer\">\n" +
"    <div class=\"container\">\n" +
"      <h3>Delicious</h3>\n" +
"      <div class=\"copyright\">\n" +
"        &copy; Copyright <strong><span>Delicious</span></strong>. All Rights Reserved\n" +
"      </div>\n" +
"    </div>\n" +
"  </footer><!-- End Footer -->\n" +
"\n" +
"  <a href=\"#\" class=\"back-to-top d-flex align-items-center justify-content-center\"><i class=\"bi bi-arrow-up-short\"></i></a>\n" +
"\n" +
"  <!-- Vendor JS Files -->\n" +
"  <script src=\"assets/vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\n" +
"  <script src=\"assets/vendor/glightbox/js/glightbox.min.js\"></script>\n" +
"  <script src=\"assets/vendor/isotope-layout/isotope.pkgd.min.js\"></script>\n" +
"  <script src=\"assets/vendor/php-email-form/validate.js\"></script>\n" +
"  <script src=\"assets/vendor/swiper/swiper-bundle.min.js\"></script>\n" +
"\n" +
"  <!-- Template Main JS File -->\n" +
"  <script src=\"assets/js/main.js\"></script>");
                        }
                    }
                        else { 
                            request.getRequestDispatcher("login.html").include(request, response);
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
