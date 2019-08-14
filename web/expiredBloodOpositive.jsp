<%-- 
    Document   : expiredBloodAnegative
    Created on : May 15, 2019, 1:03:45 PM
    Author     : victor
--%>

<%@page import="Models.bloodBag"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.sql.*"%>
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
         <div class="text-center">
             <h1 style="font-family:cursive,Times,serif; color: #8a0303; "> This page shows the blood bags that has been in the blood bank for more than 42 days </h1>


        </div>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">CBBank</a> 
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="homepage.jsp">Home <span class="sr-only">(current)</span></a>
                    </li>

                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Donors
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="studentDonors.jsp">Students</a>
                            <a class="dropdown-item" href="newDonor.jsp">Adults</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Recipients</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="bloodBag.jsp">Record a new blood bag</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="bloodDetails.jsp">Blood bags details</a>
                    </li>

                </ul>
                <form class="form-inline my-2 my-lg-0" method="get" action="displayStudentSearch.jsp">
                    <input class="form-control mr-sm-2" type="text" placeholder="Search" name="search" aria-label="Search">
                    <button> <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Search"></button>
                </form>
            </div>
        </nav>
        <p pos="center" style="color: green;">${successString}  </p>
        <table class=" table table-striped">
            <tr>
                <th>Bag Id</th>
                <th> Blood group </th>
                <th> Blood Type</th>
            </tr>
        </table>
        <%  Iterator itr; %>
        <%
            List expired = new ArrayList();
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
           // String bloodgroup = null;
          //  String bloodtype = null;
            String bloodgroup1 = "";
            String bloodtype1 = "";
            //int bagId = 0;
            
            String sql = "Select * from EXPIREDBLOOD Where bloodgroup = 'O' and bloodtype= '+ve' ";
            pstatement = connection.prepareStatement(sql);
           

           // pstatement.setString(1, bloodgroup);
           // pstatement.setString(2, bloodtype);
            resultSet = pstatement.executeQuery();
            while (resultSet.next()) {
               expired.add(resultSet.getInt(1));
               
                expired.add(resultSet.getString(2));
             expired.add(resultSet.getString(3));
                
            }

         
           for (itr = expired.iterator();
                    itr.hasNext();) {
                int bagId = (int) itr.next();
            String bloodgroup = (String) itr.next();
            String bloodtype = (String) itr.next();

        %>

        <form method="post" action="BnegativeServlet">
            <table class=" table table-striped">
                <tr>

                    <td><input type="text" value= <%= bagId%>  readonly="" name="bagId"></td>

                    <td> <input type="text" value="<%= bloodgroup%>" readonly="" name="bloodgroup"</td>
                    <td> <input type="text" value="<%= bloodtype%>" readonly="" name="bloodtype" </td>
                    <td> <input type="submit" value="remove bag" name="remove" > </td>
                <input type="text" value="remove" name="action" hidden >



                </tr>


            </table>
        </form>

        <%
            }
        %>
          <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
