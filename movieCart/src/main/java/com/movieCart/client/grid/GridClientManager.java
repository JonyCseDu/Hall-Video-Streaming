package com.movieCart.client.grid;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import com.movieCart.Objects.GridObject;
import com.movieCart.Objects.InfoObject;
import com.movieCart.Objects.RequestObject;
import com.movieCart.Objects.UploadPacket;

import uk.co.caprica.vlcj.discovery.NativeDiscovery;

public class GridClientManager {
	static String serverIp = "localhost";
	static int serverPort = 9100;
	static Socket clientSocket;
	static ObjectOutputStream outputStream;
	
	// upload setting
	public static ArrayList<GridObject> request(RequestObject packet){
		try {
			clientSocket = new Socket(serverIp, serverPort);
			outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
			// uploading...
			outputStream.writeObject(packet);
			outputStream.flush();
			System.out.println("requested");
			// close
			outputStream.close();
			return getGridObjects();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static ArrayList<GridObject> getGridObjects(){
		ArrayList<GridObject> gridObjects = new ArrayList<GridObject>();
		
		try {
			ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
			
			while(true){
				GridObject object = (GridObject) inputStream.readObject();
				if(object == null) break;
				else gridObjects.add(object);
			}
			inputStream.close();
			clientSocket.close();
			return gridObjects;
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}
}
