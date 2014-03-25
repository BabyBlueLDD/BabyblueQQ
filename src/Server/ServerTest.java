package Server;
import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;


public class ServerTest {
	public static int count = 0;  //init to zero
	public static int allUser = 0;//init to zero
	public static UserList userList=new UserList();
	public static void main(String[] args){
		ServerSocket ss;
		try {
				ss=new ServerSocket(8888);
				
				//READ FROM COMMAND LINE args[1], if not set use default file
				if(args.length > 1)
					userList.loadUserListFromFile(args[1]);
				else
					userList.loadUserListFromFile("users.dat");
				
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
