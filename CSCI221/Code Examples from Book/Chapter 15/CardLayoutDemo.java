import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutDemo extends JFrame implements ActionListener
{
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    private CardLayout dealer;
    private JPanel deckPanel;

    public CardLayoutDemo( )
    {
        setSize(WIDTH, HEIGHT);
        addWindowListener(new WindowDestroyer( ));
        setTitle("CardLayout Demonstration");
        Container contentPane = getContentPane( );
        contentPane.setLayout(new BorderLayout( ));

        deckPanel = new JPanel( );
        dealer = new CardLayout( );
        deckPanel.setLayout(dealer);

        JPanel startCardPanel = new JPanel( );
        startCardPanel.setLayout(new FlowLayout( ));
        startCardPanel.setBackground(Color.LIGHT_GRAY);
        JLabel startLabel = new JLabel("Hello");
        startCardPanel.add(startLabel);
        deckPanel.add("start", startCardPanel);

        JPanel greenCardPanel = new JPanel( );
        greenCardPanel.setLayout(new FlowLayout( ));
        greenCardPanel.setBackground(Color.GREEN);
        JLabel goLabel = new JLabel("Go");
        greenCardPanel.add(goLabel);
        deckPanel.add("green", greenCardPanel);

        JPanel redCardPanel = new JPanel( );
        redCardPanel.setLayout(new FlowLayout( ));
        redCardPanel.setBackground(Color.RED);
        JLabel stopLabel = new JLabel("Stop");
        redCardPanel.add(stopLabel);
        deckPanel.add("red", redCardPanel);

        contentPane.add(deckPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel( );
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.setLayout(new FlowLayout( ));
        JButton stopButton = new JButton("Red");
        stopButton.addActionListener(this);
        buttonPanel.add(stopButton);
        JButton goButton = new JButton("Green");
        goButton.addActionListener(this);
        buttonPanel.add(goButton);
        JButton resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        buttonPanel.add(resetButton);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        dealer.first(deckPanel);//Optional
   }


   public void actionPerformed(ActionEvent e)
   {
       String actionCommand = e.getActionCommand( );

       if (actionCommand.equals("Red"))
           dealer.show(deckPanel, "red");
       else if (actionCommand.equals("Green"))
           dealer.show(deckPanel, "green");
       else if (actionCommand.equals("Reset"))
           dealer.show(deckPanel, "start");
       else
           System.out.println("Error in CardLayout Demo.");
    }


    public static void main(String[] args)
    {
        CardLayoutDemo demoGui = new CardLayoutDemo( );
        demoGui.setVisible(true);
    }
}


