package grid1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainGrid {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame();

		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 94, 198, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JPanel SearchPanel = new JPanel();
		SearchPanel.setBackground(new Color(0, 51, 153));
		GridBagConstraints gbc_SearchPanel = new GridBagConstraints();
		gbc_SearchPanel.insets = new Insets(0, 0, 5, 0);
		gbc_SearchPanel.fill = GridBagConstraints.BOTH;
		gbc_SearchPanel.gridx = 0;
		gbc_SearchPanel.gridy = 0;
		frame.getContentPane().add(SearchPanel, gbc_SearchPanel);
		GridBagLayout gbl_SearchPanel = new GridBagLayout();
		gbl_SearchPanel.columnWidths = new int[]{367, 0, 0};
		gbl_SearchPanel.rowHeights = new int[]{42, 0};
		gbl_SearchPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_SearchPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		SearchPanel.setLayout(gbl_SearchPanel);
		
		JPanel panelLogo = new JPanel();
		GridBagConstraints gbc_panelLogo = new GridBagConstraints();
		gbc_panelLogo.insets = new Insets(0, 0, 0, 5);
		gbc_panelLogo.fill = GridBagConstraints.BOTH;
		gbc_panelLogo.gridx = 0;
		gbc_panelLogo.gridy = 0;
		SearchPanel.add(panelLogo, gbc_panelLogo);
		
		JPanel Search = new JPanel();
		GridBagConstraints gbc_Search = new GridBagConstraints();
		gbc_Search.fill = GridBagConstraints.BOTH;
		gbc_Search.gridx = 1;
		gbc_Search.gridy = 0;
		SearchPanel.add(Search, gbc_Search);
		GridBagLayout gridBagLayout_1 = new GridBagLayout();
		gridBagLayout_1.columnWidths = new int[]{0};
		gridBagLayout_1.rowHeights = new int[]{0};
		gridBagLayout_1.columnWeights = new double[]{Double.MIN_VALUE};
		gridBagLayout_1.rowWeights = new double[]{Double.MIN_VALUE};
		Search.setLayout(gridBagLayout_1);
		
		JPanel mainpanel = new JPanel();

		JScrollPane scrollPane = new JScrollPane(mainpanel);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);

		

		

		

		mainpanel.setLayout(new FlowLayout());
		mainpanel.setBackground(Color.GRAY);
		
		int i;
		for ( i = 0; i < 100; i++) {
			JPanel panel = new JPanel(); // Make a new panel
			panel.setPreferredSize(new Dimension(250, 300));

			panel.setBackground(Color.magenta);

			mainpanel.add(panel); // ...then add the panel to the layout

		}

		mainpanel.setPreferredSize(new Dimension(900,400*(i/3) ));
		frame.setBounds(100, 100, 900, 800);
		frame.setVisible(true);

	}
}
