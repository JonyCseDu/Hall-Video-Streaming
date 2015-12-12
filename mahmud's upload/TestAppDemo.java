package package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class TestAppDemo {

	private JFrame frame;

	private final JPanel panel_2 = new JPanel();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestAppDemo window = new TestAppDemo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 */
	public TestAppDemo() throws FileNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 */
	private void initialize() throws FileNotFoundException {
		frame = new JFrame();
		frame.setBounds(100, 50, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.getContentPane().setBackground(Color.black);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(300, 300));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		

		JPanel panel = new JPanel();
		panel.setBackground(Color.red);
		
		 scrollPane.setViewportView(panel);
		 frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		

		// GridLayout gl_panel = new GridLayout(10,0);
		// gl_panel.setVgap(2);
		// gl_panel.setHgap(2);

		panel.setLayout(null);

		scrollPane.setViewportView(panel);
		panel.setComponentOrientation(ComponentOrientation.UNKNOWN);

		// JPanel panel_1 = new JPanel();
		// FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		// panel_1.setPreferredSize(new Dimension(400, 400));
		// panel_1.setForeground(new Color(51, 51, 51));
		// panel_1.setBackground(Color.RED);
		// frame.getContentPane().add(panel_1, BorderLayout.WEST);
		File file = new File("/home/mahmud/workspace/gridProject/src/package1/videoName");
		Scanner sc = new Scanner(file);
		sc.useDelimiter("\\Z");

		String videoname;
		// System.out.println(videoname);
		// while()
		int i = 1;
		int buttonWideth = 310;
		int buttonHight = 210;
		int countButton = 0;
		int numCol = 3;
		int x = 5;
		int y = 5;

		while (sc.hasNextLine()) {

			countButton++;

			videoname = sc.nextLine();

			System.out.println("vavavavava--------->" + videoname);

			try {
				System.out.print(i + "  (" + x + "  " + y + ")\n");

				// panel.add(new videobuttonClass(x,y,"Button" + i,videoname));

				String panelvar = "panel";

				JPanel jp = new VideoPanelClass(x, y, videoname);
				System.out.print(i + "  (" + x + "  " + y + ")\n");
				panel.add(jp);
				if (countButton % 4 == 0) {
					x = 5;
					y += buttonHight;
				} else {
					x += buttonWideth;
				}

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("button exc = " + e);
			}

			// System.out.println("............->"+videoname);

			i++;
		}
		System.out.println("--------->----------------------------\n");

		sc.close();
	}

}