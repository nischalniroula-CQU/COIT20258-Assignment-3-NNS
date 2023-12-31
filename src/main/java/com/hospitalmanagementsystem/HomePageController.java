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
    private Button viewAppointmentButton;


    @FXML
    private Label patientsCountLabel;

    // Initialize method if needed
    @FXML
    public void initialize() {
        // Initialization code here
    }

    @FXML
    private void handleLogoutButtonAction(ActionEvent event) {
                           try {
        // Load the login page
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Login Page.fxml"));
        Parent loginPage = loader.load();

        // Get the current stage using any component (e.g., the cancel button)
        Stage stage = (Stage) logoutButtonId.getScene().getWindow();

        // Set the scene for the stage
        stage.setScene(new Scene(loginPage));

 
        // Display the stage
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
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
    private void ViewAppointmentsButtonAction(ActionEvent event) {
        
        
               try {
            // Load the Register.fxml content
            Parent registerContent = FXMLLoader.load(getClass().getResource("/com/hospitalmanagementsystem/ViewAppointments.fxml"));
            
                   System.out.println("View Appointments Button Found");


            // Create a new scene with the loaded content
            Scene registerScene = new Scene(registerContent);

            // Display in a new window (Stage)
            Stage viewAppointmentsStage = new Stage();
            viewAppointmentsStage.setScene(registerScene);
            viewAppointmentsStage.show();

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
        // Load the SearchPatientID.fxml content
        Parent searchPatientContent = FXMLLoader.load(getClass().getResource("SearchPatientID.fxml"));

        // Create a new scene with the loaded content
        Scene searchPatientScene = new Scene(searchPatientContent);

        // Create a new stage to display the search patient content
        Stage searchPatientStage = new Stage();
        searchPatientStage.setScene(searchPatientScene);

        
        searchPatientStage.initOwner(((Node) (event.getSource())).getScene().getWindow()); // Set the owner of the new window to the current window

        // Display the new stage
        searchPatientStage.show();

    } catch (IOException e) {
        e.
                printStackTrace();
        System.out.println("Error loading SearchPatientID.fxml");
        // Handle the exception (show an alert or log the error)
    }
}

}
