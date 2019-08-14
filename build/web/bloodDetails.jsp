<%-- 
    Document   : bloodDetails
    Created on : May 11, 2019, 7:48:29 AM
    Author     : victor
--%>

<%@page import="java.sql.*"%>
<%@page import="dataAccessObjects.DBConnection"%>
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
<style>
    



</style>

               
    
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
                <form class="form-inline my-2 my-lg-0" method="get" action="displayBagsSearch.jsp">
                    <h3>  <input class="form-control mr-sm-2" type="text" placeholder="" name="search" aria-label="Search"> </h3>
                    <h3> <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Search"></h3>
                </form>
            </div>
        </nav>


        <%
          
            
        
            %>
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
            // connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

        }      
           
           DBConnection  db = new DBConnection();
          //  db.connect();
          
            int Apositive = 0;
            int Apositive1 = 0, AnegativeExp=0;
              int Anegative = 0, Anegative1=0, ApositiveExp=0;
              int Bpositive =0, Bpositive1 = 0 ,BpositiveExp = 0;
              int Bnegative =0, Bnegative1 =0 , BnegativeExp=0;
              int ABpositive =0 , ABpositive1 = 0, ABpositiveExp=0;
              int ABnegative = 0, ABnegative1=0, ABnegativeExp=0;
              int Opositive = 0, Opositive1=0, OpositiveExp=0;
              int Onegative = 0, Onegative1=0, OnegativeExp =0;
                    String bloodgroup = null;
                 String bloodgroup1 = null;
                 String bloodtype = null;
                 
              
            String sql = "Select Count(bloodgroup) as totalnumberofgroupA from bloodbags where bloodgroup = 'A' and bloodtype = '+ve' and bloodstatus = 'Yes' ";
            pstatement = connection.prepareStatement(sql);
           resultSet = pstatement.executeQuery();
           while (resultSet.next()){
               bloodgroup = "A+";
               bloodgroup1 = "A";
               bloodtype = "+ve";
               Apositive = resultSet.getInt(1);
              db.updateTotalBloodBags(Apositive, bloodgroup);
              Apositive1 = db.totalBloodBagPerGroup(bloodgroup);
                db.expiredBlood(bloodgroup1, bloodtype);
                ApositiveExp = db.numberOfExpiredBags(bloodgroup1, bloodtype);
              
              
       
                      
                       }
           String sql1 = "Select Count(bloodgroup) as totalnumberofgroupA from bloodbags where bloodgroup = 'A' and bloodtype = '-ve'and bloodstatus = 'Yes' ";
            pstatement = connection.prepareStatement(sql1);
           resultSet = pstatement.executeQuery();
           while (resultSet.next()){
               Anegative = resultSet.getInt(1);
               bloodgroup = "A-";
               bloodgroup1 = "A";
               bloodtype = "-ve";
               db.updateTotalBloodBags(Anegative, bloodgroup);
               Anegative = db.totalBloodBagPerGroup(bloodgroup);
               db.expiredBlood(bloodgroup1, bloodtype);
               AnegativeExp = db.numberOfExpiredBags(bloodgroup1, bloodtype);
             
                       
                       }
               String sql2 = "Select Count(bloodgroup) as totalnumberofgroupA from bloodbags where bloodgroup = 'B' and bloodtype = '+ve' and bloodstatus = 'Yes' ";
            pstatement = connection.prepareStatement(sql2);
           resultSet = pstatement.executeQuery();
           while (resultSet.next()){
            Bpositive  = resultSet.getInt(1);
            bloodgroup = " B+";
            bloodgroup1 = "B";
            bloodtype = "+ve"; 
            db.updateTotalBloodBags(Bpositive, bloodgroup);
            Bpositive1 = db.totalBloodBagPerGroup(bloodgroup);
            db.expiredBlood(bloodgroup1, bloodtype);
            BpositiveExp = db.numberOfExpiredBags(bloodgroup1, bloodtype);
           

                       
                       }       
  String sql3 = "Select Count(bloodgroup) as totalnumberofgroupA from bloodbags where bloodgroup = 'B' and bloodtype = '-ve' and bloodstatus = 'Yes'  ";
            pstatement = connection.prepareStatement(sql3);
           resultSet = pstatement.executeQuery();
           while (resultSet.next()){
            Bnegative = resultSet.getInt(1);
            bloodgroup = "B-";
            bloodgroup1 = "B";
            bloodtype = "-ve";
            db.updateTotalBloodBags(Bnegative, bloodgroup);
            Bnegative1 = db.totalBloodBagPerGroup(bloodgroup);
            db.expiredBlood(bloodgroup1, bloodtype);
            BnegativeExp = db.numberOfExpiredBags(bloodgroup1, bloodtype);
             
                       }       
String sql4 = "Select Count(bloodgroup) as totalnumberofgroupA from bloodbags where bloodgroup = 'AB' and bloodtype = '+ve' and bloodstatus = 'Yes' ";
            pstatement = connection.prepareStatement(sql4);
           resultSet = pstatement.executeQuery();
           while (resultSet.next()){
              bloodgroup = "AB+"; 
                   bloodgroup1 = "AB";
               bloodtype = "+ve";      
              
            ABpositive = resultSet.getInt(1);
            db.updateTotalBloodBags(ABpositive, bloodgroup);
          ABpositive1 = db.totalBloodBagPerGroup(bloodgroup);
                  db.expiredBlood(bloodgroup1, bloodtype);
                  ABpositiveExp =  db.numberOfExpiredBags(bloodgroup1, bloodtype);
           
                       }    
String sql5 = "Select Count(bloodgroup) as totalnumberofgroupA from bloodbags where bloodgroup = 'AB' and bloodtype = '-ve' and bloodstatus = 'Yes' ";
            pstatement = connection.prepareStatement(sql5);
           resultSet = pstatement.executeQuery();
           while (resultSet.next()){
              bloodgroup = "AB-"; 
                   bloodgroup1 = "AB";
               bloodtype = "-ve";      
              
            ABnegative = resultSet.getInt(1);
           
            db.updateTotalBloodBags(ABnegative, bloodgroup);
            ABnegative1 = db.totalBloodBagPerGroup(bloodgroup);
                  db.expiredBlood(bloodgroup1, bloodtype);
                  ABnegativeExp =  db.numberOfExpiredBags(bloodgroup1, bloodtype);
           
                       }   


String sql6 = "Select Count(bloodgroup) as totalnumberofgroupA from bloodbags where bloodgroup = 'O' and bloodtype = '+ve' and bloodstatus = 'Yes' ";
            pstatement = connection.prepareStatement(sql6);
           resultSet = pstatement.executeQuery();
           while (resultSet.next()){
            Opositive = resultSet.getInt(1);
             bloodgroup = "O+";
                bloodgroup1 = "O";
               bloodtype = "+ve";
            db.updateTotalBloodBags(Opositive, bloodgroup);
           Opositive1 = db.totalBloodBagPerGroup(bloodgroup);
                  db.expiredBlood(bloodgroup1, bloodtype);
                  OpositiveExp =  db.numberOfExpiredBags(bloodgroup1, bloodtype);
            
                   
                       }
           
           String sql7 = "Select Count(bloodgroup) as totalnumberofgroupA from bloodbags where bloodgroup = 'O' and bloodtype = '-ve' and bloodstatus = 'Yes' ";
            pstatement = connection.prepareStatement(sql7);
           resultSet = pstatement.executeQuery();
           while (resultSet.next()){
            Onegative = resultSet.getInt(1);
            
            bloodgroup = "O-";
                bloodgroup1 = "O";
               bloodtype = "-ve";
            db.updateTotalBloodBags(Onegative, bloodgroup);
             Onegative1 = db.totalBloodBagPerGroup(bloodgroup);
                                db.expiredBlood(bloodgroup1, bloodtype);
                                  OnegativeExp =  db.numberOfExpiredBags(bloodgroup1, bloodtype);
           /* 
          
                   
                 
*/
                       }
           
            %>
            <table class="table table-striped" style="font-size: 100px;">
                <tr>
                    <th> 
                        <h2> Blood Group</h2>
                    </th> 
                  <th>
                      <h2>Available For Donation</h2>
                </th> 
                <th> </th>
                 <th>
                     <h2>  Bags Over 42 days(Expired)</h2>
                </th> 
                </tr>
              
              
                <tr>
                    <td><h5> A+ </h5> </td>
                    <td> <h5> <%= Apositive %> <a href="ApositiveServlet"> view  </a> </h5></td>
                    <td> </td> 
                    <td> <h5> <%= ApositiveExp %><a href="expiredBloodApositive.jsp"> View all </a> </h5> </td>
                </tr>
                

                <tr>
                    <td> <h5> A-</h5></td>
                    <td> <h5> <%= Anegative %> <a href="AnegativeServlet"> view  </a> </h5></td>
                        <td> </td>
                        <td><h5> <%= AnegativeExp %><a href="expiredBloodAnegative.jsp"> View all </a></h5> </td>
                </tr>
                
                <tr>
                    <td><h5> B+ </h5></td>
                    <td><h5>  <%= Bpositive %> <a href="BpositiveServlet1"> view  </a> </h5> </td>
                        <td> </td>
                        <td><h5> <%= BpositiveExp %> <a href="expiredBloodBpositive.jsp"> View all </a></h5> </td>
                </tr>
                 <tr>
                     <td> <h5>B- </h5> </td>
                     <td> <h5> <%= Bnegative %> <a href="BnegativeServlet" > view </a></h5></td>
                        <td> </td>
                        <td><h5><%= BnegativeExp %><a href="expiredBloodBnegative.jsp"> View all </a> </h5></td>
                </tr>
                <tr>
                    <td> <h5> AB+ </h5> </td>
                    <td><h5>  <%= ABpositive %> <a href="ABpositiveServlet"> view  </a> </h5></td>
                        <td> </td>
                        <td><h5> <%= ABpositiveExp%> <a href="expiredBloodABpositive.jsp"> View all </a></h5> </td>
                </tr>
                <tr>
                    <td><h5> AB- </h5> </td>
                    <td> <h5>  <%= ABnegative %> <a href="ABnegativeServlet"> view  </a> </h5></td>
                        <td> </td>
                        <td><h5> <%= ABnegativeExp %> <a href="expiredBloodABnegative.jsp"> View all </a> </h5></td>
                </tr>
                  <tr>
                      <td><h5> O+</h5> </td>
                      <td> <h5> <%= Opositive %> <a href="OpositiveServlet" > view </a></h5></td>
                        <td> </td>
                        <td> <h5><%= OpositiveExp %> <a href="expiredBloodOpositive.jsp"> View all </a> </h5></td>
                </tr>
  <tr>
      <td> <h5> O- </h5> </td>
      <td> <h5> <%= Onegative %> <a href="OnegativeServlet" > view </a></h5></td>
                        <td> </td>
                        <td> <h5> <%= OnegativeExp %> <a href="expiredBloodOnegative.jsp"> View all </a> </h5> </td>
                </tr>

            </table>
                
            
               
               <jsp:include page="footer.jsp"></jsp:include>
            </h5
    </body>
</html>
