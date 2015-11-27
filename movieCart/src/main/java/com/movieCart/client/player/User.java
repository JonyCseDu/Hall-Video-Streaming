package com.movieCart.client.player;

import uk.co.caprica.vlcj.discovery.NativeDiscovery;

public class User {
	public static void main(final String[] args) {
    	new NativeDiscovery().discover();
        new Video("Ubuntu phone.mp4");
    }
}
