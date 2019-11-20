package com.manager.frame.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.ibatis.session.SqlSession;

import com.manager.domain.Merchant;
import com.manager.mapper.MerchantMapper;
import com.manager.mapper.SqlSessionUtil;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class MerchantAction extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JPasswordField passwordField;

	private Merchant mer;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MerchantAction frame = new MerchantAction();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MerchantAction() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 227, 204);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(84, 7, 105, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("商家名称");
		label.setBounds(10, 10, 64, 15);
		contentPane.add(label);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(84, 38, 105, 21);
		contentPane.add(textField_1);

		JLabel label_1 = new JLabel("商家账号");
		label_1.setBounds(10, 41, 64, 15);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("商家密码");
		label_2.setBounds(10, 72, 64, 15);
		contentPane.add(label_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(84, 100, 105, 21);
		contentPane.add(textField_3);

		JLabel label_3 = new JLabel("商家电话");
		label_3.setBounds(10, 103, 64, 15);
		contentPane.add(label_3);

		passwordField = new JPasswordField();
		passwordField.setBounds(84, 69, 105, 21);
		contentPane.add(passwordField);

		JButton button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SqlSession session = SqlSessionUtil.getSqlSession();
				MerchantMapper mapper = session.getMapper(MerchantMapper.class);
				Merchant mer = new Merchant();
				mer.setMName(textField.getText());
				mer.setMAccount(textField_1.getText());
				mer.setMPasswd(new String(passwordField.getPassword()));
				mer.setMPhone(textField_3.getText());
				try {
					if(mapper.addMerchant(mer)==1) {
						JOptionPane.showMessageDialog(contentPane, "添加成功", "成功",
								JOptionPane.OK_OPTION);
						session.commit();
						dispose();
					}else {
						JOptionPane.showMessageDialog(contentPane, "添加失败", "错误",
								JOptionPane.WARNING_MESSAGE);
					}
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(contentPane, "添加失败", "错误",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button.setBounds(55, 131, 93, 23);
		contentPane.add(button);


	}

	public MerchantAction(Merchant merchant) {
		this.mer = merchant;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 227, 204);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(84, 7, 105, 21);
		textField.setText(mer.getMName());
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("商家名称");
		label.setBounds(10, 10, 64, 15);
		contentPane.add(label);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(84, 38, 105, 21);
		textField_1.setEnabled(false);
		textField_1.setText(mer.getMAccount());
		contentPane.add(textField_1);

		JLabel label_1 = new JLabel("商家账号");
		label_1.setBounds(10, 41, 64, 15);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("商家密码");
		label_2.setBounds(10, 72, 64, 15);
		contentPane.add(label_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(84, 100, 105, 21);
		textField_3.setText(mer.getMPhone());
		contentPane.add(textField_3);

		JLabel label_3 = new JLabel("商家电话");
		label_3.setBounds(10, 103, 64, 15);
		contentPane.add(label_3);

		passwordField = new JPasswordField();
		passwordField.setBounds(84, 69, 105, 21);
		passwordField.setEnabled(false);
		passwordField.setText(mer.getMPasswd());
		contentPane.add(passwordField);

		JButton button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SqlSession session = SqlSessionUtil.getSqlSession();
				MerchantMapper mapper = session.getMapper(MerchantMapper.class);
				Merchant merc = new Merchant();
				merc.setMName(textField.getText());
				merc.setMAccount(textField_1.getText());
				merc.setMPasswd(new String(passwordField.getPassword()));
				merc.setMPhone(textField_3.getText());
				merc.setMId(mer.getMId());
				
				try {
					mapper.updateMerchant(merc);
					JOptionPane.showMessageDialog(contentPane, "修改成功", "成功",
							JOptionPane.OK_OPTION);
					session.commit();
					dispose();
				}catch(Exception e1) {
					System.out.print(e1);
					JOptionPane.showMessageDialog(contentPane, "修改失败", "错误",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		button.setBounds(55, 131, 93, 23);
		contentPane.add(button);


	}

	public MerchantAction(Merchant merchant,boolean isShow) {
		this.mer = merchant;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 227, 204);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(84, 7, 105, 21);
		textField.setText(mer.getMName());
		textField.setEnabled(false);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("商家名称");
		label.setBounds(10, 10, 64, 15);
		contentPane.add(label);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(84, 38, 105, 21);
		textField_1.setEnabled(false);
		textField_1.setText(mer.getMAccount());
		contentPane.add(textField_1);

		JLabel label_1 = new JLabel("商家账号");
		label_1.setBounds(10, 41, 64, 15);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("商家密码");
		label_2.setBounds(10, 72, 64, 15);
		contentPane.add(label_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(84, 100, 105, 21);
		textField_3.setText(mer.getMPhone());
		textField_3.setEnabled(false);
		contentPane.add(textField_3);

		JLabel label_3 = new JLabel("商家电话");
		label_3.setBounds(10, 103, 64, 15);
		contentPane.add(label_3);

		passwordField = new JPasswordField();
		passwordField.setBounds(84, 69, 105, 21);
		passwordField.setEnabled(false);
		passwordField.setText(mer.getMPasswd());
		passwordField.setEnabled(false);
		contentPane.add(passwordField);



	}
}
