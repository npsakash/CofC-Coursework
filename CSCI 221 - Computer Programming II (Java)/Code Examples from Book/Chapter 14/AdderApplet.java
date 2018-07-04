
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdderApplet extends JApplet 
                         implements ActionListener
{
    private JTextField inputOutputField;
    private double sum = 0;

    public void init( )
    {
        Container contentPane = getContentPane( );
        contentPane.setLayout(new BorderLayout( ));

        JPanel buttonPanel = new JPanel( );
        buttonPanel.setBackground(Color.GRAY);
        buttonPanel.setLayout(new FlowLayout( ));
		
        JButton addButton = new JButton("Add");
        addButton.addActionListener(this);
        buttonPanel.add(addButton);
		
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        buttonPanel.add(resetButton);
		
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        JPanel textPanel = new JPanel( );
        textPanel.setBackground(Color.BLUE);
        textPanel.setLayout(new FlowLayout( ));
		
        inputOutputField = 
                       new JTextField("Numbers go here.", 30);
        inputOutputField.setBackground(Color.WHITE);
        textPanel.add(inputOutputField);
		
        contentPane.add(textPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand( ).equals("Add"))
        {
            sum = sum +
                stringToDouble(inputOutputField.getText( ));
            inputOutputField.setText(Double.toString(sum));
        }
        else if (e.getActionCommand( ).equals("Reset"))
        {
            sum = 0;
            inputOutputField.setText("0.0");
        }
        else
            inputOutputField.setText("Error in adder code.");
    }

    private static double stringToDouble(String stringObject)
    {
        return Double.parseDouble(stringObject.trim( ));
    }
}






