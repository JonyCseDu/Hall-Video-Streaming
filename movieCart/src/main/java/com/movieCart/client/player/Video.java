package com.movieCart.client.player;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.movieCart.client.ClientManager;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Video{
	private final EmbeddedMediaPlayerComponent mediaPlayerComponent;
	JFrame frame;
	private JButton btnPlaypause;
	ClientManager clientManager;
	String url;
	
	public Video(final String media){
		clientManager = new ClientManager();
		url = clientManager.start(media);
		
		frame = new JFrame("MovieCart");
        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        mediaPlayerComponent.getVideoSurface().setForeground(Color.GRAY);
        frame.setContentPane(mediaPlayerComponent);
        
        btnPlaypause = new JButton("play_pause");
        btnPlaypause.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		clientManager.playPauseRequest(media);
        	}
        });
        mediaPlayerComponent.add(btnPlaypause, BorderLayout.SOUTH);
        frame.setLocation(100, 100);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        playWindow();
        System.out.println("end");
	}
	public void playWindow(){
		System.out.println(url);
		mediaPlayerComponent.getMediaPlayer().playMedia(url);
	}
}
