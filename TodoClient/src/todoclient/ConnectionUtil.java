/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoclient;

import com.data.ConnectionData;
import com.data.Task;
import com.data.User;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mor Aroesti
 */
public class ConnectionUtil {
    boolean isConnected;
    Socket clientSocket;
    InputStream input;
    OutputStream output;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    
    public ConnectionUtil(){
         try {
             clientSocket = new Socket("127.0.0.1", 54321);
             isConnected = true;
             input = clientSocket.getInputStream();
             output = clientSocket.getOutputStream();
             oos = new ObjectOutputStream(output);
             ois= new ObjectInputStream(input);

        } catch (Exception e) {
             System.out.println(e.getMessage());
        }


    }
    public boolean login(String email , String password) throws Exception{
        
        ConnectionData requestCD = new ConnectionData();
        ConnectionData responseCD = new ConnectionData();
        User userLogin = new User(email, password);
        
        requestCD.setRequestCode(ConnectionData.LOGIN_CODE);
        requestCD.setNewUser(userLogin);
        oos.writeObject(requestCD);
        responseCD = (ConnectionData) ois.readObject();
        Login.userFirstName = responseCD.userFirstName;
        return responseCD.isStatus();

    }
    
    public boolean addNewUser(String email,String fName,String lName, String password, String phone, String city) {
    
        User newUser = new User(email,fName,lName, password, phone, city);
        ConnectionData requestCD = new ConnectionData();
        ConnectionData responseCD = new ConnectionData();
    
        requestCD.setRequestCode(ConnectionData.ADD_NEW_CODE);
        requestCD.setNewUser(newUser);
        try {
            oos.writeObject(requestCD);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionUtil.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        }
        System.out.println("sent user");
        
        try {
            responseCD = (ConnectionData)ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(ConnectionUtil.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionUtil.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        }
        System.out.println("user recived");
        return responseCD.isStatus();
        
        
        
    }
    
    public boolean addNewTask(String email , String task)
    {
       Task newTask = new Task(email, task);
       System.out.println("task in conn util client : " + task);
       ConnectionData requestCD = new ConnectionData();
       ConnectionData responseCD = new ConnectionData();
       requestCD.setRequestCode(ConnectionData.ADD_NEW_TASK);
       requestCD.setTask(newTask);
        try {
            oos.writeObject(requestCD);
        } catch (Exception e) {
            e.getMessage();
        }
        
        System.out.println("Task sent");
        
        try {
            responseCD = (ConnectionData)ois.readObject();
        } catch (Exception e) {
            e.getMessage();
        }
        System.out.println("task recived");
        return responseCD.isStatus();

    }
    
    public boolean getTask (String email)
    {
       
       ConnectionData requestCD = new ConnectionData();
       ConnectionData responseCD = new ConnectionData();
       requestCD.setRequestCode(ConnectionData.GET_TASK);
       requestCD.currUser = email;
       
        try {
            oos.writeObject(requestCD);
        } catch (Exception e) {
            e.getMessage();
        }
        
        System.out.println("request for task sent");
        
        try {
            responseCD = (ConnectionData)ois.readObject();
        } catch (Exception e) {
            e.getMessage();
        }
        MainApp.taskByUser = responseCD.taskByUser;
        System.out.println("FROM conn util size of array: " + responseCD.taskByUser.size());
        System.out.println("tasks recived!");
        return responseCD.isStatus();
        
    
    
    
    }

    public boolean deleteTask(String email, String task)
    {
        Task taskDel = new Task(email, task);
        ConnectionData requestCD = new ConnectionData();
        ConnectionData responseCD = new ConnectionData();
        requestCD.setRequestCode(ConnectionData.DELETE_TASK);
        requestCD.setTask(taskDel);
        try {
            oos.writeObject(requestCD);
        } catch (Exception e) {
            e.getMessage();
        }
        try {
            responseCD = (ConnectionData)ois.readObject();
        } catch (Exception e) {
            e.getMessage();
        }
        return responseCD.isStatus();
    
    }
    
    
}
