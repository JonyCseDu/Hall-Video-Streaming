package com.movieCart.Objects;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BinaryObject implements Serializable {
	String FileName;
	byte[] bytes;
	public BinaryObject(String key, String aFileName){
		for(int i=aFileName.length()-1; i>=0; i--){
			if(aFileName.charAt(i) == '.'){
				FileName = key + aFileName.substring(i);
				System.out.println("target file Name : " + FileName);
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
			System.out.println("Byte reading exception");
		}
		return null;
	}
	
	void writeBinary(String base) {
	    Path path = Paths.get(base + FileName);
	    try {
			Files.write(path, bytes);
		} catch (IOException e) {
			System.out.println("Byte writing exception");
		} //creates, overwrites
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		FileName = fileName;
	}

	public byte[] getBytes() {
		return bytes;
	}

	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
}
