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

package com.movieCart;

import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.headless.HeadlessMediaPlayer;

/**
 * An example of how to stream a media file using RTSP.
 * <p>
 * The client specifies an MRL of <code>rtsp://@127.0.0.1:5555/demo</code>
 */
public class StreamRtsp {

    public static void main(String[] args) throws Exception {
    	args = new String[1];
    	args[0] = "Ubuntu phone.mp4";
    	if(args.length != 1) {
            System.out.println("Specify a single MRL to stream");
            System.exit(1);
        }

        String media = args[0];
        String ip = "192.168.0.135";
        String options = formatRtspStream(ip, 5555, "demo");

        System.out.println("Streaming '" + media + "' to '" + options + "'");

        MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory(args);
        HeadlessMediaPlayer mediaPlayer = mediaPlayerFactory.newHeadlessMediaPlayer();
        mediaPlayer.playMedia(media,
            options,
            ":no-sout-rtp-sap",
            ":no-sout-standard-sap",
            ":sout-all",
            ":sout-keep"
        );
        
        mediaPlayer.playMedia("movie.mp4", 
        		  ":sout=#rtp{sdp=rtsp://@127.0.0.1:5555/demo}",
        		  ":no-sout-rtp-sap", 
        		  ":no-sout-standard-sap", 
        		  ":sout-all", 
        		  ":sout-keep"
        		);

        // Don't exit
        Thread.currentThread().join();
    }

    private static String formatRtspStream(String serverAddress, int serverPort, String id) {
        StringBuilder sb = new StringBuilder(60);
        sb.append(":sout=#rtp{sdp=rtsp://@");
        sb.append(serverAddress);
        sb.append(':');
        sb.append(serverPort);
        sb.append('/');
        sb.append(id);
        sb.append("}");
        return sb.toString();
    }
}
