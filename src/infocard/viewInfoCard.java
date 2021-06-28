package infocard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import System.Card;
import System.chooseService;

public class viewInfoCard extends JFrame {

	private JPanel panel;
	private JPanel contentPane;
	private JTextField txtEnterCard;
	private static ObjectInputStream ois;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewInfoCard frame = new viewInfoCard();
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
	public viewInfoCard() {
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
		
		JButton btnChoose6 = new JButton("New button");
		btnChoose6.setBounds(843, 289, 211, 131);
		contentPane.add(btnChoose6);
		btnChoose6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new chooseService().setVisible(true);
				dispose();
			}
		});
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(218, 0, 615, 420);
		panel.setLayout(null);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		BufferedImage bufImg=null;
		try {
			bufImg=ImageIO.read(new File("C:\\Users\\84837\\eclipse-workspace\\ATM\\image\\header.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lblNewLabel.setBounds(0, 0, 599, 111);
		Image dimg=bufImg.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(dimg));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_4 = new JLabel("NH\u1EA4N CANCEL \u0110\u1EC2 THO\u00C1T");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(new Color(128, 0, 0));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 18));
		lblNewLabel_4.setBounds(166, 329, 270, 41);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("TH\u00D4NG TIN T\u00C0I KHO\u1EA2N");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(new Color(128, 0, 0));
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(22, 131, 548, 49);
		panel.add(lblNewLabel_3);
		
		JLabel lblContinue = new JLabel("TI\u1EBEP T\u1EE4C GIAO D\u1ECACH");
		lblContinue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContinue.setForeground(new Color(128, 0, 0));
		lblContinue.setFont(new Font("Arial", Font.PLAIN, 18));
		lblContinue.setBounds(404, 302, 195, 37);
		panel.add(lblContinue);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("T\u00E0i kho\u1EA3n thanh to\u00E1n:");
		lblNewLabel_2_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_2.setForeground(new Color(128, 0, 0));
		lblNewLabel_2_1_2.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2_1_2.setBounds(90, 191, 195, 37);
		panel.add(lblNewLabel_2_1_2);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("Ch\u1EE7 t\u00E0i kho\u1EA3n:");
		lblNewLabel_2_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_2_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_2_1_2_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2_1_2_1.setBounds(90, 221, 195, 22);
		panel.add(lblNewLabel_2_1_2_1);
		
		JLabel lblNewLabel_2_1_2_1_1 = new JLabel("S\u1ED1 d\u01B0 t\u00E0i kho\u1EA3n:");
		lblNewLabel_2_1_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_2_1_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_2_1_2_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2_1_2_1_1.setBounds(90, 246, 208, 22);
		panel.add(lblNewLabel_2_1_2_1_1);
		
		JLabel lblNewLabel_2_1_2_1_1_1 = new JLabel("Ng\u00E2n h\u00E0ng:");
		lblNewLabel_2_1_2_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2_1_2_1_1_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_2_1_2_1_1_1.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNewLabel_2_1_2_1_1_1.setBounds(90, 269, 208, 22);
		panel.add(lblNewLabel_2_1_2_1_1_1);
		
		JLabel lblNumberCard = new JLabel("Ng\u00E2n h\u00E0ng th\u1EE5 h\u01B0\u1EDFng:");
		lblNumberCard.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumberCard.setForeground(new Color(128, 0, 0));
		lblNumberCard.setFont(new Font("Arial", Font.PLAIN, 18));
		lblNumberCard.setBounds(299, 191, 195, 37);
		panel.add(lblNumberCard);
		
		JLabel lblName = new JLabel("S\u1ED1 TK/s\u1ED1 th\u1EBB chuy\u1EC3n \u0111i:");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setForeground(new Color(128, 0, 0));
		lblName.setFont(new Font("Arial", Font.PLAIN, 18));
		lblName.setBounds(299, 221, 195, 22);
		panel.add(lblName);
		
		JLabel lblBalance = new JLabel("S\u1ED1 TK/s\u1ED1 th\u1EBB th\u1EE5 h\u01B0\u1EDFng:");
		lblBalance.setHorizontalAlignment(SwingConstants.LEFT);
		lblBalance.setForeground(new Color(128, 0, 0));
		lblBalance.setFont(new Font("Arial", Font.PLAIN, 18));
		lblBalance.setBounds(299, 246, 208, 22);
		panel.add(lblBalance);
		
		JLabel lblBankName = new JLabel("VND");
		lblBankName.setHorizontalAlignment(SwingConstants.LEFT);
		lblBankName.setForeground(new Color(128, 0, 0));
		lblBankName.setFont(new Font("Arial", Font.PLAIN, 18));
		lblBankName.setBounds(299, 269, 208, 22);
		panel.add(lblBankName);
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
		
		try {
			ois = new ObjectInputStream(chooseService.skViewInfoCard.getInputStream());
			Card obj = (Card) ois.readObject();
			lblNumberCard.setText(obj.getNumber_card());
			lblName.setText(obj.getName());
			lblBalance.setText(obj.getBalance()+"");
			lblBankName.setText(obj.getBank_name());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
