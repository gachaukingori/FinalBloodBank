<%-- 
    Document   : viewDonors
    Created on : Jun 25, 2019, 10:42:39 PM
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
            String view = request.getParameter("view");
            %>
            <h2 style="text-align: center"> Showing <%= view %>  Adult Donors Registered In June</h2>
        <table class=" table table-striped">
            <tr>
                <th style="width: 14%">
                    First Name
                </th>
 <th style="width: 14%">
                    Last Name
                </th>
                  <th style="width: 14%">
                    Id Number
                </th>
               <th style="width: 14%">
                    telephone
                </th>
                <th style="width: 14%">
                    gender
                </th>
               <th style="width: 14%">Sub-county</th>
                <th style="width: 14%">date registered</th>
            </tr>
        </table>
                    <%  Iterator itr; %>
                    
        
        <%
           
            DBConnection db = new DBConnection();
            ArrayList donorList = db.adultDonorList(view);
            for(itr = donorList.iterator(); itr.hasNext();){
                String fname = (String) itr.next();
                String lname = (String) itr.next();
                String idnumber = (String) itr.next();
                String telephone = (String) itr.next();
                String gender = (String) itr.next();
                String subcounty = (String) itr.next();
               String date_registered = (String) itr.next();
                %>
                <table class="table table-striped">
                    
                    <tr>
                        <td style="width: 14%"><%= fname %> </td>
                        <td style="width: 14%"><%= lname %> </td>
                       <td style="width: 14%"><%=idnumber %></td>
                         <td style="width: 14%"><%=telephone %></td>
                          <td style="width: 14%"><%= gender %></td>
                           <td style="width: 14%"> <%= subcounty %> </td>
                          <td style="width: 14%"><%= date_registered %></td>
                    </tr>
                </table>
                
                <%
            }
if (donorList.isEmpty()){
%>
There no donors under that category
<%
}
            
            %>
                        <h2 style="text-align: center"> Showing <%= view %>  Adult Donors Registered In May</h2>
                        <%
                            ArrayList mayAdults = db.mayAdultDonorList(view);
                            for(itr = mayAdults.iterator(); itr.hasNext();){
                                 String fname1 = (String) itr.next();
                String lname1 = (String) itr.next();
                String idnumber1 = (String) itr.next();
                String telephone1 = (String) itr.next();
                String gender1 = (String) itr.next();
                String subcounty1 = (String) itr.next();
               String date_registered1 = (String) itr.next();
               %>
                <table class="table table-striped">
                    
                    <tr>
                        <td style="width: 14%"><%= fname1 %> </td>
                       <td style="width: 14%"><%= lname1 %> </td>
                        <td style="width: 14%"><%=idnumber1 %></td>
                         <td style="width: 14%"><%=telephone1 %></td>
                          <td style="width: 14%"><%= gender1 %></td>
                           <td style="width: 14%"> <%= subcounty1 %> </td>
                           <td style="width: 14%"><%= date_registered1 %></td>
                    </tr>
                </table>
               <%
                   
                            }
if (mayAdults.isEmpty()){
%>
<h3 style="text-align: center">There were no registered donors in May</h3>
<%
}
                            %>
                                    <jsp:include page="footer.jsp"></jsp:include>
                            
    </body>
</html>
