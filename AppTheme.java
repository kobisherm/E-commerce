import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Dimension;

/**
 * Utility class that contains graphics and color data to be used on various pages
 * @author Kobi Sherman
 */
public final class AppTheme {
    public static final Font titleFont = new Font("SansSerif", Font.BOLD, 30);
	public static final Font mainFont = new Font("SansSerif", Font.PLAIN, 20);
	public static final Font smallFont = new Font("SansSerif", Font.PLAIN, 12);

    public static final Color black = Color.black;
    public static final Color white = Color.white;
    public static final Color darkRed = new Color(150, 0, 0);
	public static final Color red = Color.red;
    public static final Color gray = Color.gray;

    public static final ImageIcon logo = new ImageIcon("Logo.png");

    public static JButton createStandardButton(String text, Dimension size)
	{
		JButton btn = new JButton(text);
		btn.setFont(AppTheme.mainFont);
		btn.setBackground(AppTheme.gray);
		btn.setForeground(AppTheme.black);
		btn.setPreferredSize(size);
		btn.setFocusable(false);
		return btn;
	}

	public static ImageIcon scaleImage(ImageIcon image, float scale)
	{
		int width = (int)(image.getIconWidth() * scale);
		int height = (int)(image.getIconHeight() * scale);
		return new ImageIcon(image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
	}
}
