package com.movieCart.client;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Label;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.movieCart.Objects.UploadPacket;
import com.movieCart.Objects.welcomepacket;
import com.movieCart.client.clientManager.LoginSignUpManager;
import com.movieCart.client.grid.GridFrameClass;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.UIManager;

public class welcomepage extends JFrame  {
	
	private Image backgroundImage;
	private JTextField email;
	private JTextField password;
	JLabel label;
	public welcomepage()  {
		
		super("WELCOME");
		setResizable(false);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(650, 500);
		try {
			backgroundImage = ImageIO.read(new File("bg11.JPG"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		JPanel panel = new JPanel(null){
	        @Override public void paintComponent(Graphics g) {
	        	g.drawImage(backgroundImage, 0, 0, 670,500, null);
	        }
	    };
		panel.setSize(500, 500);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{50, 230, 91, 27, 58, 0, 0};
		gbl_panel.rowHeights = new int[]{196, 30, 30, 38, 20, 10, 9, 50, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		password = new JPasswordField();
		password.setBackground(UIManager.getColor("DesktopIcon.background"));
		password.addFocusListener(new FocusListener() {
			
			public void focusLost(FocusEvent e) {
				if(password.getText().length() == 0) password.setText("password");
				
			}
			
			public void focusGained(FocusEvent e) {
				if(true) password.setText("");
				
			}
		});
		email = new JTextField();
		email.setBackground(UIManager.getColor("DesktopIcon.background"));
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
		GridBagConstraints gbc_email = new GridBagConstraints();
		gbc_email.fill = GridBagConstraints.BOTH;
		gbc_email.insets = new Insets(0, 0, 5, 5);
		gbc_email.gridwidth = 3;
		gbc_email.gridx = 2;
		gbc_email.gridy = 1;
		panel.add(email, gbc_email);
		
		password.setToolTipText("password");
		password.setText("password");
		password.setBounds(200, 200, 250, 30);
		GridBagConstraints gbc_password = new GridBagConstraints();
		gbc_password.fill = GridBagConstraints.BOTH;
		gbc_password.insets = new Insets(0, 0, 5, 5);
		gbc_password.gridwidth = 3;
		gbc_password.gridx = 2;
		gbc_password.gridy = 2;
		panel.add(password, gbc_password);
		JButton b3 = new JButton("Enter As Guest");
		b3.setBackground(new Color(51, 204, 102));
		b3.setFont(new Font("Dialog", Font.BOLD, 18));
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GridFrameClass();
				setVisible(false);
			}
		});
		
		JButton b2 = new JButton("Register");
		b2.setBackground(new Color(102, 153, 255));
		b2.setBounds(340, 280, 100, 20);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcomepacket packet = new welcomepacket(email.getText(),
						password.getText(),"register");
				if(!logic(packet))
				{
					label.setText("Unsuccessful. Try again");
				}
				else
				{
					if(!LoginSignUpManager.serverCheck(packet)){
						label.setText("Unsuccessful. Try again");
					}
					else{
						new mymoviecart();
						setVisible(false);
					}
					System.out.println(packet.getEmail()+" "+packet.getPassword());
				}
					
				//BinaryClientManager.upload(packet);
			}
		});
		JButton b1 = new JButton("login");
		b1.setBackground(new Color(102, 153, 255));
		b1.setBounds(215, 280, 80, 20);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				welcomepacket packet = new welcomepacket(email.getText(),
						password.getText(),"login");
				if(!logic(packet))
				{
					label.setText("Unsuccessful. Try again");
				}
				else
				{
					if(!LoginSignUpManager.serverCheck(packet)){
						label.setText("Unsuccessful. Try again");
					}
					else{
						new mymoviecart();
						setVisible(false);
					}
					System.out.println(packet.getEmail()+" "+packet.getPassword());
				}
				
					
				//BinaryClientManager.upload(packet);
			}
		});
		b1.setToolTipText("login");
		GridBagConstraints gbc_b1 = new GridBagConstraints();
		gbc_b1.fill = GridBagConstraints.BOTH;
		gbc_b1.insets = new Insets(0, 0, 5, 5);
		gbc_b1.gridx = 2;
		gbc_b1.gridy = 3;
		panel.add(b1, gbc_b1);
		b2.setToolTipText("Register");
		GridBagConstraints gbc_b2 = new GridBagConstraints();
		gbc_b2.anchor = GridBagConstraints.WEST;
		gbc_b2.fill = GridBagConstraints.VERTICAL;
		gbc_b2.insets = new Insets(0, 0, 5, 5);
		gbc_b2.gridx = 4;
		gbc_b2.gridy = 3;
		panel.add(b2, gbc_b2);
		b3.setBounds(250, 320, 150, 20);
		b3.setToolTipText("Guest");
		GridBagConstraints gbc_b3 = new GridBagConstraints();
		gbc_b3.gridheight = 2;
		gbc_b3.fill = GridBagConstraints.BOTH;
		gbc_b3.insets = new Insets(0, 0, 5, 5);
		gbc_b3.gridwidth = 3;
		gbc_b3.gridx = 2;
		gbc_b3.gridy = 5;
		panel.add(b3, gbc_b3);
		label = new JLabel("");
		label.setBounds(50, 450, 550, 50);
		label.setForeground(Color.white);
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.gridwidth = 4;
		gbc_label.gridx = 1;
		gbc_label.gridy = 7;
		panel.add(label, gbc_label);
		setContentPane(panel);
		((JComponent) getContentPane()).setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5,Color.black));
		//pack();
		setVisible(true);
	}
	public Boolean logic(welcomepacket packet)
	{
		if(packet.getEmail().equals("email") || packet.getPassword().equals("password")) return false;
		else return true;
	}
	public static void main(String[] args) throws HeadlessException, IOException{
		new welcomepage();
	}

	

}
