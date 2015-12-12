package com.movieCart.Objects;

import java.io.Serializable;

public class GridObject implements Serializable {
	InfoObject infoObject;
	BinaryObject poster;
	
	public GridObject(String key) {
		infoObject = new InfoObject();
		infoObject.readFile(key);
		poster = new BinaryObject(infoObject.name, infoObject.posterName);
	}

	public InfoObject getInfoObject() {
		return infoObject;
	}

	public void setInfoObject(InfoObject infoObject) {
		this.infoObject = infoObject;
	}

	public BinaryObject getPoster() {
		return poster;
	}

	public void setPoster(BinaryObject poster) {
		this.poster = poster;
	}
}
