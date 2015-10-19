//VideoStream

import java.io.*;

public class VideoStream {

  FileInputStream fis; //video file
  int frame_nb; //current frame nb

  //-----------------------------------
  //constructor
  //-----------------------------------
  public VideoStream(String filename) throws Exception{

    //init variables
    fis = new FileInputStream(filename);
    frame_nb = 0;
    System.out.println("FILE POINTED SUCCESSFULLY");
  }

  //-----------------------------------
  // getnextframe
  //returns the next frame as an array of byte and the size of the frame
  //-----------------------------------
  public int getnextframe(byte[] frame) throws Exception
  {
    int length = 0;
    String length_string;
    byte[] frame_length = new byte[5];

    //read current frame length
    fis.read(frame_length,0,5);
    System.out.println(frame_length);
	System.out.println("Video file reading succssfully");
    //transform frame_length to integer
    length_string = new String(frame_length);
    //length_string = Byte.toString(frame_length);
    //length_string = "9";
    
    String string = "\"";
    byte[] ara = string.getBytes();
    System.out.println(ara);
    System.out.println(new String(ara));
    
    
System.out.println("OK1 " + length_string);
    length = Integer.parseInt(length_string);
System.out.println("NOT OK");
    return(fis.read(frame,0,length));
  }
}

