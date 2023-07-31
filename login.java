import java.io.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class login implements ActionListener {
    private static JLabel passtext, usertext;
    private static JTextField userbox;
    private static JPasswordField passbox;
    private static JButton button;
    

    public static void main(String[] args) {
        panel();
    }

    public static void panel() {
        JPanel panel = new JPanel();
        panel.setLayout(null);

        //display window
        JFrame window = new JFrame();
        window.setTitle("LOGIN PAGE");
        window.setLocation(new Point(500, 300));
        window.add(panel);
        window.setSize(new Dimension(400, 200));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //display "username"
        usertext = new JLabel("Username");
        usertext.setBounds(100, 8, 70, 20);
        panel.add(usertext);

        //display username text box
        userbox = new JTextField();
        userbox.setBounds(100, 27, 193, 28);
        panel.add(userbox);

        //display "password"
        passtext = new JLabel("Password");
        passtext.setBounds(100, 55, 70, 20);
        panel.add(passtext);

        //display password text box
        passbox = new JPasswordField();
        passbox.setBounds(100, 75, 193, 28);
        panel.add(passbox);

        //display button and functionality
        button = new JButton("Login");
        button.setBounds(100, 110, 90, 25);
        button.setForeground(Color.WHITE);
        button.setBackground(Color.BLACK);
        button.addActionListener((ActionListener) new login()); //Adds an ActionListener to the button and calls actionPerformed method
        panel.add(button);

        window.setVisible(true); //Make the window visible
    }

    //username and password check
    @Override
    public void actionPerformed(ActionEvent event) {
        String Username = userbox.getText();
        String Password = new String(passbox.getPassword());

        if (Username.equals("icon1999") && Password.equals("imbatman")) //will add hashmap of users soon
            JOptionPane.showMessageDialog(null, "Login Successful");
            //HomePage homePage = new HomePage();
            //homePage.display();
        else
            JOptionPane.showMessageDialog(null, "Username or Password mismatch ");
    }
}