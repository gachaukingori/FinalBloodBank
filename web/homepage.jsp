<!DOCTYPE html>
<html lang="en">

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
          <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

    </head>
    <body>
                        <jsp:include page="header.jsp"></jsp:include>
   <!--    <div class="container">

            <div class="text-center">
                <h1 style="font-family:cursive,Times,serif; color: #8a0303; "> Donate blood, a gift straight from your <img src="images/heart.png"   style="height: 25px; width: 25px;" ></h1>

            </div>

        </div> -->
        <nav class="navbar fixed-top navbar-expand-lg navbar-dark scrolling-navbar">
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

        <!-- Left Navbar -->
        <div class="container-fluid" id="main">
            <div class="row row-offcanvas row-offcanvas-left">
                <div class="col-md-3 col-lg-2 sidebar-offcanvas bg-light pl-0" id="sidebar" role="navigation">
                    <ul class="nav flex-column sticky-top pl-0 pt-5 mt-3">

                        <li class="nav-item">
                            <a class="nav-link" href="#submenu1" data-toggle="collapse" data-target="#submenu1">Reports</a>
                            <ul class="list-unstyled flex-column pl-3 collapse" id="submenu1" aria-expanded="false">
                                <li class="nav-item"><a class="nav-link" href="report30days.jsp" target="_blank">Monthly</a></li>

                            </ul>
                        </li>
                        <li class="nav-item"><a class="nav-link" href="emergencySms.jsp" >Emergencies and Blood Appeals</a></li>
                        <li class="nav-item"><a class="nav-link" href="help.jsp">Help</a></li>
                      

                        <li class="nav-item"><a class="nav-link" href="AboutUs.jsp">About Us</a></li>
                        <li class="nav-item"><a class="nav-link" href="changePassword.jsp" >Change Password</a></li>
                        <li class="nav-item"><a class="nav-link" href="loginpage.jsp">logout (${loggedInUser.getUsername()})</a></li>

                    </ul>
                </div>
            
                   <div class="card " style="left: 25%; width: 500px" >
                    <div class="card-body px-lg-5 pt-0">
                        
                        <h3 class="card-title" style="text-align: center">Welcome to CBBank System.</h3>
                          <h4 class="card-text " style=" text-align: left"> What you need to know about blood donation.</h4>
     
                          <h5 class="card-text" style="text-align: left">1. Donor must be aged between 16 - 65 years</h5>
        <h5 class="card-text" style="text-align: left">2. Donor must weigh above 50 kgs</h5>
 <h5 class="card-text" style="text-align: left">3. Donor should be in good health </h5>
 <h3 class="card-title" style="text-align: center">Blood Donation facts</h3>
  <h5 class="card-text" style="text-align: left">1. One donation can save 3 lives</h5>
    <h5 class="card-text" style="text-align:left"> 2. There is no substitute for blood</h5>
   <h5 class="card-text" style="text-align: left">3.Males can safely donate blood every 12 weeks, and females every 16 weeks. </h5>
   <h5 class="card-text" style="text-align: left"> 4.A donor effectively burns about 650 calories by donating one pint of blood </h5>
   <h1 class="card-text" style="font-family:cursive,Times,serif; color: red; text-align: center; font-size: 30px"> donate blood, save a <img src="images/heart.png"   style="height: 25px; width: 25px;"></h1>
                    </div> 
                   </div>
                    
               
            
              
                <!--
                 Homepage card
             <div class="row mb-3">
                 
                                            <div class="col-xl-3 col-sm-6 py-2">
                                <a href="newDonor.jsp">
                                <div class="card bg-success text-white h-100 ">
                                    <div class="card-body bg-success">
                                        <div class="rotate">
                                          
                                        </div>
                                        <h6 class="text-uppercase">Adult Donors</h6>
            
                                    </div>
                                </div>
                                    </a>
                            </div>
                 
                                            <div class="col-xl-3 col-sm-6 py-2">
                                <a href="studentDonors.jsp">
                                <div class="card bg-dark text-white h-100" style="width: 250px; height: 350px">
                                    <div class="card-body">
                                        <img  class="card-img-top" src="images/student.png" alt="Card image cap" >
                                        <div class="rotate">
                                           
                                        </div>
                                        <h6 class="text-uppercase">Student Donors</h6>
                                        
                                    </div>
                                </div>
                                    </a>
                            </div> <br>
                                                            
                                            <div class="col-xl-3 col-sm-6 py-2">
                                <a href="bloodBag.jsp">
                               <div class="card bg-dark text-white h-100" style="width: 250px; height: 350px">
                                    <div class="card-body bg-dark">
                                        <img  class="card-img-top" src="images/bloodbag.jpg" alt="Card image cap" >
                                        <div class="rotate">
                                           
                                        </div>
                                        <h6 class="text-uppercase">Record new bag</h6>
                                       
                                    </div>
                                </div>
                                    </a>
                            </div>
                                            <div class="col-xl-3 col-sm-6 py-2">
                                <a href="bloodDetails.jsp">
                                <div class="card bg-success text-white h-100">
                                    <div class="card-body bg-success">
                                        <div class="rotate">
                                           
                                        </div>
                                        <h6 class="text-uppercase"> Available Blood </h6>
                                      
                                    </div>
                                </div>
                                    </a>
                            </div>
                            
            
                 </div>
               
                -->
            </div>
        </div>
                <!-- JQuery -->
                <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
                <!-- Bootstrap tooltips -->
                <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
                <!-- Bootstrap core JavaScript -->
                <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
                <!-- MDB core JavaScript -->
                <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.7.7/js/mdb.min.js"></script>

                <jsp:include page="footer.jsp"></jsp:include>

                </body>
                </html>