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
		image.writeBinary("./PsudoServer/posters/");
		video.writeBinary("./PsudoServer/videos/");
	}
}

/* search algo
 		File folder = new File("your/path");
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				System.out.println("File " + listOfFiles[i].getName());
		    } else if (listOfFiles[i].isDirectory()) {
		        System.out.println("Directory " + listOfFiles[i].getName());
		    }
		}
 */
