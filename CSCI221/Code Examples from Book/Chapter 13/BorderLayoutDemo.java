import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Container;

/**
 Simple demonstration of using a layout manager
 to arrange labels.
*/
public class BorderLayoutDemo extends JFrame
{
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    public BorderLayoutDemo( )
    {
        setSize(WIDTH, HEIGHT);
        addWindowListener(new WindowDestroyer( ));
        setTitle("Layout Demonstration");
        Container content = getContentPane( );

        content.setLayout(new BorderLayout( ));

        JLabel label1 = new JLabel("First label here.");
        content.add(label1, BorderLayout.NORTH);

        JLabel label2 = new JLabel("Second label there.");
        content.add(label2, BorderLayout.SOUTH);

        JLabel label3 = new JLabel("Third label anywhere.");
        content.add(label3, BorderLayout.CENTER);
    }

    /**
     Creates and displays a window of the class BorderLayoutDemo.
    */
    public static void main(String[] args)
    {
        BorderLayoutDemo gui = new BorderLayoutDemo( );
        gui.setVisible(true);
    }
}





