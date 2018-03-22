
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 Simple demonstration of putting buttons in a panel.
*/
public class PanelDemo extends JFrame implements ActionListener
{
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    public static void main(String[] args)
    {
        PanelDemo guiWithPanel = new PanelDemo( );
        guiWithPanel.setVisible(true);
    }

    public PanelDemo( )
    {
        setSize(WIDTH, HEIGHT);
        addWindowListener(new WindowDestroyer( ));
        setTitle("Panel Demonstration");
        Container contentPane = getContentPane( );
        contentPane.setBackground(Color.BLUE);
        contentPane.setLayout(new BorderLayout( ));

        JPanel buttonPanel = new JPanel( );
        buttonPanel.setBackground(Color.WHITE);

        buttonPanel.setLayout(new FlowLayout( ));

        JButton stopButton = new JButton("Red");
        stopButton.setBackground(Color.RED);
        stopButton.addActionListener(this);
        buttonPanel.add(stopButton);

        JButton goButton = new JButton("Green");
        goButton.setBackground(Color.GREEN);
        goButton.addActionListener(this);
        buttonPanel.add(goButton);

        contentPane.add(buttonPanel, BorderLayout.SOUTH);
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
}
