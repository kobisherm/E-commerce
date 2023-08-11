import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Order extends JFrame{
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

        window.setVisible(true);
    }
    
}
