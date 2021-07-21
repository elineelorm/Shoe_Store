//ELINE-ELORM AWO NUVIADENU
//101162869

package myStore;

/**
 * An interface template
 */
public interface ProductStockContainer {
    /**
     * A method to get the quantity of a product
     * @param product refers to the product whose quantity we want
     * @return the number of the product available
     */
    public int getProductQuantity(Product product);

    /**
     * A method to add a product
     * @param product refers to the product we want to add
     * @param quantity refers to the amount of quantity to add
     */
    public void addProductQuantity(Product product, int quantity);

    /**
     * A method to remove a product
     * @param product refers to the product we want to remove
     * @param quantity refers to the amount of the product we want to remove
     * @return true if successful, false if not
     */
    public boolean removeProductQuantity(Product product, int quantity);

    /**
     * A method to return the number of products
     * @return the number of products available
     */
    public int getNumOfProducts();

}
