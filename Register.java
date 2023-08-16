import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Register is a GUI class that extends JFrame. 
 * <p>
 * This class provides the user interface for the registration screen of the application. 
 * It allows a new user to enter their email and password to create a new account.
 * </p>
 * 
 * @author Davit Sargsyan
 * @version 1.0
 * @since 2023-08
 */
public class Register extends JFrame {
    
    /**
     * A JTextField for the user to input their email.
     */
    private JTextField emailField;
    
    /**
     * A JPasswordField for the user to input their password.
     */
    private JPasswordField passwordField;
    
    /**
     * A JButton that triggers the registration process when clicked.
     */
    private JButton registerButton;
    
    /**
     * A JButton that takes the user to the login page when clicked.
     */
    private JButton loginButton;
    
    /**
     * A JLabel that displays the application's logo.
     */
    private JLabel logoLabel;

    /**
     * Sets up the registration GUI screen.
     * <p>
     * This method initializes the components of the registration screen,
     * arranges them using a layout manager, and sets up the event handlers
     * for the Register and Login buttons.
     * </p>
     */
	void register() {
	
		setTitle("Register");

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(AppTheme.black); // Using AppTheme colors
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);

        // Adding the logo
        logoLabel = new JLabel(AppTheme.logo);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; 
        panel.add(logoLabel, gbc);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(AppTheme.red); // Using AppTheme colors
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(emailLabel, gbc);

        emailField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(emailField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(AppTheme.red); // Using AppTheme colors
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(passwordLabel, gbc);

        passwordField = new JPasswordField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(passwordField, gbc);

        registerButton = new JButton("Register");
        registerButton.setForeground(AppTheme.red);
        registerButton.setBackground(AppTheme.black);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        panel.add(registerButton, gbc);

        loginButton = new JButton("Go to Login page");
        loginButton.setForeground(AppTheme.red);
        loginButton.setBackground(AppTheme.black);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(loginButton, gbc);

        add(panel);
		// Adding event handler
		registerButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
	
				User user = new User(emailField.getText(), new String(passwordField.getPassword()));
				boolean success = user.registerUser();

				if(success)
				{
					dispose();
					JOptionPane.showMessageDialog(null, "Registration Successful!");
					HomePage home = new HomePage();
					home.DisplayHomePage();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Registration Failed!");
				}
			}
		});

		loginButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				dispose();
				Login loginPage = new Login();
				loginPage.loginScreen();
			}
		});

		 setSize(new Dimension(700, 700));
	     setLocationRelativeTo(null);
	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     setVisible(true);
	}
	
	
	
}