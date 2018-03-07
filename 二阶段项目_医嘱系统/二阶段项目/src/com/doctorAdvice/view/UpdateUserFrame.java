package com.doctorAdvice.view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import org.netbeans.lib.awtextra.*;

public class UpdateUserFrame extends JFrame {
	private JButton submitBtn;
	private JButton cancelBtn;
	private JComboBox jComboBox1;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JPanel jPanel1;
	private JTextField repasswordText;
	private JTextField passwordText;
	private JTextField usernameText;
	private JTextField idText;
	private JTextField accountText;
	private JLabel jLabel0;

	public UpdateUserFrame() {
		initComponents();
	}

	private void initComponents() {

		jPanel1 = new JPanel();
		jLabel0 = new JLabel();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		usernameText = new JTextField();
		idText = new JTextField();
		accountText = new JTextField();
		jComboBox1 = new JComboBox();
		repasswordText = new JTextField();
		passwordText = new JTextField();
		submitBtn = new JButton();
		cancelBtn = new JButton();

		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setTitle("修改用户");
		getContentPane().setLayout(new AbsoluteLayout());

		jPanel1.setForeground(new java.awt.Color(0, 51, 51));
		jPanel1.setLayout(new AbsoluteLayout());

		jLabel0.setFont(new Font("微软雅黑", 0, 18));
		jLabel0.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel0.setText("I  D:");
		jPanel1.add(jLabel0, new AbsoluteConstraints(60, 20, 100, 40));

		jLabel3.setFont(new Font("微软雅黑", 0, 18));
		jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel3.setText("名称：");
		jPanel1.add(jLabel3, new AbsoluteConstraints(60, 70, 100, 50));

		jLabel4.setFont(new Font("微软雅黑", 0, 18));
		jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel4.setText("类型：");
		jPanel1.add(jLabel4, new AbsoluteConstraints(60, 120, 100, 50));

		jLabel2.setFont(new Font("微软雅黑", 0, 18));
		jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel2.setText("密码：");
		jPanel1.add(jLabel2, new AbsoluteConstraints(60, 220, 100, 50));

		jLabel1.setFont(new Font("微软雅黑", 0, 18));
		jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel1.setText("确认密码：");
		jPanel1.add(jLabel1, new AbsoluteConstraints(60, 270, 100, 50));

		jLabel5.setFont(new Font("微软雅黑", 0, 18));
		jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
		jLabel5.setText("用户帐号：");
		jPanel1.add(jLabel5, new AbsoluteConstraints(60, 170, 100, 50));

		idText.setFont(new Font("微软雅黑", 0, 18));
		idText.setEditable(false);
		jPanel1.add(idText, new AbsoluteConstraints(170, 20, 190, 40));

		usernameText.setFont(new Font("微软雅黑", 0, 18));
		usernameText.setEditable(false);
		jPanel1.add(usernameText, new AbsoluteConstraints(170, 70, 190, 40));

		jComboBox1.setFont(new Font("微软雅黑", 0, 18));
		jComboBox1.setModel(new DefaultComboBoxModel(new String[] { "管理员",
				"医   生", "药剂师", "护   士" }));
		jPanel1.add(jComboBox1, new AbsoluteConstraints(170, 120, 190, 40));

		accountText.setFont(new Font("微软雅黑", 0, 18));
		accountText.setEditable(false);
		jPanel1.add(accountText, new AbsoluteConstraints(170, 170, 190, 40));

		jPanel1.add(passwordText, new AbsoluteConstraints(170, 220, 190, 40));

		jPanel1.add(repasswordText, new AbsoluteConstraints(170, 270, 190, 40));

		submitBtn.setFont(new Font("微软雅黑", 0, 18));
		submitBtn.setText("确认修改");
		jPanel1.add(submitBtn, new AbsoluteConstraints(60, 340, 110, 50));

		cancelBtn.setFont(new Font("微软雅黑", 0, 18));
		cancelBtn.setText("取消");
		jPanel1.add(cancelBtn, new AbsoluteConstraints(270, 340, 110, 50));

		getContentPane().add(jPanel1, new AbsoluteConstraints(10, 10, 470, 450));

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
				UpdateUserFrame frame = new UpdateUserFrame();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);

			}
		});
	}

}