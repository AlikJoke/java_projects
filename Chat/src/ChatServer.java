import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;


public class ChatServer {

	private ServerSocket ss;
	private int port;
	private Thread ServerThread;
	
	BlockingQueue<SocketProcessor> q = new LinkedBlockingQueue<SocketProcessor>();  
	
	public ChatServer(int port) 
	throws IOException	{
		
		ss = new ServerSocket(port);
		this.port = port;
	}
	
	void run() {
		
		ServerThread = Thread.currentThread();
		
		while(true) {
			
			Socket s = getNewConn();
			if (ServerThread.isInterrupted()) {
				break;
			}	else if (s !=null) {
				try	{
					final SocketProcessor processor = new SocketProcessor(s);
					final Thread thread = new Thread(processor);
					thread.setDaemon(true);
					thread.start();
					q.offer(processor);
				}	catch (IOException e) {
					
					e.printStackTrace();
				}
			}
			
		}
	}
	
	public Socket getNewConn() {
		
		Socket s = null;
		try {
			s = ss.accept();
		}	catch (IOException e) {
			shutdownServer();
		}
		
		return s;
	}
	
	private synchronized void shutdownServer() {
		
		for(SocketProcessor s : q) {
			s.close();
		}
		
		if (!ss.isClosed()) {
			try {
				ss.close();
			}	catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		new ChatServer(4500).run();
	}
	
	private class SocketProcessor implements Runnable {
		
		Socket s;
		BufferedReader br;
		BufferedWriter bw;
		
		SocketProcessor(Socket SocketParam) 
				throws IOException {
			s = SocketParam;
			br = new BufferedReader(new InputStreamReader(s.getInputStream(), "UTF-8"));
			bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream(), "UTF-8"));
		}
		
		public void run() {
			while(!s.isClosed()) {
				String line = null;
				
				try{
					line = br.readLine();
				}	catch (IOException e) {
					
					close();
				}
				
				if (line == null) {
					close();
				}	else if ("shutdown".equals(line)) {
					ServerThread.interrupt();
					
					try{
						
						new Socket("localhost", port);
					}	catch (IOException e) {
						
						e.printStackTrace();
					}
					finally {
						shutdownServer();
					}
				}	else {
					for (SocketProcessor sp : q) {
						sp.send(line);
					}
				}
			}
		}
		
		public synchronized void send(String line) {
			
			try {
				bw.write(line);
				bw.write("\n");
				bw.flush();
			}	catch (IOException e) {
				
				close();
			}
		}
		
		public synchronized void close() {
			
			q.remove(this);
			
			if(!s.isClosed()) {
				
				try {
					s.close();
				}	catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		}
		
		@Override
		protected void finalize()
		throws Throwable {
			
			super.finalize();
			close();
		}
	}
}
