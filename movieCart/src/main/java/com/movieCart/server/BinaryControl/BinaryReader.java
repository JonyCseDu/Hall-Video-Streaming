package com.movieCart.server.BinaryControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import javax.print.attribute.standard.PrinterMessageFromOperator;

import com.movieCart.Objects.UploadPacket;

public class BinaryReader extends Thread {
	Socket socket;
	ObjectInputStream inputStream;
	ObjectOutputStream outputStream;
	
	public BinaryReader (Socket socket) {
		this.socket = socket;
//		try {
//			streamReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			streamWriter = new PrintWriter(socket.getOutputStream());
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	void takeUploadStream(){
		try{
			inputStream = new ObjectInputStream(socket.getInputStream());
			UploadPacket packet = (UploadPacket) inputStream.readObject(); 
			packet.write();
			inputStream.close();
			System.out.println("writing object successful");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void run(){
		takeUploadStream();
		
	}
}
