package Application;

import Bricks.Sale;
import database.SalesConnection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eric & Pelle
 */
public class ObjectCarrier {
    SalesConnection salesConnection = new SalesConnection();
    
    /**
     * This method will carry a a Sale Object to the database layer
     * @param sale
     */
    public void carrySaleToDBLayer(Sale sale){
        try {
            salesConnection.createSale(sale);
        } catch (SQLException ex) {
            Logger.getLogger(ObjectCarrier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
