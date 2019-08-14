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
                <h2 style="text-align: justify"> Welcome to the admin's help page</h2>
        
        <h3 style="text-align: justify"> Adding A new user</h3>
        <h5 style="text-align: justify"> Click "add user" link on the navigation bar </h5> 
        <h5 style="text-align: justify"> Enter the username, ensure that name is not blank </h5> 
        <h5 style="text-align: justify"> Enter the id number the length should be 7 or 8 digits </h5> 
        <h5 style="text-align: justify"> Click the add new user button </h5>
        <h5 style="text-align: justify"> A "user added successfully" is shown </h5> 
        <h5 style="text-align: justify"> If the username is taken or invalid id number "a username is taken or invalid id number" message is shown </h5>
        <h5 style="text-align: justify">The new user are highly recommended to change their passwords after their first successful login</h5>
        
          <h3 style="text-align:justify"> Suspending a user</h3>
          <h5 style="text-align: justify"> A user can be suspended if <br>
              1. They are suspected to be performing malicious actions with the system <br>
          2. They no longer work at the blood bank</h5>
          <h5 style="text-align: justify"> Enter the username of the user you want to suspend </h5>
          <h5 style="text-align: justify">The user must have already been recorded in the system</h5>
          <h5 style="text-align: justify"> Click suspend user </h5>
          <h5 style="text-align: justify">Suspended users cannot access the system anymore</h5>
                  <h3 style="text-align: justify"> Reseting a users password</h3>
                  <h5 style="text-align: justify"> Incase a user forgets their passwords they can be reset to their original id numbers</h5>
                  <h5 style="text-align: justify">Click on the Reset password link</h5>
                  <h5 style="text-align: justify"> Enter the user's username and click the reset button</h5>
                  <h5 style="text-align: justify">The password is now reset</h5>
                                      <h3 style="text-align: justify"> viewing records</h3>
                    <h5 style="text-align: justify"> Click on the record link on the home page </h5>
                    <h5 style="text-align:justify"> The web browser opens a new tab with a pdf document</h5>
                    
                <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
