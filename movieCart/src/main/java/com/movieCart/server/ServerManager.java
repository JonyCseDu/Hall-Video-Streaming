package com.movieCart.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

import javax.naming.ldap.StartTlsRequest;
import javax.sound.sampled.Port;

import com.movieCart.server.BinaryControl.BinaryReader;
import com.movieCart.server.BinaryControl.GridReader;
import com.movieCart.server.playerControl.Reader;

import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.condition.conditions.PausedCondition;
import uk.co.caprica.vlcj.player.condition.conditions.PlayingCondition;
import uk.co.caprica.vlcj.player.headless.HeadlessMediaPlayer;

public abstract class ServerManager{
	int serverPort;
	ServerSocket serverSocket;
	public ServerManager(int port) {
		serverPort = port;
		try {
			serverSocket = new ServerSocket(serverPort);
			//serverSocket.setSoTimeout(10000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public abstract void start();
}

class PlayerManager extends ServerManager{	
	public  PlayerManager(int port){
		super(port);
	}
	
	public void start(){ // just wait for socket
		while(true){
			try {
				Socket rcvedSocket = serverSocket.accept();
				System.out.println("ip :" + rcvedSocket.getRemoteSocketAddress() + " port: " + rcvedSocket.getLocalPort());
				new Reader(rcvedSocket).start();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
}

class BinaryManager extends ServerManager{	
	//boolean isFinished = false;
	
	public BinaryManager(int port){
		super(port);
	}
	
	public void start(){ // just wait for socket
		while(true){
			try {
				Socket rcvedSocket = serverSocket.accept();
				System.out.println("ip :" + rcvedSocket.getRemoteSocketAddress() + " port: " + rcvedSocket.getLocalPort());
				new BinaryReader(rcvedSocket).start();
			}catch(SocketTimeoutException e){
//				if(isFinished) break;
				System.out.println("timeout\n");
			}
			catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
		// close serversocket
//		try {
//			serverSocket.close();
//		} catch (IOException e){
//			e.printStackTrace();
//		}
	}
	
//	void shutDown(){
//		isFinished = true;
//	}
}

class GridManager extends ServerManager{
	
	public GridManager(int port){
		super(port);
	}
	
	public void start(){ // just wait for socket
		while(true){
			try {
				Socket rcvedSocket = serverSocket.accept();
				System.out.println("ip :" + rcvedSocket.getRemoteSocketAddress() + " port: " + rcvedSocket.getLocalPort());
				new GridReader(rcvedSocket).start();
			}catch(SocketTimeoutException e){
				System.out.println("timeout\n");
			}
			catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
	}
}


