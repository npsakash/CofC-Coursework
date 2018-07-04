import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisibilityDemo extends JFrame
                            implements ActionListener
{
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    private JLabel upLabel;
    private JLabel downLabel;

    public VisibilityDemo( )
    {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Visibility Demonstration");
        Container contentPane = getContentPane( );
        contentPane.setLayout(new BorderLayout( ));
        contentPane.setBackground(Color.WHITE);

        upLabel = new JLabel("Here I am up here!");
        contentPane.add(upLabel, BorderLayout.NORTH);
        upLabel.setVisible(false);
        downLabel = new JLabel("Here I am down here!");
        contentPane.add(downLabel, BorderLayout.SOUTH);
        downLabel.setVisible(false);

        JPanel buttonPanel = new JPanel( );
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setLayout(new FlowLayout( ));
        JButton upButton = new JButton("Up");
        upButton.addActionListener(this);
        buttonPanel.add(upButton);
        JButton downButton = new JButton("Down");
        downButton.addActionListener(this);
        buttonPanel.add(downButton);
        contentPane.add(buttonPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e)
    {
		if (e.getActionCommand( ).equals("Up"))
		{
			upLabel.setVisible(true);
			downLabel.setVisible(false);
			validate( ); //Update graphics
		}
		else if (e.getActionCommand( ).equals("Down"))
		{
			downLabel.setVisible(true);
			upLabel.setVisible(false);
			validate( ); //Update graphics
		}
		else
		    System.out.println("Error in VisibilityDemo interface.");
    }

    public static void main(String[] args)
    {
		VisibilityDemo demoGui = new VisibilityDemo( );
        demoGui.setVisible(true);
    }
}
