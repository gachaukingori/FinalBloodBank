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
public class newDonor {
    private String fname;
     private String lname;
      private String idnumber;
       private String telephone;
       private String gender;
        private String subcounty;
         private int age;
         private String date_registered;

    public newDonor(String fname, String lname, String idnumber, String telephone, String gender, String subcounty, int age, String date_registered) {
        this.fname = fname;
        this.lname = lname;
        this.idnumber = idnumber;
        this.telephone = telephone;
        this.gender = gender;
        this.subcounty = subcounty;
        this.age = age;
        this.date_registered = date_registered;
    }

    public String getDate_registered() {
        return date_registered;
    }

    public void setDate_registered(String date_registered) {
        this.date_registered = date_registered;
    }
    
         

    public newDonor(String fname, String lname, String gender) {
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
    }

    public newDonor(String telephone) {
        this.telephone = telephone;
    }
         

    public newDonor(String fname, String lname, String idnumber, String telephone, String gender, String subcounty, int age) {
        this.fname = fname;
        this.lname = lname;
        this.idnumber = idnumber;
        this.telephone = telephone;
        this.gender = gender;
        this.subcounty = subcounty;
        this.age = age;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
       public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
        

    public String getSubcounty() {
        return subcounty;
    }

    public void setSubcounty(String subcounty) {
        this.subcounty = subcounty;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

  
}
