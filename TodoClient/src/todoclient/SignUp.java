/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todoclient;

import java.awt.*;
import java.io.*;
import java.util.logging.*;
import java.util.regex.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;


/**
 *
 * @author Mor Aroesti
 */
public class SignUp extends JFrame {

    Boolean detailsValidationOK=false;
    Color errorColor= Color.red;
    String password;
    
    public SignUp() {
               try {
            this.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("images/signup.png")))));
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          initComponents();
          this.setSize(600, 600);
          this.setResizable(false);
          this.setVisible(true);
          this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void detailsValidation (){
        
    String email = email_txt.getText();
    password = String.valueOf(password_txt.getPassword());
    String passwordRepet = String.valueOf(passwordRepet_txt.getPassword());
    String phone = phone_txt.getText();
    String city = (String)city_comBox.getSelectedItem();
    Boolean userAgree = agree_checkBox.isSelected();
    
    Boolean flagEmail = true;
    Boolean flagPass = true;
    Boolean flagRepetPass = true;
    Boolean flagPhone = true;
    Boolean flagAgree = true;
    
    
        //RESET ALL LABEL:
        email_label.setText("");
        password_label.setText("");
        password_label2.setText("");
        passwordRepet_label.setText("");
        phone_label.setText("");
        agree_label.setText("");
        
        //RESET ALL TEXT FEILD BACKGROUND:
        email_txt.setBackground(Color.WHITE);
        password_txt.setBackground(Color.WHITE);
        passwordRepet_txt.setBackground(Color.WHITE);
        phone_txt.setBackground(Color.WHITE);
        agree_checkBox.setBackground(Color.WHITE);
        
        
        //EMAIL:
        if(!isValidEmailAddress(email))
        {
            email_label.setText("please enter correct email");
            email_label.setForeground(errorColor);
            email_txt.setBackground(errorColor);
            flagEmail=false;
        
        }
        
        //PASSWORD:
        if(!isPasswordValid(password))
        {
            password_label.setText("The password must contain just numbers and letters:");
            password_label2.setText("at least one capital letter,and one lowercase letter, and eight characters.");
            password_label.setForeground(errorColor);
            password_label2.setForeground(errorColor);
            password_txt.setBackground(errorColor);
            flagPass=false;
        }
        
        //REPET PASSWORD:
        if(!password.equals(passwordRepet))
        {
            passwordRepet_label.setText("These passwords don't match. Try again");
            passwordRepet_label.setForeground(errorColor);
            passwordRepet_txt.setBackground(errorColor);
            flagRepetPass=false;

        }
        
        //PHONE NUMBER:
        if(!isPhoneValid(phone))
        {
            phone_label.setText("mobile phone number isn't correct");
            phone_label.setForeground(errorColor);
            phone_txt.setBackground(errorColor);
            flagPhone=false;
        }
        
        //AGREE
        if(!agree_checkBox.isSelected())
        {
            agree_label.setText("You MUST agree to the conditions for register!");
            agree_label.setForeground(errorColor);
            agree_checkBox.setBackground(errorColor);
            flagAgree=false;
        }
        
        
        //CHECK ALL CONDITIONS:
        if(flagEmail && flagPass && flagRepetPass && flagPhone && flagAgree)
        {
            detailsValidationOK = true;
            
        }
        else
        {
            detailsValidationOK =  false;
           
        }
        
        
    }
    public boolean isValidEmailAddress(String email) {
           String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
           java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
           java.util.regex.Matcher m = p.matcher(email);
           return m.matches();
    }
    public boolean isPasswordValid(String password) {
        //return true if and only if password:
        //1. have at least eight characters.
        //2. consists of only letters and digits.
        //3. must contain at least one digit.
        //4. must contain at least two letters.
        //5. must contain at least one capital letter.
        //6. must contain at least one lowercase letter.
        
            
            boolean flagUppercase = false;
            boolean flagLowercase = false;
            boolean flagDigit = false;
            boolean flag = false;

            if (password.length() >= 8) {

                for (int i = 0; i < password.length(); i++) {

                    if (!Character.isLetterOrDigit(password.charAt(i))) {
                        return false;
                    }

                    if (Character.isDigit(password.charAt(i)) && !flagDigit) {
                        flagDigit = true;

                    }

                    if (Character.isUpperCase(password.charAt(i)) && !flagUppercase) {
                        flagUppercase = true;

                    }

                    if (Character.isLowerCase(password.charAt(i)) && !flagLowercase) {
                        flagLowercase = true;
                    }
                }
            }

            if (flagDigit && flagUppercase && flagLowercase) {
                flag = true;
                System.out.println("Password Success..");
                
            } else
                System.out.println("Fail..");

            return flag;
}
    public boolean isPhoneValid(String moblieNumber) {
    boolean check;
    Pattern p;
    Matcher m;
    
        try {
                if(moblieNumber.charAt(0) == '0'){
                String MobilePattern = "[0-9]{10}";
                p = Pattern.compile(MobilePattern);

                m = p.matcher(moblieNumber);
                check = m.matches();
                return check;
                }
                return false;
        } catch (Exception e) {
            return false;
        }

}

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        agree_checkBox = new javax.swing.JCheckBox();
        city_comBox = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        email_txt = new javax.swing.JTextField();
        phone_txt = new javax.swing.JTextField();
        password_txt = new javax.swing.JPasswordField();
        passwordRepet_txt = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        register_btn = new javax.swing.JButton();
        back_btn = new javax.swing.JButton();
        email_label = new javax.swing.JLabel();
        password_label = new javax.swing.JLabel();
        passwordRepet_label = new javax.swing.JLabel();
        phone_label = new javax.swing.JLabel();
        agree_label = new javax.swing.JLabel();
        password_label2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        fName_txt = new javax.swing.JTextField();
        lName_txt = new javax.swing.JTextField();

        jLabel5.setText("jLabel5");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Email");

        jLabel2.setText("Password");

        jLabel3.setText("Repet Password");

        jLabel4.setText("Phone Number");

        agree_checkBox.setText("i'm agree with the conditions");

        city_comBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tel Aviv", "Hifa", "Eilat", "Bear Shevha","Newe Yamin" }));
        city_comBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                city_comBoxActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 255));
        jLabel6.setText("It Easy To SIGN UP!");

        jLabel7.setText("City");

        register_btn.setText("Register");
        register_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_btnActionPerformed(evt);
            }
        });

        back_btn.setText("Go back");
        back_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_btnActionPerformed(evt);
            }
        });

        jLabel8.setText("First Name");

        jLabel9.setText("Last Name");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(register_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(agree_label)
                        .addComponent(agree_checkBox)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(city_comBox, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(phone_label)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(email_txt)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(passwordRepet_label)
                                            .addComponent(email_label, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(passwordRepet_txt)
                                    .addComponent(fName_txt)
                                    .addComponent(phone_txt, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(61, 61, 61))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(back_btn))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(539, 539, 539))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(password_txt)
                            .addComponent(lName_txt))
                        .addGap(61, 61, 61))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(password_label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(password_label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(email_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(email_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(fName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(lName_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(password_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(password_label, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password_label2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passwordRepet_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordRepet_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(phone_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phone_label)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(city_comBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(agree_checkBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(agree_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back_btn)
                    .addComponent(register_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void city_comBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_city_comBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_city_comBoxActionPerformed

    private void back_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_btnActionPerformed
        new Login();
        this.dispose();
        
    }//GEN-LAST:event_back_btnActionPerformed

    private void register_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register_btnActionPerformed
       boolean ok = false;
        this.detailsValidation();
        System.out.println(detailsValidationOK);
        
    
        
        if(detailsValidationOK)
        {
        
                try {
                    ok = Login.connectionUtil.addNewUser(email_txt.getText() ,fName_txt.getText() ,lName_txt.getText() , this.password ,phone_txt.getText(), city_comBox.getSelectedItem().toString());
                    System.out.println("user register into DataBase? : " + ok);
                } catch (Exception ex) {
                    Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex.getMessage());
                }    

                JOptionPane.showMessageDialog(this, "Welcome " + fName_txt.getText() + " !! " );
                new Login();
                this.dispose();
        
        }
        else
        {
        JOptionPane.showMessageDialog(this, "User alradey exist or anther problem..");
        }
    }//GEN-LAST:event_register_btnActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox agree_checkBox;
    private javax.swing.JLabel agree_label;
    private javax.swing.JButton back_btn;
    private javax.swing.JComboBox<String> city_comBox;
    private javax.swing.JLabel email_label;
    private javax.swing.JTextField email_txt;
    private javax.swing.JTextField fName_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lName_txt;
    private javax.swing.JLabel passwordRepet_label;
    private javax.swing.JPasswordField passwordRepet_txt;
    private javax.swing.JLabel password_label;
    private javax.swing.JLabel password_label2;
    private javax.swing.JPasswordField password_txt;
    private javax.swing.JLabel phone_label;
    private javax.swing.JTextField phone_txt;
    private javax.swing.JButton register_btn;
    // End of variables declaration//GEN-END:variables
}
