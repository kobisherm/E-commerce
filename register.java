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
	//private JLabel storeLogoLabel;

	void register() {
	
		setTitle("Register");
        setSize(400, 250); 
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        getContentPane().setBackground(Color.BLACK);

        emailField = new JTextField(20);
        passwordField = new JPasswordField(20);
        registerButton = new JButton("Register");
        registerButton.setForeground(Color.RED);
        loginButton = new JButton("Login");
        loginButton.setForeground(Color.RED);

        JPanel emailPanel = createPanel();
        
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.RED);
        
        
        emailPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        emailPanel.add(emailLabel);
        emailPanel.add(emailField);
        
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.RED);
        
        JPanel passwordPanel = createPanel();
        passwordPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);

        JPanel buttonPanel = createPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(registerButton);
        buttonPanel.add(loginButton);

        add(emailPanel);
        add(passwordPanel);
        add(buttonPanel);

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
				login loginPage = new login();
				loginPage.loginScreen();
			}
		});

		setVisible(true);
	}
	
	private JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.setBackground(Color.BLACK);
        for (Component c : panel.getComponents()) {
            if (c instanceof JLabel) {
                c.setForeground(Color.WHITE);
            }
            if (c instanceof JTextField || c instanceof JPasswordField) {
                c.setForeground(Color.BLACK);
                c.setBackground(Color.WHITE);
            }
        }
        return panel;
    }
	
	
	
}