package com.hospitalmanagementsystem;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ViewReportController {

    @FXML
    private TextArea registeredPatientsID;
    @FXML
    private TextArea appointmentsID;
    @FXML
    private TextArea registeredStaffsID;
    @FXML
    private TextArea cardiologyPatientsID;
    @FXML
    private TextArea NeurologyPatientsID;
    @FXML
    private TextArea orthopedicsPatientsID;
    @FXML
    private TextArea dermatologyPatientsID;
    @FXML
    private TextArea emergencyPatientsID;
    @FXML
    private TextArea cardiologyStaffsID;
    @FXML
    private TextArea NeurologyStaffsID;
    @FXML
    private TextArea orthopedicsStaffsID;
    @FXML
    private TextArea dermatologyStaffsID;
    @FXML
    private TextArea emergencyStaffsID;
    @FXML
    private TextArea administrationStaffsID;
    
    @FXML
    private Button cancelButton;

    private Connection connection;

    public ViewReportController() {
        ConnectionClass connectionClass = new ConnectionClass();
        this.connection = connectionClass.con;
    }

    @FXML
    public void initialize() {
        setAllTextAreasNonEditable();
        setAllTextAreasDefaultZero();
        displayReportData();
    }
    
    @FXML
    private void cancelButtonAction() {
        try {
        // Get the current stage using the cancel button
        Stage stage = (Stage) cancelButton.getScene().getWindow();

        // Close the stage
        stage.close();
        } catch (Exception e) {
        e.printStackTrace();
        }
    }

    private void setAllTextAreasNonEditable() {
        registeredPatientsID.setEditable(false);
        appointmentsID.setEditable(false);
        registeredStaffsID.setEditable(false);
        cardiologyPatientsID.setEditable(false);
        NeurologyPatientsID.setEditable(false);
        orthopedicsPatientsID.setEditable(false);
        dermatologyPatientsID.setEditable(false);
        emergencyPatientsID.setEditable(false);
        cardiologyStaffsID.setEditable(false);
        NeurologyStaffsID.setEditable(false);
        orthopedicsStaffsID.setEditable(false);
        dermatologyStaffsID.setEditable(false);
        emergencyStaffsID.setEditable(false);
        administrationStaffsID.setEditable(false);
    }

    private void setAllTextAreasDefaultZero() {
        registeredPatientsID.setText("0");
        appointmentsID.setText("0");
        registeredStaffsID.setText("0");
        cardiologyPatientsID.setText("0");
        NeurologyPatientsID.setText("0");
        orthopedicsPatientsID.setText("0");
        dermatologyPatientsID.setText("0");
        emergencyPatientsID.setText("0");
        cardiologyStaffsID.setText("0");
        NeurologyStaffsID.setText("0");
        orthopedicsStaffsID.setText("0");
        dermatologyStaffsID.setText("0");
        emergencyStaffsID.setText("0");
        administrationStaffsID.setText("0");
    }

    private void displayReportData() {
        try {
            // Get total number of registered patients
            try (Statement stmPatients = connection.createStatement()) {
                ResultSet rsPatients = stmPatients.executeQuery("SELECT COUNT(*) FROM patients");
                if (rsPatients.next()) {
                    registeredPatientsID.setText(String.valueOf(rsPatients.getInt(1)));
                }
            }

            // Get total number of appointments
            try (Statement stmAppointments = connection.createStatement()) {
                ResultSet rsAppointments = stmAppointments.executeQuery("SELECT COUNT(*) FROM schedules");
                if (rsAppointments.next()) {
                    appointmentsID.setText(String.valueOf(rsAppointments.getInt(1)));
                }
            }

            // Get total number of staff
            try (Statement stmStaff = connection.createStatement()) {
                ResultSet rsStaff = stmStaff.executeQuery("SELECT COUNT(*) FROM staffs");
                if (rsStaff.next()) {
                    registeredStaffsID.setText(String.valueOf(rsStaff.getInt(1)));
                }
            }
            
            
            
            // Get total patients and staff by department
        
            for (String department : new String[]{"Cardiology", "Neurology", "Orthopedics", "Dermatology", "Emergency", "Administration"}) {
                try (Statement stmDepartment = connection.createStatement()) {
                    ResultSet rsDepartmentPatients = stmDepartment.executeQuery("SELECT COUNT(*) FROM patients WHERE department = '" + department + "'");
                    
                if (rsDepartmentPatients.next()) {
                    switch (department) {
                        case "Cardiology":
                            cardiologyPatientsID.setText(String.valueOf(rsDepartmentPatients.getInt(1)));
                            break;
                        case "Neurology":
                            NeurologyPatientsID.setText(String.valueOf(rsDepartmentPatients.getInt(1)));
                            break;
                        case "Orthopedics":
                            orthopedicsPatientsID.setText(String.valueOf(rsDepartmentPatients.getInt(1)));
                            break;
                        case "Dermatology":
                            dermatologyPatientsID.setText(String.valueOf(rsDepartmentPatients.getInt(1)));
                            break;
                        case "Emergency":
                            emergencyPatientsID.setText(String.valueOf(rsDepartmentPatients.getInt(1)));
                            break;
                        case "Administration":
                            administrationStaffsID.setText(String.valueOf(rsDepartmentPatients.getInt(1)));  
                            break;
                    }
                }

                ResultSet rsDepartmentStaffs = stmDepartment.executeQuery("SELECT COUNT(*) FROM staffs WHERE department = '" + department + "'");
                if (rsDepartmentStaffs.next()) {
                    switch (department) {
                        case "Cardiology":
                            cardiologyStaffsID.setText(String.valueOf(rsDepartmentStaffs.getInt(1)));
                            break;
                        case "Neurology":
                            NeurologyStaffsID.setText(String.valueOf(rsDepartmentStaffs.getInt(1)));
                            break;
                        case "Orthopedics":
                            orthopedicsStaffsID.setText(String.valueOf(rsDepartmentStaffs.getInt(1)));
                            break;
                        case "Dermatology":
                            dermatologyStaffsID.setText(String.valueOf(rsDepartmentStaffs.getInt(1)));
                            break;
                        case "Emergency":
                            emergencyStaffsID.setText(String.valueOf(rsDepartmentStaffs.getInt(1)));
                            break;
                        case "Administration":
                            administrationStaffsID.setText(String.valueOf(rsDepartmentStaffs.getInt(1)));
                            break;
                    }
                }
            }
        }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
