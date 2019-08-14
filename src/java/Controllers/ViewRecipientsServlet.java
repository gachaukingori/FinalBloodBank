/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author victor
 */
@WebServlet(name = "ViewRecipientsServlet", urlPatterns = {"/ViewRecipientsServlet"})
public class ViewRecipientsServlet extends HttpServlet {

       protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }
       
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

        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       doPost(request, response);
    }

      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       //Referral Hospital
      String sql = "select * from recipients where hospital = 'County Referral Hospital' ";
      int bagId=0;
    // String url  ;
      String bloodtype = "";
      String recipientdate = "";
      ArrayList ReferralList = new ArrayList();
           try {
               connect();
                preparedStatement = connection.prepareStatement(sql);
                resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    
                    ReferralList.add(resultSet.getInt(1));
                    ReferralList.add(resultSet.getString(2));
                    ReferralList.add(resultSet.getString(3));
                    ReferralList.add(resultSet.getString(4));
                    
                    request.setAttribute("ReferralList", ReferralList);
                    
                    
                }
                
             //   System.out.println(sql);
             //  System.out.println(ReferralList);
                       
  // East Sub county
 String sql1 = "Select * from recipients where hospital = 'East Sub-County Hosptital'";
  ArrayList EastList = new ArrayList();
  preparedStatement = connection.prepareStatement(sql1);
  resultSet = preparedStatement.executeQuery();
  while(resultSet.next()){
      EastList.add(resultSet.getInt(1));
      EastList.add(resultSet.getString(2));
      EastList.add(resultSet.getString(3));
      EastList.add(resultSet.getString(4));
      
      request.setAttribute("EastList", EastList);
      
  }

  
                
           } catch (ClassNotFoundException | SQLException ex) {
               Logger.getLogger(ViewRecipientsServlet.class.getName()).log(Level.SEVERE, null, ex);
           }
        String   url = "ViewRecipients.jsp";
      RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
    }

        @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
