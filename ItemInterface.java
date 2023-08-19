import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Products.productInfo;

/**
 * <p>
 * Class/Module name: ItemInterface
 * @since 1.0 (2023-10)
 * @author Kobi Sherman
 * Description:
 * This class represents the pop-up window that allows adding items to cart.
 * The class contains the necessary GUI components to repond to user input, 
 * and it also performs validation checkin for the requested fields.
 * </p>
 */
public class ItemInterface extends JFrame{
    
    public final productInfo item;
    public final ShoppingCart cart;
    JTextField sizeInput;
    JTextField categoryInput;

/**
 * <p>
 * Class/Module name: ItemInterface
 * @since 1.0 (2023-10)
 * @author Kobi Sherman
 * Description:
 * This function creates a new instance of the ItemInterface window.
 * @param item - The product requested to add to cart
 * @param cart - The shopping cart in which to add the item
 * </p>
 */
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

/**
 * <p>
 * Class/Module name: ItemInterface
 * @since 1.0 (2023-10)
 * @author Kobi Sherman
 * Description:
 * This function is called when the user clickes the 'Yes' button. 
 * Input validation in performed, and the item is added to the cart.
 * </p>
 */
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
