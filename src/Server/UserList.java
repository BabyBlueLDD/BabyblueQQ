package Server;
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class UserList {
	UserInfo ui=new UserInfo();
	public Map<String, UserInfo> m;
	
	public UserList(){
		m=new HashMap<String, UserInfo> ();
		
	}
	public void loadUserList(){
		try {
					String s,name,pw=null;

//					System.out.print("load user");
					FileReader fr=new FileReader("/Users/liangdan/users");
					BufferedReader br=new BufferedReader(fr);
					while((s=br.readLine())!=null){
						String[] ss=s.split(" ");
						name=ss[0];
						pw=ss[1];
	//					String s3=ss[2];
	//					System.out.println("s3 is "+ s3);
						UserInfo ui=new UserInfo();
						ui.passWord=pw;
						
						ServerTest.ul.m.put(name,ui);
						debugMap();
						
					}
					
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
	public void updateFile(){
		try {
			FileWriter fw=new FileWriter("/Users/liangdan/users" ,false);
			FileWriter afw=new FileWriter("/Users/liangdan/users" ,true);
			BufferedWriter bw=new BufferedWriter(fw);
			BufferedWriter abw=new BufferedWriter(afw);
			
			bw.write(" ");
			Set<Entry<String, UserInfo>> set=ServerTest.ul.m.entrySet();
			Iterator<Entry<String, UserInfo>> it=set.iterator();
			while (it.hasNext()){
//				System.out.print("update ");
				Entry<String, UserInfo> en=it.next();
//				name=en.getKey();
				abw.write(en.getKey()+" "+en.getValue().passWord+"\n");
				
			}
			bw.flush();
			bw.close();
			abw.flush();
			abw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean hasKey(String str){
		return m.containsKey(str);
	}
	public boolean passwordRight(String un,String pw){
		String p= m.get(un).passWord;
		return p.equals(pw);
	}
	public void debugMap(){
		Set<Entry<String, UserInfo>> set=m.entrySet();
		Iterator<Entry<String, UserInfo>> itEntry=set.iterator();
		while(itEntry.hasNext()){
			Map.Entry<String, UserInfo> entry = ((Map.Entry<String, UserInfo>)itEntry.next());
			String key=(String) entry.getKey();
			String password=entry.getValue().passWord;
			int status=entry.getValue().status;
			System.out.println("key :"+key+"   password is "+password+"  status is "+status);
					
		}
	}

}
