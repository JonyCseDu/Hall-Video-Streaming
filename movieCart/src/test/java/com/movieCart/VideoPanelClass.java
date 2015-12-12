package com.movieCart;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.channels.AcceptPendingException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class VideoPanelClass extends JPanel {

	String variable = "No Name";
	

	public VideoPanelClass(String variable) {
		// TODO Auto-generated constructor stub
		this.variable = variable;
		
		create_panel();
	}

	void create_panel() {
		

		

		try {
			BufferedImage myPicture = ImageIO.read(new File("/home/jony/MovieCart/movieCart/images.jpg"));

			JLabel lableVideo = new JLabel(new ImageIcon(myPicture));
			this.add(lableVideo);
			this.setPreferredSize(new Dimension(200, 300));
			this.setBackground(Color.magenta);
			
//			JButton btnNewButton = new JButton("VIEW DETAILS");
//			btnNewButton.setBounds(100, 160, 100, 40);
//			this.add(btnNewButton);

		} catch (Exception e) {
			// TODO: handle exception
		}

		// JLabel lblNewLabel = new JLabel("VideoImage");
		/// lblNewLabel.setBounds(x, 12, 300, 150);
		// this.add(lblNewLabel);

		this.setName(variable);
		this.setToolTipText(variable);
		
		
	   
	  
		this.setBackground(Color.darkGray);
		this.setBorder(new Border() {
			
			public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
				// TODO Auto-generated method stub
				
			}
			
			public boolean isBorderOpaque() {
				// TODO Auto-generated method stub
				return false;
			}
			
			public Insets getBorderInsets(Component c) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		this.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});

	}

}
