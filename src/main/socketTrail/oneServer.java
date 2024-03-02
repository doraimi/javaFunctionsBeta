package main.socketTrail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
import java.net.Socket;

public class oneServer {



	public static void main(String[] args) throws IOException, InterruptedException {
		ServerSocket oneServerSocket=new ServerSocket(8082);
		System.out.println("wait client connect ...>>>");
		Socket oneSocket=oneServerSocket.accept();
		
		InputStream inputStream=oneSocket.getInputStream();
		BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
		
		OutputStream outputStream=oneSocket.getOutputStream();
		PrintWriter writer=new PrintWriter(outputStream);
		
		String message = reader.readLine();
		System.out.println("from client info: "+ message );
		
		writer.println("this is send to Client >>>");
		writer.flush();
		
		Thread.sleep(5000);
		writer.close();
		reader.close();
		oneSocket.close();
		oneServerSocket.close();
		

	}

}
