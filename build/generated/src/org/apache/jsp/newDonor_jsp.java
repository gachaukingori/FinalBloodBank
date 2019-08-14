package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newDonor_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("       <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.8.1/css/all.css\">\n");
      out.write("<!-- Bootstrap core CSS -->\n");
      out.write("<link href=\"https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("<!-- Material Design Bootstrap -->\n");
      out.write("<link href=\"https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.0/css/mdb.min.css\" rel=\"stylesheet\">\n");
      out.write("<!-- JQuery -->\n");
      out.write("<script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js\"></script>\n");
      out.write("<!-- Bootstrap tooltips -->\n");
      out.write("<script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js\"></script>\n");
      out.write("<!-- Bootstrap core JavaScript -->\n");
      out.write("<script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n");
      out.write("<!-- MDB core JavaScript -->\n");
      out.write("<script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.0/js/mdb.min.js\"></script>\n");
      out.write("           <link rel=\"stylesheet\" type=\"text/css\" href=\"images/style.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("         ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("    <nav class=\"navbar fixed-top navbar-expand-lg navbar-dark scrolling-navbar\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">CBBank</a> \n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("            </button>\n");
      out.write("\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("                <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                    <li class=\"nav-item active\">\n");
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
      out.write("\n");
      out.write("                </ul>\n");
      out.write("                <form class=\"form-inline my-2 my-lg-0\" method=\"get\" action=\"displayAdultSearch.jsp\">\n");
      out.write("                    <h3> <input class=\"form-control mr-sm-2\" type=\"text\" placeholder=\"Search \" name=\"search\" aria-label=\"Search\"> </h3>\n");
      out.write("                    <h3> <input class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\" value=\"Search\"> </h3>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("  <div class=\"container-fluid\" id=\"main\">\n");
      out.write("            <div class=\"row row-offcanvas row-offcanvas-left\">\n");
      out.write("                <div class=\"col-md-3 col-lg-2 sidebar-offcanvas bg-light pl-0\" id=\"sidebar\" role=\"navigation\">\n");
      out.write("                    <ul class=\"nav flex-column sticky-top pl-0 pt-5 mt-3\">\n");
      out.write("\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"#submenu1\" data-toggle=\"collapse\" data-target=\"#submenu1\">View Donors By Gender</a>\n");
      out.write("                            <ul class=\"list-unstyled flex-column pl-3 collapse\" id=\"submenu1\" aria-expanded=\"false\">\n");
      out.write("                                <li class=\"nav-item\"><a class=\"nav-link\" href=\"report30days.jsp\" target=\"_blank\">Monthly</a></li>\n");
      out.write("                             \n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                         <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"#submenu1\" data-toggle=\"collapse\" data-target=\"#submenu1\">View Donors By Sub-County</a>\n");
      out.write("                            <ul class=\"list-unstyled flex-column pl-3 collapse\" id=\"submenu1\" aria-expanded=\"false\">\n");
      out.write("                                <li class=\"nav-item\"><a class=\"nav-link\" href=\"viewDonors.jsp?view=Central\" >Central</a></li>\n");
      out.write("                             \n");
      out.write("                            </ul>\n");
      out.write("                        </li>\n");
      out.write("                        \n");
      out.write("                        <li class=\"nav-item\"><a class=\"nav-link\" href=\"emergencySms.jsp\" >Emergencies and Blood Appeals</a></li>\n");
      out.write("                        <li class=\"nav-item\"><a class=\"nav-link\" href=\"#\">Help</a></li>\n");
      out.write("                        <li class=\"nav-item\"><a class=\"nav-link\" href=\"#\">Settings</a></li>\n");
      out.write("\n");
      out.write("                        <li class=\"nav-item\"><a class=\"nav-link\" href=\"AboutUs.jsp\">About Us</a></li>\n");
      out.write("                        <li class=\"nav-item\"><a class=\"nav-link\" href=\"changePassword.jsp\" >Change Password</a></li>\n");
      out.write("                       <li class=\"nav-item\"><a class=\"nav-link\" href=\"loginpage.jsp\">logout (");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loggedInUser.getUsername()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(")</a></li>\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"card\" style=\"left: 25%; width: 500px; \" >\n");
      out.write("            <div class=\"card-body px-lg-5 pt-0\">\n");
      out.write("                <form class=\"text-center\" method=\"post\" action=\"newDonorServlet\">\n");
      out.write("                    <p pos=\"center\" style=\"color: green;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${successString}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("  </p>\n");
      out.write("                    <p pos=\"center\" style=\"color: red;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${errorString}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("  </p>\n");
      out.write("\n");
      out.write("                    <div class=\"md-form\">\n");
      out.write("                        <label> First Name:</label>\n");
      out.write("                        <input type=\"text\" name=\"fname\" placeholder=\"Donor's First Name\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${donor.getFname()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" required=\"Please enter this field\">\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"md-form\">\n");
      out.write("                        <label> Last Name:</label>\n");
      out.write("                        <input type=\"text\" name=\"lname\" placeholder=\"Donor's Last Name\"value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${donor.getLname()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"required=\"Please enter this field\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"md-form\">\n");
      out.write("                        <label> ID Number:</label>\n");
      out.write("                        <input type=\"number\" name=\"idnumber\" placeholder=\"Donor's ID Number\"required=\"Please enter this field\" >\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"md-form\">   \n");
      out.write("                        <label>   Age: </label>\n");
      out.write("                        <input type=\"number\" name=\"age\" placeholder=\"Donor's age\" required=\"Please enter this field\" max=\"65\" min=\"18\"> \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"md-form\">\n");
      out.write("                        <label> Phone Number:</label>\n");
      out.write("                        <input type=\"text\" name=\"telephone\" placeholder=\"Donor's Phone Number\" required=\"Please enter this field\" value=\"+2547\">\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"md-form\">\n");
      out.write("                        <label>Gender: </label>\n");
      out.write("\n");
      out.write("                        <select name=\"gender\">\n");
      out.write("                            <option>Male</option>\n");
      out.write("                            <option>Female</option>\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"md-form\">\n");
      out.write("                        <label>Sub County:</label>\n");
      out.write("\n");
      out.write("                        <select name=\"subcounty\">\n");
      out.write("                            <option>East</option>\n");
      out.write("                            <option>West</option>\n");
      out.write("                            <option>North</option>\n");
      out.write("                            <option>South</option>\n");
      out.write("                            <option>Central</option>\n");
      out.write("                        </select>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <button class=\"btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0\" type=\"submit\" name =\"recorddonor\" value=\"recorddonor\">Record Donor </button>\n");
      out.write("\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("  </div>\n");
      out.write("         </div>\n");
      out.write("</body>\n");
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
