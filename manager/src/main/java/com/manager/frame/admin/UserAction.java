package com.manager.frame.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.manager.domain.User;
import com.manager.mapper.SqlSessionUtil;
import com.manager.mapper.UserMapper;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserAction extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	
	private User usr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserAction frame = new UserAction();
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
	public UserAction() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 218, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(70, 10, 98, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setBounds(23, 13, 54, 15);
		contentPane.add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(70, 39, 98, 21);

		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(70, 70, 98, 21);

		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(70, 101, 98, 21);
		contentPane.add(textField_3);

		label = new JLabel("手机号");
		label.setBounds(23, 41, 54, 15);
		contentPane.add(label);

		label_1 = new JLabel("密码");
		label_1.setBounds(23, 73, 54, 15);
		contentPane.add(label_1);

		label_2 = new JLabel("性别");
		label_2.setBounds(23, 104, 54, 15);
		contentPane.add(label_2);

		JButton btnNewButton = new JButton("提交");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(SqlSessionUtil.getSqlSession().getMapper(UserMapper.class).selectUserByTele(textField_1.getText())==null) {
					User user = new User();
					user.setUName(textField.getText());
					user.setUPasswd(textField_2.getText());
					user.setUSex(textField_3.getText());
					user.setUTele(textField_1.getText());
					SqlSessionUtil.getSqlSession().getMapper(UserMapper.class).addUser(user);
					SqlSessionUtil.getSqlSession().commit();
					JOptionPane.showMessageDialog(contentPane, "添加成功", "成功",
							JOptionPane.OK_OPTION);
					dispose();
				}else {
					JOptionPane.showMessageDialog(contentPane, "该用户已存在", "错误",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(52, 132, 93, 23);
		contentPane.add(btnNewButton);
	}

	public UserAction(User user) {
		this.usr = user;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 218, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(70, 10, 98, 21);
		textField.setText(user.getUName());
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setBounds(23, 13, 54, 15);
		contentPane.add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(70, 39, 98, 21);
		textField_1.setEditable(false);
		textField_1.setText(user.getUTele());
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(70, 70, 98, 21);
		textField_2.setText(user.getUPasswd());
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(70, 101, 98, 21);
		textField_3.setText(user.getUSex());
		contentPane.add(textField_3);

		label = new JLabel("手机号");
		label.setBounds(23, 41, 54, 15);
		contentPane.add(label);

		label_1 = new JLabel("密码");
		label_1.setBounds(23, 73, 54, 15);
		contentPane.add(label_1);

		label_2 = new JLabel("性别");
		label_2.setBounds(23, 104, 54, 15);
		contentPane.add(label_2);

		JButton btnNewButton = new JButton("提交");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				User user = new User();
				user.setUName(textField.getText());
				user.setUPasswd(textField_2.getText());
				user.setUSex(textField_3.getText());
				user.setUTele(textField_1.getText());
				user.setUId(usr.getUId());
				SqlSessionUtil.getSqlSession().getMapper(UserMapper.class).updateInfo(user);;
				SqlSessionUtil.getSqlSession().commit();
				JOptionPane.showMessageDialog(contentPane, "修改成功", "成功",
						JOptionPane.OK_OPTION);
			}
		});
		btnNewButton.setBounds(52, 132, 93, 23);
		contentPane.add(btnNewButton);
	}

	public UserAction(User user,boolean isShow) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 218, 215);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(70, 10, 98, 21);
		textField.setText(user.getUName());
		textField.setEditable(false);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setBounds(23, 13, 54, 15);
		contentPane.add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(70, 39, 98, 21);
		textField_1.setEditable(false);
		textField_1.setText(user.getUTele());
		contentPane.add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(70, 70, 98, 21);
		textField_2.setEditable(false);
		textField_2.setText(user.getUPasswd());
		contentPane.add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(70, 101, 98, 21);
		textField_3.setEditable(false);
		textField_3.setText(user.getUSex());
		contentPane.add(textField_3);

		label = new JLabel("手机号");
		label.setBounds(23, 41, 54, 15);
		contentPane.add(label);

		label_1 = new JLabel("密码");
		label_1.setBounds(23, 73, 54, 15);
		contentPane.add(label_1);

		label_2 = new JLabel("性别");
		label_2.setBounds(23, 104, 54, 15);
		contentPane.add(label_2);


	}
}
