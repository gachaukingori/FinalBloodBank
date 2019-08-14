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
public class Records {
    private int totalDonors;
    
   private int femDonors;
   private int maleDonors;
   private int centralDononors;
   private int northDonors;
   private int westDonors;
   private int eastDonors;
   private int southDonors;
   private int rejectDonors;
   private int studentDonors;
   private  int femAdultDonors;
   private int maleAdultDonors;

    public Records() {
    }
   

    public Records(int femDonors, int maleDonors, int centralDononors, int northDonors, int westDonors, int eastDonors, int southDonors, int rejectDonors, int studentDonors) {
        this.femDonors = femDonors;
        
        this.maleDonors = maleDonors;
        this.centralDononors = centralDononors;
        this.northDonors = northDonors;
        this.westDonors = westDonors;
        this.eastDonors = eastDonors;
        this.southDonors = southDonors;
        this.rejectDonors = rejectDonors;
        this.studentDonors = studentDonors;
    }

    public Records(int totalDonors, int femDonors, int maleDonors, int femAdultDonors, int maleAdultDonors) {
        this.femDonors = femDonors;
        this.maleDonors = maleDonors;
        this.totalDonors = totalDonors;
        this.femAdultDonors= femAdultDonors;
        this.maleAdultDonors = maleAdultDonors;
        
        
    }
    

    public int getFemDonors() {
        return femDonors;
    }

    public void setFemDonors(int femDonors) {
        this.femDonors = femDonors;
    }

    public int getMaleDonors() {
        return maleDonors;
    }

    public void setMaleDonors(int maleDonors) {
        this.maleDonors = maleDonors;
    }

    public int getCentralDononors() {
        return centralDononors;
    }

    public void setCentralDononors(int centralDononors) {
        this.centralDononors = centralDononors;
    }

    public int getNorthDonors() {
        return northDonors;
    }

    public void setNorthDonors(int northDonors) {
        this.northDonors = northDonors;
    }

    public int getWestDonors() {
        return westDonors;
    }

    public void setWestDonors(int westDonors) {
        this.westDonors = westDonors;
    }

    public int getEastDonors() {
        return eastDonors;
    }

    public void setEastDonors(int eastDonors) {
        this.eastDonors = eastDonors;
    }

    public int getSouthDonors() {
        return southDonors;
    }

    public void setSouthDonors(int southDonors) {
        this.southDonors = southDonors;
    }

    public int getRejectDonors() {
        return rejectDonors;
    }

    public void setRejectDonors(int rejectDonors) {
        this.rejectDonors = rejectDonors;
    }

    public int getStudentDonors() {
        return studentDonors;
    }

    public void setStudentDonors(int studentDonors) {
        this.studentDonors = studentDonors;
    }

    public int getTotalDonors() {
        return totalDonors;
    }

    public void setTotalDonors(int totalDonors) {
        this.totalDonors = totalDonors;
    }

    public int getFemAdultDonors() {
        return femAdultDonors;
    }

    public void setFemAdultDonors(int femAdultDonors) {
        this.femAdultDonors = femAdultDonors;
    }

    public int getMaleAdultDonors() {
        return maleAdultDonors;
    }

    public void setMaleAdultDonors(int maleAdultDonors) {
        this.maleAdultDonors = maleAdultDonors;
    }
    
   
   
    
    
    
}
