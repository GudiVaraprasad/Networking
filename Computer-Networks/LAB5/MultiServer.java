import java.util.*;
import java.io.*;
import java.net.*;

public class MultiServer {
	public static void main(String[] args) throws Exception {
		try {
			// initialize server socket as 59768
			ServerSocket server = new ServerSocket(59768);
			// identify number of clients connected to the server
			int counter = 0;

			System.out.println("Server Started .....");

			while(true) {
				// increment when client is request
				counter++;
				// server accept the client connection by binding
				Socket serverClient = server.accept();

				System.out.println(" >>> " + "Client No. : " + counter + " started " + " <<< ");
				System.out.println();
				// Creating a thread to compute arthimetic operations
				ServerClientThread sct = new ServerClientThread(serverClient, counter);
				sct.start(); // starting the created thread
			}
		} catch(Exception e) {
			// print all exceptions if any
			System.out.println(e);
		}
	}
}

// IP address is : 192.168.100.9
// Host name : GVP
// Port used is : 59768