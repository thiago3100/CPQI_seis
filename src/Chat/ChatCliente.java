package Chat;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatCliente extends JFrame{
	
	JTextField TextoParaEnvio;
	Socket socket;
	PrintWriter escritor;
	String nome;
	JTextArea textoRecebido;
	
	public ChatCliente(String nome) {
		super("Chat: "+ nome);
		this.nome = nome;
		
		Font fonte = new Font("Serif", Font.PLAIN, 26);
		TextoParaEnvio = new JTextField();
		TextoParaEnvio.setFont(fonte);
		JButton botao = new JButton("Enviar");
		botao.setFont(fonte);
		botao.addActionListener(new EnviarListener());
		Container envio = new JPanel();
		envio.setLayout(new BorderLayout());
		envio.add(BorderLayout.CENTER, TextoParaEnvio);
		envio.add(BorderLayout.EAST, botao);
		getContentPane().add(BorderLayout.SOUTH, envio);
		
		textoRecebido = new JTextArea();
		textoRecebido.setFont(fonte);
		JScrollPane scroll = new JScrollPane(textoRecebido);
		
		getContentPane().add(BorderLayout.CENTER, scroll);
		getContentPane().add(BorderLayout.SOUTH, envio);
		
		ConfigurarRede();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 90);
		setVisible(true);
	}
	
	private class EnviarListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			escritor.println(nome + " " + TextoParaEnvio.getText());
			escritor.flush();
			TextoParaEnvio.setText("");
			TextoParaEnvio.requestFocus();
		}
		
	}
	
	private void ConfigurarRede() {
		try {
			socket = new Socket("192.168.1.4", 3000);
			escritor = new PrintWriter(socket.getOutputStream());
		}catch(Exception e) {}
	}
	
	
	public static void main(String[] args) {
		new ChatCliente("Thiago");
		new ChatCliente("Silva");
	}

}
