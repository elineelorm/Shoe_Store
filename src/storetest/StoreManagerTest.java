////ELINE-ELORM AWO NUVIADENU//
////101162869//
//
//package storetest;
//import org.junit.jupiter.api.*;
//import myStore.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
///**
// A test class for the Store Manager class
// * @author Eline Nuviadenu
// * @version 0.0
// */
//public class StoreManagerTest {
//    private static StoreManager sm1;
//
//    /**
//     * A method to initialise a Store Manager in order to test it
//     */
//    @BeforeAll
//    public static void init() {
//        sm1 = new StoreManager();
//    }
//
//    /**
//     * A method to test the addition of items to a cart
//     */
//    @Test
//    public void testAddProduct(){
//        int cartID = sm1.assignNewCartID();
//        Product p1 = new Product("Bag",1234,12);
//        sm1.getInventory().addAmountOfStock(p1,"clothing",5);
//        sm1.addProduct(1234,4, 0);
//        assertEquals(1, sm1.getInventory().getAmountOfStock(1234),
//                "Product was not added properly.");
//        assertEquals(1234,p1.getProductID(), "Product Id does not match.");
//    }
//
//    /**
//     * A method to test the removal of items from a cart
//     */
//    @Test
//    public void testRemoveProduct(){
//        int cartID = sm1.assignNewCartID();
//        Product p2 = new Product("Shoe",1111,10);
//        sm1.getInventory().addAmountOfStock(p2,"footwear",5);
//        sm1.addProduct(1111,4, 0);
//        sm1.removeProduct(1111,1, 0);
//        assertEquals(2, sm1.getInventory().getAmountOfStock(1111),
//                "Product was not removed properly from cart and added to the inventory.");
//        assertEquals(1111,p2.getProductID(), "Product Id does not match.");
//    }
//
//    /**
//     * A method to test the implementation of new carts
//     */
//    @Test
//    public void testAssignNewCartID(){
//        int cart = sm1.getCartID();
//        int cartSize = sm1.getShoppingCart().size();
//        sm1.assignNewCartID();
//        assertEquals(cart + 1, sm1.getCartID(),
//                "The creation of the cart id does not increment properly");
//        assertEquals(cartSize + 1, sm1.getShoppingCart().size(),
//                "The creation of the cart was not properly added");
//    }
//
//    /**
//     * A method to check the  calculation of  a users transaction
//     */
//    @Test
//    public void testCheckout(){
//        int cartID = sm1.assignNewCartID();
//        Product p3 = new Product("Heels", 5678,230.89);
//        Product p4 = new Product("Lip balm", 7368, 5.99);
//        sm1.getInventory().addAmountOfStock(p3, "shoes", 23);
//        sm1.getInventory().addAmountOfStock(p4, "beauty", 30);
//        sm1.addProduct(5678,3, 0);
//        sm1.addProduct(7368,10,0);
//        assertEquals(20, sm1.checkStock(p3), "Product did not subtract from inventory");
//        assertEquals(20, sm1.checkStock(p4), "Product did not subtract from inventory");
//        assertEquals("Your total amount to pay is: $752.57\nCome back soon!", sm1.checkout(0),
//                "The checkout method does not calculate the total properly");
//
//    }
//
//    /**
//     * A method to check if items are properly restocked if a user decides to quit before checking out
//     */
//    @Test
//    public void testQuit(){
//        int cartID = sm1.assignNewCartID();
//        Product p5 = new Product("Heels", 5578,230.89);
//        Product p6 = new Product("Lip balm", 7768, 5.99);
//        sm1.getInventory().addAmountOfStock(p5, "shoes", 23);
//        sm1.getInventory().addAmountOfStock(p6, "beauty", 30);
//        sm1.addProduct(5578,3, 0);
//        sm1.addProduct(7768,10, 0);
//        sm1.quit(0);
//
//        String contents = "";
//        contents += sm1.getShoppingCart().get(0).getCartContents();
//
//        assertEquals( "{}", contents, "The contents of the cart were " +
//                "not cleared properly");
//    }
//
//}
