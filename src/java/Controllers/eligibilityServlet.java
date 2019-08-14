/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.allDonors;
import dataAccessObjects.DBUtils;
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
@WebServlet(name = "eligibilityServlet", urlPatterns = {"/eligibilityServlet"})
public class eligibilityServlet extends HttpServlet {

   
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
       String donorID = request.getParameter("donorID");
       String eligibility = request.getParameter("eligibility");
       String date_of_donation = request.getParameter("date_of_donation");
        
       DBUtils db = new DBUtils();
        allDonors donor = new allDonors(donorID,date_of_donation,eligibility);
       
        try {
            boolean x = db.validateDonorBloodDetilsAdded(donorID);
            if(x== true){
               
                db.addEligibilityStatus(donor);
                 String successString1 = donor.getDonorId() +" details updated successfully";
                        request.setAttribute("successString1", successString1);
                      String  url = "/newDonor.jsp";
                        RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                        dispatcher.forward(request, response);
                
            }
            else{
                String errorString1 = donor.getDonorId() + " Blood Type has not been recorded";
                String  url = "/newDonor.jsp";
                request.setAttribute("errorString1", errorString1);
                 RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                        dispatcher.forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(eligibilityServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
