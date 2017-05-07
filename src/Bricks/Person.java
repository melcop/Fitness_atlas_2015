package Bricks;

/**
 * @author Pelle
 *
 */
public class Person {

	private String cpr;
	private String fName;
	private String lName;
	private String streetName;
	private String streetNumber;
	private String email;
	private String phonenumber;
	private City city;
	
    /**
     * Constructor of Person Object
     * @param CPR
     * @param fName
     * @param lName
     * @param streetName
     * @param streetNumber
     * @param email
     * @param phonenumber
     * @param city
     */
    public Person(String CPR, String fName, String lName, String streetName, String streetNumber, String email, String phonenumber, City city) {
		
		this.cpr = CPR;
		this.fName = fName;
		this.lName = lName;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.email = email;
		this.phonenumber = phonenumber;
		this.city = city;
	}
	
    /**
     * gets the phonenumber
     * Returns a members phone number
     * @return String of phonenumber
     */
    public String getPhoneNumber() {
		return phonenumber;
	}

    /**
     * sets phonenumber
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
		this.phonenumber = phoneNumber;
	}

    /**
     * gets email
     * @return String of email
     */
    public String getEmail() {
		return email;
	}

    /**
     * sets email
     * @param email
     */
    public void setEmail(String email) {
		this.email = email;
	}

    /**
     * gets streetnumber
     * @return a String of streetNumber
     */
    public String getStreetNumber() {
		return streetNumber;
	}

    /**
     * sets streetnumber
     * @param streetNumber
     */
    public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

    /**
     * gets streetname
     * @return a String of streetName
     */
    public String getStreetName() {
		return streetName;
	}

    /**
     * sets streetname
     * @param streetName
     */
    public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

    /**
     * gets lastname
     * @return a String of lName
     */
    public String getlName() {
		return lName;
	}

    /**
     * sets lastname
     * @param lName
     */
    public void setlName(String lName) {
		this.lName = lName;
	}

    /**
     * gets firstname
     * @return a String of fName
     */
    public String getfName() {
		return fName;
	}

    /**
     * sets firstname
     * @param fName
     */
    public void setfName(String fName) {
		this.fName = fName;
	}

    /**
     * gets CPR
     * @return a String of CPR
     */
    public String getCPR() {
		return cpr;
	}

    /**
     * sets CPR
     * @param CPR
     */
    public void setCPR(String CPR) {
		this.cpr = CPR;
	}

    /**
     * gets city
     * @return a City Object of city
     */
    public City getCity() {
		return city;
	}

    /**
     * sets city
     * @param city
     */
    public void setCity(City city) {
		this.city = city;
	}
	
}
