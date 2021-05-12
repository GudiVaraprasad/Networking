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
			
			out_socket.println("Welcome! You are client number " + client_number + ". What's your name? "); // send "Welcome" to the Client
			String message = in_socket.readLine(); // receive Client's message
			System.out.println("Client says: " + message); // display Client's message in the console
			
			socket.close();
			System.out.println("Client " + client_number + ". has disconnected.");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
}
