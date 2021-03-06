package com.doctorAdvice.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import com.doctorAdvice.common.TableProperties;
import com.doctorAdvice.entry.rowmapper.User;
import com.doctorAdvice.service.Doctor;
import com.doctorAdvice.service.Nurse;
import com.doctorAdvice.service.Pharmacist;

public class AdviceListFrame extends JFrame {
	private Doctor doctor = null;
	private Pharmacist pharm = null;
	private Nurse nurse = null;
	private JButton createBtn;
	private JButton detailBtn;
	private JButton drugManageBtn;
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JTable jTable1;
	private JButton upJButton;
	private JButton nextJButton;
	private int page = 1;

	public AdviceListFrame(User user) {
		String doctorType = TableProperties.tableStruct.getProperty("user.userType.doctor");
		String pharmType = TableProperties.tableStruct.getProperty("user.userType.pharmacist");
		String nurseType = TableProperties.tableStruct.getProperty("user.userType.nurse");
		
		if(doctorType.equals(user.getUserType())) {
			doctor = new Doctor(user);
		}else if(pharmType.equals(user.getUserType())) {
			pharm = new Pharmacist(user);
		}else {
			nurse = new Nurse(user);
		}
		initComponents();
	}
	
	public AdviceListFrame() {
		initComponents();
	}

	private void initComponents() {

		jPanel1 = new JPanel();
		jScrollPane1 = new JScrollPane();
		jTable1 = new JTable();
		createBtn = new JButton();
		detailBtn = new JButton();
		drugManageBtn = new JButton();
		upJButton = new JButton();
		nextJButton = new JButton();

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("医嘱列表");
		getContentPane().setLayout(new AbsoluteLayout());
		jPanel1.setLayout(new AbsoluteLayout());
		// 类型：创建医嘱-药房发药-取药成功
		
		
		String [][] value = null;
		if(doctor != null) {
			value = doctor.queryAllAdvice(page,5);
		}else if(pharm != null) {
			value = pharm.queryAllAdvice(page,5);
		}else if(nurse != null){
			value = nurse.queryAllAdvice(page,5);
		}else {
			
		}
				
		jTable1.setModel(new DefaultTableModel(value,
				new String[] { "序号", "病人姓名", "床位信息", "医嘱备注", "医嘱状态", "主治医生",
						"创建时间" }));
		jScrollPane1.setViewportView(jTable1);

		jPanel1.add(jScrollPane1, new AbsoluteConstraints(20, 40, 620, 330));
		
		createBtn.setFont(new java.awt.Font("微软雅黑", 0, 18));
			createBtn.setText("创建医嘱");
		if(doctor != null) {
			jPanel1.add(createBtn, new AbsoluteConstraints(680, 80, 110, 30));
		}
				
		detailBtn.setFont(new java.awt.Font("微软雅黑", 0, 18));
		detailBtn.setText("查看详情");
		jPanel1.add(detailBtn, new AbsoluteConstraints(680, 180, 110, 30));

		drugManageBtn.setFont(new java.awt.Font("微软雅黑", 0, 18));
		drugManageBtn.setText("药品管理");
		if(pharm != null) {
			jPanel1.add(drugManageBtn, new AbsoluteConstraints(680, 280, 110, 30));
		}
		

		upJButton.setFont(new java.awt.Font("微软雅黑", 0, 18));
		upJButton.setText("上一页");
		jPanel1.add(upJButton, new AbsoluteConstraints(150, 390, 100, 30));

		nextJButton.setFont(new java.awt.Font("微软雅黑", 0, 18));
		nextJButton.setText("下一页");
		jPanel1.add(nextJButton, new AbsoluteConstraints(350, 390, 100, 30));

		getContentPane()
				.add(jPanel1, new AbsoluteConstraints(20, 10, 820, 530));
		pack();

		createBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddAdviceFrame addAdviceFrame = new AddAdviceFrame(doctor);
				addAdviceFrame.setLocationRelativeTo(null);
				addAdviceFrame.setVisible(true);
			}
		});

		detailBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdviceDetailFrame adviceDetailFrame = new AdviceDetailFrame();
				adviceDetailFrame.setLocationRelativeTo(null);
				adviceDetailFrame.setVisible(true);
			}
		});

		drugManageBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DrugManageFrame drugManageFrame = new DrugManageFrame();
				drugManageFrame.setVisible(true);
				drugManageFrame.setLocationRelativeTo(null);
			}
		});
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				AdviceListFrame adviceListFrame = new AdviceListFrame();
				adviceListFrame.setLocationRelativeTo(null);
				adviceListFrame.setVisible(true);
			}
		});
	}

}