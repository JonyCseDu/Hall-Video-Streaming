package com.movieCart;

import javax.swing.JFrame;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;

public class Video extends JFrame {
	private String url;
	private final EmbeddedMediaPlayerComponent mediaPlayerComponent;
	
	public Video() {
		super();
		mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
	}
	public Video(String Url){
		this();
		this.url = url;
		this.setLocation(100, 100);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        play("rtp://@230.0.0.1:5555");
	}
	public void play(String stream){
		mediaPlayerComponent.getMediaPlayer().playMedia(stream);
	}
}
