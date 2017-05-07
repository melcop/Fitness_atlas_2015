package Bricks;


import java.util.ArrayList;




/**
 * @author Pelle
 *
 */
public class Member extends Person {

	private int memberID;
	private String accountNumber;
	private String registration;
	private String membershipStartDate;
        private double balance;
	private Membership membership;
        private String comment; 
        private String endDate;
        private String img;
        private ArrayList<Perk> perkList;

    /**
     * Constructor of Member without memberID
     * @param CPR
     * @param fName
     * @param lName
     * @param streetName
     * @param streetNumber
     * @param email
     * @param phonenumber
     * @param city
     * @param balance
     * @param comment
     * @param membershipStartDate
     * @param endDate
     * @param accountNumber
     * @param registration
     * @param membership
     * @param img
     * @param perkList
     */
    public Member(String CPR, String fName, String lName, String streetName,
			String streetNumber, String email, String phonenumber, City city,
                        double balance, String comment,String membershipStartDate, String endDate, String accountNumber, String registration,
                        Membership membership, String img, ArrayList<Perk> perkList) {
		
		super(CPR, fName, lName, streetName, streetNumber, email, phonenumber, city);
		
		this.accountNumber = accountNumber; // change
		this.registration = registration; // change
                this.balance = balance; 
                this.comment = comment;
                this.endDate = endDate;
                this.membership = membership;
                this.img = img;
                this.perkList = perkList;
                this.membershipStartDate = membershipStartDate;
		
	}
        
    /**
     * Construtor of Member with memberID
     * @param memberID
     * @param CPR
     * @param fName
     * @param lName
     * @param streetName
     * @param streetNumber
     * @param email
     * @param phonenumber
     * @param city
     * @param balance
     * @param comment
     * @param membershipStartDate
     * @param endDate
     * @param accountNumber
     * @param registration
     * @param membership
     * @param img
     * @param perkList
     */
    public Member(int memberID, String CPR, String fName, String lName, String streetName,
        String streetNumber, String email, String phonenumber, City city,
        int balance, String comment,String membershipStartDate, String endDate, String accountNumber, String registration,
        Membership membership, String img, ArrayList<Perk> perkList) {
                super(CPR, fName, lName, streetName, streetNumber, email, phonenumber, city);
                
                this.accountNumber = accountNumber; // change
                this.registration = registration; // change
                this.balance = balance; 
                this.comment = comment;
                this.endDate = endDate;
                this.membership = membership;
                this.img = img;
                this.perkList = perkList;
                this.memberID = memberID;
                this.membershipStartDate = membershipStartDate;
        }

    /**
     * gets ID of Member
     * @return int
     */
    public int getMemberID() {
            return memberID;
	}

    /**
     * sets memberID
     * @param memberID
     */
    public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

    /**
     * gets accountnumber
     * @return String of accountnumber
     */
    public String getAccountNumber() {
		return accountNumber;
	}

    /**
     * sets accountnumer
     * @param accountNumber
     */
    public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

    /**
     * gets registration
     * @return String of registration
     */
    public String getRegistration() {
		return registration;
	}

    /**
     * sets registration
     * @param registration
     */
    public void setRegistration(String registration) {
		this.registration = registration;
	}

    /**
     * gets startdate of membership
     * @return String of MembershipStartDate
     */
    public String getMembershipStartDate() {
		return membershipStartDate;
	}

    /**
     * sets MembershipStartDate
     * @param signupDate
     */
    public void setmembershipStartDate(String signupDate) {
		this.membershipStartDate = signupDate;
	}

    /**
     * gets membership
     * @return Membership
     */
    public Membership getMembership() {
		return membership;
	}

    /**
     * sets membership
     * @param membership
     */
    public void setMembership(Membership membership) {
		this.membership = membership;
	}
        
    /**
     * gets signupdate
     * @return String of signupdate
     */
    public String getSignUpDate() {
        return membershipStartDate;
        }

    /**
     * sets signupdate
     * @param signUpDate
     */
    public void setSignUpDate(String signUpDate) {
            this.membershipStartDate = signUpDate;
        }

    /**
     * gets balance
     * @return double of balance
     */
    public double getBalance() {
            return balance;
        }

    /**
     * sets balance
     * @param balance
     */
    public void setBalance(double balance) {
            this.balance = balance;
        }
        
    /**
     * gets comment
     * @return String of comment
     */
    public String getComment() {
            return comment;
        }

    /**
     * sets comment
     * @param comment
     */
    public void setComment(String comment) {
            this.comment = comment;
        }

    /**
     * gets enddate
     * @return String of enddate
     */
    public String getEndDate() {
            return endDate;
        }

    /**
     * sets enddate
     * @param endDate
     */
    public void setEndDate(String endDate) {
            this.endDate = endDate;
        }
        
    /**
     * get image
     * @return String URL
     */
    public String getImg() {
            return img;
        }

    /**
     * set image
     * @param img
     */
    public void setImg(String img) {
            this.img = img;
        }
        
    /**
     * gets perklist
     * @return ArrayList of Perks
     * >
     */
    public ArrayList<Perk> getPerkList() {
            return perkList;
        }

    /**
     * sets perklist
     * @param perkList
     */
    public void setPerkList(ArrayList perkList) {
            this.perkList = perkList;
        }
        


        @Override
        public String toString() {
            return "Member{" + "name=" + super.getfName() + " " + super.getlName() + ", CPR=" + super.getCPR()
                    + ", streetName=" + super.getStreetName() + ", streetNumber=" + super.getStreetNumber() + 
                    ", email=" + super.getEmail() + ", phonenumber=" + super.getPhoneNumber() + ", city="
                    + super.getCity().getPostelCode() + " " + super.getCity().getCity() + ", memberID=" + memberID + ", municipal=" + 
                    ", accountNumber=" + accountNumber + ", registration=" + registration
                    + ", signUpDate=" + membershipStartDate + ", balance=" + balance + ", membership=" + membership + ","
                    + " comment=" + comment + ", endDate=" + endDate + '}';
        }
        
    /**
     *
     * @return This method will return a Members first and last name with the names first letter en upperCase
     */
    public String print() {
        
            return "ID: " + memberID + " " + super.getfName().substring(0, 1).toUpperCase() + super.getfName().substring(1, super.getfName().length()) + 
                    " " + super.getlName().substring(0, 1).toUpperCase() + super.getlName().substring(1, super.getlName().length());
        }

	
}
