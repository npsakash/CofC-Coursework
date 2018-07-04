/**
 Another class that represents a rectangle.
*/
public class Rectangle2
{
    private int width;
    private int height; 

    public void setDimensions(int newWidth, int newHeight)
    {
        width = newWidth;
        height = newHeight;
    }

    public int getArea()
    {
		return width * height;
	}
}

