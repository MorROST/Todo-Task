package todoclient;

import com.data.Task;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JOptionPane;


/**
 *
 * @author Mor Aroesti
 */
public class MainApp extends javax.swing.JFrame {
    
    String currEmail;
    public static ArrayList <String> taskByUser = new ArrayList<String>();
    public String [] tasks;
    int deleteTaskNum;
    public String [] taskArray = new String[10];
    
    

    public MainApp(String email) {
        this.currEmail = email;

        try {

            this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("images/lgBoard.png")))));
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          initComponents();

          name_lable.setText(Login.userFirstName+ " here is your TODO List:");
          Login.connectionUtil.getTask(email);
          System.out.println("user " + currEmail +" is connect!!");
            if(taskByUser.size() <= 0)
              {
                  noTasks_lable1.setVisible(true);
                  noTasks_lable2.setVisible(true);
              }
            else
              {
                 noTasks_lable1.setVisible(false);
                 noTasks_lable2.setVisible(false);

              }
          LoadTask();
          this.setSize(1200, 800);
          this.setResizable(false);
          this.setVisible(true);
          this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void LoadTask()
    {
       
        for (int i = 0; i < taskByUser.size(); i++) {
            switch(i+1)
            {
                case 1:
                    task_lable1.setText("1) " +taskByUser.get(i));
                    taskArray[0] = taskByUser.get(i);
                    break;
                case 2:
                    task_lable2.setText("2) " +taskByUser.get(i));
                    taskArray[1] = taskByUser.get(i);
                    break;
                    
                case 3:
                    task_lable3.setText("3) " +taskByUser.get(i));
                    taskArray[2] = taskByUser.get(i);
                    break;
                case 4:
                    task_lable4.setText("4) " +taskByUser.get(i));
                    taskArray[3] = taskByUser.get(i);
                    break;
                case 5:
                    task_lable5.setText("5) " +taskByUser.get(i));
                    taskArray[4] = taskByUser.get(i);
                    break;
                case 6:
                    task_lable6.setText("6) " +taskByUser.get(i));
                    taskArray[5] = taskByUser.get(i);
                    break;
                case 7:
                    task_lable7.setText("7) " +taskByUser.get(i));
                    taskArray[6] = taskByUser.get(i);
                    break;
                case 8:
                    task_lable8.setText("8) " +taskByUser.get(i));
                    taskArray[7] = taskByUser.get(i);
                    break;
                case 9:
                    task_lable9.setText("9) " +taskByUser.get(i));
                    taskArray[8] = taskByUser.get(i);
                    break;
                case 10:
                    
                    task_lable10.setText("10) " +taskByUser.get(i));
                    taskArray[9] = taskByUser.get(i);
                    break;
            
            }
        }
        

    
    
    }
    public void deleteTask(int caseNum)
    {
        for (int i = 0; i < taskByUser.size(); i++) {
            
        
            switch(caseNum)
            {
                case 1:
                    Login.connectionUtil.deleteTask(currEmail,taskArray[0]);
                    task_lable1.setText("");
                    break;
                case 2:
                    Login.connectionUtil.deleteTask(currEmail,taskArray[1]);
                    task_lable2.setText("");
                    break;
                    
                case 3:
                    Login.connectionUtil.deleteTask(currEmail,taskArray[2]);
                    task_lable3.setText("");
                    break;
                case 4:
                    Login.connectionUtil.deleteTask(currEmail,taskArray[3]);
                    task_lable4.setText("");
                    break;
                case 5:
                    Login.connectionUtil.deleteTask(currEmail,taskArray[4]);
                    task_lable5.setText("");
                    break;
                case 6:
                    Login.connectionUtil.deleteTask(currEmail,taskArray[5]);
                    task_lable6.setText("");
                    break;
                case 7:
                    Login.connectionUtil.deleteTask(currEmail,taskArray[6]);
                    task_lable7.setText("");
                    break;
                case 8:
                    Login.connectionUtil.deleteTask(currEmail,taskArray[7]);
                    task_lable8.setText("");
                    break;
                case 9:
                    Login.connectionUtil.deleteTask(currEmail,taskArray[8]);
                    task_lable9.setText("");
                    break;
                case 10:
                    Login.connectionUtil.deleteTask(currEmail,taskArray[9]);
                    task_lable10.setText("");
                    break;
            
            }
        }

          
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logout_btn = new javax.swing.JButton();
        add_btn = new javax.swing.JButton();
        name_lable = new javax.swing.JLabel();
        task_lable1 = new javax.swing.JLabel();
        task_lable2 = new javax.swing.JLabel();
        task_lable3 = new javax.swing.JLabel();
        task_lable4 = new javax.swing.JLabel();
        task_lable5 = new javax.swing.JLabel();
        task_lable6 = new javax.swing.JLabel();
        task_lable7 = new javax.swing.JLabel();
        task_lable8 = new javax.swing.JLabel();
        task_lable9 = new javax.swing.JLabel();
        task_lable10 = new javax.swing.JLabel();
        noTasks_lable2 = new javax.swing.JLabel();
        noTasks_lable1 = new javax.swing.JLabel();
        delete_btn = new javax.swing.JButton();
        delete_txt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        logout_btn.setText("Log Out");
        logout_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_btnActionPerformed(evt);
            }
        });

        add_btn.setText("ADD");
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });

        name_lable.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        name_lable.setForeground(new java.awt.Color(0, 51, 255));
        name_lable.setText("jLabel1");

        task_lable1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        task_lable2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        task_lable3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        task_lable4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        task_lable5.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        task_lable6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        task_lable7.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        task_lable8.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N

        task_lable9.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        task_lable10.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N

        noTasks_lable2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Mor Aroesti\\Documents\\NetBeansProjects\\TodoClient\\images\\chillOut.jpg")); // NOI18N
        noTasks_lable2.setText("jLabel1");

        noTasks_lable1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        noTasks_lable1.setForeground(new java.awt.Color(255, 0, 204));
        noTasks_lable1.setText("No Tasks for you...:) you can add one with the button below");

        delete_btn.setText("Delete");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(add_btn)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(delete_btn)
                                .addGap(18, 18, 18)
                                .addComponent(delete_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(149, 149, 149)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(task_lable3, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(task_lable2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(task_lable1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name_lable, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(task_lable7, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(task_lable8, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(task_lable10, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(task_lable6, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(task_lable9, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(task_lable5, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(task_lable4, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(noTasks_lable1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(129, 129, 129)
                                        .addComponent(noTasks_lable2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(logout_btn)))
                .addContainerGap(762, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(181, Short.MAX_VALUE)
                        .addComponent(name_lable)
                        .addGap(58, 58, 58)
                        .addComponent(task_lable1)
                        .addGap(18, 18, 18)
                        .addComponent(task_lable2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(task_lable3)
                        .addGap(27, 27, 27)
                        .addComponent(task_lable4)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(task_lable5)
                            .addComponent(noTasks_lable1))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(task_lable6)
                                .addGap(39, 39, 39)
                                .addComponent(task_lable7)
                                .addGap(36, 36, 36)
                                .addComponent(task_lable8)
                                .addGap(26, 26, 26)
                                .addComponent(task_lable9)
                                .addGap(30, 30, 30)
                                .addComponent(task_lable10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(add_btn)
                                .addGap(18, 18, 18)
                                .addComponent(delete_btn))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(noTasks_lable2)
                                .addGap(0, 79, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(delete_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addComponent(logout_btn)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logout_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_btnActionPerformed
        new Login();
        this.dispose();
    }//GEN-LAST:event_logout_btnActionPerformed

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
       new AddTask(currEmail);
       this.dispose();
    }//GEN-LAST:event_add_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        deleteTaskNum = Integer.parseInt(delete_txt.getText());
        delete_txt.setText("");
        deleteTask(deleteTaskNum);
    }//GEN-LAST:event_delete_btnActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_btn;
    private javax.swing.JButton delete_btn;
    private javax.swing.JTextField delete_txt;
    private javax.swing.JButton logout_btn;
    private javax.swing.JLabel name_lable;
    private javax.swing.JLabel noTasks_lable1;
    private javax.swing.JLabel noTasks_lable2;
    private javax.swing.JLabel task_lable1;
    private javax.swing.JLabel task_lable10;
    private javax.swing.JLabel task_lable2;
    private javax.swing.JLabel task_lable3;
    private javax.swing.JLabel task_lable4;
    private javax.swing.JLabel task_lable5;
    private javax.swing.JLabel task_lable6;
    private javax.swing.JLabel task_lable7;
    private javax.swing.JLabel task_lable8;
    private javax.swing.JLabel task_lable9;
    // End of variables declaration//GEN-END:variables
}
