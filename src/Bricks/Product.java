package Bricks;

/**
 *
 * @author Charlie
 */
public class Product {

    private int productID;
    private String productName;
    private double costPrice;
    private double sellingPrice;
    private String productDescription;
    private int amountInStock;
    private int minimumStock;
    private ProductCategory category;
    private int amountToBeSold;

    /**
     *  Constructor for Product Object
     * @param productID
     * @param productName
     * @param costPrice
     * @param sellingPrice
     * @param productDescription
     * @param amountInStock
     * @param minimumStock
     * @param amountToBeSold
     * @param category
     */
    public Product(int productID, String productName, double costPrice, double sellingPrice, String productDescription, int amountInStock, int minimumStock,int amountToBeSold, ProductCategory category) {
        this.productID = productID;
        this.productName = productName;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.productDescription = productDescription;
        this.amountInStock = amountInStock;
        this.minimumStock = minimumStock;
        this.amountToBeSold = amountToBeSold;
        this.category = category;
        
    }

    /**
     * Construtor for Product Object
     * @param productID
     * @param productName
     * @param costPrice
     * @param sellingPrice
     * @param productDescription
     * @param amountInStock
     * @param minimumStock
     */
    public Product(int productID, String productName, double costPrice, double sellingPrice, String productDescription, int amountInStock, int minimumStock) {
        this.productID = productID;
        this.productName = productName;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.productDescription = productDescription;
        this.amountInStock = amountInStock;
        this.minimumStock = minimumStock;
        
    }

    /**
     *  gets amount in stock
     * @return int of amountInStock
     */
    public int getAmountInStock() {
        return amountInStock;
    }

    /**
     *  sets amount in stock
     * @param amountInStock
     */
    public void setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
    }

    /**
     *  gets minimum in stock
     * @return int of minimumStock
     */
    public int getMinimumStock() {
        return minimumStock;
    }

    /**
     *  sets minimum in stock
     * @param minimumStock
     */
    public void setMinimumStock(int minimumStock) {
        this.minimumStock = minimumStock;
    }

    /**
     *  gets id for product
     * @return an int of productID
     */
    public int getProductID() {
        return productID;
    }

    /**
     * sets id for product
     * @param productID
     */
    public void setProductID(int productID) {
        this.productID = productID;
    }

    /**
     * gets name for product
     * @return a String of productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * sets name for product
     * @param productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * gets price that it cost to by a product for the company
     * @return a double of costPrice
     */
    public double getCostPrice() {
        return costPrice;
    }

    /**
     * sets costprice
     * @param costPrice
     */
    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    /**
     * gets the price that the company is selling their product to the customers 
     * @return a double of sellingPrice
     */
    public double getSellingPrice() {
        return sellingPrice;
    }

    /**
     * sets sellingprice
     * @param sellingPrice
     */
    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    /**
     * gets the description of the product
     * @return a String of productDescription
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * sets productdescription
     * @param productDescription
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    /**
     * gets amount to be sold
     * @return an int of amountTobeSold
     */
    public int getAmountToBeSold() {
        return amountToBeSold;
    }

    /**
     * sets amounToBeSold
     * @param amountToBeSold
     */
    public void setAmountToBeSold(int amountToBeSold) {
        this.amountToBeSold = amountToBeSold;
    }

    /**
     * gets category
     * @return a ProducCategory object of category
     */
    public ProductCategory getCategory() {
        return category;
    }

    /**
     * sets category 
     * @param category
     */
    public void setCategory(ProductCategory category) {
        this.category = category;
    }
    
    //Overriden metoden har vi brugt til at gøre det først bogstav stort.
    @Override
    public String toString() {
        return getProductName().substring(0, 1).toUpperCase() + getProductName().substring(1, getProductName().length());
    }
}
