// A Java program for a ClientSide

import java.net.*;
import java.io.*;
public class ClientSide 
{
    // initialize socket and input output streams

    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;

    // constructor to put ip address and port
    public ClientSide(String address, int port)
    {
        // establish a connection
        try 
        {
            socket = new Socket(address, port);
            System.out.println("Connected to Server.");
            System.out.println("Type your message.... Type END to stop.");
            // takes input from terminal
            input = new DataInputStream(System.in);

            // sends output to the socket
            out = new DataOutputStream(socket.getOutputStream());

        } 
        catch (UnknownHostException u) 
        {
            // print if any exceptions there
            System.out.println(u);
        }
        catch (IOException i) 
        {
            System.out.println(i);
        } 

        // string to read message from input
        String line = "";

        // keep reading until "END" is input
        while (!line.equals("END")) 
        {
            try 
            {
                // read the input 
                line = input.readLine();
                // convert the input to UTF format
                out.writeUTF(line);
            } 
            catch (IOException i) 
            {
                System.out.println(i);
            }
        }

        // close the connection
        try 
        {
            input.close();
            out.close();
            socket.close();
        } 
        catch (IOException i) 
        {
            System.out.println(i);
        }
    }

    public static void main(String args[]) 
    {
        ClientSide client = new ClientSide("192.168.100.9", 59768);
    }
}

// IP address is : 192.168.100.9
// Port used is : 59768