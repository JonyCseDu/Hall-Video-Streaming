package com.movieCart.server;

import java.net.ServerSocket;
import java.net.Socket;

import javax.sound.sampled.Port;

import org.omg.CORBA.portable.InputStream;

public class ServerManager{
	static class Reciever extends Thread{
		static int port = 6789;
		@Override
		public void run() {
			ServerSocket serverSocket = new ServerSocket(port);
	           
	        // File f= new File("E:\\test.pdf");
	       //  f.createNewFile();
	         while(true)
	         {
	            Socket connectionSocket =serverSocket.accept();
	            InputStream in = (InputStream) connectionSocket.getInputStream();
	            
	            byte[] bytes = new byte[1024];
	            in.read(bytes);
	            String msg = new String(bytes);
	            
	            String command = msg.substring(0, 1);
	            String body = msg.substring(1, msg.length());
	            
	            
	            
	            OutputStream out = new FileOutputStream(f);
	            

	            int count;
	            while ((count = in.read(bytes)) > 0) {
	                out.write(bytes, 0, count);
	            }
	            if(in.read()==-1)
	            {
	                connectionSocket.close();
	                break;
	            }
	         }
	                
	        DatagramSocket serverSocket2 = new DatagramSocket(9876);
	        byte[] receiveData = new byte[1024];
	        byte[] sendData = new byte[1024];   
	        

	        String msg= "FILE is Ready";
	        InetAddress IPAddress=InetAddress.getByName("localhost");
	        sendData = msg.getBytes();
	        DatagramPacket sendPacket =
	                  new DatagramPacket(sendData, sendData.length, IPAddress, 9877);
	        serverSocket2.send(sendPacket);
	        
	        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
	        serverSocket2.receive(receivePacket);
	        String sentence = new String( receivePacket.getData());
	        System.out.println("RECEIVED: " + sentence);
		}
	}
	static class Sender{
		static void send(String str){
			
		}
		static void send(){ // file send
			
		}
	}
	public static void main(String[] args){
		
	}

}
