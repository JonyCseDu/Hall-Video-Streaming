package com.movieCart.client;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.movieCart.client.grid.GridFrameClass;
import com.movieCart.client.upload.uploadUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class mymoviecart extends JFrame {
	
	private Image backgroundImage;
	public mymoviecart(){
		
		super("MY MOVIECART");
		setResizable(false);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 500);
		try {
			backgroundImage = ImageIO.read(new File("back.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		JPanel panel = new JPanel(null){
	        @Override public void paintComponent(Graphics g) {
	        	g.drawImage(backgroundImage, 0, 0, 1500,1000, null);
	        }
	    };
		panel.setSize(500, 500);
		JButton b1 = new JButton("upload");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new uploadUI();
			}
		});
	
		b1.setBounds(300, 250, 100, 20);
		JButton b2 = new JButton("Watch video");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GridFrameClass();
				setVisible(false);
			}
		});
		b2.setBounds(300, 280, 100, 20);
		
		panel.add(b1);
		panel.add(b2);
		setContentPane(panel);
		((JComponent) getContentPane()).setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10,Color.black));
		//pack();
		setVisible(true);
	}
	public static void main(String[] args) throws HeadlessException, IOException{
		new mymoviecart();
	}

}
