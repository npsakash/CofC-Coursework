import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 Class to demonstrate adding borders to components.
*/
public class BorderDemo extends JFrame implements ActionListener
{
    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;
 
    private JTextField name; 

    public BorderDemo( )
    {
        setTitle("Name Tester with Borders");
        setSize(WIDTH, HEIGHT);
        addWindowListener(new WindowDestroyer( ));
        Container content = getContentPane( );
        content.setLayout(new GridLayout(2, 1));
 
        JPanel namePanel = new JPanel( ); 
        namePanel.setLayout(new BorderLayout( )); 
        namePanel.setBackground(Color.WHITE);
     
        name = new JTextField(20);
        //The following border is not as dramatic as others,
        //but look closely and you will see it.
        name.setBorder(new EtchedBorder(Color.GREEN, Color.BLUE));
        namePanel.add(name, BorderLayout.SOUTH); 
        JLabel nameLabel = new JLabel("Enter your name here:");
        //The following does insert space around the label.
        //To see the difference, comment out the following line:
        nameLabel.setBorder(new EmptyBorder(20, 10, 0, 0));
        namePanel.add(nameLabel, BorderLayout.CENTER);

        namePanel.setBorder(new LineBorder(Color.BLACK, 10));
        content.add(namePanel);
    
        JPanel buttonPanel = new JPanel( );
        buttonPanel.setLayout(new FlowLayout( ));
        JButton testButton = new JButton("Test");
        testButton.addActionListener(this); 
        testButton.setBorder(new BevelBorder(BevelBorder.LOWERED));
        buttonPanel.add(testButton);

        JButton clearButton = new JButton("Clear"); 
        clearButton.addActionListener(this); 
        clearButton.setBorder(new BevelBorder(BevelBorder.RAISED));
        buttonPanel.add(clearButton); 
      
        buttonPanel.setBorder(
                    new MatteBorder(60, 40, 30, 20, Color.PINK));
        content.add(buttonPanel);
    }

    public void actionPerformed(ActionEvent e) 
    {
        if (e.getActionCommand( ).equals("Test"))
            name.setText("A very good name!");
        else if (e.getActionCommand( ).equals("Clear"))
            name.setText("");
        else
            name.setText("Error in window interface.");
    } 
 
    public static void main(String[] args)
    {
        BorderDemo w = new BorderDemo( );
        w.setVisible(true);
    }
}

