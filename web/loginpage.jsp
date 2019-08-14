<%-- 
    Document   : loginpage
    Created on : Apr 5, 2019, 3:01:50 PM
    Author     : victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
  <title>Blood Bank System</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="images/style.css">
</head>
<body>
      <div class="container">

            <div class="text-center">
                <h1 style="font-family:cursive,Times,serif; color: #8a0303; text-align: center "> Welcome to County Blood Bank System <img src="images/heart.png"   style="height: 25px; width: 25px;" ></h1>

            </div>

        </div> 
       <div class="login-box">
           <img src="images/blooddrop.jpg" class="avatar">
        <form method="post" name="loginform" action="${pageContext.request.contextPath}/loginServlet">
            <p pos="center" style="color: green;">${successString}  </p>
            <p pos="center" style="color: red;">${errorString}  </p>
         
           
                    
            <p>Username:</p>
                    <input type="text" name="username" placeholder="enter your user name">
                            
             
                    <p> Password:</p>
                    
                  <input type="password" name="password" placeholder="enter your password" >
                  <p> Remember me: <input type="checkbox" name ="remember" value="yes"/> </p>
                 
             
                    
                <input type="submit" value="Login" onClick="myfunction()"> 

                </tr>
            </table>
                </div>

        </form>  
 
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    </body>
    
    
    
</html>
