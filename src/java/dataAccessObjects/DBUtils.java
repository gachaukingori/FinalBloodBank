/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessObjects;

import Models.Users;
import Models.allDonors;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author victor
 */
public class DBUtils {
     Connection  connection;
     PreparedStatement preparedStatement ;
     ResultSet resultSet;
     public  void connect()
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
 
   public void disconnect() throws SQLException{
        connection = null;
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
        
   }
   public boolean addEligibilityStatus(allDonors donor) throws ClassNotFoundException, SQLException{
       connect();
       
       String bloodtype = null ;
       String bloodgroup = null;
       String sql3= "Select * from BLOODTYPE where donorID =?";
       preparedStatement = connection.prepareStatement(sql3);
       preparedStatement.setString(1, donor.getDonorId());
       resultSet = preparedStatement.executeQuery();
       while (resultSet.next()){
           bloodgroup = resultSet.getString(3);
           bloodtype = resultSet.getString(4);
       }
       
       String sql1 = "Select * from ELIGIBILITY  where donorID =?";
       preparedStatement = connection.prepareStatement(sql1);
       preparedStatement.setString(1, donor.getDonorId());
       resultSet = preparedStatement.executeQuery();
       if (resultSet.next()){
          String date_last_donated = resultSet.getString(3);
          String sql2 = "Update ELIGIBILITY set eligibilty = ?, date_of_donation=?, date_last_donated=?, bloodgroup=?, bloodtype=? where donorID = ?";
          preparedStatement = connection.prepareStatement(sql2);
          preparedStatement.setString(1,donor.getEligibility());
           preparedStatement.setString(2,donor.getDate_of_donation());
           preparedStatement.setString(3, date_last_donated);
           preparedStatement.setString(4, donor.getDonorId());
           preparedStatement.setString(5, bloodgroup);
           preparedStatement.setString(6, bloodtype);
       boolean rowUpdated = preparedStatement.executeUpdate()>0;
       disconnect();
       return rowUpdated;
       }
       else{
      
       String sql = "INSERT INTO  ELIGIBILITY values(?,?,?,?,?,?)";
       preparedStatement = connection.prepareStatement(sql);
       preparedStatement.setString(1, donor.getDonorId());
       preparedStatement.setString(2,donor.getEligibility());
       preparedStatement.setString(3,donor.getDate_of_donation());
       preparedStatement.setString(4, donor.getDate_of_donation());
         preparedStatement.setString(5, bloodgroup);
           preparedStatement.setString(6, bloodtype);
      boolean rowInserted = preparedStatement.executeUpdate() >0;
        
           DBConnection.disconnect();
return rowInserted;         
       }
   }
   public boolean validateDonorBloodDetilsAdded(String donorID) throws ClassNotFoundException, SQLException{
        connect();

       String sql = "select * from BLOODTYPE where donorID = ?";
       
       preparedStatement = connection.prepareStatement(sql);
       preparedStatement.setString(1, donorID);
       resultSet = preparedStatement.executeQuery();
       boolean exists;
       if(resultSet.next()){
          
           exists =true;
               disconnect();
           return exists;
       }
       else{
           exists = false;
               disconnect();
           return exists;
       
       }
   }
  public boolean changePassword(String username, String password) throws ClassNotFoundException, SQLException{
      connect();
      String sql = "update users set password = ? where username = ?";
     
      boolean updated;
         preparedStatement = connection.prepareStatement(sql);
           preparedStatement.setString(1, password);
             preparedStatement.setString(2, username);
           updated =  preparedStatement.executeUpdate() >0;
           disconnect();
           return updated;
  }

public List searchAllDonors(String search) throws ClassNotFoundException, SQLException{
         connect();
         List searchDonor = new ArrayList();
         String sql6 = "Select * from ALLDONORS where donorID = ?";
              preparedStatement = connection.prepareStatement(sql6);
        preparedStatement.setString(1, search);
        resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
           String fname = resultSet.getString(1);
           String lname = resultSet.getString(2);
            String gender = resultSet.getString(4);
            allDonors donor = new allDonors(fname, lname, gender); 
            
searchDonor.add(donor);
        }
         
return searchDonor;

}     

}

      

