import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Oracle extends JApplet implements ActionListener
{
    public static int LINES = 5;
    public static int CHAR_PER_LINE = 40;

    private JTextArea theText;
    private String question;
    private String answer;
    private String advice;

    public void init()
    {
        Container contentPane = getContentPane( );
        contentPane.setLayout(new FlowLayout( ));

        JLabel instructions =
            new JLabel("I will answer any question, " +
                       "but may need some advice from you.");
        contentPane.add(instructions);

        JButton getAnswerButton = new JButton("Get Answer");
        getAnswerButton.addActionListener(this);
        contentPane.add(getAnswerButton);

        JButton sendAdviceButton = new JButton("Send Advice");
        sendAdviceButton.addActionListener(this);
        contentPane.add(sendAdviceButton);

        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        contentPane.add(resetButton);

        theText = new JTextArea(LINES, CHAR_PER_LINE);
        theText.setText("Questions and advice go here.");
        contentPane.add(theText);

        answer = 
            "The answer is: Look around."; //first answer
    }

    public void actionPerformed(ActionEvent e)
    {
        String actionCommand = e.getActionCommand( );
        if (actionCommand.equals("Get Answer"))
        {
            question = theText.getText();
            theText.setText("That is a difficult question.\n" +
                            "Please give me some advice\n" +
                            "and click the Send Advice button.");
		}
        else if (actionCommand.equals("Send Advice"))
        {
            advice = theText.getText();
            theText.setText("That advice helped.\n" +
                         "You asked the question: " + question +
                         "\n" + answer +
                         "\nClick the Reset button and" +
                         "\nleave the program on for others.");
            answer = "The answer is: " + advice;
        }
        else if (actionCommand.equals("Reset"))
        {
            theText.setText("Questions and advice go here.");
        }
        else
            theText.setText("Error");
     }
}

