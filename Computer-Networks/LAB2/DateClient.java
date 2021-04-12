import java.util.Scanner;
import java.net.Socket;
import java.io.IOException;

/**
 * A command line client for the date server. Requires the IP address of the
 * server as the sole argument. Exits after printing the response.
 */

public class DateClient 
{
    public static void main(String[] args) throws IOException 
    {
        if (args.length != 1) 
        {
            System.err.println("IP address not found, Pass the server IP as the sole command line argument..");
            return;
        }
        // creating socket with IP address and port number as arguments
        var socket = new Socket(args[0], 59768);

        // for getting input as an ordered sequence of bytes
        var in = new Scanner(socket.getInputStream());

        // getting input from server and printing date
        System.out.println("This is Server response : " + in.nextLine());
        System.out.println("Message Delivered");
    }
}

// IP address is : 192.168.100.9
// Port used is : 59768

// By Gudi Varaprasad - 19BCE7048