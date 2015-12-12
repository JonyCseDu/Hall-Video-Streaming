package com.movieCart.client.Manager;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import com.movieCart.Objects.GridObject;
import com.movieCart.Objects.RequestObject;
import com.movieCart.Objects.welcomepacket;

public class WelcomeManager {
	static String serverIp = "localhost";
	static int serverPort = 9200;
	static Socket clientSocket;
	static ObjectOutputStream outputStream;
	static ObjectOutputStream inputStream;
	
	// upload setting
		public boolean request(welcomepacket packet){
			try {
				clientSocket = new Socket(serverIp, serverPort);
				outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
				// uploading...
				outputStream.writeObject(packet);
				outputStream.flush();
				System.out.println("requested");
				
				// close all streams
				outputStream.close();
				inputStream.close();
				clientSocket.close();
				
				return getGridObjects();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}
		
		public boolean getGridObjects(){
				
			try {
				ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
				RequestObject object = (RequestObject) inputStream.readObject();
				return object.getCommand().equals("true");
			
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return false;
		}
}
