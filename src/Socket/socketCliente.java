package Socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class socketCliente {
      
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket socket = new Socket("192.168.1.4", 5000);
		Scanner s = new Scanner(socket.getInputStream());
		System.out.println("Mensagem : " + s.nextLine());
		s.close();
	}
}
