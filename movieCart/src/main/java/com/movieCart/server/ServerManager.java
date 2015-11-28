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

import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.condition.conditions.PausedCondition;
import uk.co.caprica.vlcj.player.condition.conditions.PlayingCondition;
import uk.co.caprica.vlcj.player.headless.HeadlessMediaPlayer;

public class ServerManager{
	int serverPort;
	ServerSocket serverSocket;
	
	boolean isFinished = false;
	
	public ServerManager(int port){
		serverPort = port;
		try {
			serverSocket = new ServerSocket(serverPort);
			//serverSocket.setSoTimeout(10000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void run(){ // just wait for socket
		while(true){
			try {
				Socket rcvedSocket = serverSocket.accept();
				System.out.println("ip :" + rcvedSocket.getRemoteSocketAddress() + " port: " + rcvedSocket.getLocalPort());
				new Reader(rcvedSocket).start();
				
				
			}catch(SocketTimeoutException e){
				if(isFinished) break;
				System.out.println("timeout\n");
			}
			catch (IOException e) {
				e.printStackTrace();
				break;
			}
		}
		// close serversocket
		try {
			serverSocket.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	void shutDown(){
		isFinished = true;
	}
	
	public static void main(String[] args){
		ServerManager serverManager = new ServerManager(7100);
		serverManager.run();
		Scanner scanner = new Scanner(System.in);
		String command;
		while((command = scanner.nextLine()) != null){
			System.out.println(command);
			if(command.toLowerCase().equals("exit")){
				serverManager.shutDown();
				break;
			}
		}
	}
}
