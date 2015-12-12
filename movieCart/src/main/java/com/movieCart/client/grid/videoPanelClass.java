package com.movieCart.client.grid;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.channels.AcceptPendingException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.movieCart.Objects.BinaryObject;
import com.movieCart.Objects.GridObject;
import com.movieCart.Objects.InfoObject;
import com.movieCart.client.player.Video;

public class videoPanelClass extends JPanel {

//	String variable = "No Name";
//	Image myPicture;
	GridObject object;
	InfoObject infoObject;
	BinaryObject binaryObject;
	BufferedImage bufferedImage;
	String PosterName;
	String VideoName;
	int Dimention_X;
	int Dimention_Y;

	/*
	 * GridObject object = gridObjects.get(i); InfoObject infoObject =
	 * object.getInfoObject();
	 * 
	 * System.out.println(infoObject.getPosterName());
	 * System.out.println(infoObject.getVideoName());
	 * System.out.println(infoObject.getDimension_x());
	 * System.out.println(infoObject.getDimension_y());
	 * 
	 * 
	 * 
	 */

	public videoPanelClass(GridObject object) {
		// TODO Auto-generated constructor stub
		this.object = object;
		this.infoObject = this.object.getInfoObject();
		this.binaryObject = this.object.getPoster();

		try {

			byte[] ImageByte = this.binaryObject.getBytes();

			// this.myPicture=ImageIO.read(new File(""));
			bufferedImage = ImageIO.read(new ByteArrayInputStream(ImageByte));

		} catch (Exception e) {
			// TODO: handle exception
		}

		create_panel();
	}

//	public void paintComponent(Graphics g) {
//		super.paintComponent(g);
//		// paint the background image and scale it to fill the entire space
//		// g.drawImage(myPicture, 0, 0, getWidth(), getHeight(), this);
//		g.drawImage((Image) bufferedImage, 0, 0, getWidth(), getHeight(), this);
//	}

	void create_panel() {

		try {

			PosterName = infoObject.getPosterName();

			VideoName = infoObject.getVideoName();
			Dimention_X = infoObject.getDimension_x();
			Dimention_Y = infoObject.getDimension_y();

			System.out.println("Info : " + PosterName + "  " + VideoName + "   " + Dimention_X + "  " + Dimention_Y);

			//this.setLayout(new BorderLayout());
			// Image myPicture = ImageIO.read(new
			// File("/home/mahmud/Pictures/poster3.jpg"));

			/*
			 * 
			 * Image img = ImageIO.read(new File(*File name*));
			 * 
			 * protected void paintComponent(Graphics g) {
			 * super.paintComponent(g); // paint the background image and scale
			 * it to fill the entire space g.drawImage(img, 0, 0, getWidth(),
			 * getHeight(), this); }
			 * 
			 * 
			 * 
			 */
			//--------------------this.paintComponents(getGraphics());

			// JLabel lableVideo = new JLabel(new ImageIcon(myPicture));
			// this.add(lableVideo);
			//-----------------------------------------------------------------------------------------------------------------
			this.setLayout(null);
			
			
			this.setBounds(0, 0, 250, 400);
			
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0};
			gbl_panel.rowHeights = new int[]{300, 100, 0};
			gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			this.setLayout(gbl_panel);
			
			/*
			 * 
			 * 	 setContentPane(new JPanel(new BorderLayout()) {
		        @Override public void paintComponent(Graphics g) {
		            g.drawImage(backgroundImage, 0, 0, 1500,1000, null);
		        }
		    });
			 * */
			
			
			
			
			JPanel ImageView = new JPanel(null) {
		        public void paintComponent(Graphics g) {
		            g.drawImage((Image) bufferedImage, 0, 0, 250,300, null);
		        }
		    };
			ImageView.setBackground(UIManager.getColor("Button.foreground"));
			GridBagConstraints gbc_ImageView = new GridBagConstraints();
			gbc_ImageView.insets = new Insets(0, 0, 5, 0);
			gbc_ImageView.fill = GridBagConstraints.BOTH;
			gbc_ImageView.gridx = 0;
			gbc_ImageView.gridy = 0;
			this.add(ImageView, gbc_ImageView);
			
			JPanel Info = new JPanel();
			Info.setForeground(new Color(255, 0, 0));
			Info.setBackground(UIManager.getColor("Button.background"));
			GridBagConstraints gbc_Info = new GridBagConstraints();
			gbc_Info.fill = GridBagConstraints.BOTH;
			gbc_Info.gridx = 0;
			gbc_Info.gridy = 1;
			this.add(Info, gbc_Info);
			Info.setLayout(new GridLayout(4, 1, 0, 0));
			
			JLabel lblName = new JLabel(infoObject.getName());
			Info.add(lblName);
			
			JLabel lblTime = new JLabel("" + infoObject.getTime());
			Info.add(lblTime);
			
			JLabel lblResulation = new JLabel(infoObject.getDimension_x() + " * " + infoObject.getDimension_y());
			Info.add(lblResulation);
			
			JButton btnWatch = new JButton("WATCH");
			btnWatch.setBackground(new Color(0, 255, 0));
			btnWatch.setForeground(new Color(128, 0, 128));
			Info.add(btnWatch);
			
			
			
			
			////---------------------------------------------------------------------
			

			
			
			
			//-----------------------------------------------------------------------------------------------------------------
			this.setPreferredSize(new Dimension(250, 400));
			this.setBackground(Color.magenta);

			// JButton btnNewButton = new JButton("VIEW DETAILS");
			// btnNewButton.setBounds(100, 160, 100, 40);
			// this.add(btnNewButton);

		} catch (Exception e) {
			// TODO: handle exception
		}

		// JLabel lblNewLabel = new JLabel("VideoImage");
		/// lblNewLabel.setBounds(x, 12, 300, 150);
		// this.add(lblNewLabel);

//		this.setName(variable);
//		this.setToolTipText(variable);

		this.setBackground(Color.BLACK);

		this.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mousePressed(MouseEvent e) {
				System.out.println("opening Video : " + infoObject.getVideoName());
				new Video(infoObject.getVideoName());
				
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
