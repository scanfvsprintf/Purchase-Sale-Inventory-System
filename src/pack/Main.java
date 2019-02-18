package pack;
import java.io.IOException;
import java.net.*;
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket server=new ServerSocket(80);
		while(true) {
			new Thread(new Serverlet(server.accept())).start();
		}

	}

}
