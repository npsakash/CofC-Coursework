import java.util.Scanner;
import java.io.InputStreamReader;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient
{
 public static void main(String[] args)
 {
  String s;
  Scanner inputStream = null;
  PrintWriter outputStream = null;
  try
  {
   // Connect to server on same machine, port 6789
   Socket clientSocket = new Socket("localhost",6789);
   // Set up streams to send/receive data
   inputStream = new Scanner(new InputStreamReader(clientSocket.getInputStream()));
   outputStream = new PrintWriter(new DataOutputStream(clientSocket.getOutputStream()));

   // Send "Java" to the server
   outputStream.println("Java");
   outputStream.flush(); // Sends data to the stream

   // Read everything from the server until no more lines
   // and output it to the screen
   while (inputStream.hasNextLine())
   {
     s = inputStream.nextLine();
     System.out.println(s);
   }
   inputStream.close();
   outputStream.close();
  }
  catch (Exception e)
  {
   // If any exception occurs, display it
   System.out.println("Error " + e);
  }
 }
}
