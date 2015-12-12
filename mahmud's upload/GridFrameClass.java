package grid1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class GridFrameClass extends JFrame{
	
	
	ArrayList<GridObject> list=new ArrayList<GridObject>();
	
public GridFrameClass(ArrayList<GridObject> list) {
	// TODO Auto-generated constructor stubl
	this.list=list;
	
	
	
	
	create_gridFrame();
	
}

	void create_gridFrame(){
		
		this.getContentPane().setBackground(Color.LIGHT_GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 94, 198, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		this.getContentPane().setLayout(gridBagLayout);

		JPanel SearchPanel = new JPanel();
		SearchPanel.setBackground(new Color(0, 51, 153));
		GridBagConstraints gbc_SearchPanel = new GridBagConstraints();
		gbc_SearchPanel.insets = new Insets(0, 0, 5, 0);
		gbc_SearchPanel.fill = GridBagConstraints.BOTH;
		gbc_SearchPanel.gridx = 0;
		gbc_SearchPanel.gridy = 0;
		this.getContentPane().add(SearchPanel, gbc_SearchPanel);
		GridBagLayout gbl_SearchPanel = new GridBagLayout();
		gbl_SearchPanel.columnWidths = new int[]{722, 0, 0};
		gbl_SearchPanel.rowHeights = new int[]{42, 0};
		gbl_SearchPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_SearchPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		SearchPanel.setLayout(gbl_SearchPanel);
		
		JPanel panelLogo = new JPanel();
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
		
		JPanel Search = new JPanel();
		Search.setBackground(new Color(51, 0, 51));
		GridBagConstraints gbc_Search = new GridBagConstraints();
		gbc_Search.fill = GridBagConstraints.BOTH;
		gbc_Search.gridx = 1;
		gbc_Search.gridy = 0;
		SearchPanel.add(Search, gbc_Search);
		GridBagLayout gbl_Search = new GridBagLayout();
		gbl_Search.columnWidths = new int[]{0, 0, 0, 236, 195, 0};
		gbl_Search.rowHeights = new int[]{0, 58, 0};
		gbl_Search.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_Search.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		Search.setLayout(gbl_Search);
		
		JTextField textField;
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 3;
		gbc_textField.gridy = 1;
		Search.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 1;
		Search.add(btnNewButton, gbc_btnNewButton);
		
		JPanel mainpanel = new JPanel();

		JScrollPane scrollPane = new JScrollPane(mainpanel);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		this.getContentPane().add(scrollPane, gbc_scrollPane);

		

		

		

		mainpanel.setLayout(new FlowLayout());
		mainpanel.setBackground(Color.GRAY);
		
		
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

		mainpanel.setPreferredSize(new Dimension(900,500*(i/3) ));
		this.setBounds(100, 100, 900, 800);
		this.setVisible(true);
		
		
		
	}
}
