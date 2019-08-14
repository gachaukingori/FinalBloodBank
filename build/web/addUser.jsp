<%-- 
    Document   : addUser
    Created on : Apr 19, 2019, 9:46:11 PM
    Author     : victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
        
         <div class="card" style="left: 25%; width: 500px ; " >
            <div class="card-body px-lg-5 pt-0">
                                            <p pos="center" style="color: green;">${successString}  </p>
                            <p pos="center" style="color: red;">${errorString}  </p>
        <form class="text-center" method="post" action="addUser" name="adduserform">
            <div class="md-form">
            <label> Username </label>
            
                    <input type="text" placeholder="enter username" name="username" required="Please enter this field">
                   
            </div>
                 
                <div class="md-form">
                    <label>Id number</label>
                     <input type="number" name="idnumber" placeholder="enter id number" required="Please enter this field" >
                </div>
                   
            <button class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="submit" name="adduser" value="add new user" >Add new User</button>
             
        </form></div>
    </div>
    </div>
    </div>
        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
