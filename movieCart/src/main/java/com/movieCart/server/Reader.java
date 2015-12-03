package com.movieCart.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class Reader extends Thread{
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
	
	void takeDicisiont(String command){
		try{
			if(command.equals("play")){
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
				takeDicisiont(command);
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
