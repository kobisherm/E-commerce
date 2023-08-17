import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Order extends JFrame{
    private static JLabel orderTxt, addressInfoTxt, cardInfoTxt;
    private static JTextField address1, address2, zipcode, city, state;
    private static JTextField cardName, cardNum, CVV;
    private static JLabel address1Txt, address2Txt, zipcodeTxt, cityTxt, stateTxt;
    private static JLabel cardNameTxt, cardNumTxt, CVVTxt;
    private static JButton orderButton;

    public static void main(String[] args) {
        DisplayOrderScreen();
    }
    
    public static void DisplayOrderScreen(){
        int boxy;
        int texty = 53;

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
        int txtx = 100;
        int boxx = txtx + 80;

        //display "Address 1"
        makeText(panel, addressInfoTxt, "Address 1", txtx, posy, 100, 20);

        //display Address 1 box
        makeBox(panel, address1, boxx, posy, 193, 28);

        //display Address 


        //card

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
