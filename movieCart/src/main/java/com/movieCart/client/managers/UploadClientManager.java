package com.movieCart.client.managers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;

import com.movieCart.Objects.UploadPacket;
import com.movieCart.client.frames.ClarificationFrame;

import uk.co.caprica.vlcj.discovery.NativeDiscovery;

public class UploadClientManager extends ClientManager{
	static int serverPort = 8100;
	static Socket clientSocket;
	static ObjectOutputStream outputStream;
	
	public UploadClientManager() {
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
			new ClarificationFrame("Uploading Success, key : " + packet.getKey());
			// close
			outputStream.close();
			clientSocket.close();
		} catch (Exception e) {
			new ClarificationFrame("Uploading Failed, key : " + packet.getKey());
		}

	}
}
