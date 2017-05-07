package Bricks;

import java.util.ArrayList;

/**
 *
 * @author Pelle
 */
public class Sale {
    
    private int saleID;
    private ArrayList<Product> productList;
    private double totalSalePrice;

    /**
     *
     * @param saleID
     * @param productList
     * @param totalSalePrice
     */
    public Sale(int saleID, ArrayList<Product> productList, double totalSalePrice) {
        this.saleID = saleID;
        this.productList = productList;
        this.totalSalePrice = totalSalePrice;
    }

    /**
     * This method gets SaleID
     * @return saleID
     */
    public int getSaleID() {
        return saleID;
    }

    /**
     *  This method sets SaleID and have as parameter: int saleID
     * @param saleID
     */
    public void setSaleID(int saleID) {
        this.saleID = saleID;
    }

    /**
     * This method gets a arraylist
     * @return an ArrayList of Product
     */
    public ArrayList<Product> getProductList() {
        return productList;
    }

    /**
     * This method sets input for the arraylist productlist
     * @param productList
     */
    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    /**
     *  This method gets the totalprice from SaleGUI.
     * @return double
     */
    public double getTotalSalePrice() {
        return totalSalePrice;
    }

    /**
     *  This method sets the totalprice in SaleGUI
     * @param totalSalePrice
     */
    public void setTotalSalePrice(double totalSalePrice) {
        this.totalSalePrice = totalSalePrice;
    }
   
    
}


