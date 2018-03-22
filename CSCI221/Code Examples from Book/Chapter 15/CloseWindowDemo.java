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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 Demonstration of programming the close-window button.
*/
public class CloseWindowDemo extends JFrame
{
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    public CloseWindowDemo( )
    {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(
                WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new InnerDestroyer( ));
        setTitle("Close Window Demo"); 
        Container contentPane = getContentPane( );
        contentPane.setLayout(new BorderLayout( ));

        JLabel message = new JLabel(
                             "Please don't click that button.");
        contentPane.add(message, BorderLayout.CENTER);
    }

    //An inner class that is the window listener.
    private class InnerDestroyer extends WindowAdapter
    {
        //Displays a window that checks if the user wants to exit.
        public void windowClosing(WindowEvent e) 
        {
            ConfirmWindow askWindow = new ConfirmWindow( );
            askWindow.setVisible(true);
        }
    }
    
    //An inner class to be used with the inner class 
    //InnerDestroyer. Checks if the user wants to exit.
	private class ConfirmWindow extends JFrame
                                implements ActionListener
    {
        public static final int WIDTH = 200;
        public static final int HEIGHT = 100;

        public ConfirmWindow( )
        {
            setSize(WIDTH, HEIGHT);
            Container confirmContent = getContentPane( );
            confirmContent.setBackground(Color.WHITE);
            confirmContent.setLayout(new BorderLayout( ));

            JLabel msgLabel = new JLabel(
                           "Are you sure you want to exit?");
            confirmContent.add(msgLabel, BorderLayout.CENTER);

            JPanel buttonPanel = new JPanel( );
            buttonPanel.setLayout(new FlowLayout( ));

            JButton exitButton = new JButton("Yes");
            exitButton.addActionListener(this);
            buttonPanel.add(exitButton);

            JButton cancelButton = new JButton("No");
            cancelButton.addActionListener(this);
            buttonPanel.add(cancelButton);

            confirmContent.add(buttonPanel, BorderLayout.SOUTH);
        }

        public void actionPerformed(ActionEvent e) 
        {
            if (e.getActionCommand( ).equals("Yes")) 
                System.exit(0);
            else if (e.getActionCommand( ).equals("No"))
                dispose( );//Destroys only the ConfirmWindow.
            else
                System.out.println("Error in Confirm Window.");
        }
    }

    public static void main(String[] args)
    {
        CloseWindowDemo gui = new CloseWindowDemo( );
        gui.setVisible(true);
    }
}
