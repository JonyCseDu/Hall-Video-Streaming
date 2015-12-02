package tcpclient_pack;
import java.net.*;
import java.sql.ClientInfoStatus;
import java.util.Scanner;
import java.io.*;
class take_user_pas
{
	String get(String s)
	{
		String st;
		System.out.print(s+" ") ;
        Scanner str = new Scanner(System.in);
        st = str.nextLine();
        return st ;
	}
}
class client
{
	Socket client;
	int port;
	public client() throws UnknownHostException, IOException {
		port = 2300;
		client = new Socket("localhost", port);
	}
	
	void recieve() throws IOException{
		InputStream inFromServer = client.getInputStream();
	    DataInputStream in =
	                   new DataInputStream(inFromServer);
	    System.out.println(port + "recieves: " + in.readUTF());
	}
	
	void send(String message)
	{
	      try
	      {
	         System.out.println("Connecting"
	                             + " on port " + port);
	         
	         System.out.println("Just connected to " + client.getRemoteSocketAddress());
	         OutputStream outToServer = client.getOutputStream();
	         DataOutputStream out = new DataOutputStream(outToServer);
	         String send = message;
	         System.out.println(port + " sends : " + send) ;
	         out.writeUTF(send);
	         //client.close();
	      }catch(IOException e)
	      {
	         e.printStackTrace();
	      }
	}
}

public class client_caseconver extends Thread
{
   public static void main(String [] args) throws UnknownHostException, IOException
   {
	  Scanner sc = new Scanner(System.in);
	  System.out.println("PORT :");
	  int port = sc.nextInt();
	  client c1 = new client();
	  while(true){
		  take_user_pas t = new take_user_pas() ;
		  String message = t.get("Enter your message : ") ;
		  c1.send(message);
	  }
	  
	  //send_message sm = new send_message() ;
	  
   }
}
