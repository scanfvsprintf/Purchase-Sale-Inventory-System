package pack;

import java.io.IOException;

public class SendFile {
	Request request;
	Response response;
	String filename;
	Item item;
	SendFile(Response response,Request request,String filename){
		this.request=request;
		this.response=response;
		this.filename=filename;
		
	}
	public void solve() {
		try {
			response.printfile(filename);
			response.send();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
