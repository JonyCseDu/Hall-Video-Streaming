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
	InfoObject infoObject;
	
	public UploadPacket(String key, String imagePath, String videoPath) {
		this.key = key;
		if(imagePath != null){
			image = new BinaryObject(key, imagePath);
		}
		if(videoPath != null){
			video = new BinaryObject(key, videoPath);
		}
		infoObject = new InfoObject(key, imagePath, videoPath, "");
		infoObject.posterName = "./PsudoServer/posters/" + image.FileName;
		infoObject.videoName = "./PsudoServer/videos/" + video.FileName;
	}
	
	public void write(){
		image.writeBinary("./PsudoServer/posters/");
		video.writeBinary("./PsudoServer/videos/");
		infoObject.writeFile(key);
	}
}


