import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 Simple demonstration of changing visibility in an applet.
*/
public class VisibilityDemo extends JApplet implements ActionListener
{
    private JLabel response;
    private Container contentPane;

    public void init( )
    {
        contentPane = getContentPane( );
        contentPane.setBackground(Color.WHITE);

        //Create button:
        JButton aButton = new JButton("Push me!");
        aButton.addActionListener(this);

        //Create label:
        response = new JLabel("Thanks. That felt good!");
        ImageIcon smileyFaceIcon = new ImageIcon("smiley.gif");
        response.setIcon(smileyFaceIcon);
        response.setVisible(false);//Invisible until button is clicked

        //Add button:
        contentPane.setLayout(new FlowLayout( ));
        contentPane.add(aButton);

        //Add label
        contentPane.add(response);
    }

    public void actionPerformed(ActionEvent e)
    {
        contentPane.setBackground(Color.PINK);
        response.setVisible(true);//Show label
    }
}
