package com.hospitalmanagementsystem;

import java.sql.*;

/**
 * A utility class for establishing a connection to a MySQL database and creating the database if necessary.
 */
public class ConnectionClass {
    public Connection con;
    public Statement stm;

    /**
     * Constructs a ConnectionClass instance and establishes a connection to the MySQL server.
     */
    public ConnectionClass() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection to the MySQL server without specifying a database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?serverTimezone=UTC", "root", "password");
            stm = con.createStatement();

            // Check if the database 'hospital_db' exists
            ResultSet resultSet = stm.executeQuery("SHOW DATABASES LIKE 'hospital_db'");

            if (!resultSet.next()) {
                // If 'hospital_db' does not exist, create it
                stm.executeUpdate("CREATE DATABASE hospital_db");

                // Switch to 'hospital_db'
                con.setCatalog("hospital_db");
                stm = con.createStatement();
                
                // Create the patients table
                
                createPatientsTable();
                
                // Create the staffs table
                
                createStaffsTable();
                
                //Create the schedules table
                createSchedulesTable();

            } else {
                // If 'hospital_db' exists, switch to it
                con.setCatalog("hospital_db");
                stm = con.createStatement();
                
                // Check if the 'patients' table exists in 'hospital_db'
                ResultSet tableCheck = stm.executeQuery("SHOW TABLES LIKE 'patients'");
                if (!tableCheck.next()) {
                // Create the 'patients' table if it doesn't exist
                createPatientsTable();
                }
                
               // Check if the 'staffs' table exists in 'hospital_db'
               tableCheck = stm.executeQuery("SHOW TABLES LIKE 'staffs'");
               if (!tableCheck.next()) {
               // Create the 'staffs' table if it doesn't exist
               createStaffsTable();
                } 
               
               //Check if the 'schedules' table exists in 'hospital_db'
               tableCheck = stm.executeQuery("SHOW TABLES LIKE 'schedules'");
               if (!tableCheck.next()) {
               // Create the 'staffs' table if it doesn't exist
               createSchedulesTable();
                } 
            }
            
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * The main method to initialize a ConnectionClass instance.
     *
     * @param args The command-line arguments (not used in this context).
     */
    public static void main(String[] args) {
        new ConnectionClass();
    }
    
    private void createPatientsTable() throws SQLException {
    String createTableSQL = "CREATE TABLE patients ("
            + "patient_id VARCHAR(255) PRIMARY KEY,"
            + "first_name VARCHAR(255) NOT NULL,"
            + "last_name VARCHAR(255) NOT NULL,"
            + "date_of_birth DATE NOT NULL,"
            + "gender ENUM('Male', 'Female', 'Other') NOT NULL,"
            + "blood_group ENUM('A+', 'A-', 'B+', 'B-', 'AB+', 'AB-', 'O+', 'O-') NOT NULL,"
            + "department ENUM('Cardiology', 'Neurology', 'Orthopedics', 'Dermatology', 'Emergency') NOT NULL"
            + ")";
    stm.executeUpdate(createTableSQL);
    }
    
    private void createStaffsTable() throws SQLException {
    String createTableSQL = "CREATE TABLE staffs ("
            + "staff_id VARCHAR(255) PRIMARY KEY,"
            + "first_name VARCHAR(255) NOT NULL,"
            + "last_name VARCHAR(255) NOT NULL,"
            + "email VARCHAR(255),"
            + "phone_number VARCHAR(20),"
            + "address TEXT,"
            + "gender ENUM('Male', 'Female', 'Other') NOT NULL,"
            + "blood_group ENUM('A+', 'A-', 'B+', 'B-', 'O+', 'O-', 'AB+', 'AB-') NOT NULL,"
            + "department ENUM('Cardiology', 'Neurology', 'Administration', 'Radiology') NOT NULL,"
            + "date_of_birth DATE NOT NULL"
            + ")";
    stm.executeUpdate(createTableSQL);
    }
    
    private void createSchedulesTable() throws SQLException {
    String createTableSQL = "CREATE TABLE schedules ("
            + "schedule_id INT PRIMARY KEY AUTO_INCREMENT,"
            + "first_name VARCHAR(255) NOT NULL,"
            + "last_name VARCHAR(255) NOT NULL,"
            + "date DATE NOT NULL,"
            + "time VARCHAR(10) NOT NULL,"
            + "blood_group ENUM('A+', 'A-', 'B+', 'B-', 'AB+', 'AB-', 'O+', 'O-') NOT NULL,"
            + "department ENUM('Cardiology', 'Neurology', 'Orthopedics', 'Dermatology', 'Emergency') NOT NULL"
            + ")";
    stm.executeUpdate(createTableSQL);
}


}