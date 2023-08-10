import javax.swing.*;

import Products.*;

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
        login L = new login();
        L.loginScreen();
    }
}
