package Bricks;

/**
 * @author Pelle
 *
 */

public class Instructor extends Person {

        private int instructorID;
	private User user;
        
    /**
     * Constructor of Instructor
     * @param CPR
     * @param fName
     * @param lName
     * @param streetName
     * @param streetNumber
     * @param email
     * @param phonenumber
     * @param city
     * @param instructorID
     * @param user
     */
    public Instructor(String CPR, String fName, String lName,
			String streetName, String streetNumber, String email,
			String phonenumber, City city, int instructorID, User user) {
		
		super(CPR, fName, lName, streetName, streetNumber, email, phonenumber, city);
		
                this.instructorID = instructorID;
                this.user = user;
	}

    /**
     * gets User
     * @return Object User
     */
    public User getUser() {
            return user;
        }

    /**
     * sets User
     * @param user
     */
    public void setUser(User user) {
            this.user = user;
        }
        
    /**
     * gets ID of Instructor
     * @return int of InstructorID
     */
    public int getInstructorID() {
            return instructorID;
        }

    /**
     * sets InstructorID
     * @param instructorID
     */
    public void setInstructorID(int instructorID) {
            this.instructorID = instructorID;
        }
        
        public String toString() {
            return super.getfName() + " " + super.getlName();
        }
        
    /**
     * This method will return a Intructors first and last name with the names first letter en upperCase
     * @return String
     */
    public String print() {
        
            return "ID: " + instructorID + " " + super.getfName().substring(0, 1).toUpperCase() + super.getfName().substring(1, super.getfName().length()) + 
                    " " + super.getlName().substring(0, 1).toUpperCase() + super.getlName().substring(1, super.getlName().length());
        }
}
