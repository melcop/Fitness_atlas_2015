package view;
import Application.DateHandler;
import Bricks.City;
import Bricks.Member;
import Bricks.Membership;
import Bricks.Perk;
import Bricks.Team;
import database.MemberConnection;
import database.TeamConnection;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;

/**
 *
 * @author mikkel
 */
public class MemberScreenGUI extends javax.swing.JPanel {
    /**
     * Creates new form NewJPanel
     */
    DateHandler dateHandler = new DateHandler();
    MemberConnection memberConnection = new MemberConnection();
    GUI gui;

    /**
     * Contructor
     * @param gui
     */
    public MemberScreenGUI(GUI gui) {
        initComponents();
        this.gui = gui;
    }
    
    // is used in GUI.java for determining if the updateButton should be enabled or disabled.

    /**
     * sets Update Enabled
     */
        public void setUpdateEnabled()
    {
        if(memberIdTF.getText().equals(""))
        {
            updateButton.setEnabled(false);
        }
        else
        {
            updateButton.setEnabled(true);
        }
    }
    // is used in GUI.java for determining if the refreshMembershipButton should be enabled or disabled.

    /**
     * sets RefreshButton Enabled
     */
        public void setRefreshButtonEnabled()
    {
        if(memberIdTF.getText().equals(""))
        {
            refreshMembership.setEnabled(false);
        }
        else
        {
            refreshMembership.setEnabled(true);
        }
    }
    
    private void updateMemberValues(Member searchedMember)
    {
        

         if(!fNameTF.getText().equalsIgnoreCase(searchedMember.getfName())) {
            searchedMember.setfName(fNameTF.getText());
        }
        if(!lNameTF.getText().equalsIgnoreCase(searchedMember.getlName())) {
            searchedMember.setlName(lNameTF.getText());
        }
        if(!cprTF.getText().equalsIgnoreCase(searchedMember.getCPR())) {
            searchedMember.setCPR(cprTF.getText());
        }
        if(!adressTF.getText().equalsIgnoreCase(searchedMember.getStreetName())) {
            searchedMember.setStreetName(adressTF.getText());
        }
        if(!adressNrTF.getText().equalsIgnoreCase(searchedMember.getStreetNumber())) {
            searchedMember.setStreetNumber(adressNrTF.getText());
        }
        if(!emailTF.getText().equalsIgnoreCase(searchedMember.getEmail())) {
            searchedMember.setEmail(emailTF.getText());
        }
        if(!phoneTF.getText().equalsIgnoreCase(searchedMember.getPhoneNumber())) {
            searchedMember.setPhoneNumber(phoneTF.getText());
        }
        if(!postalCodeTF.getText().equalsIgnoreCase(searchedMember.getCity().getPostelCode())) {
            searchedMember.getCity().setPostelCode(postalCodeTF.getText());
        }
        if(!regNrTF.getText().equalsIgnoreCase(searchedMember.getRegistration())) {
            searchedMember.setRegistration(regNrTF.getText());
        }
        if(!accountNrTF.getText().equalsIgnoreCase(searchedMember.getAccountNumber())) {
            searchedMember.setAccountNumber(accountNrTF.getText());
        }
        if(!commentBox.getText().equalsIgnoreCase(searchedMember.getComment())) {
            searchedMember.setComment(commentBox.getText());
        }
        // set the balance should always be updated.
        searchedMember.setBalance(Double.parseDouble(balanceTF.getText()));
    }

    /**
     * sets TotalPrice
     */
    public void setTotalPrice() {
    
            
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
    public void setToDate() {
    
       Membership membership = (Membership)membershipDropD.getSelectedItem();
       // endDateTF should be a earuopean dateformat,setMemberFromDatePlusX takes a american date format and a (int) number of days to add to the american format date.
       //this long line of code just sets the textfield to a european date format + the membership duration from the current enddate from the member.
       endDateTF.setText(dateHandler.convertDateFormatToEuropean(dateHandler.setFromDatePlusX(dateHandler.convertDateFormatToAmerican(fromDateTF.getText()), membership.getDuration())));

    }
    
    // this method sets the perks prices to the correct amount, depending on how many days the memberships duration is.

    /**
     * sets PerkPrice
     * @param perkID
     * @param cb
     */
        public void setPerkPrice(int perkID, JCheckBox cb)
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

        jPanel5 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        balanceTF = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        fromDateTF = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        endDateTF = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        totalPriceTF = new javax.swing.JTextField();
        database.MemberConnection memberConnection = new database.MemberConnection();
        membershipDropD = new javax.swing.JComboBox();
        poolsCB = new javax.swing.JCheckBox();
        groupTrainingCB = new javax.swing.JCheckBox();
        timeLimitCB = new javax.swing.JCheckBox();
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
        refreshMembership = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        commentBox = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        teamJList = new javax.swing.JList();
        createMemberButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
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

        setLayout(new java.awt.GridBagLayout());

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

        jLabel18.setText("Totalpris");

        totalPriceTF.setEditable(false);

        membershipDropD.setModel(new DefaultComboBoxModel(memberConnection.getMembershipList().toArray()));
        membershipDropD.setEnabled(false);
        membershipDropD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                membershipDropDActionPerformed(evt);
            }
        });

        poolsCB.setText("Svømmehal");
        poolsCB.setEnabled(false);
        poolsCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poolsCBActionPerformed(evt);
            }
        });

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

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setText("PBS");

        jLabel21.setText("Kontonummer");

        accountNrTF.setEditable(false);
        accountNrTF.setToolTipText("Medlemmets kontonummer");

        jLabel22.setText("Reg. Nr.");

        regNrTF.setEditable(false);
        regNrTF.setToolTipText("Medlemmets registreringsnummer");

        jLabel23.setText("Aftaledato");

        pbsDateTF.setEditable(false);

        jLabel24.setText("PBS-aftalenummer");

        pbsNumberTF.setEditable(false);

        jLabel25.setText("Beløb/måned:");

        monthPayTF.setEditable(false);

        refreshMembership.setText("Forny medlemskab");
        refreshMembership.setToolTipText("Tryk på denne knap for at opdatere/fornye medlemskabet.");
        refreshMembership.setEnabled(false);
        refreshMembership.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshMembershipActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(groupTrainingCB)
                    .addComponent(poolsCB)
                    .addComponent(timeLimitCB)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalPriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(refreshMembership, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel21)
                                            .addComponent(jLabel22)
                                            .addComponent(regNrTF, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                                            .addComponent(accountNrTF))
                                        .addGap(33, 33, 33)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel24)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(pbsNumberTF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel23)
                                                .addComponent(pbsDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel20)
                                        .addGroup(jPanel5Layout.createSequentialGroup()
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel15)
                                                .addComponent(balanceTF)
                                                .addComponent(jLabel16)
                                                .addComponent(fromDateTF))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(endDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(membershipDropD, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 20, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addComponent(jLabel25)
                    .addComponent(monthPayTF, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel14)
                .addGap(17, 17, 17)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(balanceTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fromDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17)
                    .addComponent(endDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(membershipDropD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(poolsCB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(groupTrainingCB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeLimitCB)
                .addGap(10, 10, 10)
                .addComponent(jLabel20)
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel22))
                .addGap(8, 8, 8)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pbsDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(regNrTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(totalPriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshMembership))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 20;
        gridBagConstraints.ipady = 88;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        add(jPanel5, gridBagConstraints);

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        commentBox.setColumns(20);
        commentBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        commentBox.setRows(5);
        commentBox.setEnabled(false);
        jScrollPane1.setViewportView(commentBox);

        jLabel13.setText("Kommentarer");

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Hold");

        teamJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        teamJList.setToolTipText("En liste over hold som medlemmet er tilmeldt");
        jScrollPane2.setViewportView(teamJList);

        createMemberButton.setText("Opret nyt medlem");
        createMemberButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                createMemberButtonMouseReleased(evt);
            }
        });

        updateButton.setText("Ret");
        updateButton.setToolTipText("Tryk på denne knap for at rette personalia");
        updateButton.setEnabled(false);
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGap(0, 173, Short.MAX_VALUE)
                        .addComponent(updateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(createMemberButton))
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel13))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel19)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createMemberButton)
                    .addComponent(updateButton))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 173;
        gridBagConstraints.ipady = 89;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 0);
        add(jPanel6, gridBagConstraints);

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        postalCodeTF.setEditable(false);
        postalCodeTF.setToolTipText("Udfyld postnummer, derved udfyldes by og kommune automatisk.");

        memberIdTF.setEditable(false);
        memberIdTF.setToolTipText("Medlemmets unikke medlemsnummer");

        lNameTF.setEditable(false);

        cprTF.setEditable(false);
        cprTF.setToolTipText("Medlemmets fulde cpr-nummer");

        jLabel4.setText("Efternavn");

        jLabel5.setText("CPR-nummer");

        jLabel9.setText("Email");

        emailTF.setEditable(false);

        fNameTF.setEditable(false);

        adressNrTF.setEditable(false);

        jLabel6.setText("Adresse");

        pictureLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/anonymousoi0.jpg"))); // NOI18N
        pictureLabel.setToolTipText("Medlemmets billede");

        jLabel11.setText("By");

        jLabel2.setText("Medlemsnummer");

        cityTF.setEditable(false);

        phoneTF.setEditable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Personalia");

        jLabel3.setText("Fornavn");

        jLabel10.setText("Postnummer");

        jLabel7.setText("Telefonnummer");

        adressTF.setEditable(false);

        jLabel8.setText("Nr.");

        changePictureBTN.setText("Ret billede");
        changePictureBTN.setToolTipText("Tryk på denne knap for at ændre medlemmets billede.");
        changePictureBTN.setEnabled(false);
        changePictureBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePictureBTNActionPerformed(evt);
            }
        });

        jLabel12.setText("Kommune");

        municipalTF.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addContainerGap(11, Short.MAX_VALUE)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(memberIdTF, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(fNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pictureLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changePictureBTN)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(municipalTF, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(phoneTF)
                                .addComponent(emailTF)
                                .addComponent(jLabel9)
                                .addComponent(jLabel7)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(adressTF, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(adressNrTF)
                                        .addGroup(jPanel4Layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(0, 58, Short.MAX_VALUE)))))
                            .addComponent(jLabel12)
                            .addComponent(cprTF, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                                    .addComponent(postalCodeTF))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cityTF, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(changePictureBTN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pictureLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(memberIdTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
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
                .addComponent(municipalTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 103;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 18, 0, 0);
        add(jPanel4, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    
    private void createMemberButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createMemberButtonMouseReleased
        // TODO add your handling code here:
        CreateMemberGUI newMemberScreen = new CreateMemberGUI(gui);
        
        gui.backPanel.removeAll();
        gui.backPanel.add(newMemberScreen);
        gui.setVisible(true);
        
    }//GEN-LAST:event_createMemberButtonMouseReleased

    private void membershipDropDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_membershipDropDActionPerformed
        
        Member m = memberConnection.searchMemberID(Integer.parseInt(memberIdTF.getText()));
      if(!(membershipDropD.getSelectedItem() == null))
        {
            fromDateTF.setText(dateHandler.setFromDatePlusX(m.getEndDate(), 1));
            setToDate();
            setTotalPrice();
        }
    }//GEN-LAST:event_membershipDropDActionPerformed

    private void poolsCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poolsCBActionPerformed
        setPerkPrice(1, poolsCB);
    }//GEN-LAST:event_poolsCBActionPerformed

    private void groupTrainingCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_groupTrainingCBActionPerformed
        setPerkPrice(2, groupTrainingCB);
    }//GEN-LAST:event_groupTrainingCBActionPerformed

    private void timeLimitCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeLimitCBActionPerformed
        setPerkPrice(3, timeLimitCB);
    }//GEN-LAST:event_timeLimitCBActionPerformed

    private void fromDateTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fromDateTFKeyReleased
        
        try {    
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

    private void changePictureBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePictureBTNActionPerformed
        File file;
        BufferedImage img = null;
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("C:\\Users"));
        chooser.setDialogTitle("Vælg et billede");
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        chooser.setAcceptAllFileFilterUsed(true);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
        } else {
            System.out.println("No Selection ");
            file = chooser.getSelectedFile();
        }

        String path = file.getAbsolutePath();
        try {
            img = ImageIO.read(new File(path));
        } catch (IOException ex) {
         
        }

        img = pictureConvert.resizeImage(img, img.TYPE_INT_RGB);

        pictureLabel.setIcon(new ImageIcon(img));
    }//GEN-LAST:event_changePictureBTNActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
         // when the update button is pressed and released this method will set all the personalia textfields to editable 
        // and when the button is pressed again, it will use the updateMemberValues to check if anything is changed. if anything is changed it will override the members 
        // fields and use the editMember in MemberHandler to push the updates to the database.
        if(!fNameTF.isEditable())
        {
            fNameTF.setEditable(true);
            lNameTF.setEditable(true);
            adressTF.setEditable(true);
            adressNrTF.setEditable(true);
            cprTF.setEditable(true);
            cityTF.setEditable(true);
            emailTF.setEditable(true);
            municipalTF.setEditable(true);
            phoneTF.setEditable(true);
            postalCodeTF.setEditable(true);
            commentBox.setEnabled(true);
            teamJList.setEnabled(true);
            changePictureBTN.setEnabled(true);
            
            updateButton.setText("Gem");
            
            
        }
        else
        {
            fNameTF.setEditable(false);
            lNameTF.setEditable(false);
            adressTF.setEditable(false);
            adressNrTF.setEditable(false);
            cprTF.setEditable(false);
            cityTF.setEditable(false);
            emailTF.setEditable(false);
            municipalTF.setEditable(false);
            phoneTF.setEditable(false);
            postalCodeTF.setEditable(false);
            commentBox.setEnabled(false);
            teamJList.setEnabled(false);
            changePictureBTN.setEnabled(false);
            
            updateButton.setText("Ret"); 
            
            Member searchedMember = memberConnection.searchMemberID(Integer.parseInt(memberIdTF.getText()));
            updateMemberValues(searchedMember);
            
            memberConnection.editMember(searchedMember);
        }
    }//GEN-LAST:event_updateButtonActionPerformed

    private void refreshMembershipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshMembershipActionPerformed
        
        Member member = memberConnection.searchMemberID(Integer.parseInt(memberIdTF.getText()));
        if(refreshMembership.getText().equalsIgnoreCase("forny medlemskab"))
        {
            fromDateTF.setText("");
            endDateTF.setText("");

            membershipDropD.setEnabled(true);
            fromDateTF.setEditable(true);
            endDateTF.setEditable(true);
            poolsCB.setEnabled(true);
            timeLimitCB.setEnabled(true);
            groupTrainingCB.setEnabled(true);

            

            refreshMembership.setText("Betal");
        }
        else if(refreshMembership.getText().equalsIgnoreCase("betal"))
        {
           PaymentGUI paymentWindow = new PaymentGUI(this);
           paymentWindow.setVisible(true);
     
            refreshMembership.setText("Forny medlemskab");
           
            membershipDropD.setEnabled(false);
            fromDateTF.setEditable(false);
            endDateTF.setEditable(false);
            poolsCB.setEnabled(false);
            timeLimitCB.setEnabled(false);
            groupTrainingCB.setEnabled(false);
        }
        
    }//GEN-LAST:event_refreshMembershipActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accountNrTF;
    private javax.swing.JTextField adressNrTF;
    private javax.swing.JTextField adressTF;
    public javax.swing.JTextField balanceTF;
    private javax.swing.JButton changePictureBTN;
    private javax.swing.JTextField cityTF;
    private javax.swing.JTextArea commentBox;
    private javax.swing.JTextField cprTF;
    private javax.swing.JButton createMemberButton;
    private javax.swing.JTextField emailTF;
    public javax.swing.JTextField endDateTF;
    private javax.swing.JTextField fNameTF;
    public javax.swing.JTextField fromDateTF;
    public javax.swing.JCheckBox groupTrainingCB;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lNameTF;
    public javax.swing.JTextField memberIdTF;
    public javax.swing.JComboBox membershipDropD;
    private javax.swing.JTextField monthPayTF;
    private javax.swing.JTextField municipalTF;
    private javax.swing.JTextField pbsDateTF;
    private javax.swing.JTextField pbsNumberTF;
    private javax.swing.JTextField phoneTF;
    private javax.swing.JLabel pictureLabel;
    public javax.swing.JCheckBox poolsCB;
    private javax.swing.JTextField postalCodeTF;
    private javax.swing.JButton refreshMembership;
    private javax.swing.JTextField regNrTF;
    private javax.swing.JList teamJList;
    public javax.swing.JCheckBox timeLimitCB;
    public javax.swing.JTextField totalPriceTF;
    public javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables

    /**
     *
     * @param m
     */
    public void setMemberDetails(Member m) {
         
        List<Perk> list = m.getPerkList();
        fillPerks(list);
        
        memberIdTF.setText(""+m.getMemberID());
        fNameTF.setText(m.getfName());
        lNameTF.setText(m.getlName());
        adressNrTF.setText(m.getStreetNumber());
        adressTF.setText(m.getStreetName());
        balanceTF.setText(""+m.getBalance());
        cprTF.setText(m.getCPR());
        commentBox.setText(m.getComment());
        accountNrTF.setText(m.getAccountNumber());
        emailTF.setText(m.getEmail());
        fromDateTF.setText(dateHandler.convertDateFormatToEuropean(m.getMembershipStartDate()));
        //fromDateTF.setText(m.get);
        //monthPayTF.setText(m.get);
        //pbsNumberTF.setText(m.get);
        phoneTF.setText(m.getPhoneNumber());
        //pbsDateTF.setText();
        postalCodeTF.setText(m.getCity().getPostelCode());
        fillCity();
        endDateTF.setText(dateHandler.convertDateFormatToEuropean(m.getEndDate()));
        regNrTF.setText(m.getRegistration());
        
        ImageIcon icon = new ImageIcon(m.getImg()); 
        pictureLabel.setIcon(icon);
        fillTeamList(m);
        
    }
    private void fillCity() {
              
        if(postalCodeTF.getText().length() == 4){
            
            City city = memberConnection.getCity(postalCodeTF.getText());
            municipalTF.setText(city.getMunicipal().replaceAll("_", " "));
            cityTF.setText(city.getCity().replaceAll("_", " "));
        }
    }
    
    private void fillPerks(List<Perk> perks)
    {
        for(Perk perk : perks)
        {
            if(perk.getName().equals("pool"))
            {
                poolsCB.setSelected(true);
            }
            if(perk.getName().equals("team"))
            {
                groupTrainingCB.setSelected(true);
            }
            if(perk.getName().equals("time constraint"))
            {
                timeLimitCB.setSelected(true);
            }
        }
    }
    
    private void fillTeamList(Member m)
    {
        TeamConnection teamHandler = new TeamConnection();
        List<Team> teamList = teamHandler.getMemberTeamList(m.getMemberID());
        DefaultListModel dlm = new DefaultListModel();
        
        for(int i = 0; i < teamList.size(); i++)
        {
            dlm.addElement(teamList.get(i));
        }
        teamJList.setModel(dlm);
    }
}
