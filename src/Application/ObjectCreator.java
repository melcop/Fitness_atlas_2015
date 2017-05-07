package Application;

import Bricks.Product;
import Bricks.Sale;
import java.util.ArrayList;

/**
 *
 * @author Eric & Pelle
 */
public class ObjectCreator {
    Sale sale;
    
    /**
     * This method will create a sale Object
     * @param saleID
     * @param productList
     * @param totalSalePrice
     * @return a Sale Object
     */
    public Sale createSale(int saleID, ArrayList<Product> productList, double totalSalePrice) {
        return new Sale(saleID, productList, totalSalePrice);
    }
    
}
