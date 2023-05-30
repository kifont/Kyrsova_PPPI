package com.example.kyrsova_pppi.assets;

public class User {

    private int id;
    private String firstName;
    private String secondName;
    private String userName;
    private String password;
    private String location;
    private String gender;

    public User(String firstName, String secondName, String userName, String password, String location, String gender) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.userName = userName;
        this.password = password;
        this.location = location;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(int id, String firstName, String secondName, String userName, String password, String location, String gender) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.userName = userName;
        this.password = password;
        this.location = location;
        this.gender = gender;
    }

    public User() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
