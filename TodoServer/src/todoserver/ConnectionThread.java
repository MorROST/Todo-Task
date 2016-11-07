/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoserver;

import com.data.ConnectionData;
import java.io.*;
import java.net.Socket;

/**
 *
 * @author Mor Aroesti
 */
public class ConnectionThread extends Thread{
    int check;
    boolean checkLogin = false;
    boolean checkSetTask = false;
    boolean checkGetTaskByUser = false;
    boolean checkIfTaskDelete = false;
    Socket socket;
    InputStream input;
    OutputStream output;
    ObjectInputStream ois;
    ObjectOutputStream oos;
    String username;
    int taskNum;
    
    boolean isConnected = true;
    
    public ConnectionThread(Socket s){
    
    this.socket = s;
       
    
    
    }
            
     @Override
     public void run(){
         try {
  
             input = socket.getInputStream();
             output = socket.getOutputStream();
             oos = new ObjectOutputStream(output);
             ois = new ObjectInputStream(input);
             
             while(isConnected)
             {
                              
                 ConnectionData requestCD = (ConnectionData)ois.readObject();   
                 ConnectionData responseCD = new ConnectionData();
                    
                    switch (requestCD.getRequestCode())
                    {
                        case ConnectionData.LOGIN_CODE:
                            System.out.println("press login");
                            checkLogin = ServerSide.db.checkLogIn(requestCD.getNewUser().geteMail(), requestCD.getNewUser().getPassword());
                            responseCD.userFirstName = DataBase.userFirstName;
                            responseCD.setStatus(checkLogin);
                            break;
                            
                        case ConnectionData.ADD_NEW_CODE:
                            System.out.println("press register");
                            check = ServerSide.db.newUser(requestCD.getNewUser().geteMail(),requestCD.getNewUser().getFirstName(),requestCD.getNewUser().getLastName(), requestCD.getNewUser().getPassword(), requestCD.getNewUser().getPhoneNumber()
                                    , requestCD.getNewUser().getCity());
                            if (check == 1)
                            {
                            responseCD.setStatus(false);
                            }
                            else{
                            responseCD.setStatus(true);
                            }
                         break;  
                         
                        case ConnectionData.ADD_NEW_TASK:
                            System.out.println("press add task");
                            checkSetTask = ServerSide.db.setNewTask(requestCD.getTask().getCurrEmail(), requestCD.getTask().getTask());
                            responseCD.setStatus(checkSetTask);
                            
                            break;
                            
                        case ConnectionData.GET_TASK:
                            responseCD.taskByUser = ServerSide.db.getTaskByUser(requestCD.currUser);
                            responseCD.setStatus(true);
                            
                            
                            break;
                        case ConnectionData.DELETE_TASK:
                            taskNum = ServerSide.db.getTaskIDforDelete(requestCD.currUser, requestCD.getTask().getTask());
                            ServerSide.db.deleteTask(taskNum);
                            responseCD.setStatus(true);
                            
                            break;
                    }
                    
                oos.writeObject(responseCD);
             
             }
             this.socket.close();
         } catch (Exception e ) {
         
         }finally
            {
                if(socket != null)
                {
                    try {
                        socket.close();
                    } catch (Exception e) {
                    }
                
                }



            }
        
     
     }
    
}
