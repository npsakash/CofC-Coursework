
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.BorderLayout;
import java.awt.Container;

public class DukeApplet extends JApplet
{
    public void init( )
    {
        Container contentPane = getContentPane( );
        contentPane.setLayout(new BorderLayout( ));

        JLabel spacer = new JLabel("             ");
        contentPane.add(spacer, "West");
        JLabel friendlyLabel = new JLabel("Hello out there!");
        ImageIcon dukeIcon = new ImageIcon("duke_waving.gif");
        friendlyLabel.setIcon(dukeIcon);
        contentPane.add(friendlyLabel, BorderLayout.CENTER);
    }
}
