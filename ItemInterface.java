import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Products.productInfo;

//This class provides UI to add items to cart
public class ItemInterface extends JFrame{
    
    public final productInfo item;
    public final ShoppingCart cart;
    JTextField sizeInput;
    JTextField categoryInput;

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

        //shoe size input

        JPanel sizePanel = new JPanel();
        sizePanel.setPreferredSize(new Dimension(400, 30));
        JLabel sizeLabel = new JLabel("Enter size:");
        sizeLabel.setFont(AppTheme.smallFont);
        sizeLabel.setPreferredSize(new Dimension(80, 15));
        sizeInput = new JTextField();
        sizeInput.setPreferredSize(new Dimension(40, 15));
        sizePanel.add(sizeLabel);
        sizePanel.add(sizeInput);

        mainPanel.add(sizePanel);

        //category input
        JPanel categoryPanel = new JPanel();
        categoryPanel.setPreferredSize(new Dimension(600, 30));
        JLabel categoryLable = new JLabel("Mens or Womens");
        categoryLable.setFont(AppTheme.smallFont);
        categoryLable.setPreferredSize(new Dimension(100, 15));
        categoryInput = new JTextField();
        categoryInput.setPreferredSize(new Dimension(40, 15));
        categoryPanel.add(categoryLable);
        categoryPanel.add(categoryInput);

        mainPanel.add(categoryPanel);

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
        int selectedSize;
        try{
            selectedSize = Integer.parseInt(sizeInput.getText());        
        }
        catch(Exception e)
        {
            sizeInput.setBackground(AppTheme.red);
            return;
        }
        if(selectedSize < 1 || selectedSize > 15) 
        {
            sizeInput.setBackground(AppTheme.red);
            return;
        }

        String category = categoryInput.getText().toLowerCase();
        if(!category.equals("m") && !category.equals("w"))
        {
            categoryInput.setBackground(AppTheme.red);
            return;
        }
        
        cart.addProductToCart(item);
        dispose();
    }
}
