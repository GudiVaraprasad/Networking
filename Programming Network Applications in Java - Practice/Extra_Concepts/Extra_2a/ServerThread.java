import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread implements Runnable {

	private Socket socket;
	private ServerMain server_main;
	
	public ServerThread (Socket socket, ServerMain server_main) {
		this.socket = socket;
		this.server_main = server_main;
	}
	
	@Override
	public void run() {
		try {
			
			int client_number = server_main.getClientNumber();
			
			System.out.println("Client " + client_number + ". has connected.");
			
			// I/O buffers:
			BufferedReader in_socket = new BufferedReader(new InputStreamReader (socket.getInputStream()));
			PrintWriter out_socket = new PrintWriter(new OutputStreamWriter (socket.getOutputStream()), true);
			
			// SOLUTION
			String message; // this string will store client's messages
			int secret_number = (int)(Math.random()*20+1); // generating the secret number
			
			do {
				out_socket.println("Guess a number [1-20]: "); // sending a prompt to the user to guess a number
				message = in_socket.readLine(); // accepting a message from the user
			} while (!(Integer.parseInt(message)==secret_number)); // go back to the loop as long the secret number isn't guessed yet
			
			out_socket.println("You got it!!!"); // as soon as the condition in our do-while loop isn't met, it means the number has been guessed
			// SOLUTION		
			
			socket.close();
			System.out.println("Client " + client_number + ". has disconnected.");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
