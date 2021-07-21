//ELINE-ELORM AWO NUVIADENU//
//101162869//
package myStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * A Storemanager class
 * @author Eline Nuviadenu
 * @version 2.0
 */
public class StoreView {

    /**
     * A Storeview class
     */
    private StoreManager storeManager;
    private int cartID;
    private final JFrame frame;
    private ArrayList<JButton> upB;
    private ArrayList<JButton> downB;
    private ArrayList<JLabel> counters;
    private ArrayList<JPanel> bodyComp;
    private ArrayList<JLabel> productImages;

    /**
     * Constructor for the storeview class
     * @param storeManager refers to the storemanager class which controls the storeview
     * @param cartID refers to the users unique cart id
     */
    public StoreView(StoreManager storeManager, int cartID) throws MalformedURLException {
        this.storeManager = storeManager;
        this.cartID = cartID;
        this.frame = new JFrame("ELINE'S HUB OF SHOES!");
        this.frame.setBounds(100, 100,450, 300);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
        this.upB = new ArrayList<JButton>();
        this.downB = new ArrayList<JButton>();
        for (Product p: this.storeManager.getList()){
            JButton increase = new JButton(" + ");
            JButton decrease = new JButton(" - ");
            this.upB.add(increase);
            this.downB.add(decrease);
            this.downB.get(this.storeManager.getList().indexOf(p)).setEnabled(false);
        }
        this.counters = new ArrayList<JLabel>();
        for(int i = 0; i <= this.storeManager.getAmountInStock(); i++){
            JLabel inCart = new JLabel();
            inCart.setText(String.valueOf(0));
            this.counters.add(inCart);
        }
        this.bodyComp = new ArrayList<JPanel>();
        this.productImages = new ArrayList<JLabel>();

        URL img1 = new URL("https://i.pinimg.com/236x/7a/98/1e/7a981e2317d52ba8eca63fe48da6ddff.jpg");
        URL img2 = new URL("https://i.pinimg.com/236x/ea/a9/82/eaa982e8ebc3c71ea440e902d818d567.jpg");
        URL img3 = new URL("https://i.pinimg.com/236x/6e/8c/57/6e8c574b5d8deff2b8770dd07da2897f.jpg");
        URL img4 = new URL("https://i.pinimg.com/236x/bf/51/63/bf51636980254952ff8219b40bc80169.jpg");
        URL img5 = new URL("https://i.pinimg.com/236x/4b/40/7b/4b407b5ac0187d2785de9d7fca5a7b99.jpg");
        URL img6 = new URL("https://i.pinimg.com/236x/33/29/78/33297826e243d1c76c2c86bded2bdf2e.jpg");
        URL img7 = new URL("https://i.pinimg.com/236x/50/c3/ad/50c3ad8b6833389e8db4a9794dea050d.jpg");
        URL img8 = new URL("https://i.pinimg.com/236x/15/2e/23/152e23b12e8cc98c3ac7c40dcc6a28ea.jpg");
        JLabel ballet = new JLabel(new ImageIcon(img1));
        JLabel boots = new JLabel(new ImageIcon(img2));
        JLabel flipflops = new JLabel(new ImageIcon(img3));
        JLabel heels = new JLabel(new ImageIcon(img4));
        JLabel loafers = new JLabel(new ImageIcon(img5));
        JLabel slides = new JLabel(new ImageIcon(img6));
        JLabel sneakers = new JLabel(new ImageIcon(img7));
        JLabel wedges = new JLabel(new ImageIcon(img8));
        this.productImages.add(ballet);
        this.productImages.add(boots);
        this.productImages.add(flipflops);
        this.productImages.add(heels);
        this.productImages.add(loafers);
        this.productImages.add(slides);
        this.productImages.add(sneakers);
        this.productImages.add(wedges);

    }

    /**
     * Get colours of a certain brightness. Wow!
     * @return Color : A Color object with the generated colour.
     */
    private static Color getColour() {
        int r = (int)(Math.random()*256);
        int g = (int)(Math.random()*256);
        int b = (int)(Math.random()*256);
        double luma = (0.2126 * r) + (0.7152 * g) + (0.0722 * b);

        while (luma < 75) {
            r = (int)(Math.random()*256);
            g = (int)(Math.random()*256);
            b = (int)(Math.random()*256);
            luma = (0.2126 * r) + (0.7152 * g) + (0.0722 * b);
        }
        return new Color(r, g, b);
    }

    /**
     * A method to add a unit quantity of an item to cart
     * @param p is the product we want to add to cart
     * @param quantity is the amount we want to add to the cart
     */
    private void increment(Product p, int quantity){
        this.storeManager.addProduct(p, quantity, this.cartID);
    }

    /**
     * A method to remove a unit quantity from a cart
     * @param p is the product we want to remove
     * @param quantity refers to the amount we want to remove from cart
     */
    private void decrement(Product p, int quantity){
        this.storeManager.removeProduct(p,quantity, this.cartID);
    }

    /**
     * A method that returns items to stock when a user quites before checking out
     */
    private void quit(){
        this.storeManager.quit(this.cartID);
        this.frame.setVisible(false);
    }

    /**
     * A method that displays the user's receipt and allows the user to checkout the contents
     */
    private void checkout(){
        String msg = " Product  |   Quantity  |   Price   \n";
        for (Product p : this.storeManager.getShoppingCart().get(this.cartID).getCartContents().keySet()) {
            msg += p.getProductName();
            msg += "  |      ";
            msg += String.valueOf( this.storeManager.getShoppingCart().get(this.cartID).getProductQuantity(p));
            msg += "       | ";
            msg += String.valueOf(p.getProductPrice());
            msg += "\n";
        }
        msg += String.valueOf(this.storeManager.checkout(this.cartID));
        JOptionPane option = new JOptionPane(msg, JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = option.createDialog(null, "Receipt");
        dialog.setVisible(true);
        quit();
        System.exit(0);
    }

    /**
     * A method that enables the addition and subtraction buttons for each product
     * @param p is the product whose buttons we want to access
     * @param index refers to the position of the product in the list of products
     */
    private void enableUpDown(Product p, int index){
        this.upB.get(index).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                increment(p, 1);
                downB.get(index).setEnabled(true);
                int numb = Integer.valueOf(counters.get(index).getText());
                counters.get(index).setText(String.valueOf(numb + 1));
                if(storeManager.checkStock(p) < 1){
                    upB.get(index).setEnabled(false);
                }
                if (storeManager.checkStock(p) > 0){
                    upB.get(index).setEnabled(true);
                } else {
                    upB.get(index).setEnabled(false);
                }
            }
        });
        this.downB.get(index).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                decrement(p,1);
                int numb = Integer.valueOf(counters.get(index).getText());
                counters.get(index).setText(String.valueOf(numb - 1));
                if(storeManager.getShoppingCart().get(cartID).getCartContents().get(p) > 0){
                    downB.get(index).setEnabled(true);
                }
                else{
                    downB.get(index).setEnabled(false);
                }
            }
        });
    }

    /**
     * A method that displays the way a user sees and interacts with the store
     * @return true if successful, false if failed
     */
    public boolean displayGUI() throws MalformedURLException {
        JPanel mainPanel = new JPanel(new BorderLayout());
        JScrollPane jsp = new JScrollPane(mainPanel);

        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JPanel headerPanel = new JPanel();
        JPanel bodyPanel = new JPanel(new GridLayout(3,3));
        JPanel footerPanel = new JPanel();

        JLabel headerLabel = new JLabel("Welcome!     Your cart has CartId:" + this.cartID);
        headerPanel.add(headerLabel);

        headerPanel.setPreferredSize(new Dimension(250,100));

        footerPanel.setPreferredSize(new Dimension(250, 100));

        for (Product p: this.storeManager.getList()){
            int index = this.storeManager.getList().indexOf(p);
            JPanel bodyP = new JPanel(new BorderLayout());

            JPanel bodyHead = new JPanel();
            JLabel bodyHeadTitle = new JLabel(p.getProductName().toUpperCase() + "           Amount in Stock :"
                    + this.storeManager.checkStock(p)+ "           Price : $"
                    + p.getProductPrice());

            bodyHead.add(bodyHeadTitle);

            //add pictures
            JPanel bodyBody = new JPanel();

            bodyBody.setBackground(getColour());
            bodyBody.add(this.productImages.get(index), BorderLayout.CENTER);

            JPanel bodyFoot = new JPanel();
            bodyFoot.add(upB.get(index));
            enableUpDown(p, index);

            bodyFoot.add(counters.get(index));

            bodyFoot.add(downB.get(index));


            bodyP.add(bodyHead, BorderLayout.NORTH);
            bodyP.add(bodyBody, BorderLayout.CENTER);
            bodyP.add(bodyFoot, BorderLayout.SOUTH);

            this.bodyComp.add(bodyP);
        }

        for (JPanel j: this.bodyComp){
            bodyPanel.add(j);
        }

        URL cIcon = new URL("https://th.bing.com/th/id/OIP.omw8euivoCLZqZmrGhb4AAHaHa?w=175&h=180&c=7&o=5&dpr=1.5&pid=1.7");
        ImageIcon pic = new ImageIcon(cIcon);
        Image image = pic.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
        JButton checkoutButton = new JButton("Checkout", new ImageIcon(image));

        URL qIcon = new URL("https://images.all-free-download.com/images/graphicthumb/delete_97221.jpg");
        ImageIcon pic1 = new ImageIcon(qIcon);
        Image image1 = pic1.getImage().getScaledInstance(30,30, Image.SCALE_SMOOTH);
        JButton quitButton = new JButton("Quit", new ImageIcon(image1));

        checkoutButton.addActionListener(new ActionListener() {
            // this method will be called when we click the button
            @Override
            public void actionPerformed(ActionEvent ae) {
                checkout();
            }
        });
        quitButton.addActionListener(new ActionListener() {
            // this method will be called when we click the button
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(JOptionPane.showConfirmDialog(frame,"Are you sure you want to quit without" +
                        " checking out?") == JOptionPane.OK_OPTION){
                    quit();
                    frame.setVisible(false);
                    frame.dispose();
                }
            }
        });

        footerPanel.add(checkoutButton);
        footerPanel.add(quitButton);

        mainPanel.add(headerPanel, BorderLayout.PAGE_START);
        mainPanel.add(bodyPanel, BorderLayout.CENTER);
        mainPanel.add(footerPanel, BorderLayout.PAGE_END);

        this.frame.getContentPane().add(jsp);
        this.frame.pack();

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                if (JOptionPane.showConfirmDialog(frame, "Are you sure you want to quit?")
                        == JOptionPane.OK_OPTION) {
                    // close it down!
                    quit();
                    frame.dispose();
                }
            }
        });
        return false;
    }

    /**
     * This is where we interact with the classes created
     * @param args refers to the inputs that will aid in the communication with the class
     */
    public static void main(String[] args) throws MalformedURLException {

        StoreManager sm = new StoreManager();
        StoreView sv1 = new StoreView(sm, sm.assignNewCartID());
        sv1.displayGUI();
    }
}
