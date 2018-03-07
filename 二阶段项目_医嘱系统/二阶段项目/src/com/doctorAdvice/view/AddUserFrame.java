package com.doctorAdvice.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import com.doctorAdvice.common.TableProperties;
import com.doctorAdvice.entry.rowmapper.User;
import com.doctorAdvice.service.Administrator;

public class AddUserFrame extends JFrame {
	private Administrator admin;
	private JButton submitBtn;
	private JButton cancelBtn;
	private JLabel jLabel0;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JPanel jPanel1;
	private JTextField userName;
	private JTextField loginName;
	private JTextField loginPwd2;
	private JTextField loginPwd;
	private JComboBox userType;

	
	public AddUserFrame() {
		initComponents();
	}

	public AddUserFrame(User user) {
		initComponents();
		admin = new Administrator(user);
	}
	private void initComponents() {

		jPanel1 = new JPanel();
		userType = new JComboBox();
		jLabel0 = new JLabel();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		userName = new JTextField();
		loginPwd2 = new JTextField();
		submitBtn = new JButton();
		cancelBtn = new JButton();
		jLabel3 = new JLabel();
		loginName = new JTextField();
		jLabel4 = new JLabel();
		loginPwd = new JTextField();

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

		jPanel1.add(userName, new AbsoluteConstraints(200, 20, 190, 40));
		jPanel1.add(loginName, new AbsoluteConstraints(200, 70, 190, 40));
		userType.setModel(new DefaultComboBoxModel(new String[] { "管理员", "医师",
				"药剂师", "护士" }));
		userType.setSelectedIndex(0);
		jPanel1.add(userType, new AbsoluteConstraints(200, 120, 190, 40));
		userType.getAccessibleContext().setAccessibleName("type");
		jPanel1.add(loginPwd, new AbsoluteConstraints(200, 170, 190, 40));
		jPanel1.add(loginPwd2, new AbsoluteConstraints(200, 220, 190, 40));

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
				String newType = null;
				switch(userType.getSelectedItem().toString()) {
				case "管理员":
					newType = TableProperties.tableStruct.getProperty("user.userType.admin");
					break;
				case "医生":
					newType = TableProperties.tableStruct.getProperty("user.userType.doctor");
					break;
				case "药剂师":
					newType = TableProperties.tableStruct.getProperty("user.userType.pharmacist");
					break;	
				case "护士":
					newType = TableProperties.tableStruct.getProperty("user.userType.nurse");
					break;	
				}
				//用户编号由数据库序列自动维护
				User newUser = new User(-1, userName.getText(), loginName.getText(), loginPwd.getText(), newType);
				int result = admin.addUser(newUser);
				if(result == 1) {
					JOptionPane.showMessageDialog(null, "添加成功","提示",JOptionPane.CANCEL_OPTION);
				}else {
					JOptionPane.showMessageDialog(null, "添加失败","提示",JOptionPane.CANCEL_OPTION);
				}
				
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