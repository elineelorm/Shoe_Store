////ELINE-ELORM AWO NUVIADENU//
////101162869//
//
//package storetest;
//import org.junit.jupiter.api.*;
//import myStore.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
///**
// * A test class for the Shopping Cart class
// * @author Eline Nuviadenu
// * @version 0.0
// */
//public class ShoppingCartTest {
//
//    private static ShoppingCart s1;
//
//    /**
//     * A method to initialise a Shopping cart in order to test it
//     */
//    @BeforeAll
//    public static void init(){
//        s1 = new ShoppingCart();
//    }
//
//    /**
//     * A method to test the addition of items into a shopping cart
//     */
//    @Test
//    public void testAddToCart(){
//        Product p1 = new Product("Heels", 5678,230.89);
//        Product p2 = new Product("Lip balm", 7368, 5.99);
//        s1.addProductQuantity(p1,2);
//        int quantity = s1.getCartContents().get(5678);
//        s1.addProductQuantity(p2,3);
//        s1.addProductQuantity(p2,2);
//        int quantity2 = s1.getCartContents().get(7368);
//        assertEquals(2, quantity, "ShoppingCart does not add the new product to the list");
//        assertEquals(5, quantity2, "ShoppingCart does not add the new quantity to " +
//                "the existing one");
//    }
//
//    /**
//     * A method to test the removal of items from a shopping cart
//     */
//    @Test
//    public void testRemoveFromCart() {
//        Product p3 = new Product("Heels", 5578,230.89);
//        Product p4 = new Product("Lip balm", 7768, 5.99);
//        s1.addToCart(p3, 2);
//        s1.addToCart(p4, 3);
//        s1.removeFromCart(p4, 2);
//        s1.removeFromCart(5578, 1);
//        s1.removeFromCart(5578, 1);
//        int quantity = s1.getCartContents().get(5578);
//        int quantity2 = s1.getCartContents().get(7768);
//        assertEquals(0, quantity, "ShoppingCart does not add the various removals of the " +
//                "product from the list");
//        assertEquals(1, quantity2, "ShoppingCart does not remove the right quantity " +
//                "from the shopping cart");
//    }
//}
