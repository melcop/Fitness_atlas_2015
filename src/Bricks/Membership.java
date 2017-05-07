package Bricks;

/**
 * The Class Membership.
 *
 * @author Pelle
 */
public class Membership {
	//fields
	/** The membership id. */
	private int membershipID;
	
	/** The membership name. */
	private String membershipName;
	
	/** The price. */
	private double price;
	/** Duration of membership. */
        private int duration;
        

	/**
	 * Instantiates a new membership.
	 *
     * @param membershipID
	 * @param membershipName the membership name
	 * @param price the price
     * @param duration
	 */
	public Membership(int membershipID, String membershipName, double price, int duration ) {
		
                this.membershipID = membershipID;
		this.membershipName = membershipName;
		this.price = price;
                this.duration = duration;
	}


	
	/**
	 * Gets the membership id.
	 *
	 * @return the membership id
	 */
	public int getMembershipID() {
		return membershipID;
	}
	
	/**
	 * Sets the membership id.
	 *
	 * @param membershipID the new membership id
	 */
	public void setMembershipID(int membershipID) {
		this.membershipID = membershipID;
	}
	
	/**
	 * Gets the membership name.
	 *
	 * @return the membership name
	 */
	public String getMembershipName() {
		return membershipName;
	}
	
	/**
	 * Sets the membership name.
	 *
	 * @param membershipName the new membership name
	 */
	public void setMembershipName(String membershipName) {
		this.membershipName = membershipName;
	}
	
	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public double getPricePerDay() {
		return price;
	}
	
	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
    /**
     *  Gets the duration
     * @return
     */
    public int getDuration() {
            return duration;
        }

    /**
     *  Sets the duration
     * @param duration
     */
    public void setDuration(int duration) {
            this.duration = duration;
        }
        @Override
    public String toString() {
        return membershipName;
    }
}
