/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoserver;

import java.net.*;
import java.util.ArrayList;

/**
 *
 * @author Mor Aroesti
 */
public class ServerSide {
    ServerSocket sSoket;
    ArrayList<ConnectionThread> connections = new ArrayList<ConnectionThread>();
    static DataBase db;
   
public ServerSide(int port){

    try {
        db = new DataBase();
        sSoket = new ServerSocket(port);
        System.out.println("Server is waiting on port 54321");
    } catch (Exception e) {
    }

}
    
 public void listen(){
 
     while(true){
         try {
             Socket singleSocket;
             System.out.println("Server waiting for call...........");
             singleSocket = sSoket.accept();
             System.out.println("Incomming call");
             connections.add(new ConnectionThread(singleSocket));
             connections.get(connections.size()-1).start();
             
             
         } catch (Exception e) {
         }
   
     
     
     
     
     }
 
 
 
     
     
     
     
 }   
    
    
    
    
    
    
    
    
 








}
