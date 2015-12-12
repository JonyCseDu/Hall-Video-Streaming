package com.movieCart.client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.movieCart.Objects.UploadPacket;
import com.movieCart.Objects.welcomepacket;

public class welcomepage extends JFrame  {
	
	private Image backgroundImage;
	private JTextField email;
	private JTextField password;
	public welcomepage() throws IOException {
		
		super("WELCOME");
		setResizable(false);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 500);
		backgroundImage = ImageIO.read(new File("back.jpg"));		
		JPanel panel = new JPanel(null){
	        @Override public void paintComponent(Graphics g) {
	        	g.drawImage(backgroundImage, 0, 0, 1500,1000, null);
	        }
	    };
		panel.setSize(500, 500);
		
		JButton b1 = new JButton("login");
		b1.setBounds(215, 280, 80, 20);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcomepacket packet = new welcomepacket(email.getText(),
						password.getText(),"login");
				
				
				//BinaryClientManager.upload(packet);
			}
		});
		b1.setToolTipText("login");
		
		JButton b2 = new JButton("Register");
		b2.setBounds(340, 280, 100, 20);
		b2.setToolTipText("Register");
		JButton b3 = new JButton("Enter As Guest");
		b3.setBounds(250, 320, 150, 20);
		b3.setToolTipText("Guest");
		
		email = new JTextField();
		email.addFocusListener(new FocusListener() {
			
			public void focusLost(FocusEvent e) {
				if(email.getText().length() == 0) email.setText("email");
				
			}
			
			public void focusGained(FocusEvent e) {
				if(true) email.setText("");
				
			}
		});
		
		email.setToolTipText("email");
		email.setText("email");
		email.setBounds(200, 150, 250, 30);
		password = new JTextField();
		password.addFocusListener(new FocusListener() {
			
			public void focusLost(FocusEvent e) {
				if(password.getText().length() == 0) password.setText("password");
				
			}
			
			public void focusGained(FocusEvent e) {
				if(true) password.setText("");
				
			}
		});
		
		password.setToolTipText("password");
		password.setText("password");
		password.setBounds(200, 200, 250, 30);
		panel.add(email);
		panel.add(password);
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		setContentPane(panel);
		((JComponent) getContentPane()).setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5,Color.black));
		//pack();
		setVisible(true);
	}
	public static void main(String[] args) throws HeadlessException, IOException{
		new welcomepage();
	}

	

}
