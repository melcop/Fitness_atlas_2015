package database;

import Bricks.Product;
import Bricks.ProductCategory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Charlie, Mikkel & Pelle
 */
public class ProductConnection {
    
    private final Connection connection = DBconnection.createConnection();
    
    /**
     * Contructor
     * @param name
     * @param purchasePrice
     * @param costPrice
     * @param minAmount
     * @param amountInStock
     * @param category
     * @param description
     */
    public void createProduct(String name, String purchasePrice, String costPrice, String minAmount, String amountInStock, ProductCategory category, String description){
        
        double dPurchasePrice = Double.parseDouble(purchasePrice);
        double dCostPrice = Double.parseDouble(costPrice);
        int iMinAmount = Integer.parseInt(minAmount);
        int iAmountInStock = Integer.parseInt(amountInStock);
        
        Product product = new Product(0, name, dPurchasePrice, dCostPrice, description, iAmountInStock, iMinAmount, 0 , category);
       
        try {
            createProduct(product);
        } catch (SQLException ex) {
            Logger.getLogger(ProductConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * This method creates a product
     * @param product
     * @throws SQLException
     */
    public void createProduct(Product product) throws SQLException
    {
        
        String sql = "INSERT INTO product (productName, costPrice, sellingPrice, productDescription, amountInStock, minimumStock, fk_categoryID) VALUES (?,?,?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        
        preparedStatement.setString(1, product.getProductName());
        preparedStatement.setDouble(2, product.getCostPrice());
        preparedStatement.setDouble(3, product.getSellingPrice());
        preparedStatement.setString(4, product.getProductDescription());
        preparedStatement.setInt(5, product.getAmountInStock());
        preparedStatement.setInt(6, product.getMinimumStock());
        preparedStatement.setInt(7, product.getCategory().getCategory_id());
    

        preparedStatement.executeUpdate();
    }
    
    /**
     * this method edit a product
     * @param product
     * @throws SQLException
     */
    public void editProduct(Product product) throws SQLException
    {
        String sql = "UPDATE product SET"
                    + " ProductName = ?,"
                    + " CostPrice = ?, "
                    + " SellingPrice = ?,"
                    + " ProductDescription = ?,"
                    + " AmountInStock = ?,"
                    + " MinimumStock = ?,"
                    + " FK_CategoryID = ? "
                    +  " WHERE productID = ? ";

            
           
           
            PreparedStatement preparedstamentEditProduct = connection.prepareStatement(sql);
          
            preparedstamentEditProduct.setString(1, product.getProductName());
            preparedstamentEditProduct.setDouble(2, product.getCostPrice());
            preparedstamentEditProduct.setDouble(3, product.getSellingPrice());
            preparedstamentEditProduct.setString(4, product.getProductDescription());
            preparedstamentEditProduct.setInt(5, product.getAmountInStock());
            preparedstamentEditProduct.setInt(6, product.getMinimumStock());
            preparedstamentEditProduct.setInt(7, product.getCategory().getCategory_id());
            preparedstamentEditProduct.setInt(8, product.getProductID());
            preparedstamentEditProduct.executeUpdate();
            
    }
    
    /**
     * this method remove a product
     * @param productID
     * @throws SQLException
     */
    public void removeProduct(int productID) throws SQLException
    {
        String remove = "DELETE FROM product WHERE productID=?";
        PreparedStatement preStatement=connection.prepareStatement(remove);
        preStatement.setInt(1, productID);
        preStatement.executeUpdate();
    }
    
    /**
     * this method search for a product by productID
     * @param productID
     * @return Product
     * @throws SQLException
     */
    public Product searchProductID(int productID) throws SQLException
    {
        Product searchedProduct=null;
       Statement statement = connection.createStatement();
    
        String sqlProd = "SELECT productID, ProductName, CostPrice, SellingPrice, ProductDescription, AmountInStock, MinimumStock, Fk_categoryID"
                + " FROM product WHERE productID = '" + productID + "'";
        
        ResultSet productResult = statement.executeQuery(sqlProd);
        
        while(productResult.next()) {
            searchedProduct = new Product(productResult.getInt("productID"), productResult.getString("ProductName"), productResult.getDouble("CostPrice")
            , productResult.getDouble("SellingPrice"), productResult.getString("ProductDescription"), productResult.getInt("AmountInStock")
            , productResult.getInt("MinimumStock")); 
                    
        }
        return searchedProduct;
    }
    
    /**
     * gets productlist
     * @return a List of productlist
     */
    public List getProductList() {
        
            List<Product> productList = new ArrayList();
            ProductCategory category;
            Product product;
            String sql = "SELECT *, (SELECT categoryname FROM category WHERE categoryID = fk_categoryID) AS categoryname From product  ";
                    
            
        try {
            Statement statement = connection.createStatement();
            
            ResultSet result = statement.executeQuery(sql);
            
            while(result.next()) {
            
                category = new ProductCategory(result.getInt("fk_categoryID"), result.getString("categoryname"));
                product = new Product(result.getInt("productID"), result.getString("productName"), result.getDouble("costPrice"), 
                        result.getDouble("sellingPrice"), result.getString("productDescription"), result.getInt("amountInStock"),
                        result.getInt("minimumStock") );
                product.setCategory(category);
               productList.add(product);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productList;
            
    }
    
    /**
     * delete a product
     * @param productID
     */
    public void deleteProduct(int productID) {
    
        String sql = "DELETE FROM product WHERE = ?";
        PreparedStatement preparedStament;
        try {
            preparedStament = connection.prepareStatement(sql);
            
            preparedStament.setInt(1, productID);
            preparedStament.executeUpdate();
            preparedStament.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductConnection.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
        
        
    
    
    
}
