package com.hospitalmanagementsystem;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ViewStaffsController {

       // Define the UI components from FXML
    @FXML
    private Button cancelButton;

    @FXML
    private TextArea StaffID;  
    
    private TextArea firstNameID;
    @FXML
    private TextArea lastNameID;
    @FXML
    private TextArea dobID;
    @FXML
    private TextArea genderID;
    @FXML
    private TextArea bloodGroupID;
    @FXML
    private TextArea departmentID;
    @FXML
    private TextArea phoneNumberID;
    @FXML
    private TextArea emailID;
    @FXML
    private TextArea addressID;

    // Methods handling the button actions
    @FXML
    private void cancelButtonAction() {
                            try {
        // Load the home page
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AdminHomePage.fxml"));
        Parent homePage = loader.load();

        // Get the current stage using any component (e.g., the cancel button)
        Stage stage = (Stage) cancelButton.getScene().getWindow();

        // Set the scene for the stage
        stage.setScene(new Scene(homePage));

        // Optionally, you can set the title for the stage if needed
        // stage.setTitle("Home Page");

        // Display the stage
        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
    }


    // Initialization method
    @FXML
    public void initialize() {
        // Initialization code if needed
        // Example: loading all patients' data into the table or set default states.
    }
}
