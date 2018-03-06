package com.doctorAdvice.view.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginWin extends JFrame {

	private JPanel contentPane;
	private JTextField userName;
	private JTextField userPwd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWin frame = new LoginWin();
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
	public LoginWin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D:");
		label.setBounds(85, 82, 72, 18);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6  \u7801:");
		label_1.setBounds(85, 120, 72, 18);
		contentPane.add(label_1);
		
		userName = new JTextField();
		userName.setBounds(183, 79, 86, 24);
		contentPane.add(userName);
		userName.setColumns(10);
		
		userPwd = new JTextField();
		userPwd.setBounds(183, 117, 86, 24);
		contentPane.add(userPwd);
		userPwd.setColumns(10);
		
		JButton loginButton = new JButton("\u767B    \u9646");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		loginButton.setBounds(65, 190, 113, 27);
		contentPane.add(loginButton);
		
		JButton registButton = new JButton("\u6CE8    \u518C");
		registButton.setBounds(235, 190, 113, 27);
		contentPane.add(registButton);
	}
}
