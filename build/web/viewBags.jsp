<%-- 
    Document   : viewBags
    Created on : Jun 26, 2019, 1:56:32 AM
    Author     : victor
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dataAccessObjects.DBConnection"%>
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

            <nav class="navbar navbar-expand-lg navbar-light bg-light">
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
                        <h3> <input class="form-control mr-sm-2" type="text" placeholder="Search " name="search" aria-label="Search"> </h3>
                        <h3> <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Search"> </h3>
                    </form>
                </div>
            </nav>
        <%
            String bloodtype = request.getParameter("bloodtype");
            String bloodtype1 = "";
            String bloodgroup = request.getParameter("bloodgroup");
            if(bloodtype.equals("positive") ){
                bloodtype1 = "+ve";
            }
            else{
                bloodtype1 = "-ve";
            }
        %>
        <h2 style="text-align: center"> Showing <%= bloodgroup%> <%= bloodtype1%>  Donors Who Donated In June</h2>
        <table class=" table table-striped">
            <tr>
                <th style="width:10%">
                 First Name
                </th>
                              <th style="width:10%">
                   Last Name
                </th>
                              <th style="width:10%">
                    Donor Id
                </th>
                             <th style="width:10%">
                    Gender
                </th>
                              <th style="width:10%">
                   Blood Group
                </th>
                <th style="width:10%">
                   Blood Type
                </th>
                                 <th style="width:10%">
                   Date _ Donated
                </th>
                <th style="width:10%">
                   Category
                </th>

            </tr>
        </table>
        <%  Iterator itr; %>
        <%
            DBConnection db = new DBConnection();
            ArrayList bag = db.bagsList(bloodgroup, bloodtype1);
            for (itr = bag.iterator(); itr.hasNext();) {
                String fname = (String) itr.next();
                String lname = (String) itr.next();
                String donorId = (String) itr.next();
                String gender = (String) itr.next();
                
                bloodgroup = (String) itr.next();
                bloodtype = (String) itr.next();
               
                String date_donated = (String) itr.next();
                 String category = (String) itr.next();
        %>
        <table class=" table table-striped">
            <tr>
                <td style="width: 10%"><%= fname%> </td>
            <td style="width: 10%"><%= lname%> </td>
           <td style="width: 10%"><%= donorId%> </td> 
        <td style="width: 10%"><%= gender %> </td>
            <td style="width: 10%"><%= bloodgroup%> </td>
            <td style="width: 10%"><%= bloodtype %> </td> 
            <td style="width: 10%"><%= date_donated%> </td>
               <td style="width: 10%"><%= category%> </td>
        </tr>
        </table>
        <%

            }
            if (bag.isEmpty()) {
        %>
        <p style="text-align: center"> There was no blood <%= bloodgroup%> <%= bloodtype1%> donors in the Month of June </p>
        <%
        }
        %>
        <h2 style="text-align: center"> Showing <%= bloodgroup%> <%= bloodtype1%>  Donors Who Donated In May</h2>
        <%
            ArrayList mayBags = db.mayBags(bloodgroup, bloodtype1);
            for (itr = mayBags.iterator(); itr.hasNext();) {
                String fname = (String) itr.next();
                String lname = (String) itr.next();
                String donorId = (String) itr.next();
                String gender = (String) itr.next();
                
                bloodgroup = (String) itr.next();
                bloodtype = (String) itr.next();
               
                String date_donated = (String) itr.next();
                 String category = (String) itr.next();
        %>
           <table class=" table table-striped">
            <tr>
                <td style="width: 10%"><%= fname%> </td>
            <td style="width: 10%"><%= lname%> </td>
           <td style="width: 10%"><%= donorId%> </td> 
        <td style="width: 10%"><%= gender %> </td>
            <td style="width: 10%"><%= bloodgroup%> </td>
            <td style="width: 10%"><%= bloodtype %> </td> 
            <td style="width: 10%"><%= date_donated%> </td>
               <td style="width: 10%"><%= category%> </td>
        </tr>
        </table>
        <%

            }
            if (bag.isEmpty()) {
        %>
        <p style="text-align: center"> There was no blood <%= bloodgroup%> <%= bloodtype1%> donors in the Month of May </p>
        <%
        }
        %>
        
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
