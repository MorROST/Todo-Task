/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoserver;

/**
 *
 * @author Mor Aroesti
 */
public class TodoServer {


    public static void main(String[] args) {
     ServerSide loadServer = new ServerSide(54321);
     loadServer.listen();
     
    }
    
}
