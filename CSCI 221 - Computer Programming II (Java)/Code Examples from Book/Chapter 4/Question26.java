
import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Color;

public class Question26 extends JApplet
{
    public static final int DIAMETER = 30;
    public static final int X_CENTER = 100;
    public static final int Y_CENTER = 100;
	public static final int GAP = 10;
	
    public void paint(Graphics canvas)
    {
		int radius = DIAMETER / 2;
		int x = X_CENTER - radius;//upper left corner
		int y = Y_CENTER - radius;
		
		for (int i = 1; i <= 6; i++)
		{
			canvas.setColor(Color.BLUE);
			canvas.fillOval(x, y, DIAMETER, DIAMETER);
			
			canvas.setColor(Color.BLACK);
			canvas.drawOval(x, y, DIAMETER, DIAMETER);
			
			x = x + DIAMETER + GAP; 
		}
    }
}
