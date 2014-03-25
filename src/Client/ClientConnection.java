package Client;


import java.io.IOException;

import java.net.Socket;
import BasicMethod.*;
import Server.ServerConnection;

public class ClientConnection {
	Socket s;
	BasicWriteAndRead bwr=new BasicWriteAndRead();
	ClientConnection(Socket s){
		this.s=s;
	}
	public void load() throws IOException{
//		 String warning= "password is not correct,please enter again:";
//		 String rStr=bwr.receiveMessage(s);
//		 System.out.println(rStr);
		 boolean flag=true;
		 while(flag){
			 String rStr=bwr.receiveMessage(s);//what's username?
			 System.out.println(rStr);
			 
			 String screenStr=bwr.readFromScreen();//enter username
			 bwr.sendMessage(s,screenStr);	
			 
			 
			 String askPwStr=bwr.receiveMessage(s);	
			 System.out.println(askPwStr);
			 if(!askPwStr.equals("the username doesn't exist")){
				 
				 String myPwStr=bwr.readFromScreen();				 
				 bwr.sendMessage(s,myPwStr);	
				 
				 String welorWrongStr=bwr.receiveMessage(s);		 
				 System.out.println(welorWrongStr);
				 if(welorWrongStr.equals("you are online already")){
					 continue;
				 }
				 
				
				 if(!welorWrongStr.equals(ServerConnection.warning)){
					 flag=false;
				 }
			 }
		 }
		
	}
	
	
}
