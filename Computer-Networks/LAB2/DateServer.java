import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * A simple TCP server. When a client connects, it sends the client the current
 * datetime, then closes the connection. This is arguably the simplest server
 * you can write. Beware though that a client has to be completely served its
 * date before the server will be able to handle another client.
 */

public class DateServer
{
    public static void main(String[] args) throws IOException 
    {
        // listening to the port used
        try (var listener = new ServerSocket(59768)) 
        {
            System.out.println("Hii !! Message sent");
            System.out.println("The date server is running...");
            while (true) 
            {
                // accept the request from socket
                try (var socket = listener.accept()) 
                {
                    var out = new PrintWriter(socket.getOutputStream(), true);
                    // get the date and convert that to string and send it to socket used
                    out.println(new Date().toString());
                }
                catch(Exception ex)
                {
                    // print all the exceptions if any
                    ex.printStackTrace();
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

// IP address is : 192.168.100.9
// Port used is : 59768

// By Gudi Varaprasad - 19BCE7048