/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessObjects;

import Models.Records;
import Models.allDonors;
import Models.bloodBag;
import Models.minorDonors;
import Models.newDonor;
import Models.studentDonors;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {

    Connection connection;
    PreparedStatement preparedStatement;

    public void connect()
            throws ClassNotFoundException, SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://localhost/BloodBank", "root", "gachau");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            // connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

        }

    }

    public static void disconnect() throws SQLException {
        Connection connection = null;
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
    private String username;
    private String idnumber;
    private String rank;
    // Connection connection=null;
    

    public boolean addUser(String username, String idnumber, String rank) throws ClassNotFoundException, SQLException {

        connect();

        String query = "Insert into users values(?,?,?,?)";
        boolean rowInserted;

        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, idnumber);
        preparedStatement.setString(3, idnumber);
        preparedStatement.setString(4, rank);
        rowInserted = preparedStatement.executeUpdate() > 0;

        DBConnection.disconnect();
        return rowInserted;
    }

    public boolean addNewDonor(newDonor donor) throws ClassNotFoundException, SQLException {
                connect();
                
                   String sql1 = "Select CURDATE()";
        preparedStatement = connection.prepareStatement(sql1);
       ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            donor.setDate_registered(resultSet.getString(1));
        }  
        String sql = "Insert into ADULTDONORS values(?,?,?,?,?,?,?,?)";

        
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, donor.getFname());
        preparedStatement.setString(2, donor.getLname());
        preparedStatement.setString(3, donor.getIdnumber());
        preparedStatement.setString(4, donor.getTelephone());
        preparedStatement.setString(5, donor.getGender());
        preparedStatement.setString(6, donor.getSubcounty());
        preparedStatement.setInt(7, donor.getAge());
        preparedStatement.setString(8, donor.getDate_registered());
        boolean rowInserted;

        rowInserted = preparedStatement.executeUpdate() > 0;

        disconnect();
        return rowInserted;
    }

    public boolean addMinorDonor(minorDonors minor) throws ClassNotFoundException, SQLException {

        String sql = "Insert into MINORDONORS values (?,?,?,?,?,?,?)";
        connect();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, minor.getFname());
        preparedStatement.setString(2, minor.getLname());
        preparedStatement.setString(3, minor.getIdnumber());
        preparedStatement.setString(4, minor.getTelephone());
        preparedStatement.setString(5, minor.getSubcounty());
        preparedStatement.setString(6, minor.getGender());
        preparedStatement.setInt(7, minor.getAge());
        boolean rowInserted = preparedStatement.executeUpdate() > 0;
        disconnect();
        return rowInserted;

    }

    public boolean addStudentDonor(studentDonors student) throws ClassNotFoundException, SQLException {
        connect();
                           String sql1 = "Select CURDATE()";
        preparedStatement = connection.prepareStatement(sql1);
       ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            student.setDate_registered(resultSet.getString(1));
        }
        String sql = "Insert into STUDENTDONORS values(?,?,?,?,?,?,?,?)";
        
        preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, student.getFname());
        preparedStatement.setString(2, student.getLname());
        preparedStatement.setString(3, student.getGender());
        preparedStatement.setString(4, student.getSchoolname());
        preparedStatement.setString(5, student.getAdmission());
        preparedStatement.setString(6, student.getLevel());
        preparedStatement.setInt(7, student.getAge());
        preparedStatement.setString(8, student.getDate_registered());
        boolean rowInserted = preparedStatement.executeUpdate() > 0;
        disconnect();
        return rowInserted;
    }

    public boolean validateStudentExist(String admission) throws ClassNotFoundException, SQLException {
        String sql = "select * from STUDENTDONORS where admission = ?";
        connect();
        boolean exist;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, admission);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            exist = true;
            return exist;
        } else {
            exist = false;
            return exist;
        }

    }

    public boolean validateAdultDonorExist(String idnumber) throws ClassNotFoundException, SQLException {
        String sql = "select * from ADULTDONORS where idnumber = ?";
        connect();
        boolean exist;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, idnumber);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) {
            exist = true;
            return exist;
        } else {
            exist = false;
            return exist;
        }
    }

    public boolean addBloodGroup(allDonors donor) throws ClassNotFoundException, SQLException {
        connect();
        String query = "select idnumber from ADULTDONORS where idnumber = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, donor.getDonorId());
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean exists;
        if (resultSet.next()) {
            donor.setFname(resultSet.getString(1));
            donor.setLname(resultSet.getString(2));
            donor.setGender(resultSet.getString(5));
        }

        String query1 = "Insert into ALLDONORS values(?,?,?,?,?,?,?,?,?) ";
        preparedStatement = connection.prepareStatement(query1);
        preparedStatement.setString(1, donor.getFname());
        preparedStatement.setString(2, donor.getLname());
        preparedStatement.setString(3, donor.getDonorId());
        preparedStatement.setString(4, donor.getGender());
        preparedStatement.setString(5, donor.getBloodgroup());
        preparedStatement.setString(6, donor.getBloodtype());
        preparedStatement.setString(7, donor.getDate_of_donation());
        preparedStatement.setString(8, donor.getDate_last_donated());

        preparedStatement.setString(9, donor.getCategory());
        boolean rowInserted;
        rowInserted = preparedStatement.executeUpdate() > 0;
        DBConnection.disconnect();
        return rowInserted;

    }

    public boolean validateAdultDonorExists(String donorID) throws ClassNotFoundException, SQLException {
        connect();
        String query = "select idnumber from ADULTDONORS where idnumber = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, donorID);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean exists;
        if (resultSet.next()) {
            exists = true;
            return exists;
        } else {
            exists = false;
            return exists;
        }
    }

    public boolean validateStudentDonorExists(String donorID) throws ClassNotFoundException, SQLException {
        connect();
        String query = "select admission from STUDENTDONORS where admission = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, donorID);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean exists;
        if (resultSet.next()) {

            exists = true;
            return exists;
        } else {
            exists = false;
            return exists;
        }
    }

    public boolean validateMinorDonorExists(String donorID) throws ClassNotFoundException, SQLException {
        connect();
        String query = "select guardianID from MINORDONORS where guardianID = ?";
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, donorID);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean exists;
        if (resultSet.next()) {

            exists = true;
            return exists;
        } else {
            exists = false;
            return exists;
        }

    }

    public void updateTotalBloodBags(int x, String y) throws ClassNotFoundException, SQLException {
        connect();

        String sql = "Update BLOODBAGS SET number_of_bags = ? where bloodgroup = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, x);
        preparedStatement.setString(2, y);
        preparedStatement.executeUpdate();

    }

    public int totalBloodBagPerGroup(String bloodgroup) throws ClassNotFoundException, SQLException {
        connect();
        String sql = "Select * from BLOODBAGS where bloodgroup = ?";
        int bags = 0;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, bloodgroup);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            bags = resultSet.getInt(2);

        }
        return bags;

    }

    public void expiredBlood(String bloodgroup, String bloodtype) throws ClassNotFoundException, SQLException {
        connect();
        String bagID;
        String sql = "select bagID, bloodgroup,bloodtype,DATEDIFF(CURDATE(),date_of_donation) from bloodbags where DATEDIFF(CURDATE(),date_of_donation)>45 and bloodgroup =? and bloodtype =?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, bloodgroup);
        preparedStatement.setString(2, bloodtype);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            bagID = resultSet.getString(1);
            bloodgroup = resultSet.getString(2);
            bloodtype = resultSet.getString(3);
            String sql2 = "Insert into EXPIREDBLOOD values (?,?,?)";
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setString(1, bagID);
            preparedStatement.setString(2, bloodgroup);
            preparedStatement.setString(3, bloodtype);
            preparedStatement.executeUpdate();

            String sql3 = "Delete from bloodbags where bagID = ? ";

            preparedStatement = connection.prepareStatement(sql3);
            preparedStatement.setString(1, bagID);
            preparedStatement.executeUpdate();

        }
    }

    public int numberOfExpiredBags(String bloodgroup, String bloodtype) throws ClassNotFoundException, SQLException {
        connect();
        int bags = 0;
        String sql = "Select COUNT(donorID) as totalbags from EXPIREDBLOOD where bloodgroup =? and bloodtype=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, bloodgroup);
        preparedStatement.setString(2, bloodtype);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            bags = resultSet.getInt(1);

        }
        return bags;

    }
    //new approach

    public boolean addNewBloodBag(bloodBag bag) throws ClassNotFoundException, SQLException {
        connect();
        //String donorId = "";
        String sql = "insert into bloodbags values(?,?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, bag.getBagId());
        preparedStatement.setString(2, bag.getCategory());
        preparedStatement.setString(3, bag.getBloodgroup());
        preparedStatement.setString(4, bag.getBloodtype());
        preparedStatement.setString(5, bag.getStatus());
        preparedStatement.setString(6, bag.getDate_of_donation());

        boolean rowInserted;
        rowInserted = preparedStatement.executeUpdate() > 0;
        disconnect();
        return rowInserted;
    }

    public boolean checkIfBagRecorded(int bagID) throws ClassNotFoundException, SQLException {
        connect();
        String sql = " Select * from bloodbags where bagID = ?";
        boolean bagExists;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, bagID);

        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            bagExists = true;
            return bagExists;
        } else {
            bagExists = false;
            return bagExists;
        }

    }

    public void updateTheDonorsBloodGroupAndDateOfDonation(allDonors donor) throws ClassNotFoundException, SQLException {
        connect();
        String sql = "Insert Into ALLDONORS values(?,?,?,?,?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, donor.getFname());
        preparedStatement.setString(2, donor.getLname());
        preparedStatement.setString(3, donor.getDonorId());
        preparedStatement.setString(4, donor.getGender());
        preparedStatement.setString(5, donor.getBloodgroup());
        preparedStatement.setString(6, donor.getBloodtype());
        preparedStatement.setString(7, donor.getDate_of_donation());
        preparedStatement.setString(8, donor.getDate_of_donation());
        preparedStatement.setString(9, donor.getCategory());
        preparedStatement.executeUpdate();

    }

    public boolean checksIfStudentDonorPreviouslyDonated(String donorId) throws ClassNotFoundException, SQLException {
        connect();
        String sql = " Select * from STUDENTDONORS where admission = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, donorId);
        boolean exists;
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            exists = true;
            return exists;
        } else {
            exists = false;
            return exists;
        }

    }

    public boolean checkIfAdultDonorPreviouslyDonated(String donorId) throws ClassNotFoundException, SQLException {
        connect();
        String sql = "Select * from ADULTDONORS where idnumber =?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, donorId);
        boolean exists;
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            exists = true;
            return exists;
        } else {
            exists = false;
            return exists;
        }
    }

    public void addAdultDonorsBloodDetails(String category, String donorId, String fname, String lname, String gender, String date_of_donation, String bloodgroup, String bloodtype) throws ClassNotFoundException, SQLException {
        connect();
        boolean x = checkIfAdultDonorPreviouslyDonated(donorId);

        String sql = "Select * from ADULTDONORS where idnumber =?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, donorId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            fname = resultSet.getString(1);
            lname = resultSet.getString(2);
            gender = resultSet.getString(3);
            String sql2 = "Insert into ALLDONORS values(?,?,?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setString(1, fname);
            preparedStatement.setString(2, lname);
            preparedStatement.setString(3, donorId);
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, bloodgroup);
            preparedStatement.setString(6, bloodtype);
            preparedStatement.setString(7, date_of_donation);
            preparedStatement.setString(8, date_of_donation);
            preparedStatement.setString(9, category);
            preparedStatement.executeUpdate();

        }
    }

    public void addStudentDonorBloodDetails(String category, String donorId, String fname, String lname, String gender, String date_of_donation, String bloodgroup, String bloodtype) throws ClassNotFoundException, SQLException {
        connect();
        //boolean x = checksIfStudentDonorPreviouslyDonated(donorId);

        String sql = "Select * from STUDENTDONORS where admission =?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, donorId);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            fname = resultSet.getString(1);
            lname = resultSet.getString(2);
            gender = resultSet.getString(3);
            String sql2 = "Insert into ALLDONORS values(?,?,?,?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setString(1, fname);
            preparedStatement.setString(2, lname);
            preparedStatement.setString(3, donorId);
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, bloodgroup);
            preparedStatement.setString(6, bloodtype);
            preparedStatement.setString(7, date_of_donation);
            preparedStatement.setString(8, date_of_donation);
            preparedStatement.setString(9, category);
            preparedStatement.executeUpdate();

        }

    }

    public boolean confirmBagExistsForRecipient(int bagId) throws ClassNotFoundException, SQLException {
        connect();
        String sql = "Select * from bloodbags where bagID = ? ";
        boolean exists;
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, bagId);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            exists = true;
            disconnect();
            return exists;

        } else {
            exists = false;
            disconnect();
            return exists;
        }
    }

    public boolean updateBloodBagsAfterBagIsTaken(int bagId, String bloodgroup, String bloodtype, String recipient_date, String hospital) throws ClassNotFoundException, SQLException {
        connect();
        ResultSet resultSet;
        boolean success = false;

        bloodBag bag = new bloodBag(bagId, bloodgroup, bloodtype, recipient_date,hospital);
        String sql1 = "Select CURDATE()";
        preparedStatement = connection.prepareStatement(sql1);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            bag.setRecipient_date(resultSet.getString(1));
        }
        String sql = "Select * from bloodbags where bagID = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, bagId);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            bag.setBagId(bagId);
            bag.setBloodgroup(resultSet.getString(3));
            bag.setBloodtype(resultSet.getString(4));

            String sql2 = " Insert into recipients values (?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.setInt(1, bag.getBagId());
            preparedStatement.setString(2, bag.getBloodgroup());
            preparedStatement.setString(3, bag.getBloodtype());
            preparedStatement.setString(4, bag.getRecipient_date());
            preparedStatement.setString(5, bag.getHospital());
            preparedStatement.executeUpdate();

            String sql3 = "delete from bloodbags where bagID = ?";
            preparedStatement = connection.prepareStatement(sql3);
            preparedStatement.setInt(1, bagId);
          success =  preparedStatement.executeUpdate()>0;
          success = true;

        }
        return success;

    }

    public boolean checkIfRegisteredDonorHadPreviouslyDonated(String donorId) throws ClassNotFoundException, SQLException {
        connect();
        boolean exists;
        String date_last_donated ;
        String sql = "Select * from ALLDONORS where donorID = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, donorId);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        
        if (resultSet.next()) {
            date_last_donated = resultSet.getString(7);
            String sql2 = "update ALLDONORS set date_last_donated = ? where donorID =?" ;
             preparedStatement = connection.prepareStatement(sql2);
        preparedStatement.setString(1,date_last_donated );
        preparedStatement.setString(2, donorId);
            preparedStatement.executeUpdate();
            exists = true;
            disconnect();
            return exists;
        } else {
            exists = false;
            disconnect();
            return exists;

        }
    }

    public void addAllDonorsRecord(allDonors donor) throws ClassNotFoundException, SQLException {
        connect();
        String sql = "Insert Into ALLDONORS values(?,?,?,?,?,?,?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, donor.getFname());
        preparedStatement.setString(2, donor.getLname());
        preparedStatement.setString(3, donor.getDonorId());
        preparedStatement.setString(4, donor.getGender());
        preparedStatement.setString(5, donor.getBloodgroup());
        preparedStatement.setString(6, donor.getBloodtype());
        preparedStatement.setString(7, donor.getDate_of_donation());
        preparedStatement.setString(8, donor.getDate_of_donation());
        preparedStatement.setString(9, donor.getCategory());
        preparedStatement.executeUpdate();
    }

    public void updateTheDateOfDonationAndBloodGroup(allDonors donor) throws ClassNotFoundException, SQLException {
        connect();
        String fname , lname , gender , bloodgroup,bloodtype;
        boolean x = checkIfRegisteredDonorHadPreviouslyDonated(donor.getDonorId());
        if (x == true) {
            String sql = "Select * from ALLDONORS where donorID = ?";
            
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, donor.getDonorId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                fname = resultSet.getString(1);
                lname = resultSet.getString(2);
                gender = resultSet.getString(4);
                bloodgroup = resultSet.getString(5);
                bloodtype = resultSet.getString(6);
                donor.setFname(fname);
                    donor.setLname(lname);
                    donor.setGender(gender);
                    donor.setBloodgroup(bloodgroup);
                    donor.setBloodtype(bloodtype);
                    addAllDonorsRecord(donor);
                
            }
            
          
        } else if(x ==false){
            if ("student".equals(donor.getCategory())) {
                               
                String sql1 = "Select * from STUDENTDONORS where admission = ?";
                preparedStatement = connection.prepareStatement(sql1);
                preparedStatement.setString(1, donor.getDonorId());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    fname = resultSet.getString(1);
                    lname = resultSet.getString(2);
                    gender = resultSet.getString(3);

                    donor.setFname(fname);
                    donor.setLname(lname);
                    donor.setGender(gender);
                    addAllDonorsRecord(donor);

                }
            } else {
                 
                
                String sql1 = "Select * from ADULTDONORS where idnumber = ?";
                preparedStatement = connection.prepareStatement(sql1);
                preparedStatement.setString(1, donor.getDonorId());
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    fname = resultSet.getString(1);
                    lname = resultSet.getString(2);
                    gender = resultSet.getString(5);
                    donor.setFname(fname);
                    donor.setLname(lname);
                    donor.setGender(gender);

                    addAllDonorsRecord(donor);
                }
            }

        }

    }
    public void thirtyDaysRecord(Records record ) throws ClassNotFoundException, SQLException{
        connect();
        ResultSet resultSet;
        //total female donors in One Month
        String sql = "select count(gender) as totalDonors from ADULTDONORS where gender ='female' and month(now())";
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            record.setFemDonors(resultSet.getInt(1));
        }
        //Total male donors in One Month
        String sql2 = "select count(gender) as totalmales from ADULTDONORS where gender ='male' and month(now())";
        preparedStatement = connection.prepareStatement(sql2);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            record.setMaleDonors(resultSet.getInt(1));
        
            
    }
    // Total Donors
    String sql3 ="select count(gender) as totalmales from ADULTDONORS where  month(now())";
    preparedStatement = connection.prepareStatement(sql3);
    resultSet = preparedStatement.executeQuery();
    while(resultSet.next()){
        record.setTotalDonors(resultSet.getInt(1));
    }
   String sql4 ="select count(gender) as totalmales from ADULTDONORS where gender ='male' and month(now())";
    preparedStatement = connection.prepareStatement(sql4);
    resultSet = preparedStatement.executeQuery();
    while(resultSet.next()){
        record.setMaleAdultDonors(resultSet.getInt(1));
        
    }
    String sql5 ="select count(gender) as totalmales from ADULTDONORS where gender ='female' and month(now())";
    preparedStatement = connection.prepareStatement(sql5);
    resultSet = preparedStatement.executeQuery();
    while(resultSet.next()){
        record.setFemAdultDonors(resultSet.getInt(1));
      
    }
   
}
    public String[] donorsContacts() throws ClassNotFoundException, SQLException{
        connect();
        ArrayList  numberList = new ArrayList();
        int total = 0;
        ResultSet resultSet;
        String sql1 = "Select COUNT(telephone) from ADULTDONORS";
        preparedStatement = connection.prepareStatement(sql1);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            total = resultSet.getInt(1);
            
        }
        
        
        String [] numberArray = new String [total];
        String telephone = "";
        newDonor donor = new newDonor(telephone);
        String sql = " Select telephone from ADULTDONORS";
        preparedStatement = connection.prepareStatement(sql);
        resultSet =  preparedStatement.executeQuery();
       while(resultSet.next()){
           numberList.add(resultSet.getString(1));
           
           
       }
          //numberList.add(donor);
          numberArray = (String[]) numberList.toArray(numberArray);
          return numberArray;
        
    }
    public String[] eastDonorsContact() throws ClassNotFoundException, SQLException{
        connect();
          ArrayList  numberList = new ArrayList();
        int total = 0;
        ResultSet resultSet;
        String sql1 = "Select COUNT(telephone) from ADULTDONORS where subcounty ='EAST' ";
        preparedStatement = connection.prepareStatement(sql1);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            total = resultSet.getInt(1);
            
        }
        
        
        String [] numberArray = new String [total];
        String telephone = "";
        newDonor donor = new newDonor(telephone);
        String sql = " Select telephone from ADULTDONORS where subcounty = 'EAST' ";
        preparedStatement = connection.prepareStatement(sql);
        resultSet =  preparedStatement.executeQuery();
       while(resultSet.next()){
           numberList.add(resultSet.getString(1));
           
           
       }
          //numberList.add(donor);
          numberArray = (String[]) numberList.toArray(numberArray);
          return numberArray;
        
    }
      public String[] westDonorsContact() throws ClassNotFoundException, SQLException{
        connect();
          ArrayList  numberList = new ArrayList();
        int total = 0;
        ResultSet resultSet;
        String sql1 = "Select COUNT(telephone) from ADULTDONORS where subcounty ='WEST' ";
        preparedStatement = connection.prepareStatement(sql1);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            total = resultSet.getInt(1);
            
        }
        
        
        String [] numberArray = new String [total];
        String telephone = "";
        newDonor donor = new newDonor(telephone);
        String sql = " Select telephone from ADULTDONORS where subcounty = 'WEST' ";
        preparedStatement = connection.prepareStatement(sql);
        resultSet =  preparedStatement.executeQuery();
       while(resultSet.next()){
           numberList.add(resultSet.getString(1));
           
           
       }
          //numberList.add(donor);
          numberArray = (String[]) numberList.toArray(numberArray);
          return numberArray;
        
    }
      public String[] centralDonorsContact() throws ClassNotFoundException, SQLException{
        connect();
          ArrayList  numberList = new ArrayList();
        int total = 0;
        ResultSet resultSet;
        String sql1 = "Select COUNT(telephone) from ADULTDONORS where subcounty ='CENTRAL' ";
        preparedStatement = connection.prepareStatement(sql1);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            total = resultSet.getInt(1);
            
        }
        
        
        String [] numberArray = new String [total];
        String telephone = "";
        newDonor donor = new newDonor(telephone);
        String sql = " Select telephone from ADULTDONORS where subcounty = 'CENTRAL' ";
        preparedStatement = connection.prepareStatement(sql);
        resultSet =  preparedStatement.executeQuery();
       while(resultSet.next()){
           numberList.add(resultSet.getString(1));
           
           
       }
          //numberList.add(donor);
          numberArray = (String[]) numberList.toArray(numberArray);
          return numberArray;
        
    }
        public String[] northDonorsContact() throws ClassNotFoundException, SQLException{
        connect();
          ArrayList  numberList = new ArrayList();
        int total = 0;
        ResultSet resultSet;
        String sql1 = "Select COUNT(telephone) from ADULTDONORS where subcounty ='NORTH' ";
        preparedStatement = connection.prepareStatement(sql1);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            total = resultSet.getInt(1);
            
        }
        
        
        String [] numberArray = new String [total];
        String telephone = "";
        newDonor donor = new newDonor(telephone);
        String sql = " Select telephone from ADULTDONORS where subcounty = 'NORTH' ";
        preparedStatement = connection.prepareStatement(sql);
        resultSet =  preparedStatement.executeQuery();
       while(resultSet.next()){
           numberList.add(resultSet.getString(1));
           
           
       }
          //numberList.add(donor);
          numberArray = (String[]) numberList.toArray(numberArray);
          return numberArray;
        
    }
          public String[] southDonorsContact() throws ClassNotFoundException, SQLException{
        connect();
          ArrayList  numberList = new ArrayList();
        int total = 0;
        ResultSet resultSet;
        String sql1 = "Select COUNT(telephone) from ADULTDONORS where subcounty ='SOUTH' ";
        preparedStatement = connection.prepareStatement(sql1);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            total = resultSet.getInt(1);
            
        }
        
        
        String [] numberArray = new String [total];
        String telephone = "";
        newDonor donor = new newDonor(telephone);
        String sql = " Select telephone from ADULTDONORS where subcounty = 'SOUTH' ";
        preparedStatement = connection.prepareStatement(sql);
        resultSet =  preparedStatement.executeQuery();
       while(resultSet.next()){
           numberList.add(resultSet.getString(1));
           
           
       }
          //numberList.add(donor);
          numberArray = (String[]) numberList.toArray(numberArray);
          return numberArray;
        
    }
          public ArrayList eastSubcountyHospital() throws ClassNotFoundException, SQLException{
              connect();
              ArrayList EastList = new ArrayList();
              String sql = "Select * from recipients where hospital = 'East Sub-county Hospital'";
              preparedStatement = connection.prepareStatement(sql);
              ResultSet resultSet = preparedStatement.executeQuery();
              while(resultSet.next()){
                  EastList.add(resultSet.getInt(1));
                  EastList.add(resultSet.getString(2));
                  EastList.add(resultSet.getString(3));
                  EastList.add(resultSet.getString(4));
              }
              return EastList;
          }
          public ArrayList centralSubcountyHospital() throws SQLException, ClassNotFoundException{
              connect();
              ArrayList CentralList = new ArrayList();
              String sql = "Select * from recipients where hospital='Central Sub-county Hospital'";
              preparedStatement = connection.prepareStatement(sql);
              ResultSet resultSet = preparedStatement.executeQuery();
              while (resultSet.next()){
                  CentralList.add(resultSet.getInt(1));
                    CentralList.add(resultSet.getString(2));
                  CentralList.add(resultSet.getString(3));
                 CentralList.add(resultSet.getString(4));
              }
              return  CentralList;
          }
    public ArrayList southSubcountyHospital() throws ClassNotFoundException, SQLException{
        connect();
        String sql = "Select * from recipients where hospital = 'South Sub-County Hospital'";
        preparedStatement = connection.prepareStatement(sql);
        ArrayList SouthList = new ArrayList();
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
           SouthList.add(resultSet.getInt(1));
            SouthList.add(resultSet.getString(2));
            SouthList.add(resultSet.getString(3));
            SouthList.add(resultSet.getString(4));
            
        }
        return SouthList;
    }
    public ArrayList westSubcountyHospital() throws ClassNotFoundException, SQLException{
        connect();
        String sql = "Select * from recipients where hospital = 'West Sub-County Hospital'";
        preparedStatement = connection.prepareStatement(sql);
       ArrayList WestList = new ArrayList();
       ResultSet resultSet = preparedStatement.executeQuery();
       while(resultSet.next()){
           WestList.add(resultSet.getInt(1));
           WestList.add(resultSet.getString(2));
           WestList.add(resultSet.getString(3));
           WestList.add(resultSet.getString(4));
           
       }
        return WestList;
    }
    public ArrayList northSubcountyHospital() throws ClassNotFoundException, SQLException{
        connect();
        String sql = "Select * from recipients where hospital = 'North Sub-County Hospital'";
        ArrayList NorthList = new ArrayList();
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            NorthList.add(resultSet.getInt(1));
            NorthList.add(resultSet.getString(2));
            NorthList.add(resultSet.getString(3));
            NorthList.add(resultSet.getString(4));
        }
        return NorthList;
    }
    public ArrayList adultDonorList(String view) throws ClassNotFoundException, SQLException{
        String sql = "Select * from ADULTDONORS where subcounty =? or gender =? and month(now()) ";
        connect();
        ArrayList list = new ArrayList();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, view);
        preparedStatement.setString(2, view);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            list.add(resultSet.getString(1));
            list.add(resultSet.getString(2));
            list.add(resultSet.getString(3));
            list.add(resultSet.getString(4));
            list.add(resultSet.getString(5));
            list.add(resultSet.getString(6));
            list.add(resultSet.getString(8));
        }
        return list;
            
    }
    public ArrayList mayAdultDonorList(String view) throws ClassNotFoundException, SQLException{
         String sql = "Select * from ADULTDONORS where !month(now()) and subcounty = ? and gender =? ";
        connect();
        ArrayList list = new ArrayList();
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, view);
        preparedStatement.setString(2, view);
        
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            list.add(resultSet.getString(1));
            list.add(resultSet.getString(2));
            list.add(resultSet.getString(3));
            list.add(resultSet.getString(4));
            list.add(resultSet.getString(5));
            list.add(resultSet.getString(6));
            list.add(resultSet.getString(8));
        }
        return list;

    }
    public ArrayList studentDonorList(String view) throws ClassNotFoundException, SQLException{
        connect();
        ArrayList student = new ArrayList();
        String sql = "Select * from STUDENTDONORS where gender=? and month(now())";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, view);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            student.add(resultSet.getString(1));
            student.add(resultSet.getString(2));
            student.add(resultSet.getString(3));
            student.add(resultSet.getString(4));
            student.add(resultSet.getString(5));
            student.add(resultSet.getString(6));
            student.add(resultSet.getString(8));
        }
        return student;
    }
    public ArrayList mayStudents(String view) throws ClassNotFoundException, SQLException{
        connect();
           ArrayList student = new ArrayList();
        String sql = "Select * from STUDENTDONORS where gender=? and !month(now())";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, view);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            student.add(resultSet.getString(1));
            student.add(resultSet.getString(2));
            student.add(resultSet.getString(3));
            student.add(resultSet.getString(4));
            student.add(resultSet.getString(5));
            student.add(resultSet.getString(6));
            student.add(resultSet.getString(8));
        }
        return student;
    }
    public ArrayList bagsList (String bloodgroup, String bloodtype1) throws ClassNotFoundException, SQLException{
        connect();
        ArrayList bag = new ArrayList();
        String sql = "Select * from ALLDONORS where bloodgroup =? and bloodtype=? and month(now())";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, bloodgroup);
        preparedStatement.setString(2, bloodtype1);
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            bag.add(resultSet.getString(1));
            bag.add(resultSet.getString(2));
            bag.add(resultSet.getString(3));
            bag.add(resultSet.getString(4));
            bag.add(resultSet.getString(5));
            bag.add(resultSet.getString(6));
            bag.add(resultSet.getString(7));
            bag.add(resultSet.getString(9));
            
        }
        return bag;
    }
    public ArrayList mayBags(String bloodgroup, String bloodtype) throws ClassNotFoundException, SQLException{
        connect();
        
                String sql = "Select * from ALLDONORS where bloodgroup =? and bloodtype=? and !month(now())";
                 ArrayList bag = new ArrayList();
                 preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, bloodgroup);
        preparedStatement.setString(2, bloodtype);
        ResultSet resultSet = preparedStatement.executeQuery();
          while(resultSet.next()){
            bag.add(resultSet.getString(1));
            bag.add(resultSet.getString(2));
            bag.add(resultSet.getString(3));
            bag.add(resultSet.getString(4));
            bag.add(resultSet.getString(5));
            bag.add(resultSet.getString(6));
            bag.add(resultSet.getString(7));
            bag.add(resultSet.getString(9));
            
        }
        return bag;
    }
    public ArrayList bagSearch(String search) throws ClassNotFoundException, SQLException{
        connect();
        ArrayList bag = new ArrayList();
        String sql = "Select * from bloodbags where bagID = ? or category = ? or bloodgroup =?  or bloodtype=? or bloodstatus = ? or date_of_donation =? ";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, search);
         preparedStatement.setString(2, search);
          preparedStatement.setString(3, search);
           preparedStatement.setString(4, search);
            preparedStatement.setString(5, search);
             preparedStatement.setString(6, search);
             ResultSet resultSet = preparedStatement.executeQuery();
             while (resultSet.next()){
                  bag.add(resultSet.getString(1));
            bag.add(resultSet.getString(2));
            bag.add(resultSet.getString(3));
            bag.add(resultSet.getString(4));
            bag.add(resultSet.getString(5));
            bag.add(resultSet.getString(6));
             }
         return bag;
    
    }
    public boolean confirmUsernameDoesnotExist(String username, String idnumber) throws ClassNotFoundException, SQLException{
        connect();
        boolean exists ;
        String sql = "Select * from users where username = ? or idnumber=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, idnumber);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            exists = true;
                    return exists;
        }
        else
        {
            exists = false;
                     return exists;
        }

    }
    public boolean confirmUserToSuspend(String username) throws ClassNotFoundException, SQLException{
        connect();
        boolean exists;
        String sql = "Select * from users where username = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()){
            exists = true;
            return exists;
        }
        else{
            exists = false;
            return exists;
        }
        
    }
    public void suspendUser(String username) throws ClassNotFoundException, SQLException{
        connect();
        String sql = "update users set rank = 'suspended' where username=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.executeUpdate();
        
    }
    public void resetUser(String username) throws ClassNotFoundException, SQLException{
        connect();
        String sql = "update users set password = idnumber where username=?";
           preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, username);
        preparedStatement.executeUpdate();
    }
    public ArrayList studentFilter (String startdate, String enddate) throws ClassNotFoundException, SQLException{
        connect();
        ArrayList student = new ArrayList();
        String sql = "Select * from STUDENTDONORS where date_registered between ? and ? ";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, startdate);
        preparedStatement.setString(2, enddate);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            student.add(resultSet.getString(1));
            student.add(resultSet.getString(2));
            student.add(resultSet.getString(3));
            student.add(resultSet.getString(4));
            student.add(resultSet.getString(5));
            student.add(resultSet.getString(6));
            student.add(resultSet.getString(8));
        }
        return student;
        
    }
    public ArrayList adultFilter(String startdate, String enddate) throws ClassNotFoundException, SQLException{
        connect();
        ArrayList adult = new ArrayList();
        String sql = "Select * from ADULTDONORS where date_registered between ? and ?";
         preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, startdate);
        preparedStatement.setString(2, enddate);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            adult.add(resultSet.getString(1));
            adult.add(resultSet.getString(2));
            adult.add(resultSet.getString(3));
            adult.add(resultSet.getString(4));
            adult.add(resultSet.getString(5));
            adult.add(resultSet.getString(6));
            adult.add(resultSet.getString(8));
        }
        
        return adult;
    }
    public ArrayList donorsFilter(String startdate, String enddate) throws ClassNotFoundException, SQLException{
        connect();
        ArrayList donor = new ArrayList();
        String sql = "Select * from ALLDONORS where date_of_donation between ? and ?";
         preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, startdate);
        preparedStatement.setString(2, enddate);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            donor.add(resultSet.getString(1));
            donor.add(resultSet.getString(2));
            donor.add(resultSet.getString(3));
            donor.add(resultSet.getString(4));
            donor.add(resultSet.getString(5));
            donor.add(resultSet.getString(6));
            donor.add(resultSet.getString(7));
            donor.add(resultSet.getString(9));
        }
return donor;
    }
}