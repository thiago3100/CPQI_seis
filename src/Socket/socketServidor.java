package Socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class socketServidor {
       
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(5000);
		while(true){
			Socket socket = server.accept();
			try(PrintWriter w = new PrintWriter(socket.getOutputStream())){
				w.println("Aprenda Java e seja contratado");
			}
		}
	}
}
