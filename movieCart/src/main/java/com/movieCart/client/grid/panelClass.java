package com.movieCart.client.grid;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class panelClass extends JPanel{
	
	String title="Void Panel";
	
	public panelClass() {
	
		// TODO Auto-generated constructor stub
		super();
		this.createPanel();
	}
	
	public panelClass(String title) {
		
		// TODO Auto-generated constructor stub
		super();
		this.createPanel();
	}
	
	
	void createPanel(){
		
		add(new JLabel("panel"));
		
		
	}

}