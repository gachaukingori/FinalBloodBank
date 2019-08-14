<%-- 
    Document   : recipientConfirm
    Created on : May 23, 2019, 8:19:53 AM
    Author     : victor
--%>

<%@page import="dataAccessObjects.DBConnection"%>
<%@page import="java.sql.*"%>
<%@page import="Models.bloodBag"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            int bagId = Integer.parseInt(request.getParameter("bagId"));
            String bloodgroup = "A", bloodtype = "+ve", recipient_date = "2019-05-22";

            bloodBag bag = new bloodBag(bagId, bloodgroup, bloodtype, recipient_date);
            Connection connection = null;
            PreparedStatement pstatement;
            ResultSet resultSet;
            if (connection == null || connection.isClosed()) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    connection = DriverManager.getConnection("jdbc:mysql://localhost/BloodBank", "root", "gachau");
                } catch (ClassNotFoundException e) {
                    throw new SQLException(e);
                }
            }
            String sql1 = "Select CURDATE()";
            pstatement = connection.prepareStatement(sql1);
            resultSet = pstatement.executeQuery();
            while (resultSet.next()) {
                bag.setRecipient_date(resultSet.getString(1));
            }

            DBConnection db = new DBConnection();
            boolean x = db.confirmBagExistsForRecipient(bagId);
            if (x == false) {
        %>
        <p>The Blood bag <%= bagId%> not found</p>
        <%
        } else {

            String sql = "Select * from bloodbags where bagID = ?";
            pstatement = connection.prepareStatement(sql);
            pstatement.setInt(1, bagId);
            resultSet = pstatement.executeQuery();

            while (resultSet.next()) {
                bag.setBagId(bagId);
                bag.setBloodgroup(resultSet.getString(3));
                bag.setBloodtype(resultSet.getString(4));
            }
        %>
      
            
           <p> confirm that bag number <%= bag.getBagId()%> is blood group <%= bag.getBloodgroup()%>   <%= bag.getBloodtype()%> </p>
        
                
        <%
        }

db.updateBloodBagsAfterBagIsTaken(bagId, bloodgroup, bloodtype, recipient_date);


        %>
    </body>
</html>
