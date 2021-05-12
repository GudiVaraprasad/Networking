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
		String user_number; // this string will store user's guesses
		
		while((in_socket.readLine()).startsWith("Guess")) { // go into the loop as long as server is still saying "Guess a number.."
			System.out.println("Server says: Guess a number [1-20]."); // prompt the user to guess a number
			user_number = keyboard.nextLine(); // read user's message
			out_socket.println(user_number); // send user's message to the server
		}
		
		System.out.println("You got it!!!"); // as soon as the condition in our do-while loop isn't met, it means the number has been guessed
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
