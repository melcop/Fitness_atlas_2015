package Bricks;

/**
 *
 * @author mikkel
 */
public class User {
    
    private int userID;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "User{" + "id=" + userID + ", username=" + username + ", password=" + password + '}';
    }

    /**
     * gets userID
     * @return an int of userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     *  sets userID
     * @param userID
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     *  gets username
     * @return a String of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * sets username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *  gets password
     * @return a String of password
     */
    public String getPassword() {
        return password;
    }

    /**
     *  sets password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *  Constructor for User object
     * @param userID
     * @param username
     * @param password
     */
    public User(int userID, String username, String password) {
        this.userID = userID;
        this.username = username;
        this.password = password;
    }

    /**
     * An default construtor for user object without parameter 
     */
    public User() {
    }
    
    
    
}
