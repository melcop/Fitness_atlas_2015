package Bricks;

/**
 * @author Pelle
 *
 */

public class City {

	private String postalCode;
	private String city;
        private String municipal;

    /**
     * gets the municpal
     * @return String of municipal
     */
    public String getMunicipal() {
            return municipal;
        }

    /**
     *  sets municipal
     * @param municipal
     */
    public void setMunicipal(String municipal) {
            this.municipal = municipal;
        }
	
    /**
     * Constructor of city
     * @param postalCode
     * @param city
     * @param municipal
     */
    public City(String postalCode, String city, String municipal) {
		
		this.postalCode = postalCode;
		this.city = city;
                this.municipal = municipal;
	}
	
    /**
     *  gets the city
     * @return String of city
     */
    public String getCity() {
		return city;
	}

    /**
     * sets city
     * @param city
     */
    public void setCity(String city) {
		this.city = city;
	}

    /**
     * gets the postelcode
     * @return String of postelcode
     */
    public String getPostelCode() {
		return postalCode;
	}

    /**
     * sets postelcode
     * @param postalCode
     */
    public void setPostelCode(String postalCode) {
		this.postalCode = postalCode;
	}
}