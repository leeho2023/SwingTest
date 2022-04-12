package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JList;

public class Lotto extends JFrame {
	DefaultListModel<String> listModel = new DefaultListModel<String>();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lotto frame = new Lotto();
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Lotto() {
		setBackground(Color.PINK);
		setBounds(100, 100, 800, 800);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel num1 = new JLabel("");
		num1.setHorizontalAlignment(SwingConstants.CENTER);
		num1.setFont(new Font("굴림", Font.PLAIN, 35));
		num1.setBackground(Color.WHITE);
		num1.setOpaque(true);
		num1.setBounds(17, 62, 110, 110);
		contentPane.add(num1);
		
		JLabel num2 = new JLabel("");
		num2.setHorizontalAlignment(SwingConstants.CENTER);
		num2.setFont(new Font("굴림", Font.PLAIN, 35));
		num2.setBackground(Color.WHITE);
		num2.setOpaque(true);
		num2.setBounds(144, 62, 110, 110);
		contentPane.add(num2);
		
		JLabel num3 = new JLabel("");
		num3.setHorizontalAlignment(SwingConstants.CENTER);
		num3.setFont(new Font("굴림", Font.PLAIN, 35));
		num3.setBackground(Color.WHITE);
		num3.setOpaque(true);
		num3.setBounds(271, 62, 110, 110);
		contentPane.add(num3);
		
		JLabel num4 = new JLabel("");
		num4.setHorizontalAlignment(SwingConstants.CENTER);
		num4.setFont(new Font("굴림", Font.PLAIN, 35));
		num4.setBackground(Color.WHITE);
		num4.setOpaque(true);
		num4.setBounds(398, 62, 110, 110);
		contentPane.add(num4);
		
		JLabel num5 = new JLabel("");
		num5.setHorizontalAlignment(SwingConstants.CENTER);
		num5.setFont(new Font("굴림", Font.PLAIN, 35));
		num5.setBackground(Color.WHITE);
		num5.setOpaque(true);
		num5.setBounds(525, 62, 110, 110);
		contentPane.add(num5);
		
		JLabel num6 = new JLabel("");
		num6.setHorizontalAlignment(SwingConstants.CENTER);
		num6.setFont(new Font("굴림", Font.PLAIN, 35));
		num6.setBackground(Color.WHITE);
		num6.setOpaque(true);
		num6.setBounds(652, 62, 110, 110);
		contentPane.add(num6);
		
		
		
		JButton selectBtn = new JButton("뽑 기");
		selectBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Integer> list = new ArrayList<Integer>();
				TreeSet<Integer> test = new TreeSet<Integer>();
				while(test.size() < 6) {
					 int number = (int)Math.ceil(Math.random()*45);
					 test.add(number);
				}
				
				
				for(int ts : test) {
					list.add(ts);
				}
				
				num1.setText(Integer.toString(list.get(0)));
				num2.setText(Integer.toString(list.get(1)));
				num3.setText(Integer.toString(list.get(2)));
				num4.setText(Integer.toString(list.get(3)));
				num5.setText(Integer.toString(list.get(4)));
				num6.setText(Integer.toString(list.get(5)));
				
				
				
				
			}
		});
		selectBtn.setFont(new Font("굴림", Font.PLAIN, 20));
		selectBtn.setBounds(31, 249, 219, 40);
		contentPane.add(selectBtn);
		
		JList<String> saveList = new JList<>();
		saveList.setBounds(144, 333, 219, 418);
		contentPane.add(saveList);
		saveList.setModel(listModel);
		
		JButton saveBtn = new JButton("저 장");
		saveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			listModel.addElement(num1.getText() + ", " + num2.getText() + ", " + num3.getText() 
			+ ", " + num4.getText() + ", " + num5.getText() + ", " + num6.getText());
				
			}
		});
		saveBtn.setFont(new Font("굴림", Font.PLAIN, 20));
		saveBtn.setBounds(281, 249, 219, 40);
		contentPane.add(saveBtn);
		
		JButton logOutBtn = new JButton("로그아웃");
		logOutBtn.setFont(new Font("굴림", Font.PLAIN, 20));
		logOutBtn.setBounds(531, 249, 219, 40);
		contentPane.add(logOutBtn);
		
		
		
		JLabel lblNewLabel = new JLabel("로또 번호 뽑기~!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		lblNewLabel.setBounds(281, 10, 200, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("되겠냐~");
		lblNewLabel_1.setBounds(693, 295, 57, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("1 회차 :");
		lblNewLabel_2.setBounds(93, 334, 57, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("2 회차 :");
		lblNewLabel_2_1.setBounds(93, 353, 57, 15);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("3 회차 :");
		lblNewLabel_2_1_1.setBounds(93, 374, 57, 15);
		contentPane.add(lblNewLabel_2_1_1);
	}
}
