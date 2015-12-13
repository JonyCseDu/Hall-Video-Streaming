package com.movieCart.client.frames;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.border.MatteBorder;

public class MyMoviecartFrame extends JFrame {
	
	private Image backgroundImage;
	public MyMoviecartFrame(){
		
		super("MY MOVIECART");
		setResizable(false);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(650, 500);
		try {
			backgroundImage = ImageIO.read(new File("2bg.JPG"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		JPanel panel = new JPanel(null){
	        @Override public void paintComponent(Graphics g) {
	        	g.drawImage(backgroundImage, 0, 0, 921,512, null);
	        }
	    };
		panel.setSize(500, 500);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{198, 36, 240, 34, 0};
		gbl_panel.rowHeights = new int[]{152, 77, 21, 81, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		JButton b2 = new JButton("WATCH VIDEO");
		b2.setBackground(new Color(204, 204, 153));
		b2.setFont(new Font("Dialog", Font.BOLD, 28));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GridFrame();
				setVisible(false);
			}
		});
		JButton b1 = new JButton("UPLOAD");
		b1.setBackground(new Color(102, 204, 153));
		b1.setFont(new Font("Dialog", Font.BOLD, 28));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UploadFrame();
			}
		});
		
		//	b1.setBounds(300, 250, 100, 20);
			
			GridBagConstraints gbc_b1 = new GridBagConstraints();
			gbc_b1.gridwidth = 3;
			gbc_b1.fill = GridBagConstraints.BOTH;
			gbc_b1.insets = new Insets(0, 0, 5, 5);
			gbc_b1.gridx = 1;
			gbc_b1.gridy = 1;
			panel.add(b1, gbc_b1);
		b2.setBounds(300, 280, 100, 20);
		GridBagConstraints gbc_b2 = new GridBagConstraints();
		gbc_b2.gridwidth = 3;
		gbc_b2.insets = new Insets(0, 0, 0, 5);
		gbc_b2.fill = GridBagConstraints.BOTH;
		gbc_b2.gridx = 1;
		gbc_b2.gridy = 3;
		panel.add(b2, gbc_b2);
		setContentPane(panel);
		((JComponent) getContentPane()).setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0)));
		//pack();
		setVisible(true);
	}
	public static void main(String[] args) throws HeadlessException, IOException{
		new MyMoviecartFrame();
	}

}
