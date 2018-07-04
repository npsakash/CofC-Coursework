
import java.awt.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 If you register an object of this class as a listener to any
 object of the class JFrame, then if the user clicks the
 close-window button in the JFrame, the object of this class
 will end the program and close the JFrame.
*/
public class WindowDestroyer extends WindowAdapter
{
    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }
}
