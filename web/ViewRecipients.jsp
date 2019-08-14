<%-- 
    Document   : ViewRecipients
    Created on : Jun 20, 2019, 5:53:25 PM
    Author     : victor
--%>

<%@page import="dataAccessObjects.DBConnection"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
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


        <h1 style="text-align: center"> County Referral Hospital</h1>
       
<table class="table table-striped">
            <tr>
                <th style="width:25%">Bag Number</th>
                <th style="width:25%"> Blood Group</th>
                <th style="width:25%">Blood type</th>
<th style="width:25%">Date Received</th>

            </tr>
        </table>
        <%  Iterator itr; %>
        <%
           
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
            
 String sql = "select * from recipients where hospital = 'County Referral Hospital' ";
      
      ArrayList ReferralList = new ArrayList();
          
              
                pstatement = connection.prepareStatement(sql);
                resultSet = pstatement.executeQuery();
                while (resultSet.next()){
                    
                    ReferralList.add(resultSet.getInt(1));
                    ReferralList.add(resultSet.getString(2));
                    ReferralList.add(resultSet.getString(3));
                    ReferralList.add(resultSet.getString(4));
                    
                    request.setAttribute("ReferralList", ReferralList);
                    
                    
                }
            for (itr = ReferralList.iterator();
                    itr.hasNext();) {
                int bagId = (int) itr.next();
                String bloodgroup = (String) itr.next();
                String bloodtype = (String) itr.next();
                String recipientdate = (String) itr.next();
        %>
       
<table class="table table-striped">
            <tr>
                <td style="width:25%"><%=bagId%></td>
                <td style="width:25%"><%= bloodgroup%></td>
                <td style="width:25%"><%= bloodtype%></td>
                <td style="width:25%"><%=recipientdate%></td>
            </tr>
        </table>

        <%
            }

        %>
         <h1 style="text-align: center"> East Sub-County Hospital</h1>
         <%  Iterator itr1; %>
         
         <%
            
             DBConnection db = new DBConnection();
              ArrayList EastList = db.eastSubcountyHospital();
            
                     for(itr1 = EastList.iterator(); itr1.hasNext();){
             int bagId = (int) itr1.next();
                String bloodgroup = (String) itr1.next();
                String bloodtype = (String) itr1.next();
                String recipientdate = (String) itr1.next();
        %>
        <table class="table table-striped">
            <tr>
               <td style="width:25%"><%=bagId%></td>
               <td style="width:25%"><%= bloodgroup%></td>
                <td style="width:25%"><%= bloodtype%></td>
                <td style="width:25%"><%=recipientdate%></td>
            </tr>
        </table>

        <%
            
            }
if (EastList.isEmpty()){
                %>
                <p>There is nothing here</p>
                <%
            }

        %>
                 <h1 style="text-align: center">Central Sub-County Hospital</h1>
         <table class="table table-striped">
            <tr>
                <th style="width:25%">Bag Number</th>
                <th style="width:25%"> Blood Group</th>
                <th style="width:25%">Blood type</th>
<th style="width:25%">Date Received</th>

            </tr>
        </table>
        <%
            ArrayList CentralList = db.centralSubcountyHospital();
              for(itr1 = CentralList.iterator(); itr1.hasNext();){
             int bagId = (int) itr1.next();
                String bloodgroup = (String) itr1.next();
                String bloodtype = (String) itr1.next();
                String recipientdate = (String) itr1.next();
            %>
             <table class="table table-striped">
            <tr>
                <td style="width:25%"><%=bagId%></td>
                <td style="width:25%"><%= bloodgroup%></td>
                <td style="width:25%"><%= bloodtype%></td>
                <td style="width:25%"><%=recipientdate%></td>
            </tr>
        </table>

        <%
            
            }
if (CentralList.isEmpty()){
                %>
                <p>There is nothing here</p>
                <%
            }

        %>
                 <h1 style="text-align: center">South Sub County Hospital</h1>
         <table class="table table-striped">
                  <table class="table table-striped">
            <tr>
                <th style="width:25%">Bag Number</th>
                <th style="width:25%"> Blood Group</th>
                <th style="width:25%">Blood type</th>
<th style="width:25%">Date Received</th>

            </tr>
        </table>
        <%
            ArrayList SouthList = db.southSubcountyHospital();
            for(itr1 = SouthList.iterator(); itr1.hasNext();){
             int bagId = (int) itr1.next();
                String bloodgroup = (String) itr1.next();
                String bloodtype = (String) itr1.next();
                String recipientdate = (String) itr1.next();
            %>
             <table class="table table-striped">
            <tr>
                <td style="width:25%"><%=bagId%></td>
                <td style="width:25%"><%= bloodgroup%></td>
                <td style="width:25%"><%= bloodtype%></td>
                 <td style="width:25%"><%=recipientdate%></td>
            </tr>
        </table>

        <%
            
            }
if (SouthList.isEmpty()){
                %>
                <p>There is nothing here</p>
           
<table class="table table-striped">
            <tr>
                <th style="width:25%">Bag Number</th>
                <th style="width:25%"> Blood Group</th>
                <th style="width:25%">Blood type</th>
<th style="width:25%">Date Received</th>

            </tr>
        </table>
                <%
            }

        %>
            
             <h1 style="text-align: center">West Sub - county Hospital</h1>
 
<table class="table table-striped">
            <tr>
                <th style="width:25%">Bag Number</th>
                <th style="width:25%"> Blood Group</th>
                <th style="width:25%">Blood type</th>
<th style="width:25%">Date Received</th>

            </tr>
        </table>
    <%
        ArrayList WestList = db.westSubcountyHospital();
          for(itr1 = WestList.iterator(); itr1.hasNext();){
             int bagId = (int) itr1.next();
                String bloodgroup = (String) itr1.next();
                String bloodtype = (String) itr1.next();
                String recipientdate = (String) itr1.next();
            %>

             <table class="table table-striped">
            <tr>
                <td style="width:25%"><%=bagId%></td>
                <td style="width:25%"><%= bloodgroup%></td>
                <td style="width:25%"><%= bloodtype%></td>
                <td style="width:25%"><%=recipientdate%></td>
            </tr>
        </table>

        <%
            
            }
if (WestList.isEmpty()){
                %>
                <p>There is nothing here</p>
                <%
            }

        %>
                <h1 style="text-align: center">North Sub - County Hospital </h1>
         
<table class="table table-striped">
            <tr>
                <th style="width:25%">Bag Number</th>
                <th style="width:25%"> Blood Group</th>
                <th style="width:25%">Blood type</th>
<th style="width:25%">Date Received</th>

            </tr>
        </table>
<%
ArrayList NorthList = db.northSubcountyHospital();
  for(itr1 = NorthList.iterator(); itr1.hasNext();){
             int bagId = (int) itr1.next();
                String bloodgroup = (String) itr1.next();
                String bloodtype = (String) itr1.next();
                String recipientdate = (String) itr1.next();
            %>
             <table class="table table-striped">
            <tr>
                <td style="width:25%"><%=bagId%></td>
                <td style="width:25%"><%= bloodgroup%></td>
                <td style="width:25%"><%= bloodtype%></td>
                <td style="width:25%"><%=recipientdate%></td>
            </tr>
        </table>

        <%
            
            }
if (NorthList.isEmpty()){
                %>
                <p>There is nothing here</p>
                <%
            }

        %>


   <jsp:include page="footer.jsp"></jsp:include>
     
    </body>
    
</html>
