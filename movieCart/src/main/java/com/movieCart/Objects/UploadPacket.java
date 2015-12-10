package com.movieCart.Objects;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class UploadPacket implements Serializable {
	String key;
	BinaryObject image;
	BinaryObject video;
	
	public UploadPacket(String key, String imagePath, String videoPath) {
		this.key = key;
		if(imagePath != null){
			image = new BinaryObject(key, imagePath);
		}
		if(videoPath != null){
			video = new BinaryObject(key, videoPath);
		}
	}
	
	public void write(){
		try {
		    Files.write(Paths.get("./PsudoServer/keys"), key.getBytes(), StandardOpenOption.APPEND);
		}catch (IOException e) {
		    System.out.println("EXCEPTION : APPENDING KEYS");
		}
		
		image.writeBinary("./PsudoServer/posters/");
		video.writeBinary("./PsudoServer/videos/");
	}
}
