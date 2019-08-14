<%-- 
    Document   : allABPositive
    Created on : Jun 5, 2019, 9:57:35 PM
    Author     : victor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <    <%
            List<bloodBag> bagList = (List) request.getAttribute("bagList");
            // bloodBag bag = (bloodBag)request.getAttribute("bag");
            for (bloodBag bag : bagList) {
        %>
        <table>
            <tr>
                <th>
                    Bag Number
                </th>

            </tr>
            <tr>
                <th>
                    Blood Group
                </th>

            </tr>

            <tr>
                <th>
            <tr>
                <th>
                    Blood Type
                </th>

            </tr>

            <tr>
                <th>
                    Date Of Donation
                </th>

            </tr>
            <tr>
                <td> <%= bag.getBagId()%> </td>

            </tr>
            <tr>
                <td> <%= bag.getBloodgroup()%> </td>

            </tr>
            <tr>
                <td> <%= bag.getBloodtype()%> </td>

            </tr>
            <tr>
                <td> <%= bag.getDate_of_donation()%> </td>

            </tr>


        </table>
<%
        }



        %> 
    </body>
</html>
