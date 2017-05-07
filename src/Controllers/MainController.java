package Controllers;

import Application.ListHandler;
import Application.ObjectCarrier;
import Application.ObjectCreator;
import Bricks.Product;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import view.GUI;
import view.SaleGUI;

/**
 *
 * @author Charlie & Eric
 */
public class MainController {
    private ListHandler listHandler = new ListHandler();
    private ObjectCreator objectCreator = new ObjectCreator();
    private ObjectCarrier objectCarrier = new ObjectCarrier();
    private SaleGUI newSaleGUI;
    private GUI gui;
    
    public MainController(GUI gui){
        this.gui=gui;
        this.gui.addListenerToSalesButton(new Listener());
        
    }
    
    /**
     * Creates a
     */
    public void createNewSaleGUI(){
        this.newSaleGUI=new SaleGUI(this.listHandler.getProductList(), listHandler.getCategoryList());
       
        gui.backPanel.removeAll();
        gui.backPanel.repaint();
        gui.backPanel.add(newSaleGUI);
        gui.backPanel.repaint();
        gui.setVisible(true);
        
        /*Sætter ActionListeneren fra MainController-klassens inner class, 'Listener', på de nødvendige SaleGUI-componenter.*/
        this.newSaleGUI.addListenerToCategoryCB(new Listener());
        this.newSaleGUI.addListenerToAddItemButton(new Listener());
        this.newSaleGUI.addListenerToRemoveItemButton(new Listener());
        this.newSaleGUI.addListenerToPurchaseButton(new Listener());
    }
    
    
    private class Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            if (e.getSource() == gui.getSalesButton()) { //Salgsknappen i hovedmenuens menubar.
                
                createNewSaleGUI();
                
            } else if (e.getSource() == newSaleGUI.getCategoryCB()) { //NewSaleGUI'ens kategori-combobox.
                
                if (newSaleGUI.getCategoryCB().getSelectedIndex() == 0) { //Hvis den første værdi i kategori-comboboxen, 'Alle', er valgt.
                    newSaleGUI.setProductList(listHandler.getProductList()); //Sætter varelisten til at vise alle produkter.
                } else {
                    newSaleGUI.setProductListByCategory(listHandler.getProductList()); //Sætter varelisten til udelukkende at vise produkter fra den valgte kategori.
                }
                
            } else if (e.getSource() == newSaleGUI.getAddItemButton()) { //NewSaleGUI'ens knap, 'Tilføj'.
                
                Product selectedProduct = (Product) newSaleGUI.getProductList().getSelectedValue(); //Laver et objekt af klassen 'Product' af værdierne fra det valgt objekt i varelisten.
                
                if (selectedProduct != null) { //Hvis vi har valgt et produkt.
                    
                    ListModel existingProductsListModel = newSaleGUI.getItemsToBeSoldList().getModel();
                    
                    Boolean selectedProductAlreadyExists = false; //Boolean som indeholder viden om hvorvidt det valgte produkt i varelisten, allerede er tilføjet i købslisten.
                    int existingItemIndex = 0; //Denne int indeholder det indeks som den valgte vare fra varelisten, allerede er placeret i i købslisten.
                    
                    /*Dette loop vil tjekke om den valgte vare fra varelisten, allerede eksisterer i købslisten*/
                    for (existingItemIndex = 0; existingItemIndex < existingProductsListModel.getSize(); existingItemIndex ++) {
                        if (selectedProduct.toString().equals(existingProductsListModel.getElementAt(existingItemIndex).toString())) { //Hvis den valgte vare stemmer overens med varen på det indeks i købslisten som loopet er nået.
                            selectedProductAlreadyExists = true; //Sæt boolean
                            break; //Break ud af loopet for at holde existingItemIndex
                        }
                    }
                    
                    int amountToBeSold = 1;
                    
                    if (selectedProductAlreadyExists) {
                        try{
                            amountToBeSold = Integer.parseInt(newSaleGUI.getAmountTF().getText());
                            amountToBeSold += Integer.parseInt(newSaleGUI.getAmountOfItemsToBeSoldList().getModel().getElementAt(existingItemIndex).toString());

                            newSaleGUI.setNewAmountOfItemsToBeSold(existingItemIndex, amountToBeSold);

                        } catch (NumberFormatException exception) {
                                amountToBeSold += Integer.parseInt(newSaleGUI.getAmountOfItemsToBeSoldList().getModel().getElementAt(existingItemIndex).toString());

                                newSaleGUI.setNewAmountOfItemsToBeSold(existingItemIndex, amountToBeSold);
                        }
                    } else {
                        try {
                            if (newSaleGUI.getAmountTF().getText() != "") {
                                amountToBeSold = Integer.parseInt(newSaleGUI.getAmountTF().getText());
                            }
                        } catch (NumberFormatException exception) {
                        }
                        
                        newSaleGUI.setItemsToBeSoldList(selectedProduct);
                        newSaleGUI.setAmountOfItemsToBeSoldList(amountToBeSold);
                    }
                    
                    newSaleGUI.setAmountTF("");
                }
            } else if (e.getSource() == newSaleGUI.getRemoveItemButton()) {
                int selection = newSaleGUI.getItemsToBeSoldList().getSelectedIndex();
                newSaleGUI.removeItemFromItemToBeSoldList(selection);
            } else if (e.getSource() == newSaleGUI.getPurchaseButton()) {
                ListModel<Product> itemsToBeSoldDLM = newSaleGUI.getItemsToBeSoldList().getModel();
                ListModel<Integer> amountToBeSoldDLM = newSaleGUI.getAmountOfItemsToBeSoldList().getModel();
                List<Product> itemsToBeSold = new ArrayList<>();
                
                for (int i = 0; i < itemsToBeSoldDLM.getSize(); i++) {
                    itemsToBeSoldDLM.getElementAt(i).setAmountToBeSold(amountToBeSoldDLM.getElementAt(i));
                    itemsToBeSold.add(itemsToBeSoldDLM.getElementAt(i));
                }
                
                objectCarrier.carrySaleToDBLayer(objectCreator.createSale(0, (ArrayList)itemsToBeSold, newSaleGUI.getTotalPrice()));
                newSaleGUI.clearPurchase();
                JOptionPane.showMessageDialog(newSaleGUI, "Salget er registreret og gemt.");
            }
        }
    }
}
