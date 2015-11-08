/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package udp;

/**
 *
 * @author Student
 */

import java.io.*;
import java.net.*;

class Send extends Thread
{   private DatagramSocket ServerSocket;
    Send(DatagramSocket socket)
     {
          ServerSocket=socket;
     }

    public void run() {
        try {
        while(true)
        {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData = new byte[1024];
        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 12000);
        ServerSocket.send(sendPacket);}
        }
        catch(Exception e)
        {
            System.out.println("Exception "+e.toString());
        }
    }

}
class Receive extends Thread
{   private DatagramSocket ServerSocket;
    Receive(DatagramSocket socket)
     {
          ServerSocket=socket;
     }
    public void run() {
        try {
        while(true){
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        ServerSocket.receive(receivePacket);
        String modifiedSentence = new String(receivePacket.getData());
        System.out.println("FROM CLIENT:" + modifiedSentence);
        }
        }
        catch(Exception e)
        {
            System.out.println("Exception "+e.toString());
        }
    }
}

class UDPServer {
    public static void main(String args[]) throws Exception
    {          DatagramSocket serverSocket = new DatagramSocket(9877);
               //byte[] receiveData = new byte[1024];
               //byte[] sendData = new byte[1024];
               //while(true)                {
                 //   DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                   // serverSocket.receive(receivePacket);
                    //String sentence = new String( receivePacket.getData());
                    //System.out.println("RECEIVED: " + sentence);
                    //InetAddress IPAddress = receivePacket.getAddress();
                    //int port = receivePacket.getPort();
                    //String capitalizedSentence = sentence.toUpperCase();
                    //sendData = capitalizedSentence.getBytes();
                    //DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
                    //serverSocket.send(sendPacket);
                    new Send(serverSocket).start();
                    new Receive(serverSocket).start();
               
    }
}