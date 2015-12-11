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
	static String serverIp = "192.168.0.109";
	static int serverPort = 8100;
	static Socket clientSocket;
	static ObjectOutputStream outputStream;
	
	public BinaryClientManager() {
		new NativeDiscovery().discover();
	}
	
	// upload setting
	public static void upload(UploadPacket packet){
		try {
			clientSocket = new Socket(serverIp, serverPort);
			outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
			// uploading...
			outputStream.writeObject(packet);
			outputStream.flush();
			System.out.println("upload finished");
			// close
			outputStream.close();
			clientSocket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
