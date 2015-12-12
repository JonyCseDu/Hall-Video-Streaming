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

import com.movieCart.Objects.UploadPacket;
import com.movieCart.client.ClientManager;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class uploadUI extends JFrame  {
	private JTextField key;
	private JTextField imageUrl;
	private JTextField videoUrl;
	private Image backgroundImage;
	public uploadUI() {
		super("UPLOAD");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(600, 200);
		
		// setting background
		
		//getContentPane().setBackground(Color.WHITE);/home/sayed/Downloads/
		try {
			backgroundImage = ImageIO.read(new File("back.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 setContentPane(new JPanel(new BorderLayout()) {
		        @Override public void paintComponent(Graphics g) {
		            g.drawImage(backgroundImage, 0, 0, 1500,1000, null);
		        }
		    });
		((JComponent) getContentPane()).setBorder(BorderFactory.createMatteBorder(10, 10, 10, 10,Color.black));  
		getContentPane().setLayout(new GridLayout(4, 1, 20, 20));
		
		// panels setting

		JPanel keyPanel = new JPanel();
		JPanel imagePanel = new JPanel();
		JPanel videoPanel = new JPanel();
		JPanel submitPanel = new JPanel();
		
		keyPanel.setLayout(new BorderLayout());
		imagePanel.setLayout(new BorderLayout());
		videoPanel.setLayout(new BorderLayout());
		submitPanel.setLayout(new BorderLayout());
		
		getContentPane().add(keyPanel, BorderLayout.CENTER);
		getContentPane().add(imagePanel, BorderLayout.CENTER);
		getContentPane().add(videoPanel, BorderLayout.CENTER);
		getContentPane().add(submitPanel, BorderLayout.CENTER);
		
		// key text
		
		key = new JTextField();
		key.addFocusListener(new FocusListener() {
			
			public void focusLost(FocusEvent e) {
				if(key.getText().length() == 0) key.setText("Search Key");
				
			}
			
			public void focusGained(FocusEvent e) {
				if(true) key.setText("");
				
			}
		});
		
		key.setToolTipText("Search Key");
		key.setText("Search Key");
		key.setSize(600, 50);
		keyPanel.add(key, BorderLayout.CENTER);
		key.setColumns(50);
		
		// poster
		
		imageUrl = new JTextField();
		imageUrl.setToolTipText("Poster Url");
		imageUrl.setText("Poster Url");
		imageUrl.setSize(450, 50);
		imagePanel.add(imageUrl, BorderLayout.CENTER);
		imageUrl.setColumns(50);
		
		imageUrl.addFocusListener(new FocusListener() {
			
			public void focusLost(FocusEvent e) {
				if(imageUrl.getText().length() == 0) imageUrl.setText("Poster Url");
			}
			
			public void focusGained(FocusEvent e) {
				if(true) imageUrl.setText("");
			}
		});
		
		JButton imageChoser = new JButton("choose");
		imageChoser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				chooser.setFileHidingEnabled(false);
				chooser.showSaveDialog(null);
				String path="Poster Url";
				try{
					path = chooser.getSelectedFile().getAbsolutePath();
					String filename = chooser.getSelectedFile().getName();
				}catch(NullPointerException ex){
					//ex.printStackTrace();
				}
				imageUrl.setText(path);
			}
		});
		imageChoser.setToolTipText("Poster Choose");
		imagePanel.add(imageChoser, BorderLayout.EAST);
		
		// video
		videoUrl = new JTextField();
		videoUrl.setToolTipText("Video Url");
		videoUrl.setText("Video Url");
		videoUrl.setSize(500, 50);
		videoPanel.add(videoUrl, BorderLayout.CENTER);
		videoUrl.setColumns(50);
		
		videoUrl.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				if(videoUrl.getText().length() == 0) videoUrl.setText("Video Url");
				
			}
			public void focusGained(FocusEvent e) {
				if(true) videoUrl.setText("");
			}
		});
		
		JButton videoChooser = new JButton("choose");
		videoChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				chooser.setFileHidingEnabled(false);
				chooser.showSaveDialog(null);
				String path="Video Url";
				try{
					path = chooser.getSelectedFile().getAbsolutePath();
					String filename = chooser.getSelectedFile().getName();
				}catch(NullPointerException ex){
					//ex.printStackTrace();
				}
				videoUrl.setText(path);
			}
		});
		videoChooser.setToolTipText("choose");
		videoPanel.add(videoChooser, BorderLayout.EAST);
		
		// upload button
		
		JButton upload = new JButton("UPLOAD");
		//upload.setSize(100, 50);
		upload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				UploadPacket packet = new UploadPacket(key.getText(),
						imageUrl.getText(), videoUrl.getText());
				
				
				BinaryClientManager.upload(packet);
			}
		});
		upload.setToolTipText("upload");
		submitPanel.add(upload);
		
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args) throws HeadlessException, IOException{
		new uploadUI();
	}
}
