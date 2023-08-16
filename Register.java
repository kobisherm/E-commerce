import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//comment
public class Register extends JFrame {
	private JTextField emailField;
	private JPasswordField passwordField;
	private JButton registerButton;
	private JButton loginButton;
	private JLabel logoLabel;

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
					HomePage home = new HomePage(user.getShoppingCart());
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