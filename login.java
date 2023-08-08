import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class login extends JFrame {
    private static JLabel passtext, usertext;
    private static JTextField userbox;
    private static JPasswordField passbox;
    private static JButton logButton;
    private static JButton regButton;
    private static JLabel logoLabel;

    public void loginScreen() {
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

        // Display logButton and functionality
        logButton = new JButton("Login");
        logButton.setForeground(Color.RED);
        logButton.setBackground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; // Spans across 2 columns
        gbc.fill = GridBagConstraints.HORIZONTAL; // Button grows to fill space horizontally
        logButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
            String Username = userbox.getText();
            String Password = new String(passbox.getPassword());

            if (Username.equals("batman") && Password.equals("123")){
                //JOptionPane.showMessageDialog(null, "Login Successful");
                //opens Homepage class
                HomePage H = new HomePage();
                H.DisplayHomePage();
                //closes login window
                window.setVisible(false);
                window.dispose();
            } //will add hashmap of users soon
            else
                JOptionPane.showMessageDialog(null, "Username or Password mismatch ");
            }
        });//Adds an ActionListener to the button and calls actionPerformed method
        panel.add(logButton, gbc);
        

        // Display regButton and functionality
        regButton = new JButton("Register");
        regButton.setForeground(Color.RED);
        regButton.setBackground(Color.BLACK);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2; // Spans across 2 columns
        gbc.fill = GridBagConstraints.HORIZONTAL;
        regButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                //opens Homepage class
                register R = new register();
                R.register();
                //closes login window
                window.setVisible(false);
                window.dispose();
            }
        });//Adds an ActionListener to the button and calls actionPerformed method
        panel.add(regButton, gbc);

        window.setVisible(true); //Make the window visible

    }

    //username and password check
    
}