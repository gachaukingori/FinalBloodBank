/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.bloodBag;
import Models.recipientCart;
import dataAccessObjects.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author victor
 */
@WebServlet(name = "cartServlet", urlPatterns = {"/cartServlet"})
public class cartServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String action1 = request.getParameter("pick");
        String url = null;
       
        
                    System.out.println(action);
        
        switch (action) {
            case "add":
                addToCart(request, response);
                //  String successString = "Donor's Details added Successfully";
                //request.setAttribute("successString", successString);
                //HttpSession session = request.getSession();
                url = "allBNegative.jsp";
                break;
            case "remove":
                removeFromCart(request, response);
                url = "cart.jsp";
                break;
                
                
                
                
                
            case "addABnegative":
                addToCart(request, response);
                url = "allABNegative.jsp";
                break;
            case "addABpositive":
                addToCart(request, response);
                url = "allABPositive.jsp";
                break;
            case "addAnegative":
                addToCart(request, response);
                url = "allANegative.jsp";
                break;
            case "addApositive":
                addToCart(request, response);
                url ="allAPositive.jsp";
                break;
            case "addBpositive":
                addToCart(request, response);
                url ="allBPositive.jsp";
                break;
            case "addOnegative":
                addToCart(request, response);
                url = "allONegative.jsp";
                break;
            case "addOpositive":
                addToCart(request,response);
                url = "allOPositive.jsp";
                break;
            default:
                break;
        }
       
           
            RequestDispatcher dispatcher = request.getRequestDispatcher(url);
            dispatcher.forward(request, response);
            System.out.println ("the url is" +url);

    }

    protected void addToCart(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        String bagId = request.getParameter("bagId");
        String bloodgroup = request.getParameter("bloodgroup");
        String bloodtype = request.getParameter("bloodtype");
        recipientCart recipientcart = new recipientCart();
        recipientcart.setBagId(bagId);
        recipientcart.setBloodbag(bloodgroup);
        recipientcart.setBloodtype(bloodtype);

        ArrayList<recipientCart> myCartList = (ArrayList) session.getAttribute("myCartList");

        if (myCartList == null) {
            myCartList = new ArrayList();
            myCartList.add(recipientcart);
        } else if (myCartList != null) {
            recipientCart result = myCartList.stream()
                    .filter(x -> bagId.equals(x.getBagId()))
                    .findAny()
                    .orElse(null);
            if (result == null) {
                myCartList.add(recipientcart);

            }

        }
        session.setAttribute("myCartList", myCartList);
        //session.removeAttribute("myCartList");
    }

    public void removeFromCart(HttpServletRequest request, HttpServletResponse response) {
        //String bagId = request.getParameter("bagId");
         String bloodgroup = request.getParameter("bloodgroup");
        String bloodtype = request.getParameter("bloodtype");
  recipientCart recipientcart = new recipientCart();
      //  recipientcart.setBagId(bagId);
       // recipientcart.setBloodbag(bloodgroup);
        //recipientcart.setBloodtype(bloodtype);
        HttpSession session = request.getSession();
       

       
        ArrayList myCartList = (ArrayList) session.getAttribute("myCartList");
       
        if(myCartList != null){
            int index = isExisting(request.getParameter("bagId"), myCartList);
                    if(index <0){
                        String  errorString = " The cart is empty, pick bags  <a href='blooddetails.jsp'> here </a> ";
            request.setAttribute("errorString", errorString);

                    }
                    else{
            myCartList.remove(index);
            session.setAttribute("myCartList", myCartList);
            System.out.println(recipientcart.getBagId());
        }
        }
        else{
            String  errorString = " The cart is empty, pick bags  <a href='blooddetails.jsp'> here </a> ";
            request.setAttribute("errorString", errorString);
        }
        
       /* for(recipientCart temp: myCartList){
            if(bagId.equals(temp.getBagId())){
                
     
                boolean x = myCartList.remove(temp);
                  System.out.println(x);
            }
        } */
          
    }
    private int isExisting(String bagId, ArrayList <recipientCart> myCartList){
        for(int i=0; i < myCartList.size(); i++){
            if(myCartList.get(i).getBagId().equalsIgnoreCase(bagId)){
              return i;  
            }
        }
        return 0;
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
