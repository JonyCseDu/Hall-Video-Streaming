package com.movieCart.client.player;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

    public class VideoExample {

        //private final EmbeddedMediaPlayerComponent mediaPlayerComponent;

        public static void main(final String[] args) {
        	new NativeDiscovery().discover();
            new VideoExample();
        }

        private VideoExample() {
        	new Video("rtp://@127.0.0.1:5555");
//            JFrame frame = new JFrame("vlcj Tutorial");
//
//            mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
//
//            frame.setContentPane(mediaPlayerComponent);
//
//            frame.setLocation(100, 100);
//            frame.setSize(500, 500);
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setVisible(true);
//
//            mediaPlayerComponent.getMediaPlayer().playMedia("rtp://@127.0.0.1:5555");
            
        }
    }