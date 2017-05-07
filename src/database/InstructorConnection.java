package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Bricks.City;
import Bricks.Instructor;
import Bricks.User;

/**
 *
 * @author Pelle
 */
public class InstructorConnection  {

    private final Connection connection = DBconnection.createConnection();

    /**
     * gets list of Instructor
     * @return InstructorList
     */
    public List getInstructorList() {

        List<Instructor> list = new ArrayList();
        Statement statement;
        try {
            statement = connection.createStatement();

            String sql = "SELECT fName, lName, instructorID FROM instructor";

            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {

                Instructor instructor = new Instructor(
                        null, result.getString("fName"), result.getString("lName"), null, null, null, null, null, result.getInt("instructorID"), null);
                list.add(instructor);
            }

        } catch (SQLException ex) {
            Logger.getLogger(MemberConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    /**
     * gets User
     * @param username
     * @param password
     * @return User
     */
    //Forstår ikke helt den kode
    public User getUser(String username, String password) {
        try {
            String sql = "SELECT * FROM login WHERE username = ? AND password = MD5(?)";
            PreparedStatement preStatement = connection.prepareStatement(sql);
            preStatement.setString(1, username);
            preStatement.setString(2, password);
            ResultSet result = preStatement.executeQuery();
            // first() : Moves the cursor to the first row in this ResultSet object.
            if (result.first()) {
                String passwordUser = result.getString("password");
                String usernameUser = result.getString("username");
                int userID = result.getInt("userID");

                User user = new User(userID, usernameUser, passwordUser);
                return user;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MemberConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    /**
     * createInstructor
     * @param instructor
     * @throws SQLException
     */
    public void createInstructor(Instructor instructor) throws SQLException
    {
        String saveUser="INSERT INTO login(username, password) VALUES( ?, MD5(?))";
                
        PreparedStatement preparedStatement = connection.prepareStatement(saveUser);
        preparedStatement.setString(1, instructor.getUser().getUsername());
        preparedStatement.setString(2, instructor.getUser().getPassword());
        preparedStatement.executeUpdate();
     
        int userID = getNewestUserID();
    
         String sql = "INSERT INTO instructor (CPR, fName, lName, streetName, streetnumber, email,"
                + " phoneNumber, FK_postalCode, fk_userID) VALUES (?,?,?,?,?,?,?,?,?)";

         preparedStatement = connection.prepareStatement(sql);
        
        preparedStatement.setString(1, instructor.getCPR());
        preparedStatement.setString(2, instructor.getfName());
        preparedStatement.setString(3, instructor.getlName());
        preparedStatement.setString(4, instructor.getStreetName());
        preparedStatement.setString(5, instructor.getStreetNumber());
        preparedStatement.setString(6, instructor.getEmail());
        preparedStatement.setString(7, instructor.getPhoneNumber());
        preparedStatement.setString(8, instructor.getCity().getPostelCode());
       // preparedStatement.setTimestamp(9, new java.sql.Timestamp(System.currentTimeMillis()));
        preparedStatement.setInt(9, userID);
    
        preparedStatement.executeUpdate();
    }
    
    /**
     * editInstructor
     * @param instructor
     */
    public void editInstructor(Instructor instructor)
    {
           String sql = "UPDATE instructor SET"
                    + " CPR = ?,"
                    + " fName = ?,"
                    + "lName = ?,"
                    + "streetName = ?,"
                    + "streetNumber = ?,"
                    + "email = ?,"
                    + "phonenumber= ?,"
                    + "FK_postalCode=?"
                   + "WHERE instructorID = " + instructor.getInstructorID();

            
           
            try {
            PreparedStatement preparedstamentEditInstructor = connection.prepareStatement(sql);
          
            preparedstamentEditInstructor.setString(1, instructor.getCPR());
            preparedstamentEditInstructor.setString(2, instructor.getfName());
            preparedstamentEditInstructor.setString(3, instructor.getlName());
            preparedstamentEditInstructor.setString(4, instructor.getStreetName());
            preparedstamentEditInstructor.setString(5, instructor.getStreetNumber());
            preparedstamentEditInstructor.setString(6, instructor.getEmail());
            preparedstamentEditInstructor.setString(7, instructor.getPhoneNumber());
            preparedstamentEditInstructor.setString(8, instructor.getCity().getPostelCode());
    
            preparedstamentEditInstructor.executeUpdate();
            
            String editUser = "UPDATE login SET "
                    + "username = ?,"
                    + "password = MD5(?)"
                    + "WHERE userID = " + instructor.getUser().getUserID() ;
            
            preparedstamentEditInstructor = connection.prepareStatement(editUser);
            
            preparedstamentEditInstructor.setString(1, instructor.getUser().getUsername());
            preparedstamentEditInstructor.setString(2, instructor.getUser().getPassword());
            
            preparedstamentEditInstructor.executeUpdate();
            
            } catch (SQLException ex) {
            Logger.getLogger(TeamConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }

    /**
     * search for searchInstructorID
     * @param instructorID
     * @return
     * @throws SQLException
     */
    public Instructor searchInstructorID(int instructorID) throws SQLException
    {
        Instructor searchedInstructor=null;
        City city=null;
        Instructor instructor=null;
        User user=null;
        
        Statement statement = connection.createStatement();
        //get city from DB
        String sqlGetCity = "SELECT postalCode, cityname, municipal FROM city" 
                        + " INNER JOIN instructor"
                        + " ON postalCode = fk_postalCode "
                        + " WHERE instructorID = " + instructorID;
        
        ResultSet cityResult = statement.executeQuery(sqlGetCity);
        
         while(cityResult.next()) {
        
            city = new City(cityResult.getString("postalCode"), cityResult.getString("cityname"), cityResult.getString("municipal"));
        }
         
        String sqlGetUser= "SELECT userID, username,password FROM login"
                + " INNER JOIN instructor"
                + " ON userid = fk_userid"
                + " WHERE instructorID=" + instructorID;
        
        ResultSet userResult= statement.executeQuery(sqlGetUser);
        while(userResult.next())
        {
            user= new User(userResult.getInt("userID"),userResult.getString("username"),userResult.getString("password"));
        }
        
        String sqlInst = "SELECT instructorID, fName, lName, CPR, streetName, streetNumber, email, phonenumber,"
                + " phoneNumber, FK_postalCode, fk_userID"
                + " FROM instructor WHERE instructorID = '" + instructorID + "'";
        
        ResultSet instructorResult = statement.executeQuery(sqlInst);
        
        while(instructorResult.next()) {
            searchedInstructor = new Instructor( instructorResult.getString("CPR"), instructorResult.getString("fName"), instructorResult.getString("lName")
            , instructorResult.getString("streetName"), instructorResult.getString("streetNumber"), instructorResult.getString("email")
            , instructorResult.getString("phonenumber"), city, instructorResult.getInt("instructorID"), user); 
                    
        }
        return searchedInstructor;
    }
   
    /**
     * remoce INstructor
     * @param instructorID
     * @throws SQLException
     */
    public void removeInstructor(int instructorID) throws SQLException {
        
        String remove = "DELETE FROM Instructor WHERE instructorID=?";
        PreparedStatement preStatement=connection.prepareStatement(remove);
        preStatement.setInt(1, instructorID);
        preStatement.executeUpdate();
    }
    
    /**
     * gets the newest InstructorID
     * @return int of the newest InstructorID
     */
    public int getNewestInstructorID() {
    
        int instructorID = 0;
        
        String sqluserID = "SELECT MAX(instructorID) FROM `instructor`";
        Statement statement;
        try {
            statement = connection.createStatement();

        ResultSet userIDResult = statement.executeQuery(sqluserID);
        
        while(userIDResult.next()) {
            
            instructorID = userIDResult.getInt("MAX(instructorID)");
        }
        } catch (SQLException ex) {
            Logger.getLogger(InstructorConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return instructorID;
    }
    
    /**
     * gets the newest userID
     * @return int of the newest userID
     */
    public int getNewestUserID() {
    
        int userID = 0;
        
        String sqluserID = "SELECT MAX(userID) FROM `login`";
        Statement statement;
        try {
            statement = connection.createStatement();

        ResultSet userIDResult = statement.executeQuery(sqluserID);
        
        while(userIDResult.next()) {
            
            userID = userIDResult.getInt("MAX(userID)");
        }
        } catch (SQLException ex) {
            Logger.getLogger(InstructorConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userID;
    }

}
