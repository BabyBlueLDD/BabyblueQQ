package Client;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.*;
import java.util.*;


public class ClientTest {

	 public static Socket s=null;

	 public static void main(String[] a) throws UnknownHostException, IOException{
		
		 ClientTest.s=new Socket("127.0.0.1",8888);
		 ClientConnection c=new ClientConnection(s);
		 c.load();
		 
		 ClientQuery cq=new ClientQuery(s);
		 cq.query();


		 
	 }
	 
}
