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
public class Task implements Serializable{
    
    private int ID;
    private String currEmail;
    private String task;
    
    
    public Task(String email , String task)
    {
    
        this.currEmail = email;
        this.task = task;
       
    }

    public Task(String currEmail) {
        this.currEmail = currEmail;
    }
    

    public int getID() {
        return ID;
    }

    public String getCurrEmail() {
        return currEmail;
    }

    public void setCurrEmail(String currEmail) {
        this.currEmail = currEmail;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }
    
    
}
