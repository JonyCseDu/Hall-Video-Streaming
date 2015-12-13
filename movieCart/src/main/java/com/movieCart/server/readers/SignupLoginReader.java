package com.movieCart.server.readers;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.movieCart.Objects.UploadPacket;
import com.movieCart.Objects.SignupLoginPacket;

public class SignupLoginReader extends Thread {
	Socket socket;
	ObjectInputStream inputStream;
	ObjectOutputStream outputStream;
	
	public SignupLoginReader (Socket socket) {
		this.socket = socket;
	}
	
	public void run(){
		try{
			inputStream = new ObjectInputStream(socket.getInputStream());
			SignupLoginPacket packet = (SignupLoginPacket) inputStream.readObject();
			packet.setCommand("" + packet.readAndCheck());
			outputStream = new ObjectOutputStream(socket.getOutputStream());
			outputStream.writeObject(packet);
			System.out.println("sending " + packet.getCommand());
			outputStream.flush();
			inputStream.close();
			outputStream.close();
			socket.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
}
