import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ShoppingCart extends JFrame {

    private ArrayList<Product> items;
    private double totalPrice;

    private DefaultListModel<Product> cartListModel;
    private JList<Product> cartList;
    private JLabel totalPriceLabel;

    public ShoppingCart() {
        items = new ArrayList<>();
        totalPrice = 0.0;

        cartListModel = new DefaultListModel<>();
        cartList = new JList<>(cartListModel);
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

        add(mainPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setTitle("Shopping Cart");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void addItem(Product item) {
        items.add(item);
        totalPrice += item.getPrice();
    }

    public void removeItem(Product item) {
        items.remove(item);
        totalPrice -= item.getPrice();
    }

    private void addProductToCart() {
        Product product = new Product("Sample Product", 9.99);
        addItem(product);
        cartListModel.addElement(product);
        updateTotalPriceLabel();
    }

    private void removeProductFromCart() {
        Product selectedProduct = cartList.getSelectedValue();
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