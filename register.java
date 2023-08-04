import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class register extends JPanel {
	private JTextField emailField;
	private JPasswordField passwordField;
	private JButton registerButton;

	void RegistrationPage() {
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
				user user = new user();
				user.registerUser(emailField.getText(), new String(passwordField.getPassword());
				JOptionPane.showMessageDialog(null, "Registration Successful!");	
			}
		});
	}
}