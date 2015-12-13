package com.movieCart.client.managers;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.movieCart.Objects.InfoPacket;
import com.movieCart.Objects.UploadPacket;
import com.movieCart.Objects.SignupLoginPacket;

import uk.co.caprica.vlcj.discovery.NativeDiscovery;

public class LoginSignUpClientManager extends ClientManager {
	static int serverPort = 9200;
	static Socket clientSocket;
	static ObjectOutputStream outputStream;
	
	// upload setting
	public static boolean serverCheck(SignupLoginPacket packet){
		try {
			clientSocket = new Socket(serverIp, serverPort);
			outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
			
			// send data to server
			outputStream.writeObject(packet);
			outputStream.flush();
			System.out.println("sending");
			// read server response
			ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
			packet = (SignupLoginPacket) inputStream.readObject();
			
			System.out.println("found : " + packet.getCommand());
			
			inputStream.close();
			outputStream.close();
			clientSocket.close();
			return packet.getCommand().equals("true");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
}
