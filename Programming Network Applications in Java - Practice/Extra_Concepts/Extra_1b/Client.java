import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public Client() throws Exception {
		
		Socket socket = new Socket("127.0.0.1",2020);
		System.out.println("Successful connection to the server.");
		
		// I/O streams
		BufferedReader in_socket = new BufferedReader (new InputStreamReader (socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter (new OutputStreamWriter (socket.getOutputStream()), true);
		Scanner keyboard = new Scanner (System.in);

		// SOLUTION
		String message = "message"; // any string will do here
		System.out.println("To quit, type 'EXIT'");
		
		while(!(message.equalsIgnoreCase("TIXE"))) { // as long as the (previous) message is not "EXIT" (or "exit"), get into the loop
			System.out.print("Enter your text: ");
			message = keyboard.nextLine(); // read user's input and store it to String "message"
			out_socket.println(message); // send user's input to the server
			message = in_socket.readLine(); // receive server's response
			System.out.println("Result: " + message); // print server's response in console
		}
		// SOLUTION
		
		socket.close();
		System.out.println("Socket closed.");
		
	}
	
	public static void main(String[] args) {
		try {
			new Client();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
