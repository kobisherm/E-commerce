import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Order extends JFrame{
    private static JLabel orderTxt, addressInfoTxt, cardInfoTxt;
    private static JTextField address1, address2, zipcode, city, state;
    private static JTextField cardName, cardNum, CVV;
    private static JLabel address1Txt, address2Txt, zipcodeTxt, cityTxt, stateTxt;
    private static JLabel cardNameTxt, cardNumTxt, CVVTxt;
    private static JButton orderButton;

    public static void main(String[] args) {
        DisplayOrderScreen();
    }
    
    public static void DisplayOrderScreen(){
        JPanel panel = new JPanel(new GridBagLayout()); 
        //panel.setBackground(AppTheme.black); // Set background color to black
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15); 

        // Display window
        JFrame window = new JFrame();
        window.setTitle("Order");
        window.setLocationRelativeTo(null); // Centers the window
        window.add(panel);
        window.setSize(new Dimension(700, 700));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gbc.gridwidth = 1;

        //H1 order
        orderTxt = new JLabel("Order");
        orderTxt.setForeground(AppTheme.black);
        panel.add(orderTxt);

        //address

        //card

        window.setVisible(true);
    }
    
}
