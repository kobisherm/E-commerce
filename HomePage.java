import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Products.*;

/**
 * <p>
 * Class/Module name: HomePage
 * @since 1.0 (2023-08)
 * @author Kobi Sherman
 * Description:
 * This class represents the home page window that the user interacts with.
 * The class contains and organizes the elements of the home page, 
 * and it also links buttons to the actions they perform. 
 * This class also supports page navigation to display the various products.
 * </p>
 */
public class HomePage extends JFrame{
	Store store = new Store();
	ArrayList<productInfo> productsToDisplay;
	
	JTextField searchBarText;
	JButton searchButton;
	JPanel itemsPanel;
	public ShoppingCart cart = new ShoppingCart();
	int page = 0;

public HomePage(ShoppingCart _cart)
{
	cart = _cart;
}

/**
 * <p>
 * Class/Module name: HomePage
 * @since 1.0 (2023-08)
 * @author Kobi Sherman
 * Description:
 * This function creates and sets the elements of the homePage instance.
 * The home page is created using javax.swing and java.awt functionalities.
 * </p>
 */
	void DisplayHomePage()
	{
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		setTitle("Home page");
		setSize(screenSize);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout(0, 0, 0));
		setIconImage(AppTheme.logo.getImage());
		
		//THE FOLLOWING CONTROLS THE TOP BAR UI
		JPanel topBar = new JPanel();
		topBar.setPreferredSize(new Dimension(screenSize.width, 50));
		topBar.setBackground(AppTheme.black);
		topBar.setBorder(BorderFactory.createLineBorder(AppTheme.black, 1));
		
		JLabel homeLabel = new JLabel("Home");
		homeLabel.setFont(AppTheme.titleFont);
		homeLabel.setForeground(AppTheme.white);
		homeLabel.setFocusable(true);
		
		searchBarText = new JTextField();
		searchBarText.setFont(AppTheme.mainFont);
		searchBarText.setPreferredSize(new Dimension(200, 40));
		searchBarText.setFocusable(true);
		
		searchButton = AppTheme.createStandardButton("Search...", new Dimension(150, 40));
		searchButton.addActionListener(a -> onSearchClick());
		
		//To create a space
		JLabel space = new JLabel();
		space.setPreferredSize(new Dimension(400, 1));
		space.setFocusable(false);
		
		JButton myCartButton = AppTheme.createStandardButton("My Cart", new Dimension(150, 40));
		myCartButton.addActionListener(a -> onCartClick());
		
		JButton checkoutButton = AppTheme.createStandardButton("Checkout", new Dimension(150, 40));
		checkoutButton.addActionListener(a -> onCheckoutClick());
		
		JButton LogOutButton = AppTheme.createStandardButton("Log out", new Dimension(150, 40));
		LogOutButton.addActionListener(a -> onLogoutClick());
		
		//THE FOLLOWING CONTROLS THE UI UNDER THE TOP BAR
		JPanel appLogoBar = new JPanel();
		appLogoBar.setPreferredSize(new Dimension(screenSize.width, 150));
		appLogoBar.setBackground(AppTheme.darkRed);
		appLogoBar.setLayout(new BorderLayout());
		
		JLabel appTitle = new JLabel(" HI-LO");
		appTitle.setFont(AppTheme.titleFont);
		appTitle.setForeground(AppTheme.white);
		appTitle.setIcon(AppTheme.scaleImage(AppTheme.logo, 0.3255f));
		appTitle.setBorder(new EmptyBorder(0, 10, 0, 0));
		
		add(topBar);
		topBar.add(homeLabel);
		topBar.add(searchBarText);
		topBar.add(searchButton);
		topBar.add(space);
		topBar.add(myCartButton);
		topBar.add(checkoutButton);
		topBar.add(LogOutButton);
		 
		add(appLogoBar);
		appLogoBar.add(appTitle);
		
		productsToDisplay = Product.allProducts;
		itemsPanel = new JPanel(new GridLayout(3, 3 ,10, 10));
		itemsPanel.setPreferredSize(new Dimension((int)screenSize.getWidth(), 500));
		displayItems(itemsPanel);
		add(itemsPanel);

		JPanel navigationPanel = new JPanel();
		add(navigationPanel);

		navigationPanel.setPreferredSize(new Dimension((int)screenSize.getWidth(), 40));
		JButton previousPageBtn = AppTheme.createStandardButton("Back");
		previousPageBtn.addActionListener(x -> PreviousPage());
		navigationPanel.add(previousPageBtn);
		JButton nextPageBtn = AppTheme.createStandardButton("Next");
		nextPageBtn.addActionListener(x -> NextPage());
		navigationPanel.add(nextPageBtn);

		setResizable(false);
		setVisible(true);
	}
	
/**
 * <p>
 * Class/Module name: HomePage
 * @since 1.0 (2023-08)
 * @author Kobi Sherman
 * Description:
 * This function adds the appropriate items to the items panel, so that they are displayed
 * in the homePage. This function depends on the current page. 
 * @param producstList - The total list of filtered or unfiltered search results to display.
 * @param panel - The target panel to contain the item displays.
 * </p>
 */
	void displayItems(JPanel panel)
	{
		if(page < 0) page = 0;

		int firstProductIndex = 9 * page;
		if(firstProductIndex >= productsToDisplay.size()) page -= 1;

		for(int i = firstProductIndex; i < firstProductIndex + 9; i++)
		{
			if(i >= productsToDisplay.size())
			{
				//no more items, empty cell
				panel.add(new JLabel());
				continue;
			}

			productInfo item = productsToDisplay.get(i);

			ImageIcon image = new ImageIcon(item.getImage());
			image = AppTheme.scaleImage(image, 0.1f);
			JButton display = new JButton(image);
			display.addActionListener(x -> OnItemClick(item));

			String itemName = "<b>" + item.getName().toUpperCase() + "</b><br>";
			String price = "$" + item.getPrice() + "<br>";
			String category = "Category: " + item.getCategory() + "<br>";
			String description = item.getDescription() + "<br>";

			display.setText("<html>" + itemName + price + category + description + "</html>");

			display.setFont(AppTheme.smallFont);
			display.setHorizontalAlignment(JButton.LEFT);
			display.setHorizontalTextPosition(JButton.RIGHT);

			panel.add(display);
		}
	}

/**
 * <p>
 * Class/Module name: HomePage
 * @since 1.0 (2023-08)
 * @author Kobi Sherman
 * Description:
 * This function redraws the home page, and is called after the current page is updated 
 * to display the correct items. 
 * </p>
 */
	void refreshItems()
	{
		itemsPanel.removeAll();
		displayItems(itemsPanel);
		itemsPanel.revalidate();
		itemsPanel.repaint();
	}

	// *********************** BUTTON EVENTS **************************************
	public void onSearchClick()
	{
		String searchText = searchBarText.getText();
		if(searchText == null || searchText.equals(""))
			productsToDisplay = Product.allProducts;
		else
			productsToDisplay = store.searchProduct(searchText);

		if(productsToDisplay.size() == 0) System.out.println("uh oh");
		refreshItems();
	}
	
	public void onCartClick()
	{
		cart.displayShoppingCart();
	}

	public void onCheckoutClick()
	{
		Order shoe = new Order();
		shoe.DisplayOrderScreen();
		System.out.println("going to checkout page");
	}
	
	public void onLogoutClick()
	{
		if(cart.frame != null){
			cart.frame.dispose();
		}
		Login login = new Login();
		login.loginScreen();
		dispose();
	}

	public void NextPage()
	{
		page += 1;
		refreshItems();
	}

	public void PreviousPage()
	{
		page -= 1;
		refreshItems();
	}

	public void OnItemClick(productInfo item)
	{
		new ItemInterface(item, cart);
	}
}