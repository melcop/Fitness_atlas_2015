package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pelle
 */
public abstract class DBconnection {

   /* final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final static String DB_URL = "jdbc:mysql://54.77.202.131:3306/atlas_fitness_db";
    final static String username = "atlas";
    final static String password = "j96cczYWyWsQTRS2";
    
    */
    final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    final static String DB_URL = "jdbc:mysql://localhost/atlas_fitness_db";
    final static String username = "root";
    final static String password = "root";

    /**
     * This method makes the connection to the database.
     * @return an Connection
     */
    public static Connection createConnection() {

        Connection connection;
        try {
            Class.forName(DBconnection.JDBC_DRIVER); //This code is forcing the code to load and initialize
            
            /*  Attemps to establish a connection to the given database URL. The DriverManager attempts to 
                select an appropiate driver from the set of registered JDBC drivers
            */
            connection = DriverManager.getConnection(DBconnection.DB_URL, DBconnection.username, DBconnection.password);

            return connection;

        } catch (ClassNotFoundException | SQLException e) { // If no connection made, then it catch an ClassNotFoundException or SQLException.
            System.err.println(e);
            return null;
        }
       
    }
}
