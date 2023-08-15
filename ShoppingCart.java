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
    public ShoppingCart() {
        items = new ArrayList<>();
        totalPrice = 0.0;

        cartListModel = new DefaultListModel<>();
        cartList = new JList<>();
        totalPriceLabel = new JLabel("Total Price: $0.00");

        JButton addButton = new JButton("Add to Cart");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addProductToCart();
            }
        });

        JButton removeButton = new JButton("Remove from Cart");
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeProductFromCart();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(new JScrollPane(cartList), BorderLayout.CENTER);
        mainPanel.add(totalPriceLabel, BorderLayout.SOUTH);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setTitle("Shopping Cart");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
    public void addItem(productInfo item) {
        items.add(item);
        totalPrice += item.getPrice();
    }

    /**
     * Removes an item from the shopping cart and updates the total price.
     * @param item The item to be removed from the cart.
     */
    public void removeItem(productInfo item) {
        items.remove(item);
        totalPrice -= item.getPrice();
    }

    /**
     * Adds a sample product to the cart and updates the GUI.
     */
    private void addProductToCart() {
        productInfo product = new productInfo(); //"Sample Product", 9.99);
        addItem(product);
        cartListModel.addElement(product);
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