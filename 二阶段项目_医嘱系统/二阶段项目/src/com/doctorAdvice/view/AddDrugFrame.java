package com.doctorAdvice.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import org.netbeans.lib.awtextra.*;

public class AddDrugFrame extends JFrame {

	private JButton submitBtn;
	private JButton cancelBtn;
	private JLabel jLabel1;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JPanel jPanel1;
	private JScrollPane jScrollPane1;
	private JTextArea drugRemarkText;
	private JTextField drugNameText;
	private JTextField drugAreaText;
	private JTextField drugStandardText;
	private JTextField drugInventoryText;

	public AddDrugFrame() {
		initComponents();
	}

	private void initComponents() {

		jPanel1 = new JPanel();
		jLabel1 = new JLabel();
		drugNameText = new JTextField();
		jLabel2 = new JLabel();
		drugAreaText = new JTextField();
		jLabel3 = new JLabel();
		drugStandardText = new JTextField();
		jLabel4 = new JLabel();
		drugInventoryText = new JTextField();
		jLabel5 = new JLabel();
		jScrollPane1 = new JScrollPane();
		drugRemarkText = new JTextArea();
		submitBtn = new JButton();
		cancelBtn = new JButton();

		setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
		setTitle("ҩƷɫࠢ");

		jPanel1.setLayout(new AbsoluteLayout());

		jLabel1.setFont(new java.awt.Font("΢ɭ҅ۚ", 0, 18));
		jLabel1.setText("ĻԆú");
		jPanel1.add(jLabel1, new AbsoluteConstraints(100, 60, 60, 30));
		jPanel1.add(drugNameText, new AbsoluteConstraints(180, 60, 230, 30));

		jLabel2.setFont(new java.awt.Font("΢ɭ҅ۚ", 0, 18));
		jLabel2.setText("Ӻ֘ú");
		jPanel1.add(jLabel2, new AbsoluteConstraints(100, 110, 70, 30));
		jPanel1.add(drugAreaText, new AbsoluteConstraints(180, 110, 230, 30));

		jLabel3.setFont(new java.awt.Font("΢ɭ҅ۚ", 0, 18));
		jLabel3.setText("ڦٱú");
		jPanel1.add(jLabel3, new AbsoluteConstraints(100, 160, 60, 30));
		jPanel1.add(drugStandardText, new AbsoluteConstraints(180, 160, 230, 30));

		jLabel4.setFont(new java.awt.Font("΢ɭ҅ۚ", 0, 18));
		jLabel4.setText("ࠢզú");
		jPanel1.add(jLabel4, new AbsoluteConstraints(100, 200, 60, 50));
		jPanel1.add(drugInventoryText, new AbsoluteConstraints(180, 210, 230, 30));

		jLabel5.setFont(new java.awt.Font("΢ɭ҅ۚ", 0, 18));
		jLabel5.setText("Ѹעú");
		jPanel1.add(jLabel5, new AbsoluteConstraints(100, 260, 60, 40));

		drugRemarkText.setRows(5);
		jScrollPane1.setViewportView(drugRemarkText);

		jPanel1.add(jScrollPane1, new AbsoluteConstraints(180, 260, 230, 70));

		submitBtn.setFont(new java.awt.Font("΢ɭ҅ۚ", 0, 18));
		submitBtn.setText("т ն");
		jPanel1.add(submitBtn, new AbsoluteConstraints(90, 380, 100, 50));

		cancelBtn.setFont(new java.awt.Font("΢ɭ҅ۚ", 0, 18));
		cancelBtn.setText("ȡ л");
		jPanel1.add(cancelBtn, new AbsoluteConstraints(350, 380, 100, 50));

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addComponent(jPanel1,
				GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				GroupLayout.Alignment.LEADING).addComponent(jPanel1,
				GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE));
		pack();

		submitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO ҩƷͭݓ
				JOptionPane.showMessageDialog(null, "ҩƷͭݓԉ٦",
						"INFORMATION_MESSAGE", JOptionPane.INFORMATION_MESSAGE);
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
				 AddDrugFrame addDrugFrame = new AddDrugFrame();
				 addDrugFrame.setVisible(true);
				 addDrugFrame.setLocationRelativeTo(null);
			}
		});
	}

}