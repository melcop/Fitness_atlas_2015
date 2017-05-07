package Bricks;

/**
 *
 * @author Pelle
 */
public class Perk {
    
    private String name;
    private double price; 
    private int perkID;

    /**
     * Constructor of Perk
     * @param name
     * @param price
     * @param perkID
     */
    public Perk(String name, double price, int perkID) {
        this.name = name;
        this.price = price;
        this.perkID = perkID;
    }
    
    /**
     * gets name
     * @return String of name
     */
    public String getName() {
        return name;
    }

    /**
     * sets name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets price
     * @return double of price
     */
    public double getPrice() {
        return price;
    }

    /**
     * sets price
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * gets ID of perk
     * @return int of perkID
     */
    public int getPerkID() {
        return perkID;
    }

    /**
     * sets perkID
     * @param perkID
     */
    public void setPerkID(int perkID) {
        this.perkID = perkID;
    }
    
}
