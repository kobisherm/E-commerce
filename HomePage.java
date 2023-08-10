import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class HomePage extends JFrame{
	JButton searchButton;
	
	//Instead of display homepage
	void DisplayHomePage()
	{
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
		appTitle.setIcon(new ImageIcon(AppTheme.logo.getImage().getScaledInstance(125, 125, Image.SCALE_SMOOTH)));
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
		
		setResizable(false);
		setVisible(true);
	}
	
	// *********************** BUTTON EVENTS **************************************
	public void onSearchClick()
	{
		System.out.println("pressed");
	}
	
	public void onCartClick()
	{
		System.out.println("going to cart page");
	}

	public void onCheckoutClick()
	{
		System.out.println("going to checkout page");
	}
	
	public void onLogoutClick()
	{
		System.out.println("Log out");
	}
}