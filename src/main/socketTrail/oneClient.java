package socketTrail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class oneClient {



	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		Socket socket=new Socket("localhost",8082);
		OutputStream outputStream=socket.getOutputStream();
		PrintWriter writer=new PrintWriter(outputStream);
		
		InputStream inputStream=socket.getInputStream();
		BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
		
		writer.println("[I'm Client] say hello to server >>>");
		writer.flush();
		
		String message =reader.readLine();
		System.out.println("[I'm Client] this is from SERVER info : "+ message);
		
		Thread.sleep(5000);
		writer.close();
		reader.close();
		socket.close();

	}

}
