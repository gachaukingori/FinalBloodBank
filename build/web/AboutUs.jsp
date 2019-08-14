<%-- 
    Document   : AboutUs
    Created on : Jun 13, 2019, 11:56:47 PM
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
                        <h3> <input class="form-control mr-sm-2" type="text" placeholder="Search " name="search" aria-label="Search"> </h3>
                        <h3> <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Search"> </h3>
                    </form>
                </div>
            </nav>
        <h1>The CBBank System is a system developed by Victor Gachau Kingori, A student At egerton university with the main objectives including:<br>
         
        </h1>
        <h3>
            1. Keeping all the county blood bank records in a secure and systematic way<br>
            2. Ensuring that the blood bank records are accessed by authorized at any time through a web browser <br>
            3. Enable the county health officers make public announcements to the public through a Short messaging Service<br>
            
        </h3>
                <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
