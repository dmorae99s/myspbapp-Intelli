package com.trainingtcs.myspbapp.response;


import com.trainingtcs.myspbapp.entity.User;

public class AddressResponse {

    private int id;
    private int userID;
    private String street;
    private String city;

    //private User user;

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public int getUserID() {return userID;}
    public void setUserID(int userID) {this.userID = userID;}
    public String getStreet() {return street;}
    public void setStreet(String street) {this.street = street;}
    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}


    //public User getUser() {return user;}
    //public void setUser(User user) {this.user = user;}
}
