package com.movieCart.client.upload;


import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.nio.channels.NonWritableChannelException;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

class FileChooser extends JFrame{
	public FileChooser(String name){
		super(name);
		JFileChooser chooser = new JFileChooser();
		chooser.setFileHidingEnabled(false);
		add(chooser);
		
		pack();
		setVisible(true);
		
	}
}

public class uploadUI extends JFrame  {
	private JTextField key;
	private JTextField imageUrl;
	private JTextField videoUrl;
	private Image backgroundImage;
	public uploadUI() throws HeadlessException, IOException {
		super("UPLOAD");
		setSize(600, 200);
		//getContentPane().setBackground(Color.WHITE);/home/sayed/Downloads/
		backgroundImage = ImageIO.read(new File("images.jpg"));
		 setContentPane(new JPanel(new BorderLayout()) {
		        @Override public void paintComponent(Graphics g) {
		            g.drawImage(backgroundImage, 0, 0,1500,1000, null);
		        }
		    });
		((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  
		getContentPane().setLayout(new GridLayout(4, 1, 20, 20));
		JPanel keyPanel = new JPanel();
		JPanel imagePanel = new JPanel();
		JPanel videoPanel = new JPanel();
		JPanel submitPanel = new JPanel();
		
		keyPanel.setLayout(new BorderLayout());
		imagePanel.setLayout(new BorderLayout());
		videoPanel.setLayout(new BorderLayout());
		//submitPanel.setLayout(new BorderLayout());
		
		getContentPane().add(keyPanel, BorderLayout.CENTER);
		getContentPane().add(imagePanel, BorderLayout.CENTER);
		getContentPane().add(videoPanel, BorderLayout.CENTER);
		getContentPane().add(submitPanel, BorderLayout.CENTER);
		
		key = new JTextField();
		key.setToolTipText("Search Key");
		key.setText("Search Key");
		key.setSize(600, 50);
		keyPanel.add(key, BorderLayout.CENTER);
		key.setColumns(50);
		
		imageUrl = new JTextField();
		imageUrl.setToolTipText("Choose Poster");
		imageUrl.setText("Choose Poster");
		imageUrl.setSize(450, 50);
		imagePanel.add(imageUrl, BorderLayout.CENTER);
		imageUrl.setColumns(50);
		
		JButton imageChoser = new JButton("choose");
		imageChoser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FileChooser("Choose Image");
			}
		});
		imageChoser.setToolTipText("Poster Choose");
		imagePanel.add(imageChoser, BorderLayout.EAST);
		
		
		videoUrl = new JTextField();
		videoUrl.setToolTipText("choose video");
		videoUrl.setText("Choose video");
		videoUrl.setSize(500, 50);
		videoPanel.add(videoUrl, BorderLayout.CENTER);
		videoUrl.setColumns(50);
		
		JButton videoChooser = new JButton("choose");
		videoChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new FileChooser("Choose Video");
			}
		});
		videoChooser.setToolTipText("choose");
		videoPanel.add(videoChooser, BorderLayout.EAST);
		
		JButton upload = new JButton("UPLOAD");
		upload.setToolTipText("upload");
		submitPanel.add(upload);
		
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) throws HeadlessException, IOException{
		new uploadUI();
	}
}
