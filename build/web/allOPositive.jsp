<%-- 
    Document   : allAPositive
    Created on : Jun 5, 2019, 8:10:05 PM
    Author     : victor
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Models.bloodBag"%>
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
                    <h3>  <input class="form-control mr-sm-2" type="text" placeholder="Id number/admission no" name="search" aria-label="Search"> </h3>
                    <h3> <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Search"></h3>
                </form>
            </div>
        </nav>             

        <a href="cart.jsp"> view cart</a>
          <%  Iterator itr; %>
          
        <%
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
           String sql = "Select * from bloodbags where bloodgroup = 'O' and bloodtype = '+ve' and bloodstatus ='Yes' ";
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
            
        %>
        
      <form method="post" action="cartServlet">
             <table class="table-striped">
                            <tr>
                                
                             <td style="width: 20%"><label>bag id:</label><input type="text" value= <%= bagId%>  readonly="" name="bagId"></td>
                 

                    <td style="width: 20%"><label>blood group</label> <input type="text" value="<%= bloodgroup%>" readonly="" name="bloodgroup"</td>
                 
                    <td style="width: 20%"> <label>blood type</label><input type="text" value="<%= bloodtype%>" readonly="" name="bloodtype" </td><br>
                <td style="width: 20%"> <label> date of donation </label><input type="text" value="<%= date_of_donation%>" readonly="" name="bloodtype" </td>

                <td style="width: 20%"> <input type="submit" value="add to cart"  > </td>
                
                            <input type="text" value="addOpositive" name="action"  hidden=" ">


            </tr>


        </table>                    </form>
<%
        }
if(bagList.isEmpty()){
%>
<p> There is no blood available now.
    <%
}



        %>
         <jsp:include page="footer.jsp"></jsp:include>
           </body>
</html>

