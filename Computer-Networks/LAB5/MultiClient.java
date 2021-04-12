import java.util.*;
import java.io.*;
import java.net.*;

public class MultiClient {
	public static void main(String[] args) throws Exception {
		try {
			// create socket with IP address and port number of server
			Socket socket = new Socket("192.168.100.9", 59768);
			// getting options list add, sub, mul
			DataInputStream option = new DataInputStream(socket.getInputStream());
			// sending information to server side
			DataInputStream inStream = new DataInputStream(socket.getInputStream());

			// to send option to server to perform which arthimetic operation
			DataOutputStream outOption = new DataOutputStream(socket.getOutputStream());
			// for sending first value
			DataOutputStream outStream1 = new DataOutputStream(socket.getOutputStream());
			// for sending second value
			DataOutputStream outStream2 = new DataOutputStream(socket.getOutputStream());

			// for reading options in the list like add, sub, mul
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			// creating user input object for giving user inputs
			BufferedReader num1 = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader num2 = new BufferedReader(new InputStreamReader(System.in));

			// initialize reference variable in string format
			String clientMessage = "", serverMessage="", serverOutput = "", input1 = "", input2 = "";

			// condition to check if the client message is END or not, to exit from loop
			while(!clientMessage.equals("END")) {
				System.out.println("Enter the option 1.Add \t 2.Subtract \t 3.Multiply \t 4.Divide \t 5.Square \t 6.Exit");
				// read the options
				clientMessage = br.readLine();
				// send this option information to server
				outOption.writeUTF(clientMessage);
				// convert this information to UTF format
				serverOutput = inStream.readUTF();
				System.out.println(serverOutput);

				System.out.print("Enter 1st number = ");
				// Take user input number 1
				input1 = num1.readLine();
				System.out.println();
				System.out.print("Enter 2nd number = ");
				// Take user input number 2
				input2 = num2.readLine();
				System.out.println();
				// pass these two inputs to the server side
				outStream1.writeUTF(input1);
				outStream2.writeUTF(input2);
				// after performing operation, reading from server side to client side
				serverOutput = inStream.readUTF();
				System.out.println(serverOutput);
				// make buffer memory empty
				outOption.flush();
			}
			// close all the connections
			outOption.close();
			outStream1.close();
			outStream2.close();
			socket.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}

// IP address is : 192.168.100.9
// Host name : GVP
// Port used is : 59768