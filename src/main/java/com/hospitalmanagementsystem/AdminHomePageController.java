package com.hospitalmanagementsystem;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AdminHomePageController {

    // Buttons
    @FXML
    private Button logoutButtonId;

    @FXML
    private Button registerStaffsButton;

    @FXML
    private Button viewStaffsButton;

    @FXML
    private Button reportButton;

    // Methods handling the button actions
    @FXML
    private void handleLogoutButtonAction() {
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
    private void handleRegisterStaffsButtonAction() {
        // Code to handle registering staffs action
        try {
            Parent root = FXMLLoader.load(getClass().getResource("RegisterStaffs.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Register Staff");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleViewStaffsButtonAction(ActionEvent event) {
        // Code to handle viewing staffs action
    try {
        // Load the SearchPatientID.fxml content
        Parent searchStaffContent = FXMLLoader.load(getClass().getResource("SearchStaffID.fxml"));

        // Create a new scene with the loaded content
        Scene searchPatientScene = new Scene(searchStaffContent);

        // Create a new stage to display the search patient content
        Stage searchPatientStage = new Stage();
        searchPatientStage.setScene(searchPatientScene);

        
        searchPatientStage.initOwner(((Node) (event.getSource())).getScene().getWindow()); // Set the owner of the new window to the current window

        // Display the new stage
        searchPatientStage.show();

    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Error loading SearchPatientID.fxml");
        // Handle the exception (show an alert or log the error)
    }
    }

    @FXML
    private void handlereportButtonAction() {
        // Code to handle report & analytics action
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AdminReport.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Reports & Analytics");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Initialization method
    @FXML
    public void initialize() {
        // Initialization code (if needed)
    }
}
