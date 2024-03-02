package main.aUserDatagramProtocol;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class clientUDP {

	public static void main(String[] args) throws IOException {
		System.out.println("args.length : "+args.length);
		DatagramSocket clientUDPSocket=new DatagramSocket();
		InetAddress serverAddress=InetAddress.getByName("localhost");
		
		byte[] sendData=new byte[1024];
		byte[] receiveData=new byte[1024];
		
		String clientMessage="[client]this is Message from client";
		if(args.length>0) {
			clientMessage=clientMessage+" /// "+args[0];
		};
		sendData=clientMessage.getBytes();
		DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,serverAddress,8060);
		clientUDPSocket.send(sendPacket);
		
		DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
		clientUDPSocket.receive(receivePacket);
		String serverMessage=new String(receivePacket.getData(),0,receivePacket.getLength());
		System.out.println("[client]this is from server msg:"+serverMessage);
		
		clientUDPSocket.close();
		
		

	}

}
