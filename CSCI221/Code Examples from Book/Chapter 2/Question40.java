import javax.swing.JOptionPane;
public class Question40
{
    public static void main(String[] args)
    {
        String numberString = JOptionPane.showInputDialog(
                              "Enter a whole number:");
        JOptionPane.showMessageDialog(null, "The number is " +
                                      numberString);
        System.exit(0);
    }
}
