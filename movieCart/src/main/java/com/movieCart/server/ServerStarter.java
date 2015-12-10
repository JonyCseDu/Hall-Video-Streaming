package com.movieCart.server;



public class ServerStarter implements Runnable{
	ServerManager serverManager;
	public ServerStarter(ServerManager serverManager) {
		this.serverManager = serverManager;
	}
	public void run() {
		serverManager.start();
	}
	public static void main(String[] args){
		Thread playerManager = new Thread(new ServerStarter(new PlayerManager(7100)));
		Thread binaryManager = new Thread(new ServerStarter(new BinaryManager(8100)));
		
		playerManager.start();
		binaryManager.start();
	}
}
