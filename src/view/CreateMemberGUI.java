package view;

import Application.DateHandler;
import database.MemberConnection;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import Bricks.City;
import Bricks.Member;
import Bricks.Membership;
import Bricks.Perk;
import javax.swing.JCheckBox;

/**
 *
 * @author Mikkel, Eric, Charlie & Pelle
 */
public class CreateMemberGUI extends javax.swing.JPanel {

    /**
     * Creates new form CreateNewMember
     */
    String path;
    GUI gui;
    BufferedImage img = null;
    MemberConnection memberConnection = new MemberConnection();
    DateHandler dateHandler = new DateHandler();

    /**
     * Constructor 
     * @param gui
     */
    public CreateMemberGUI(GUI gui) {
        initComponents();
        this.gui = gui;
        fromDateTF.setText(dateHandler.getCurrentDate());
    }
    
    private void addSelectedPerks(ArrayList perkList) {
    
        if(poolsCB.isSelected()) {
            perkList.add(memberConnection.getPerk(1));
        }
        if(groupTrainingCB.isSelected()) {
            perkList.add(memberConnection.getPerk(2));
        }
        if(timeLimitCB.isSelected()) {
            perkList.add(memberConnection.getPerk(3));
        }
    }
    /**
     *  This method puts city and municipal in cityTF and muncipalTF after user
     *  has inserted postelcode in postalCodeTF
     */
    private void fillCity() {
    
            if(postalCodeTF.getText().length() == 4){
            City city = memberConnection.getCity(postalCodeTF.getText());
            cityTF.setText(city.getCity().replaceAll("_", " "));
            municipalTF.setText(city.getMunicipal().replaceAll("_", " "));
        }
    }

    /**
     * sets MembershipPanel Ediable to False
     */
    private void setMembershipPanelEdiableFalse() {
    
            accountNrTF.setEditable(false);
            fromDateTF.setEditable(false);
            groupTrainingCB.setEnabled(false);
            monthPayTF.setEditable(false);
            pbsDateTF.setEditable(false);
            pbsNumberTF.setEditable(false);
            regNrTF.setEditable(false);
            balanceTF.setEditable(false);
            poolsCB.setEnabled(false);
            timeLimitCB.setEnabled(false);
            endDateTF.setEditable(false);
            membershipDropD.setEnabled(false);
    }

    /**
     * sets MembershipPanel Ediable to True
     */
    private void setMembershipPanelEditableTrue() {
    
            accountNrTF.setEditable(true);
            fromDateTF.setEditable(true);
            groupTrainingCB.setEnabled(true);
            monthPayTF.setEditable(true);
            pbsDateTF.setEditable(true);
            pbsNumberTF.setEditable(true);
            regNrTF.setEditable(true);
            balanceTF.setEditable(true);
            poolsCB.setEnabled(true);
            timeLimitCB.setEnabled(true);
            endDateTF.setEditable(true);
            membershipDropD.setEnabled(true);
    }

    /**
     * sets MemberInformationPanel Editable to False
     */
    private void setMemberInformationPanelEditableFalse() {
    
            fNameTF.setEditable(false);
            lNameTF.setEditable(false);
            cprTF.setEditable(false);
            cityTF.setEditable(false);
            adressTF.setEditable(false);
            emailTF.setEditable(false);
            memberIdTF.setEditable(false);
            fNameTF.setEditable(false);
            phoneTF.setEditable(false);
            postalCodeTF.setEditable(false);
            adressNrTF.setEditable(false);
            changePictureBTN.setEnabled(false);
    }

    /**
     * sets MemberInformationPanel Editable to True
     */
    private void setMemberInformationPanelEditableTrue() {
    
            fNameTF.setEditable(true);
            lNameTF.setEditable(true);
            cprTF.setEditable(true);
            cityTF.setEditable(true);
            adressTF.setEditable(true);
            emailTF.setEditable(true);
            memberIdTF.setEditable(true);
            fNameTF.setEditable(true);
            phoneTF.setEditable(true);
            postalCodeTF.setEditable(true);
            adressNrTF.setEditable(true);
            changePictureBTN.setEnabled(true);
    }

    /**
     * sets totalprice
     */
    private void setTotalPrice() {
    
            
            int days = dateHandler.getDaysBetweenDates(fromDateTF.getText(), endDateTF.getText());
            totalPriceTF.setText("0");
            poolsCB.setSelected(false);
            groupTrainingCB.setSelected(false);
            timeLimitCB.setSelected(false);
            Membership membership = (Membership)membershipDropD.getSelectedItem();
            double price = membership.getPricePerDay() * days;
            totalPriceTF.setText(""+(int)price);
    }

    /**
     * sets ToDate
     */
    private void setToDate() {
    
       Membership membership = (Membership)membershipDropD.getSelectedItem();
       endDateTF.setText("" + dateHandler.getFutureDate(membership.getDuration())); 
    }
    
    /**
     * sets PerkPrice
     * @param perkID
     * @param cb
     */
    private void setPerkPrice(int perkID, JCheckBox cb)
    {
        int days = dateHandler.getDaysBetweenDates(fromDateTF.getText(), endDateTF.getText());
        double totalPrice = Double.parseDouble(totalPriceTF.getText());
        Perk perk = memberConnection.getPerk(perkID);
        double perkPrice = perk.getPrice();
            
        if(cb.isSelected()){
            totalPrice += perkPrice*days;
            totalPriceTF.setText(""+totalPrice);
        } else if (!cb.isSelected()) {
            totalPrice -= perkPrice*days;
            totalPriceTF.setText(""+totalPrice);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel4 = new javax.swing.JPanel();
        postalCodeTF = new javax.swing.JTextField();
        memberIdTF = new javax.swing.JTextField();
        lNameTF = new javax.swing.JTextField();
        cprTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        emailTF = new javax.swing.JTextField();
        fNameTF = new javax.swing.JTextField();
        adressNrTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        pictureLabel = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nextButton1 = new javax.swing.JButton();
        cityTF = new javax.swing.JTextField();
        phoneTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        adressTF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        changePictureBTN = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        municipalTF = new javax.swing.JTextField();
        cprPicture = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        balanceTF = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        fromDateTF = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        endDateTF = new javax.swing.JTextField();
        nextButton2 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        totalPriceTF = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        accountNrTF = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        regNrTF = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        pbsDateTF = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        pbsNumberTF = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        monthPayTF = new javax.swing.JTextField();
        membershipDropD = new javax.swing.JComboBox();
        jLabel19 = new javax.swing.JLabel();
        groupTrainingCB = new javax.swing.JCheckBox();
        timeLimitCB = new javax.swing.JCheckBox();
        poolsCB = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        doneButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        commentBox = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();

        setForeground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1007, 462));
        setLayout(new java.awt.GridBagLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        postalCodeTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                postalCodeTFKeyReleased(evt);
            }
        });

        memberIdTF.setEditable(false);

        cprTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cprTFKeyReleased(evt);
            }
        });

        jLabel4.setText("Efternavn");

        jLabel5.setText("CPR-nummer");

        jLabel9.setText("Email");

        jLabel6.setText("Adresse");

        pictureLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/anonymousoi0.jpg"))); // NOI18N

        jLabel11.setText("By");

        jLabel2.setText("Medlemsnummer");

        nextButton1.setText("Næste");
        nextButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nextButton1MouseReleased(evt);
            }
        });

        cityTF.setEditable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Personalia");

        jLabel3.setText("Fornavn");

        jLabel10.setText("Postnummer");

        jLabel7.setText("Telefonnummer");

        jLabel8.setText("Nr.");

        changePictureBTN.setText("Ret billede");
        changePictureBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                changePictureBTNMouseReleased(evt);
            }
        });

        jLabel12.setText("Kommune");

        municipalTF.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(nextButton1)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel12)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cprTF)
                        .addComponent(lNameTF)
                        .addComponent(jLabel3)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(fNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(memberIdTF, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(municipalTF, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addComponent(postalCodeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cityTF))
                        .addComponent(phoneTF, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(emailTF, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(adressTF, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(adressNrTF)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(0, 62, Short.MAX_VALUE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(changePictureBTN)
                    .addComponent(cprPicture))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(changePictureBTN)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(2, 2, 2)
                        .addComponent(memberIdTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addGap(3, 3, 3)
                        .addComponent(fNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cprTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cprPicture))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(adressTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adressNrTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(emailTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(phoneTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cityTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(postalCodeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(municipalTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addComponent(nextButton1)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 78;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 10, 0, 0);
        add(jPanel4, gridBagConstraints);

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Medlemsskab");

        jLabel15.setText("Saldo");

        balanceTF.setEditable(false);

        jLabel16.setText("Fra");

        fromDateTF.setEditable(false);
        fromDateTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fromDateTFKeyReleased(evt);
            }
        });

        jLabel17.setText("-");

        endDateTF.setEditable(false);
        endDateTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                endDateTFKeyReleased(evt);
            }
        });

        nextButton2.setText("Betal");
        nextButton2.setEnabled(false);
        nextButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                nextButton2MouseReleased(evt);
            }
        });

        jLabel18.setText("Totalpris");

        totalPriceTF.setEditable(false);

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("PBS");

        jLabel21.setText("Kontonummer");

        accountNrTF.setEditable(false);

        jLabel22.setText("Reg. Nr.");

        regNrTF.setEditable(false);

        jLabel23.setText("Aftaledato");

        pbsDateTF.setEditable(false);

        jLabel24.setText("PBS-aftalenummer");

        pbsNumberTF.setEditable(false);

        jLabel25.setText("Beløb/måned:");

        monthPayTF.setEditable(false);

        membershipDropD.setModel(new DefaultComboBoxModel(memberConnection.getMembershipList().toArray()));
        membershipDropD.setEnabled(false);
        membershipDropD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateMemberGUI.this.actionPerformed(evt);
            }
        });

        jLabel19.setText("Vælg medlemskab");

        groupTrainingCB.setText("Holdtræning");
        groupTrainingCB.setEnabled(false);
        groupTrainingCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                groupTrainingCBActionPerformed(evt);
            }
        });

        timeLimitCB.setText("Tidsbegrændset");
        timeLimitCB.setEnabled(false);
        timeLimitCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeLimitCBActionPerformed(evt);
            }
        });

        poolsCB.setText("Svømmehal");
        poolsCB.setEnabled(false);
        poolsCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poolsCBActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel22)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel24)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(regNrTF, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                                    .addComponent(accountNrTF))
                                                .addComponent(jLabel21))
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel5Layout.createSequentialGroup()
                                                    .addGap(49, 49, 49)
                                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel23)
                                                        .addComponent(pbsDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                                    .addGap(15, 15, 15)
                                                    .addComponent(pbsNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(monthPayTF, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel15)
                                        .addComponent(balanceTF))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(totalPriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nextButton2)))
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(groupTrainingCB)
                            .addComponent(poolsCB)
                            .addComponent(timeLimitCB)
                            .addComponent(membershipDropD, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel16)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(fromDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(endDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 54, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(balanceTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(membershipDropD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fromDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(endDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(poolsCB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(groupTrainingCB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeLimitCB)
                .addGap(7, 7, 7)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jLabel23))
                .addGap(8, 8, 8)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(regNrTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pbsDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(accountNrTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pbsNumberTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(monthPayTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(totalPriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextButton2))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 41;
        gridBagConstraints.ipady = 106;
        gridBagConstraints.insets = new java.awt.Insets(8, 6, 0, 0);
        add(jPanel5, gridBagConstraints);

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        doneButton.setText("Færdig");
        doneButton.setEnabled(false);
        doneButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                doneButtonMouseReleased(evt);
            }
        });

        commentBox.setColumns(20);
        commentBox.setRows(5);
        jScrollPane1.setViewportView(commentBox);

        jLabel13.setText("Kommentarer");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(doneButton))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 397, Short.MAX_VALUE)
                .addComponent(doneButton)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 204;
        gridBagConstraints.ipady = 391;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(8, 6, 0, 0);
        add(jPanel6, gridBagConstraints);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        add(jPanel1, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        add(jPanel2, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents

    private void nextButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButton1MouseReleased
        if(fNameTF.isEditable())
        {
            // set fields to uneditable
            setMemberInformationPanelEditableFalse();
            nextButton1.setText("Ret");
            nextButton2.setEnabled(true);
            
            // set next fields to editable.
            setMembershipPanelEditableTrue();
        }
        else
        {
            
            // set current fields editable
            setMemberInformationPanelEditableTrue();
            nextButton1.setText("Næste");
            nextButton2.setEnabled(false);
            
            // set next panel's fields uneditable
            setMembershipPanelEdiableFalse();
        }
    }//GEN-LAST:event_nextButton1MouseReleased

    private void changePictureBTNMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePictureBTNMouseReleased
        File file;
        
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle("Vælg et billede");
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setAcceptAllFileFilterUsed(true);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
        } else {
            System.out.println("No Selection ");
            file = chooser.getSelectedFile();
        }

        path = file.getAbsolutePath();
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException ex) {
            Logger.getLogger(CreateMemberGUI.class.getName()).log(Level.SEVERE, null, ex);
        }

        img = pictureConvert.resizeImage(img, img.TYPE_INT_RGB);
       
        
        File f = new File("C:\\junkPics\\"+(memberConnection.getNewestMemberID()+1)+".jpg");
        try {
            ImageIO.write(img, "jpg", f);
        } catch (IOException ex) {
            Logger.getLogger(CreateMemberGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        path = f.getAbsolutePath();
        
        pictureLabel.setIcon(new ImageIcon(img));
    }//GEN-LAST:event_changePictureBTNMouseReleased

    private void nextButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextButton2MouseReleased

        if(accountNrTF.isEditable())
        {
            setMembershipPanelEdiableFalse();
            nextButton2.setText("Ret");
            doneButton.setEnabled(true);
            PaymentGUI paymentWindow = new PaymentGUI(this);
            paymentWindow.setVisible(true);
            
        }
        else
        {
            setMembershipPanelEditableTrue();
            doneButton.setEnabled(false);
            nextButton2.setText("Næste");
            totalPriceTF.setText("");
        }
        
        
    }//GEN-LAST:event_nextButton2MouseReleased

    private void doneButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doneButtonMouseReleased
        

        // make sure that the balance is an int before passing it to the constructor.
        
        
        
        double balance;
        if(!balanceTF.getText().equals(""))
        {
            balance = Double.parseDouble(balanceTF.getText());
        }
        else
        {
            balance = 0;
        }

        // create a city object to pass to the member constructor.
        City city = new City(postalCodeTF.getText(), cityTF.getText(), municipalTF.getText());
       
        //Create a perkList to use in the creation of a member.
        ArrayList<Perk> perkList = new ArrayList();
        
        addSelectedPerks(perkList);
        
        // get membership for use in the creation of a member.
        Membership membership = (Membership) membershipDropD.getSelectedItem();
        
        
        // create a member object to pass to the database.
        Member member = new Member(cprTF.getText(), fNameTF.getText(), lNameTF.getText(), adressTF.getText(),
            adressNrTF.getText(), emailTF.getText(), phoneTF.getText(), city,
            balance, commentBox.getText(), dateHandler.convertDateFormatToAmerican(fromDateTF.getText()), dateHandler.convertDateFormatToAmerican(endDateTF.getText()) , accountNrTF.getText()
            ,regNrTF.getText(), membership, path,  perkList);
        
        try {
            
            memberConnection.createMember(member);
            gui.backPanel.removeAll();
            gui.backPanel.add(new MemberScreenGUI(gui));
            gui.backPanel.repaint();
            gui.searchMemberID(memberConnection.getNewestMemberID());
            
        } catch (SQLException ex) {
            Logger.getLogger(CreateMemberGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_doneButtonMouseReleased

    private void actionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actionPerformed
        // TODO add your handling code here:
        
        if(!(membershipDropD.getSelectedItem() == null))
        {
            setToDate();
            setTotalPrice();
        }
    }//GEN-LAST:event_actionPerformed

    private void poolsCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poolsCBActionPerformed
        setPerkPrice(1, poolsCB);
    }//GEN-LAST:event_poolsCBActionPerformed

    private void groupTrainingCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupTrainingCBActionPerformed
        setPerkPrice(2, groupTrainingCB);
    }//GEN-LAST:event_groupTrainingCBActionPerformed

    private void timeLimitCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeLimitCBActionPerformed
        setPerkPrice(3, timeLimitCB);
    }//GEN-LAST:event_timeLimitCBActionPerformed

    private void postalCodeTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_postalCodeTFKeyReleased
        
        try {
        fillCity();
        } catch(Exception ex) {
            System.err.println(ex);
        }
    }//GEN-LAST:event_postalCodeTFKeyReleased

    private void cprTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cprTFKeyReleased
        if(CprValidate.validateCpr(cprTF.getText()))
        {
            cprPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/cprApproved.png")));
            //Check if member exists
            int memberid = memberConnection.memberExist(cprTF.getText());
            
            if(memberid != -1) {
                
                int result = JOptionPane.showOptionDialog(null, "Medlemet er allerede oprettet klik YES for at gå til profilen", "Medlem Eksisterer",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                //if user press yes we create a new memberscreen and fill in the member information in the memberscreen
                if(result == JOptionPane.YES_OPTION) {
                
                    MemberScreenGUI memberScreen = new MemberScreenGUI(gui);
                    memberScreen.setMemberDetails(memberConnection.searchMemberID(memberid));
                    gui.backPanel.removeAll();
                    gui.backPanel.add(memberScreen);
                    gui.repaint();
                    gui.setVisible(true);
                }
            }
        }
        else
        {
            cprPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/cprNotValidated.png")));
        }
    }//GEN-LAST:event_cprTFKeyReleased

    private void fromDateTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fromDateTFKeyReleased
       
        try {
        setToDate();    
        setTotalPrice();
        }catch(java.lang.NumberFormatException ex) {
        
        }
    }//GEN-LAST:event_fromDateTFKeyReleased

    private void endDateTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_endDateTFKeyReleased
        
        try {
        setTotalPrice();
        }catch(java.lang.NumberFormatException ex) {
        
        }
    }//GEN-LAST:event_endDateTFKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountNrTF;
    private javax.swing.JTextField adressNrTF;
    private javax.swing.JTextField adressTF;
    public javax.swing.JTextField balanceTF;
    private javax.swing.JButton changePictureBTN;
    private javax.swing.JTextField cityTF;
    private javax.swing.JTextArea commentBox;
    private javax.swing.JLabel cprPicture;
    private javax.swing.JTextField cprTF;
    private javax.swing.JButton doneButton;
    private javax.swing.JTextField emailTF;
    private javax.swing.JTextField endDateTF;
    private javax.swing.JTextField fNameTF;
    private javax.swing.JTextField fromDateTF;
    private javax.swing.JCheckBox groupTrainingCB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lNameTF;
    private javax.swing.JTextField memberIdTF;
    private javax.swing.JComboBox membershipDropD;
    private javax.swing.JTextField monthPayTF;
    private javax.swing.JTextField municipalTF;
    private javax.swing.JButton nextButton1;
    private javax.swing.JButton nextButton2;
    private javax.swing.JTextField pbsDateTF;
    private javax.swing.JTextField pbsNumberTF;
    private javax.swing.JTextField phoneTF;
    private javax.swing.JLabel pictureLabel;
    private javax.swing.JCheckBox poolsCB;
    private javax.swing.JTextField postalCodeTF;
    private javax.swing.JTextField regNrTF;
    private javax.swing.JCheckBox timeLimitCB;
    public javax.swing.JTextField totalPriceTF;
    // End of variables declaration//GEN-END:variables
}
