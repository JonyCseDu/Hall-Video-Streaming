package com.movieCart.client.clientManager;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Scanner;

import com.movieCart.client.player.Video;

import uk.co.caprica.vlcj.discovery.NativeDiscovery;

public class ClientManager {
	String serverIp = "192.168.0.109";
	int serverPort = 7100;
	Socket clientSocket;
	static PrintWriter streamWriter;
	boolean isStarted;
	boolean isplaying;
	
	public ClientManager(){
		new NativeDiscovery().discover();
		isStarted = false;
		isplaying = false;
	}
	
	public void playPauseRequest(String media){
		if(!isStarted) start();
		if(!isplaying) play(media);
		else pause(media);
	}
	private void play(String media){
		isplaying = true;
		streamWriter.println(media);
		streamWriter.flush();
		System.out.println("playing");
	}
	private void pause(String media){
		isplaying = false;
		streamWriter.println("pause : Ubuntu phone.mp4");
		streamWriter.flush();
	}
	public void stop(){
		isStarted = false;
		streamWriter.close();
		try {
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public String start(){
		isStarted = true;
		try {
			clientSocket = new Socket(serverIp, serverPort);
			streamWriter = new PrintWriter(clientSocket.getOutputStream());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//"rtp://@127.0.0.1:5555"
		String url = "rtp://@";
		String ip = clientSocket.getLocalAddress().toString().substring(1);
		int port = clientSocket.getLocalPort();
		url += ip + ":" + port;
		System.out.println(url);
		//url = "rtp://@127.0.0.1:5555";
		return url;
	}
	
	
	public static void main(String[] args) throws UnknownHostException, IOException{
		ClientManager client = new ClientManager();
		Scanner scanner = new Scanner(System.in);
		String mString;
//		while(true){
//			mString = scanner.nextLine();
//			streamWriter.println(mString);
//			streamWriter.flush();
//			if(mString.equals("exit")) break;
//		}
		
		streamWriter.println("Ubuntu phone.mp4");
		streamWriter.flush();
		streamWriter.close();
		
		mString = "rtp://@127.0.0.1:5555";
		new Video(mString);
		
	}
}

