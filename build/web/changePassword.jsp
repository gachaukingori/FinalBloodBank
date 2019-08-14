<%-- 
    Document   : changePassword
    Created on : Apr 20, 2019, 12:01:17 AM
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
<style>
    
body{
    margin: 0;
    padding: 0;
    background: url(images/image.jpg);
    background-size: cover;
    font-family: sans-serif;
}

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
                <form class="form-inline my-2 my-lg-0" method="get" action="displaySearch.jsp">
                    <h3>  <input class="form-control mr-sm-2" type="text" placeholder="Id number/admission no" name="search" aria-label="Search"> </h3>
                    <h3> <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Search"></h3>
                </form>
            </div>
        </nav>



  <div class="container-fluid" id="main">
            <div class="row row-offcanvas row-offcanvas-left">
                <div class="col-md-3 col-lg-2 sidebar-offcanvas bg-light pl-0" id="sidebar" role="navigation">
                    <ul class="nav flex-column sticky-top pl-0 pt-5 mt-3">

                        <li class="nav-item">
                            <a class="nav-link" href="#submenu1" data-toggle="collapse" data-target="#submenu1">Reports</a>
                            <ul class="list-unstyled flex-column pl-3 collapse" id="submenu1" aria-expanded="false">
                                <li class="nav-item"><a class="nav-link" href="report30days.jsp" target="_blank">Mothy</a></li>
                        
                            </ul>
                        </li>
                        <li class="nav-item"><a class="nav-link" href="emergencySms.jsp" >Emergencies and Blood Appeals</a></li>
                      

                        <li class="nav-item"><a class="nav-link" href="AboutUs.jsp">About Us</a></li>
                        <li class="nav-item"><a class="nav-link" href="changePassword.jsp" >Change Password</a></li>
                                                <li class="nav-item"><a class="nav-link" href="loginpage.jsp">logout (${loggedInUser.getUsername()})</a></li>

                    </ul>
                </div>
                
                 <div class="card " style="left: 25%; width: 300px; height: 250px" >
                    <div class="card-body px-lg-5 pt-0">
                   

        <form method="post" action="updatePassword">
             <p pos="center" style="color: green;">${successString}  </p>
            <p pos="center" style="color: red;">${errorString}  </p>

            <table>
                <tr>
                    <td> Username</td>
                    <td><input type="text" name="username" placeholder="enter your username"></td>
                   
                </tr>
                <tr>
                    <td> Enter old Password </td>
                    <td> <input type="password" name="oldpassword" required="Please enter this field"></td>
                </tr>
                <tr>
                    <td>Enter new password</td>
                    <td> <input type="password" name="newpassword" required="Please enter this field"></td>
                </tr>
                  <tr>
                    <td>Confirm new password</td>
                    <td> <input type="password" name="confirmpassword"required="Please enter this field"> </td>
                </tr>
                <tr>
                    <td></td>
                    <td> <input type="submit" value="reset " name="reset" </td>
                </tr>
            </table>
            
        </form>
                 </div>
            </div>
  </div>
      </div>
       <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
