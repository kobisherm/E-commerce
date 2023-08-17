import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Products.*;

/**
 * ShoppingCart Class
 * @since 1.0  2023-08
 * @author Ian Valle
 * Description: 
 * The Shoppingcart class will allow the user to interact with the cart
 * which will allow the user to add or remove and clicking around.
 */
public class ShoppingCart {

    private ArrayList<productInfo> items; // hold items in shopping cart
    private double totalPrice; // total prices of all items

    private DefaultListModel<productInfo> cartListModel; // a model to display the items in the cart
    private JList<productInfo> cartList; 
    private JLabel totalPriceLabel;
    public JFrame frame = new JFrame();

    /**
     * A constructor to make the shopping cart and create the GUI elements.
     */
    // public ShoppingCart()
    // {
    //     //displayShoppingCart();
    // }

    //is called from homepage
    public void displayShoppingCart() { //Constructor to start the shopping cart
        items = new ArrayList<>(); // create the list of items for the shopping cart
        totalPrice = 0.0; //initial price

        cartListModel = new DefaultListModel<>(); //create a new list mode
        cartList = new JList<>();// create a jlist component
        totalPriceLabel = new JLabel("Total Price: $0.00"); //makes the total price label

         JButton addButton = new JButton("Add to Cart"); //creates add to cart button
             addButton.addActionListener(new ActionListener()
           {
           public void actionPerformed(ActionEvent e)
           {
             productInfo selectedProduct = cartList.getSelectedValue();
               if (selectedProduct != null) {
                addItem(selectedProduct);
                 cartListModel.addElement(selectedProduct);
                 updateTotalPriceLabel();
            }
        }
    });

        JButton removeButton = new JButton("Remove from Cart");//creates remove from cart button
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeProductFromCart();
            }
        });

        JPanel buttonPanel = new JPanel(); //creates a panel for the buttons
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        JPanel mainPanel = new JPanel(new BorderLayout()); //creates the main panel showing scrollable list and total price label
        mainPanel.add(new JScrollPane(cartList), BorderLayout.CENTER);
        mainPanel.add(totalPriceLabel, BorderLayout.SOUTH);

        frame.add(mainPanel, BorderLayout.CENTER); //add the main button paannel to the frame
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setTitle("Shopping Cart");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //close window
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * @since 1.0  2023-08
     * @author Ian Valle
     * Adds an item to the shopping cart and updates the total price.
     * @param item The item to be added to the cart.
     */
    public void addItem(productInfo item) { //function to add item to cart
        items.add(item); //add item to list
        totalPrice += item.getPrice();//update price
    }

    /**
     * Removes an item from the shopping cart and updates the total price.
     * @param item The item to be removed from the cart.
     */
    public void removeItem(productInfo item) { //function to remove item from cart
        items.remove(item); //remove item
        totalPrice -= item.getPrice(); //update price
    }

    /**
     * Adds a sample product to the cart and updates the GUI.
     */
    public void addProductToCart(productInfo item) {
            addItem(item);
            cartListModel.addElement(item);
             updateTotalPriceLabel();
    }

    /**
     * Removes the selected product from the cart and updates the GUI.
     */
    private void removeProductFromCart() {
        productInfo selectedProduct = cartList.getSelectedValue();
        if (selectedProduct != null) {
            removeItem(selectedProduct);
            cartListModel.removeElement(selectedProduct);
            updateTotalPriceLabel();
        }
    }

    /**
     * Updates the total price label with the current total price of items in the cart.
     */
    private void updateTotalPriceLabel() {
        totalPriceLabel.setText("Total Price: $" + String.format("%.2f", getTotalPrice()));
    }

    /**
     * Returns the total price of items in the shopping cart.
     * @return The total price.
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Main method to start the shopping cart application.
     * @param args Command-line arguments (unused).
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ShoppingCart();
            }
        });
    }
}