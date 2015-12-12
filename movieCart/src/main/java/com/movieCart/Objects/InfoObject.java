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
		
	}
	
	public InfoObject(String name, String poster, String video, String uploader) {
		this.name = name;
		posterName = poster;
		videoName = video;
		// get info of video
		EmbeddedMediaListPlayerComponent component = new EmbeddedMediaListPlayerComponent();
		EmbeddedMediaPlayer mediaPlayer = component.getMediaPlayer();
		
		String options[] = {
        		":no-sout-rtp-sap", 
				":no-sout-standard-sap",
				":sout-all",
    			":sout-keep"
        };
        mediaPlayer.setStandardMediaOptions(options);
        mediaPlayer.startMedia(video);
        
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
        
        Dimension dimension =  mediaPlayer.getVideoDimension();
        dimension_x = dimension.width;
        dimension_y = dimension.height;
        time = mediaPlayer.getLength();
        System.out.println("time : " + time);
        
        mediaPlayer.stop();
        
        // set uploader
        this.uploader = uploader; 
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
			size = br.read();
			time = br.read();
			dimension_x = br.read();
			dimension_y = br.read();
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
