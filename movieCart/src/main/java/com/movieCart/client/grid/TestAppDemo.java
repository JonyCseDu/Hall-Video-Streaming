package com.movieCart.client.grid;

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
	/**
	 * @wbp.nonvisual location=112,7
	 */
	private final JPanel panel_2 = new JPanel();

	/**
	 * Launch the application.
	 */
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
	 * @throws FileNotFoundException 
	 */
	public TestAppDemo() throws FileNotFoundException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws FileNotFoundException 
	 */
	private void initialize() throws FileNotFoundException {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(300, 300));
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		GridLayout gl_panel = new GridLayout(1200,3);
		gl_panel.setVgap(2);
		gl_panel.setHgap(2);
		panel.setLayout(gl_panel);
		
		scrollPane.setViewportView(panel);
		panel.setComponentOrientation(ComponentOrientation.UNKNOWN);
		
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		panel_1.setPreferredSize(new Dimension(400, 400));
		panel_1.setForeground(new Color(51, 51, 51));
		panel_1.setBackground(Color.RED);
		//frame.getContentPane().add(panel_1, BorderLayout.WEST);
		File file=new File("videoName");
		Scanner sc=new  Scanner(file);
		sc.useDelimiter("\\Z");
		
		
		String videoname;
		//System.out.println(videoname);
		//while()
		int i=1;
		
		while(sc.hasNextLine()){
			
			videoname=sc.nextLine();
			
			System.out.println("--------->"+videoname);
			try {
				panel.add(new videobuttonClass("Button" + i,videoname));
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("button exc = "+e);
			}
				
				//System.out.println("............->"+videoname);
			
			i++;
		}
		System.out.println("--------->----------------------------\n");
		
		sc.close();
	}

}