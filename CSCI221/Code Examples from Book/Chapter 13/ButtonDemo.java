
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 Simple demonstration of putting buttons in a JFrame.
*/
public class ButtonDemo extends JFrame implements ActionListener
{
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    public ButtonDemo( )
    {
        setSize(WIDTH, HEIGHT);

        addWindowListener(new WindowDestroyer( ));
        setTitle("Button Demo");
        Container contentPane = getContentPane( );
        contentPane.setBackground(Color.BLUE);

        contentPane.setLayout(new FlowLayout( ));

        JButton stopButton = new JButton("Red");
        stopButton.addActionListener(this);
        contentPane.add(stopButton);

        JButton goButton = new JButton("Green");
        goButton.addActionListener(this);
        contentPane.add(goButton);
    }

    public void actionPerformed(ActionEvent e)
    {
       Container contentPane = getContentPane( );

       if (e.getActionCommand( ).equals("Red"))
           contentPane.setBackground(Color.RED);
       else if (e.getActionCommand( ).equals("Green"))
           contentPane.setBackground(Color.GREEN);
       else
           System.out.println("Error in button interface.");
    }

    /**
     Creates and displays a window of the class ButtonDemo.
    */
    public static void main(String[] args)
    {
        ButtonDemo buttonGui = new ButtonDemo( );
        buttonGui.setVisible(true);
    }
}

