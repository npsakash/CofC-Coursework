import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;

public class IconDemo extends JApplet
{
    public void init( )
    {
        JLabel niceLabel = new JLabel("Java is fun!");
        ImageIcon dukeIcon = new ImageIcon("duke_waving.gif");
        niceLabel.setIcon(dukeIcon);
        getContentPane( ).add(niceLabel);
    }
}
