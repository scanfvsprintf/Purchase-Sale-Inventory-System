package pack;

import java.io.*;

public class Inquire {
	Request request;
	Response response;
	Item item;
	Inquire(Response response,Request request){
		this.request=request;
		this.response=response;
	}
	private void printItem(String name) {
		try {
			item=new Item(name);
			response.println("<table border=\"1\">");
			response.println("<tr>");
			response.println("<td>名称</td>");
			response.println("<td>购进所支总额</td>");
			response.println("<td>销售所得总额</td>");
			response.println("<td>总利润</td>");
			response.println("<td>现有库存</td>");
			response.println("</tr>");
			response.println("<tr>");
			response.println("<td>"+item.name+"</td>");
			response.println("<td>"+item.spend+"</td>");
			response.println("<td>"+item.getIn+"</td>");
			response.println("<td>"+(item.getIn-item.spend)+"</td>");
			response.println("<td>"+item.num+"</td>");
			response.println("</tr>");
			response.println("</table>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void printOne() {
		response.println("<html>");
		response.println("<head>\r\n" + "<title>查询结果</title>\r\n" + "</head>");
		response.println("<body>");
		printItem(request.getParam("name").get(0));
		response.println("<form action=\"index.html\" method=\"GET\">\r\n" + "<input type=\"submit\" value=\"返回首页\"/>\r\n" +	"</form>");
		response.println("</body>");
		response.println("</html>");
		response.send();
	}
	private void printAll() {
		response.println("<html>");
		response.println("<head>\r\n" + "<title>查询结果</title>\r\n" + "</head>");
		response.println("<body>");
		File items[]=new File("items").listFiles();
		for (File each:items) {
			try {
				printItem(each.getName().substring(0, each.getName().indexOf(".dat")));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.println("<form action=\"index.html\" method=\"GET\">\r\n" + "<input type=\"submit\" value=\"返回首页\"/>\r\n" +	"</form>");
		response.println("</body>");
		response.println("</html>");
		response.send();
	}
	public void solve() {
		if(request.getParam("method").get(0).equals("one")) {
			printOne();
		}
		else {
			printAll();
		}
	}
}
