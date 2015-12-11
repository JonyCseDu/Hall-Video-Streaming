package package1;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class videobuttonClass extends JButton{
	String varName="buttonVariable";
	String buttonText="voidButton";
	int x=0,y=0;
	
	
	public videobuttonClass() {
		// TODO Auto-generated constructor stub
		super();
		this.createButton();
		
	}
	public videobuttonClass(int x,int y,String name,String title) {
		// TODO Auto-generated constructor stub
		super();
		this.varName=name;
		this.buttonText=title;
		this.x=x;
		this.y=y;
		this.createButton();
		
	}
	
	
	
	
	
	void createButton(){
		
		//this.setPreferredSize(new Dimension(100,100));
		this.setBounds(x, y, 300, 200);
		this.setName(varName);
		this.setText(buttonText);
		
		//this.setSize(width, height);
		
		this.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame frame=new JFrame("video");
				frame.setBounds(100, 100, 400, 400);
				frame.setVisible(true);
				JButton play_button=new JButton("Play");
		
				play_button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						System.out.println("Play button is pressed\n");
						
						
						
					}
					
				});
				frame.add(play_button);
			
				System.out.println(varName+" button is pressed --> show "+buttonText);
				
			}
		});
		
		
		
	}
	
	

}