package grid1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
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
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

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

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		// paint the background image and scale it to fill the entire space
		// g.drawImage(myPicture, 0, 0, getWidth(), getHeight(), this);
		g.drawImage((Image) bufferedImage, 0, 0, getWidth(), getHeight(), this);
	}

	void create_panel() {

		try {

			PosterName = infoObject.getPosterName();

			VideoName = infoObject.getVideoName();
			Dimention_X = infoObject.getDimension_x();
			Dimention_Y = infoObject.getDimension_y();

			System.out.println("Info : " + PosterName + "  " + VideoName + "   " + Dimention_X + "  " + Dimention_Y);

			this.setLayout(new BorderLayout());
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
			this.paintComponents(getGraphics());

			// JLabel lableVideo = new JLabel(new ImageIcon(myPicture));
			// this.add(lableVideo);
			this.setPreferredSize(new Dimension(400, 500));
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

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println(VideoName + "---------->Video panel had been released\n");

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println("---------->Video panel had been pressed\n");

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

}
