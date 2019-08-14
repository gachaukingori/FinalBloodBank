<%-- 
    Document   : cart
    Created on : Jun 8, 2019, 11:12:19 PM
    Author     : victor
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
                    <h3>  <input class="form-control mr-sm-2" type="text" placeholder="Id number/admission no" name="search" aria-label="Search"> </h3>
                    <h3> <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Search"></h3>
                </form>
            </div>
        </nav>

         <h3 style="color: black"> my cart </h3>
        <p pos="center" style="color: green;">${successString}  </p>
        <p pos="center" style="color: red;">${errorString}  </p>


        <form method="post" action="RecipientServlet">
            <h3> <label style="color:black ">Hospital: </label> <select name="hospital">
                                <option>County Referral Hospital </option>
                               
                                <option> Central Sub-county Hospital </option>
                                <option> East Sub-county Hospital</option>
                                <option> North Sub-County Hospital </option>
                                <option> West Sub-County Hospital</option>
                                <option> South Sub-County Hospital</option>
                                
                            </select> </h3>

  <div id="div1">
                            
   </div>



            <%-- <%  Iterator itr; %>

        <%
           // ArrayList myCartList = (ArrayList) session.getAttribute("myCartList");
            
         /* for (itr = myCartList.iterator();
                   itr.hasNext();) {
             String bagId = (String) itr.next();
            String bloodgroup = (String) itr.next();
            String bloodtype = (String) itr.next();
*/
            %>
            --%>
            <c:forEach items="${sessionScope.myCartList}" var="cart" >







                <table class="table-striped">
                    
                    <tr>

                        <td style="width: 20%"><input type="text" value= ${cart.bagId}  readonly="" name="bagId"></td>

                        <td style="width: 20%"> <input type="text" value="${cart.bloodtype}" readonly="" name="bloodgroup"</td>
                        <td style="width: 20%"> <input type="text" value="${cart.bloodbag}" readonly="" name="bloodtype" </td>
                        <td style="width: 20%">  <a href = "<c:url value='/cartServlet?bagId=${cart.bagId}&action=remove' /> "><h3> Remove</h3></a> </td>
                        
                        <td> <br></td>
                            <%
                                String hospital = request.getParameter("hospital");
                            %>

                       
                        <td style="width: 20%"> <input type="submit" value=" Take a bag" name="pick" > <input type="text" value="pick" name="action" hidden >  </td>
                       

                        <%-- <td>  <a href = "<c:url value='/RecipientServlet?hospital = hospital' /> " > Take bag</a> </td> --%>

                    </tr>


                </table>

            </c:forEach>



            <%-- <%
          }
           %>.
            --%>

        </form>


      <jsp:include page="footer.jsp"></jsp:include>
    </body>
</html>
