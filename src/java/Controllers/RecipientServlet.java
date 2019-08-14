/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

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
@WebServlet(name = "RecipientServlet", urlPatterns = {"/RecipientServlet"})
public class RecipientServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }
       @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
            DBConnection db = new DBConnection();
            int  bagId = Integer.parseInt(request.getParameter("bagId"));
            
            cartServlet cart = new cartServlet();
            String bloodgroup = request.getParameter("bloodgroup");
            String bloodtype = request.getParameter("bloodtype");
            String hospital = request.getParameter("hospital");
            
            String recipientdate ="";
            String url =null;
            System.out.println(" and Bag " + bagId);
            
            boolean x = true;
        try {
            x = db.updateBloodBagsAfterBagIsTaken(bagId, bloodgroup, bloodtype, recipientdate,hospital);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(RecipientServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            if(x== true){
                String successString = " bag " + bagId + " was picked successfully for hospital " + hospital;
                request.setAttribute("successString", successString);
                cart.removeFromCart(request, response);
                url = "cart.jsp";
                System.out.println(x);
            }
            else{
                String errorString = "bag" + bagId + "does not exist or has been removed";
                request.setAttribute("errorString", errorString);
                url = "cart.jsp";
                System.out.println(x);
            }
            
            
            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
       
    }

        @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
