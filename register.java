import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Register extends JFrame {
	private JTextField emailField;
	private JPasswordField passwordField;
	private JButton registerButton;
	private JButton loginButton;
	private JLabel storeLogoLabel;

	void register() {
		// Initialization...

		setBackground(Color.BLACK);

		emailField = new JTextField(20);
		passwordField = new JPasswordField(20);
		registerButton = new JButton("Register");
		loginButton = new JButton("Login");

		//ImageIcon storeLogo = new ImageIcon("Logo.png");
		storeLogoLabel = new JLabel(AppTheme.logo);

		emailField.setForeground(AppTheme.white);  // Text color
		emailField.setBackground(AppTheme.red);    // Background color
		passwordField.setForeground(AppTheme.white);
		passwordField.setBackground(AppTheme.red);
		registerButton.setForeground(AppTheme.white);
		registerButton.setBackground(AppTheme.red);
		loginButton.setForeground(AppTheme.white);
		loginButton.setBackground(AppTheme.red);
		

		// Adding Components
		add(new JLabel("Email:"));
		add(emailField);
		add(new JLabel("Password:"));
		add(passwordField);
		add(registerButton);
		add(loginButton);

		// Adding event handler
		registerButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
	
				User user = new User(emailField.getText(), new String(passwordField.getPassword()));
				boolean success = user.registerUser();

				if(success)
				{
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
				
				login loginPage = new login();
				loginPage.loginScreen();
			}
		});

		setVisible(true);
	}
}