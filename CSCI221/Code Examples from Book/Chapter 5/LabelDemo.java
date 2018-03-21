
import javax.swing.JApplet;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

/**
 An applet that uses a label to display text.
*/
public class LabelDemo extends JApplet
{
    public void init( )
    {
        Container contentPane = getContentPane( );
        contentPane.setBackground(Color.WHITE);

        //Create labels:
        JLabel label1 = new JLabel("Hello ");
        JLabel label2 = new JLabel("out there!");

        //Add labels:
        contentPane.setLayout(new FlowLayout( ));
        contentPane.add(label1);
        contentPane.add(label2);
    }
}
