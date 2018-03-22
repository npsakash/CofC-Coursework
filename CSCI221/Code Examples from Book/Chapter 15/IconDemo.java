import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 Simple demonstration of putting icons in buttons and labels.
*/
public class IconDemo extends JFrame implements ActionListener
{
    public static final int WIDTH = 400;
    public static final int HEIGHT = 200;
    private JTextField message;

    public IconDemo( )
    {
        setSize(WIDTH, HEIGHT);
        addWindowListener(new WindowDestroyer( ));
        setTitle("Icon Demonstration");
        Container content = getContentPane( );
        content.setBackground(Color.WHITE);
        content.setLayout(new BorderLayout( ));

        JLabel niceLabel = new JLabel("Nice day!");
        ImageIcon smileyIcon = new ImageIcon("smiley.gif");
        niceLabel.setIcon(smileyIcon);
        content.add(niceLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel( );
        buttonPanel.setLayout(new FlowLayout( ));
        JButton helloButton = new JButton("Hello");
        ImageIcon dukeWavingIcon = new ImageIcon("duke_waving.gif");
        helloButton.setIcon(dukeWavingIcon);
        helloButton.addActionListener(this);
        buttonPanel.add(helloButton);
        JButton byeButton = new JButton("Good bye");
        ImageIcon dukeStandingIcon =
                  new ImageIcon("duke_standing.gif");
        byeButton.setIcon(dukeStandingIcon);
        byeButton.addActionListener(this);
        buttonPanel.add(byeButton);
        content.add(buttonPanel, BorderLayout.SOUTH);

        message = new JTextField(30);
        content.add(message, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e)
    {
       if (e.getActionCommand( ).equals("Hello"))
           message.setText("Glad to meet you!");
       else if (e.getActionCommand( ).equals("Good bye"))
           message.setText(
                  "OK, click the upper right button. I'll miss you.");
       else
           System.out.println("Error in button interface.");
    }

    /**
     Creates and displays a window of the class IconDemo.
    */
    public static void main(String[] args)
    {
        IconDemo iconGui = new IconDemo( );
        iconGui.setVisible(true);
    }
}
