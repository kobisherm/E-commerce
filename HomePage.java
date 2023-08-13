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

public class HomePage extends JFrame{
	JButton searchButton;
	JPanel itemsPanel;
	public ShoppingCart cart = new ShoppingCart();
	int page = 0;

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
		
		JTextField searchBarText = new JTextField();
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
		
		itemsPanel = new JPanel(new GridLayout(3, 3 ,10, 10));
		itemsPanel.setPreferredSize(new Dimension((int)screenSize.getWidth(), 500));
		displayItems(Product.allProducts, itemsPanel);
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
	
	void displayItems(ArrayList <productInfo> productsList, JPanel panel)
	{
		if(page < 0) page = 0;

		int firstProductIndex = 9 * page;
		if(firstProductIndex >= productsList.size()) page -= 1;

		for(int i = firstProductIndex; i < firstProductIndex + 9; i++)
		{
			if(i >= productsList.size())
			{
				//no more items, empty cell
				panel.add(new JLabel());
				continue;
			}

			productInfo item = productsList.get(i);

			ImageIcon image = new ImageIcon(item.getImage());
			image = AppTheme.scaleImage(image, 0.1f);
			JButton display = new JButton(image);

			String itemName = "<b>" + item.getName().toUpperCase() + "</b><br>";
			String price = "$" + item.getPrice() + "<br>";
			String category = "Category: " + item.getCategory() + "<br>";
			String description = item.getDescription() + "<br>";
			String quantity = item.getStockQuantity() + " in stock";

			display.setText("<html>" + itemName + price + category + description + quantity + "</html>");

			display.setFont(AppTheme.smallFont);
			display.setHorizontalAlignment(JButton.LEFT);
			display.setHorizontalTextPosition(JButton.RIGHT);

			panel.add(display);
		}
	}

	void RefreshItems()
	{
		itemsPanel.removeAll();
		displayItems(Product.allProducts, itemsPanel);
		itemsPanel.revalidate();
		itemsPanel.repaint();
	}

	// *********************** BUTTON EVENTS **************************************
	public void onSearchClick()
	{
		System.out.println("pressed");
	}
	
	public void onCartClick()
	{
		cart.Shopping_Cart();
		System.out.println("going to cart page");
	}

	public void onCheckoutClick()
	{
		System.out.println("going to checkout page");
	}
	
	public void onLogoutClick()
	{
		Login login = new Login();
		login.loginScreen();
		dispose();
	}

	public void NextPage()
	{
		page += 1;
		RefreshItems();
	}

	public void PreviousPage()
	{
		page -= 1;
		RefreshItems();
	}
}