package com.movieCart.client;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.Scanner;

import com.movieCart.Objects.UploadPacket;
import com.movieCart.client.player.Video;

import uk.co.caprica.vlcj.discovery.NativeDiscovery;

public class ClientManager {
	static String serverIp = "localhost";
	static int serverPort = 7100;
	static Socket clientSocket;
	static PrintWriter streamWriter;
	static BufferedReader streamReader;
	static boolean isStarted;
	static boolean isplaying;
	//static boolean hasSocket=false;
	
	public ClientManager(){
		new NativeDiscovery().discover();
		isStarted = false;
		isplaying = true;
	}
	
	// player settings
	public String start(String media){
		//if(hasSocket) stop();
		isStarted = true;
		try {
			clientSocket = new Socket(serverIp, serverPort);
			streamWriter = new PrintWriter(clientSocket.getOutputStream());
			streamReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			//hasSocket = true;
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		streamWriter.println(media);
		streamWriter.flush();
		
		// reading ack
		try {
			String ack = streamReader.readLine();
			System.out.println("ACK : " + ack);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// generate url for client's stream play
		String url = "rtp://@";
		String ip = clientSocket.getLocalAddress().toString().substring(1);
	
		int port = clientSocket.getLocalPort();
		url += ip + ":" + port;
		System.out.println(url);
		//url = "rtp://@127.0.0.1:5555";
		return url;
	}
	
	public void stop(){
		isStarted = false;
		streamWriter.println("stop");
		streamWriter.flush();
		System.out.println("stop clicked");
		
		// reading ack
		try {
			String ack = streamReader.readLine();
			System.out.println("ACK : " + ack);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// close sokcet and streams
		try {
			streamWriter.close();
			streamReader.close();
			clientSocket.close();
			//hasSocket = false;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void seek(int time){
		// writing seek request in stream
		streamWriter.println(time);
		streamWriter.flush();
		// reading ack
		try {
			String ack = streamReader.readLine();
			System.out.println("ACK : " + ack);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("seeking");
	}
}

