/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.data;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Mor Aroesti
 */
public class ConnectionData implements Serializable{
    public static final int LOGIN_CODE = 1;
    public static final int ADD_NEW_CODE = 2;
    public static final int ADD_NEW_TASK = 3;
    public static final int GET_TASK = 4;
    public static final int DELETE_TASK = 5;
    
    int requestCode;
    boolean status;
    private User newUser;
    private Task task;
    private boolean checkIfWorked;
    public ArrayList <String> taskByUser = new ArrayList<String>();
    public String currUser;
    public String userFirstName;

    public boolean isCheckIfWorked() {
        return checkIfWorked;
    }

    public void setCheckIfWorked(boolean checkIfWorked) {
        this.checkIfWorked = checkIfWorked;
    }
    
    public int getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(int requestCode) {
        this.requestCode = requestCode;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }


    
    
}
