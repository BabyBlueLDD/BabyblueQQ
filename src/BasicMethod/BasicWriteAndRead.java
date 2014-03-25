package BasicMethod;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class BasicWriteAndRead {
	public String readFromScreen() throws IOException{
	 	InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		String str=br.readLine();		
		return str;
		
	}
	public String receiveMessage(Socket socket) throws IOException{
		
		InputStream is=socket.getInputStream();
		DataInputStream dis=new DataInputStream(is);
		String str=dis.readUTF();
		return str;
		
	}
	public void sendMessage(Socket socket,String str) throws IOException{
			
			OutputStream is=socket.getOutputStream();
			DataOutputStream dis=new DataOutputStream(is);
			dis.writeUTF(str);
	}
}
