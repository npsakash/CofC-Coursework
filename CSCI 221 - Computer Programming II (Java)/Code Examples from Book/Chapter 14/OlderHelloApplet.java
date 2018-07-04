
import java.awt.FlowLayout;
import java.awt.Label;
import java.applet.Applet;

public class OlderHelloApplet extends Applet
{
    public void init()
    {
        setLayout(new FlowLayout());
        Label friendlyLabel = new Label("Hello out there!");
        add(friendlyLabel);
    }
}