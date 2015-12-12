package com.movieCart.client.player;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

import com.movieCart.client.ClientManager;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.player.condition.conditions.PausedCondition;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop.Action;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.ActionEvent;

public class Video{
	private final EmbeddedMediaPlayerComponent mediaPlayerComponent;
	private final EmbeddedMediaPlayer mediaPlayer;
	JFrame frame;
	JSlider sliderSeeker;
	ClientManager clientManager;
	String url;
	Timer timer;
	//static final String media;
	boolean isplaying = false;
	boolean isStarted = true;
	
	public Video(final String media){
		//media = this.media;
		clientManager = new ClientManager();
		
		frame = new JFrame("MovieCart");
        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        mediaPlayer = mediaPlayerComponent.getMediaPlayer();
        
        mediaPlayerComponent.getVideoSurface().setForeground(Color.GRAY);
        //frame.setContentPane(mediaPlayerComponent);
        frame.add(mediaPlayerComponent, BorderLayout.CENTER);
        frame.setLocation(100, 100);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        //////////////////////////////
        
        JPanel bottomPanel = new JPanel(); // for adding play and stop button
        JPanel rightBottomPanel = new JPanel(); // for slider
        bottomPanel.setLayout(new BorderLayout());
        rightBottomPanel.setLayout(new GridLayout(1, 1));

        //play/pause button
        JButton btnPlay = new JButton("Play");
        btnPlay.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(isplaying) pause();
        		else play();
        	}
        });
        btnPlay.setToolTipText("play/pause");
        bottomPanel.add(btnPlay, BorderLayout.WEST);
        
        // stop/start button
        JButton btnStop = new JButton("Stop");
        btnStop.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(isStarted) stop();
        		//final String tmp = media.toString();
        		else start(media);
        	}
        });
        btnStop.setToolTipText("Stop");
        bottomPanel.add(btnStop, BorderLayout.EAST);
        
        //adding slider
        sliderSeeker = new JSlider();
        sliderSeeker.setToolTipText("Seek");
        sliderSeeker.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pause();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            	//time = sliderSeeker.getValue();
            	time = sliderSeeker.getValue();
                seek(time);
                play();
            }
        });
        rightBottomPanel.add(sliderSeeker);
        
        //bottomPanel.add(leftBottomPanel);
        bottomPanel.add(rightBottomPanel, BorderLayout.CENTER);
        frame.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        
     
        frame.setVisible(true);
        start(media);
	}
	
	int time = 0;
	ActionListener timerActionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(time == 90*1000){
				timer.stop();
			}
			else{
				time++;
				sliderSeeker.setValue(time);
			}
			
		}
	};
	private void start(final String media){
		url = clientManager.start(media);
		mediaPlayer.playMedia(url);
		isStarted = true;
		isplaying = true;
		
		startTimer();
		
	}
	private void play(){
		isplaying = true;
		mediaPlayer.play();
		timer.start();
	}
	private void pause(){
		isplaying = false;
		mediaPlayer.pause();
		timer.stop();
		
	}
	private void stop(){
		isStarted = false;
		clientManager.stop();
		mediaPlayer.stop();
		timer.stop();
		sliderSeeker.setValue(0);
	}
	private void seek(int time){
		System.out.println("seek : " + time);
		mediaPlayer.setPosition(time);
		mediaPlayer.setTime(time);
		clientManager.seek(time);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		timer.stop();
	}
	private void startTimer(){
		timer = new Timer(1, timerActionListener);
		timer.setInitialDelay(0);
		timer.start();
		time = 0;
		sliderSeeker.setMaximum(90*1000);
		sliderSeeker.setValue(time);
	}
}

