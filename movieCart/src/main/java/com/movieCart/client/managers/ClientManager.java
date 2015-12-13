package com.movieCart.client.managers;

public abstract class ClientManager {
	static String serverIp = "localhost";
	public static void setServerIp(String ip){
		serverIp = ip;
	}
}
