package view;
import Bricks.Member;
import database.MemberConnection;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Charlie, Pelle, Eric & Mikkel
 */
public class GUI extends javax.swing.JFrame {

    MemberScreenGUI memberScreen;
    /**
     * Creates new form GUI
     */
    public GUI() {
        initComponents();
         Dimension screnSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(screnSize);
        
        this.setLocationRelativeTo(null);
    }
    private void searchMember() {
    
        MemberConnection memberConnection = new MemberConnection();
        int memberID = Integer.parseInt(searchTF.getText());
        Member searchedMember = memberConnection.searchMemberID(memberID);
        
        memberScreen = new MemberScreenGUI(this);
        
        memberScreen.setMemberDetails(searchedMember);
        memberScreen.setRefreshButtonEnabled();
        memberScreen.setUpdateEnabled();
  
            backPanel.removeAll();
            backPanel.repaint();
            backPanel.add(memberScreen);
            backPanel.repaint();
            this.setVisible(true);
    }
        public void searchMemberID(int id) {
    
        MemberConnection memberConnection = new MemberConnection();
        Member searchedMember = memberConnection.searchMemberID(id);
        
        memberScreen = new MemberScreenGUI(this);
        
        memberScreen.setMemberDetails(searchedMember);
        memberScreen.setRefreshButtonEnabled();
        memberScreen.setUpdateEnabled();
  
            backPanel.removeAll();
            backPanel.repaint();
            backPanel.add(memberScreen);
            backPanel.repaint();
            this.setVisible(true);
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        memberButton = new javax.swing.JButton();
        salesButton = new javax.swing.JButton();
        groupButton = new javax.swing.JButton();
        calenderButton = new javax.swing.JButton();
        setupButton = new javax.swing.JButton();
        backPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        searchTF = new javax.swing.JTextField();
        searchForwardBtn = new javax.swing.JButton();
        searchBackBtn = new javax.swing.JButton();
        searchBtn = new javax.swing.JButton();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Atlas motion og fitness");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0));

        memberButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/1416318964_sign-up.png"))); // NOI18N
        memberButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                memberButtonMouseReleased(evt);
            }
        });
        jPanel2.add(memberButton);

        salesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/1416319011_Shopping_cart.png"))); // NOI18N
        jPanel2.add(salesButton);

        groupButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/1416319176_group-outline-128.png"))); // NOI18N
        groupButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                groupButtonMouseReleased(evt);
            }
        });
        jPanel2.add(groupButton);

        calenderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/1416319222_Calender.png"))); // NOI18N
        calenderButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                calenderButtonMouseReleased(evt);
            }
        });
        jPanel2.add(calenderButton);

        setupButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/1416319194_advancedsettings.png"))); // NOI18N
        setupButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                setupButtonMouseReleased(evt);
            }
        });
        jPanel2.add(setupButton);

        backPanel.setForeground(new java.awt.Color(255, 0, 0));
        backPanel.setPreferredSize(new java.awt.Dimension(1000, 607));
        backPanel.setLayout(new javax.swing.BoxLayout(backPanel, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Søg medlem");

        searchTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTFActionPerformed(evt);
            }
        });

        searchForwardBtn.setText("Frem");
        searchForwardBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchForwardBtnActionPerformed(evt);
            }
        });

        searchBackBtn.setText("Tilbage");
        searchBackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBackBtnActionPerformed(evt);
            }
        });

        searchBtn.setText("Søg");
        searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                searchBtnMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchBackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(searchForwardBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(searchForwardBtn)
                    .addComponent(searchBackBtn)
                    .addComponent(searchBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(backPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1184, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void memberButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_memberButtonMouseReleased
        
        memberScreen = new MemberScreenGUI(this);
  
            backPanel.removeAll();
            backPanel.repaint();
            backPanel.add(memberScreen);
            backPanel.repaint();
            this.setVisible(true);
          
        
        
    }//GEN-LAST:event_memberButtonMouseReleased

    
    private void groupButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_groupButtonMouseReleased
        
        TeamGUI teamGui = new TeamGUI();
       
            backPanel.removeAll();
            backPanel.repaint();
            backPanel.add(teamGui);
            backPanel.repaint();
            this.setVisible(true);
           
        
        //teamGui.setVisible(true);
    }//GEN-LAST:event_groupButtonMouseReleased

    private void calenderButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calenderButtonMouseReleased
        JOptionPane.showMessageDialog(null, "Under construction");
    }//GEN-LAST:event_calenderButtonMouseReleased

    private void setupButtonMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setupButtonMouseReleased
        
         AdminCatagoryGUI adminCatagoryGUI = new AdminCatagoryGUI(this);
            backPanel.removeAll();
            backPanel.repaint();
            backPanel.add(adminCatagoryGUI);
            backPanel.repaint();
            this.setVisible(true);
        
        adminCatagoryGUI.setVisible(true);
    }//GEN-LAST:event_setupButtonMouseReleased

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
         setExtendedState(JFrame.MAXIMIZED_BOTH);
    }//GEN-LAST:event_formWindowOpened
    
    private void searchBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMousePressed

        searchMember();
    }//GEN-LAST:event_searchBtnMousePressed

    private void searchTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTFActionPerformed
        
        searchMember();
    }//GEN-LAST:event_searchTFActionPerformed

    private void searchBackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBackBtnActionPerformed
        // go back in member number
        
    }//GEN-LAST:event_searchBackBtnActionPerformed

    private void searchForwardBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchForwardBtnActionPerformed
        // go forward in member number
        
    }//GEN-LAST:event_searchForwardBtnActionPerformed
    
    /**
     * add addListener ToSalesButton
     * @param al
     */
    public void addListenerToSalesButton(ActionListener al){
        salesButton.addActionListener(al);
    }
    
    /**
     * gets SalesButton
     * @return JButton
     */
    public JButton getSalesButton() {
        return salesButton;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel backPanel;
    private javax.swing.JButton calenderButton;
    private javax.swing.JButton groupButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton memberButton;
    private javax.swing.JButton salesButton;
    private javax.swing.JButton searchBackBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton searchForwardBtn;
    private javax.swing.JTextField searchTF;
    private javax.swing.JButton setupButton;
    // End of variables declaration//GEN-END:variables

}
