package com.movieCart.Objects;

import java.io.Serializable;

public class RequestObject implements Serializable {
	String command;
	String searchKey;
	
	public RequestObject(String c, String k) {
		command = c;
		searchKey = k;
	}
	public String getCommand(){
		return command;
	}
	public String getSearchKey(){
		return searchKey;
	}
}
