package com.hospitalmanagementsystem;

public class Patient {
    private String patientID;
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String bloodGroup;
    private String department;
    private double height;
    private double weight;
    private String bloodPressure;
    private double bmi;
    private String reason;

    // Constructor
    public Patient(String patientID, String firstName, String lastName, 
                   String dateOfBirth, String gender, String bloodGroup, 
                   String department, double height, double weight, 
                   String bloodPressure, double bmi, String reason) {
        this.patientID = patientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.department = department;
        this.height = height;
        this.weight = weight;
        this.bloodPressure = bloodPressure;
        this.bmi = bmi;
        this.reason = reason;
    }

    // Getters
    public String getPatientID() {
        return patientID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getDepartment() {
        return department;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public double getBmi() {
        return bmi;
    }
    
    public String getReason() {
        return reason;
    }

    // Setters
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public void setBmi(double bmi) {
        this.bmi = bmi;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }

    // `toString` method
    @Override
    public String toString() {
        return "Patient{" +
                "patientID='" + patientID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", department='" + department + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", bloodPressure='" + bloodPressure + '\'' +
                ", bmi='" + bmi + '\'' +
                ", reason=" + reason +
                '}';
    }
}
