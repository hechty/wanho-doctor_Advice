package com.doctorAdvice.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

@SuppressWarnings("serial")
public class AddAdviceFrame extends JFrame {

	private JButton addBtn;
	private JButton deleteBtn;
	private JButton cancelBtn;
	private JButton configBtn;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JScrollPane jScrollPane2;
	private JTable jTable1;
	private JTextArea adviceRemarkText;
	private JTextField bedDetailText;
	private JTextField patientNameText;

	public AddAdviceFrame() {
		initComponents();
	}

	private void initComponents() {

		jPanel1 = new JPanel();
		jScrollPane1 = new JScrollPane();
		jTable1 = new JTable();
		cancelBtn = new JButton();
		configBtn = new JButton();
		jScrollPane2 = new JScrollPane();
		adviceRemarkText = new JTextArea();
		jLabel3 = new JLabel();
		patientNameText = new JTextField();
		jLabel1 = new JLabel();
		bedDetailText = new JTextField();
		jLabel2 = new JLabel();
		addBtn = new JButton();
		deleteBtn = new JButton();

		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setTitle("新建医嘱");
		getContentPane().setLayout(new AbsoluteLayout());

		jPanel1.setLayout(new AbsoluteLayout());

		jPanel1.add(jScrollPane1, new AbsoluteConstraints(80, 210, -1, 230));

		cancelBtn.setFont(new java.awt.Font("微软雅黑", 0, 18));
		cancelBtn.setText("取消");
		jPanel1.add(cancelBtn, new AbsoluteConstraints(360, 470, 130, 40));

		configBtn.setFont(new java.awt.Font("微软雅黑", 0, 18));
		configBtn.setText("确认");
		jPanel1.add(configBtn, new AbsoluteConstraints(130, 470, 130, 40));

		jScrollPane2.setViewportView(adviceRemarkText);
		jPanel1.add(jScrollPane2, new AbsoluteConstraints(200, 120, 230, 70));

		jLabel2.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel2.setText("床位信息：");
		jPanel1.add(jLabel2, new AbsoluteConstraints(90, 40, -1, -1));
		jPanel1.add(bedDetailText, new AbsoluteConstraints(200, 40, 230, 30));

		jLabel1.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel1.setText("病人姓名：");
		jPanel1.add(jLabel1, new AbsoluteConstraints(90, 80, -1, -1));
		jPanel1.add(patientNameText, new AbsoluteConstraints(200, 80, 230, 30));

		jLabel3.setFont(new java.awt.Font("微软雅黑", 0, 18));
		jLabel3.setText("备    注：");
		jPanel1.add(jLabel3, new AbsoluteConstraints(100, 140, -1, -1));

		addBtn.setFont(new java.awt.Font("微软雅黑", 0, 14));
		addBtn.setText("添加药品");
		jPanel1.add(addBtn, new AbsoluteConstraints(550, 320, -1, -1));

		deleteBtn.setFont(new java.awt.Font("微软雅黑", 0, 14));
		deleteBtn.setText("删除药品");
		jPanel1.add(deleteBtn, new AbsoluteConstraints(550, 400, -1, -1));

		jTable1.setModel(new DefaultTableModel(new Object[][] {}, new String[] {
				"序号", "名称", "数量" }));
		jScrollPane1.setViewportView(jTable1);

		jTable1.setModel(new DefaultTableModel(new Object[][] {
				{ 1, "阿莫西林", 10 }, { 2, "板蓝根", 5 } }, new String[] { "序号",
				"名称", "数量" }));
		jScrollPane1.setViewportView(jTable1);

		getContentPane().add(jPanel1, new AbsoluteConstraints(0, 20, 690, 540));
		pack();

		addBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DrugListFrame drugListFrame = new DrugListFrame();
				drugListFrame.setLocationRelativeTo(null);
				drugListFrame.setVisible(true);
			}
		});

	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				AddAdviceFrame addAdviceFrame = new AddAdviceFrame();
				addAdviceFrame.setLocationRelativeTo(null);
				addAdviceFrame.setVisible(true);
			}
		});
	}
}