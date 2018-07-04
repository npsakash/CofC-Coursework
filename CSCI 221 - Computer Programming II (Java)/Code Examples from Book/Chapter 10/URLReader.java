import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.DataOutputStream;
import java.net.URL;

public class URLReader
{
    public static void main(String[] args) throws Exception {

    URL website = new URL("http://www.wikipedia.org");
    Scanner inputStream = new Scanner(
		new InputStreamReader(website.openStream()));

    while (inputStream.hasNextLine())
    {
     String s = inputStream.nextLine();
     System.out.println(s);
    }
    inputStream.close();
  }
}