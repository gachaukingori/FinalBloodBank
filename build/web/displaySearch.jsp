<%-- 
    Document   : displaySearch
    Created on : May 6, 2019, 6:24:22 PM
    Author     : victor
--%>

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
            <table class="table table-striped">
                <tr>    

                    <th style="width: 12%">First Name</th>
                    <th style="width: 12%">Last Name</th>
                    <th style="width: 12%"> Donor ID</th>
                    <th style="width: 12%">Gender</th>
                    <th style="width: 12%"> Blood group</th>
                    <th style="width: 12%">Blood type</th>
                    <th style="width: 12%">Dates Of Donation</th>
                    <th style="width: 12%">Category</th>

                </tr>

            <%  Iterator itr; %>
            <%

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


            %> 

            <% if (donorList.isEmpty()) {
            %>
            <p  pos="center" style="color: green; align-self: center;"> Donor's record not found. Would you want to record a <a href="studentDonors.jsp"> Student</a> or an <a href="newDonor.jsp">Adult</a> donor </p>
            <%
            } else {
                for (itr = donorList.iterator();
                        itr.hasNext();) {
            %>

            <table class="table table-striped">

                <tr>

                    <td style="width: 12%"> <%= itr.next()%></td>
                    <td style="width: 12%"> <%= itr.next()%></td>

                    <td style="width: 12%"> <%= itr.next()%></td>
                    <td style="width: 12%"> <%= itr.next()%></td>
                    <td style="width: 12%"> <%= itr.next()%></td>
                    <td style="width: 12%"> <%= itr.next()%></td>
                    <td style="width: 12%"> <%= itr.next()%></td>
                    <td style="width: 12%"> <%= itr.next()%></td>
                </tr>
            </table>
            <%
                    }
                }
            %>
            <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
