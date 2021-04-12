// A Java program for a Client Side

import java.io.*;
import java.util.*;
import java.lang.*;
import java.net.*;

class UDPClient
{
    public static void main(String args[]) throws Exception
    {
        // InputStreamReader reads bytes and decodes them into characters using a specified charset
        // BufferedReader reads the stream of characters from the specified source 
        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));

        // creates a datagram socket and binds it with the available Port Number on the localhost machine.
        DatagramSocket clientSocket = new DatagramSocket();

        // get the IP address using the host name of the system
        InetAddress ip = InetAddress.getByName("GVP");

        byte[] sendData = new byte[1024]; // maximum charset is 1024
        byte[] receivedData = new byte[1024];
        String sentence = userInput.readLine(); // user input

        sendData = sentence.getBytes(); // convert the input to bytes

        // creates a datagram packet. This constructor is used to send the packets
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ip, 59768);
        clientSocket.send(sendPacket); // send the packet to server

        // This constructor is used to receive the packets
        DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
        clientSocket.receive(receivedPacket); // receive the packet from server

        // convert bytes into data
        String fromServer = new String(receivedPacket.getData());
        System.out.println();
        System.out.println("FROM SERVER : \n" + fromServer);
        // close the connection if received
        clientSocket.close();
    }
}

// IP address is : 192.168.100.9
// Host name : GVP
// Port used is : 59768