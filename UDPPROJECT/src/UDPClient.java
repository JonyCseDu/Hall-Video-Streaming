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
class Send1 extends Thread
{   private DatagramSocket clientSocket;
    Send1(DatagramSocket socket)
     {
          clientSocket=socket;
     }

    public void run() {
        try {
        while(true) {
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData = new byte[1024];
        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9877);
        clientSocket.send(sendPacket);
        }
        }
        catch(Exception e)
        {
            System.out.println("Exception "+e.toString());
        }
    }

}
class Receive1 extends Thread
{    private DatagramSocket clientSocket;
    Receive1(DatagramSocket socket)
     {
          clientSocket=socket;
     }
    public void run() {
        try {
        while(true){
        byte[] receiveData = new byte[1024];

        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);
        String modifiedSentence = new String(receivePacket.getData());
        System.out.println("FROM SERVER:" + modifiedSentence);}
        }
        catch(Exception e)
        {
            System.out.println("Exception "+e.toString());
        }
    }
}

class UDPClient {

    public static void main(String args[]) throws Exception {
        //BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket clientSocket = new DatagramSocket(12000);
        //InetAddress IPAddress = InetAddress.getByName("localhost");
        //byte[] sendData = new byte[1024];
        //byte[] receiveData = new byte[1024];
        //String sentence = inFromUser.readLine();
        //sendData = sentence.getBytes();
        //DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        //clientSocket.send(sendPacket);
        //DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        //clientSocket.receive(receivePacket);
        //String modifiedSentence = new String(receivePacket.getData());
        //System.out.println("FROM SERVER:" + modifiedSentence);
         new Send1(clientSocket).start();
        new Receive1(clientSocket).start();
        //clientSocket.close();
    }
}
