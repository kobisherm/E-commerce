import javax.swing.*;

import Products.*;

/**
 * <p>
 * Class Name: Product.java<br>
 * @since 1.0 (2023-08)<br>
 * @author Armon Lee<br>
 * Description: This class runs the proper files and classes<br>
 * to make the app run smoothly.<br>
 * </p>
 */

public class App {
        public static void main(String[] args) {
        try {
            // Set system look and feel
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
            System.out.println("Look and Feel not set");
        }

        //call and read products
        Product P = new Product();
        P.loadProducts("Products\\productFile.txt");

        //call and read users

        //HomePage home = new HomePage(new ShoppingCart());
        //home.DisplayHomePage();
        //call classes here
        Login L = new Login();
        L.loginScreen();
    }
}