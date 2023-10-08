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

                // Note: At this point, you can add code to create initial tables if desired.
                // For now, we'll just set up the database.

            } else {
                // If 'hospital_db' exists, switch to it
                con.setCatalog("hospital_db");
                stm = con.createStatement();
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
}
