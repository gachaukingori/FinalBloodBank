<%-- 
    Document   : bloodBag
    Created on : May 12, 2019, 11:10:09 PM
    Author     : victor
--%>

<%@page import="java.time.LocalDate"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
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
                <a class="navbar-brand" href="homepage.jsp">CBBank</a> 
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
                        <h3>  <input class="form-control mr-sm-2" type="text" placeholder="Search" name="search" aria-label="Search"> </h3>
                        <h3> <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Search"></h3>
                    </form>
                </div>
            </nav>



            <div class="container-fluid" id="main">
                <div class="row row-offcanvas row-offcanvas-left">
                    <div class="col-md-3 col-lg-2 sidebar-offcanvas bg-light pl-0" id="sidebar" role="navigation">
                        <ul class="nav flex-column sticky-top pl-0 pt-5 mt-3">

                            <li class="nav-item">
                                <a class="nav-link" href="#submenu1" data-toggle="collapse" data-target="#submenu1">View All Donors</a>
                                <ul class="list-unstyled flex-column pl-3 collapse" id="submenu1" aria-expanded="false">
                                    <li class="nav-item"><a class="nav-link" href="viewBags.jsp?bloodgroup=A&bloodtype=positive" >A+</a></li>
                                    <li class="nav-item"><a class="nav-link" href="viewBags.jsp?bloodgroup=A&bloodtype=negative" >A-</a></li>
                                    <li class="nav-item"><a class="nav-link" href="viewBags.jsp?bloodgroup=B&bloodtype=positive" >B+</a></li>
                                    <li class="nav-item"><a class="nav-link" href="viewBags.jsp?bloodgroup=B&bloodtype=negative" >B-</a></li>
                                    <li class="nav-item"><a class="nav-link" href="viewBags.jsp?bloodgroup=AB&bloodtype=positive" >AB+</a></li>
                                    <li class="nav-item"><a class="nav-link" href="viewBags.jsp?bloodgroup=AB&bloodtype=negative" >AB-</a></li>
                                    <li class="nav-item"><a class="nav-link" href="viewBags.jsp?bloodgroup=O&bloodtype=positive" >O+</a></li>
                                    <li class="nav-item"><a class="nav-link" href="viewBags.jsp?bloodgroup=O&bloodtype=negative" >O-</a></li>
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
                        <h3 class="card-title" style="text-align: center">Blood Bag</h3>


                        <form class="text-center" action="bloodBagServlet" method="post" >

                            <p pos="center" style="color: green;">${successString}  </p>
                            <p pos="center" style="color: red;">${errorString}  </p>
                            <div class="md-form">
                                <label>Bag Id:</label>

                                <input type="number" name="bagId" placeholder="Enter the bag number" required="Please enter this field" min="1" max="100000">

                            </div>
                            <div class="md-form">
                                <label>Donor Id:</label>

                                <input type="text" name="donorId" placeholder="Enter donor's id" required="Please enter this field" min="1">

                            </div>


                            <div class="md-form">
                                <label>Category:</label>

                                <select name="category">
                                    <option>student</option>
                                    <option>adult</option>

                                </select>

                            </div>

                            <div class="md-form">
                                <label>Blood Group</label>

                                <select name="bloodgroup">
                                    <option>A</option>

                                    <option>B</option>
                                    <option>AB</option>
                                    <option>O</option>
                                </select>

                            </div>

                            <div class="md-form">
                                <label>Blood Type:</label>


                                <select name="bloodtype" >
                                    <option>+ve</option>
                                    <option>-ve</option>

                                </select>

                            </div>

                            <div class="md-form">
                                <label> Transfusable </label>

                                <select name="status">
                                    <option> Yes</option>
                                    <option> No</option>
                                </select>
                            </div>


                            <%
                                LocalDate today = LocalDate.now();
                            %>
                            <div class="md-form">
                                <label>Date of Donation</label>

                                <input type="date" value="dd/mm/yyyy" id="donationDate" name="date_of_donation" required="Please enter this field"   >

                            </div>
                            <div id="datewarn">

                            </div>
                            <div class="md-form">


                                <button class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="submit" name ="addBag" value="Add Bag">Add Bag </button>
                            </div>
                        </form>


                        <a href="newDonor.jsp" class="card-link"> add an adult donor</a>
                        <a href="studentDonors.jsp" class="card-link"> add a student donor</a>
                    </div>
                </div>
                            <div class="card" style="left: 30% ; width: 300px; top:20px; height: 250px;  ">
                                   <div class="card-title"><h4>View Donors  </h4> </div>
                                 <form class="text-center" action="donorFilter.jsp" method="post">
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
