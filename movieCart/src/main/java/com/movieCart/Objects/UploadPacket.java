package com.movieCart.Objects;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class BinaryObject{
	String FileName;
	byte[] bytes;
	public BinaryObject(String key, String aFileName){
		for(int i=aFileName.length()-1; i>=0; i--){
			if(aFileName.charAt(i) == '.'){
				FileName = key + aFileName.substring(i);
				break;
			}
		}
		bytes = readBinary(aFileName);
	}
	
	byte[] readBinary(String aFileName) {
		Path path = Paths.get(aFileName);
		try {
			return Files.readAllBytes(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	void writeBinary() {
	    Path path = Paths.get(FileName);
	    try {
			Files.write(path, bytes);
		} catch (IOException e) {
			e.printStackTrace();
		} //creates, overwrites
	}
}

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
}
