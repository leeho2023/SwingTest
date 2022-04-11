package main;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import db.MySQLDB;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;

public class RegistFrame extends JFrame {

	private JPanel contentPane;
	private JTextField idInputField;
	private JLabel id;
	private JPasswordField pwField;
	private JPasswordField pwCheckField;
	
	public RegistFrame() {
		setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 350);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("회원가입");
		title.setFont(new Font("Dialog", Font.BOLD, 23));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(135, 20, 88, 28);
		contentPane.add(title);
		
		idInputField = new JTextField();
		idInputField.setBounds(150, 70, 114, 22);
		contentPane.add(idInputField);
		idInputField.setColumns(10);
		
		JButton returnBassBtn = new JButton("돌아가기");
		returnBassBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main frame = new Main();
				frame.setVisible(true);
				setVisible(false);
			}
		});
		
		id = new JLabel("아이디 :");
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setFont(new Font("Dialog", Font.BOLD, 15));
		id.setBounds(75, 65, 88, 28);
		contentPane.add(id);
		
		JLabel pw = new JLabel("비밀번호 :");
		pw.setHorizontalAlignment(SwingConstants.CENTER);
		pw.setFont(new Font("Dialog", Font.BOLD, 15));
		pw.setBounds(68, 94, 88, 28);
		contentPane.add(pw);
		
		pwField = new JPasswordField();
		pwField.setBounds(150, 100, 114, 22);
		contentPane.add(pwField);
		
		JLabel pwCheck = new JLabel("비밀번호 확인 :");
		pwCheck.setHorizontalAlignment(SwingConstants.CENTER);
		pwCheck.setFont(new Font("Dialog", Font.BOLD, 15));
		pwCheck.setBounds(42, 124, 114, 28);
		contentPane.add(pwCheck);
		
		pwCheckField = new JPasswordField();
		pwCheckField.setBounds(150, 130, 114, 22);
		contentPane.add(pwCheckField);
		returnBassBtn.setBounds(203, 196, 105, 28);
		contentPane.add(returnBassBtn);
		
		
		JButton singInBtn = new JButton("회원가입");
		singInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String testId = idInputField.getText();
				String testPw = pwField.getText();
				String testPwCheck = pwCheckField.getText();
				
				if(testPw.equals(testPwCheck)) {
					MySQLDB db = new MySQLDB();
					db.insert(testId, testPw);
				}else {
					Pwcheck pc = new Pwcheck();
					pc.setVisible(true);
				}
				
//				MySQLDB db = new MySQLDB();
//				db.insert(testId, testPw);
//				System.out.println("insert 완료");
				
			}
		});
		singInBtn.setBounds(86, 196, 105, 28);
		contentPane.add(singInBtn);
		
		
		
	}
}
