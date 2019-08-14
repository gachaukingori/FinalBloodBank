package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminpage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("   \n");
      out.write("<head>\n");
      out.write("      <!-- Font Awesome -->\n");
      out.write("<link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.8.1/css/all.css\">\n");
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
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"images/style.css\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write(" \n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write(" \n");
      out.write("     ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\n");
      out.write("       \n");
      out.write("\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"#\">CBBank</a> \n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("            </button>\n");
      out.write("\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("                <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                   <li class=\"nav-item active\">\n");
      out.write("                        <a class=\"nav-link\" href=\"adminpage.jsp\"><h3> Home </h3> <span class=\"sr-only\">(current)</span></a>\n");
      out.write("                    </li>\n");
      out.write("<li class=\"nav-item\">\n");
      out.write("    <a class=\"nav-link\" href=\"addUser.jsp\"><h3>Add new User</h3></a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("    <a class=\"nav-link\" href=\"suspendUser.jsp\"><h3>Suspend user</h3></a>\n");
      out.write("                    </li>\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("    <a class=\"nav-link\" href=\"resetUser.jsp\"><h3>Reset user's password</h3></a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <!-- Left Navbar -->\n");
      out.write("    <div class=\"container-fluid\" id=\"main\">\n");
      out.write("    <div class=\"row row-offcanvas row-offcanvas-left\">\n");
      out.write("        <div class=\"col-md-3 col-lg-2 sidebar-offcanvas bg-light pl-0\" id=\"sidebar\" role=\"navigation\">\n");
      out.write("            <ul class=\"nav flex-column sticky-top pl-0 pt-5 mt-3\">\n");
      out.write("                \n");
      out.write("                <li class=\"nav-item\">\n");
      out.write("                    <a class=\"nav-link\" href=\"#submenu1\" data-toggle=\"collapse\" data-target=\"#submenu1\">Reports▾</a>\n");
      out.write("                    <ul class=\"list-unstyled flex-column pl-3 collapse\" id=\"submenu1\" aria-expanded=\"false\">\n");
      out.write("                       <li class=\"nav-item\"><a class=\"nav-link\" href=\"report30days.jsp\"> monthly</a></li>\n");
      out.write("                       \n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item\"><a class=\"nav-link\" href=\"adminhelp.jsp\">Help</a></li>\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                <li class=\"nav-item\"><a class=\"nav-link\" href=\"loginpage.jsp\">logout (");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${loggedInUser.getUsername()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(")</a></li>\n");
      out.write("                           </ul>\n");
      out.write("        </div>\n");
      out.write("      <div class=\"card \" style=\"left: 25%; width: 500px\" >\n");
      out.write("                    <div class=\"card-body px-lg-5 pt-0\">\n");
      out.write("                        \n");
      out.write("                        <h3 class=\"card-title\" style=\"text-align: center\">Welcome to CBBank System Admin Page.</h3>\n");
      out.write("                          <h4 class=\"card-text \" style=\" text-align: left\"> Admin's roles</h4>\n");
      out.write("     \n");
      out.write("                          <h5 class=\"card-text\" style=\"text-align: left\">1.Adding a new user(clerk)</h5>\n");
      out.write("        <h5 class=\"card-text\" style=\"text-align: left\">2. Resetting users password</h5>\n");
      out.write(" <h5 class=\"card-text\" style=\"text-align: left\">3. Suspending users</h5>\n");
      out.write(" <h3 class=\"card-title\" style=\"text-align: center\">Blood Donation facts</h3>\n");
      out.write("  <h5 class=\"card-text\" style=\"text-align: left\">1. One donation can save 3 lives</h5>\n");
      out.write("    <h5 class=\"card-text\" style=\"text-align:left\"> 2. There is no substitute for blood</h5>\n");
      out.write("   <h5 class=\"card-text\" style=\"text-align: left\">3.Males can safely donate blood every 12 weeks, and females every 16 weeks. </h5>\n");
      out.write("   <h5 class=\"card-text\" style=\"text-align: left\"> 4.A donor effectively burns about 650 calories by donating one pint of blood </h5>\n");
      out.write("   <h1 class=\"card-text\" style=\"font-family:cursive,Times,serif; color: red; text-align: center; font-size: 30px\"> donate blood, save a <img src=\"images/heart.png\"   style=\"height: 25px; width: 25px;\"></h1>\n");
      out.write("                    </div> \n");
      out.write("                   </div>\n");
      out.write("    \n");
      out.write("    \n");
      out.write("    <!-- Homepage cards -->\n");
      out.write(" \n");
      out.write("     </div>\n");
      out.write("    </div>\n");
      out.write("        \n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\n");
      out.write("\n");
      out.write("         </body>\n");
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
