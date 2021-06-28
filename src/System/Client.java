package System;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	private static Socket skClient;
	private static DataInputStream dis;
	private static DataOutputStream dos;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			skClient=new Socket("localhost", 5000);
			while(true) {
				dis = new DataInputStream(skClient.getInputStream());
				System.out.println(dis.readUTF());
				dos = new DataOutputStream(skClient.getOutputStream());
				dos.writeUTF("Xin chao");
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
