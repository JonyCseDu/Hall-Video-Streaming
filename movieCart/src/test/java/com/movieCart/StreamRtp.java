package com.movieCart;

/*
 * This file is part of VLCJ.
 *
 * VLCJ is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * VLCJ is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with VLCJ.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright 2009, 2010, 2011, 2012, 2013, 2014, 2015 Caprica Software Limited.
 */


import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.headless.HeadlessMediaPlayer;

/**
 * An example of how to stream a media file using RTP.
 * <p>
 * The client specifies an MRL of <code>rtp://@127.0.0.1:5555</code>
 */
public class StreamRtp {

    public static void main(String[] args) throws Exception {
    	args = new String[1];
    	args[0] = "Ubuntu phone.mp4";
        if(args.length != 1) {
            System.out.println("Specify a single MRL to stream");
            System.exit(1);
        }

        String media = args[0];
        //String options = formatRtpStream("10.42.0.47", 5555);
        String ip = "localhost";
        String options[] = {formatRtpStream(ip, 5555)};
        /*
         * 										, 
        					":no-sout-rtp-sap", 
        					":no-sout-standard-sap",
        					":sout-all",
                			":sout-keep"
         */
                			

        System.out.println("Streaming '" + media + "' to '" + options + "'");

        MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory(args);
        HeadlessMediaPlayer mediaPlayer = mediaPlayerFactory.newHeadlessMediaPlayer();
        
        mediaPlayer.setStandardMediaOptions();
        mediaPlayer.playMedia(media, options);
        
        mediaPlayer.setPause(true);
        mediaPlayer.setRepeat(true);
        
        mediaPlayer.pause();
        System.out.println(mediaPlayer.canPause());

        // Don't exit
        Thread.currentThread().join();
    }

    private static String formatRtpStream(String serverAddress, int serverPort) {
        StringBuilder sb = new StringBuilder(60);
        sb.append(":sout=#rtp{dst=");
        sb.append(serverAddress);
        sb.append(",port=");
        sb.append(serverPort);
        sb.append(",mux=ts}");
        return sb.toString();
    }
}

