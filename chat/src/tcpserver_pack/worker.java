package tcpserver_pack;

import java.net.*;
import java.io.*;

public class worker extends Thread
{
   Socket socket;
   public worker(Socket sc) {
		socket = sc;
   }

   public void run()
   {
         try
         {
            //System.out.println("Waiting for client on port " +socket.getLocalPort() + "...");
            System.out.println("Just connected to "+ socket.getRemoteSocketAddress());
            DataInputStream in =new DataInputStream(socket.getInputStream());
            
            String st=in.readUTF();
            System.out.println("Server Receive : "+st) ;
            String upper=st.toUpperCase();
            System.out.println(upper);
            
            DataOutputStream out =new DataOutputStream(socket.getOutputStream());
            out.writeUTF(upper+""+ socket.getLocalSocketAddress());
            out.flush();
            in.close();
            out.close();
            
            
            //socket.close();
         }catch(SocketTimeoutException s)
         {
            System.out.println("Socket timed out!");
            //break;
         }catch(IOException e)
         {
            e.printStackTrace();
            //break;
         }
      
   }
}