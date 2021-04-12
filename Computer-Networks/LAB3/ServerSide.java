// A Java program for a Serverside

import java.net.*;
import java.io.*;
public class ServerSide 
{
    //initialize socket and input stream
    private Socket socket = null;
    private ServerSocket server = null;
    private DataInputStream in = null;

    // constructor with port
    public ServerSide(int port) 
    {
        // starts server and waits for a connection
        try 
        {
            // creates new server using port number
            server = new ServerSocket(port);
            System.out.println("Server has started !! ");
            System.out.println("Waiting for a client response...");

            // accept client request
            socket = server.accept();
            System.out.println("Client request accepted");

            // takes input from the client socket
            in = new DataInputStream(
                new BufferedInputStream(socket.getInputStream()));
            String line = "";

            // reads message from client until "END" is sent
            while (!line.equals("END")) 
            {
                try 
                {
                    // convert the string into UTF format
                    line = in .readUTF();
                    System.out.println(line);
                } 
                catch (IOException i) 
                {
                    System.out.println(i);
                }
            }
            System.out.println("Closing the connection !! ");

            // close connection
            socket.close(); in .close();
        } 
        catch (IOException i) 
        {
            // print if any exception occured
            System.out.println(i);
        }
    }

    public static void main(String args[]) 
    {
        // contructor initialised with port number as argument
        ServerSide server = new ServerSide(59768);
    }
}

// IP address is : 192.168.100.9
// Port used is : 59768