<%-- 
    Document   : screenedDonors
    Created on : Apr 23, 2019, 10:34:18 PM
    Author     : victor
--%>

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
      <form class="form-inline my-2 my-lg-0" method="get" action="displaySearch.jsp">
          <input class="form-control mr-sm-2" type="text" placeholder="Id number/admission no" name="search" aria-label="Search">
          <button> <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Search"></button>
    </form>
  </div>
</nav>
        
             <div class="row justify-content-center">
         <div class="card bg-success"   style="width: 400px;" style="margin-left: auto; margin-right: auto; margin-top: auto;" >
                    <h5 class="card-title"> record blood bag </h5>
                    <img class="card-img-top" src="images/avatar.png" style="height: 100px;" >
  <div class="card-body"  >
        <form action="allDonorsServlet" method="post">
             <p pos="center" style="color: green;">${successString}  </p>
            <p pos="center" style="color: red;">${errorString}  </p>
            <table>
               
                <tr>
                    <td>ID/ Adm No:</td>
                    <td><input type="text" name="donorID" placeholder="ID Or Adm No For Students" required="Please enter this field"></td>
                    
                </tr>
                <tr>
                    <td>Category:</td>
                    <td>
                        <select name="category">
                                <option>student</option>
                                 <option>adult</option>
                             
                        </select>
                        
                    </td>
                </tr>
                <tr>
                    <td>Blood Group</td>
                    <td>
                        <select name="bloodgroup">
                            <option>A</option>
                            <option>B</option>
                            <option>AB</option>
                            <option>O</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Blood Type:</td>
                    <td>
                        <select name="bloodtype" >
                            <option>+ve</option>
                            <option>-ve</option>

                        </select>
                    </td>
                </tr>
                
                 <tr>
                    <td></td>
                    <td><input type="submit" name="bloodgroup" value="Add Details"</td>
                </tr>
            </table>
        </form>
         </div>
         </div>
             </div>
            <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
