package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.sql.*;
import java.util.Iterator;
import java.util.List;
import Models.bloodBag;

public final class allABPositive_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">CBBank</a> \n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("            </button>\n");
      out.write("\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("                <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                    <li class=\"nav-item active\">\n");
      out.write("                        <a class=\"nav-link\" href=\"homepage.jsp\">Home <span class=\"sr-only\">(current)</span></a>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li class=\"nav-item dropdown\">\n");
      out.write("                        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                            Donors\n");
      out.write("                        </a>\n");
      out.write("                        <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">\n");
      out.write("                            <a class=\"dropdown-item\" href=\"studentDonors.jsp\">Students</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"newDonor.jsp\">Adults</a>\n");
      out.write("                        </div>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"#\">Recipients</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"bloodBag.jsp\">Record a new blood bag</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"bloodDetails.jsp\">Blood bags details</a>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                </ul>\n");
      out.write("                <form class=\"form-inline my-2 my-lg-0\" method=\"get\" action=\"displayStudentSearch.jsp\">\n");
      out.write("                    <input class=\"form-control mr-sm-2\" type=\"text\" placeholder=\"Search\" name=\"search\" aria-label=\"Search\">\n");
      out.write("                    <button> <input class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\" value=\"Search\"></button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        \n");
      out.write("        <a href=\"cart.jsp\"> view cart</a>\n");
      out.write("          ");
  Iterator itr; 
      out.write("\n");
      out.write("          \n");
      out.write("        ");

                     Connection connection = null;
            PreparedStatement preparedStatement;
            ResultSet resultSet;
          if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost/BloodBank", "root", "gachau");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            }
           String sql = "Select * from bloodbags where bloodgroup = 'AB' and bloodtype = '+ve' and bloodstatus ='Yes' ";
          preparedStatement = connection.prepareStatement(sql);
          resultSet = preparedStatement.executeQuery();
          //int bagId = 0;
          List bagList = new ArrayList();
          String bloodgroup = "";
          String bloodtype="";
          String date_of_donation= "";
         // bloodBag bag = new bloodBag(bagId,bloodgroup, bloodtype, date_of_donation);
          while (resultSet.next()){
              bagList.add(resultSet.getInt(1));
              bagList.add(resultSet.getString(3));
              bagList.add(resultSet.getString(4));
              bagList.add(resultSet.getString(6));
              
          }
            //List bagList = (List) request.getAttribute("bagList");
           //  bloodBag bag = (bloodBag)request.getAttribute("bag");
           String cartBag = (String) session.getAttribute("bagId");
           for (itr = bagList.iterator();
                    itr.hasNext();) {
               int bagId = (int) itr.next();
             bloodgroup = (String) itr.next();
            bloodtype = (String) itr.next();
             date_of_donation = (String) itr.next();
            
        
      out.write("\n");
      out.write("        \n");
      out.write("       \n");
      out.write("        <table class=\"table table-striped\">\n");
      out.write("            <tr>\n");
      out.write("                <th>\n");
      out.write("                    Bag Number\n");
      out.write("                </th>\n");
      out.write("               \n");
      out.write("                  <th>\n");
      out.write("                    Blood Group\n");
      out.write("                </th>\n");
      out.write("                \n");
      out.write("\n");
      out.write("                <th>\n");
      out.write("                    Blood Type\n");
      out.write("                </th>\n");
      out.write("                 \n");
      out.write("                \n");
      out.write("            </tr> \n");
      out.write("        </table>\n");
      out.write("\n");
      out.write("        <form method=\"post\" action=\"cartServlet\">\n");
      out.write("                        <table>\n");
      out.write("                            <tr>\n");
      out.write("                                \n");
      out.write("                                <td><input type=\"text\" value= ");
      out.print( bagId);
      out.write("  readonly=\"\" name=\"bagId\"></td>\n");
      out.write("               \n");
      out.write("                <td> <input type=\"text\" value=\"");
      out.print( bloodgroup);
      out.write("\" readonly=\"\" name=\"bloodgroup\"</td>\n");
      out.write("                <td> <input type=\"text\" value=\"");
      out.print( bloodtype);
      out.write("\" readonly=\"\" name=\"bloodtype\" </td>\n");
      out.write("                <td> <input type=\"submit\" value=\"add to cart\"  > </td>\n");
      out.write("                \n");
      out.write("                            <input type=\"text\" value=\"addABpositive\" name=\"action\"  hidden=\" \">\n");
      out.write("\n");
      out.write("\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </table>\n");
      out.write("                    </form>\n");

        }
if(bagList.isEmpty()){

      out.write("\n");
      out.write("<p> There is no blood available now.\n");
      out.write("    ");

}



        
      out.write("\n");
      out.write("        \n");
      out.write("           </body>\n");
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
