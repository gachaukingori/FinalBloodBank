/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.bloodBag;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author victor
 */
@WebServlet(name = "BnegativeServlet", urlPatterns = {"/BnegativeServlet"})
public class BnegativeServlet extends HttpServlet {
   Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
  public void connect()
          
            throws ClassNotFoundException, SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost/BloodBank", "root", "gachau");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            // connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

        }

    }

    public static void disconnect() throws SQLException {
        Connection connection = null;
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               }
  

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
          connect();
           // String[] selectedBags = request.getParameterValues("bagId");

          String sql = "Select * from bloodbags where bloodgroup = 'B' and bloodtype = '-ve' and bloodstatus ='Yes' ";
          preparedStatement = connection.prepareStatement(sql);
          resultSet = preparedStatement.executeQuery();
          //int bagId = 0;
          List bagList = new ArrayList();
          String bloodgroup = "";
          String bloodtype="";
          String date_of_donation= "";
         // bloodBag bag = new bloodBag(bagId,bloodgroup, bloodtype, date_of_donation);
          while (resultSet.next()){
              bagList.add(resultSet.getInt(1));
              bagList.add(resultSet.getString(3));
              bagList.add(resultSet.getString(4));
              bagList.add(resultSet.getString(6));
              
          }
          String bagId = request.getParameter("bagId");
          HttpSession session = request.getSession();
          session.setAttribute("bagId", bagId);
          
          request.setAttribute("bagList",bagList);
       //   request.setAttribute("bag", bag);
          String url = "allBNegative.jsp";
          RequestDispatcher dispatcher = request.getRequestDispatcher(url);
          dispatcher.forward(request, response);
      } catch (ClassNotFoundException | SQLException ex) {
          Logger.getLogger(ApositiveServlet.class.getName()).log(Level.SEVERE, null, ex);
      }


    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String action = request.getParameter("action");
         if ("remove".equals(action)){
        String bagId = request.getParameter("bagId");
       try {
           connect();
           
           String sql1 = "Delete from EXPIREDBLOOD WHERE donorID = ?";
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setString(1, bagId);
            preparedStatement.executeUpdate();
            String successString = "Expired Bag" + bagId + " removed successfully";
            request.setAttribute("successString", successString);
             String url = "expiredBloodBnegative.jsp";
          RequestDispatcher dispatcher = request.getRequestDispatcher(url);
          dispatcher.forward(request, response);
           
       } catch (ClassNotFoundException | SQLException ex) {
           Logger.getLogger(BnegativeServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
    }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
