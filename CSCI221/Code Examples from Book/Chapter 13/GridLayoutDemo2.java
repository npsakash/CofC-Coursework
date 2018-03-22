
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Container;
import java.awt.GridLayout;

/**
 Simple demonstration of using a layout manager to arrange labels.
 Note that seven items are added even though only six locations are specified.
*/
public class GridLayoutDemo2 extends JFrame
{
    public static final int WIDTH = 300;
    public static final int HEIGHT = 200;

    /**
     Creates and displays a window of the class BorderLayoutDemo.
    */
    public static void main(String[] args)
    {
        GridLayoutDemo2 gui2 = new GridLayoutDemo2();
        gui2.setVisible(true);
    }

    public GridLayoutDemo2()
    {
        setSize(WIDTH, HEIGHT);
        addWindowListener(new WindowDestroyer());
        setTitle("Layout Demonstration");
        Container content = getContentPane();

        content.setLayout(new GridLayout(2, 3));
        JLabel label1 = new JLabel("First");
        content.add(label1);
        JLabel label2 = new JLabel("Second");
        content.add(label2);
        JLabel label3 = new JLabel("Third");
        content.add(label3);
        JLabel label4 = new JLabel("Fourth");//Empty string label
        content.add(label4);
        JLabel label5 = new JLabel("Fifth");
        content.add(label5);
        JLabel label6 = new JLabel("Sixth");
        content.add(label6);
        JLabel label7 = new JLabel("Seventh");
        content.add(label7);
    }
}




