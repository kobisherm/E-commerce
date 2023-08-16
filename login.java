import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * Class Name: Login.java
 * Date:
 * @since 1.0 (2023-08)
 * @author Armon Lee
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
 * Description: This class gives the users the option 
 * to login with an existing account or register for a new 
 * account. As well as, take them to the homepage if logged 
 * in with correct username and password, take them to 
 * registration page if a new user, and lastly notify 
 * them if the username or password they entered was incorrect.
 *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Methods: 
 * 
 */

public class Login extends JFrame {
    /**
     * Important Variables:
     * passtext, usertext - display "password" and "username" on screen
     * userbox - display box for user to input username
     * passbox - display box for user to input password, hides characters
     * logoLabel - displays logo
     */
    private static JLabel passtext, usertext;
    private static JTextField userbox;
    private static JPasswordField passbox;
    private static JButton loginButton;
    private static JButton registerButton;
    private static JLabel logoLabel;

    /**
     * loginScreen() - displays login screen, including text and
     * input text boxes for the user. In addition, the class contains
     * an if else statement to direct users to direct users according
     * to their inputs.
     *    - if user has account & inputs correct login then it will
     *      take them to home screen
     *    - if user has account & inputs incorrect login then an 
     *      incorrect password message will pop up
     *    - if user has no account then they can register for one
     */
    public void loginScreen() {
        
        JPanel panel = new JPanel(new GridBagLayout()); 
        panel.setBackground(AppTheme.black); // Set background color to black
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15); 

        // Display logo
        //ImageIcon logoIcon = new ImageIcon("Logo.png"); // Load the logo
        logoLabel = new JLabel(AppTheme.logo); 
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
        usertext.setForeground(AppTheme.red); // Set text color to red
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
        passtext.setForeground(AppTheme.red); // Set text color to red
        passtext.setFont(AppTheme.smallFont);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(passtext, gbc);

        // Display password text box
        passbox = new JPasswordField(20);
        passbox.setFont(AppTheme.smallFont);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(passbox, gbc);

        // Display logButton and functionality
        loginButton = new JButton("Login");
        loginButton.setFont(AppTheme.smallFont);
        loginButton.setForeground(AppTheme.red);
        loginButton.setBackground(AppTheme.black);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2; // Spans across 2 columns
        gbc.fill = GridBagConstraints.HORIZONTAL; // Button grows to fill space horizontally
        /**
         * loginButton.addActionListener()
         * @since 1.0 (2023-08)
         * @author Armon Lee
         * @param ActionListener - The listener interface for receiving action events.
         * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
         * Description - Applies functionally to the loginButton. If user
         * clicks loginButton, has account, & inputs correct login then 
         * it will take them to home screen. However, if user clicks button,
         * has account, & inputs incorrect login then an incorrect password
         * message will pop up.
         * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
         */
        loginButton.addActionListener(new ActionListener() {
            /**
             * Important Variables:
             * Username - collects input from username box
             * Password - collects input from password box
             */
            @Override
            public void actionPerformed(ActionEvent event) {
            String Username = userbox.getText();
            String Password = new String(passbox.getPassword());

            User currentUser = new User(Username, Password);
            boolean isUserValid = currentUser.login();

            if (isUserValid){
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
        panel.add(loginButton, gbc);
        

        // Display regButton and functionality
        registerButton = new JButton("Register");
        registerButton.setFont(AppTheme.smallFont);
        registerButton.setForeground(AppTheme.red);
        registerButton.setBackground(AppTheme.black);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2; // Spans across 2 columns
        gbc.fill = GridBagConstraints.HORIZONTAL;
        /**
         * @since 1.0 (2023-08)
         * @author Armon Lee
         * registerButton.addActionListener()
         * @param ActionListener - The listener interface for receiving action events.
         * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
         * Description - Applies functionally to the registerButton. If
         * user clicks registerButton the it will take them to the
         * register page.
         * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
         */
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                //opens Homepage class
                Register R = new Register();
                R.register();
                //closes login window
                window.setVisible(false);
                window.dispose();
            }
        });//Adds an ActionListener to the button and calls actionPerformed method
        panel.add(registerButton, gbc);
    } 
}