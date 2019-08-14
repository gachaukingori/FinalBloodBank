<%-- 
    Document   : studentFilter
    Created on : Jun 27, 2019, 11:02:15 PM
    Author     : victor
--%>


<%@page import="dataAccessObjects.DBConnection"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@page import="Models.minorDonors"%>
<%@page import="Models.studentDonors"%>
<%@page import="Models.newDonor"%>
<%@page import="Models.allDonors"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
        <!-- Font Awesome -->
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
        <!-- Bootstrap core CSS -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
        <!-- Material Design Bootstrap -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.0/css/mdb.min.css" rel="stylesheet">
        <!-- JQuery -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
        <!-- Bootstrap tooltips -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
        <!-- Bootstrap core JavaScript -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <!-- MDB core JavaScript -->
        <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.8.0/js/mdb.min.js"></script>

    </head>
    <body>
          <jsp:include page="header.jsp"></jsp:include>
       

        <nav class="navbar fixed-top navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">CBBank</a> 
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                   <li class="nav-item active">
                        <a class="nav-link" href="homepage.jsp"><h3> Home </h3> <span class="sr-only">(current)</span></a>
                    </li>
<li class="nav-item">
    <a class="nav-link" href="studentDonors.jsp"><h3>Students</h3></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="newDonor.jsp"><h3>Adult Donors</h3></a>
                    </li>

 <li class="nav-item">
     <a class="nav-link" href="bloodDetails.jsp"><h3>Blood bags details </h3></a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="ViewRecipients.jsp"><h3>Recipients</h3></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="bloodBag.jsp"><h3> Record a new blood bag</h3></a>
                    </li>
                   
                </ul>
                <form class="form-inline my-2 my-lg-0" method="get" action="displaySearch.jsp">
                    <h3>  <input class="form-control mr-sm-2" type="text" placeholder="Id number/admission no" name="search" aria-label="Search"> </h3>
                    <h3> <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Search"></h3>
                </form>
            </div>
        </nav>

         <table class="table table-striped">
            <tr>    

                <th style="width: 14%">First Name</th>
                <th style="width: 14%">Last Name</th>
<th style="width: 14%"> Gender</th>
<th style="width: 14%">School Name</th>
<th style="width: 14%"> Admission</th>
                <th style="width: 14%">Level Of Study</th>
                <th style="width: 14%"> Date Registered</th>
               
               

            </tr>
         </table>
         <%  Iterator itr; %>
        <%
            String startdate = request.getParameter("startdate");
            String enddate = request.getParameter("enddate");
            DBConnection db = new DBConnection();
            ArrayList student = db.studentFilter(startdate, enddate);
            for (itr = student.iterator();
                    itr.hasNext();) {
            String fname = (String) itr.next();
            String lname = (String) itr.next();
            String gender = (String) itr.next();
            String schoolname = (String) itr.next();
            String admission = ( String) itr.next();
            String level_of_study = (String) itr.next();
            String date_registered = (String) itr.next();
        %>
                <table class="table table-striped">
                    <tr>
                        <td style="width: 14%"><%= fname %></td>
                         <td style="width: 14%"><%=lname %> </td>
                          <td style="width: 14%"><%= gender %></td>
                          <td style="width: 14%"><%= schoolname %></td>
                            <td style="width: 14%"> <%=admission %></td>
                             <td style="width: 14%"><%= level_of_study %></td>
                              <td style="width: 14%"> <%= date_registered %></td>
                    </tr>
        </table>

                               <%
                                  }
if (student.isEmpty()){
%>
<p style="text-align: center"> O results found  </p>
                              <%
}
%>
        
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
