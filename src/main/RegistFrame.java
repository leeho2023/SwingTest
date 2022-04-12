package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import db.MySQLDB;

public class RegistFrame extends JFrame {

	private JPanel contentPane;
	private JTextField idInputField;
	private JLabel id;
	private JPasswordField pwField;
	private JPasswordField pwCheckField;
	
	public RegistFrame() {
		setBackground(Color.PINK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 494);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("⚔회원가입⚔");
		title.setFont(new Font("Dialog", Font.BOLD, 30));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(147, 24, 248, 55);
		contentPane.add(title);
		
		idInputField = new JTextField();
		idInputField.setFont(new Font("굴림", Font.BOLD, 20));
		idInputField.setBounds(147, 127, 248, 39);
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
		
		id = new JLabel("아이디");
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setFont(new Font("Dialog", Font.BOLD, 15));
		id.setBounds(129, 89, 88, 28);
		contentPane.add(id);
		
		JLabel pw = new JLabel("비밀번호");
		pw.setHorizontalAlignment(SwingConstants.CENTER);
		pw.setFont(new Font("Dialog", Font.BOLD, 15));
		pw.setBounds(139, 176, 88, 28);
		contentPane.add(pw);
		
		pwField = new JPasswordField();
		pwField.setFont(new Font("굴림", Font.BOLD, 20));
		pwField.setBounds(147, 214, 248, 39);
		contentPane.add(pwField);
		
		JLabel pwCheck = new JLabel("비밀번호 확인");
		pwCheck.setHorizontalAlignment(SwingConstants.CENTER);
		pwCheck.setFont(new Font("Dialog", Font.BOLD, 15));
		pwCheck.setBounds(147, 263, 114, 28);
		contentPane.add(pwCheck);
		
		pwCheckField = new JPasswordField();
		pwCheckField.setFont(new Font("굴림", Font.BOLD, 20));
		pwCheckField.setBounds(147, 301, 248, 39);
		contentPane.add(pwCheckField);
		returnBassBtn.setBounds(290, 368, 105, 28);
		contentPane.add(returnBassBtn);
		
		
		JButton singInBtn = new JButton("회원가입");
		singInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				// 패스워드 값 아이디 값 받아오기
				String id = idInputField.getText().trim().replaceAll(" ", "");		//아이디
				id = id.replaceAll("[^a-zA-Z0-9]", "");
				String pw = pwField.getText().trim().replaceAll(" ", "");			// 비밀번호
				
				String rePw = pwCheckField.getText().trim().replaceAll(" ", "");	// 비밀번호 확인
				
				
				int idCheck = 0;
				int pwCheck = 0;
				int rePwCheck = 0;
				int ans = 0;
				
//				System.out.println(id);
//				System.out.println(pw);
//				System.out.println(rePw);
				
				// 아이디 유효성 검사
				
				if(id.length() > 4) {
					if(id.equals("") || id == null) {
						idCheck = 0;
						System.out.println("아이디가 입력되지 않았습니다.");
						JOptionPane.showMessageDialog(contentPane, "아이디를 입력해주세요", "경고", JOptionPane.WARNING_MESSAGE);
					}else {
						MySQLDB db = new MySQLDB();
						int test = db.checkUserID(id);
						if(test == 0) {
							idCheck = 0;
							idInputField.setText("");
							System.out.println("아이디 중복");
							JOptionPane.showMessageDialog(contentPane, "아이디 중복", "경고", JOptionPane.WARNING_MESSAGE);
						}else {
							System.out.println("아이디 사용가능");
							JOptionPane.showConfirmDialog(contentPane, "이 아이디를 사용하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
							idCheck = 1;
						}
					}
				}else {
					idCheck = 0;
					JOptionPane.showMessageDialog(contentPane, "아이디를 5글자 이상 입력해주세요", "경고", JOptionPane.WARNING_MESSAGE);
				}
				
				
				// 비밀번호 유효성 검사
				if(pw.equals("") || pw == null) {
					pwCheck = 0;
					System.out.println("비밀번호가 입력되지 않았습니다.");
					JOptionPane.showMessageDialog(contentPane, "비밀번호를 입력해주세요", "경고", JOptionPane.WARNING_MESSAGE);
				}else if(rePw.equals("") || rePw == null) {
					rePwCheck = 0;
					System.out.println("비밀번호확인이 입력되지 않았습니다.");
					JOptionPane.showMessageDialog(contentPane, "비밀번호확인을 입력해주세요", "경고", JOptionPane.WARNING_MESSAGE);
				}else {
					if(pw.length() > 10) {
						if(pw.equals(rePw)){
							System.out.println("비밀번호가 일치합니다.");
							pwCheck = 1;
							rePwCheck = 1;
						}else {
							pwCheck = 0;
							rePwCheck = 0;
							pwField.setText("");
							pwCheckField.setText("");
							System.out.println("비밀번호가 일지하지 않습니다.");
							JOptionPane.showMessageDialog(contentPane, "비밀번호가 일치하지 않습니다.", "경고", JOptionPane.WARNING_MESSAGE);
						}
					}else {
						pwCheck = 0;
						rePwCheck = 0;
						JOptionPane.showMessageDialog(contentPane, "비밀번호를 10자리 이상 입력해주세요", "경고", JOptionPane.WARNING_MESSAGE);
					}
				}
					
				
				// 아이디 비밀번호 비밀번호 확인 검사완료 확인
				if(idCheck == 1 && pwCheck == 1 && rePwCheck == 1) {
					System.out.println("아이디 입력완료 비밀번호 입력완료 비밀번호 확인 입력완료");
					ans = JOptionPane.showConfirmDialog(contentPane, "가입하시겠습니까?", "확인", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
					
					if(ans == 0) {
						System.out.println("가입 완료");
						MySQLDB db = new MySQLDB();
						db.insert(id, pw);
						Main frame = new Main();
						frame.setVisible(true);
						JOptionPane.showMessageDialog(contentPane, "🎊가입 완료🎊", "확인", JOptionPane.PLAIN_MESSAGE);
						setVisible(false);
					}else {
						System.out.println("가입 취소");
						idInputField.setText("");
						pwField.setText("");
						pwCheckField.setText("");
						JOptionPane.showMessageDialog(contentPane, "가입 취소", "확인", JOptionPane.PLAIN_MESSAGE);
					}
				}
				
			}
		});
		singInBtn.setBounds(147, 368, 105, 28);
		contentPane.add(singInBtn);
		
		
		
	}
}
