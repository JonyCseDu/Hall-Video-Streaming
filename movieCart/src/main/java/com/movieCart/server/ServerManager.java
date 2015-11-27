package com.movieCart.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

import javax.naming.ldap.StartTlsRequest;

import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.condition.conditions.PausedCondition;
import uk.co.caprica.vlcj.player.condition.conditions.PlayingCondition;
import uk.co.caprica.vlcj.player.headless.HeadlessMediaPlayer;

class Streaming{
	Socket socket;
	HeadlessMediaPlayer mediaPlayer;
	String ip;
	
	public Streaming(Socket socket, String media) {
		this.socket = socket;
		start(media);
		
	}
	
	void start(String media){
        ip = "localhost";
        
        /*
          										, 
        					":no-sout-rtp-sap", 
        					":no-sout-standard-sap",
        					":sout-all",
                			":sout-keep"
         */
                			

        

        MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory(media);
        mediaPlayer = mediaPlayerFactory.newHeadlessMediaPlayer();
        
        //mediaPlayer.setStandardMediaOptions();
        
        
        //mediaPlayer.setPause(true);
        mediaPlayer.setRepeat(true);
        
        //mediaPlayer.pause();
        //System.out.println(mediaPlayer.canPause());

        // Don't exit
        System.out.println("started successfully");

	}
	void stop(){
		
	}
	void play(String media){
		String options[] = {formatRtpStream(ip, 5555)};
		mediaPlayer.playMedia(media, options);
		System.out.println("Streaming '" + media + "' to '" + options + "'");
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void pause(){
		
	}
	void seek(){
		
	}
	private static String formatRtpStream(String serverAddress, int serverPort) {
        StringBuilder sb = new StringBuilder(60);
        sb.append(":sout=#rtp{dst=");
        sb.append(serverAddress);
        sb.append(",port=");
        sb.append(serverPort);
        sb.append(",mux=ts}");
        return sb.toString();
    }
}

class Reader extends Thread{
	Socket socket;
	BufferedReader streamReader;
	public Reader(Socket socket) {
		this.socket = socket;
		try {
			streamReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run(){
		//READING FROM SOCKET
		String tmp;
		try {
			//while ((tmp = streamReader.readLine()) != null) {
				tmp = streamReader.readLine();
				System.out.println("recieved : " + tmp);
				// DO SOME JOB
			//}
			
			Streaming streaming = new Streaming(socket, tmp);
			streaming.start(tmp);
			streaming.play(tmp);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("finished");
		//CLOSING STREAM READER
		try {
			streamReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

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
