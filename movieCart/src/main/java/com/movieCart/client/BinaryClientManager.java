package com.movieCart.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import com.movieCart.Objects.UploadPacket;

import uk.co.caprica.vlcj.discovery.NativeDiscovery;

public class BinaryClientManager {
	static String serverIp = "localhost";
	static int serverPort = 8100;
	static Socket clientSocket;
	static ObjectOutputStream outputStream;
	
	public BinaryClientManager() {
		new NativeDiscovery().discover();
	}
	
	// upload setting
		public static void upload(UploadPacket packet){
			try {
				//hasSocket = true;
				clientSocket = new Socket(serverIp, serverPort);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
				outputStream.writeObject(packet);
				outputStream.flush();
				System.out.println("upload finished");
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			// close sokcet and streams
			try {
				clientSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
