/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Users;
import dataAccessObjects.DBUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.*;
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
@WebServlet(name = "updatePassword", urlPatterns = {"/updatePassword"})
public class updatePassword extends HttpServlet {
    Connection  connection;
     PreparedStatement preparedStatement ;
     ResultSet resultSet;
     public  void connect()
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

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String oldpassword = request.getParameter("oldpassword");
        String newpassword = request.getParameter("newpassword");
        String confirmpassword = request.getParameter("confirmpassword");
        
        String errorString;
        String successString;
        
        Users user = new Users(username, oldpassword, newpassword, confirmpassword);
        DBUtils db = new DBUtils();
        if( newpassword.length() > 6){
        if(newpassword.equals(confirmpassword)){
        try { 
          connect();
            String sql1 = "select * from users where username =? and password =?";
            preparedStatement = connection.prepareStatement(sql1);
            preparedStatement.setString(2,oldpassword);
            preparedStatement.setString(1,username);
           resultSet= preparedStatement.executeQuery();
           if(resultSet.next()){
            String oldpassword2 = resultSet.getString(2);
            if(oldpassword2 == null ? newpassword == null : oldpassword2.equals(newpassword)){
                  errorString = "old password cannot be new password";
        
               String url = "/changePassword.jsp";
               request.setAttribute("errorString", errorString);
               RequestDispatcher dispatcher = request.getRequestDispatcher(url);
               dispatcher.forward(request, response);
                
            }
            else{
                db.changePassword(username, newpassword);
                 successString =" password updated Successfully";
               String url = "/changePassword.jsp";
               request.setAttribute("successString", successString);
               RequestDispatcher dispatcher = request.getRequestDispatcher(url);
               dispatcher.forward(request, response);
            }
           }
           else{
                errorString = "Wrong username or password";
        
               String url = "/changePassword.jsp";
               request.setAttribute("errorString", errorString);
               RequestDispatcher dispatcher = request.getRequestDispatcher(url);
               dispatcher.forward(request, response);
           }
           
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(updatePassword.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else{
         errorString = "confirm password doesnt match the new password";  
          
               String url = "/changePassword.jsp";
               request.setAttribute("errorString",errorString);
               RequestDispatcher dispatcher = request.getRequestDispatcher(url);
               dispatcher.forward(request, response);
        }
    }
        else{
            errorString = "Password length is too short";
          
               String url = "/changePassword.jsp";
               request.setAttribute("errorString",errorString);
               RequestDispatcher dispatcher = request.getRequestDispatcher(url);
               dispatcher.forward(request, response);
        }
    }
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
