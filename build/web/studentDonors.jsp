<%-- 
    Document   : studentDonors
    Created on : Apr 22, 2019, 6:18:02 PM
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
                    <form class="form-inline my-2 my-lg-0" method="get" action="displayStudentSearch.jsp">
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
                                <a class="nav-link" href="#submenu1" data-toggle="collapse" data-target="#submenu1">View Student Donors</a>
                                <ul class="list-unstyled flex-column pl-3 collapse" id="submenu1" aria-expanded="false">
                                    <li class="nav-item"><a class="nav-link" href="viewStudentDonors.jsp?view=Male">Boys</a></li>
                                    <li class="nav-item"><a class="nav-link" href="viewStudentDonors.jsp?view=Female">Girls</a></li>

                                </ul>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="emergencySms.jsp" >Emergencies and Blood Appeals</a></li>
                            <li class="nav-item"><a class="nav-link" href="help.jsp">Help</a></li>
                            

                            <li class="nav-item"><a class="nav-link" href="AboutUs.jsp">About Us</a></li>
                            <li class="nav-item"><a class="nav-link" href="changePassword.jsp" >Change Password</a></li>
                            <li class="nav-item"><a class="nav-link" href="loginpage.jsp">logout (${loggedInUser.getUsername()})</a></li>

                    </ul>
                </div>





                <div class="card" style="left: 25% ; width: 500px; top:20px;  ">

                    <div class="card-body px-lg-5 pt-0">
                        <div class="card-title"><h4> Student Donors </h4> </div>
                        <form class="text-center" action="studentDonorServlet" method="post">
                            <p pos="center" style="color: green;">${successString}  </p>
                            <p pos="center" style="color: green;">${errorString}  </p>

                            <div class="md-form">
                                <label> First Name: </label>
                                <input type="text" name="fname" placeholder="Student's First Name" required="please fill in this field">
                            </div>
                            <div class="md-form">
                                <label> Last Name: </label>
                                <input type="text" name="lname" placeholder="Student's Last Name" required="please fill in this field">
                            </div>

                            <div class="md-form">
                                <label>    Gender: </label>


                                <select name="gender" >
                                    <option> Male </option>
                                    <option> Female </option>
                                </select>
                            </div>
                            <div class="md-form">
                                <label> School Name: </label>

                                <input type="text"  required="please fill in this field" name="schoolname" placeholder="School Name">
                            </div>
                            <div class="md-form">

                                <label> Admission Number: </label>

                                <input type="text" name="admission"  required="please fill in this field" placeholder="Adm. Number">
                            </div> 
                            <div class="md-form">
                                <label>  Level Of Study: </label>



                                <select name="level">
                                    <option>I</option>
                                    <option>II</option>
                                    <option>III</option>
                                    <option>IV</option>
                                </select>
                            </div>

                            <div class="md-form">

                                <label> Age: </label>
                                <input type="number" name="age" placeholder="Student's Age" min="16" max="65" required="please fill in this field"></td>


                            </div>
                            <button class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="submit" name ="studentDonor" value="Add Student">Add Student </button>

                        </form>
                    </div>
                </div>
                             <div class="card" style="left: 30% ; width: 300px; top:20px; height: 250px;  ">
                                   <div class="card-title"><h4>View Student Donors Registered </h4> </div>
                                 <form class="text-center" action="studentFilter.jsp" method="post">
                                     <div class="md-form">
                                <label> From: </label>
                                <input type="date" name="startdate" placeholder="Student's First Name" required="please fill in this field">
                            </div>
                                     <div class="md-form">
                                <label> To: </label>
                                <input type="date" name="enddate" placeholder="Student's First Name" required="please fill in this field">
                            </div>
                                       <button class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="submit" name ="studentDonor" value="Add Student">View </button>
                                 </form>
                                 
                                 
                             </div>

            </div>
        </div>


        <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
