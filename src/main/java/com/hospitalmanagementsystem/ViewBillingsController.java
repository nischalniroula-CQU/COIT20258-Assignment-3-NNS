package com.hospitalmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ViewBillingsController {

    @FXML
    private Button cancelButtonID;

    @FXML
    private Button printButtonID;

    @FXML
    private TextArea patientID;

    @FXML
    private TextArea nameID;

    @FXML
    private TextArea departmentID;

    @FXML
    private TextArea reasonID;

    @FXML
    private TextArea totalBillID;

    @FXML
    public void initialize() {
        makeTextAreasNonEditable();
    }
    
    private void makeTextAreasNonEditable(){
        patientID.setEditable(false);
        nameID.setEditable(false);
        departmentID.setEditable(false);
        reasonID.setEditable(false);
        totalBillID.setEditable(false);
    }
    
    //Billing functionality
    
    public void setPatientData(Patient patient) {
        patientID.setText(patient.getPatientID());
        nameID.setText(patient.getFirstName() + " " + patient.getLastName());
        departmentID.setText(patient.getDepartment());
        reasonID.setText(patient.getReason());
        
        // Calculate the total bill based on the reason and set it
        totalBillID.setText("$" + calculateTotalBill(patient.getReason()));
    }

    private double calculateTotalBill(String reason) {
        switch (reason) {
            case "Normal Checkup":
                return 100;
            case "Surgery":
                return 700;
            case "Intensive Care Requirement":
                return 1000;
            case "Chronic Illness Management":
                return 500;
            case "Accident and Trauma Care":
                return 1200;
            default:
                return 0;  // or throw an error if the reason is invalid
        }
    }

    @FXML
    private void handleCancelButtonAction(ActionEvent event) {
        Stage stage = (Stage) cancelButtonID.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handlePrintButtonAction(ActionEvent event) {
    // Retrieve the billing details
    String patientIDText = patientID.getText();
    String nameText = nameID.getText();
    String departmentText = departmentID.getText();
    String reasonText = reasonID.getText();
    String totalBillText = totalBillID.getText();

    // Create the content for the txt file
    String content = "Bill Details:\n\n";
    content += "Patient ID: " + patientIDText + "\n";
    content += "Name: " + nameText + "\n";
    content += "Department: " + departmentText + "\n";
    content += "Reason for Visit: " + reasonText + "\n";
    content += "Total Bill: " + totalBillText + "\n";

    // Write the details to a .txt file
    File file = new File("Bill for Patient ID " + patientIDText + ".txt");

    try (FileWriter writer = new FileWriter(file)) {
        writer.write(content);
        System.out.println("Bill exported successfully!");
    } catch (IOException e) {
        e.printStackTrace();
        System.out.println("Error exporting the bill!");
    }
}
}
