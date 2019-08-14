/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.africastalking.AfricasTalking;
import com.africastalking.SmsService;
import com.africastalking.sms.Recipient;
import dataAccessObjects.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Arrays;
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
@WebServlet(name = "smsServlet", urlPatterns = {"/smsServlet"})
public class smsServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
                String username = "bloodbank";    // use 'sandbox' for development in the test environment
String apiKey = "2afa76c30b7f653c114c6ff642aed32142f326c76bd90a3cc4b86a283ff97b45";       // use your sandbox app API key for development in the test environment
AfricasTalking.initialize(username, apiKey);
DBConnection db = new DBConnection();

// Initialize a service e.g. SMS
SmsService sms = AfricasTalking.getService(AfricasTalking.SERVICE_SMS);
//2afa76c30b7f653c114c6ff642aed32142f326c76bd90a3cc4b86a283ff97b45
// Use the service


String message = request.getParameter("emergency");
String subcounty = request.getParameter("subcounty");

String [] number = null;
        try {
            if(     null == subcounty){
                number = db.donorsContacts();
            }else   switch (subcounty) {
                        case "All":
                            number = db.donorsContacts();
                            break;
                        case "East":
                            number = db.eastDonorsContact();
                            break;
                        case "West":
                            number = db.westDonorsContact();
                            break;
                        case "North":
                            number = db.northDonorsContact();
                            break;
                        case "South":
                            number = db.southDonorsContact();
                            break;
                        case "Central":
                            number = db.centralDonorsContact();
                            break;
                        default:
                            number = db.donorsContacts();
                            break;
                    }
                   } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(smsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
List<Recipient> SMSresponse = null;
String smsSuccess;
                    smsSuccess = "'"+ message +"'" + "   Was sent Successfully to all donors from "+ subcounty +"  subcounty" + Arrays.toString(number);
         try {
             SMSresponse = sms.send(message, number, true);
             System.out.println(SMSresponse);
             
         } catch (IOException ex) {
             Logger.getLogger(africaTalkingSms.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
         }
request.setAttribute("SMSresponse",SMSresponse);
request.setAttribute("smsSuccess", smsSuccess);
String url = "/emergencySms.jsp";
RequestDispatcher dispatcher = request.getRequestDispatcher(url);
dispatcher.forward(request, response);

   
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
