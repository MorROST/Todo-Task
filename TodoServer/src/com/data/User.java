/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;

import java.io.Serializable;

/**
 *
 * @author Mor Aroesti
 */
public class User implements Serializable{
    
    private String eMail;
    private String firstName;
    private String lastName;
    private String password;
    private String phoneNumber;
    private String city;
    
    public User(String email,String fName,String lName,String pass, String phone, String city)
    {
        this.eMail=email;
        this.firstName = fName;
        this.lastName = lName;
        this.password=pass;
        this.phoneNumber = phone;
        this.city = city;
    }

    public User(String email, String pass){
     
        this.eMail = email;
        this.password = pass;

    
    }
    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    
        
        
        
        
        
        
        
        
        
        
}
