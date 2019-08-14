package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.sql.*;
import java.util.Iterator;
import java.util.List;
import Models.bloodBag;

public final class allBNegative_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
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
           String sql = "Select * from bloodbags where bloodgroup = 'B' and bloodtype = '-ve' and bloodstatus ='Yes' ";
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
      out.write("                            <input type=\"text\" value=\"add\" name=\"action\"  hidden=\" \">\n");
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
