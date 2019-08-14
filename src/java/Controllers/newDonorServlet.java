/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.minorDonors;
import Models.newDonor;
import dataAccessObjects.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "newDonorServlet", urlPatterns = {"/newDonorServlet"})
public class newDonorServlet extends HttpServlet {

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
           String fname = request.getParameter("fname");
       String lname = request.getParameter("lname");
       String idnumber = request.getParameter("idnumber");
       String telephone = request.getParameter("telephone");
       String subcounty = request.getParameter("subcounty");
       String gender = request.getParameter("gender");
       String date_registered = "";
       int age = Integer.parseInt(request.getParameter("age"));
       String errorString;
       String successString;
       if( fname !="" || lname !="" ){
         
               newDonor donor = new newDonor(fname, lname, idnumber, telephone, gender, subcounty, age, date_registered);
       if(idnumber.length()>10 || idnumber.length()<7){
               errorString = " Invalid ID Number";
            String url = "/newDonor.jsp";
             request.setAttribute("errorString", errorString);
              request.setAttribute("donor", donor);
               RequestDispatcher dispatcher = request.getRequestDispatcher(url);
               dispatcher.forward(request, response);
       }else{
           if(telephone.length()> 13 || !telephone.startsWith("+2547")  || telephone.length()<13){
                   errorString = " Invalid Phone Number";
            String url = "/newDonor.jsp";
             request.setAttribute("errorString", errorString);
              request.setAttribute("donor", donor);
               RequestDispatcher dispatcher = request.getRequestDispatcher(url);
               dispatcher.forward(request, response);
               
           }
           else{
       
       if (age >= 18 && age < 65){
             DBConnection db = new DBConnection();
           try {
              boolean x = db.validateAdultDonorExist(idnumber);
              if(x ==true){
                  errorString = "ID Number "+ donor.getIdnumber()+ " is registered";
               String url = "/newDonor.jsp";
               request.setAttribute("errorString", errorString);
              
               
               RequestDispatcher dispatcher = request.getRequestDispatcher(url);
               dispatcher.forward(request, response);
              }else{
               db.addNewDonor(donor);
            //   db.addPersonalDetails(fname, lname, idnumber, gender);
               successString = "Donor's Details added Successfully";
               String url = "/newDonor.jsp";
               request.setAttribute("successString", successString);
              
               
               RequestDispatcher dispatcher = request.getRequestDispatcher(url);
               dispatcher.forward(request, response);
           }
           
               
           } catch (ClassNotFoundException | SQLException ex) {
               Logger.getLogger(newDonorServlet.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       }else {
           
           errorString = " Donor is ineligible for donation";
            String url = "/newDonor.jsp";
             request.setAttribute("errorString", errorString);
              request.setAttribute("donor", donor);
               RequestDispatcher dispatcher = request.getRequestDispatcher(url);
               dispatcher.forward(request, response);
       }
    }
    }
    }
       else{
              errorString = " Donor is ineligible for donation";
            String url = "/newDonor.jsp";
             request.setAttribute("errorString", errorString);
             // request.setAttribute("donor", donor);
               RequestDispatcher dispatcher = request.getRequestDispatcher(url);
               dispatcher.forward(request, response);
       }
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
