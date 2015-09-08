package Web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		
		BufferedReader in = null;
		PrintWriter out = null;
		
		ServerSocket server = null;
		Socket client = null;
		
		try {
			server = new ServerSocket(5679);
		}	catch (IOException e) {
			System.out.println("Error port!");
			System.exit(-1);
		}
		
		try {
			System.out.println("Waiting...");
			client = server.accept();
			System.out.println("Client connected");
		}	catch (IOException e) {
			System.out.println("Error!");
			System.exit(-1);
		}
		
		try {
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			out = new PrintWriter(client.getOutputStream(), true);
			
			@SuppressWarnings("unused")
			String input, output;
			
			System.out.println("Waiting for messages...");
			
			while((input = in.readLine()) != null) {
				if (input.equalsIgnoreCase("exit")) break;
				out.println("S ::: " + input);
				System.out.println(input);
			}
			
			out.close();
			in.close();
			client.close();
			server.close();
			
			} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
