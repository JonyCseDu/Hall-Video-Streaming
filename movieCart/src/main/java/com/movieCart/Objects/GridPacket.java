package com.movieCart.Objects;

import java.io.Serializable;

public class GridPacket implements Serializable {
	InfoPacket infoObject;
	BinaryObject poster;
	
	public GridPacket(String key) {
		infoObject = new InfoPacket();
		infoObject.readFile(key);
		poster = new BinaryObject(infoObject.name, infoObject.posterName);
	}

	public InfoPacket getInfoObject() {
		return infoObject;
	}

	public void setInfoObject(InfoPacket infoObject) {
		this.infoObject = infoObject;
	}

	public BinaryObject getPoster() {
		return poster;
	}

	public void setPoster(BinaryObject poster) {
		this.poster = poster;
	}
}
