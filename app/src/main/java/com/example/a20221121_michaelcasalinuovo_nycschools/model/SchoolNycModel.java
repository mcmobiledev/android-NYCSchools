package com.example.a20221121_michaelcasalinuovo_nycschools.model;

public class SchoolNycModel {

    private String dbn;
    private String school_name;
    private String location;
    private String city;
    private String total_students;

    public String getDbn() {
        return dbn;
    }

    public void setDbn(String dbn) {
        this.dbn = dbn;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getLocation() {
        return location;
    }

    public String getCity() {
        return city;
    }

    public String getTotal_students() {
        return total_students;
    }
}
