package database;

import Bricks.ProductCategory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Charlie, Pelle & Mikkel
 */
public class CategoryConnection {
    
  private final Connection connection = DBconnection.createConnection();
    
    /**
     * This method initialize an Arraylist that contains objects of ProductCategory
     * Then it makes an connection to DB and then through query it gets categoryID and
     * categoryname from table category in DB and put it in the ArrayList product 
     * productcategorylist.
     * @return an ArrayList productcategorylist
     */
    public ArrayList<ProductCategory> getCategoryList(){
    ArrayList<ProductCategory> productcategorylist = new ArrayList<ProductCategory>();
     
    try{
    Statement statement;
    statement = connection.createStatement();
        String sql = "SELECT categoryID, categoryname FROM category";
                
        ResultSet result = statement.executeQuery(sql);
        
        while(result.next()) {
            
           ProductCategory m = new ProductCategory(result.getInt("categoryID"), result.getString("categoryname"));
            
             productcategorylist.add(m);
        }
    }catch (SQLException ex) {
            Logger.getLogger(MemberConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    return productcategorylist;
    }
}
