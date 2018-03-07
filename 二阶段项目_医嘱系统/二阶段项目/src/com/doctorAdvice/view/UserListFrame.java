package com.doctorAdvice.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import com.doctorAdvice.entry.rowmapper.User;
import com.doctorAdvice.service.Administrator;

//import com.jfame_row.service.UserService;
//import com.jfame_row.vo.SystemUser;



public class UserListFrame extends JFrame {

	private JButton createBtn;
	private JButton updateBtn;
	private JButton deleteBtn;
	private JButton returnBtn;
	private JPanel jPanel1;
	private JScrollPane userTable;
	private Administrator admin;

//	private UserService us = new UserService();
	private JTable table_1;
	
	public UserListFrame() {
		initComponents();
	}

	public UserListFrame(User user) {
		admin = new Administrator(user);
		initComponents();
	}
	private void initComponents() {

		jPanel1 = new JPanel();
		userTable = new JScrollPane();
		createBtn = new JButton();
		updateBtn = new JButton();
		deleteBtn = new JButton();
		returnBtn = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("用户列表");

		getContentPane().setLayout(new AbsoluteLayout());
		jPanel1.setLayout(new AbsoluteLayout());

		
		jPanel1.add(userTable, new AbsoluteConstraints(50, 50, 660, 330));
		
		table_1 = new JTable();
		userTable.setViewportView(table_1);
		initTableData();
		createBtn.setText("新建");
		jPanel1.add(createBtn, new AbsoluteConstraints(80, 420, 110, 40));
		updateBtn.setText("修改");
		jPanel1.add(updateBtn, new AbsoluteConstraints(250, 420, 110, 40));
		deleteBtn.setText("删除");
		jPanel1.add(deleteBtn, new AbsoluteConstraints(420, 420, 110, 40));
		returnBtn.setText("返回");
		jPanel1.add(returnBtn, new AbsoluteConstraints(580, 420, 110, 40));

		getContentPane().add(jPanel1, new AbsoluteConstraints(0, 0, 770, 520));
		pack();

		createBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddUserFrame frame = new AddUserFrame(admin);
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				dispose();
			}
		});

		updateBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int num = table_1.getSelectedRowCount();
				
				// 判断选中的行数是否为1行
				if (num == 1) {
					// 如果为1行的时候获取这一行的值
					// 创建一个user对象
//					SystemUser user = new SystemUser();
					// 给user对象赋值
//					user.setId(Integer.parseInt(table_1.getValueAt(table_1.getSelectedRow(), 0) + ""));
//					user.setAccount(table_1.getValueAt(table_1.getSelectedRow(), 1) + "");
//					user.setUsername(table_1.getValueAt(table_1.getSelectedRow(), 2) + "");
//					user.setPassword(table_1.getValueAt(table_1.getSelectedRow(), 3) + "");
//					user.setUserType(table_1.getValueAt(table_1.getSelectedRow(), 4) + "");
//					
					User newUser = new User();
					newUser.setUserId(Integer.parseInt(table_1.getValueAt(table_1.getSelectedRow(), 0).toString()));
					newUser.setLoginName(table_1.getValueAt(table_1.getSelectedRow(), 1).toString());
					newUser.setLoginPwd(table_1.getValueAt(table_1.getSelectedRow(), 2).toString());
					newUser.setUserType(table_1.getValueAt(table_1.getSelectedRow(), 3).toString());
					newUser.setName(table_1.getValueAt(table_1.getSelectedRow(), 4).toString());
					// 传值到修改页面
					UpdateUserFrame updateFrame = new UpdateUserFrame(admin, newUser);
					updateFrame.setVisible(true);
					updateFrame.setLocationRelativeTo(null);
//					updateFrame.getUser();
					dispose();
				} else if (table_1.getSelectedRowCount() > 1) {
					JOptionPane.showMessageDialog(null, "选中多行", "提示", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "未选中", "提示", JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});

		deleteBtn.addActionListener(new ActionListener() {
			//删除用户
			@Override
			public void actionPerformed(ActionEvent e) {
//				int num = table_1.getSelectedRowCount();
				
				// 判断选中的行数是否为1行
				if (num == 1) {
					// 如果为1行的时候获取这一行的值
					// 创建一个user对象
//					SystemUser user = new SystemUser();
					// 给user对象赋值
//					user.setId(Integer.parseInt(table_1.getValueAt(table_1.getSelectedRow(), 0) + ""));
//					user.setAccount(table_1.getValueAt(table_1.getSelectedRow(), 1) + "");
//					user.setUsername(table_1.getValueAt(table_1.getSelectedRow(), 2) + "");
//					user.setPassword(table_1.getValueAt(table_1.getSelectedRow(), 3) + "");
//					user.setUserType(table_1.getValueAt(table_1.getSelectedRow(), 4) + "");
//					
					User newUser = new User();
					newUser.setUserId(Integer.parseInt(table_1.getValueAt(table_1.getSelectedRow(), 0).toString()));
					
					int result = admin.deleteUserById(newUser.getUserId());
					if(result == 1) {
						JOptionPane.showMessageDialog(null, "删除成功", "提示", JOptionPane.INFORMATION_MESSAGE);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "删除失败", "提示", JOptionPane.INFORMATION_MESSAGE);
					}
					
				} else if (table_1.getSelectedRowCount() > 1) {
					JOptionPane.showMessageDialog(null, "选中多行", "提示", JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(null, "未选中", "提示", JOptionPane.INFORMATION_MESSAGE);
				}
			}
			
		});

		//返回
		returnBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				UserLoginFrame b=new UserLoginFrame();
				b.setVisible(true);
				b.setLocationRelativeTo(null);
				dispose();//将本页面隐藏
			}
		});
	}

	// 初始化所有用户，查询所有用户
	protected void initTableData() {
		
		
		String[][] values = admin.queryAllUser();
		table_1.setModel(new DefaultTableModel(values,new String[] { "ID", "登陆名", "密码", "类型", "账号" }));
	}

	
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				UserListFrame userListFrame = new UserListFrame();
				userListFrame.setVisible(true);
				userListFrame.setLocationRelativeTo(null);
			}
		});
	}
}
