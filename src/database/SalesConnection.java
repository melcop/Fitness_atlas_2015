package database;

import Bricks.Sale;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Pelle
 */
public class SalesConnection {

    private final Connection connection = DBconnection.createConnection();

    /**
     * this method handle data from SaleGUI to DB
     * @param sale
     * @throws SQLException
     */
    public void createSale(Sale sale) throws SQLException {
        
        String sql = "INSERT INTO sale (salesDate, totalprice) VALUES (?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setTimestamp(1, new java.sql.Timestamp(System.currentTimeMillis()));
        preparedStatement.setDouble(2, sale.getTotalSalePrice());
        preparedStatement.executeUpdate();
        
        //get saleID
        int saleid = 0;
        String salesID = "SELECT MAX(salesid) FROM `sale`";
        Statement statement = connection.createStatement();
        ResultSet saleResult = statement.executeQuery(salesID);
        
        while(saleResult.next()) {
            
            saleid = saleResult.getInt("MAX(salesid)");
        }
        
        //insert productsale
        String sqlSales = "INSERT INTO productsale (fk_salesid, fk_productid, quantity) VALUES (?, ?, ?)";
        PreparedStatement salePreparedStatement = connection.prepareStatement(sqlSales);
        
        for(int i = 0; i < sale.getProductList().size(); i++) {
            
            salePreparedStatement.setInt(1, saleid);
            salePreparedStatement.setInt(2,sale.getProductList().get(i).getProductID());
            salePreparedStatement.setInt(3, sale.getProductList().get(i).getAmountToBeSold());
            salePreparedStatement.executeUpdate();
            
        }
        
        //update product table
        
        String sqlproduct = "UPDATE product SET amountInStock = amountInStock - ?" +
                            " WHERE productID = ?";
        PreparedStatement productPreparedStatement = connection.prepareStatement(sqlproduct);
        
        for(int i = 0; i < sale.getProductList().size(); i++) {
                
            productPreparedStatement.setInt(1, sale.getProductList().get(i).getAmountToBeSold());
            productPreparedStatement.setInt(2, sale.getProductList().get(i).getProductID());
            productPreparedStatement.executeUpdate();
        
        }
        salePreparedStatement.close();
        statement.close();
        
    }
}
