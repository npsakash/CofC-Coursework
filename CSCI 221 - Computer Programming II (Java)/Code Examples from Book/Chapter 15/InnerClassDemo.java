
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InnerClassDemo extends JFrame
{
    public static final int WIDTH = 300; 
    public static final int HEIGHT = 200;

    /**
     Creates and displays a window of the class InnerClassDemo.
    */
    public static void main(String[] args)
    {
        InnerClassDemo sampleGUI = new InnerClassDemo( );
        sampleGUI.setVisible(true);
    }
    
    public InnerClassDemo( )
    {
        setSize(WIDTH, HEIGHT);
        setTitle("Inner Class Demo");
        Container contentPane = getContentPane( );
        contentPane.setLayout(new BorderLayout( ));

        JLabel label = new JLabel(
                          "Please don't click that button!");
        contentPane.add(label, BorderLayout.CENTER);

        addWindowListener(new InnerDestroyer( ));
    }

    //An inner class with the same functionality
    //as the class WindowDestroyer.
    private class InnerDestroyer extends WindowAdapter
    {
        public void windowClosing(WindowEvent e) 
        {
            System.exit(0);
        }
    }
}
