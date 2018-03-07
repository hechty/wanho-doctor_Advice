package com.doctorAdvice.view;

import java.awt.event.*;
import javax.swing.*;

import org.netbeans.lib.awtextra.*;

public class AddUserFrame extends JFrame {

	private JButton submitBtn;
	private JButton cancelBtn;
	private JLabel jLabel0;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JPanel jPanel1;
	private JTextField accountText;
	private JTextField usernameText;
	private JTextField repasswordText;
	private JTextField passwordText;
	private JComboBox type;

	public AddUserFrame() {
		initComponents();
	}

	private void initComponents() {

		jPanel1 = new JPanel();
		type = new JComboBox();
		jLabel0 = new JLabel();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		accountText = new JTextField();
		repasswordText = new JTextField();
		submitBtn = new JButton();
		cancelBtn = new JButton();
		jLabel3 = new JLabel();
		usernameText = new JTextField();
		jLabel4 = new JLabel();
		passwordText = new JTextField();

		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setTitle("新增用户");
		setFocusable(false);
		setResizable(false);
		getContentPane().setLayout(new AbsoluteLayout());

		jPanel1.setLayout(new AbsoluteLayout());

		jLabel0.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel0.setText("帐户");
		jPanel1.add(jLabel0, new AbsoluteConstraints(100, 20, 90, 40));

		jLabel3.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel3.setText("名称");
		jPanel1.add(jLabel3, new AbsoluteConstraints(100, 70, 90, 40));

		jLabel2.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel2.setText("类型");
		jPanel1.add(jLabel2, new AbsoluteConstraints(100, 120, 90, 40));

		jLabel4.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel4.setText("密码");
		jPanel1.add(jLabel4, new AbsoluteConstraints(100, 170, 90, 40));

		jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel1.setText("确认密码");
		jPanel1.add(jLabel1, new AbsoluteConstraints(100, 220, 90, 40));

		jPanel1.add(accountText, new AbsoluteConstraints(200, 20, 190, 40));
		jPanel1.add(usernameText, new AbsoluteConstraints(200, 70, 190, 40));
		type.setModel(new DefaultComboBoxModel(new String[] { "管理员", "医师",
				"药剂师", "护士" }));
		type.setSelectedIndex(0);
		jPanel1.add(type, new AbsoluteConstraints(200, 120, 190, 40));
		type.getAccessibleContext().setAccessibleName("type");
		jPanel1.add(passwordText, new AbsoluteConstraints(200, 170, 190, 40));
		jPanel1.add(repasswordText, new AbsoluteConstraints(200, 220, 190, 40));

		submitBtn.setFont(new java.awt.Font("微软雅黑", 0, 18));
		submitBtn.setText("确认新增");

		jPanel1.add(submitBtn, new AbsoluteConstraints(100, 300, 110, 50));

		cancelBtn.setFont(new java.awt.Font("微软雅黑", 0, 18));
		cancelBtn.setText("取消");
		jPanel1.add(cancelBtn, new AbsoluteConstraints(280, 300, 110, 50));

		getContentPane().add(jPanel1, new AbsoluteConstraints(0, 0, 480, 440));
		pack();
		submitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {

				AddUserFrame frame = new AddUserFrame();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);

			}
		});
	}

}