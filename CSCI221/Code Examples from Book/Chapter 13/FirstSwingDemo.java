
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 A simple demonstration of a window constructed using Swing.
*/
public class FirstSwingDemo
{
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    public static void main(String[] args)
    {
        JFrame myWindow = new JFrame( );
        myWindow.setSize(WIDTH, HEIGHT);
        JLabel myLabel =
                   new JLabel("Please don’t click that button!");
        myWindow.getContentPane( ).add(myLabel);

        WindowDestroyer myListener = new WindowDestroyer( );
        myWindow.addWindowListener(myListener);

        myWindow.setVisible(true);
    }
}
