package com.movieCart;

import javax.swing.JFrame;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;

public class Video{
	private String url;
	private final EmbeddedMediaPlayerComponent mediaPlayerComponent;
	JFrame frame;
	
	public Video(String url){
		this.url = url;
		
		frame = new JFrame("vlcj Tutorial");
        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        frame.setContentPane(mediaPlayerComponent);
        frame.setLocation(100, 100);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        play();
	}
	public void play(){
		System.out.println(url);
		mediaPlayerComponent.getMediaPlayer().playMedia(url);
	}
}
