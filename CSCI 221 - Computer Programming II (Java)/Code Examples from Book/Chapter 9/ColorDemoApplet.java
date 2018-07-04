
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorDemoApplet extends JApplet implements ActionListener
{
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
    public static final int NUMBER_OF_CHAR = 20;

    private JTextField colorName;

    public void init()
    {
        Container contentPane = getContentPane( );
        contentPane.setBackground(Color.GRAY);
        contentPane.setLayout(new FlowLayout( ));

        JButton showButton = new JButton("Show Color");
        showButton.addActionListener(this);
        contentPane.add(showButton);

        colorName = new JTextField(NUMBER_OF_CHAR);
        contentPane.add(colorName);
    }

    public void actionPerformed(ActionEvent e)
    {
        Container contentPane = getContentPane( );

        try
        {
            contentPane.setBackground(
                     getColor(colorName.getText()));
        }
        catch(UnknownColorException exception)
        {
           colorName.setText("Unknown Color");
           contentPane.setBackground(Color.GRAY);
        }
    }

    public Color getColor(String name) throws UnknownColorException
    {
        if (name.equalsIgnoreCase("RED"))
            return Color.RED;
        else if (name.equalsIgnoreCase("WHITE"))
            return Color.WHITE;
        else if (name.equalsIgnoreCase("BLUE"))
            return Color.BLUE;
        else if (name.equalsIgnoreCase("GREEN"))
            return Color.GREEN;
        else
            throw new UnknownColorException();
    }
}
