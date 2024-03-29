package com.manager.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.manager.domain.Administrator;
import com.manager.domain.Merchant;
import com.manager.frame.admin.AdminMenu;
import com.manager.frame.merchant.MerchantMenu;
import com.manager.mapper.LoginMapper;
import com.manager.mapper.SqlSessionUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField usernameText;
	private JPasswordField passwordField;
	private JRadioButton user;
	private JRadioButton admin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 273, 211);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel usernameLabel = new JLabel("用户名");
		usernameLabel.setBounds(20, 20, 49, 22);
		contentPane.add(usernameLabel);
		
		JLabel pwdLabel = new JLabel("密码");
		pwdLabel.setBounds(20, 55, 49, 22);
		contentPane.add(pwdLabel);
		
		usernameText = new JTextField();
		usernameText.setBounds(79, 21, 132, 22);
		contentPane.add(usernameText);
		usernameText.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(79, 56, 132, 21);
		contentPane.add(passwordField);
		
		user = new JRadioButton("商家登陆");
		user.setSelected(true);
		user.setBounds(20, 98, 93, 23);
		contentPane.add(user);
		
		admin = new JRadioButton("管理员登陆");
		admin.setBounds(132, 98, 103, 23);
		contentPane.add(admin);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(user);
		bg.add(admin);
		
		JButton loginButton = new JButton("登陆");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SqlSession session = SqlSessionUtil.getSqlSession();
				LoginMapper mapper = session.getMapper(LoginMapper.class);
				
				if(usernameText.getText()==null) {
					JOptionPane.showMessageDialog(contentPane, "请输入账号", "请输入账号",
							JOptionPane.WARNING_MESSAGE);
				}else {
					if(user.isSelected()&&!admin.isSelected()) {
						Merchant mer = mapper.merchantLogin(usernameText.getText(), 
								new String(passwordField.getPassword()));
						if(mer==null) {
							JOptionPane.showMessageDialog(contentPane, "用户名或密码错误", "错误",
									JOptionPane.WARNING_MESSAGE);
						}else {
							MerchantMenu m = new MerchantMenu(mer);
							m.setVisible(true);
							dispose();
						}
					}else if(!user.isSelected()&&admin.isSelected()) {
						Administrator admin = mapper.adminLogin(usernameText.getText(), 
								new String(passwordField.getPassword()));
						if(admin==null) {
							JOptionPane.showMessageDialog(contentPane, "用户名或密码错误", "错误",
									JOptionPane.WARNING_MESSAGE);
						}else {
							AdminMenu m = new AdminMenu(admin);
							m.setVisible(true);
							dispose();
						}
					}else {
						
					}
				}
				
				
				
			}
		});
		loginButton.setBounds(20, 127, 93, 23);
		contentPane.add(loginButton);
		
		JButton closeButton = new JButton("取消");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		closeButton.setBounds(132, 127, 93, 23);
		contentPane.add(closeButton);
	}
}
