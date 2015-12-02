package tcpserver_pack;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Listener extends Thread {
	private ServerSocket serverSocket;
	public Listener(int port) throws IOException {
		serverSocket = new ServerSocket(port);
	    //System.out.println("SERVERSOCKET STARTED");
	}
	public void run(){
		Socket socket;
		Socket[] sockets = new Socket[7];
		worker[] workers = new worker[7];
		int cnt = 0;
		try {
			while(true){
				socket = serverSocket.accept();
				boolean found = false;
				for(int i=0; i<cnt; i++){
					if(sockets[i].getRemoteSocketAddress() == socket.getRemoteSocketAddress()){
						found = true;
					}
					else{
						workers[i].start();
					}
				}
				if(!found) {
					sockets[cnt] = socket;
					workers[cnt] = new worker(socket);
					cnt++;
				}
				
			}
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public static void main(String[] args){
		int port = 2300;
	    try
	    {
	        Thread t = new Listener(port);
	        t.start();
	    }catch(IOException e)
	    {
	       e.printStackTrace();
	    }
	}
}
