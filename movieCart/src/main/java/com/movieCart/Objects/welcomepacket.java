package com.movieCart.Objects;

import java.awt.TexturePaint;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.print.attribute.standard.RequestingUserName;

import com.sun.jna.platform.WindowUtils.NativeWindowUtils;

public class welcomepacket implements Serializable {
	String email;
	String password;
	String command;
	
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public welcomepacket(String e,String p,String c)
	{
		setEmail(e);
		setPassword(p);
		setCommand(c);
		
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public void write()
	{
		BufferedWriter bf;
		try{
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("/home/jony/MovieCart/movieCart/PsudoServer/userData.txt", true)));
			out.println(email);
			out.println(password);
			out.flush();
			out.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

		
	   public boolean readAndCheck()
	   {
			BufferedReader br;
			try{
				br = new BufferedReader(new InputStreamReader(new FileInputStream("/home/jony/MovieCart/movieCart/PsudoServer/userData.txt")));
				//bf.write(email);
				//bf.write(password);
				//bf.flush();
				String email,password;

				while ((email = br.readLine()) != null) {
					password=br.readLine();
					if(command.equals("register") && email.equals(this.email)) return false;
					if(command.equals("login") && email.equals(this.email) &&  password.equals(this.password)) return true;
					
				}
				br.close();
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			if(command.equals("login")) return false;
			else{
				write();
				return true;
			}
	   }
}
