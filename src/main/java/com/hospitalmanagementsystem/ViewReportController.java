package com.hospitalmanagementsystem;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
        try (Statement stm = connection.createStatement()) {
            // Get total number of registered patients
            ResultSet rsPatients = stm.executeQuery("SELECT COUNT(*) FROM patients");
            if (rsPatients.next()) {
                registeredPatientsID.setText(String.valueOf(rsPatients.getInt(1)));
            }

            // Get total number of appointments
            ResultSet rsAppointments = stm.executeQuery("SELECT COUNT(*) FROM schedules");
            if (rsAppointments.next()) {
                appointmentsID.setText(String.valueOf(rsAppointments.getInt(1)));
            }

            // Get total number of staff
            ResultSet rsStaff = stm.executeQuery("SELECT COUNT(*) FROM staffs");
            if (rsStaff.next()) {
                registeredStaffsID.setText(String.valueOf(rsStaff.getInt(1)));
            }

            // Get total patients and staff by department
            for (String department : new String[]{"Cardiology", "Neurology", "Orthopedics", "Dermatology", "Emergency", "Administration"}) {
                ResultSet rsDepartmentPatients = stm.executeQuery("SELECT COUNT(*) FROM patients WHERE department = '" + department + "'");
                ResultSet rsDepartmentStaffs = stm.executeQuery("SELECT COUNT(*) FROM staffs WHERE department = '" + department + "'");

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
                            administrationStaffsID.setText(String.valueOf(rsDepartmentPatients.getInt(1)));  // This line might need some correction based on your requirements.
                            break;
                    }
                }

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

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void cancelButtonAction() {
        // Handle the cancel button action here
    }
}
