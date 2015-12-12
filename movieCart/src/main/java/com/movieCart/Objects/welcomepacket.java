package com.movieCart.Objects;

import java.awt.TexturePaint;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import javax.print.attribute.standard.RequestingUserName;

import com.sun.jna.platform.WindowUtils.NativeWindowUtils;

public class welcomepacket {
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
		File file=new File("./PsedoServer/userData");
		BufferedWriter bf;
		try{
			bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
			bf.write(email);
			bf.write(password);
			bf.flush();
			bf.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

		
	   public boolean readAndCheck()
	   {

			File file=new File("./PsedoServer/userData");
			BufferedReader br;
			try{
				br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
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
			else return true;
	   }
}
