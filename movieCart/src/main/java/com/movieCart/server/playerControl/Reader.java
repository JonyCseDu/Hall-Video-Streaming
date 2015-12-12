package com.movieCart.server.playerControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;

import com.movieCart.Objects.UploadPacket;

public class Reader extends Thread{
	Socket socket;
	BufferedReader streamReader;
	PrintWriter streamWriter;
	StreamingPlayer streaming=null;
	
	public Reader(Socket socket) {
		this.socket = socket;
		try {
			streamReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			streamWriter = new PrintWriter(socket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void takeDicision(String command){
		try{
			if(command.equals("upload")){
				try {
					ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
					UploadPacket packet = (UploadPacket) inputStream.readObject(); 
					packet.write();
					streamWriter.println("ok");
					inputStream.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
			else if(command.equals("play")){
				streaming.play();
			}
			else if(command.equals("pause")){
				streaming.pause();
			}
			else if(command.equals("stop")){
				streaming.stop();
				streamWriter.println("ok");
				streamWriter.flush();
			}
			else if(command.charAt(0) >= '0' && command.charAt(0) <= '9'){
				//command.
				System.out.println("got : " + Integer.parseInt(command));
				streaming.seek(Integer.parseInt(command));
				
				streamWriter.println("ok");
				streamWriter.flush();
			}
			else{
				System.out.println("else happend");
				streaming = new StreamingPlayer(socket, command);
				System.out.println(socket);
				streaming.start(command);
				
				streamWriter.println("ok");
				streamWriter.flush();
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
	}
	
	public void run(){
		//READING FROM SOCKET
		String command;
		try {
			while((command = streamReader.readLine()) != null){
				System.out.println("recieved : " + command);
				takeDicision(command);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("finished");
		
		//CLOSING STREAM READER
		try {
			streamReader.close();
			streamWriter.close();
			//socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
