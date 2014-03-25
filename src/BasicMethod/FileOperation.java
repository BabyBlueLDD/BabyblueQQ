package BasicMethod;

import java.io.*;

import Server.UserInfo;
import Server.UserList;

public class FileOperation {
	UserList ul=new UserList(); 
	UserInfo ui=new UserInfo();
	String s,name,pw=null;
	public void readFile(){
		try {
			
			
			FileReader fr=new FileReader("/Users/liangdan/workspace/users");
			BufferedReader br=new BufferedReader(fr);
			while((s=br.readLine())!=null){
				String[] ss=s.split(" ");
				name=ss[0];
				pw=ss[1];
				ui.setPassword(pw);
				ul.userInfoMap.put(name,ui);
				
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void writeFile(){
		
	}
}
