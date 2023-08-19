import static org.junit.Assert.*;
import org.junit.Test;
import java.awt.Dimension;

import javax.swing.ImageIcon;

public class AppThemeTest {

    @Test
    public void createStandardButtonTest(){
        assertNotEquals(null, AppTheme.createStandardButton("button"));
    }

    @Test
    public void createStandardButtonWidthTest(){
        assertEquals(17, AppTheme.createStandardButton("button", new Dimension(17, 8)).getPreferredSize().width);
    }

    //copy image path for logo
    @Test
    public void scaleImageWidthTest(){
        ImageIcon logo = new ImageIcon("C:\\Users\\Armon Lee\\VS_Code\\E-commerce\\Logo.png");
        assertEquals(4, AppTheme.scaleImage(logo, 4).getIconWidth());
    }

    //copy image path for logo
    @Test
    public void scaleImageMultiplierTest(){
        ImageIcon logo = new ImageIcon("C:\\Users\\Armon Lee\\VS_Code\\E-commerce\\Logo.png");
        assertEquals(logo.getIconWidth()/2+1, AppTheme.scaleImage(logo, 0.5f).getIconWidth());
    }




    

}
