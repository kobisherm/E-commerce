import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.*;

public class Order extends JFrame {
    private JLabel orderTxt, addressInfoTxt, cardInfoTxt;
    private JTextField address1, address2, zipcode, city, state;
    private JTextField cardName, cardNum, CVV;
    private JButton orderButton;

    String[] addressTxtArray = new String[]{"Address 1", "Address 2", "Zipcode", "City", "State"};
    JTextField[] addressBoxArray = new JTextField[5];

    String[] cardTxtArray = new String[]{"Name on Card", "Card Number", "CVV"};
    JTextField[] cardBoxArray = new JTextField[3];

    // The logo image
    private ImageIcon logoIcon = new ImageIcon("Logo.png");

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

        // Assign the individual JTextField objects after they are initialized in makeBox()
        address1 = addressBoxArray[0];
        address2 = addressBoxArray[1];
        zipcode = addressBoxArray[2];
        city = addressBoxArray[3];
        state = addressBoxArray[4];

        // Display "Card Info"
        makeText(panel, "Card Info", 100, 420, 100, 20, Color.RED);

        // Display card text
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
        orderButton = new JButton("Purchase");
        orderButton.setBounds(350, 750, 100, 30);
        orderButton.setBackground(Color.RED);
        orderButton.setForeground(Color.BLACK);
        orderButton.addActionListener(new ActionListener() {
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