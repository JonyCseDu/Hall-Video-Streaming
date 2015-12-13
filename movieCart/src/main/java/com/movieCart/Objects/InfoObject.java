package com.movieCart.Objects;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;

import javax.print.attribute.standard.PrinterMessageFromOperator;

import uk.co.caprica.vlcj.component.EmbeddedMediaListPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.headless.HeadlessMediaPlayer;

public class InfoObject implements Serializable {
	String name;
	String posterName;
	String videoName;
	int size;
	long time; // total time in milliseconds
	int dimension_x;
	int dimension_y;
	String uploader;
	
	public InfoObject(){
		new NativeDiscovery().discover();
	}
	
	public InfoObject(String name, String poster, String video, String uploader) {
		this.name = name;
		posterName = poster;
		videoName = video;
		// get info of video
		MediaPlayerFactory factory = new MediaPlayerFactory(video);
		HeadlessMediaPlayer mediaPlayer = factory.newHeadlessMediaPlayer();
		String options[] = {
        		":no-sout-rtp-sap", 
				":no-sout-standard-sap",
				":sout-all",
    			":sout-keep"
        };
        mediaPlayer.setStandardMediaOptions(options);
		
		mediaPlayer.startMedia(video, formatRtpStream("localhost", 1000));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("playing");
        
        // now get
        File file = new File(videoName);
        if(file.exists()){
			size = (int) Math.ceil(file.length() / (1024 * 1024));
			System.out.println("SIZE IN MB : " + size);
        }
        else{
        	System.err.println("FILE NOT FOUND");
        }
        
        //Dimension dimension =  mediaPlayer.getVideoDimension();
        dimension_x = 1024;//dimension.width;
        dimension_y = 756;//dimension.height;
        time = mediaPlayer.getLength();//mediaPlayer.getLength();
        System.out.println("time : " + time);
        mediaPlayer.stop();
        
        //mediaPlayer.stop();
        
        // set uploader
        this.uploader = uploader; 
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
	
	void writeFile(String key){
		File fout = new File("./PsudoServer/infos/" + key);
		BufferedWriter bWriter;
		try {
			bWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fout)));
			bWriter.write(name + "\n");
			bWriter.write(posterName + "\n");
			bWriter.write(videoName + "\n");
			bWriter.write(size + "\n");
			bWriter.write(time + "\n");
			bWriter.write(dimension_x + "\n");
			bWriter.write(dimension_y + "\n");
			bWriter.write(uploader + "\n");
			
			bWriter.flush();
			bWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void readFile(String key){
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("./PsudoServer/infos/" + key));
			name = br.readLine();
			posterName = br.readLine();
			videoName = br.readLine();
			size = Integer.valueOf(br.readLine());
			time = Integer.valueOf(br.readLine());
			System.out.println("VideoName : " + videoName);
			System.out.println("Size : " + size);
			System.out.println("time : " + time);
			dimension_x = Integer.valueOf(br.readLine());
			dimension_y = Integer.valueOf(br.readLine());
			uploader = br.readLine();
			
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosterName() {
		return posterName;
	}

	public void setPosterName(String posterName) {
		this.posterName = posterName;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int getDimension_x() {
		return dimension_x;
	}

	public void setDimension_x(int dimension_x) {
		this.dimension_x = dimension_x;
	}

	public int getDimension_y() {
		return dimension_y;
	}

	public void setDimension_y(int dimension_y) {
		this.dimension_y = dimension_y;
	}

	public String getUploader() {
		return uploader;
	}

	public void setUploader(String uploader) {
		this.uploader = uploader;
	}
	
}
