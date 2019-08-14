/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Users;
import dataAccessObjects.DBConnection;
import dataAccessObjects.DBUtils;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.sql.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author victor
 */
@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet implements Serializable {
    
    private static final long serialVersionUID = 1L;

    public loginServlet() {
        super();
    }



    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
           
        RequestDispatcher dispatcher //
                = this.getServletContext().getRequestDispatcher("/loginpage.jsp");

        dispatcher.forward(request, response);

    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        processRequest(request, response);
        String errorString = null ;
          Boolean  error = true;
          Users user =new Users();
       String username = request.getParameter("username");
        String password = request.getParameter("password");
        String admin = request.getParameter("admin");
        String officer = request.getParameter("healthofficer");
        String remember = request.getParameter("remember");
        boolean rememberMe = "yes".equals(remember);
         Connection connection = null;
          
       
        if (username !=null || password != null || username.length()!=0 || password.length()!=0) {
            
           
        
            try {
        
     if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost/BloodBank", "root", "gachau");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
         

        } 

                 
            String query = "Select * from users where username = ? and password =?";
            
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            
            ResultSet resultSet;
            resultSet = preparedStatement.executeQuery();
            
            if(resultSet.next()){
               // username = resultSet.getString(4);
               HttpSession session = request.getSession();
                user.setUsername(username);
                    user.setPassword(password);
                    session.setAttribute("loggedInUser", user);
               
              if("admin".equals(resultSet.getString(4))){
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/adminpage.jsp");
                    dispatcher.forward(request, response);
                  
                   
                    
              }
              else if("officer".equals(resultSet.getString(4))){
                   RequestDispatcher dispatcher = request.getRequestDispatcher("/homepage.jsp");
                    dispatcher.forward(request, response);
                    
              }else{
                   errorString = "User Has been suspended";
                  request.setAttribute("errorString", errorString);
                  RequestDispatcher dispatcher;
                dispatcher = request.getRequestDispatcher("/loginpage.jsp");
                 dispatcher.forward(request, response);
                  
              }
             
            
            } else{
               
                 errorString = "WRONG USERNAME OR PASSWORD";
                  request.setAttribute("errorString", errorString);
                  RequestDispatcher dispatcher;
                dispatcher = request.getRequestDispatcher("/loginpage.jsp");
                 dispatcher.forward(request, response);
                 
              }
            
            
                  //  RequestDispatcher dispatcher = request.getRequestDispatcher("/errorpage.jsp");
             // dispatcher.forward(request, response);
                
                            
             
            } catch (SQLException ex) {
                Logger.getLogger(loginServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        else{
            errorString ="invalid detaillssssssss";
              request.setAttribute("errorString", errorString);
            request.setAttribute("user", user);

            // Forward to /login.jsp
            RequestDispatcher dispatcher //
                    = this.getServletContext().getRequestDispatcher("/loginpage.jsp");

            dispatcher.forward(request, response);
            
        }
             
         
              
       }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
