/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.studentDonors;
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
@WebServlet(name = "studentDonorServlet", urlPatterns = {"/studentDonorServlet"})
public class studentDonorServlet extends HttpServlet {

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
        String gender = request.getParameter("gender");
        String schoolname = request.getParameter("schoolname");
        String admission = request.getParameter("admission");
        String level = request.getParameter("level");
        String date_registered ="";
        String successString;
        String errorString;
        int age = Integer.parseInt(request.getParameter("age"));
        if (age > 15 && age <= 65) {

            DBConnection db = new DBConnection();
            studentDonors student = new studentDonors(fname, lname, gender, schoolname, admission, level, age,date_registered);
            try {
                boolean x;
                x = db.validateStudentExist(admission);
                if (x == true) {
                   // successString = "Donor  " + student.getLname() + " Details added Successfully";
                    String url = "/studentDonors.jsp";
                    errorString = "Amdission  "+ student.getAdmission() + "  already exists";
                    request.setAttribute("errorString", errorString);

                    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                    dispatcher.forward(request, response);

                } else {

                    db.addStudentDonor(student);

                    successString = "Donor  " + student.getLname() + " Details added Successfully";
                    String url = "/studentDonors.jsp";
                    request.setAttribute("successString", successString);

                    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
                    dispatcher.forward(request, response);
                }

            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(studentDonorServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            errorString = " Donor is ineligible for donation";
            String url = "/studentDonors.jsp";
            request.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
