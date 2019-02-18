package pack;
import java.io.IOException;
public class Modify {
	Request request;
	Response response;
	Item item;
	Modify(Response response,Request request){
		this.request=request;
		this.response=response;
		
	}
	public void solve() {
		try {
			item=new Item(request.getParam("name").get(0));
			if(request.getParam("method").get(0).equals("buy")) {
				item.buy(Integer.valueOf(request.getParam("num").get(0)), Double.valueOf(request.getParam("price").get(0)));
				item.writeToFile();
				response.printfile("ModifySuccess.html");
			}
			else if(request.getParam("method").get(0).equals("sell")) {
				boolean ifSuc=item.sell(Integer.valueOf(request.getParam("num").get(0)), Double.valueOf(request.getParam("price").get(0)));
				if(ifSuc) {
					response.printfile("ModifySuccess.html");
					item.writeToFile();
				}
				else {
					response.printfile("ModifyFail.html");
				}
			}
			response.send();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
