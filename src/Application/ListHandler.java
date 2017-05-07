package Application;

import database.CategoryConnection;
import database.ProductConnection;
import java.util.List;

/**
 * 
 * @author Pelle & Eric
 */
public class ListHandler {
    CategoryConnection categoryConnection = new CategoryConnection();
    ProductConnection productConnection = new ProductConnection();
    
    /**
     * This method will call the CategoryConnection class's method getCategoryList
     * @return a List of Categories
     */
    public List getCategoryList() {
        return categoryConnection.getCategoryList();
    }
    
    /**
     * This method will call the ProductConnection class's method getProductList
     * @return a List of Products
     */ 
    public List getProductList(){
        return productConnection.getProductList();
    }

  
}
