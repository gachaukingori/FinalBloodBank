<%-- 
    Document   : newDonor
    Created on : Apr 22, 2019, 2:56:37 PM
    Author     : victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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
                <form class="form-inline my-2 my-lg-0" method="get" action="displayAdultSearch.jsp">
                    <h3> <input class="form-control mr-sm-2" type="text" placeholder="Search " name="search" aria-label="Search"> </h3>
                    <h3> <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Search"> </h3>
                </form>
            </div>
        </nav>
        
        
        
  <div class="container-fluid" id="main">
            <div class="row row-offcanvas row-offcanvas-left">
                <div class="col-md-3 col-lg-2 sidebar-offcanvas bg-light pl-0" id="sidebar" role="navigation">
                    <ul class="nav flex-column sticky-top pl-0 pt-5 mt-3">

                        <li class="nav-item">
                            <a class="nav-link" href="#submenu1" data-toggle="collapse" data-target="#submenu1">View Donors By Gender</a>
                            <ul class="list-unstyled flex-column pl-3 collapse" id="submenu1" aria-expanded="false">
                                 <li class="nav-item"><a class="nav-link" href="viewDonors.jsp?view=Male" >Male</a></li>
                                <li class="nav-item"><a class="nav-link" href="viewDonors.jsp?view=Female" >Female</a></li>
                            </ul>
                        </li>
                         <li class="nav-item">
                            <a class="nav-link" href="#submenu1" data-toggle="collapse" data-target="#submenu1">View Donors By Sub-County</a>
                            <ul class="list-unstyled flex-column pl-3 collapse" id="submenu1" aria-expanded="false">
                                <li class="nav-item"><a class="nav-link" href="viewDonors.jsp?view=Central" >Central</a></li>
                                   <li class="nav-item"><a class="nav-link" href="viewDonors.jsp?view=East" >East</a></li>
                                      <li class="nav-item"><a class="nav-link" href="viewDonors.jsp?view=North" >North</a></li>
                                         <li class="nav-item"><a class="nav-link" href="viewDonors.jsp?view=South" >South</a></li>
                                            <li class="nav-item"><a class="nav-link" href="viewDonors.jsp?view=West" >Central</a></li>
                             
                            </ul>
                        </li>
                        

                        <li class="nav-item"><a class="nav-link" href="help.jsp">Help</a></li>
                       

                       
                        <li class="nav-item"><a class="nav-link" href="changePassword.jsp" >Change Password</a></li>
                       <li class="nav-item"><a class="nav-link" href="loginpage.jsp">logout (${loggedInUser.getUsername()})</a></li>

                    </ul>
                </div>

                <div class="card" style="left: 25%; width: 500px; " >
            <div class="card-body px-lg-5 pt-0">
                <form class="text-center" method="post" action="newDonorServlet">
                    <p pos="center" style="color: green;">${successString}  </p>
                    <p pos="center" style="color: red;">${errorString}  </p>

                    <div class="md-form">
                        <label> First Name:</label>
                        <input type="text" name="fname" placeholder="Donor's First Name" value="${donor.getFname()}" required="Please enter this field">
                    </div>

                    <div class="md-form">
                        <label> Last Name:</label>
                        <input type="text" name="lname" placeholder="Donor's Last Name"value="${donor.getLname()}"required="Please enter this field">
                    </div>
                    <div class="md-form">
                        <label> ID Number:</label>
                        <input type="number" name="idnumber" placeholder="Donor's ID Number"required="Please enter this field" >

                    </div>
                    <div class="md-form">   
                        <label>   Age: </label>
                        <input type="number" name="age" placeholder="Donor's age" required="Please enter this field" max="65" min="18"> 
                    </div>
                    <div class="md-form">
                        <label> Phone Number:</label>
                        <input type="text" name="telephone" placeholder="Donor's Phone Number" required="Please enter this field" value="+2547">
                    </div>
                    <div class="md-form">
                        <label>Gender: </label>

                        <select name="gender">
                            <option>Male</option>
                            <option>Female</option>
                        </select>
                    </div>
                    <div class="md-form">
                        <label>Sub County:</label>

                        <select name="subcounty">
                            <option>East</option>
                            <option>West</option>
                            <option>North</option>
                            <option>South</option>
                            <option>Central</option>
                        </select>
                    </div>

                    <button class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="submit" name ="recorddonor" value="recorddonor">Record Donor </button>


                </form>
            </div>
        </div>
                    <div class="card" style="left: 30% ; width: 300px; top:20px; height: 250px;  ">
                                   <div class="card-title"><h4>View Donors Registered </h4> </div>
                                 <form class="text-center" action="adultFilter.jsp" method="post">
                                     <div class="md-form">
                                <label> From: </label>
                                <input type="date" name="startdate" placeholder="Student's First Name" required="please fill in this field">
                            </div>
                                     <div class="md-form">
                                <label> To: </label>
                                <input type="date" name="enddate" placeholder="Student's First Name" required="please fill in this field">
                            </div>
                                       <button class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="submit" name ="adultDonors" value="view adult donors">View </button>
                                 </form>
                                 
                                 
                             </div>
  </div>
         </div>
                            <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
