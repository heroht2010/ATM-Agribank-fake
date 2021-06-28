package System;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


public class Server {
	private static ServerSocket skServer;
	private static Socket sk; 
	private static DataInputStream dis;
	private static DataOutputStream dos;
	private static String numberCard;
	private static String requestClient;
	private static String dataClient;
	private static String DB_URL="jdbc:mysql://localhost:3306/atm";
	private static String DB_USERNAME="root";
	private static String DB_PASSWORD="";
	public static Connection conn=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			skServer = new ServerSocket(5000);
			while(true) {
				sk = skServer.accept();
				conn = getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
				dos = new DataOutputStream(sk.getOutputStream());
				dis = new DataInputStream(sk.getInputStream());
				dataClient = dis.readUTF();
				requestClient = dataClient.substring(0, dataClient.lastIndexOf("-"));
				System.out.println(requestClient);
				switch (requestClient) {
					case "verifycard":  verifyCard(); break;
					case "verifyPIN": verifyPIN(); break;
					case "verifyPINOld": verifyPIN(); break;
					case "updatePIN": updatePIN(); break;
					case "viewInfoCard": viewInfoCard(); break;
					case "getMoney5Milion": getMoney(5000000); break;
					case "getMoneyOther": {
						int money = Integer.parseInt(dataClient.substring(dataClient.indexOf("-")+1, dataClient.length()));
						getMoney(money);
						break;
					}
					case "getInfoCardReceive": getInfoCardReceive(); break;
					case "transferMoney": transferMoney(); break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void verifyCard() {
		numberCard = dataClient.substring(dataClient.indexOf("-")+1, dataClient.length());
		try {
			String sql = "SELECT * FROM card WHERE number_card='"+numberCard+"'";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				dos.writeUTF("verifiedcard");
			}
			else {
				dos.writeUTF("verifiedcard-fail");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(numberCard);
	}
	
	private static void verifyPIN() {
		String PIN = dataClient.substring(dataClient.indexOf("-")+1, dataClient.length());
		try {
			String sql = "SELECT * FROM card WHERE pin='"+PIN+"' AND number_card='"+numberCard+"'";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				dos.writeUTF("verifiedPIN");
			}
			else {
				dos.writeUTF("verifiedPIN-fail");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(PIN);
	}
	
	private static void updatePIN() {
		String PIN = dataClient.substring(dataClient.indexOf("-")+1, dataClient.length());
		try {
			String sql = "UPDATE card SET pin='"+PIN+"' WHERE number_card='"+numberCard+"'";
			Statement stm = (Statement) conn.createStatement();
			if (stm.executeUpdate(sql) != -1) {
				dos.writeUTF("updatedPIN");
			}
			else {
				dos.writeUTF("updatedPIN-fail");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(PIN);
	}
	
	private static void viewInfoCard() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(sk.getOutputStream());
			String sql = "SELECT * FROM card WHERE number_card='"+numberCard+"'";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			rs.absolute(1);
			Card obj = new Card(rs.getString(2), rs.getString(4), rs.getString(5), rs.getInt(6));
			oos.writeObject(obj);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void getMoney(int money) {
		try {
			String sql = "SELECT * FROM card WHERE number_card='"+numberCard+"'";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			rs.absolute(1);
			if (rs.getInt(6) > money) {
				String sqlUpdate = "UPDATE card SET balance=balance-"+money+" WHERE number_card='"+numberCard+"'";
				Statement stmUpdate = (Statement) conn.createStatement();
				if (stmUpdate.executeUpdate(sqlUpdate) != -1) {
					dos.writeUTF("getMoney-success");
				}
				else {
					dos.writeUTF("getMoney-fail");
				}
			}
			else {
				dos.writeUTF("balance-fail");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void getInfoCardReceive() {
		String numberCardTransfer = dataClient.substring(dataClient.indexOf("-")+1, dataClient.lastIndexOf("."));
		String bankNameTransfer = dataClient.substring(dataClient.indexOf(".")+1, dataClient.length());
		System.out.println(numberCardTransfer+""+bankNameTransfer);
		try {
			String sql = "SELECT * FROM card WHERE number_card='"+numberCardTransfer+"' AND bank_name='"+bankNameTransfer+"'";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if (rs.next()) {
				dos.writeUTF("Numbercard exist-"+rs.getString(4));
			}
			else {
				dos.writeUTF("Numbercard not exist-");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void transferMoney() {
		try {
			String numberCardReceive = dataClient.substring(dataClient.indexOf("-")+1, dataClient.lastIndexOf("."));
			String nameReceive = dataClient.substring(dataClient.indexOf(".")+1, dataClient.lastIndexOf(","));
			String bankReceive = dataClient.substring(dataClient.indexOf(",")+1, dataClient.lastIndexOf("+"));
			int money = Integer.parseInt(dataClient.substring(dataClient.indexOf("+")+1, dataClient.length()));
			System.out.println(numberCardReceive+" "+nameReceive+" "+bankReceive+" "+money+"");
			String sql = "SELECT * FROM card WHERE number_card='"+numberCard+"'";
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			rs.absolute(1);
			if (rs.getInt(6) > money) {
				String sqlUpdateSend = "UPDATE card SET balance=balance-"+money+" WHERE number_card='"+numberCard+"'";
				String sqlUpdateReceive = "UPDATE card SET balance=balance+"+money+" WHERE number_card='"+numberCardReceive+"'"
										+ " AND bank_name='"+bankReceive+"' AND name='"+nameReceive+"'";
				Statement stmUpdate = (Statement) conn.createStatement();
				if (stmUpdate.executeUpdate(sqlUpdateReceive) != -1 && stmUpdate.executeUpdate(sqlUpdateSend) != -1) {
					dos.writeUTF("transferMoney-success");
				}
				else {
					dos.writeUTF("transferMoney-fail");
				}
			}
			else {
				dos.writeUTF("balance-fail");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(String DB_URL, String DB_USERNAME, String DB_PSW) {
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = (Connection) DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PSW);
			System.out.println("Connection Successfully");
		}catch(Exception e) {
			System.out.println("Connection Failure");
			e.printStackTrace();
		}
		return conn;
	}

}
