package com.doctorAdvice.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.*;

public class DrugManageFrame extends JFrame {

	private JButton addBtn;
	private JButton cancelBtn;
	private JButton checkBtn;
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JTable jTable1;

	public DrugManageFrame() {
		initComponents();
	}

	private void initComponents() {

		jPanel1 = new JPanel();
		jScrollPane1 = new JScrollPane();
		jTable1 = new JTable();
		addBtn = new JButton();
		cancelBtn = new JButton();
		checkBtn = new JButton();

		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new AbsoluteLayout());

		jPanel1.setLayout(new AbsoluteLayout());

		jTable1.setModel(new DefaultTableModel(new Object[][] {
				{ "1", "阿莫西林", "云南", "盒", "999", "一日三盒" },
				{ "2", "板蓝根", "云南", "袋", "109", "一日一袋" },
				{ "3", "红霉素软膏", "云南", "盒", "200", "一日一盒" },
				{ "4", "牛黄解毒片", "云南", "盒", "499", "一日三盒" } }, new String[] {
				"序号", "药品名称", "药品产地", "药品规格", "药品库存", "药品备注" }));
		jScrollPane1.setViewportView(jTable1);

		jPanel1.add(jScrollPane1, new AbsoluteConstraints(40, 80, 620, 280));

		addBtn.setFont(new java.awt.Font("微软雅黑", 0, 18));
		addBtn.setText("新增药品入库");
		jPanel1.add(addBtn, new AbsoluteConstraints(420, 380, 150, 40));

		cancelBtn.setFont(new java.awt.Font("微软雅黑", 0, 18));
		cancelBtn.setText("取消返回");
		jPanel1.add(cancelBtn, new AbsoluteConstraints(100, 380, 120, 40));

		checkBtn.setFont(new java.awt.Font("微软雅黑", 0, 18));
		checkBtn.setText("检查超时");
		jPanel1.add(checkBtn, new AbsoluteConstraints(40, 20, 120, 40));

		getContentPane().add(jPanel1, new AbsoluteConstraints(10, 0, 690, 460));

		pack();

		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddDrugFrame addDrugFrame = new AddDrugFrame();
				addDrugFrame.setVisible(true);
				addDrugFrame.setLocationRelativeTo(null);
			}
		});
		cancelBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		checkBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});

	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				DrugManageFrame drugManageFrame = new DrugManageFrame();
				drugManageFrame.setVisible(true);
				drugManageFrame.setLocationRelativeTo(null);
			}
		});
	}

}