
public class FigureDemo
{
    public static void main(String[] args)
    {
        RectangleInterface box = new Rectangle(5, 8, 4);
		box.drawHere();
		
		box.set(5, 5);
		box.setOffset(10);
		box.drawAt(2);
    }
}
