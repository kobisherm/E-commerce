import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Products.*;

public class ShoppingCart {//extends JFrame {

    private ArrayList<productInfo> items; // hold items in shopping cart
    private double totalPrice; // total prices of all items

    private DefaultListModel<productInfo> cartListModel; // a model to display the items in the cart
    private JList<productInfo> cartList;
    private JLabel totalPriceLabel;
    public JFrame frame = new JFrame();
    
    
    public void Shopping_Cart() {
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

    public void addItem(productInfo item) {
        items.add(item);
        totalPrice += item.getPrice();
    }

    public void removeItem(productInfo item) {
        items.remove(item);
        totalPrice -= item.getPrice();
    }

    private void addProductToCart() {
        productInfo product = new productInfo(); //"Sample Product", 9.99);
        addItem(product);
        cartListModel.addElement(product);
        updateTotalPriceLabel();
    }

    private void removeProductFromCart() {
        productInfo selectedProduct = cartList.getSelectedValue();
        if (selectedProduct != null) {
            removeItem(selectedProduct);
            cartListModel.removeElement(selectedProduct);
            updateTotalPriceLabel();
        }
    }

    private void updateTotalPriceLabel() {
        totalPriceLabel.setText("Total Price: $" + String.format("%.2f", getTotalPrice()));
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ShoppingCart();
            }
        });
    }
}