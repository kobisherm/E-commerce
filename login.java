import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class login implements ActionListener {
    private static JLabel passtext, usertext;
    private static JTextField userbox;
    private static JPasswordField passbox;
    private static JButton button;
    private static JLabel logoLabel;

    public static void main(String[] args) {
        try {
            // Set system look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
            // If the look and feel cannot be set, print the error
            System.out.println("Look and Feel not set");
        }
        panel();
    }

    public static void panel() {
        JPanel panel = new JPanel(new GridBagLayout()); 
        panel.setBackground(Color.BLACK); // Set background color to black
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15); 

        // Display logo
        ImageIcon logoIcon = new ImageIcon("Logo.png"); // Load the logo
        logoLabel = new JLabel(logoIcon); 
        gbc.gridx = 0; // Column
        gbc.gridy = 0; // Row
        gbc.gridwidth = 2; // Span across 2 columns
        panel.add(logoLabel, gbc);

        // Display window
        JFrame window = new JFrame();
        window.setTitle("LOGIN PAGE");
        window.setLocationRelativeTo(null); // Centers the window
        window.add(panel);
        window.setSize(new Dimension(700, 700));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Display "username"
        usertext = new JLabel("Username");
        usertext.setForeground(Color.RED); // Set text color to red
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Reset gridwidth
        panel.add(usertext, gbc);

        // Display username text box
        userbox = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(userbox, gbc);

        // Display "password"
        passtext = new JLabel("Password");
        passtext.setForeground(Color.RED); // Set text color to red
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(passtext, gbc);

        // Display password text box
        passbox = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(passbox, gbc);

        // Display button and functionality
        button = new JButton("Login");
        button.setForeground(Color.RED);
        button.setBackground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; // Spans across 2 columns
        gbc.fill = GridBagConstraints.HORIZONTAL; // Button grows to fill space horizontally
        button.addActionListener((ActionListener) new login()); //Adds an ActionListener to the button and calls actionPerformed method
        panel.add(button, gbc);

        window.setVisible(true); //Make the window visible
    }

    //username and password check
    @Override
    public void actionPerformed(ActionEvent event) {
        String Username = userbox.getText();
        String Password = new String(passbox.getPassword());

        if (Username.equals("icon1999") && Password.equals("imbatman")) //will add hashmap of users soon
            JOptionPane.showMessageDialog(null, "Login Successful");
        else
            JOptionPane.showMessageDialog(null, "Username or Password mismatch ");
    }
}