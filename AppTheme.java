import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Dimension;

/**
 * <p>
 * Class/Module name: AppTheme
 * @since 1.0 (2023-08)
 * @author Kobi Sherman
 * Description:
 * This is a utility class that contains graphics and color data to be used on various pages of the App
 * The class contains various colors, Fonts, and Images that are used throughout the app
 * </p>
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

/**
 * <p>
 * Class/Module name: AppTheme
 * @since 1.0 (2023-08)
 * @author Kobi Sherman
 * Description:
 * This function creates a JButton with a specific, consistance style that is used throught the app.
 * @return a JButton that is formatted in a consistent, standard way. 
 * @param text - The text displayed by the button
 * @param size - The size of the JButton to be created
 * </p>
 */
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

/**
 * <p>
 * Class/Module name: AppTheme
 * @since 1.0 (2023-08)
 * @author Kobi Sherman
 * Description:
 * This function creates a JButton with a specific, consistance style that is used throught the app.
 * Method overloading is used.
 * @return a JButton that is formatted in a consistent, standard way. 
 * @param text - The text displayed by the button
 * </p>
 */
	public static JButton createStandardButton(String text)
	{
		JButton btn = new JButton(text);
		btn.setFont(AppTheme.mainFont);
		btn.setBackground(AppTheme.gray);
		btn.setForeground(AppTheme.black);
		btn.setFocusable(false);
		return btn;
	}

/**
 * <p>
 * Class/Module name: AppTheme
 * @since 1.0 (2023-08)
 * @author Kobi Sherman
 * Description:
 * This function takes in an ImageIcon and returns a scaled version of it.
 * @return an ImageIcon that is a scaled version of an original ImageIcon.
 * @param image - the original unscaled image
 * @param scale - a float multiplier to scale the image by
 * </p>
 */
	public static ImageIcon scaleImage(ImageIcon image, float scale)
	{
		int width = 1 + (int)(image.getIconWidth() * scale);
		int height = 1 + (int)(image.getIconHeight() * scale);
		return new ImageIcon(image.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
	}

	public static ImageIcon scaleImage(ImageIcon image, int newWidth)
	{
		float scale = (float)newWidth / image.getIconWidth();
		int newHeight = 1 + (int)(image.getIconHeight() * scale);
		return new ImageIcon(image.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH));
	}
}
