package com.doctorAdvice.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import com.doctorAdvice.common.TableProperties;
import com.doctorAdvice.entry.rowmapper.User;
import com.doctorAdvice.service.Login;

@SuppressWarnings("serial")
public class UserLoginFrame extends JFrame {
	private JPanel jPanel1;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JTextField loginName;
	private JPasswordField loginPwd;
	private JButton loginBtn;
	private JButton cancelBtn;

	public UserLoginFrame() {
		initComponents();
	}

	private void initComponents() {

		jPanel1 = new JPanel();
		jLabel1 = new JLabel();
		jLabel2 = new JLabel();
		loginName = new JTextField();
		loginPwd = new JPasswordField();
		cancelBtn = new JButton();
		loginBtn = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("登陆窗口");

		getContentPane().setLayout(new AbsoluteLayout());

		jPanel1.setLayout(new AbsoluteLayout());

		jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel1.setText("密码：");
		jPanel1.add(jLabel1, new AbsoluteConstraints(80, 210, 80, 50));

		jLabel2.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel2.setText("账户：");
		jPanel1.add(jLabel2, new AbsoluteConstraints(80, 130, 80, 50));

		jPanel1.add(loginName, new AbsoluteConstraints(150, 130, 210, 40));
		jPanel1.add(loginPwd, new AbsoluteConstraints(150, 210, 210, 50));

		loginBtn.setFont(new java.awt.Font("微软雅黑", 0, 18));
		loginBtn.setText("登陆");
		jPanel1.add(loginBtn, new AbsoluteConstraints(80, 320, 100, 40));
		cancelBtn.setFont(new java.awt.Font("微软雅黑", 0, 18));
		cancelBtn.setText("取消");
		jPanel1.add(cancelBtn, new AbsoluteConstraints(270, 320, 110, 40));

		getContentPane().add(jPanel1, new AbsoluteConstraints(0, 0, 490, 500));
		// 调整此窗口的大小，以适合其子组件的首选大小和布局。
		pack();

		// 登陆按钮
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int check = Login.checkLogin(loginName.getText(), String.valueOf(loginPwd.getPassword()));
				
				if(check == 0) {
					JOptionPane.showMessageDialog(null, "用户名不存在!","提示",JOptionPane.CANCEL_OPTION);
					
				}else if(check == 1) {
					JOptionPane.showMessageDialog(null, "密码不正确","提示",JOptionPane.CANCEL_OPTION);
				}else {
					User user = Login.getLoggedUser();
					String userType = user.getUserType();
					String adminType = TableProperties.tableStruct.getProperty("user.userType.admin");
					if(userType.equals(adminType)) {
						UserListFrame userListFrame = new UserListFrame();
						userListFrame.setLocationRelativeTo(null);
						userListFrame.setVisible(true);
					}else {
						AdviceListFrame adviceListFrame = new AdviceListFrame();
						adviceListFrame.setLocationRelativeTo(null);
						adviceListFrame.setVisible(true);
					}
						
						
							
					
//						case TableProperties.tableStruct.getProperty("user.userType.doctor"):{
//							AdviceListFrame adviceListFrame = new AdviceListFrame();
//							adviceListFrame.setLocationRelativeTo(null);
//							adviceListFrame.setVisible(true);
//							break;
//						}
//						case TableProperties.tableStruct.getProperty("user.userType.pharmacist") :{
//							
//							break;
//						}
//						case TableProperties.tableStruct.getProperty("user.userType.nurse") :{
//							AdviceListFrame adviceListFrame = new AdviceListFrame();
//							adviceListFrame.setLocationRelativeTo(null);
//							adviceListFrame.setVisible(true);
//							break;
//						}
						
//					}
				}
				
				// 根据用户类型判断进入不同页面
//				UserListFrame userListFrame = new UserListFrame();
//				userListFrame.setLocationRelativeTo(null);
//				userListFrame.setVisible(true);

				

				
			}
		});

		// 取消按钮，关闭程序
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				UserLoginFrame frame = new UserLoginFrame();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

}