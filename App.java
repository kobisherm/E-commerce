import javax.swing.*;

import Products.*;

/**
 * Class Name: Product.java
 * Date:
 * @since 1.0 (2023-08)
 * @author Armon Lee, ...
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
 * Description: This class runs the proper files and classes
 * to make the app run smoothly.
 *  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
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

        //call classes here
        Login L = new Login();
        L.loginScreen();
    }
}
