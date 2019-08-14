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
@WebServlet(name = "suspendServlet", urlPatterns = {"/suspendServlet"})
public class suspendServlet extends HttpServlet {

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
       // processRequest(request, response);
    }

        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //  processRequest(request, response);
      String username = request.getParameter("username");
                  DBConnection db = new DBConnection();
                  String url = "suspendUser.jsp";
                  
        try {
            boolean x = db.confirmUserToSuspend(username);
            if(x == true){
                db.suspendUser(username);
                String successString = "user " + username +" was suspended";
                request.setAttribute("successString", successString);
                
            }
            else  {
                String errorString = "user "+ username + " does not exist";
                request.setAttribute("errorString", errorString);
                
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(suspendServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
                  
      
    }

        @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
