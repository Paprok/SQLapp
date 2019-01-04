package com.codecool.app.models;

public class Mentor {
    private int id;
    private String first_name;      //Changing name convention to match DB
    private String last_name;
    private String nick_name;
    private String phone_number;
    private String email;
    private String city;
    private String favourite_number;

    public Mentor() {
    }

    public Mentor(String first_name, String last_name, String nick_name, String phone_number, String email, String city, String favourite_number) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.nick_name = nick_name;
        this.phone_number = phone_number;
        this.email = email;
        this.city = city;
        this.favourite_number = favourite_number;
    }

    public Mentor(int id, String first_name, String last_name, String nick_name, String phone_number, String email, String city, String favourite_number) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.nick_name = nick_name;
        this.phone_number = phone_number;
        this.email = email;
        this.city = city;
        this.favourite_number = favourite_number;
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

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFavourite_number() {
        return favourite_number;
    }

    public void setFavourite_number(String favourite_number) {
        this.favourite_number = favourite_number;
    }
}
