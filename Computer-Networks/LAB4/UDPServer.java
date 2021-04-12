// A Java program for a Server Side

import java.io.*;
import java.util.*;
import java.lang.*;
import java.net.*;

class UDPServer
{
    public static void main(String args[]) throws Exception
    {
        // creates a datagram socket and binds it with the available Port Number on the localhost machine.
        DatagramSocket serverSocket = new DatagramSocket(59768);
        byte[] receivedData = new byte[1024]; // max is 1024 charset
        byte[] sendData = new byte[1024];

        while(true)
        {
            // This constructor is used to receive the packets
            DatagramPacket receivedPacket = new DatagramPacket(receivedData, receivedData.length);
            serverSocket.receive(receivedPacket); // received

            // convert bytes into data
            String fromClient = new String(receivedPacket.getData());
            System.out.println();
            System.out.println("RECEIVED FROM CLIENT : \n" + fromClient);

            InetAddress ip = receivedPacket.getAddress();
            int port = receivedPacket.getPort();
            // converts the sentence from client to capital letters
            String capitalClient = fromClient.toUpperCase();
            // convert it into bytes
            sendData = capitalClient.getBytes();

            // creates a datagram packet. This constructor is used to send the packets
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ip, port);
            serverSocket.send(sendPacket); // send
        }
    }
}

// IP address is : 192.168.100.9
// Host name : GVP
// Port used is : 59768