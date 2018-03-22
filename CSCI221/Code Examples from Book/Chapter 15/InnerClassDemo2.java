import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 Demonstration of invoking a method of the outer
 class within an inner class.
*/
public class InnerClassDemo2 extends JFrame
{
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    public static void main(String[] args)
    {
        InnerClassDemo2 gui = new InnerClassDemo2();
        gui.setVisible(true);
    }

    public InnerClassDemo2()
    {
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(
                WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new InnerDestroyer());
        setTitle("Close Window Demo");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        JLabel message = new JLabel(
                         "Please don't click that button.");
        contentPane.add(message, BorderLayout.CENTER);
    }

    public void blushMainWindow()
    {
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.PINK);
        repaint();
    }

    public void unBlushMainWindow()
    {
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.WHITE);
        repaint();
    }

	//INNER CLASS
    //Displays a window that checks if the user wants to exit.
    private class InnerDestroyer extends WindowAdapter
    {
        public void windowClosing(WindowEvent e)
        {
            ConfirmWindow askWindow = new ConfirmWindow();
            askWindow.setVisible(true);
        }
    }

	//ANOTHER INNER CLASS
    //Designed to be used with the inner class InnerDestroyer in
    //the class CloseWindowDemo. Checks if the user wants to exit.
    private class ConfirmWindow extends JFrame
                                implements ActionListener
    {
        public static final int WIDTH = 200;
        public static final int HEIGHT = 100;

        public ConfirmWindow()
        {
			blushMainWindow(); //Invocation of an outer-class method
            setSize(WIDTH, HEIGHT);
            Container confirmContent = getContentPane();
            confirmContent.setBackground(Color.WHITE);
            confirmContent.setLayout(new BorderLayout());

            JLabel msgLabel = new JLabel(
                           "Are you sure you want to exit?");
            confirmContent.add(msgLabel, BorderLayout.CENTER);

            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new FlowLayout());

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
            if (e.getActionCommand().equals("Yes"))
                System.exit(0);
            else if (e.getActionCommand().equals("No"))
            {
				unBlushMainWindow();
                dispose();//Destroys only the ConfirmWindow.
            }
            else
                System.out.println("Error in Confirm Window.");
        }
   }
}
