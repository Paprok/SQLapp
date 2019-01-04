package com.codecool.app.models;

public class Applicant {
    private int id;
    private String  first_name;     //Changing naming convention of fields to match DB
    private String last_name;
    private String phone_number;
    private String email;
    private int application_code;

    public Applicant() {
    }

    public Applicant(String first_name, String last_name, String phone_number, String email, int application_code) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.email = email;
        this.application_code = application_code;
    }

    public Applicant(int id, String first_name, String last_name, String phone_number, String email, int application_code) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.email = email;
        this.application_code = application_code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getApplication_code() {
        return application_code;
    }

    public void setApplication_code(int application_code) {
        this.application_code = application_code;
    }
}
