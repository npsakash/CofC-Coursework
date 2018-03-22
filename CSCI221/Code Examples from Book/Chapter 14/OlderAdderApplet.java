
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.Applet;

public class OlderAdderApplet extends Applet implements ActionListener
{
    private TextField inputOutputField;
    private double sum = 0;

    public void init()
    {
        setLayout(new BorderLayout());

        Panel buttonPanel = new Panel();
        buttonPanel.setBackground(Color.gray);
        buttonPanel.setLayout(new FlowLayout());
        Button addButton = new Button("Add");
        addButton.addActionListener(this);
        buttonPanel.add(addButton);
        Button resetButton = new Button("Reset");
        resetButton.addActionListener(this);
        buttonPanel.add(resetButton);
        add(buttonPanel, BorderLayout.SOUTH);

        Panel textPanel = new Panel();
        textPanel.setBackground(Color.blue);
        textPanel.setLayout(new FlowLayout());
        inputOutputField = new TextField("Numbers go here.", 30);
        inputOutputField.setBackground(Color.white);
        textPanel.add(inputOutputField);
        add(textPanel, BorderLayout.CENTER);
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

