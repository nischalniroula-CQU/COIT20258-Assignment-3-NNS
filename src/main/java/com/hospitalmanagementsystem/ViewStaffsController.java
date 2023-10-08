package com.hospitalmanagementsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ViewStaffsController {

    // TextFields
    @FXML
    private TextField searchID;

    // TableView
    @FXML
    private TableView<?> patientsTable; // Replace the wildcard with a specific type if needed

    // Buttons
    @FXML
    private Button cancelButton;
    @FXML
    private Button searchButton;

    // Methods handling the button actions
    @FXML
    private void cancelButtonAction() {
        // Code to handle the "Go to home" action
        System.out.println("Go to home clicked.");
        // Implement the logic to navigate to the home page, possibly using a scene change.
    }

    @FXML
    private void searchButtonAction() {
        // Code to handle the search action
        System.out.println("Search clicked.");

        String searchValue = searchID.getText();
        System.out.println("Searching for Patient ID: " + searchValue);

        // Implement the logic to search in the TableView or fetch from the database based on the searchValue.
    }

    // Initialization method
    @FXML
    public void initialize() {
        // Initialization code if needed
        // Example: loading all patients' data into the table or set default states.
    }
}
