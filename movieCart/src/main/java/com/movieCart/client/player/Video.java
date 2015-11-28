package com.movieCart.client.player;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;
import com.movieCart.client.clientManager.ClientManager;

import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
public class Video extends JFrame{
	private final EmbeddedMediaPlayerComponent mediaPlayerComponent;
	JFrame frame;
	private JButton btnPlaypause;
	ClientManager clientManager;
	private Timer timer;
	String url;
	private JProgressBar progressBar;
	private int counter = 0;
	
	public Video(final String media){
		clientManager = new ClientManager();
		url = clientManager.start();
		
		frame = new JFrame("MovieCart");
        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        mediaPlayerComponent.getVideoSurface().setForeground(Color.GRAY);
        frame.setContentPane(mediaPlayerComponent);
        
        btnPlaypause = new JButton("play_pause");
        btnPlaypause.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		clientManager.playPauseRequest(media);
        		timer.start();
        	}
        });
        mediaPlayerComponent.add(btnPlaypause, BorderLayout.SOUTH);
        
        progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setForeground(Color.RED);
        progressBar.setBackground(Color.BLUE);
        progressBar.setMaximum(90);
        mediaPlayerComponent.add(progressBar, BorderLayout.NORTH);
        frame.setLocation(100, 100);
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
        ActionListener action = new ActionListener()
        {   
            public void actionPerformed(ActionEvent event)
            {
                if( counter == 90 )
                {
                	timer.stop();
                }
                else
                {
                	counter++;
                	progressBar.setValue(counter );
                }
                
            }
        };
        
        timer = new Timer(1000, action);
        timer.setInitialDelay(0);
        //timer.start();
        playWindow();
        System.out.println("end");
	}
	public void playWindow(){
		System.out.println(url);
		mediaPlayerComponent.getMediaPlayer().playMedia(url);
		//timer.start();
	}
}
