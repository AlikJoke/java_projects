import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;



public class ChatClient {

	final Socket s;
	
	final BufferedReader socketReader;
	final BufferedWriter socketWriter;
	final BufferedReader userInput;
	
	public ChatClient(String host, int port) 
	throws IOException	{
		
		s = new Socket(host, port);
		
		socketReader = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));
		socketWriter = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8"));
		
		userInput = new BufferedReader(new InputStreamReader(System.in));
		
		new Thread(new Receiver()).start();
	}
	
	public void run() {
		
		System.out.println("Write...");
		
		while(true) {
			
			String userString = null;
			try {
				
				userString = userInput.readLine();
			}	catch (IOException e) {
				
			}
			
			if (userString == null || userString.length() == 0 || s.isClosed()) {
				
				close();
				break;
			}	else {
				try {
					
					socketWriter.write(userString);
					socketWriter.write("\n");
					socketWriter.flush();
				}	catch (IOException e) {
					close();
				}
			}
		}
	}
	
	public synchronized void close() {
		
		if(!s.isClosed()) {
			try{
				
				s.close();
				System.exit(0);
			}	catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		
		try{
			new ChatClient("localhost", 4500).run();
		}	catch (IOException e) {
			
			System.out.println("Unable to connect");
		}
	}
	
	private class Receiver implements Runnable {
		
		public void run() {
			
			while(!s.isClosed()) {
				
				String line = null;
				try {
					line = socketReader.readLine();
				}	catch (IOException e) {
					
					if ("Socket closed".equals(e.getMessage())) {
						break;
					}
					
					System.out.println("Connection lost");
					close();
				}
				if (line == null) {
					System.out.println("Server has closed connection");
					close();
				}	else {
					System.out.println("Server:" + line);
				}
			}
		}
	}
}
