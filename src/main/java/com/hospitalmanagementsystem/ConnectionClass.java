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
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?serverTimezone=UTC", "root", "root");
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
            + "department ENUM('Cardiology', 'Neurology', 'Orthopedics', 'Dermatology', 'Emergency') NOT NULL,"
            + "height DOUBLE(5,2),"
            + "weight DECIMAL(4,2),"
            + "blood_pressure VARCHAR(7),"
            + "bmi DECIMAL(4,2)"
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
            + "gender VARCHAR(10) NOT NULL CHECK (gender IN ('Male', 'Female', 'Other')),"
            + "blood_group VARCHAR(10) NOT NULL CHECK (blood_group IN ('A+', 'A-', 'B+', 'B-', 'O+', 'O-', 'AB+', 'AB-')),"
            + "department VARCHAR(20) NOT NULL CHECK (department IN ('Cardiology', 'Neurology', 'Administration', 'Radiology')),"
            + "date_of_birth DATE NOT NULL,"
            + "password VARCHAR(255),"
            + "username VARCHAR(255),"
            + "role VARCHAR(20) NOT NULL CHECK (role IN ('Admin', 'Staff'))"
            + ")";
    
    stm.executeUpdate(createTableSQL);

    // Inserting the sample data
    String insertSampleDataSQL = "INSERT INTO staffs (staff_id, first_name, last_name, username, password, role, gender, blood_group, department, date_of_birth) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    PreparedStatement preparedStatement = stm.getConnection().prepareStatement(insertSampleDataSQL);
    
    preparedStatement.setString(1, "ADM001"); // Sample staff_id for the admin. You can change it as needed.
    preparedStatement.setString(2, "Admin"); // Sample first name for the admin
    preparedStatement.setString(3, "Admin"); // Sample last name for the admin
    preparedStatement.setString(4, "admin"); // username
    preparedStatement.setString(5, "adminpassword"); // password
    preparedStatement.setString(6, "Admin"); // role
    preparedStatement.setString(7, "Male"); // gender
    preparedStatement.setString(8, "O+"); // blood group
    preparedStatement.setString(9, "Administration"); // department
    preparedStatement.setDate(10, java.sql.Date.valueOf("2000-01-01")); // Sample date of birth for the admin

    preparedStatement.executeUpdate();
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