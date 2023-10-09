package com.hospitalmanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
        // Code to handle logout action
        Stage stage = (Stage) logoutButtonId.getScene().getWindow();
        stage.close();
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
    private void handleViewStaffsButtonAction() {
        // Code to handle viewing staffs action
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ViewStaffs.fxml"));
            Stage stage = new Stage();
            stage.setTitle("View Staffs");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
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
