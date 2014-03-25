package Server;

import java.io.IOException;
import java.net.Socket;
import java.util.Collection;
import java.util.Iterator;

import BasicMethod.*;
public class ServerQuery {
	Socket s;
	boolean flag=true;
	public ServerQuery(Socket s) {
		this.s=s;
	}
	
	public void respondToQuery(String keyStr){
		BasicWriteAndRead bwr=new BasicWriteAndRead();
		try {
			while(flag){
				bwr.sendMessage(s,
						"you can input number 0-3\n" 
						+"1:inquire the num of users\n"
						+"2:inquire the num of online users\n"
						+"3:change your password\n"
						+"0:quit\n");
				
				String rStr=bwr.receiveMessage(s);
				if(rStr.equals("0")){
					
					synchronized(this){
						ServerTest.count--;
					}
					flag=false;
					ServerTest.ul.m.get(keyStr).status=0;
					s.close();
					
				}else if(rStr.equals("1")){
					String num=String.valueOf(ServerTest.allUser);
					bwr.sendMessage(s, "we have "+num+" client(s) totally");
//					flag=false;
				}else if(rStr.equals("2")){
					String num=String.valueOf(ServerTest.count);
					bwr.sendMessage(s, "there are "+num+" client(s) online");
//					flag=false;

				}else if(rStr.equals("3")){

//						String valueStr=(String)u.m.get(keyStr);
						bwr.sendMessage(s,"input your new password:");
						
						String newPW=bwr.receiveMessage(s);
						
						ServerTest.ul.m.remove(keyStr);
//						Collection values=u.m.values();
//						Iterator it=values.iterator();
//						while(it.hasNext()){
//							System.out.println(it.next());
//							
//						}
//						for(){
//							
//						}
//						if(u.m.containsKey(keyStr)){
//							System.out.println("key exists");
	//						
//						}
						
						ServerTest.ul.m.put(keyStr, new UserInfo(newPW, 1));
 					ServerTest.ul.updateFile();
						//ServerTest.ul.debugMap();
						bwr.sendMessage(s, "password is changed");
//						flag=false;
					
					

				}else{
					bwr.sendMessage(s, "invalid input");
					
				}
			}
			

			
		} catch (IOException e) {
			ServerTest.count--;
			System.out.println("catch  "+ServerTest.count);
			e.printStackTrace();
		}
	}
	

}
