import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Order extends JFrame{
    private static JLabel orderTxt, addressInfoTxt, cardInfoTxt;
    private static JTextField address1, address2, zipcode, city, state;
    private static JTextField cardName, cardNum, CVV;
    private static JLabel addressTxt, cardTxt;
    private static JButton orderButton;

    static String[] addressTxtArray = new String[]{"address1", "address2", "zipcode", "city", "state"};
    static JTextField[] addressBoxArray = new JTextField[]{address1, address2, zipcode, city, state};

    static String[] cardTxtArray = new String[]{"Card Name", "Card Number", "CVV"};
    static JTextField[] cardBoxArray = new JTextField[]{cardName, cardNum, CVV};

    public static void main(String[] args) {
        DisplayOrderScreen();
    }
    
    public static void DisplayOrderScreen(){

        JPanel panel = new JPanel();
        panel.setLayout(null);

        //display window
        JFrame window = new JFrame();
        window.setTitle("LOGIN PAGE");
        window.setLocation(new Point(500, 300));
        window.add(panel);
        window.setSize(new Dimension(800, 900));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //display "Order" Title
        makeText(panel, orderTxt, "Order Page", 100, 8, 100, 20);

        //display "Address Info" Title
        makeText(panel, addressInfoTxt, "Address Info", 100, 40, 100, 20);

        int posy = 90;
        int txtx = 140;
        int boxx = txtx + 90;

        //display address text
        for( int i = 0; i < 5; i++){
            makeText(panel, addressTxt, addressTxtArray[i], txtx, posy, 100, 20);
            posy= posy + 50;
        }

        //display address box
        posy = 90;
        for(int i = 0; i < 5; i++){
            makeBox(panel, addressBoxArray[i], boxx, posy, 193, 28);
            posy= posy + 50;
        }

        //display "Card Info"
        makeText(panel, cardInfoTxt, "Card Info", 100, 370, 100, 20);

        //display card text
        posy = 420;
        for( int i = 0; i < 3; i++){
            makeText(panel, cardTxt, cardTxtArray[i], txtx, posy, 100, 20);
            posy= posy + 50;
        }

        //display card box
        posy = 420;
        for( int i = 0; i < 3; i++){
            makeBox(panel, cardBoxArray[i], boxx, posy, 193, 28);
            posy= posy + 50;
        }

        //update quantity

        window.setVisible(true);
    }

    static public void makeText(JPanel panel, JLabel txtVar, String txt, int x, int y, int width, int height){
        txtVar = new JLabel(txt);
        txtVar.setBounds(x, y, width, height);
        panel.add(txtVar);
    }

    static public void makeBox(JPanel panel, JTextField boxVar, int x, int y, int width, int height){
        boxVar = new JTextField();
        boxVar.setBounds(x, y, width, height);
        panel.add(boxVar);
    }
    
}
