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
public class SetActionCommandDemo extends JFrame implements ActionListener
{
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    /**
     Creates and displays a window of the class SetActionCommandDemo.
    */
    public static void main(String[] args)
    {
        SetActionCommandDemo buttonGui = new SetActionCommandDemo();
        buttonGui.setVisible(true);
    }

    public SetActionCommandDemo()
    {
        setSize(WIDTH, HEIGHT);

        addWindowListener(new WindowDestroyer());
        setTitle("SetActionCommand Demo");
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.BLUE);

        contentPane.setLayout(new FlowLayout());

        JButton stopButton = new JButton("Red");
        stopButton.setActionCommand("Stop");
        stopButton.addActionListener(this);
        contentPane.add(stopButton);

        JButton goButton = new JButton("Green");
        goButton.setActionCommand("Go");
        goButton.addActionListener(this);
        contentPane.add(goButton);
    }

    public void actionPerformed(ActionEvent e)
    {
       Container contentPane = getContentPane();

       if (e.getActionCommand().equals("Stop"))
           contentPane.setBackground(Color.RED);
       else if (e.getActionCommand().equals("Go"))
           contentPane.setBackground(Color.GREEN);
       else
           System.out.println("Error in button interface.");
    }
}
