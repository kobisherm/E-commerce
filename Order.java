import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

/**
 * <p>
 * Class Name: Order.java<br>
 * @since 1.0 (2023-08)<br>
 * @author Armon Lee & Davit Sargsyan<br>
 * Description: This class gives the users the option<br>
 * to order the products that they added to the shopping<br>
 * cart. They'll also be able to put in their card information<br>
 * and shipping information to properly purchase their items<br>
 * Important Data Structures: <br>
 *    - String[] addressTxtArray - holds array of address text strings<br>
 *    - String[] cardTxtArray - holds array of card text strings<br>
 *    - JTextField[] addressBoxArray - holds array of address text boxes<br>
 *    - JTextField[] cardBoxArray - holds array of card text boxes<br>
 * </p>
 */

public class Order extends JFrame {
        /**
     * <p>
     * Important Variables: <br>
     * address1, address2, zipcode, city, state - displays text field box<br>
     * cardName, cardNum, CVV - displays text field box<br>
     * purchaseButton - displays purchase button<br>
     * logoLabel - displays logo<br>
     * </p>
     */

    private JTextField address1, address2, zipcode, city, state;
    private JTextField cardName, cardNum, CVV;
    private JButton purchaseButton;

    String[] addressTxtArray = new String[]{"Address 1", "Address 2", "Zipcode", "City", "State"};
    JTextField[] addressBoxArray = new JTextField[5];

    String[] cardTxtArray = new String[]{"Name on Card", "Card Number", "CVV"};
    JTextField[] cardBoxArray = new JTextField[3];

    // The logo image
    private ImageIcon logoIcon = new ImageIcon("Logo.png");

    /**
     * <p>
     * DisplayOrderScreen() - displays the panel and frame<br>
     * for the Order.java interface. As well as, displaying<br>
     * the text strings and boxes for the card and shipping<br>
     * information.<br>
     * </p>
     */
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

        int posy = 150; //y position of text strings and boxes
        int txtx = 140; //x position of text strings
        int boxx = txtx + 110; //x position of text boxes

        // Display address text and boxes
        // Loop through addressTxtArray and addressBoxArray
        // Call makeText and makeBox methods with each element in arrays to create and display
        for (int i = 0; i < addressTxtArray.length; i++) {
            makeText(panel, addressTxtArray[i], txtx, posy, 100, 20, Color.WHITE);
            makeBox(panel, addressBoxArray, i, boxx, posy, 193, 28);
            posy = posy + 50;
        }

        // Assign the individual JTextField objects after they are initialized in makeBox()
        address1 = addressBoxArray[0];
        address2 = addressBoxArray[1];
        zipcode = addressBoxArray[2];
        city = addressBoxArray[3];
        state = addressBoxArray[4];

        // Display "Card Info"
        makeText(panel, "Card Info", 100, 420, 100, 20, Color.RED);

        // Display card text and boxes
        posy = 470;
        for (int i = 0; i < cardTxtArray.length; i++) {
            makeText(panel, cardTxtArray[i], txtx, posy, 100, 20, Color.WHITE);
            makeBox(panel, cardBoxArray, i, boxx, posy, 193, 28);
            posy = posy + 50;
        }

        // Assign the individual JTextField objects after they are initialized in makeBox()
        cardName = cardBoxArray[0];
        cardNum = cardBoxArray[1];
        CVV = cardBoxArray[2];

        // Limit the Card Number field to 16 digits
        ((PlainDocument) cardNum.getDocument()).setDocumentFilter(new LengthFilter(16));
        
        // Limit the CVV field to 3 digits
        ((PlainDocument) CVV.getDocument()).setDocumentFilter(new LengthFilter(3));

        // Add Purchase Button
        purchaseButton = new JButton("Purchase");
        purchaseButton.setBounds(350, 750, 100, 30);
        purchaseButton.setBackground(Color.RED);
        purchaseButton.setForeground(Color.BLACK);
        purchaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (areRequiredFieldsFilled() && isInputValid()) {
                    JOptionPane.showMessageDialog(window, 
                        "Your purchase was complete, your confirmation will be sent to your email address.",
                        "Purchase Complete",
                        JOptionPane.INFORMATION_MESSAGE);
                    window.dispose();
                } else {
                    JOptionPane.showMessageDialog(window, 
                        "Please fill in all required fields and ensure the information is valid.",
                        "Missing or Invalid Information",
                        JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        panel.add(purchaseButton);

        window.setVisible(true);
    }

    /**
     * makeText() - create and displays text strings on the GUI
     * @param panel - passes JPanel to add text
     * @param txt - passes text element string from addressTxtArray
     * @param x - position x
     * @param y - position y
     * @param width
     * @param height
     * @param color
     */
    public void makeText(JPanel panel, String txt, int x, int y, int width, int height, Color color) {
        JLabel txtVar = new JLabel(txt);
        txtVar.setBounds(x, y, width, height);
        txtVar.setForeground(color);
        panel.add(txtVar);
    }

    /**
     * makeBox() - create and displays text boxes on the GUI
     * @param panel - passes JPanel to add text
     * @param boxArray - passes text element string from cardTxtArray
     * @param index - index of cardTxtArray
     * @param x - position x
     * @param y - position y
     * @param width
     * @param height
     */
    public void makeBox(JPanel panel, JTextField[] boxArray, int index, int x, int y, int width, int height) {
        JTextField boxVar = new JTextField();
        boxVar.setBounds(x, y, width, height);
        boxArray[index] = boxVar;
        panel.add(boxVar);
    }
    
    private boolean areRequiredFieldsFilled() {
        // Check if the required fields are not empty
        return !(address1.getText().trim().isEmpty() || 
                 zipcode.getText().trim().isEmpty() || 
                 city.getText().trim().isEmpty() || 
                 state.getText().trim().isEmpty() || 
                 cardName.getText().trim().isEmpty() || 
                 cardNum.getText().trim().isEmpty() || 
                 CVV.getText().trim().isEmpty());
    }
    
    private boolean isInputValid() {
        boolean isCardNameValid = cardName.getText().trim().matches("^[a-zA-Z ]+$");
        boolean isCardNumValid = cardNum.getText().trim().matches("^\\d{16}$");
        boolean isCVVValid = CVV.getText().trim().matches("^\\d{3}$");
        
        return isCardNameValid && isCardNumValid && isCVVValid;
    }

    // Inner class to limit the length of input
    class LengthFilter extends DocumentFilter {
        private int limit;

        public LengthFilter(int limit) {
            this.limit = limit;
        }

        @Override
        public void insertString(FilterBypass fb, int offset, String str, AttributeSet attr)
                throws BadLocationException {
            if (fb.getDocument().getLength() + str.length() <= limit) {
                super.insertString(fb, offset, str, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String str, AttributeSet attrs)
                throws BadLocationException {
            if (fb.getDocument().getLength() + str.length() - length <= limit) {
                super.replace(fb, offset, length, str, attrs);
            }
        }
    }
}