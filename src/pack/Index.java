package pack;
import java.io.*;
public class Index {
	Request request;
	Response response;
	Index(Response response,Request request){
		this.request=request;
		this.response=response;
		
	}
	public void solve() {
		try {
			response.printfile("index.html");
			response.send();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
