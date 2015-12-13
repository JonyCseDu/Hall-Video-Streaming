package com.movieCart.client.grid;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import com.movieCart.Objects.GridObject;
import com.movieCart.Objects.RequestObject;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

public class GridFrameClass extends JFrame{
	
	private Image bg,backgroundImage,backgroundImage1;
	ArrayList<GridObject> list=new ArrayList<GridObject>();
	
	public GridFrameClass() {
		this("");
	}
	
	public GridFrameClass(String key) {
		super("Browse video");
		System.out.println("key : " + key);
		GridClientManager manager = new GridClientManager();
		list = manager.request(new RequestObject("search", key));
		create_gridFrame();
	}
	public static void main(String args[])
	{
		new GridFrameClass();
	}

	void create_gridFrame(){
		
		this.getContentPane().setBackground(new Color(204, 102, 0));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 120, 198, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		this.getContentPane().setLayout(gridBagLayout);

		
		JPanel SearchPanel = new JPanel();
		SearchPanel.setBackground(new Color(210, 105, 30));
		GridBagConstraints gbc_SearchPanel = new GridBagConstraints();
		gbc_SearchPanel.insets = new Insets(0, 0, 5, 0);
		gbc_SearchPanel.fill = GridBagConstraints.BOTH;
		gbc_SearchPanel.gridx = 0;
		gbc_SearchPanel.gridy = 0;
		this.getContentPane().add(SearchPanel, gbc_SearchPanel);
		GridBagLayout gbl_SearchPanel = new GridBagLayout();
		gbl_SearchPanel.columnWidths = new int[]{492, 0, 0};
		gbl_SearchPanel.rowHeights = new int[]{42, 0};
		gbl_SearchPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_SearchPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		SearchPanel.setLayout(gbl_SearchPanel);
		
		
		try {
			backgroundImage = ImageIO.read(new File("logo2.JPG"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		JPanel panelLogo = new JPanel(){
	        @Override public void paintComponent(Graphics g) {
	        	g.drawImage(backgroundImage, 0, 0, 490,117, null);
	        }
	    };
		//JPanel panelLogo = new JPanel();
		panelLogo.setBackground(new Color(51, 0, 51));
		GridBagConstraints gbc_panelLogo = new GridBagConstraints();
		gbc_panelLogo.insets = new Insets(0, 0, 0, 5);
		gbc_panelLogo.fill = GridBagConstraints.BOTH;
		gbc_panelLogo.gridx = 0;
		gbc_panelLogo.gridy = 0;
		SearchPanel.add(panelLogo, gbc_panelLogo);
		GridBagLayout gbl_panelLogo = new GridBagLayout();
		gbl_panelLogo.columnWidths = new int[]{0};
		gbl_panelLogo.rowHeights = new int[]{0};
		gbl_panelLogo.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panelLogo.rowWeights = new double[]{Double.MIN_VALUE};
		panelLogo.setLayout(gbl_panelLogo);
		
		try {
			backgroundImage1 = ImageIO.read(new File("backcolour.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		JPanel Search = new JPanel(){
	        @Override public void paintComponent(Graphics g) {
	        	g.drawImage(backgroundImage1, 0, 0, 1200,420, null);
	        }
	    };	
		//JPanel Search = new JPanel();
		Search.setBackground(new Color(51, 0, 51));
		GridBagConstraints gbc_Search = new GridBagConstraints();
		gbc_Search.fill = GridBagConstraints.BOTH;
		gbc_Search.gridx = 1;
		gbc_Search.gridy = 0;
		SearchPanel.add(Search, gbc_Search);
		GridBagLayout gbl_Search = new GridBagLayout();
		gbl_Search.columnWidths = new int[]{452, 134, 0};
		gbl_Search.rowHeights = new int[]{46, 40, 0};
		gbl_Search.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_Search.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		Search.setLayout(gbl_Search);
		
		final JTextField textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 20));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		Search.add(textField, gbc_textField);
		((JTextField) textField).setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 18));
		btnNewButton.setBackground(new Color(102, 153, 204));
		btnNewButton.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				new GridFrameClass(textField.getText());
				setVisible(false);
				
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 1;
		Search.add(btnNewButton, gbc_btnNewButton);
		
		try {
			bg = ImageIO.read(new File("gridbg.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		JPanel mainpanel = new JPanel(){
	        @Override public void paintComponent(Graphics g) {
	        	g.drawImage(bg, 0, 0, 3000,2800, null);
	        }
	    };
		mainpanel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		//JPanel mainpanel = new JPanel();

		JScrollPane scrollPane = new JScrollPane(mainpanel);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		this.getContentPane().add(scrollPane, gbc_scrollPane);

		

		

		

		FlowLayout fl_mainpanel = new FlowLayout();
		fl_mainpanel.setVgap(10);
		fl_mainpanel.setHgap(15);
		mainpanel.setLayout(fl_mainpanel);
		mainpanel.setBackground(new Color(210, 105, 30));
		
		
		/*
		 * 
		 * GridClientManager manager = new GridClientManager();
		ArrayList<GridObject> gridObjects = manager.request(new RequestObject("search", ""));
		System.out.println("size : " + gridObjects.size());
		for(int i=0; i<gridObjects.size(); i++){
			GridObject object = gridObjects.get(i);
			InfoObject infoObject = object.getInfoObject();
			
			System.out.println(infoObject.getPosterName());
			System.out.println(infoObject.getVideoName());
			System.out.println(infoObject.getDimension_x());
			System.out.println(infoObject.getDimension_y());	
		}
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
		int i;
		int listSize=list.size();
		for ( i = 0; i < listSize; i++) {
//			JPanel panel = new JPanel(); // Make a new panel
//			panel.setPreferredSize(new Dimension(400, 500));
//
//			panel.setBackground(Color.magenta);
			
			GridObject object=list.get(i);
			
			
			
			JPanel panel = new videoPanelClass(object); // Make a new panel

			mainpanel.add(panel); // ...then add the panel to the layout

		}

		mainpanel.setPreferredSize(new Dimension(900,400*(i/3) ));
		this.setBounds(100, 100, 1200, 800);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setVisible(true);
		
		
		
	}
}
