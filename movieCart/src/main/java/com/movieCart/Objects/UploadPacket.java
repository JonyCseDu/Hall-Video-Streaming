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
	InfoPacket infoObject;
	
	public UploadPacket(String key, String imagePath, String videoPath) {
		key = key.toUpperCase();
		this.key = key;
		if(imagePath != null){
			image = new BinaryObject(key, imagePath);
		}
		if(videoPath != null){
			video = new BinaryObject(key, videoPath);
		}
		infoObject = new InfoPacket(key, imagePath, videoPath, "");
		infoObject.posterName = "./PsudoServer/posters/" + image.FileName;
		infoObject.videoName = "./PsudoServer/videos/" + video.FileName;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public BinaryObject getImage() {
		return image;
	}

	public void setImage(BinaryObject image) {
		this.image = image;
	}

	public BinaryObject getVideo() {
		return video;
	}

	public void setVideo(BinaryObject video) {
		this.video = video;
	}

	public InfoPacket getInfoObject() {
		return infoObject;
	}

	public void setInfoObject(InfoPacket infoObject) {
		this.infoObject = infoObject;
	}

	public void write(){
		image.writeBinary("./PsudoServer/posters/");
		video.writeBinary("./PsudoServer/videos/");
		infoObject.writeFile(key);
	}
}


