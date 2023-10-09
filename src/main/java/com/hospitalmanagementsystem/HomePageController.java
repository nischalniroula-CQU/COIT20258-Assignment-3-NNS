package com.hospitalmanagementsystem;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HomePageController {

    @FXML
    private Button logoutButtonId;

    @FXML
    private Button registerPatientsButton;

    @FXML
    private Button scheduleAppointmentsButton;

    @FXML
    private Button viewPatientsButton;

    @FXML
    private Button billingsButton;

    @FXML
    private LineChart<String, Number> dashboardChart;

    @FXML
    private Label patientsCountLabel;

    // Initialize method if needed
    @FXML
    public void initialize() {
        // Initialization code here
    }

    @FXML
    private void handleLogoutButtonAction(ActionEvent event) {
        Stage stage = (Stage) logoutButtonId.getScene().getWindow();
        stage.close();
        System.out.println("Logout Button Pressed");
    }

    @FXML
    private void handleRegisterPatientsButtonAction(ActionEvent event) {
        
        
               try {
            // Load the Register.fxml content
            Parent registerContent = FXMLLoader.load(getClass().getResource("/com/hospitalmanagementsystem/Register.fxml"));
            
                   System.out.println("Register Page found");


            // Create a new scene with the loaded content
            Scene registerScene = new Scene(registerContent);

            // Display in a new window (Stage)
            Stage registerStage = new Stage();
            registerStage.setScene(registerScene);
            registerStage.show();

            //If you want to close the current window after opening the new one:
            ((Node) (event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading Register.fxml");
            // Handle the exception (show an alert or log the error)
        }
    }

    @FXML
    private void handleScheduleAppointmentsButtonAction(ActionEvent event) {
     try {
            // Load the Register.fxml content
            Parent registerContent = FXMLLoader.load(getClass().getResource("/com/hospitalmanagementsystem/ScheduleAppointments.fxml"));
            
                   System.out.println("Register Page found");


            // Create a new scene with the loaded content
            Scene registerScene = new Scene(registerContent);

            // Display in a new window (Stage)
            Stage registerStage = new Stage();
            registerStage.setScene(registerScene);
            registerStage.show();

            //If you want to close the current window after opening the new one:
            ((Node) (event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading Register.fxml");
            // Handle the exception (show an alert or log the error)
        }
    
    }

    @FXML
    private void handleViewPatientsButtonAction(ActionEvent event) {
             try {
            // Load the Register.fxml content
            Parent registerContent = FXMLLoader.load(getClass().getResource("/com/hospitalmanagementsystem/ViewPatients.fxml"));


            // Create a new scene with the loaded content
            Scene registerScene = new Scene(registerContent);

            // Display in a new window (Stage)
            Stage registerStage = new Stage();
            registerStage.setScene(registerScene);
            registerStage.show();

            //If you want to close the current window after opening the new one:
            ((Node) (event.getSource())).getScene().getWindow().hide();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading Register.fxml");
            // Handle the exception (show an alert or log the error)
        }
    }

    @FXML
    private void handleBillingsButtonAction(ActionEvent event) {
        System.out.println("Billing Button Pressed");
    }

    // Add more methods or logic as needed
}
