//ELINE-ELORM AWO NUVIADENU//
//101162869//
package myStore;

/**
 * A Store.Product class
 * @author Eline Nuviadenu
 * @version 0.0
 */
public class Product {

    private final String PRODUCTNAME;
    private final int productID;
    private final double productPrice;

    /**
     * Constructor for Store.Product
     * @param productName allows the user name a new product
     * @param productID allows for easy identification of the product
     * @param productPrice states the price of the product being created
     */
    public Product(String productName, int productID, double productPrice){
        this.PRODUCTNAME = productName;
        this.productID = productID;
        this.productPrice = productPrice;
    }

    /**
     * Accessor method for Store.Product name
     * @return the name of the product
     */
    public String getProductName(){
        return this.PRODUCTNAME;
    }

    /**
     * Accessor method for Store.Product id
     * @return the id of the product
     */
    public int getProductID(){
        return this.productID;
    }

    /**
     * Accessor method for the Store.Product price
     * @return the price of the product
     */
    public double getProductPrice() {
        return this.productPrice;
    }
}
