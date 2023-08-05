import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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

//TODO: FOLLOW TUTORIAL, ADD SEARCH BAR TEXT, LOGO, ETC...
public class HomePage extends JFrame{
	
	JButton searchButton;
	
	//Instead of display homepage
	void HomePage()
	{
		final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		final Font titleFont = new Font("SansSerif", Font.BOLD, 30);
		final Font mainFont = new Font("SansSerif", Font.PLAIN, 20);
		ImageIcon logo = new ImageIcon("Logo.png");
		
		setTitle("Home page");
		setSize(screenSize);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout(0, 0, 0));
		setIconImage(logo.getImage());
		
		//THE FOLLOWING CONTROLS THE TOP BAR UI
		JPanel topBar = new JPanel();
		topBar.setPreferredSize(new Dimension(screenSize.width, 50));
		topBar.setBackground(Color.BLACK);
		topBar.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		JLabel homeLabel = new JLabel("Home");
		homeLabel.setFont(titleFont);
		homeLabel.setForeground(Color.WHITE);
		homeLabel.setFocusable(true);
		
		JTextField searchBarText = new JTextField();
		searchBarText.setFont(mainFont);
		searchBarText.setPreferredSize(new Dimension(200, 40));
		searchBarText.setFocusable(true);
		
		searchButton = new JButton();
		searchButton.setFont(mainFont);
		searchButton.setBackground(Color.GRAY);
		searchButton.setForeground(Color.WHITE);
		searchButton.setPreferredSize(new Dimension(200, 40));
		searchButton.setText("Search");
		searchButton.setFocusable(false);
		searchButton.addActionListener(a -> System.out.println("pressed"));
		
		//THE FOLLOWING CONTROLS THE UI UNDER THE TOP BAR
		JPanel appLogoBar = new JPanel();
		appLogoBar.setPreferredSize(new Dimension(screenSize.width, 150));
		appLogoBar.setBackground(new Color(150, 0, 0));
		appLogoBar.setLayout(new BorderLayout());
		
		JLabel appTitle = new JLabel("HI-LO");
		appTitle.setFont(titleFont);
		appTitle.setForeground(Color.WHITE);
		appTitle.setIcon(new ImageIcon(logo.getImage().getScaledInstance(125, 125, Image.SCALE_SMOOTH)));
		appTitle.setBorder(new EmptyBorder(0, 10, 0, 0));
		
		add(topBar);
		topBar.add(homeLabel);
		topBar.add(searchBarText);
		topBar.add(searchButton);
		
		add(appLogoBar);
		appLogoBar.add(appTitle);
		
		setResizable(false);
		setVisible(true);
	}
}