package com.movieCart.client.player;

import javax.swing.JButton;
import javax.swing.JFrame;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import java.awt.BorderLayout;
import java.awt.Color;

public class Video{
	private String url;
	private final EmbeddedMediaPlayerComponent mediaPlayerComponent;
	JFrame frame;
	private JButton btnPlaypause;
	
	public Video(String url){
		this.url = url;
		
		frame = new JFrame("vlcj Tutorial");
        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        mediaPlayerComponent.getVideoSurface().setForeground(Color.GRAY);
        frame.setContentPane(mediaPlayerComponent);
        
        btnPlaypause = new JButton("Play/Pause");
        
        mediaPlayerComponent.add(btnPlaypause, BorderLayout.SOUTH);
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
