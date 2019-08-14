/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.allDonors;
import Models.minorDonors;
import Models.newDonor;
import Models.studentDonors;
import dataAccessObjects.DBConnection;
import dataAccessObjects.DBUtils;
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

/**
 *
 * @author victor
 */
@WebServlet(name = "allDonorsServlet", urlPatterns = {"/allDonorsServlet"})
public class allDonorsServlet extends HttpServlet {
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
 
   public void disconnect() throws SQLException{
        connection = null;
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
        String search = request.getParameter("search");
        String errorString;
          String donorId = "", category = "",bloodgroup = "",bloodtype = "", gender = "",date_last_donated = "" ,fname="", lname="";
        
        
        List searchDonor = new ArrayList();
       

       
        

    try {
        connect();
      
              String sql1 = "Select * from BLOODTYPE where donorID = ?";
           preparedStatement = connection.prepareStatement(sql1);
        preparedStatement.setString(1, search);
        resultSet = preparedStatement.executeQuery();
       // String dbcategory;
        if (resultSet.next()){
            // dbcategory = resultSet.getString(2);
          donorId = resultSet.getString(1);
           category= resultSet.getString(2);
           bloodgroup = resultSet.getString(3);
            bloodtype = resultSet.getString(4);
               String sql6 = "Select * from ALLDONORS where donorID = ?";
              preparedStatement = connection.prepareStatement(sql6);
        preparedStatement.setString(1, search);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
         fname= resultSet.getString(1);
           lname = resultSet.getString(2);
        gender = resultSet.getString(4); 
     
        }
               String sql5 = "Select * from ELIGIBILITY where donorID =?";
        preparedStatement = connection.prepareStatement(sql5);
        preparedStatement.setString(1, search);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
           date_last_donated = resultSet.getString(4);
            
        
                    }
           
        
        allDonors donor = new allDonors(fname,lname,gender,donorId, category,bloodgroup,bloodtype,date_last_donated);
             request.setAttribute("donor" , donor);
             
                      String  url = "displaySearch.jsp";
                        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                    //   dispatcher.include(request, response);

          
        }
        
        else{
            errorString = "donor not found";
             String  url = "displaySearch.jsp";
             RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                   //    dispatcher.include(request, response);

        }
        
    } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(allDonorsServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
        
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String donorId = request.getParameter("donorID");  
         String category = request.getParameter("category");  
          String bloodgroup = request.getParameter("bloodgroup");  
           String bloodtype = request.getParameter("bloodtype");  
           
           DBConnection     db =new DBConnection();
           String successString ;
           String errorString;
           String successString1;
           
           String url;
           allDonors donor = new allDonors(donorId, category,bloodgroup,bloodtype);
           // System.out.println(donor.getDonorId() + donor.getBloodtype() + donor.getCategory());
           if (null == category){
               errorString = donor.getDonorId()+ "has not been recorded becauste of category";
               request.setAttribute("errorString", errorString);
               url = "/allDonors.jsp";
               RequestDispatcher dispatcher = request.getRequestDispatcher(url);
               dispatcher.forward(request, response);
           }
           else switch (category) {
            case "adult":
                System.out.println(donor.getDonorId() + donor.getBloodtype() + donor.getCategory());
                try {
                    boolean x = db.validateAdultDonorExists(donorId);
                    if (x == true){
                        db.addBloodGroup(donor);
                        successString1 = donor.getDonorId() +" Blood details updated successfully";
                        request.setAttribute("successString1", successString1);
                        url = "/newDonor.jsp";
                        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                        dispatcher.forward(request, response);
                        
                    }else{
                        errorString = donor.getDonorId()+ " has not been recorded as  " + donor.getCategory();
                        request.setAttribute("errorString", errorString);
                        url = "/newDonor.jsp";
                        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                        dispatcher.forward(request, response);
                        
                        
                    }
                    
                    
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(allDonorsServlet.class.getName()).log(Level.SEVERE, null, ex);
                }   break;
            case "student":
                try {
                    boolean x = db.validateStudentDonorExists(donorId);
                    if (x == true){
                        db.addBloodGroup(donor);
                        successString = donor.getDonorId() +" Blood details added successfully";
                        request.setAttribute("successString", successString);
                        url = "/allDonors.jsp";
                        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                        dispatcher.forward(request, response);
                        
                    }else{
                        errorString = donor.getDonorId()+" has not been recorded as  "+donor.getCategory();
                        request.setAttribute("errorString", errorString);
                        url = "/allDonors.jsp";
                        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                        dispatcher.forward(request, response);
                        
                        
                    }
                    
                    
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(allDonorsServlet.class.getName()).log(Level.SEVERE, null, ex);
                }   break;
            case "minor":
                try {
                    boolean x = db.validateMinorDonorExists(donorId);
                    if (x == true){
                        db.addBloodGroup(donor);
                        successString = donor.getDonorId() +" Blood details added successfully";
                        request.setAttribute("successString", successString);
                        url = "/allDonors.jsp";
                        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                        dispatcher.forward(request, response);
                        
                    }else{
                        errorString = donor.getDonorId()+" has not been recorded as  " +donor.getCategory();
                        request.setAttribute("errorString", errorString);
                        url = "/allDonors.jsp";
                        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                        dispatcher.forward(request, response);
                        
                        
                    }
                    
                    
                    
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(allDonorsServlet.class.getName()).log(Level.SEVERE, null, ex);
                }   break;
            default:
                errorString = donor.getDonorId()+ "has not been recorded because of category";
                request.setAttribute("errorString", errorString);
                url = "/allDonors.jsp";
                RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                dispatcher.forward(request, response);
                break;
        }
    }

       @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

