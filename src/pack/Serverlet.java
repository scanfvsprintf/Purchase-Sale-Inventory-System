package pack;

import java.io.IOException;
import java.net.*;

public class Serverlet implements Runnable{
	Request request;
	Response response;
	Socket client;
	Serverlet(Socket client){
		this.client=client;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		request=new Request(client);
		response=new Response(client);
		if(request.getAddress().equals("Modify")) {
			new Modify(response,request).solve();
		}
		else if(request.getAddress().equals("Inquire")) {
			new Inquire(response,request).solve();
		}
		else if(request.getAddress().contains(".")) {
			new SendFile(response,request,request.getAddress()).solve();
		}
		else{
			new Index(response,request).solve();
		}
		try {
			client.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
