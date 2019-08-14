<%-- 
    Document   : help.jsp
    Created on : Jun 27, 2019, 1:04:04 AM
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
         <h3 style="text-align: justify"> Searching a donors record</h3>
        <h5 style="text-align: justify">Once a donor is at the donation desk, request them to provide their identification</h5>
         <h5 style="text-align: justify"> Enter id number for adult or admission number in the search box in the Home page</h5>
         <h5 style="text-align: justify">On searching the system will respond by showing all the previous dates of donation</h5>
         <h5 style="text-align: justify">If the donor has never donated blood through the system again, click on the "Adult donors" <br>
             link for an adult and the "students" link for Student </h5>
         <h5 style="text-align: justify">If the donor had previously donated, Confirrm with the latest date if they are eligible to donate.</h5>
        
        
         <h3 style="text-align: justify"> Recording an adult donor</h3>
         <h5 style="text-align: justify">Click on the"Adult Donors" link on the navigation bar</h5>
         <h5 style="text-align: justify">1. Request for the Id card from the donor at the donation registration desk</h5>
         <h5 style="text-align: justify">2. Enter the donors First name, last name, id number from the Id card </h5>
         <h5 style="text-align: justify">3.Request for the donors id number and age</h5>
         <<h5 style="text-align: justify">4. Age and weight is a necessity to determine whether the donor eligible to donate</h5>
         <h5 style="text-align: justify"> 5.Record the donors gender and the county of residence.</h5>
         <h5 style="text-align: justify"> Click the "Record Donor" Button</h5>
         
                  <h3 style="text-align: justify"> Recording A student donor</h3>
                  <h5 style="text-align: justify">1.Click on the "Students" link on the navigation bar</h5>
                  <h5 style="text-align: justify">2.Request for student id cards before recording a student </h5>
                  <h5 style="text-align: justify">Record the students details from the student id ie first name, last name, school, admission number</h5>
                  <h5 style="text-align: justify">Students are also required to provide details about the age and weight</h5>
                  
                  <h3 style="text-align: justify"> Recording a blood bag</h3>
                  <h5 style="text-align: justify">After donation all the bags must be screened and their blood group written on the bag.</h5>
                  <h5 style="text-align: justify">Every bag must have a bag id, the donor id, that is either the student admission numbers, or the id numbers</h5>
                  <h5 style="text-align: justify">After screening the bag should have the blood group and status to show if it rejected or good for transfusion</h5>
                  <h5 style="text-align: justify">Click on the "Record Blood Bag" link to add the above details</h5>
                  <h5 style="text-align: justify">Click on the "Add bag" button to submit the bag details </h5>
                  
                  <h3 style="text-align: justify"> Picking a blood bag for transfusion</h3>
                  <h5 style="text-align: justify"> Click on the "blood bags details" link </h5>
                  <h5 style="text-align: justify">On the table displayed click the "view" on the Available for donation column <br>
                      based on the blood group you want to pick for transfusion
                  </h5>
                  <h5 style="text-align: justify">A page is displayed with a list of bags available and an add to cart button </h5>
                  <h5 style="text-align: justify">Add the bag you need</h5>
                  <h5 style="text-align: justify">Once you are done click on the view cart to see the bags you have selected</h5>
                  <h5 style="text-align: justify">You can remove a bag from the cart by clicking the remove button</h5>
                  <h5 style="text-align: justify">If you are good with the bags you can select the hospital you want to give the blood to</h5>
                  <h5 style="text-align: justify"> Click on the take bag button to pick the bag</h5>
                  
                    <h3 style="text-align: justify"> viewing records</h3>
                    <h5 style="text-align: justify"> Click on the record link on the home page </h5>
                    <h5 style="text-align: justify"> The web browser opens a new tab with a pdf document</h5>
                    
                    <h3 style="text-align: justify"> viewing Recipients</h3>
                    <h5 style="text-align: justify">Click on the "Recipients" icon </h5>
                    <h5 style="text-align: justify">A web page with all the list of hospitals and the bags they received is dispalyed</h5>
                  
                  <jsp:include page="footer.jsp"></jsp:include>

    </body>
</html>
