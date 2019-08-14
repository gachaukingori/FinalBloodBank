/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author victor
 */
public class bloodBag {
    
    private int bagId;
   
    private String category;
    private String bloodgroup;
    private String bloodtype;
    private String status;
    private  String date_of_donation;
    private String recipient_date;
private String hospital;
    public bloodBag(int bagId,  String category, String bloodgroup, String bloodtype, String status, String date_of_donation) {
        this.bagId = bagId;
    
        this.category = category;
        this.bloodgroup = bloodgroup;
        this.bloodtype = bloodtype;
        this.status = status;
        this.date_of_donation = date_of_donation;
    }

    public bloodBag(int bagId, String bloodgroup, String bloodtype, String recipient_date) {
        this.bagId = bagId;
        this.bloodgroup = bloodgroup;
        this.bloodtype = bloodtype;
        this.recipient_date = recipient_date;
    }

    public bloodBag(int bagId, String bloodgroup, String bloodtype, String recipient_date, String hospital) {
        this.bagId = bagId;
        this.bloodgroup = bloodgroup;
        this.bloodtype = bloodtype;
        this.recipient_date = recipient_date;
        this.hospital = hospital;
    }
    

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
    

    public bloodBag(int bagId, String bloodgroup, String bloodtype) {
        this.bagId = bagId;
        this.bloodgroup = bloodgroup;
        this.bloodtype = bloodtype;
    }
    
    


    public int getBagId() {
        return bagId;
    }

    public void setBagId(int bagId) {
        this.bagId = bagId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getBloodtype() {
        return bloodtype;
    }

    public void setBloodtype(String bloodtype) {
        this.bloodtype = bloodtype;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate_of_donation() {
        return date_of_donation;
    }

    public void setDate_of_donation(String date_of_donation) {
        this.date_of_donation = date_of_donation;
    }

    public String getRecipient_date() {
        return recipient_date;
    }

    public void setRecipient_date(String recipient_date) {
        this.recipient_date = recipient_date;
    }
    
    
}
