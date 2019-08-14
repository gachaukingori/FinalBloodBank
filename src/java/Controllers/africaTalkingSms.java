/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.africastalking.AfricasTalking;
import com.africastalking.SmsService;
import com.africastalking.sms.Recipient;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import static org.apache.tomcat.jni.User.username;

/**
 *
 * @author victor
 */
public class africaTalkingSms {
   
  public void mySms() {
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
             Logger.getLogger(africaTalkingSms.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
         }

 
}


   }



