<%-- 
    Document   : emergencySms
    Created on : Jun 4, 2019, 3:24:01 PM
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

         <div class="card">



            <div class="card-body px-lg-5 pt-0">



                <h4 class="card-title" > Short Messaging Service</h4>
                <p class="card-text"> How to recharge your Africa's talking account </p>
                <p class="card-text">1. Go to m-pesa Pay Bill </p>
                <p class="card-text"> 2. Enter Africa's Talking Business Number 525900</p>
                <p class="card-text">  3. Enter your Africa's Talking Account Number. Your account number is bloodbank.api </p>
                
                <p class="card-text">4.Enter the Amount of credits you want to buy</p>
                <p class="card-text"> For more information click <a href="https://account.africastalking.com/apps/vvvbbhgemr" target="_blank"> this link</a> </p>
                <form class="text-center" action="smsServlet" method="post">
                     <div class="md-form">
            <label>Emergency or a public announcement</label>
            <textarea name="emergency" placeholder="Insert Text Here" required="you can't send a blank Sms"></textarea><br>
                     </div>
                     <div class="md-form">
            <label> Send To(sub counties) </label> 
            <select name="subcounty">
                <option> All </option>
                <option>East</option>
                <option>West </option>
                <option> Central</option>
                <option> North</option>
                <option>South</option>
            </select><br>
                     </div>
            <input type="submit" value="send sms">
        </form>
        <p>  ${smsSuccess}</p>
             <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
