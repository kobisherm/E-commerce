import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Products.productInfo;

//This class provides UI to add items to cart
public class ItemInterface extends JFrame{
    
    public productInfo item;
    public ShoppingCart cart;

    public ItemInterface(productInfo item, ShoppingCart cart)
    {
        this.item = item;
        this.cart = cart;

        setTitle("Add item");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setIconImage(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(400, 200));
        add(mainPanel);

        JLabel message = new JLabel("Add " + item.getName() + " to cart?");
        message.setFont(AppTheme.smallFont);
        mainPanel.add(message);

        JPanel buttonsPanel = new JPanel();
        JButton yesBtn = AppTheme.createStandardButton("Yes", new Dimension(100, 50));
        JButton noBtn = AppTheme.createStandardButton("no", new Dimension(100, 50));
        yesBtn.addActionListener(x -> OnYesClick());
        noBtn.addActionListener(x -> dispose());

        buttonsPanel.add(yesBtn, BorderLayout.SOUTH);
        buttonsPanel.add(noBtn, BorderLayout.SOUTH);
        add(buttonsPanel, BorderLayout.SOUTH);

        pack();
        setResizable(false);
        setVisible(true);
    }

    public void OnYesClick()
    {

    }
}
