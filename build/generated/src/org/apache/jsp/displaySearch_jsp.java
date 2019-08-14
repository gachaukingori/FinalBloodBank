package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.sql.*;
import Models.minorDonors;
import Models.studentDonors;
import Models.newDonor;
import Models.allDonors;
import java.util.List;
import java.util.Iterator;

public final class displaySearch_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("     <head>\n");
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
      out.write("      \n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("            <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n");
      out.write("                <a class=\"navbar-brand\" href=\"#\">CBBank</a> \n");
      out.write("                <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                    <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                </button>\n");
      out.write("\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("                    <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                        <li class=\"nav-item active\">\n");
      out.write("                            <a class=\"nav-link\" href=\"homepage.jsp\"><h3> Home </h3> <span class=\"sr-only\">(current)</span></a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"studentDonors.jsp\"><h3>Students</h3></a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"newDonor.jsp\"><h3>Adult Donors</h3></a>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"bloodDetails.jsp\"><h3>Blood bags details </h3></a>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"ViewRecipients.jsp\"><h3>Recipients</h3></a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"bloodBag.jsp\"><h3> Record a new blood bag</h3></a>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                    <form class=\"form-inline my-2 my-lg-0\" method=\"get\" action=\"displaySearch.jsp\">\n");
      out.write("                        <h3> <input class=\"form-control mr-sm-2\" type=\"text\" placeholder=\"Search \" name=\"search\" aria-label=\"Search\"> </h3>\n");
      out.write("                        <h3> <input class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\" value=\"Search\"> </h3>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write(" <table class=\"table table-striped\">\n");
      out.write("            <tr>    \n");
      out.write("\n");
      out.write("                <th style=\"width: 12%\">First Name</th>\n");
      out.write("                <th style=\"width: 12%\">Last Name</th>\n");
      out.write("               <th style=\"width: 12%\"> Donor ID</th>\n");
      out.write("<th style=\"width: 12%\">Gender</th>\n");
      out.write("              <th style=\"width: 12%\"> Blood group</th>\n");
      out.write("               <th style=\"width: 12%\">Blood type</th>\n");
      out.write("               <th style=\"width: 12%\">Dates Of Donation</th>\n");
      out.write("<th style=\"width: 12%\">Category</th>\n");
      out.write("\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("        ");
  Iterator itr; 
      out.write("\n");
      out.write("        ");


            // List searchDonor = (List) request.getAttribute("searchDonor");
            //Book bk = (Book)request.getAttribute
            List donorList = new ArrayList();
            String donorId = "", category = "", bloodgroup = "", bloodtype = "", gender = "", lname = "", fname = "", date_last_donated = "";
            allDonors donor = new allDonors(donorId, category, bloodgroup, bloodtype, gender, lname, fname, date_last_donated);
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

            String search = request.getParameter("search");

            String sql = " Select * from ALLDONORS where donorID = ? or lname = ? or fname=? or gender =? or bloodgroup=?";

            pstatement = connection.prepareStatement(sql);
            pstatement.setString(1, search);
            pstatement.setString(2, search);
            pstatement.setString(3, search);
            pstatement.setString(4, search);
            pstatement.setString(5, search);

            resultSet = pstatement.executeQuery();
            while (resultSet.next()) {

                donorList.add(resultSet.getString(1));
                donorList.add(resultSet.getString(2));
                donorList.add(resultSet.getString(3));
                donorList.add(resultSet.getString(4));
                donorList.add(resultSet.getString(5));
                donorList.add(resultSet.getString(6));
                donorList.add(resultSet.getString(7));
                donorList.add(resultSet.getString(9));
                // donorList.add(donor);

            }
            pageContext.setAttribute("donorList", donorList);
            
            


        
      out.write(" \n");
      out.write("\n");
      out.write("        ");
 if (donorList.isEmpty()) {
        
      out.write("\n");
      out.write("        <p  pos=\"center\" style=\"color: green; align-self: center;\"> Donor's record not found. Would you want to record a <a href=\"studentDonors.jsp\"> Student</a> or an <a href=\"newDonor.jsp\">Adult</a> donor </p>\n");
      out.write("        ");

        } else {
            for (itr = donorList.iterator();
                    itr.hasNext();) {
        
      out.write("\n");
      out.write("    \n");
      out.write("       <table class=\"table table-striped\">\n");
      out.write("            \n");
      out.write("            <tr>\n");
      out.write("\n");
      out.write("                <td> ");
      out.print( itr.next());
      out.write("</td>\n");
      out.write("                <td> ");
      out.print( itr.next());
      out.write("</td>\n");
      out.write("\n");
      out.write("                <td> ");
      out.print( itr.next());
      out.write("</td>\n");
      out.write("                <td> ");
      out.print( itr.next());
      out.write("</td>\n");
      out.write("                <td> ");
      out.print( itr.next());
      out.write("</td>\n");
      out.write("                <td> ");
      out.print( itr.next());
      out.write("</td>\n");
      out.write("                <td> ");
      out.print( itr.next());
      out.write("</td>\n");
      out.write("                <td> ");
      out.print( itr.next());
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        ");

                }
            }
        
      out.write("\n");
      out.write("         ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
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
