
import javax.swing.JApplet;
import java.awt.Graphics;
import java.awt.Color;

public class MultipleFaces extends JApplet
{
    public static final int FACE_DIAMETER = 50;
    public static final int X_FACE0 = 10;
    public static final int Y_FACE0 = 5;

    public static final int EYE_WIDTH = 5;
    public static final int EYE_HEIGHT = 10;
    public static final int X_RIGHT_EYE0 = 20;
    public static final int Y_RIGHT_EYE0 = 15;
    public static final int X_LEFT_EYE0 = 45;
    public static final int Y_LEFT_EYE0 = Y_RIGHT_EYE0;

    public static final int NOSE_DIAMETER = 5;
    public static final int X_NOSE0 = 32;
    public static final int Y_NOSE0 = 25;

    public static final int MOUTH_WIDTH = 30;
    public static final int MOUTH_HEIGHT0 = 0;
    public static final int X_MOUTH0 = 20;
    public static final int Y_MOUTH0 = 35;
    public static final int MOUTH_START_ANGLE = 180;
    public static final int MOUTH_EXTENT_ANGLE = 180;

    /**
     g is the drawing area. pos is a parameter for the position of the face.
     As pos increases, the face is drawn lower and further to the right.
    */
    private void drawFaceSansMouth(Graphics g, int pos)
    {
        g.setColor(Color.BLACK);
        g.drawOval(X_FACE0 + 50 * pos, Y_FACE0 + 30 * pos,
                   FACE_DIAMETER, FACE_DIAMETER);
        //Draw eyes:
        g.setColor(Color.BLUE);
        g.fillOval(X_RIGHT_EYE0 + 50 * pos, Y_RIGHT_EYE0 + 30 * pos,
                   EYE_WIDTH, EYE_HEIGHT);
        g.fillOval(X_LEFT_EYE0 + 50 * pos, Y_LEFT_EYE0 + 30 * pos,
                   EYE_WIDTH, EYE_HEIGHT);
        //Draw nose:
        g.setColor(Color.BLACK);
        g.fillOval(X_NOSE0 + 50 * pos, Y_NOSE0 + 30 * pos,
                   NOSE_DIAMETER, NOSE_DIAMETER);
    }

    public void paint(Graphics canvas)
    {
        int i;
        for (i = 0; i < 5; i++)
        {//Draw one face:
            if (i % 2 == 0)//If i is even,
            {   //make face yellow
                canvas.setColor(Color.YELLOW);
                canvas.fillOval(X_FACE0 + 50 * i, Y_FACE0 + 30 * i,
                                FACE_DIAMETER, FACE_DIAMETER);
            }
            drawFaceSansMouth(canvas, i);
            //Draw mouth:
            canvas.setColor(Color.RED);
            canvas.drawArc(X_MOUTH0 + 50 * i, Y_MOUTH0 + 30 * i,
                           MOUTH_WIDTH, MOUTH_HEIGHT0 + 3 * i,
                           MOUTH_START_ANGLE, MOUTH_EXTENT_ANGLE);
        }
        //i == 5

        //Draw kissing face:
        drawFaceSansMouth(canvas, i);
        //Draw mouth in shape of a kiss:
        canvas.setColor(Color.RED);
        canvas.fillOval(X_MOUTH0 + 50 * i + 10, Y_MOUTH0 + 30 * i,
                        MOUTH_WIDTH - 20, MOUTH_WIDTH - 20);
        //Add text:
        canvas.setColor(Color.BLACK);
        canvas.drawString("Kiss, Kiss.",
						  X_FACE0 + 50 * i + FACE_DIAMETER, Y_FACE0 + 30 * i);

        //Draw blushing face:
        i++;
        //Draw face circle:
        canvas.setColor(Color.PINK);
        canvas.fillOval(X_FACE0 + 50 * i, Y_FACE0 + 30 * i,
                        FACE_DIAMETER, FACE_DIAMETER);
        drawFaceSansMouth(canvas, i);
        //Draw mouth:
        canvas.setColor(Color.RED);
        canvas.drawArc(X_MOUTH0 + 50 * i, Y_MOUTH0 + 30 * i, MOUTH_WIDTH,
                       MOUTH_HEIGHT0 + 3 * (i - 2),
                       MOUTH_START_ANGLE, MOUTH_EXTENT_ANGLE);
        //Add text:
        canvas.setColor(Color.BLACK);
        canvas.drawString("Tee Hee.",
			              X_FACE0 + 50 * i + FACE_DIAMETER, Y_FACE0 + 30 * i);
    }
}