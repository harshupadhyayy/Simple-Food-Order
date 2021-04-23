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
import javax.servlet.http.HttpSession;

/**
 *
 * @author upadhyays
 */
public class Checkout extends HttpServlet {

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
            HttpSession session = request.getSession(false);
            if(session != null) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"\n" +
"<head>\n" +
"  <meta charset=\"utf-8\">\n" +
"  <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">\n" +
"\n" +
"  <title>Checkout</title>\n" +
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
"        <h1><a href=\"index.html\">Delicious</a></h1>\n" +
"        <!-- Uncomment below if you prefer to use an image logo -->\n" +
"        <!-- <a href=\"index.html\"><img src=\"assets/img/logo.png\" alt=\"\" class=\"img-fluid\"></a>-->\n" +
"      </div>\n" +
"\n" +
"      <nav id=\"navbar\" class=\"navbar order-last order-lg-0\">\n" +
"        <ul>\n" +
"          <li><a class=\"nav-link scrollto active\" href=\"index.html\">Home</a></li>\n" +
"          <li><a class=\"nav-link scrollto\" href=\"menu.html\">Menu</a></li>\n" +
"          <li><a class=\"nav-link scrollto\" href=\"Cart\">Cart</a></li>\n" +
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
"          <h2>Fill in your details to process payment</h2>\n" +
"          <ol>\n" +
"            <li><a href=\"index.html\">Home</a></li>\n" +
"            <li>Checkout</li>\n" +
"          </ol>\n" +
"        </div>\n" +
"\n" +
"      </div>\n" +
"    </section><!-- End Breadcrumbs Section -->\n" +
"\n" +
"<section class=\"inner-page\">\n" +
"    <div class=\"container checkout\">\n" +
"        <form action=\"Finalise\" method=\"post\" class=\"form-group\">\n" +
"            <div class=\"row\">\n" +
"                <div class=\"col-25\">\n" +
"                    <label for=\"fname\">First Name: </label>\n" +
"                </div>\n" +
"                <div class=\"col-75\">\n" +
"                    <input type=\"text\" id=\"fname\" name=\"firstname\" placeholder=\"Your name..\" />\n" +
"                </div>\n" +
"            </div>\n" +
"            <div class=\"row\">\n" +
"                <div class=\"col-25\">\n" +
"                    <label for=\"lname\">Last Name: </label>\n" +
"                </div>\n" +
"                <div class=\"col-75\">\n" +
"                    <input type=\"text\" id=\"lname\" name=\"lastname\" placeholder=\"Your last name..\" />\n" +
"                </div>\n" +
"            </div>\n" +
"            <div class=\"row\">\n" +
"                <div class=\"col-25\">\n" +
"                    <label for=\"subject\">Address: </label>\n" +
"                </div>\n" +
"                <div class=\"col-75\">\n" +
"                    <textarea name=\"address\" placeholder=\"Write something..\" style=\"height: 200px\"></textarea>\n" +
"                </div>\n" +
"            </div>\n" +
"            <div class=\"row\">\n" +
"                <div class=\"col-25\">\n" +
"                    <label for=\"lname\">Credit Card</label>\n" +
"                </div>\n" +
"                <div class=\"col-75\">\n" +
"                    <input type=\"radio\" id=\"visa\" name=\"card\" value=\"visa\" required />\n" +
"                    <label for=\"visa\">Visa</label><br />\n" +
"                    <input type=\"radio\" id=\"master_card\" name=\"card\" value=\"Master Card\" />\n" +
"                    <label for=\"master_card\">Master Card</label><br />\n" +
"                    <input type=\"radio\" id=\"american_express\" name=\"card\" value=\"american_express\" />\n" +
"                    <label for=\"american_express\">American Express</label><br />\n" +
"                    <input type=\"radio\" id=\"discover\" name=\"card\" value=\"discover\\\" />\n" +
"                    <label for=\"discover\">Discover</label><br />\n" +
"                    <input type=\"radio\" id=\"java_smartcard\" name=\"card\" value=\"java_smartcard\" />\n" +
"                    <label for=\"java_smartcard\">Java Smartcard</label><br />\n" +
"                </div>\n" +
"            </div>\n" +
"            <div class=\"row\">\n" +
"                <div class=\"col-25\">\n" +
"                    <label for=\"lname\">Credit Card Number: </label>\n" +
"                </div>\n" +
"                <div class=\"col-75\">\n" +
"                    <input type=\"text\" name=\"cc\" placeholder=\"Your cc no..\" />\n" +
"                </div>\n" +
"            </div>\n" +
"            <div class=\"row\">\n" +
"                <div class=\"col-25\">\n" +
"                    <label for=\"lname\">Enter CVV: </label>\n" +
"                </div>\n" +
"                <div class=\"col-75\">\n" +
"                    <input type=\"text\" name=\"cvv\" placeholder=\"Your CVV..\" />\n" +
"                </div>\n" +
"            </div>\n" +
"            <br />\n" +
"            <div class=\"row center\">\n" +
"                <button class=\"btn-nice final\" type=\"submit\" name=\"b1\">Pay</button>\n" +
"            </div>\n" +
"        </form>\n" +
"    </div>\n" +
"</section>" +  
"\n" +
"  </main><!-- End #main -->\n" +
"  \n" +
"  \n" +
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
"  <script src=\"assets/js/main.js\"></script>\n" +
"\n" +
"</body>\n" +
"\n" +
"</html>");
            
            
            
        }
            else { 
                request.getRequestDispatcher("login.html").include(request, response);
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
