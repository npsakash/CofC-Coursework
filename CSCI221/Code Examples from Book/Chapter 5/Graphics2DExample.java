import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Graphics2DExample extends JFrame
{
 public void paint(Graphics canvas)
 {
   super.paint(canvas);
   try
   {
     // Load image from default location on disk. This is inefficient
     // because the image will be re-loaded everytime the JFrame is
     // displayed.  A better technique would be to load the image
     // once in the constructor (discussed in a later chapter).
     BufferedImage img = ImageIO.read(new File("java.jpg"));
     // Draw the image at coordinate 50,50
     canvas.drawImage(img, 50, 50, null);

     // Copy the image to another buffer with a
     // color model (ARGB) to support alpha blending
     // that allows translucency
     int w = img.getWidth(null);
     int h = img.getHeight(null);
     BufferedImage img2 = new
       BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
     Graphics g = img2.getGraphics();
     g.drawImage(img, 0, 0, null);


     // Create a rescale filter operation that
     // makes the image 30% opaque
     float[] scales = { 1f, 1f, 1f, 0.3f };
     float[] offsets = new float[4];
     RescaleOp rop = new RescaleOp(scales, offsets, null);
     // Draw the image, applying the filter
     Graphics2D g2 = (Graphics2D) canvas;
     g2.drawImage(img2, rop, 150, 50);
   }
   catch (IOException e)
   {
     System.out.println("Error reading the image.");
   }
 }
 public Graphics2DExample()
 {
   setSize(275,175);
   setDefaultCloseOperation(EXIT_ON_CLOSE);
 }
 public static void main(String[] args)
 {
   Graphics2DExample guiWindow = new Graphics2DExample();
   guiWindow.setVisible(true);
 }
}