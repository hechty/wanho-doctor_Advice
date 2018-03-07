package com.doctorAdvice.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import org.netbeans.lib.awtextra.*;

public class AdviceDetailFrame extends JFrame {
	
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JTable jTable1;
	
	private JTextField jTextField1;
	private JTextField jTextField2;
	private JTextField jTextField3;
	private JTextArea jTextArea1;
	private JTextArea jTextArea2;
	
	private JButton returnBtn;
	private JButton configBtn;

	public AdviceDetailFrame() {
		initComponents();
	}

	private void initComponents() {

		jPanel1 = new JPanel();
		jLabel2 = new JLabel();
		jLabel1 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jTextField1 = new JTextField();
		jTextField2 = new JTextField();
		jTextField3 = new JTextField();
		
		jTextArea1 = new JTextArea();
		jTextArea2 = new JTextArea();
		
		jScrollPane1 = new JScrollPane();
		jTable1 = new JTable();
		
		configBtn = new JButton();
		returnBtn = new JButton();

		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setTitle("医嘱详情");
		getContentPane().setLayout(new AbsoluteLayout());

		jPanel1.setLayout(new AbsoluteLayout());
		
		jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel1.setText("床位信息：");
		jPanel1.add(jLabel1, new AbsoluteConstraints(130, 30, -1, -1));

		jLabel2.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel2.setText("病人姓名：");
		jPanel1.add(jLabel2, new AbsoluteConstraints(130, 70, -1, -1));
		
		jLabel3.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel3.setText("医嘱备注：");
		jPanel1.add(jLabel3, new AbsoluteConstraints(130, 120, -1, -1));
		
		jLabel4.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel4.setText("医嘱状态:");
		jPanel1.add(jLabel4, new AbsoluteConstraints(130, 190, -1, -1));
		
		
		
		jPanel1.add(jTextField1, new AbsoluteConstraints(240, 30, 230, 30));
		jPanel1.add(jTextField2, new AbsoluteConstraints(240, 70, 230, 30));
		jPanel1.add(jTextField3, new AbsoluteConstraints(240, 190, 230, 30));
		jPanel1.add(jTextArea1, new AbsoluteConstraints(240, 110, 230, 70));
		
		jTextField1.setEnabled(false);
		jTextField2.setEnabled(false);
		jTextField3.setEnabled(false);
		jTextArea1.setEditable(false);
		
		jTable1.setModel(new DefaultTableModel(new Object[][] {
				{ "1", "aaa", "20" }, { "2", "bbbbbb", "30" },
				{ "3", "ccc", "10" }, { "4", "ddd", "2" } }, new String[] {
				"序号", "名称", "数量" }));
		jTable1.setEnabled(false);
		jScrollPane1.setViewportView(jTable1);
		jPanel1.add(jScrollPane1, new AbsoluteConstraints(90, 230, 450, 220));

		configBtn.setFont(new java.awt.Font("微软雅黑", 0, 18));
		configBtn.setText("确认无误");
		jPanel1.add(configBtn, new AbsoluteConstraints(150, 460, 130, 40));

		returnBtn.setFont(new java.awt.Font("微软雅黑", 0, 18));
		returnBtn.setText("错误打回");
		jPanel1.add(returnBtn, new AbsoluteConstraints(320, 460, 130, 40));
		
		jLabel5.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel5.setText("打回原因（备注）:");
		jPanel1.add(jLabel5, new AbsoluteConstraints(150, 550, -1, -1));
		
		jPanel1.add(jTextArea2, new AbsoluteConstraints(320, 520, 230, 70));

		getContentPane().add(jPanel1, new AbsoluteConstraints(10, 0, 630, 600));

		pack();

		configBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		returnBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
//				AdviceDetailFrame adviceDetailFrame = new AdviceDetailFrame();
//				adviceDetailFrame.setVisible(true);
//				adviceDetailFrame.setLocationRelativeTo(null);
			}
		});
	}

}