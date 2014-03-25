package Server;

public class UserInfo {
	String passWord;
	int status=0;//0:off 1:online
	
	public UserInfo(){
		
	}
	UserInfo(String pw,int i){
		passWord=pw;
		status=i;
	}
	
	public void setPassword(String s){
		passWord=s;
	}
	public void setStatus(int i){
		status=i;
	}
	
}
