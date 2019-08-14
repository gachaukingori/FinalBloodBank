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
public class studentDonors {
    private String fname;
    private String lname;
    private String gender;
    private String schoolname;
    private String admission;
    private String level;
    private int age;
    private String date_registered;

    public studentDonors(String fname, String lname, String gender, String schoolname, String admission, String level, int age, String date_registered) {
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.schoolname = schoolname;
        this.admission = admission;
        this.level = level;
        this.age = age;
        this.date_registered = date_registered;
    }

    public String getDate_registered() {
        return date_registered;
    }

    public void setDate_registered(String date_registered) {
        this.date_registered = date_registered;
    }
    

    public studentDonors(String fname, String lname, String gender) {
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
    }

    public studentDonors(String fname, String lname, String gender, String schoolname, String admission, String level, int age) {
        this.fname = fname;
        this.lname = lname;
        this.gender = gender;
        this.schoolname = schoolname;
        this.admission = admission;
        this.level = level;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getAdmission() {
        return admission;
    }

    public void setAdmission(String admission) {
        this.admission = admission;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    
}
