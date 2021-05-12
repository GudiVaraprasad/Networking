import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client_tcp {

	public Client_tcp() throws Exception {
		
		Socket socket = new Socket("localhost",2021);
		System.out.println("Successful connection to the server.");
		
		// I/O streams
		BufferedReader in_socket = new BufferedReader (new InputStreamReader (socket.getInputStream()));
		PrintWriter out_socket = new PrintWriter (new OutputStreamWriter (socket.getOutputStream()), true);
		
		String message = in_socket.readLine();
		System.out.println("Server says: " + message);
		out_socket.println("Thanks!");
		
		socket.close();
		System.out.println("Socket closed.");
		
	}
	
	public static void main(String[] args) {
		try {
			new Client_tcp();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
