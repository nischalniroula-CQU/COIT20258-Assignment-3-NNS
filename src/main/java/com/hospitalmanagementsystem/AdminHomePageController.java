package com.hospitalmanagementsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
        // Code to handle logout action
        System.out.println("Logged out.");
    }

    @FXML
    private void handleRegisterStaffsButtonAction() {
        // Code to handle registering staffs action
        System.out.println("Register staffs clicked.");
    }

    @FXML
    private void handleViewStaffsButtonAction() {
        // Code to handle viewing staffs action
        System.out.println("View staffs clicked.");
    }

    @FXML
    private void handlereportButtonAction() {
        // Code to handle report & analytics action
        System.out.println("Report & Analytics clicked.");
    }

    // Initialization method
    @FXML
    public void initialize() {
        // Initialization code (if needed)
    }
}
