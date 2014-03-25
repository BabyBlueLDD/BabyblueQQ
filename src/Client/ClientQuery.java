package Client;
import BasicMethod.*;

import java.io.IOException;
import java.net.Socket;

public class ClientQuery {
	Socket s;
	boolean flag =true;
	ClientQuery(Socket s){
		this.s=s;
	}
	
	public void query() throws IOException{
		BasicWriteAndRead bwr=new BasicWriteAndRead();
		String screenStr=null;
		while(flag){
			String reStr=bwr.receiveMessage(s);
			System.out.println(reStr);
			
			screenStr=bwr.readFromScreen();		
			bwr.sendMessage(s,screenStr);
			if(screenStr.equals("3")){
				String rStr=bwr.receiveMessage(s);
				System.out.println(rStr);
				screenStr=bwr.readFromScreen();		
				bwr.sendMessage(s, screenStr);
			}
			String rStr=bwr.receiveMessage(s);
//			if(!rStr.equals("invalid input")){
//				flag=false;
//			}
			System.out.println(rStr);
			
		}
		
	}
}
