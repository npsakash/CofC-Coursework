
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowListenerDemo extends JFrame
                   implements ActionListener, WindowListener
{
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    public WindowListenerDemo( )
    {
        setSize(WIDTH, HEIGHT);

        addWindowListener(this);
        setTitle("Window Listener Demonstration");
        Container content = getContentPane( );
        content.setBackground(Color.BLUE);

        content.setLayout(new FlowLayout( ));

        JButton stopButton = new JButton("Red");
        stopButton.addActionListener(this);
        content.add(stopButton);

        JButton goButton = new JButton("Green");
        goButton.addActionListener(this);
        content.add(goButton);
    }

    public void actionPerformed(ActionEvent e)
    {
        Container content = getContentPane( );
        if (e.getActionCommand( ).equals("Red"))
            content.setBackground(Color.RED);
        else if (e.getActionCommand( ).equals("Green"))
            content.setBackground(Color.GREEN);
        else
            System.out.println("Error in WindowListenerDemo.");
    }

    public void windowClosing(WindowEvent e)
    {
        this.dispose( );
        System.exit(0);
    }

    public void windowOpened(WindowEvent e)
    {}

    public void windowClosed(WindowEvent e)
    {}

    public void windowIconified(WindowEvent e)
    {}

    public void windowDeiconified(WindowEvent e)
    {}

    public void windowActivated(WindowEvent e)
    {}

    public void windowDeactivated(WindowEvent e)
    {}

    public static void main(String[] args)
    {
        WindowListenerDemo demoWindow = new WindowListenerDemo( );
        demoWindow.setVisible(true);
    }
}
