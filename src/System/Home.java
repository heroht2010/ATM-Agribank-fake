package System;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.border.LineBorder;

import transferMoney.chooseBank;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Home extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	JTextField txtEnterPIN;
	private JTextField txtEnterCard;
	public static Socket skClient;
	private static DataInputStream dis;
	private static DataOutputStream dos;
	public static String numberCard;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		try {
			skClient=new Socket("localhost", 5000);
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(10, 5, 198, 131);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(10, 147, 198, 131);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setBounds(10, 289, 198, 131);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(843, 5, 211, 131);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_1_1 = new JButton("New button");
		btnNewButton_1_1.setBounds(843, 147, 211, 131);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_2_1 = new JButton("New button");
		btnNewButton_2_1.setBounds(843, 289, 211, 131);
		contentPane.add(btnNewButton_2_1);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(218, 0, 615, 420);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 431, 709, 239);
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(4, 4, 0, 0));
		
		JButton btnNewButton_5 = new JButton("1");
		btnNewButton_5.setFont(new Font("Arial", Font.BOLD, 20));
		panel_1.add(btnNewButton_5);
		
		JButton btnNewButton_11 = new JButton("2");
		btnNewButton_11.setFont(new Font("Arial", Font.BOLD, 20));
		panel_1.add(btnNewButton_11);
		
		JButton btnNewButton_10 = new JButton("3");
		btnNewButton_10.setFont(new Font("Arial", Font.BOLD, 20));
		panel_1.add(btnNewButton_10);
		
		JButton btnNewButton_12 = new JButton("ENTER");
		btnNewButton_12.setBackground(new Color(50, 205, 50));
		btnNewButton_12.setFont(new Font("Arial", Font.BOLD, 15));
		panel_1.add(btnNewButton_12);
		
		JButton btnNewButton_9 = new JButton("4");
		btnNewButton_9.setFont(new Font("Arial", Font.BOLD, 20));
		panel_1.add(btnNewButton_9);
		
		JButton btnNewButton_16 = new JButton("5");
		btnNewButton_16.setFont(new Font("Arial", Font.BOLD, 20));
		panel_1.add(btnNewButton_16);
		
		JButton btnNewButton_17 = new JButton("6");
		btnNewButton_17.setFont(new Font("Arial", Font.BOLD, 20));
		panel_1.add(btnNewButton_17);
		
		JButton btnNewButton_15 = new JButton("CANCEL");
		btnNewButton_15.setBackground(new Color(255, 0, 0));
		btnNewButton_15.setFont(new Font("Arial", Font.BOLD, 15));
		panel_1.add(btnNewButton_15);
		
		JButton btnNewButton_14 = new JButton("7");
		btnNewButton_14.setFont(new Font("Arial", Font.BOLD, 20));
		panel_1.add(btnNewButton_14);
		
		JButton btnNewButton_13 = new JButton("8");
		btnNewButton_13.setFont(new Font("Arial", Font.BOLD, 20));
		panel_1.add(btnNewButton_13);
		
		JButton btnNewButton_8 = new JButton("9");
		btnNewButton_8.setFont(new Font("Arial", Font.BOLD, 20));
		panel_1.add(btnNewButton_8);
		
		JButton btnNewButton_18 = new JButton("CLEAR");
		btnNewButton_18.setBackground(new Color(255, 255, 0));
		btnNewButton_18.setFont(new Font("Arial", Font.BOLD, 15));
		panel_1.add(btnNewButton_18);
		
		JButton btnNewButton_6 = new JButton(".");
		btnNewButton_6.setFont(new Font("Arial", Font.BOLD, 20));
		panel_1.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("0");
		btnNewButton_7.setFont(new Font("Arial", Font.BOLD, 20));
		panel_1.add(btnNewButton_7);
		
		JButton btnNewButton_4 = new JButton("00");
		btnNewButton_4.setFont(new Font("Arial", Font.BOLD, 20));
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_19 = new JButton("RETURN");
		btnNewButton_19.setFont(new Font("Arial", Font.BOLD, 15));
		panel_1.add(btnNewButton_19);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(729, 431, 325, 239);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		txtEnterCard = new JTextField();
		txtEnterCard.setToolTipText("Enter Your Number Card");
		txtEnterCard.setFont(new Font("Arial", Font.BOLD, 18));
		txtEnterCard.setForeground(new Color(255, 215, 0));
		txtEnterCard.setBackground(new Color(0, 128, 128));
		txtEnterCard.setBounds(10, 8, 251, 35);
		panel_2.add(txtEnterCard);
		txtEnterCard.setColumns(10);
		
		JLabel lblImgSocket = new JLabel("New label");
		BufferedImage bufImgSocket=null;
		try {
			bufImgSocket=ImageIO.read(new File("C:\\Users\\84837\\eclipse-workspace\\ATM\\image\\socketATM.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lblImgSocket.setBounds(0, 51, 325, 188);
		Image dimgSocket=bufImgSocket.getScaledInstance(lblImgSocket.getWidth(), lblImgSocket.getHeight(), Image.SCALE_SMOOTH);
		lblImgSocket.setIcon(new ImageIcon(dimgSocket));
		panel_2.add(lblImgSocket);
		
		JButton btnEnterCard = new JButton("New button");
		btnEnterCard.setBounds(271, 8, 44, 34);
		panel_2.add(btnEnterCard);
		btnEnterCard.addActionListener(new enterCard());
		
	}
	
	class enterCard implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				dis = new DataInputStream(skClient.getInputStream());
				dos = new DataOutputStream(skClient.getOutputStream());
					
				dos.writeUTF("verifycard-"+txtEnterCard.getText());

				String responseServer = dis.readUTF();
				System.out.println(responseServer);
				if(responseServer.equals("verifiedcard")) {
					numberCard = txtEnterCard.getText();
					new enterPIN().setVisible(true);
					dispose();
				}
				if(responseServer.equals("verifiedcard-fail")){
					JOptionPane.showMessageDialog(contentPane, "Vui long nhap lai so the" );
				}
				
			} catch (UnknownHostException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			} catch (IOException ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
			}
		}
		
	}
}
