package Server;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;


public class ServerTest {
	public static int count;
	public static int allUser;
	public static UserList ul=new UserList();
	public static void main(String[] args){
		
		ServerSocket ss;
		try {
				
				ss=new ServerSocket(8888);			
				ul.loadUserList();
				while(true){
					Socket s=ss.accept();
					ServerConnection c=new ServerConnection(s);
					Thread t=new Thread(c);					
					t.start();
					

				}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	}
