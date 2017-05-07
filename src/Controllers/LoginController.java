package Controllers;

import Bricks.User;
import database.InstructorConnection;
import javax.swing.JOptionPane;
import view.GUI;
import view.LoginGUI;

/**
 *
 * @author Mikkel
 */
public class LoginController {

    private String username;
    private String password;
    private InstructorConnection instructorConnection;
    private LoginGUI loginGUI;

    /**
     *
     * @param handler
     * @param loginGUI
     */
    public LoginController(InstructorConnection handler, LoginGUI loginGUI) {
        this.instructorConnection = handler;
        this.loginGUI = loginGUI;
    }

    /**
     *
     * @param username
     * @param password
     */
    public void handleLogin(String username, String password) {
        this.username = username;
        this.password = password;
       // her kalder den på getUser() metoden fra instructorConnection klassen
        User user = instructorConnection.getUser(username, password);
        if (user == null) {
            JOptionPane.showMessageDialog(null, " forkert brugernavn/ password");
        } else {
            loginGUI.dispose();
            GUI gui = new GUI();
            gui.setVisible(true);
            MainController mainController =new MainController(gui);
           
        } 
    }
}
