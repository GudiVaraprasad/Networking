import java.util.*;
import java.io.*;
import java.net.*;

 // Concept of Multi threading
class ServerClientThread extends Thread {
	Socket serverClient; // for creating a socket named serverClient
	int clientNo; // client number

	// constructor class to identify socket and which client request
	ServerClientThread(Socket inSocket, int counter) {
		// identify socket
		serverClient = inSocket;
		// which client request
		clientNo = counter;
	}

	// running the thread created
	public void run() {
		try {
			// get input option list from client using serverClient socket
			DataInputStream input1 = new DataInputStream(serverClient.getInputStream());
			// getting information to server side numbers
			DataInputStream inStream1 = new DataInputStream(serverClient.getInputStream());
			DataInputStream inStream2 = new DataInputStream(serverClient.getInputStream());
			DataOutputStream outStream = new DataOutputStream(serverClient.getOutputStream());

			// initialize reference variable in string format
			String clientInput1 = "", serverMessage="", clientInput2 = "", input = "", output = "";

			// condition to check if the client message is END or not, to exit from loop
			while(!clientInput1.equals("END")) {
				// verify the actual result of option input
				input = input1.readUTF();

				serverMessage = "From Server to Client - " + clientNo;
				outStream.writeUTF(serverMessage);

				// Input number 1 from client
				clientInput1 = inStream1.readUTF();
				// Input number 2 from client
				clientInput2 = inStream2.readUTF();

				int optionNo,sum,difference,product,division,square;
				// which option to select
				optionNo = Integer.parseInt(input);
				// parses a string (UTF here) and converts it to an integer

				// check option is 1 or not means to perform sumition
				if (optionNo == 1) 
				{
					System.out.println("From Client - " + clientNo + " : Number1 is : " + clientInput1 + " : Number 2 is : " + clientInput2);
					sum = Integer.parseInt(clientInput1) + Integer.parseInt(clientInput2);
					output = "From Server to Client : " + clientNo + " : Sum of : " + clientInput1 + "\t" + clientInput2 + " is = " + sum;
					outStream.writeUTF(output);
				}
				// else check option is 2 or not means to perform differencetraction
				else if (optionNo == 2) 
				{
					System.out.println("From Client - " + clientNo + " : Number1 is : " + clientInput1 + " : Number 2 is : " + clientInput2);
					difference = Integer.parseInt(clientInput1) - Integer.parseInt(clientInput2);
					output = "From Server to Client : " + clientNo + " : Difference of : " + clientInput1 + "\t" + clientInput2 + " is = " + difference;
					outStream.writeUTF(output);
				}
				// else check option is 3 or not means to perform producttiplication
				else if (optionNo == 3) 
				{
					System.out.println("From Client - " + clientNo + " : Number1 is : " + clientInput1 + " : Number 2 is : " + clientInput2);
					product = Integer.parseInt(clientInput1) * Integer.parseInt(clientInput2);
					output = "From Server to Client : " + clientNo + " : Product of : " + clientInput1 + "\t" + clientInput2 + " is = " + product;
					outStream.writeUTF(output);
				}
				// else check option is 4 or not means to perform divisionision
				else if (optionNo == 4) 
				{
					System.out.println("From Client - " + clientNo + " : Number1 is : " + clientInput1 + " : Number 2 is : " + clientInput2);
					division = Integer.parseInt(clientInput1) / Integer.parseInt(clientInput2);
					output = "From Server to Client : " + clientNo + " : Divison of : " + clientInput1 + "\t" + clientInput2 + " is = " + division;
					outStream.writeUTF(output);
				}
				// else check option is 5 or not means to perform squareuare
				else if (optionNo == 5) 
				{
					System.out.println("From Client - " + clientNo + " : Number is : " + clientInput1);
					square = Integer.parseInt(clientInput1) * Integer.parseInt(clientInput1);
					output = "From Server to Client : " + clientNo + " : Square of : " + clientInput1 + " is = " + square;
					outStream.writeUTF(output);
				}
				// neither of them, default option to exit
				else 
				{
					System.exit(0);
				}
				// make buffer memory empty
				outStream.flush();
			}
			// close all the connections
			inStream1.close();
			outStream.close();
			serverClient.close();
		} 
		catch(Exception e) {
			// print if any exceptions
			System.out.println(e);
		}
		finally {
			// default method to print which client got diconnected
			System.out.println("Client - " + clientNo + " exit !!");
		}
	}
}

// IP address is : 192.168.100.9
// Host name : GVP
// Port used is : 59768
