import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * <p>
 * Class Name: Login.java<br>
 * @since 1.0 (2023-08)<br>
 * @author Armon Lee<br>
 * Description: This class gives the users the option <br>
 * to login with an existing account or register for a new <br>
 * account. As well as, take them to the homepage if logged <br>
 * in with correct username and password, take them to <br>
 * registration page if a new user, and lastly notify <br>
 * them if the username or password they entered was incorrect.<br>
 * </p>
 */

public class Login extends JFrame {
    /**
     * <p>
     * Important Variables: <br>
     * passtext, usertext - display "password" and "username" on screen<br>
     * userbox - display box for user to input username<br>
     * passbox - display box for user to input password, hides characters<br>
     * logoLabel - displays logo<br>
     * </p>
     */
    private static JLabel passtext, usertext;
    private static JTextField userbox;
    private static JPasswordField passbox;
    private static JButton loginButton;
    private static JButton registerButton;
    private static JLabel logoLabel;

    /**
     * <p>
     * loginScreen() - displays login screen, including text and<br>
     * input text boxes for the user. In addition, the class contains<br>
     * an if else statement to direct users to direct users according<br>
     * to their inputs.<br>
     *    - if user has account & inputs correct login then it will<br>
     *      take them to home screen<br>
     *    - if user has account & inputs incorrect login then an <br>
     *      incorrect password message will pop up<br>
     *    - if user has no account then they can register for one<br>
     * </p>
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
         * <p>
         * loginButton.addActionListener()<br>
         * @since 1.0 (2023-08)<br>
         * @author Armon Lee<br>
         * @param ActionListener - The listener interface for receiving action events.<br>
         * Description - Applies functionally to the loginButton. If user<br>
         * clicks loginButton, has account, & inputs correct login then <br>
         * it will take them to home screen. However, if user clicks button,<br>
         * has account, & inputs incorrect login then an incorrect password<br>
         * message will pop up.<br>
         * </p>
         */
        loginButton.addActionListener(new ActionListener() {
            /**
             * <p>
             * Important Variables:<br>
             * Username - collects input from username box<br>
             * Password - collects input from password box<br>
             * </p>
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
                HomePage H = new HomePage(currentUser.getShoppingCart());
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
         * <p>
         * @since 1.0 (2023-08)<br>
         * @author Armon Lee<br>
         * registerButton.addActionListener()<br>
         * @param ActionListener - The listener interface for receiving action events.<br>
         * Description - Applies functionally to the registerButton. If<br>
         * user clicks registerButton the it will take them to the<br>
         * register page.<br>
         * </p>
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

        window.setVisible(true);
    } 
}
