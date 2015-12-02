package package1;

import java.awt.Color;
import java.awt.GridLayout;
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

public class VideoPanelClass extends JPanel {

	String variable = "No Name";
	int x = 0;
	int y = 0;

	public VideoPanelClass(int x, int y, String variable) {
		// TODO Auto-generated constructor stub
		this.variable = variable;
		this.x = x;
		this.y = y;
		create_panel();
	}

	void create_panel() {
		System.out.print(variable + "---->=   (" + x + "  " + y + ")\n");
		this.setBounds(x, y, 300, 200);

		this.setLayout(null);

		try {
			BufferedImage myPicture = ImageIO.read(new File("/home/mahmud/workspace/gridProject/src/lable.jpg"));

			JLabel lableVideo = new JLabel(new ImageIcon(myPicture));
			lableVideo.setBounds(0, 0, 300, 200);
			this.add(lableVideo);

			JButton btnNewButton = new JButton("VIEW DETAILS");
			btnNewButton.setBounds(100, 160, 100, 40);
			this.add(btnNewButton);

		} catch (Exception e) {
			// TODO: handle exception
		}

		// JLabel lblNewLabel = new JLabel("VideoImage");
		/// lblNewLabel.setBounds(x, 12, 300, 150);
		// this.add(lblNewLabel);

		this.setName(variable);
		this.setToolTipText(variable);

		this.setBackground(Color.WHITE);
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				System.out.println(variable + "---------->Video panel had been released\n");

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
