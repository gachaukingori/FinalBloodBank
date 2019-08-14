package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dataAccessObjects.DBConnection;
import java.sql.*;
import java.util.Iterator;
import java.util.ArrayList;

public final class ViewRecipients_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <!-- Font Awesome -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.8.1/css/all.css\">\n");
      out.write("        <!-- Bootstrap core CSS -->\n");
      out.write("        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- Material Design Bootstrap -->\n");
      out.write("        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.0/css/mdb.min.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- JQuery -->\n");
      out.write("        <script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js\"></script>\n");
      out.write("        <!-- Bootstrap tooltips -->\n");
      out.write("        <script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js\"></script>\n");
      out.write("        <!-- Bootstrap core JavaScript -->\n");
      out.write("        <script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n");
      out.write("        <!-- MDB core JavaScript -->\n");
      out.write("        <script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.0/js/mdb.min.js\"></script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("          ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("       \n");
      out.write("\n");
      out.write("        <nav class=\"navbar fixed-top navbar-expand-lg navbar-light bg-light\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">CBBank</a> \n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("            </button>\n");
      out.write("\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("                <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                   <li class=\"nav-item active\">\n");
      out.write("                        <a class=\"nav-link\" href=\"homepage.jsp\"><h3> Home </h3> <span class=\"sr-only\">(current)</span></a>\n");
      out.write("                    </li>\n");
      out.write("<li class=\"nav-item\">\n");
      out.write("    <a class=\"nav-link\" href=\"studentDonors.jsp\"><h3>Students</h3></a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"newDonor.jsp\"><h3>Adult Donors</h3></a>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write(" <li class=\"nav-item\">\n");
      out.write("     <a class=\"nav-link\" href=\"bloodDetails.jsp\"><h3>Blood bags details </h3></a>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"ViewRecipients.jsp\"><h3>Recipients</h3></a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"bloodBag.jsp\"><h3> Record a new blood bag</h3></a>\n");
      out.write("                    </li>\n");
      out.write("                   \n");
      out.write("                </ul>\n");
      out.write("                <form class=\"form-inline my-2 my-lg-0\" method=\"get\" action=\"displaySearch.jsp\">\n");
      out.write("                    <h3>  <input class=\"form-control mr-sm-2\" type=\"text\" placeholder=\"Id number/admission no\" name=\"search\" aria-label=\"Search\"> </h3>\n");
      out.write("                    <h3> <input class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\" value=\"Search\"></h3>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <h1> County Referral Hospital</h1>\n");
      out.write("       \n");
      out.write("<table class=\"table table-striped\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Bag Number</th>\n");
      out.write("                <th> Blood Group</th>\n");
      out.write("                <th>Blood type</th>\n");
      out.write("                <th>Date Received</th>\n");
      out.write("\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        ");
  Iterator itr; 
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
            }
            
 String sql = "select * from recipients where hospital = 'County Referral Hospital' ";
      
      ArrayList ReferralList = new ArrayList();
          
              
                pstatement = connection.prepareStatement(sql);
                resultSet = pstatement.executeQuery();
                while (resultSet.next()){
                    
                    ReferralList.add(resultSet.getInt(1));
                    ReferralList.add(resultSet.getString(2));
                    ReferralList.add(resultSet.getString(3));
                    ReferralList.add(resultSet.getString(4));
                    
                    request.setAttribute("ReferralList", ReferralList);
                    
                    
                }
            for (itr = ReferralList.iterator();
                    itr.hasNext();) {
                int bagId = (int) itr.next();
                String bloodgroup = (String) itr.next();
                String bloodtype = (String) itr.next();
                String recipientdate = (String) itr.next();
        
      out.write("\n");
      out.write("       \n");
      out.write("<table class=\"table table-striped\">\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(bagId);
      out.write("</td>\n");
      out.write("                <td>");
      out.print( bloodgroup);
      out.write("</td>\n");
      out.write("                <td>");
      out.print( bloodtype);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(recipientdate);
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("        ");

            }

        
      out.write("\n");
      out.write("         <h1> East Sub-County Hospital</h1>\n");
      out.write("         ");
  Iterator itr1; 
      out.write("\n");
      out.write("         \n");
      out.write("         ");

            
             DBConnection db = new DBConnection();
              ArrayList EastList = db.eastSubcountyHospital();
            
                     for(itr1 = EastList.iterator(); itr1.hasNext();){
             int bagId = (int) itr1.next();
                String bloodgroup = (String) itr1.next();
                String bloodtype = (String) itr1.next();
                String recipientdate = (String) itr1.next();
        
      out.write("\n");
      out.write("        <table class=\"table table-striped\">\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(bagId);
      out.write("</td>\n");
      out.write("                <td>");
      out.print( bloodgroup);
      out.write("</td>\n");
      out.write("                <td>");
      out.print( bloodtype);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(recipientdate);
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("        ");

            
            }
if (EastList.isEmpty()){
                
      out.write("\n");
      out.write("                <p>There is nothing here</p>\n");
      out.write("                ");

            }

        
      out.write("\n");
      out.write("        <h1>Central Sub-County Hospital</h1>\n");
      out.write("         <table class=\"table table-striped\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Bag Number</th>\n");
      out.write("                <th> Blood Group</th>\n");
      out.write("                <th>Blood type</th>\n");
      out.write("                <th>Date Received</th>\n");
      out.write("\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        ");

            ArrayList CentralList = db.centralSubcountyHospital();
              for(itr1 = CentralList.iterator(); itr1.hasNext();){
             int bagId = (int) itr1.next();
                String bloodgroup = (String) itr1.next();
                String bloodtype = (String) itr1.next();
                String recipientdate = (String) itr1.next();
            
      out.write("\n");
      out.write("             <table class=\"table table-striped\">\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(bagId);
      out.write("</td>\n");
      out.write("                <td>");
      out.print( bloodgroup);
      out.write("</td>\n");
      out.write("                <td>");
      out.print( bloodtype);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(recipientdate);
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("        ");

            
            }
if (CentralList.isEmpty()){
                
      out.write("\n");
      out.write("                <p>There is nothing here</p>\n");
      out.write("                ");

            }

        
      out.write("\n");
      out.write("        <h1>South Sub County Hospital</h1>\n");
      out.write("         <table class=\"table table-striped\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Bag Number</th>\n");
      out.write("                <th> Blood Group</th>\n");
      out.write("                <th>Blood type</th>\n");
      out.write("                <th>Date Received</th>\n");
      out.write("\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        ");

            ArrayList SouthList = db.southSubcountyHospital();
            for(itr1 = SouthList.iterator(); itr1.hasNext();){
             int bagId = (int) itr1.next();
                String bloodgroup = (String) itr1.next();
                String bloodtype = (String) itr1.next();
                String recipientdate = (String) itr1.next();
            
      out.write("\n");
      out.write("             <table class=\"table table-striped\">\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(bagId);
      out.write("</td>\n");
      out.write("                <td>");
      out.print( bloodgroup);
      out.write("</td>\n");
      out.write("                <td>");
      out.print( bloodtype);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(recipientdate);
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("        ");

            
            }
if (SouthList.isEmpty()){
                
      out.write("\n");
      out.write("                <p>There is nothing here</p>\n");
      out.write("                <table class=\"table table-striped\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Bag Number</th>\n");
      out.write("                <th> Blood Group</th>\n");
      out.write("                <th>Blood type</th>\n");
      out.write("                <th>Date Received</th>\n");
      out.write("\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("                ");

            }

        
      out.write("\n");
      out.write("            \n");
      out.write("    <h1>West Sub - county Hospital</h1>\n");
      out.write(" <table class=\"table table-striped\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Bag Number</th>\n");
      out.write("                <th> Blood Group</th>\n");
      out.write("                <th>Blood type</th>\n");
      out.write("                <th>Date Received</th>\n");
      out.write("\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("    ");

        ArrayList WestList = db.westSubcountyHospital();
          for(itr1 = WestList.iterator(); itr1.hasNext();){
             int bagId = (int) itr1.next();
                String bloodgroup = (String) itr1.next();
                String bloodtype = (String) itr1.next();
                String recipientdate = (String) itr1.next();
            
      out.write("\n");
      out.write("\n");
      out.write("             <table class=\"table table-striped\">\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(bagId);
      out.write("</td>\n");
      out.write("                <td>");
      out.print( bloodgroup);
      out.write("</td>\n");
      out.write("                <td>");
      out.print( bloodtype);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(recipientdate);
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("        ");

            
            }
if (WestList.isEmpty()){
                
      out.write("\n");
      out.write("                <p>There is nothing here</p>\n");
      out.write("                ");

            }

        
      out.write("\n");
      out.write("        <h1>North Sub - County Hospital </h1>\n");
      out.write("         <table class=\"table table-striped\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Bag Number</th>\n");
      out.write("                <th> Blood Group</th>\n");
      out.write("                <th>Blood type</th>\n");
      out.write("                <th>Date Received</th>\n");
      out.write("\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");

ArrayList NorthList = db.northSubcountyHospital();
  for(itr1 = NorthList.iterator(); itr1.hasNext();){
             int bagId = (int) itr1.next();
                String bloodgroup = (String) itr1.next();
                String bloodtype = (String) itr1.next();
                String recipientdate = (String) itr1.next();
            
      out.write("\n");
      out.write("             <table class=\"table table-striped\">\n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print(bagId);
      out.write("</td>\n");
      out.write("                <td>");
      out.print( bloodgroup);
      out.write("</td>\n");
      out.write("                <td>");
      out.print( bloodtype);
      out.write("</td>\n");
      out.write("                <td>");
      out.print(recipientdate);
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("        ");

            
            }
if (NorthList.isEmpty()){
                
      out.write("\n");
      out.write("                <p>There is nothing here</p>\n");
      out.write("                ");

            }

        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("   \n");
      out.write("     \n");
      out.write("    </body>\n");
      out.write("    \n");
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
