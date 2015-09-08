package Web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

	public static void main(String[] args) 
	throws IOException	{
		
		Socket client = null;
		
		if (args.length == 0) {
			System.out.println("client hostname");
			System.exit(-1);
		}
		
		System.out.println("Connecting to ..." + args[0]);
		
			client = new Socket(args[0], 5679);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintWriter out = new PrintWriter(client.getOutputStream(), true);
			BufferedReader inu = new BufferedReader(new InputStreamReader(System.in));
			
			String f_user, f_server;
			
			while((f_user = inu.readLine()) != null)  {
				
				out.println(f_user);
				f_server = in.readLine();
				System.out.print(f_server);
				
				if (f_user.equalsIgnoreCase("close")) break;
				if (f_server.equalsIgnoreCase("exit")) break;
			}
			
			out.close();
			in.close();
			inu.close();
			client.close();
		
	}
}
