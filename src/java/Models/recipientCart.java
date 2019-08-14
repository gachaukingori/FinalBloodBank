/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author victor
 */
public class recipientCart  implements Serializable{
    private ArrayList cartItems;
    String bloodbag;
    String bloodtype;
    String bagId;

    public recipientCart() {
    }
    
    
    

    public recipientCart(String bloodbag, String bloodtype, String bagId) {
        this.bloodbag = bloodbag;
        this.bloodtype = bloodtype;
        this.bagId = bagId;
    }

    public String getBloodbag() {
        return bloodbag;
    }

    public void setBloodbag(String bloodbag) {
        this.bloodbag = bloodbag;
    }

    public String getBloodtype() {
        return bloodtype;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }

    public String getBagId() {
        return bagId;
    }

    public void setBagId(String bagId) {
        this.bagId = bagId;
    }
    
    
    public int getLineItemCount(){
        return cartItems.size();
        
    }
    public void deleteCartItem(int bagId){
        try{
           cartItems.remove(bagId);
           
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void addCartItem (int bagId, String bloodgroup, String bloodtype){
        cartItemBean cartitembean = new cartItemBean();
        cartitembean.setBagId(bagId);
        cartitembean.setBloodgroup(bloodgroup);
        cartitembean.setBloodtype(bloodtype);
        cartItems.add(cartitembean);
        
    }
    public void addCartItem(cartItemBean cartitembean){
        cartItems.add(cartitembean);
    }
    public ArrayList getCartItems(){
        return cartItems;
    }
}
 