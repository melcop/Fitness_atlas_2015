package view;

import Application.ListHandler;
import Bricks.Product;
import Bricks.ProductCategory;
import database.CategoryConnection;
import database.ProductConnection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Mikkel & Pelle
 */
public class CreateProductGUI extends javax.swing.JPanel {

    DefaultListModel dlm;
    List<Product> productList;
    ListHandler productListHandler = new ListHandler();
    ProductConnection productConnection = new ProductConnection();
    /**
     * Creates new form CreateGoods
     */
    public CreateProductGUI() {
        initComponents();
        fillCategoryList();
        setProductList();
    }
    
    private void textFieldsSetEditableTrue()
    {
        nameTF.setEditable(true);
        purchasePriceTF.setEditable(true);
        sellPriceTF.setEditable(true);
        minAmountTF.setEditable(true);
        amountInStockTF.setEditable(true);
        categoryCombo.setEnabled(true);
        descriptionArea.setEditable(true);
    }
    private void textFieldsSetEditableFalse()
    {
        nameTF.setEditable(false);
        purchasePriceTF.setEditable(false);
        sellPriceTF.setEditable(false);
        minAmountTF.setEditable(false);
        amountInStockTF.setEditable(false);
        categoryCombo.setEnabled(false);
        descriptionArea.setEditable(false);
    }
    private void clearTextFields()
    {
        nameTF.setText("");
        purchasePriceTF.setText("");
        sellPriceTF.setText("");
        minAmountTF.setText("");
        amountInStockTF.setText("");
        descriptionArea.setText("");
    }
    private void fillTextFields() {
    
        Product product = productList.get(productJL.getSelectedIndex());
        
        nameTF.setText(product.getProductName());
        purchasePriceTF.setText("" + product.getCostPrice());
        sellPriceTF.setText("" + product.getSellingPrice());
        minAmountTF.setText("" + product.getMinimumStock());
        amountInStockTF.setText("" + product.getAmountInStock());
        categoryCombo.setSelectedIndex(productList.get(productJL.getSelectedIndex()).getCategory().getCategory_id()-1);
        descriptionArea.setText(product.getProductDescription());
    }
    private void updateProductValues() {
    

             if(!nameTF.getText().equals(productList.get(productJL.getSelectedIndex()).getProductName())) {
                 productList.get(productJL.getSelectedIndex()).setProductName(nameTF.getText());
             }
             if(!purchasePriceTF.getText().equals("" + productList.get(productJL.getSelectedIndex()).getCostPrice())) {
                 productList.get(productJL.getSelectedIndex()).setCostPrice((Double.parseDouble(purchasePriceTF.getText())));
             }
             if(!sellPriceTF.getText().equals("" + productList.get(productJL.getSelectedIndex()).getSellingPrice())) {
                 productList.get(productJL.getSelectedIndex()).setSellingPrice((Double.parseDouble(sellPriceTF.getText())));
             }
             if(!minAmountTF.getText().equals("" + productList.get(productJL.getSelectedIndex()).getMinimumStock())) {
                 productList.get(productJL.getSelectedIndex()).setMinimumStock((Integer.parseInt(minAmountTF.getText())));
             }
             if(!amountInStockTF.getText().equals("" + productList.get(productJL.getSelectedIndex()).getAmountInStock())) {
                 productList.get(productJL.getSelectedIndex()).setAmountInStock((Integer.parseInt(amountInStockTF.getText())));
             }
             ProductCategory category = (ProductCategory)categoryCombo.getSelectedItem();
             if(!category.getCategoryName().equals(productList.get(productJL.getSelectedIndex()).getCategory().getCategoryName())) {
                 productList.get(productJL.getSelectedIndex()).setCategory((category));
             }
             if(!descriptionArea.getText().equals(productList.get(productJL.getSelectedIndex()).getProductDescription())) {
                 productList.get(productJL.getSelectedIndex()).setProductDescription((descriptionArea.getText()));
             }
             
             
        
    }
    private void setProductList() {
    
        productList = productListHandler.getProductList();
        dlm = new DefaultListModel();
        
        for(int i = 0; i < productList.size(); i++) {

            dlm.addElement(productList.get(i)); // add elements
        }
        
        productJL.setModel(dlm);  // set model for jlist
        
       
    }
 
    private void fillCategoryList()
    {
        CategoryConnection categoryConnection = new CategoryConnection();
        
            categoryCombo.setModel(new DefaultComboBoxModel(categoryConnection.getCategoryList().toArray()));

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

        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        purchasePriceLabel = new javax.swing.JLabel();
        purchasePriceTF = new javax.swing.JTextField();
        sellPriceLabel = new javax.swing.JLabel();
        sellPriceTF = new javax.swing.JTextField();
        minAmountLabel = new javax.swing.JLabel();
        minAmountTF = new javax.swing.JTextField();
        createGoodsButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        categoryCombo = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        amountInStockTF = new javax.swing.JTextField();
        deleteProductBTN = new javax.swing.JButton();
        editProductBTN = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        descriptionArea = new javax.swing.JTextArea();
        descriptionLabel1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        productJL = new javax.swing.JList();
        jSeparator1 = new javax.swing.JSeparator();

        setLayout(new java.awt.GridBagLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Opret vare");

        nameLabel.setText("Navn");

        nameTF.setEditable(false);

        purchasePriceLabel.setText("Købspris");

        purchasePriceTF.setEditable(false);

        sellPriceLabel.setText("Salgspris");

        sellPriceTF.setEditable(false);

        minAmountLabel.setText("Minimum antal på lager");

        minAmountTF.setEditable(false);

        createGoodsButton.setText("Opret");
        createGoodsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createGoodsButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Kategori");

        categoryCombo.setEnabled(false);

        jLabel6.setText("Lagerbeholdning");

        amountInStockTF.setEditable(false);

        deleteProductBTN.setText("Slet");
        deleteProductBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                deleteProductBTNMouseReleased(evt);
            }
        });

        editProductBTN.setText("Ret");
        editProductBTN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                editProductBTNMouseReleased(evt);
            }
        });

        descriptionArea.setEditable(false);
        descriptionArea.setColumns(20);
        descriptionArea.setRows(5);
        descriptionArea.setText("per 100g/100mL:\nkcal:\nkJ:\nKulhydrat:\nProtein:\nFedt:");
        jScrollPane2.setViewportView(descriptionArea);

        descriptionLabel1.setText("Produktbeskrivelse");

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(descriptionLabel1)
                .addGap(144, 144, 144))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(descriptionLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jLayeredPane1.setLayer(jScrollPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(descriptionLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setText("Produkter");

        productJL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                productJLMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(productJL);

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(categoryCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(amountInStockTF, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(nameTF, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(purchasePriceLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(sellPriceLabel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(minAmountLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(purchasePriceTF, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(sellPriceTF, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(minAmountTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(createGoodsButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 76, Short.MAX_VALUE)
                        .addComponent(editProductBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteProductBTN, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(nameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(purchasePriceLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(purchasePriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sellPriceLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sellPriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minAmountLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(minAmountTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6))
                            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(amountInStockTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoryCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deleteProductBTN)
                            .addComponent(editProductBTN))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(createGoodsButton)
                        .addGap(22, 22, 22))))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 76;
        gridBagConstraints.ipady = -15;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 11, 0);
        add(jPanel2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void createGoodsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createGoodsButtonActionPerformed
        
        textFieldsSetEditableTrue();

        if(createGoodsButton.getText().equalsIgnoreCase("Opret"))
        {
            createGoodsButton.setText("Gem");
            clearTextFields();
            descriptionArea.setText("per 100g/100mL:\n" +
                                    "kcal:\n" +
                                    "kJ:\n" +
                                    "Kulhydrat:\n" +
                                    "Protein:\n" +
                                    "Fedt:");
            editProductBTN.setText("Ret");
        }    
        else if(createGoodsButton.getText().equalsIgnoreCase("Gem"))
        {
        productConnection = new ProductConnection();
        productConnection.createProduct(nameTF.getText(), purchasePriceTF.getText(), sellPriceTF.getText(),
                                     minAmountTF.getText(), amountInStockTF.getText(), (ProductCategory)categoryCombo.getSelectedItem(), descriptionArea.getText());
        
        JOptionPane.showMessageDialog(null, "Produktet er oprettet" , "Oprettet!" ,
                JOptionPane.INFORMATION_MESSAGE, null);
        textFieldsSetEditableFalse();
        }
        
        setProductList();
        
        
    }//GEN-LAST:event_createGoodsButtonActionPerformed

    private void productJLMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productJLMouseReleased
        
        fillTextFields();
        editProductBTN.setText("Ret");
        createGoodsButton.setText("Opret");
        textFieldsSetEditableFalse();
        
    }//GEN-LAST:event_productJLMouseReleased

    private void deleteProductBTNMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteProductBTNMouseReleased
        
        int index = productJL.getSelectedIndex();
        productConnection = new ProductConnection();
        int result = JOptionPane.showOptionDialog(null, "Er du sikker på at du vil slette product: " + productList.get(index) + "?", "Bekræft",
                JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
        if(result == JOptionPane.YES_OPTION) {
        
            try {
                productConnection.removeProduct(productList.get(index).getProductID());
            } catch (SQLException ex) {
                Logger.getLogger(CreateProductGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        setProductList();
        clearTextFields();
        textFieldsSetEditableFalse();
    }//GEN-LAST:event_deleteProductBTNMouseReleased

    private void editProductBTNMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editProductBTNMouseReleased
        
        
        
        
        if(editProductBTN.getText().equalsIgnoreCase("ret") && productJL.getSelectedIndex() >= 0) {
        
            editProductBTN.setText("Gem");
            textFieldsSetEditableTrue();
            createGoodsButton.setText("Opret");
        }
        else if(editProductBTN.getText().equalsIgnoreCase("gem")) {
            
            //update fields if anything is changed
            updateProductValues(); 
             
            try {
                productConnection.editProduct(productList.get(productJL.getSelectedIndex()));
            } catch (SQLException ex) {
                Logger.getLogger(CreateProductGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
                JOptionPane.showMessageDialog(null, "Produktet er rettet" , "Færdig" ,
                JOptionPane.INFORMATION_MESSAGE, null);
                editProductBTN.setText("Ret");
                textFieldsSetEditableFalse();
                setProductList();
        }
    }//GEN-LAST:event_editProductBTNMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountInStockTF;
    private javax.swing.JComboBox categoryCombo;
    private javax.swing.JButton createGoodsButton;
    private javax.swing.JButton deleteProductBTN;
    private javax.swing.JTextArea descriptionArea;
    private javax.swing.JLabel descriptionLabel1;
    private javax.swing.JButton editProductBTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel minAmountLabel;
    private javax.swing.JTextField minAmountTF;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTF;
    private javax.swing.JList productJL;
    private javax.swing.JLabel purchasePriceLabel;
    private javax.swing.JTextField purchasePriceTF;
    private javax.swing.JLabel sellPriceLabel;
    private javax.swing.JTextField sellPriceTF;
    // End of variables declaration//GEN-END:variables
}
