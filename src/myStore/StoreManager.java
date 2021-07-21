//ELINE-ELORM AWO NUVIADENU//
//101162869//
package myStore;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A Storemanager class
 * @author Eline Nuviadenu
 * @version 1.1
 */
public class StoreManager {

    private Inventory inventory;
    private ArrayList<ShoppingCart> shoppingCarts;
    private int newID = -1;

    /**
     * Constructor for the class
     */
    public StoreManager(){
        this.inventory = new Inventory();
        this.shoppingCarts = new ArrayList<ShoppingCart>();
    }

    /**
     * Method to check the amount of product available in the inventory
     * @param product specifies the product whose quantity we want to get
     * @return the amount of product available
     */
    public int checkStock(Product product){
        return this.inventory.getProductQuantity(product);
    }

    /**
     * A method to calculate the amount a user has to pay
     * @param cartID refers to a users cart
     */
    public String checkout( int cartID){
        HashMap<Product, Integer> cartList = this.getShoppingCart().get(cartID).getCartContents();
        double amountToPay = 0.0;
        for (Product p: cartList.keySet()){
            double price = p.getProductPrice();
            amountToPay += price * cartList.get(p);
        }
        this.getShoppingCart().get(cartID).getCartContents().clear();
        return "Your total amount to pay is: $" + String.format("%.2f", amountToPay) + "\n" +
                "Come back soon!";
    }

    /**
     * A method to give each user a specific cart id
     * @return a new id for each user
     */
    public int assignNewCartID(){
        this.newID += 1;
        ShoppingCart cart = new ShoppingCart();
        this.shoppingCarts.add(cart);
        return this.newID;
    }

    /**
     * A method to add a product to a cart and remove from inventory
     * @param product refers to the specific product we want to add
     * @param quantity refers to the amount of a product a user wants to add to cart
     * @param cartID refers to the users cart id
     * @return true if addition was successful, false if unsuccessful
     */
    public boolean addProduct(Product product, int quantity, int cartID) {
        if (this.inventory.getProductQuantity(product) >= quantity && quantity > 0) {
            this.inventory.removeProductQuantity(product, quantity);
            this.shoppingCarts.get(cartID).addProductQuantity(product, quantity);
            return true;
        }
        System.out.println("Amount of stock is not available, please go back and re-select :(");
        return false;
    }

    /**
     * A method to remove an item from a users cart and add to the inventory
     * @param product refers to the specific product we want to remove
     * @param quantity refers to the amount of product a user wants to remove from cart
     * @param cartID refers to the users cart id
     */
    public void removeProduct(Product product, int quantity, int cartID){
        if (this.getShoppingCart().get(cartID).getProductQuantity(product) >= quantity && quantity > 0) {
            this.inventory.addProductQuantity(product, quantity);
            this.shoppingCarts.get(cartID).removeProductQuantity(product, quantity);
        }else {
            System.out.println("Amount is out of bounds! Kindly make another selection :(");
        }
    }

    /**
     * A method that allows a user to quit before checking out
     * @param cartID refers to the users cart id
     */
    public void quit(int cartID){
        for (Product p: this.getShoppingCart().get(cartID).getCartContents().keySet()){
            int q = this.shoppingCarts.get(cartID).getProductQuantity(p);
            this.inventory.addProductQuantity(p, q);
        }
        this.getShoppingCart().get(cartID).getCartContents().clear();
    }

    /**
     * A method to get the list of shopping carts
     * @return a list of shopping carts
     */
    public ArrayList<ShoppingCart> getShoppingCart() {
        return this.shoppingCarts;
    }

    /**
     * A method to return the cart id
     * @return the cart id
     */
    public int getCartID(){
        return this.newID;
    }

    /**
     * A method to get the amount of product in an inventory
     * @return the number of products in an inventory
     */
    public int getAmountInStock(){
        return this.inventory.getNumOfProducts();
    }

    /**
     * A method to get the product lists
     * @return alist of products
     */
    public ArrayList<Product> getList(){
        return this.inventory.getProducts();
    }
}
