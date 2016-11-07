/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoserver;

import com.data.Task;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.ArrayList;

/**
 *
 * @author Mor Aroesti
 */
public class DataBase {
    
    public static final String DB_URL = "jdbc:derby://localhost:1527/TodoDBee";
    public static final String DB_USER = "root";
    public static final String DB_PASS = "root";
    public static final String DB_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    public static Connection conn;
    public static Statement statement;
    public static PreparedStatement pstUsers;
    public static PreparedStatement pstTask;
    public int taskSize=0;
    public static String userFirstName;
    public int taskIDtoDelete;
   
    
    public static final String InsertUserSQL = "INSERT into USERS values(?,?,?,?,?,?)";
    public static final String InsertTaskSQL = "INSERT into TASK values(?,?,?)";
    
    
    public DataBase()
    {
        
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            pstUsers = conn.prepareStatement(InsertUserSQL);
            pstTask = conn.prepareStatement(InsertTaskSQL);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(*) AS total FROM TASK");
            while(rs.next())
            {
                taskSize = rs.getInt("total");
            }
            System.out.println("current number of task is " + taskSize);
            //conn.close();
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
    }
    
    public int newUser(String email,String fName,String lName, String password, String phone, String city){
        
        Statement st;
        int check = 0;
        String userNameReturn;
        String passwordReturn;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            st = conn.createStatement();
            Statement stselect = conn.createStatement();
            ResultSet rs = stselect.executeQuery("select * from USERS");
            while (rs.next())
            {
                userNameReturn = rs.getString("EMAIL");
                if (email.equals(userNameReturn))
                {
                    check = 1;
                    return check;
                }
            }
            if (check == 0)
            {
            pstUsers.setString(1, email);
            pstUsers.setString(2, fName);
            pstUsers.setString(3, lName);
            pstUsers.setString(4, password);
            pstUsers.setString(5, phone);
            pstUsers.setString(6, city);
            pstUsers.execute();
            conn.close();
            }
 
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return check;
}
    
   public boolean checkLogIn(String email, String password){
   
       boolean check = false;
        Statement st;
        String emailReturn;
        String passwordReturn;
       
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            st = conn.createStatement();
            Statement stselect = conn.createStatement();
            ResultSet rs = stselect.executeQuery("SELECT * from USERS");
            while(rs.next())
            {
                
                emailReturn = rs.getString("Email");
                passwordReturn = rs.getString("Password");
                if (email.equals(emailReturn) && password.equals(passwordReturn))
                    {
                        check = true;
                        rs = stselect.executeQuery("SELECT firstname FROM users WHERE email = '" + email + "'");
                        while(rs.next())
                        {
                            userFirstName = rs.getString("FirstName");
                        }
                        return check;
                    }
            }
            rs.close();
            conn.close();
            

            
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        }
       
       return check;
       
   
   
   }
    
   public boolean setNewTask(String email, String task)
   {
       boolean check = false;
       try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            taskSize++;
            pstTask.setInt(1, taskSize);
            pstTask.setString(2, email);
            pstTask.setString(3, task);
            pstTask.execute();
            
            conn.close();
       } catch (Exception e) {
           e.getMessage();
       }
       
       return true;
   }
   
   public ArrayList<String> getTaskByUser(String email)
   {
       boolean check = false;
       Statement st;
       ArrayList <String> tasks = new ArrayList<String>();
       
       try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            st = conn.createStatement();
            Statement stselect = conn.createStatement();
            ResultSet rs = stselect.executeQuery("SELECT task FROM task WHERE email ='" + email + "'");
            
            while(rs.next())
            {
                tasks.add(rs.getString("TASK"));
                
            }
            System.out.println("FROM DataBase array size: " + tasks.size());
           
            rs.close();
            conn.close();
       } catch (SQLException e) {
           e.getMessage();
       }

        return tasks;

   }
   
   public int getTaskIDforDelete (String email, String task)
   {
       //UPDATE TASK SET EMAIL= '' WHERE ID=2;
        Statement st;
        try {
            System.out.println(task);// שים לב להדפסה
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            st = conn.createStatement();
        Statement stselect = conn.createStatement();  
        ResultSet rs = stselect.executeQuery("SELECT id FROM task WHERE task ='" + task +"'");
        while(rs.next())
        {
           taskIDtoDelete = rs.getInt("ID");
        }
            rs.close();
            conn.close();
        
//        String sql = "DELETE FROM task WHERE id = '" + taskIDtoDelete +"';";
//        st.executeUpdate(sql);
//        while(rs.next())
//        {
//        }
//
//        String sql2 = "UPDATE task SET id = id +1 WHERE id ='" + taskIDtoDelete++ +"';";
//        st.executeUpdate(sql2);
//        while(rs.next())
//        {
//        }
//        
//        
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex.getMessage());
        }
//      
//
//   
//   
//   
//   
        return taskIDtoDelete;
//   }
   
}
    
   public boolean deleteTask (int taskNum)
   {
       String SQL;
       Statement st;
       
       try {
        conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
        st = conn.createStatement();
        Statement stselect = conn.createStatement();  
        SQL = "UPDATE task SET email=''WHERE ID=" + taskNum;
        st.executeUpdate(SQL);
        
        conn.close();
       
       } catch (Exception e) {
       e.getMessage();
       return false;
       }
 
       
       
       
       
       return true;
   }
}
    
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

