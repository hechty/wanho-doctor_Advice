package com.doctorAdvice.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import org.netbeans.lib.awtextra.*;

public class DrugListFrame extends JFrame {

	private JTextField searchField;
	private JButton searchBtn;
	private JButton addBtn;
	private JButton cancelBtn;
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JTable jTable1;

	public DrugListFrame() {
		initComponents();
	}

	private void initComponents() {
		searchField = new JTextField();
		searchBtn = new JButton();
		jPanel1 = new JPanel();
		jScrollPane1 = new JScrollPane();
		jTable1 = new JTable();
		addBtn = new JButton();
		cancelBtn = new JButton();

		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setTitle("药品管理");
		getContentPane().setLayout(new AbsoluteLayout());

		jPanel1.setLayout(new AbsoluteLayout());
		
		jPanel1.add(searchField, new AbsoluteConstraints(20, 20, 400, 30));
		
		searchBtn.setFont(new java.awt.Font("微软雅黑", 0, 18));
		searchBtn.setText("搜索");
		jPanel1.add(searchBtn, new AbsoluteConstraints(430, 20, 80, 30));
		
		jTable1.setAutoCreateRowSorter(true);
		jTable1.setModel(new DefaultTableModel(new Object[][] {
				{ "1", "阿莫西林", "云南", "盒", "999", "一日三盒" },
				{ "2", "板蓝根", "云南", "袋", "109", "一日一袋" },
				{ "3", "毓婷", "云南", "盒", "200", "一日一盒" },
				{ "4", "云南白药", "云南", "盒", "499", "一日三盒" } }, new String[] {
				"序号", "药品名称", "药品产地", "药品规格", "药品库存", "药品备注" }));
		jScrollPane1.setViewportView(jTable1);

		jPanel1.add(jScrollPane1, new AbsoluteConstraints(20, 60, 600, 260));

		addBtn.setFont(new java.awt.Font("微软雅黑", 0, 18));
		addBtn.setText("确认添加");
		jPanel1.add(addBtn, new AbsoluteConstraints(100, 340, 110, 50));

		cancelBtn.setFont(new java.awt.Font("微软雅黑", 0, 18));
		cancelBtn.setText("取消");
		jPanel1.add(cancelBtn, new AbsoluteConstraints(390, 340, 100, 50));

		getContentPane().add(jPanel1, new AbsoluteConstraints(0, 0, 650, 450));
		pack();
		
		searchBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		addBtn.addActionListener(new ActionListener() {
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
				DrugListFrame drugListFrame = new DrugListFrame();
				drugListFrame.setVisible(true);
				drugListFrame.setLocationRelativeTo(null);
			}
		});
	}

}