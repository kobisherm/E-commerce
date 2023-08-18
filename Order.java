import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import Products.Product;

public class Order extends JFrame {
    private JLabel orderTxt, addressInfoTxt, cardInfoTxt;
    private JTextField address1, address2, zipcode, city, state;
    private JTextField cardName, cardNum, CVV;
    private JButton orderButton;

    String[] addressTxtArray = new String[]{"Address 1", "Address 2", "Zipcode", "City", "State"};
    JTextField[] addressBoxArray = new JTextField[5];

    String[] cardTxtArray = new String[]{"Card Name", "Card Number", "CVV"};
    JTextField[] cardBoxArray = new JTextField[3];

    // The logo image
    private ImageIcon logoIcon = new ImageIcon("Logo.png");

    public static void main(String[] args) {
        new Order().DisplayOrderScreen();
    }

    public void DisplayOrderScreen() {

        // Custom JPanel class to paint the background
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Draw the image as the background of the panel
                g.drawImage(logoIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(null);

        // Display window
        JFrame window = new JFrame();
        window.setTitle("Order Page");
        window.setLocation(new Point(500, 300));
        window.add(panel);
        window.setSize(new Dimension(800, 900));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Display "Order" Title
        makeText(panel, "Order Page", 100, 60, 100, 20, Color.RED);

        // Display "Address Info" Title
        makeText(panel, "Address Info", 100, 100, 100, 20, Color.BLACK);

        int posy = 150;
        int txtx = 140;
        int boxx = txtx + 110;

        // Display address text
        for (int i = 0; i < addressTxtArray.length; i++) {
            makeText(panel, addressTxtArray[i], txtx, posy, 100, 20, Color.WHITE);
            makeBox(panel, addressBoxArray, i, boxx, posy, 193, 28);
            posy = posy + 50;
        }

        // Display "Card Info"
        makeText(panel, "Card Info", 100, 420, 100, 20, Color.RED);

        // Display card text
        posy = 470;
        for (int i = 0; i < cardTxtArray.length; i++) {
            makeText(panel, cardTxtArray[i], txtx, posy, 100, 20, Color.WHITE);
            makeBox(panel, cardBoxArray, i, boxx, posy, 193, 28);
            posy = posy + 50;
        }

        // Add Purchase Button
        orderButton = new JButton("Purchase");
        orderButton.setBounds(350, 750, 100, 30);
        orderButton.setBackground(Color.RED);
        orderButton.setForeground(Color.BLACK);
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show a popup message
                JOptionPane.showMessageDialog(window, 
                    "Your purchase was complete, your confirmation will be sent to your email address.",
                    "Purchase Complete",
                    JOptionPane.INFORMATION_MESSAGE);
                window.dispose();

                //Product P = new Product();
                //P.loadProducts("Products\\productFile.txt");

                // Navigate to the HomePage
                HomePage home = new HomePage(new ShoppingCart());
                home.DisplayHomePage();
                //I commented this out bc the HomePage is now showing fine after purchase is clicked

            }
        });
        panel.add(orderButton);

        window.setVisible(true);
    }

    public void makeText(JPanel panel, String txt, int x, int y, int width, int height, Color color) {
        JLabel txtVar = new JLabel(txt);
        txtVar.setBounds(x, y, width, height);
        txtVar.setForeground(color);
        panel.add(txtVar);
    }

    public void makeBox(JPanel panel, JTextField[] boxArray, int index, int x, int y, int width, int height) {
        JTextField boxVar = new JTextField();
        boxVar.setBounds(x, y, width, height);
        boxArray[index] = boxVar;
        panel.add(boxVar);
    }
}