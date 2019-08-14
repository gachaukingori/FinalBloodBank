/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.allDonors;
import Models.bloodBag;
import dataAccessObjects.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
@WebServlet(name = "bloodBagServlet", urlPatterns = {"/bloodBagServlet"})
public class bloodBagServlet extends HttpServlet {

  Connection  connection = null;
     PreparedStatement preparedStatement ;
 
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
        processRequest(request, response);
    }

   
   
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
     
     

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
        int bagId = Integer.parseInt(request.getParameter("bagId"));
        String category = request.getParameter("category");
         String bloodgroup = request.getParameter("bloodgroup");
          String bloodtype = request.getParameter("bloodtype");
           String status = request.getParameter("status");
            String date_of_donation = request.getParameter("date_of_donation");
            String donorId = request.getParameter("donorId");
            String fname="", lname="",gender="";
            String date_last_donated ="";
            
          
           
               String successString , errorString,url;
            DBConnection db = new DBConnection();
          allDonors donor = new allDonors( donorId, category, bloodgroup, bloodtype,  date_of_donation, gender, lname,  fname, date_last_donated);
            bloodBag bag = new bloodBag(bagId, category,bloodgroup,bloodtype,status,date_of_donation);
        try {
            
             boolean bagExists = db.checkIfBagRecorded(bagId);

           if ("adult".equals(category)){
           
               boolean x = db.checkIfAdultDonorPreviouslyDonated(donorId);
               if(x==false){
                                          errorString = "donor "+ donor.getDonorId()+" has not been recorded";
               url = "/bloodBag.jsp";
               request.setAttribute("errorString", errorString);
               RequestDispatcher dispatcher = request.getRequestDispatcher(url);
               dispatcher.forward(request, response);
                   
               }
               else{
               if (bagExists== true){
                
                                   errorString = "Bag "+ bag.getBagId()+" has already been recorded";
               url = "/bloodBag.jsp";
               request.setAttribute("errorString", errorString);
               RequestDispatcher dispatcher = request.getRequestDispatcher(url);
               dispatcher.forward(request, response);
                
           
             }
            
            
             else{
                 db.addNewBloodBag(bag);
                 db.updateTheDateOfDonationAndBloodGroup( donor);
              successString = "Bag "+ bag.getBagId()+"  added Successfully";
               url = "/bloodBag.jsp";
               request.setAttribute("successString", successString);
               
             
               
               RequestDispatcher dispatcher = request.getRequestDispatcher(url);
               dispatcher.forward(request, response);

             }
               }
               
 
              
               
           }   else {
              
               boolean studentExist = db.validateStudentDonorExists(donorId);
               if (studentExist == false){
                     errorString = "donor "+ donor.getDonorId()+" has not been recorded";
               url = "/bloodBag.jsp";
               request.setAttribute("errorString", errorString);
               RequestDispatcher dispatcher = request.getRequestDispatcher(url);
               dispatcher.forward(request, response);
                   
                   
               }
               else{
 if (bagExists== true){
                
                                   errorString = "Bag "+ bag.getBagId()+" has already been recorded";
               url = "/bloodBag.jsp";
               request.setAttribute("errorString", errorString);
               RequestDispatcher dispatcher = request.getRequestDispatcher(url);
               dispatcher.forward(request, response);
                
           
             }
            
            
             else{
                 db.addNewBloodBag(bag);
                  db.updateTheDateOfDonationAndBloodGroup( donor);
              successString = "Bag "+ bag.getBagId()+"  added Successfully";
               url = "/bloodBag.jsp";
               request.setAttribute("successString", successString);
               
             
               
               RequestDispatcher dispatcher = request.getRequestDispatcher(url);
               dispatcher.forward(request, response);

             }
                   
               }
               
              
           } 
            
           
             System.out.println(" fname is" +fname +" and is a  "+ category);
           
           
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(bloodBagServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
