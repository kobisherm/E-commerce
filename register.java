import javax.swing.*;
import java.awt.enet.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationPage extends JPanel {
	private JTextField emailField;
	private JPasswordField passwordField;
	private JButton registerButton;

	public RegistrationPage() {
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

	}
}