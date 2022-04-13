package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.MySQLDB;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

@SuppressWarnings({ "serial", "unused" })
public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField idInputField;
	@SuppressWarnings("unused")
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
		setBounds(100, 350, 400, 350);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("⚔수탉의 전설⚔");
//		label.setOpaque(true);
		title.setFont(new Font("Dialog", Font.BOLD, 30));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(76, 48, 217, 44);
		contentPane.add(title);
		
		idInputField = new JTextField();
		idInputField.setBounds(112, 102, 150, 22);
		idInputField.setColumns(10);
		contentPane.add(idInputField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(112, 137, 150, 22);
		passwordField.setColumns(10);
		contentPane.add(passwordField);
		
		loginBtn = new JButton("로그인");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = idInputField.getText().trim().replaceAll(" ", "");
				String pw = passwordField.getText().trim().replaceAll(" ", "");
				
				System.out.println("id : " + id );
				System.out.println("pw : " + pw );
				
				if(id.equals("admin") && pw.equals("admin111")) {
					System.out.println("관리자 로그인 성공");
				}else {
					MySQLDB db = new MySQLDB();
					boolean test = db.checkUser(id, pw);
					if(test == true) {
						Lotto frame = new Lotto();
						frame.setVisible(true);
						idInputField.setText("");
						passwordField.setText("");
						setVisible(false);
					}else {
						JOptionPane.showMessageDialog(contentPane, "아이디 혹은 비밀번호를 다시 확인해주세요", "경고", JOptionPane.WARNING_MESSAGE);
					}
				}
				
				
			}
		});
		loginBtn.setBounds(96, 171, 78, 28);
		contentPane.add(loginBtn);
		
		singInBtn = new JButton("회원가입");
		singInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				RegistFrame rf = new RegistFrame();
				rf.setVisible(true);
				setVisible(false);
				
			}
		});
		
		singInBtn.setBounds(186, 171, 87, 28);
		contentPane.add(singInBtn);

	}
}
