
/**
 Abstract base class for drawing simple shapes on the screen
 using keyboard characters. 
*/
public abstract class ShapeBase implements ShapeInterface
{
    private int offset; 
    
    public ShapeBase( )
    {
        offset = 0;
    }

    public ShapeBase(int theOffset)
    {
        offset = theOffset;
    }

    /**
     Draws the shape at the current line.
    */
    public abstract void drawHere( );
              
    /**
     Draws the shape at lineNumber lines down
     from the current line.
    */
    public void drawAt(int lineNumber)
    {
        for (int count = 0; count < lineNumber; count++)
            System.out.println( ); 
        drawHere( );
    } 
    
    public void setOffset(int newOffset)
    {
        offset = newOffset;
    }

    public int getOffset( )
    {
        return offset;
    }
}