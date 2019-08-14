package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Models.bloodBag;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.sql.*;

public final class expiredBloodBnegative_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("       <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.8.1/css/all.css\">\n");
      out.write("<!-- Bootstrap core CSS -->\n");
      out.write("<link href=\"https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("<!-- Material Design Bootstrap -->\n");
      out.write("<link href=\"https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.7./css/mdb.min.css\" rel=\"stylesheet\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("          <div class=\"text-center\">\n");
      out.write("      <h1 style=\"font-family:cursive,Times,serif; color: #8a0303; \"> This page shows the blood bags that has been in the blood bank for more than 42 days </h1>\n");
      out.write("      \n");
      out.write("   \n");
      out.write("  </div>\n");
      out.write("          <p pos=\"center\" style=\"color: green;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${successString}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("  </p>\n");
      out.write("         <table class=\" table table-striped\">\n");
      out.write("                <tr>\n");
      out.write("                <th>Bag Id</th>\n");
      out.write("                <th> Blood group </th>\n");
      out.write("                <th> Blood Type</th>\n");
      out.write("                                                </tr>\n");
      out.write("         </table>\n");
      out.write("         ");
  Iterator itr; 
      out.write("\n");
      out.write("                ");

                    List <bloodBag> expired = new ArrayList();
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
            String bloodgroup = "B";
            String bloodtype = "-ve";
            String bloodgroup1 = "";
           String bloodtype1 = "";
            int bagId = 0;
           bloodBag  bag = new bloodBag(bagId, bloodgroup, bloodtype);
String sql = "Select * from EXPIREDBLOOD Where bloodgroup = ? and bloodtype=? ";
pstatement = connection.prepareStatement(sql);
pstatement.setString(1, bloodgroup);
pstatement.setString(2, bloodtype);
resultSet = pstatement.executeQuery();
while(resultSet.next()){
      bag.setBagId(resultSet.getInt(1));
    bag.setBloodgroup(resultSet.getString(2));
    bag.setBloodtype(bloodtype1 = resultSet.getString(3));
    expired.add(bag);
}
            
          for (bloodBag bag1 : expired)
           {
                        
            
      out.write("\n");
      out.write("            \n");
      out.write("           <form method=\"post\" action=\"BnegativeServlet\">\n");
      out.write("                      <table class=\" table table-striped\">\n");
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
      out.write("                <td> <input type=\"submit\" value=\"remove bag\" name=\"delete\" > </td>\n");
      out.write("                \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </table>\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                          ");

                              }

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
