package Server;

import BasicMethod.*;
import java.io.*;
import java.net.*;

public class ServerConnection implements Runnable {
	BasicWriteAndRead bwr = new BasicWriteAndRead();
	public static String warning = "Password is incorrect"; // global warning
															// message

	Socket sock_conn = null;
	
	

	ServerConnection(Socket s) {
		this.sock_conn = s;
	}
		
	
	public boolean Login(){
		return false;
	}
	public boolean Query(){
		return false;
	}
	/* TODO 
	 * Divide the the run function into several pieces: Login -> Query
	 * If(!Login()) return;
	 * while(Query()) return;  
	 * */
	@Override
	public void run() {
		try {
			boolean flag = true;

			while (flag) {
				bwr.sendMessage(sock_conn, "what's your username?");
				String un = bwr.receiveMessage(sock_conn);
				ServerLog.Log("the username is:  " + un);
				if (ServerTest.userList.hasKey(un)) {
					bwr.sendMessage(sock_conn,
							"username is correct,what's your password?");
					String pw = bwr.receiveMessage(sock_conn);
					if (ServerTest.userList.passwordRight(un, pw)) {
						

						if (ServerTest.userList.userInfoMap.get(un).status == 1) {
							bwr.sendMessage(sock_conn, "you are online already");
						} else {
							bwr.sendMessage(sock_conn, "welcome !!!! \n");
							ServerTest.userList.userInfoMap.get(un).status = 1;
							synchronized (this) {
								ServerTest.count++;
								ServerTest.allUser++;
							}

							ServerQuery sq = new ServerQuery(sock_conn);
							sq.respondToQuery(un);
							flag = false;
						}
					} else {
						bwr.sendMessage(sock_conn, warning);

					}

				} else {
					bwr.sendMessage(sock_conn, "the username doesn't exist");
				}
			}

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
