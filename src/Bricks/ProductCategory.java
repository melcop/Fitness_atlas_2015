package Bricks;


/**
 *
 * @author Charlie
 */
public class ProductCategory {
    private int category_id;
    private String categoryName;

    @Override
    public String toString() {
        return categoryName;
    }

    /**
     * Constructor for ProductCategory object
     * @param category_id
     * @param categoryName
     */
    public ProductCategory(int category_id, String categoryName) {
        this.category_id = category_id;
        this.categoryName = categoryName;
    }

    /**
     *  gets id for category
     * @return an int of category_id
     */
    public int getCategory_id() {
        return category_id;
    }

    /**
     *  sets id for category
     * @param category_id
     */
    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    /**
     *  gets name for category
     * @return a String of categoryname
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     *  sets name for category
     * @param categoryName
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

   
    
}
