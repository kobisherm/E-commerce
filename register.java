import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class register extends JPanel {
	private JTextField emailField;
	private JPasswordField passwordField;
	private JButton registerButton;

	void register() {
		// Initialization...
		emailField = new JTextField(20);
		passwordField = new JPasswordField(20);
		registerButton = new JButton("Register");

		// Adding Components
		add(new JLabel("Email:"));
		add(emailField);
		add(new JLabel("Password:"));
		add(passwordField);
		add(registerButton);

		// Adding event handler
		registerButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String userID = UUID.randomUUID().toString();

				User user = new User(userID, emailField.getText(), new String(passwordField.getPassword()));
				boolean success = user.registerUser(userID, emailField.getText(), new String(passwordField.getPassword()));

				if(success)
				{
					JOptionPane.showMessageDialog(null, "Registration Successful!");
					HomePage home = new HomePage();
					home.HomePage();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Registration Failed!");
				}
			}
		});
	}
}