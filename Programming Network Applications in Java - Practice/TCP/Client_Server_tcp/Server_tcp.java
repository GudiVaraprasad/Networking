import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server_tcp {
	
	public Server_tcp() throws Exception {
		
		ServerSocket server_socket = new ServerSocket(2021); //opening a new port
		System.out.println("Port 2021 is open.");
		
		Socket socket = server_socket.accept();
		System.out.println("Client " + socket.getInetAddress() + " has connected.");
		
		// I/O buffers:
		BufferedReader in_socket = new BufferedReader(new InputStreamReader (socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter(new OutputStreamWriter (socket.getOutputStream()), true);
		
		out_socket.println("Welcome!"); // send "Welcome" to the Client
		String message = in_socket.readLine();
		System.out.println("Client says: " + message); // display Client's message in the console
		
		socket.close();
		System.out.println("Socket is closed.");
	}
	
	public static void main(String[] args) {
		try {
			new Server_tcp();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
