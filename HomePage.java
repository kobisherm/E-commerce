import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//TODO: FOLLOW TUTORIAL, ADD SEARCH BAR TEXT, LOGO, ETC...
public class HomePage extends JFrame{
	
	JButton searchButton;
	
	//Instead of display homepage
	public HomePage()
	{
		final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		final int screenCenterX = screenSize.width / 2;
		final int screenCenterY = screenSize.height / 2;
		final Font titleFont = new Font("SansSerif", Font.BOLD, 30);
		final Font mainFont = new Font("SansSerif", Font.PLAIN, 20);
		
		setTitle("Home page");
		setSize(screenSize);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel topBar = new JPanel();
		topBar.setPreferredSize(new Dimension(screenSize.width, 50));
		topBar.setBackground(new Color(235, 235, 245));
		topBar.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		JLabel title = new JLabel("Home");
		title.setFont(titleFont);
		title.setFocusable(true);
		
		JTextField searchBarText = new JTextField();
		searchBarText.setFont(mainFont);
		searchBarText.setPreferredSize(new Dimension(200, 40));
		searchBarText.setFocusable(true);
		
		searchButton = new JButton();
		searchButton.setFont(mainFont);
		searchButton.setPreferredSize(new Dimension(200, 40));
		searchButton.setText("Search");
		searchButton.setFocusable(false);
		searchButton.addActionListener(a -> System.out.println("pressed"));
		
		add(topBar, BorderLayout.NORTH);
		topBar.add(title);
		topBar.add(searchBarText);
		topBar.add(searchButton);
		
		setResizable(false);
		setVisible(true);
	}
}
