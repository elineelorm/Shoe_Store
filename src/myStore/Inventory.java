//ELINE-ELORM AWO NUVIADENU//
//101162869//
package myStore;

import java.util.ArrayList;

/**
 * An inventory class
 * @author Eline Nuviadenu
 * @version 1.0
 */
public class Inventory implements ProductStockContainer{

    private ArrayList<Integer> quantityList;
    private ArrayList<Product> productList;

    public Inventory(){

        /**
         * Constructor for the Store.Inventory class
         */
        this.quantityList= new ArrayList<>();
        this.productList= new ArrayList<>();

        Product p1 = new Product("Ballet", 5678, 46.71);
        Product p2 = new Product("Boots", 7368, 100.62);
        Product p3 = new Product("Flip-Flops", 2637, 32.00);
        Product p4 = new Product("Heels", 1122, 187.41);
        Product p5 = new Product("Loafers", 7324, 50.30);
        Product p6 = new Product("Slides", 2345, 45.27);
        Product p7 = new Product("Sneakers", 7734, 44.99);
        Product p8 = new Product("Wedges", 2923, 56.86);

        addProductQuantity(p1,  23);
        addProductQuantity(p2, 30);
        addProductQuantity(p3, 50);
        addProductQuantity(p4, 23);
        addProductQuantity(p5, 30);
        addProductQuantity(p6, 50);
        addProductQuantity(p7, 23);
        addProductQuantity(p8, 30);

    }

    /**
     * Accessor for the amount of stock in the inventory
     * @param product validates if the item is actually in stock
     * @return the amount of product in stock
     */
    @Override
    public int getProductQuantity(Product product){
        for (Product p: this.productList){
            if (p == product){
                int index = this.productList.indexOf(p);
                return this.quantityList.get(index);
            }
        }
        return -1;
    }

    /**
     * Method to add more to a product's quantity or to create a new product if it does not exist
     * @param product specifies the name of the product
     * @param amount quantity of product that will be added
     */
    @Override
    public void addProductQuantity(Product product, int amount){
        for (Product p: this.productList){
            if (p.getProductID() == product.getProductID()){
                int index = this.productList.indexOf(product);
                int newAmount = this.quantityList.get(index) + amount;
                this.quantityList.set(index, newAmount);
            }
        }
        if (!this.productList.contains(product)){
            this.productList.add(product);
            this.quantityList.add(amount);
        }
    }

    /**
     * Method to remove a quantity of an item from stock
     * @param product gets the product whose quantity you want reduced
     * @param amount specifies the amount you want the quantity to be reduced by
     * @return whether or not the removal was successful
     */
    @Override
    public boolean removeProductQuantity(Product product, int amount){
        for (Product p: this.productList){
            if (p == (product)) {
                int index = this.productList.indexOf(p);
                int quantity = this.quantityList.get(index);
                if (quantity > amount) {
                    this.quantityList.set(index, quantity - amount);
                    return true;
                } else if (quantity <= amount){
                    this.quantityList.set(index, 0);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * A method to get the number of products
     * @return the number of products
     */
    @Override
    public int getNumOfProducts() {
        return this.productList.size();
    }

    /**
     * A method to get the product list
     * @return product list
     */
    public ArrayList<Product> getProducts() {
        return this.productList;
    }
}
