<%-- 
    Document   : adminpage
    Created on : Apr 16, 2019, 12:08:17 AM
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
  <link rel="stylesheet" type="text/css" href="images/style.css">

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
                        <a class="nav-link" href="adminpage.jsp"><h3> Home </h3> <span class="sr-only">(current)</span></a>
                    </li>
<li class="nav-item">
    <a class="nav-link" href="addUser.jsp"><h3>Add new User</h3></a>
                    </li>
                    <li class="nav-item">
    <a class="nav-link" href="suspendUser.jsp"><h3>Suspend user</h3></a>
                    </li>
                    <li class="nav-item">
    <a class="nav-link" href="resetUser.jsp"><h3>Reset user's password</h3></a>
                    </li>
                </ul>

            </div>
        </nav>

        <!-- Left Navbar -->
    <div class="container-fluid" id="main">
    <div class="row row-offcanvas row-offcanvas-left">
        <div class="col-md-3 col-lg-2 sidebar-offcanvas bg-light pl-0" id="sidebar" role="navigation">
            <ul class="nav flex-column sticky-top pl-0 pt-5 mt-3">
                
                <li class="nav-item">
                    <a class="nav-link" href="#submenu1" data-toggle="collapse" data-target="#submenu1">Reports▾</a>
                    <ul class="list-unstyled flex-column pl-3 collapse" id="submenu1" aria-expanded="false">
                       <li class="nav-item"><a class="nav-link" href="report30days.jsp"> monthly</a></li>
                       
                    </ul>
                </li>
                <li class="nav-item"><a class="nav-link" href="adminhelp.jsp">Help</a></li>
                
                
                <li class="nav-item"><a class="nav-link" href="loginpage.jsp">logout (${loggedInUser.getUsername()})</a></li>
                           </ul>
        </div>
      <div class="card " style="left: 25%; width: 500px" >
                    <div class="card-body px-lg-5 pt-0">
                        
                        <h3 class="card-title" style="text-align: center">Welcome to CBBank System Admin Page.</h3>
                          <h4 class="card-text " style=" text-align: left"> Admin's roles</h4>
     
                          <h5 class="card-text" style="text-align: left">1.Adding a new user(clerk)</h5>
        <h5 class="card-text" style="text-align: left">2. Resetting users password</h5>
 <h5 class="card-text" style="text-align: left">3. Suspending users</h5>
 <h3 class="card-title" style="text-align: center">Blood Donation facts</h3>
  <h5 class="card-text" style="text-align: left">1. One donation can save 3 lives</h5>
    <h5 class="card-text" style="text-align:left"> 2. There is no substitute for blood</h5>
   <h5 class="card-text" style="text-align: left">3.Males can safely donate blood every 12 weeks, and females every 16 weeks. </h5>
   <h5 class="card-text" style="text-align: left"> 4.A donor effectively burns about 650 calories by donating one pint of blood </h5>
   <h1 class="card-text" style="font-family:cursive,Times,serif; color: red; text-align: center; font-size: 30px"> donate blood, save a <img src="images/heart.png"   style="height: 25px; width: 25px;"></h1>
                    </div> 
                   </div>
    
    
    <!-- Homepage cards -->
 
     </div>
    </div>
        
<jsp:include page="footer.jsp"></jsp:include>

         </body>
</html>
