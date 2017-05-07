package view;

import Bricks.City;
import Bricks.Instructor;
import Bricks.User;
import database.InstructorConnection;
import database.MemberConnection;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Pelle
 */
public class InstructorGUI extends javax.swing.JPanel {

    /**
     * Creates new form AdminGUI
     */
    private MemberConnection memberConnection;
    private InstructorConnection instructorConnection;
    private Instructor searchedInstructor;
   
    /**
     * Constructor
     */
    public InstructorGUI() {
        initComponents();
        setEditableFalse();
        
    }
    
    /**
     *  This method puts city and municipal in cityTF and muncipalTF after user
     *  has inserted postelcode in postalCodeTF
     */
    private void fillCity() {
    
        memberConnection = new MemberConnection();      
        if(postalcodeTF.getText().length() == 4){
            
            City city = memberConnection.getCity(postalcodeTF.getText());
            cityTF.setText(city.getCity().replaceAll("_", " "));
        }
    }
    private String getStringPassword() {
    
        return new String(passwordTF.getPassword());
    }
    private void wrongPassword() {
    
        JOptionPane.showMessageDialog(null, "Password stemmer ikke overens med gentaget password ",
              "Forkert password", JOptionPane.OK_OPTION);
    }
    private void updateInstructorValues() {
    
        if(!fNameTF.getText().equals(searchedInstructor.getfName())) {
            searchedInstructor.setfName(fNameTF.getText());
        }
        if(!lNameTF.getText().equals(searchedInstructor.getlName())) {
            searchedInstructor.setlName(lNameTF.getText());
        }
        if(!cprTF.getText().equals(searchedInstructor.getCPR())) {
            searchedInstructor.setCPR(cprTF.getText());
        }
        if(!streetNameTF.getText().equals(searchedInstructor.getStreetName())) {
            searchedInstructor.setStreetName(streetNameTF.getText());
        }
        if(!streetNumberTF.getText().equals(searchedInstructor.getStreetNumber())) {
            searchedInstructor.setStreetNumber(streetNumberTF.getText());
        }
        if(!emailTF.getText().equals(searchedInstructor.getEmail())) {
            searchedInstructor.setEmail(emailTF.getText());
        }
        if(!phonenumberTF.getText().equals(searchedInstructor.getPhoneNumber())) {
            searchedInstructor.setPhoneNumber(phonenumberTF.getText());
        }
        if(!postalcodeTF.getText().equals(searchedInstructor.getCity().getPostelCode())) {
            searchedInstructor.getCity().setPostelCode(postalcodeTF.getText());
        }
        if(!usernameTF.getText().equals(searchedInstructor.getUser().getUsername())) {
            searchedInstructor.getUser().setUsername(usernameTF.getText());
        }
        //MD5 password and check with current 
        if(checkPasswords()) {
            MessageDigest m;
            try {
                // Kode taget fra: http://stackoverflow.com/questions/415953/how-can-i-generate-an-md5-hash 01/12-14
                m = MessageDigest.getInstance("MD5");
                m.update(getStringPassword().getBytes(),0,getStringPassword().length());
                String cryptetPassword = new BigInteger(1,m.digest()).toString(16);

           if(!cryptetPassword.equals(searchedInstructor.getUser().getPassword())) {
                searchedInstructor.getUser().setPassword(getStringPassword());
            }

            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(InstructorGUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
                
        
    }
    private boolean checkPasswords() {
    
        String password = new String(passwordTF.getPassword());
        String repeatedPassword = new String(repeatPasswordTF.getPassword());
        
        if(password.equals(repeatedPassword)) {
            return true;
        }
        return false;
    }
    private void clearTextFields() {
        
        searchTF.setText("");
        instructorIDTF.setText("");
        fNameTF.setText("");
        lNameTF.setText("");
        cprTF.setText("");
        streetNameTF.setText("");
        streetNumberTF.setText("");
        emailTF.setText("");
        phonenumberTF.setText("");
        postalcodeTF.setText("");
        usernameTF.setText("");
        passwordTF.setText("");
        repeatPasswordTF.setText("");
    }
    private void setEditableFalse() {
    
        fNameTF.setEditable(false);
        lNameTF.setEditable(false);
        cprTF.setEditable(false);
        streetNameTF.setEditable(false);
        streetNumberTF.setEditable(false);
        emailTF.setEditable(false);
        phonenumberTF.setEditable(false);
        postalcodeTF.setEditable(false);
        usernameTF.setEditable(false);
        passwordTF.setEditable(false);
        repeatPasswordTF.setEditable(false);
    }
    private void setEditableTrue() {
    
        fNameTF.setEditable(true);
        lNameTF.setEditable(true);
        cprTF.setEditable(true);
        streetNameTF.setEditable(true);
        streetNumberTF.setEditable(true);
        emailTF.setEditable(true);
        phonenumberTF.setEditable(true);
        postalcodeTF.setEditable(true);
        usernameTF.setEditable(true);
        passwordTF.setEditable(true);
        repeatPasswordTF.setEditable(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        createInstructorJP = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        instructorIDTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fNameTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lNameTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cprTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        streetNameTF = new javax.swing.JTextField();
        streetNumberTF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        emailTF = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        phonenumberTF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        postalcodeTF = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cityTF = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        usernameTF = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        passwordTF = new javax.swing.JPasswordField();
        jLabel14 = new javax.swing.JLabel();
        repeatPasswordTF = new javax.swing.JPasswordField();
        editCreateInstructorBTN = new javax.swing.JButton();
        editInstructorBTN = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        searchTF = new javax.swing.JTextField();
        deleteInstructorBTN = new javax.swing.JButton();

        setLayout(new java.awt.GridBagLayout());

        createInstructorJP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Instruktør");

        jLabel2.setText("Instruktørnummer");

        instructorIDTF.setEditable(false);

        jLabel3.setText("Fornavn");

        jLabel4.setText("Efternavn");

        jLabel5.setText("CPR-nummer");

        jLabel6.setText("Adresse");

        jLabel7.setText("Nr.");

        jLabel8.setText("Email");

        jLabel9.setText("Telefonnummer");

        jLabel10.setText("Postnummer");

        postalcodeTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                postalcodeTFKeyReleased(evt);
            }
        });

        jLabel11.setText("By");

        cityTF.setEditable(false);

        jLabel12.setText("Brugernavn");

        jLabel13.setText("Password");

        jLabel14.setText("Gentag password");

        editCreateInstructorBTN.setText("Ny Instruktør");
        editCreateInstructorBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCreateInstructorBTNActionPerformed(evt);
            }
        });

        editInstructorBTN.setText("Ret");
        editInstructorBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editInstructorBTNActionPerformed(evt);
            }
        });

        jLabel15.setText("Søg Instruktør");

        searchTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTFActionPerformed(evt);
            }
        });

        deleteInstructorBTN.setText("Slet");
        deleteInstructorBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteInstructorBTNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout createInstructorJPLayout = new javax.swing.GroupLayout(createInstructorJP);
        createInstructorJP.setLayout(createInstructorJPLayout);
        createInstructorJPLayout.setHorizontalGroup(
            createInstructorJPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createInstructorJPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(createInstructorJPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameTF)
                    .addGroup(createInstructorJPLayout.createSequentialGroup()
                        .addGroup(createInstructorJPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(createInstructorJPLayout.createSequentialGroup()
                                .addComponent(editCreateInstructorBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(editInstructorBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteInstructorBTN, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                    .addComponent(phonenumberTF)
                    .addComponent(emailTF)
                    .addGroup(createInstructorJPLayout.createSequentialGroup()
                        .addGroup(createInstructorJPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(instructorIDTF, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(createInstructorJPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(searchTF)))
                    .addComponent(fNameTF)
                    .addComponent(lNameTF)
                    .addComponent(cprTF)
                    .addComponent(passwordTF, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(repeatPasswordTF, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, createInstructorJPLayout.createSequentialGroup()
                        .addGroup(createInstructorJPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(streetNameTF))
                        .addGap(18, 18, 18)
                        .addGroup(createInstructorJPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(streetNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(createInstructorJPLayout.createSequentialGroup()
                        .addGroup(createInstructorJPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(createInstructorJPLayout.createSequentialGroup()
                        .addGroup(createInstructorJPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(postalcodeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(createInstructorJPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(cityTF))))
                .addContainerGap())
        );
        createInstructorJPLayout.setVerticalGroup(
            createInstructorJPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(createInstructorJPLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(createInstructorJPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(createInstructorJPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(instructorIDTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cprTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(createInstructorJPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(createInstructorJPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(streetNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(streetNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(phonenumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(createInstructorJPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(createInstructorJPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(postalcodeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cityTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addGap(1, 1, 1)
                .addComponent(passwordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(repeatPasswordTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(createInstructorJPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editCreateInstructorBTN)
                    .addComponent(editInstructorBTN)
                    .addComponent(deleteInstructorBTN))
                .addGap(0, 0, 0))
        );

        add(createInstructorJP, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents

    private void postalcodeTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_postalcodeTFKeyReleased
        fillCity();
    }//GEN-LAST:event_postalcodeTFKeyReleased

    private void editCreateInstructorBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCreateInstructorBTNActionPerformed
        City city;
        User user = null;
        if(editCreateInstructorBTN.getText().equalsIgnoreCase("ny instruktør")) {
        
        setEditableTrue();
        clearTextFields();
        editCreateInstructorBTN.setText("Færdig");
        editInstructorBTN.setText("Ret");
        }
        else if (editCreateInstructorBTN.getText().equalsIgnoreCase("Færdig")) {
        
        city = new City(postalcodeTF.getText(), cityTF.getText(), null);
                    
            if(!checkPasswords()) {
            
               wrongPassword();
                
            }
            else {
            String pass = new String(passwordTF.getPassword());
                user = new User(0, usernameTF.getText(), pass );
            }
            
            Instructor instructor = new Instructor(cprTF.getText(), fNameTF.getText(), lNameTF.getText(), streetNameTF.getText()
            , streetNumberTF.getText(),emailTF.getText(), phonenumberTF.getText(), city, 0, user);
            
            instructorConnection = new InstructorConnection();
            try {
                instructorConnection.createInstructor(instructor);
            } catch (SQLException ex) {
                Logger.getLogger(InstructorGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            editCreateInstructorBTN.setText("Ny Instruktør");
            editInstructorBTN.setText("Ret");
            instructorIDTF.setText("" + instructorConnection.getNewestInstructorID());
            setEditableFalse();
            
            //confirm 
                JOptionPane.showMessageDialog(null, "Instruktør " + instructor.getfName() + " " + instructor.getlName() + " oprettet",
              "Instruktør oprettet", JOptionPane.INFORMATION_MESSAGE );
        }

        
    }//GEN-LAST:event_editCreateInstructorBTNActionPerformed

    private void editInstructorBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editInstructorBTNActionPerformed
       
        if(editInstructorBTN.getText().equalsIgnoreCase("ret")) {
        
            setEditableTrue();
            editInstructorBTN.setText("Gem");
            editCreateInstructorBTN.setText("Ny Instruktør");
        }
        else if(editInstructorBTN.getText().equalsIgnoreCase("gem")) {
        
            if(checkPasswords() && getStringPassword().length() < 32) {
                
                setEditableFalse();
                editInstructorBTN.setText("Ret");
                editCreateInstructorBTN.setText("Ny Instruktør");
                updateInstructorValues();
                instructorConnection.editInstructor(searchedInstructor);
            }
            else
                 JOptionPane.showMessageDialog(null, "Passwords stemmer ikke overens eller det er for langt");
            
            
        }
      
    }//GEN-LAST:event_editInstructorBTNActionPerformed

    private void searchTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTFActionPerformed
        
        instructorConnection = new InstructorConnection();
        
        try {
            searchedInstructor = instructorConnection.searchInstructorID(Integer.parseInt(searchTF.getText()));
            instructorIDTF.setText("" + searchedInstructor.getInstructorID());
            fNameTF.setText(searchedInstructor.getfName());
            lNameTF.setText(searchedInstructor.getlName());
            cprTF.setText(searchedInstructor.getCPR());
            streetNameTF.setText(searchedInstructor.getStreetName());
            streetNumberTF.setText(searchedInstructor.getStreetNumber());
            emailTF.setText(searchedInstructor.getEmail());
            phonenumberTF.setText(searchedInstructor.getPhoneNumber());
            postalcodeTF.setText(searchedInstructor.getCity().getPostelCode());
            usernameTF.setText(searchedInstructor.getUser().getUsername());
            passwordTF.setText(searchedInstructor.getUser().getPassword());
            repeatPasswordTF.setText(searchedInstructor.getUser().getPassword());
            
            editCreateInstructorBTN.setText("Ny Instruktør");
            editInstructorBTN.setText("Ret");
            setEditableFalse();
        } catch (Exception ex) {
            Logger.getLogger(InstructorGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_searchTFActionPerformed

    private void deleteInstructorBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteInstructorBTNActionPerformed
        
            int result = JOptionPane.showOptionDialog(null, "Er du sikker på at du vil slette instruktør: " + searchedInstructor.print(), "Slet Instruktør",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            
            if(result == JOptionPane.YES_OPTION) {
                try {
                    instructorConnection.removeInstructor(searchedInstructor.getInstructorID());
                } catch (SQLException ex) {
                    Logger.getLogger(InstructorGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
                clearTextFields();
            }
        
    }//GEN-LAST:event_deleteInstructorBTNActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cityTF;
    private javax.swing.JTextField cprTF;
    private javax.swing.JPanel createInstructorJP;
    private javax.swing.JButton deleteInstructorBTN;
    private javax.swing.JButton editCreateInstructorBTN;
    private javax.swing.JButton editInstructorBTN;
    private javax.swing.JTextField emailTF;
    private javax.swing.JTextField fNameTF;
    private javax.swing.JTextField instructorIDTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lNameTF;
    private javax.swing.JPasswordField passwordTF;
    private javax.swing.JTextField phonenumberTF;
    private javax.swing.JTextField postalcodeTF;
    private javax.swing.JPasswordField repeatPasswordTF;
    private javax.swing.JTextField searchTF;
    private javax.swing.JTextField streetNameTF;
    private javax.swing.JTextField streetNumberTF;
    private javax.swing.JTextField usernameTF;
    // End of variables declaration//GEN-END:variables
}
