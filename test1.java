package package1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.RepaintManager;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;
import javax.swing.SpringLayout;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 JFrame frame = new JFrame();
		 
		 
		 
		 
		 
		 
		 frame.setBounds(100, 100, 1000, 800);
		 
		 
		 //frame.getContentPane().add(scrollPane);
		 
		 
		 JPanel mainpanel=new JPanel();
		 
		 
		 

		 mainpanel.setLayout(new FlowLayout());
		 mainpanel.setBackground(Color.GRAY);
		 
		
		 
         for( int i = 0; i < 30; i++ ) {
            JPanel panel = new JPanel();  // Make a new panel
            panel.setPreferredSize(new Dimension(250,300));
            
            panel.setBackground(Color.magenta);

            mainpanel.add( panel );   // ...then add the panel to the layout
            
         }
         
//         JScrollPane jScrollPane=new JScrollPane();
//         jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
//         jScrollPane.setViewportView(mainpanel);
         //frame.getContentPane().add(jScrollPane, BorderLayout.CENTER);
	
		 //jScrollPane.setVerticalScrollBar(jScrollBar);
//		 jScrollBar.addAdjustmentListener(new AdjustmentListener() {
//			
//			@Override
//			public void adjustmentValueChanged(AdjustmentEvent e) {
//				// TODO Auto-generated method stub
//				
//				jScrollBar.getValue();
//				
//				
//				
//			}
//		});
		 
		
		 
         
         frame.getContentPane().add(mainpanel);
         
         
         
         //frame.pack();
         //frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
         //frame.setLocationRelativeTo( null );
         frame.setVisible( true );

	}

}

