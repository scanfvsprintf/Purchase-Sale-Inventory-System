package pack;
import java.io.*;
public class Item {
	double spend=0;
	double getIn=0;
	int num=0;
	String name;
	File file;
	Item(String name) throws IOException{
		if(!new File("items").exists()) {
			new File("items").mkdirs();
		}
		this.name=name;
		file=new File("items/"+name+".dat");
		if(!file.exists()) {
			file.createNewFile();
		}
		else {
			BufferedReader reader=new BufferedReader(new FileReader(file));
			char buff[]=new char[1024];
			int len=reader.read(buff);
			reader.close();
			String value=new String(buff,0,len);
			String each[]=value.split("\r\n");
			for(String i:each) {
				String t[]=i.split("=");
				if(t[0].equals("spend")) {
					spend=Double.valueOf(t[1]);
				}
				else if(t[0].equals("getin")) {
					getIn=Double.valueOf(t[1]);
				}
				else if(t[0].equals("num")) {
					num=Integer.valueOf(t[1]);
				}
			}
		}
	}
	public void buy(int num,double price) {
		spend+=num*price;
		this.num+=num;
	}
	public boolean sell(int num,double price) {
		System.out.println("现数量："+this.num+"要卖的"+num);
		if(num<=this.num) {
			this.num-=num;
			getIn+=num*price;
			return true;
		}
		else {
			return false;
		}
	}
	public double[] getMessage() {
		double t[]=new double[3];
		t[0]=spend;
		t[1]=getIn;
		t[2]=num;
		return t;
	}
	public void writeToFile() {
		try {
			BufferedWriter writer=new BufferedWriter(new FileWriter(file));
			writer.write("spend="+String.valueOf(spend));
			writer.newLine();
			writer.write("getin="+String.valueOf(getIn));
			writer.newLine();
			writer.write("num="+String.valueOf(num));
			writer.flush();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
