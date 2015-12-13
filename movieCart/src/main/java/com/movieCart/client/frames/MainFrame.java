package com.movieCart.client.frames;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFrame;

import com.movieCart.client.managers.ClientManager;
public class MainFrame{	
	public static void main(String[] args){
		System.out.println("Server IP : ");
		Scanner scanner = new Scanner(System.in);
		//ClientManager.setServerIp(scanner.nextLine());
		new SignupLoginFrame();
	}
}
