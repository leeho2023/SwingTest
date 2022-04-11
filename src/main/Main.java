package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.MySQLDB;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField idInputField;
	private JTextField pwInputField;
	private JButton loginBtn;
	private JButton singInBtn;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("로그인");
//		label.setOpaque(true);
		title.setFont(new Font("Dialog", Font.BOLD, 30));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(116, 48, 133, 44);
		contentPane.add(title);
		
		idInputField = new JTextField();
		idInputField.setBounds(112, 104, 150, 22);
		idInputField.setColumns(10);
		contentPane.add(idInputField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(112, 137, 150, 22);
		passwordField.setColumns(10);
		contentPane.add(passwordField);
		
		loginBtn = new JButton("로그인");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("1111111111");
				String id = idInputField.getText();
				System.out.println("2222222222");
				String pw = passwordField.getText();
				System.out.println("333333333333");
				
				System.out.println("id : " + id );
				System.out.println("pw : " + pw );
				
				MySQLDB db = new MySQLDB();
				boolean test = db.checkUser(id, pw);
				if(test == true) {
					System.out.println("메인에 새창 띄우기");
				}else {
					System.out.println("메인에 경고창 띄우기");
				}
				
				
			}
		});
		loginBtn.setBounds(112, 171, 67, 28);
		contentPane.add(loginBtn);
		
		singInBtn = new JButton("회원가입");
		singInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegistFrame rf = new RegistFrame();
				rf.setVisible(true);
				setVisible(false);
				
			}
		});
		singInBtn.setBounds(178, 171, 89, 28);
		contentPane.add(singInBtn);

	}
}
