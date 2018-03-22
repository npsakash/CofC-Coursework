
import javax.swing.JApplet;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.FlowLayout;

public class HelloApplet extends JApplet
{
    public void init( )
    {
        Container contentPane = getContentPane( );
        contentPane.setLayout(new FlowLayout( ));
        JLabel friendlyLabel = new JLabel("Hello out there!");
        contentPane.add(friendlyLabel);
    }
}
