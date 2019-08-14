
import Controllers.smsServlet;
import Models.allDonors;
import com.africastalking.AfricasTalking;
import com.africastalking.SmsService;
import com.africastalking.sms.Recipient;
import dataAccessObjects.DBConnection;
import dataAccessObjects.DBUtils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author victor
 */
public class Test {

     public  void connect()
            throws ClassNotFoundException, SQLException {
        
        
    } 
     
 
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, ParseException{
        Connection  connection = null;
        
//mySms();
   SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yyyy");
                                //Date today = sdf.parse(sdf.format(new Date()));
LocalDate today = LocalDate.now();
System.out.println(today);
String [] number = null;
DBConnection db = new DBConnection();
number = db.donorsContacts();
System.out.println("YOUR PHONE NUMBERS ARE  " + number );
    }
    
      public static void mySms() {
        String username = "bloodbank";    // use 'sandbox' for development in the test environment
String apiKey = "2afa76c30b7f653c114c6ff642aed32142f326c76bd90a3cc4b86a283ff97b45";       // use your sandbox app API key for development in the test environment
AfricasTalking.initialize(username, apiKey);

// Initialize a service e.g. SMS
SmsService sms = AfricasTalking.getService(AfricasTalking.SERVICE_SMS);
//2afa76c30b7f653c114c6ff642aed32142f326c76bd90a3cc4b86a283ff97b45
// Use the service
String message = "how does it feel naweza kutusi na huwezi reply... Anyway ndo mjue sikulangi fees nikienda shule ebu kama umepata hii text unitumie mia moja kesho";
String [] number = {"+254713776565", "+254715974915", "+254728278744"};
List<Recipient> response;
         try {
             response = sms.send(message, number, true);
             System.out.println(response);
         } catch (IOException ex) {
             Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
         }

 
}
     

   }

    

