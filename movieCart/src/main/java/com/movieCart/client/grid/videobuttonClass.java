package com.movieCart.client.grid;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class videobuttonClass extends JButton{
	String varName="buttonVariable";
	String buttonText="voidButton";
	
	
	public videobuttonClass() {
		// TODO Auto-generated constructor stub
		super();
		this.createButton();
		
	}
	public videobuttonClass(String name,String title) {
		// TODO Auto-generated constructor stub
		super();
		this.varName=name;
		this.buttonText=title;
		this.createButton();
		
	}
	
	
	
	
	
	void createButton(){
		
		this.setPreferredSize(new Dimension(100,100));
		this.setName(varName);
		this.setText(buttonText);
		//this.setSize(width, height);
		
		this.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame frame=new JFrame("video");
				frame.setBounds(100, 100, 400, 400);
				frame.setVisible(true);
			
				System.out.println(varName+" button is pressed --> show "+buttonText);
				
			}
		});
		
		
		
	}
	
	

}