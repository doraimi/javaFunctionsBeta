package aUserDatagramProtocol;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class serverUDP {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		DatagramSocket serverSocket=new DatagramSocket(8060);
		byte[] receiveData=new byte[1024];
		byte[] sendData=new byte[1024];
		while(true) {
			DatagramPacket receivePacket=new DatagramPacket(receiveData,receiveData.length);
			serverSocket.receive(receivePacket);
			String clientMessage=new String(receivePacket.getData(),0,receivePacket.getLength());
			System.out.println("[SERVER]receive from client : "+clientMessage);
			
			InetAddress clientAddress=receivePacket.getAddress();
			int clientPort=receivePacket.getPort();
			
			String serverMessage="this message is from server to client";
			sendData=serverMessage.getBytes();
			DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,clientAddress,clientPort);
			serverSocket.send(sendPacket);
			
		}

	}

}
