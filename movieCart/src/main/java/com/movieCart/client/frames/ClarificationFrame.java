package com.movieCart.client.frames;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClarificationFrame extends JFrame {
	public ClarificationFrame(String msg) {
		JLabel label = new JLabel();
		label.setText(msg);
		label.setBounds(0, 0, 50, 20);
		add(label);
		pack();
		setVisible(true);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dispose();
	}
	public static void main(String[] args){
		new ClarificationFrame("elkjsldfjlsjkglsjgSuccess");
	}
}

