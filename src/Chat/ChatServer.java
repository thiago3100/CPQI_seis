package Chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {

	public ChatServer() {

		class EscutaCliente implements Runnable {
			Scanner leitor;
			
			public EscutaCliente(Socket socket) throws IOException {
				try {
				leitor = new Scanner(socket.getInputStream());
				
				}catch(Exception e) {}
			}

			@Override
			public void run() {
				try {
				String texto;
				while((texto = leitor.nextLine()) != null) {
					System.out.println(texto);
				}
			}catch(Exception e) {}	
			}
			
		}
		ServerSocket server; 
		Scanner leitor;
		try {	
			server = new ServerSocket(3000);
			while(true) {
				Socket socket = server.accept();
				new Thread(new EscutaCliente(socket)).start();;
			}

		}catch(Exception e) {};
	}
	
	public static void main(String[] args) {
		new ChatServer();
	}
}