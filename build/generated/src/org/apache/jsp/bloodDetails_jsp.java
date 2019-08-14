package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import dataAccessObjects.DBConnection;

public final class bloodDetails_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.8.1/css/all.css\">\n");
      out.write("<!-- Bootstrap core CSS -->\n");
      out.write("<link href=\"https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("<!-- Material Design Bootstrap -->\n");
      out.write("<link href=\"https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.7./css/mdb.min.css\" rel=\"stylesheet\">\n");
      out.write("<link href=\"bootstrap/css/style.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("                  <div class=\"container\">\n");
      out.write("  \n");
      out.write("  <div class=\"text-center\">\n");
      out.write("      <h1 style=\"font-family:cursive,Times,serif; color: #8a0303; \">Now, every   <img src=\"images/blooddrop.jpg\"   style=\"height: 30px; width: 25px;\" > Counted</h1>\n");
      out.write("   \n");
      out.write("  </div>\n");
      out.write("  \n");
      out.write("    </div>\n");
      out.write("        \n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n");
      out.write(" <a class=\"navbar-brand\" href=\"#\">CBBank</a> \n");
      out.write("  <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("    <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("  </button>\n");
      out.write("\n");
      out.write("  <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("    <ul class=\"navbar-nav mr-auto\">\n");
      out.write("      <li class=\"nav-item active\">\n");
      out.write("        <a class=\"nav-link\" href=\"homepage.jsp\">Home <span class=\"sr-only\">(current)</span></a>\n");
      out.write("      </li>\n");
      out.write("    \n");
      out.write("      <li class=\"nav-item dropdown\">\n");
      out.write("        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("          Donors\n");
      out.write("        </a>\n");
      out.write("        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("          <a class=\"dropdown-item\" href=\"studentDonors.jsp\">Students</a>\n");
      out.write("          <a class=\"dropdown-item\" href=\"newDonor.jsp\">Adults</a>\n");
      out.write("                 </div>\n");
      out.write("      </li>\n");
      out.write("        <li class=\"nav-item\">\n");
      out.write("        <a class=\"nav-link\" href=\"#\">Recipients</a>\n");
      out.write("      </li>\n");
      out.write("        <li class=\"nav-item\">\n");
      out.write("        <a class=\"nav-link\" href=\"bloodBag.jsp\">Record a new blood bag</a>\n");
      out.write("      </li>\n");
      out.write("      <li class=\"nav-item\">\n");
      out.write("        <a class=\"nav-link\" href=\"emergencySms.jsp\">Appeal for donations </a>\n");
      out.write("      </li>\n");
      out.write("\n");
      out.write("    </ul>\n");
      out.write("       <form class=\"form-inline my-2 my-lg-0\" method=\"get\" action=\"displaySearch.jsp\">\n");
      out.write("          <input class=\"form-control mr-sm-2\" type=\"text\" placeholder=\"Id number/admission no\" name=\"search\" aria-label=\"Search\">\n");
      out.write("          <button> <input class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\" value=\"Search\"></button>\n");
      out.write("    </form>\n");
      out.write("  </div>\n");
      out.write("</nav>\n");
      out.write("        ");

          
            
        
            
      out.write("\n");
      out.write("        ");
 
             Connection connection = null;
            PreparedStatement pstatement;
            ResultSet resultSet;
          if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost/BloodBank", "root", "gachau");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            // connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

        }      
           
           DBConnection  db = new DBConnection();
          //  db.connect();
          
            int Apositive = 0;
            int Apositive1 = 0, AnegativeExp=0;
              int Anegative = 0, Anegative1=0, ApositiveExp=0;
              int Bpositive =0, Bpositive1 = 0 ,BpositiveExp = 0;
              int Bnegative =0, Bnegative1 =0 , BnegativeExp=0;
              int ABpositive =0 , ABpositive1 = 0, ABpositiveExp=0;
              int ABnegative = 0, ABnegative1=0, ABnegativeExp=0;
              int Opositive = 0, Opositive1=0, OpositiveExp=0;
              int Onegative = 0, Onegative1=0, OnegativeExp =0;
                    String bloodgroup = null;
                 String bloodgroup1 = null;
                 String bloodtype = null;
                 
              
            String sql = "Select Count(bloodgroup) as totalnumberofgroupA from bloodbags where bloodgroup = 'A' and bloodtype = '+ve' and bloodstatus = 'Yes' ";
            pstatement = connection.prepareStatement(sql);
           resultSet = pstatement.executeQuery();
           while (resultSet.next()){
               bloodgroup = "A+";
               bloodgroup1 = "A";
               bloodtype = "+ve";
               Apositive = resultSet.getInt(1);
              db.updateTotalBloodBags(Apositive, bloodgroup);
              Apositive1 = db.totalBloodBagPerGroup(bloodgroup);
                db.expiredBlood(bloodgroup1, bloodtype);
                ApositiveExp = db.numberOfExpiredBags(bloodgroup1, bloodtype);
              
              
       
                      
                       }
           String sql1 = "Select Count(bloodgroup) as totalnumberofgroupA from bloodbags where bloodgroup = 'A' and bloodtype = '-ve'and bloodstatus = 'Yes' ";
            pstatement = connection.prepareStatement(sql1);
           resultSet = pstatement.executeQuery();
           while (resultSet.next()){
               Anegative = resultSet.getInt(1);
               bloodgroup = "A-";
               bloodgroup1 = "A";
               bloodtype = "-ve";
               db.updateTotalBloodBags(Anegative, bloodgroup);
               Anegative = db.totalBloodBagPerGroup(bloodgroup);
               db.expiredBlood(bloodgroup1, bloodtype);
               AnegativeExp = db.numberOfExpiredBags(bloodgroup1, bloodtype);
             
                       
                       }
               String sql2 = "Select Count(bloodgroup) as totalnumberofgroupA from bloodbags where bloodgroup = 'B' and bloodtype = '+ve' and bloodstatus = 'Yes' ";
            pstatement = connection.prepareStatement(sql2);
           resultSet = pstatement.executeQuery();
           while (resultSet.next()){
            Bpositive  = resultSet.getInt(1);
            bloodgroup = " B+";
            bloodgroup1 = "B";
            bloodtype = "+ve"; 
            db.updateTotalBloodBags(Bpositive, bloodgroup);
            Bpositive1 = db.totalBloodBagPerGroup(bloodgroup);
            db.expiredBlood(bloodgroup1, bloodtype);
            BpositiveExp = db.numberOfExpiredBags(bloodgroup1, bloodtype);
           

                       
                       }       
  String sql3 = "Select Count(bloodgroup) as totalnumberofgroupA from bloodbags where bloodgroup = 'B' and bloodtype = '-ve' and bloodstatus = 'Yes'  ";
            pstatement = connection.prepareStatement(sql3);
           resultSet = pstatement.executeQuery();
           while (resultSet.next()){
            Bnegative = resultSet.getInt(1);
            bloodgroup = "B-";
            bloodgroup1 = "B";
            bloodtype = "-ve";
            db.updateTotalBloodBags(Bnegative, bloodgroup);
            Bnegative1 = db.totalBloodBagPerGroup(bloodgroup);
            db.expiredBlood(bloodgroup1, bloodtype);
            BnegativeExp = db.numberOfExpiredBags(bloodgroup1, bloodtype);
             
                       }       
String sql4 = "Select Count(bloodgroup) as totalnumberofgroupA from bloodbags where bloodgroup = 'AB' and bloodtype = '+ve' and bloodstatus = 'Yes' ";
            pstatement = connection.prepareStatement(sql4);
           resultSet = pstatement.executeQuery();
           while (resultSet.next()){
              bloodgroup = "AB+"; 
                   bloodgroup1 = "AB";
               bloodtype = "+ve";      
              
            ABpositive = resultSet.getInt(1);
            db.updateTotalBloodBags(ABpositive, bloodgroup);
          ABpositive1 = db.totalBloodBagPerGroup(bloodgroup);
                  db.expiredBlood(bloodgroup1, bloodtype);
                  ABpositiveExp =  db.numberOfExpiredBags(bloodgroup1, bloodtype);
           
                       }    
String sql5 = "Select Count(bloodgroup) as totalnumberofgroupA from bloodbags where bloodgroup = 'AB' and bloodtype = '-ve' and bloodstatus = 'Yes' ";
            pstatement = connection.prepareStatement(sql5);
           resultSet = pstatement.executeQuery();
           while (resultSet.next()){
              bloodgroup = "AB-"; 
                   bloodgroup1 = "AB";
               bloodtype = "-ve";      
              
            ABnegative = resultSet.getInt(1);
           
            db.updateTotalBloodBags(ABnegative, bloodgroup);
            ABnegative1 = db.totalBloodBagPerGroup(bloodgroup);
                  db.expiredBlood(bloodgroup1, bloodtype);
                  ABnegativeExp =  db.numberOfExpiredBags(bloodgroup1, bloodtype);
           
                       }   


String sql6 = "Select Count(bloodgroup) as totalnumberofgroupA from bloodbags where bloodgroup = 'O' and bloodtype = '+ve' and bloodstatus = 'Yes' ";
            pstatement = connection.prepareStatement(sql6);
           resultSet = pstatement.executeQuery();
           while (resultSet.next()){
            Opositive = resultSet.getInt(1);
             bloodgroup = "O+";
                bloodgroup1 = "O";
               bloodtype = "+ve";
            db.updateTotalBloodBags(Opositive, bloodgroup);
           Opositive1 = db.totalBloodBagPerGroup(bloodgroup);
                  db.expiredBlood(bloodgroup1, bloodtype);
                  OpositiveExp =  db.numberOfExpiredBags(bloodgroup1, bloodtype);
            
                   
                       }
           
           String sql7 = "Select Count(bloodgroup) as totalnumberofgroupA from bloodbags where bloodgroup = 'O' and bloodtype = '-ve' and bloodstatus = 'Yes' ";
            pstatement = connection.prepareStatement(sql7);
           resultSet = pstatement.executeQuery();
           while (resultSet.next()){
            Onegative = resultSet.getInt(1);
            
            bloodgroup = "O-";
                bloodgroup1 = "O";
               bloodtype = "-ve";
            db.updateTotalBloodBags(Onegative, bloodgroup);
             Onegative1 = db.totalBloodBagPerGroup(bloodgroup);
                                db.expiredBlood(bloodgroup1, bloodtype);
                                  OnegativeExp =  db.numberOfExpiredBags(bloodgroup1, bloodtype);
           /* 
          
                   
                 
*/
                       }
           
            
      out.write("\n");
      out.write("                               <table class=\"table table-striped\">\n");
      out.write("                <tr>\n");
      out.write("                    <th> Blood Group </th> \n");
      out.write("                  <th>\n");
      out.write("                  Available For Donation\n");
      out.write("                </th> \n");
      out.write("                <th> </th>\n");
      out.write("                 <th>\n");
      out.write("                   Bags Over 42 days(Expired)\n");
      out.write("                </th> \n");
      out.write("                </tr>\n");
      out.write("              \n");
      out.write("              \n");
      out.write("                <tr>\n");
      out.write("                    <td> A+</td>\n");
      out.write("                    <td>  ");
      out.print( Apositive );
      out.write(" <a href=\"ApositiveServlet\"> view  </a> </td>\n");
      out.write("                    <td> </td> \n");
      out.write("                    <td> ");
      out.print( ApositiveExp );
      out.write("<a href=\"expiredBloodApositive.jsp\"> View all </a> </td>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td> A-</td>\n");
      out.write("                    <td>  ");
      out.print( Anegative1 );
      out.write(" <a href=\"AnegativeServlet\"> view  </a> </td>\n");
      out.write("                        <td> </td>\n");
      out.write("                    <td> ");
      out.print( AnegativeExp );
      out.write("<a href=\"expiredBloodAnegative.jsp\"> View all </a> </td>\n");
      out.write("                </tr>\n");
      out.write("                \n");
      out.write("                <tr>\n");
      out.write("                    <td> B+ </td>\n");
      out.write("                    <td>  ");
      out.print( Bpositive );
      out.write(" <a href=\"BpositiveServlet1\"> view  </a> </td>\n");
      out.write("                        <td> </td>\n");
      out.write("                     <td> ");
      out.print( BpositiveExp );
      out.write(" <a href=\"expiredBloodBpositive.jsp\"> View all </a> </td>\n");
      out.write("                </tr>\n");
      out.write("                 <tr>\n");
      out.write("                    <td> B- </td>\n");
      out.write("                    <td>  ");
      out.print( Bnegative );
      out.write(" <a href=\"BnegativeServlet\" > view </a></td>\n");
      out.write("                        <td> </td>\n");
      out.write("                     <td>");
      out.print( BnegativeExp );
      out.write("<a href=\"expiredBloodBnegative.jsp\"> View all </a> </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td> AB+ </td>\n");
      out.write("                    <td>  ");
      out.print( ABpositive );
      out.write(" <a href=\"ABpositiveServlet\"> view  </a> </td>\n");
      out.write("                        <td> </td>\n");
      out.write("                     <td> ");
      out.print( ABpositiveExp);
      out.write(" <a href=\"expiredBloodABpositive.jsp\"> View all </a> </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td> AB- </td>\n");
      out.write("                    <td>  ");
      out.print( ABnegative );
      out.write(" <a href=\"ABnegativeServlet\"> view  </a> </td>\n");
      out.write("                        <td> </td>\n");
      out.write("                     <td> ");
      out.print( ABnegativeExp );
      out.write(" <a href=\"expiredBloodABnegative.jsp\"> View all </a> </td>\n");
      out.write("                </tr>\n");
      out.write("                  <tr>\n");
      out.write("                    <td> O+ </td>\n");
      out.write("                    <td>  ");
      out.print( Opositive );
      out.write(" <a href=\"OpositiveServlet\" > view </a></td>\n");
      out.write("                        <td> </td>\n");
      out.write("                     <td> ");
      out.print( OpositiveExp );
      out.write(" <a href=\"expiredBloodOpositive.jsp\"> View all </a> </td>\n");
      out.write("                </tr>\n");
      out.write("  <tr>\n");
      out.write("                    <td> O- </td>\n");
      out.write("                    <td>  ");
      out.print( Onegative );
      out.write(" <a href=\"OnegativeServlet\" > view </a></td>\n");
      out.write("                        <td> </td>\n");
      out.write("                     <td> ");
      out.print( OnegativeExp );
      out.write(" <a href=\"expiredBloodOnegative.jsp\"> View all </a> </td>\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("            </table>\n");
      out.write("                \n");
      out.write("            \n");
      out.write("               \n");
      out.write("               ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("            \n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
