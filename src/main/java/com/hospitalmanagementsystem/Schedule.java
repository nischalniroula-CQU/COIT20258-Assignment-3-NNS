package com.hospitalmanagementsystem;

public class Schedule {

    private int scheduleId;
    private String firstName;
    private String lastName;
    private String date;
    private String time;
    private String bloodGroup;
    private String department;

    // Default constructor
    public Schedule() {}

    // Parameterized constructor
    public Schedule(int scheduleId, String firstName, String lastName, String date, String time, String bloodGroup, String department) {
        this.scheduleId = scheduleId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        this.time = time;
        this.bloodGroup = bloodGroup;
        this.department = department;
    }

    // Getters and setters
    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Schedule [scheduleId=" + scheduleId + ", firstName=" + firstName + ", lastName=" + lastName + ", date=" + date
                + ", time=" + time + ", bloodGroup=" + bloodGroup + ", department=" + department + "]";
    }
}
