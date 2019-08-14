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
public class allDonors {
    private String donorId;
    private String category;
    private String bloodgroup;
    private String bloodtype;
    private String date_of_donation;
    private String eligibility;
    public String gender;
    private String lname;
    private String fname;
    private String date_last_donated;

    public allDonors(String donorId, String category, String bloodgroup, String bloodtype, String date_of_donation, String gender, String lname, String fname, String date_last_donated) {
        this.donorId = donorId;
        this.category = category;
        this.bloodgroup = bloodgroup;
        this.bloodtype = bloodtype;
        this.date_of_donation = date_of_donation;
        this.gender = gender;
        this.lname = lname;
        this.fname = fname;
        this.date_last_donated = date_last_donated;
    }

    public allDonors(String fname, String lname, String gender,String donorId, String category, String bloodgroup, String bloodtype,  String date_last_donated) {
        this.fname =fname;
        this.lname = lname;
        this.gender = gender;
        this.donorId = donorId;
        this.category = category;
        this.bloodgroup = bloodgroup;
        this.bloodtype = bloodtype;
      
        this.date_last_donated = date_last_donated;
    }

    public allDonors(String donorId, String date_of_donation, String eligibility) {
        this.donorId = donorId;
        this.date_of_donation = date_of_donation;
        this.eligibility = eligibility;
    }

    public allDonors(String donorId, String category, String bloodgroup, String bloodtype) {
        this.donorId = donorId;
        this.category = category;
        this.bloodgroup = bloodgroup;
        this.bloodtype = bloodtype;
    }

   
    

    public String getDonorId() {
        return donorId;
    }

    public void setDonorId(String donorId) {
        this.donorId = donorId;
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

    public String getDate_of_donation() {
        return date_of_donation;
    }

    public void setDate_of_donation(String date_of_donation) {
        this.date_of_donation = date_of_donation;
    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getDate_last_donated() {
        return date_last_donated;
    }

    public void setDate_last_donated(String date_last_donated) {
        this.date_last_donated = date_last_donated;
    }
    
}
