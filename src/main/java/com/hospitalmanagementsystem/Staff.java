package com.hospitalmanagementsystem;

public class Staff {
    private String staffID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String gender;
    private String bloodGroup;
    private String department;
    private String dateOfBirth;
    private String role;

    // Constructor
    public Staff(String staffID, String firstName, String lastName, String email, 
                 String phoneNumber, String address, String gender, String bloodGroup, 
                 String department, String dateOfBirth, String role) {
        this.staffID = staffID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.department = department;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
    }

    // Getters
    public String getStaffID() {
        return staffID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getRole() {
        return role;
    }

    // Setters
    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Optionally, you can override the `toString` method to get a string representation of the object for debugging or logging
    @Override
    public String toString() {
        return "Staff{" +
                "staffID='" + staffID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", department='" + department + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
