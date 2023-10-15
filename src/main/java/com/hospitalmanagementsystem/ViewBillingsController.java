package com.hospitalmanagementsystem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

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

    @FXML
    private void handleCancelButtonAction(ActionEvent event) {
        Stage stage = (Stage) cancelButtonID.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void handlePrintButtonAction(ActionEvent event) {
        // Implement your print logic here.
        System.out.println("Print button pressed!");
    }

    // Additional helper methods can go here.

}
