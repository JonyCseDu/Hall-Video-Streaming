package com.movieCart.client.managers;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import com.movieCart.Objects.GridPacket;
import com.movieCart.Objects.InfoPacket;
import com.movieCart.Objects.RequestObject;
import com.movieCart.Objects.UploadPacket;

import uk.co.caprica.vlcj.discovery.NativeDiscovery;

public class GridClientManager extends ClientManager {
	static int serverPort = 9100;
	static Socket clientSocket;
	static ObjectOutputStream outputStream;
	static ObjectOutputStream inputStream;
	
	// upload setting
	public static ArrayList<GridPacket> request(RequestObject packet){
		try {
			clientSocket = new Socket(serverIp, serverPort);
			outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
			// uploading...
			outputStream.writeObject(packet);
			outputStream.flush();
			System.out.println("requested");
			return getGridObjects();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<GridPacket> getGridObjects(){
		ArrayList<GridPacket> gridObjects = new ArrayList<GridPacket>();
		
		try {
			ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
			
			while(true){
				GridPacket object = (GridPacket) inputStream.readObject();
				if(object == null) break;
				else gridObjects.add(object);
			}
			outputStream.writeObject(null);
			outputStream.flush();
			
			// close all streams
			outputStream.close();
			inputStream.close();
			clientSocket.close();
			return gridObjects;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}
}
