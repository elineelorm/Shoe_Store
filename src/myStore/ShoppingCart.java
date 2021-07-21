//ELINE-ELORM AWO NUVIADENU//
//101162869//

package myStore;
import java.util.HashMap;

/**
 * A Store.ShoppingCart class
 * @author Eline Nuviadenu
 * @version 1.0
 */
public class ShoppingCart implements ProductStockContainer {

    private HashMap<Product, Integer> cartContents = new HashMap<Product, Integer>();

    /**
     * A method to add a product to a cart
     *
     * @param product refers to the product a user wants to add to cart
     * @param quantity  refers to the amount of product a user wants to add to their cart
     */
    @Override
    public void addProductQuantity(Product product, int quantity) {
        if (this.cartContents.containsKey(product)) {
            int oldValue = this.cartContents.get(product);
            this.cartContents.replace(product, oldValue, oldValue + quantity);
        } else {
            this.cartContents.put(product, quantity);
        }
    }

    /**
     * A method to remove a product from a cart
     *
     * @param product refers to the product a user wants to remove from their cart
     * @param quantity  refers to the amount of product to be removed
     * @return true if successful, false if failed
     */
    @Override
    public boolean removeProductQuantity(Product product, int quantity) {
        int oldValue = this.cartContents.get(product);
        if (this.cartContents.containsKey(product) && oldValue >= quantity) {
            this.cartContents.replace(product, oldValue, oldValue - quantity);
            return true;
        } else if (this.cartContents.containsKey(product) && oldValue == quantity) {
            this.cartContents.remove(product);
            return true;
        }
        return false;
    }

    /**
     * A method to get the quantity of products available
     * @param product refers to the product we want to find the quantity of
     * @return the available quantity of the product
     */
    @Override
    public int getProductQuantity(Product product) {
        return this.cartContents.get(product);
    }

    /**
     * A method to get the number of the products in the shopping cart
     * @return the number of products in the cart
     */
    @Override
    public int getNumOfProducts() {
        return this.cartContents.size();
    }

    /**
     * A method to return the cart contents
     * @return the contents of a users cart
     */
    public HashMap<Product, Integer> getCartContents() {
        return this.cartContents;
    }
}
