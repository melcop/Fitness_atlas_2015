/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Bricks.Product;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Charlie
 */
public class SaleGUITest {
    List p= new ArrayList();
    public SaleGUITest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setProductList method, of class SaleGUI.
     */
    @Test
    public void testSetProductList() {
        System.out.println("setProductList");
        Product Powerbar = new Product(1,"powerbar", 2.01, 1.01, "abc", 2, 1);
        Product Proteindrink=new Product(2,"powerbar", 2.01, 1.01, "abc", 2, 1);
        Product Energydrink=new Product(3,"powerbar", 2.01, 1.01, "abc", 2, 1);
        List<Product> productList=new ArrayList();
        SaleGUI instance = new SaleGUI(p,p);
        productList.add(Powerbar);
        productList.add(Proteindrink);
        productList.add(Energydrink);
        
        instance.setProductList(productList);   
    }

    /**
     * Test of addListenerToAddItemButton method, of class SaleGUI.
     */
    @Test
    public void testAddListenerToAddItemButton() {
        System.out.println("addListenerToAddItemButton");
        ActionListener al = null;
        JButton addItemButton=new JButton();
        addItemButton.addActionListener(al);
    }

    /**
     * Test of getCategoryCB method, of class SaleGUI.
     */
    @Test
    public void testGetCategoryCB() {
        System.out.println("getCategoryCB");
        SaleGUI instance = null;
        JComboBox expResult = null;
        JComboBox result = instance.getCategoryCB();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAmountTF method, of class SaleGUI.
     */
    @Test
    public void testSetAmountTF() {
        System.out.println("setAmountTF");
        String n = "";
        SaleGUI instance = null;
        instance.setAmountTF(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAmountTF method, of class SaleGUI.
     */
    @Test
    public void testGetAmountTF() {
        System.out.println("getAmountTF");
        SaleGUI instance = null;
        JTextField expResult = null;
        JTextField result = instance.getAmountTF();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeItemFromItemToBeSoldList method, of class SaleGUI.
     */
    @Test
    public void testRemoveItemFromItemToBeSoldList() {
        System.out.println("removeItemFromItemToBeSoldList");
        int i = 0;
        SaleGUI instance = null;
        instance.removeItemFromItemToBeSoldList(i);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotalLabel method, of class SaleGUI.
     */
    @Test
    public void testSetTotalLabel_int() {
        System.out.println("setTotalLabel");
        int n = 0;
        SaleGUI instance = null;
        instance.setTotalLabel(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalLabel method, of class SaleGUI.
     */
    @Test
    public void testGetTotalLabel() {
        System.out.println("getTotalLabel");
        SaleGUI instance = null;
        JLabel expResult = null;
        JLabel result = instance.getTotalLabel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalPrice method, of class SaleGUI.
     */
    @Test
    public void testGetTotalPrice() {
        System.out.println("getTotalPrice");
        SaleGUI instance = null;
        double expResult = 0.0;
        double result = instance.getTotalPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }



    /**
     * Test of getProductList method, of class SaleGUI.
     */
    @Test
    public void testGetProductList() {
        System.out.println("getProductList");
        SaleGUI instance = null;
        JList expResult = null;
        JList result = instance.getProductList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getItemsToBeSoldList method, of class SaleGUI.
     */
    @Test
    public void testGetItemsToBeSoldList() {
        System.out.println("getItemsToBeSoldList");
        SaleGUI instance = null;
        JList expResult = null;
        JList result = instance.getItemsToBeSoldList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setItemsToBeSoldList method, of class SaleGUI.
     */
    @Test
    public void testSetItemsToBeSoldList() {
        System.out.println("setItemsToBeSoldList");
        Product selectedProduct = null;
        SaleGUI instance = null;
        instance.setItemsToBeSoldList(selectedProduct);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clearPurchase method, of class SaleGUI.
     */
    @Test
    public void testClearPurchase() {
        System.out.println("clearPurchase");
        SaleGUI instance = null;
        instance.clearPurchase();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAmountOfItemsToBeSoldList method, of class SaleGUI.
     */
    @Test
    public void testGetAmountOfItemsToBeSoldList() {
        System.out.println("getAmountOfItemsToBeSoldList");
        SaleGUI instance = null;
        JList expResult = null;
        JList result = instance.getAmountOfItemsToBeSoldList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAmountOfItemsToBeSoldList method, of class SaleGUI.
     */
    @Test
    public void testSetAmountOfItemsToBeSoldList() {
        System.out.println("setAmountOfItemsToBeSoldList");
        int n = 0;
        SaleGUI instance = null;
        instance.setAmountOfItemsToBeSoldList(n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNewAmountOfItemsToBeSold method, of class SaleGUI.
     */
    @Test
    public void testSetNewAmountOfItemsToBeSold() {
        System.out.println("setNewAmountOfItemsToBeSold");
        int i = 0;
        int n = 0;
        SaleGUI instance = null;
        instance.setNewAmountOfItemsToBeSold(i, n);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
