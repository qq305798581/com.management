package com.manager.frame.merchant;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.manager.domain.Merchant;

public class MerchantMenu extends JFrame {

	private JPanel contentPane;

	

	/**
	 * Create the frame.
	 */
	public MerchantMenu(Merchant merchant) {
		setTitle("Merchant Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 304, 234);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel welcom = new JLabel("欢迎回来：");
		welcom.setBounds(30, 81, 77, 15);
		contentPane.add(welcom);
		
		JLabel username = new JLabel(merchant.getName());
		username.setBounds(30, 110, 54, 50);
		contentPane.add(username);
		
		JButton commodity = new JButton("商品管理");
		commodity.setBounds(159, 38, 93, 23);
		contentPane.add(commodity);
		
		JButton user = new JButton("用户管理");
		user.setBounds(159, 71, 93, 23);
		contentPane.add(user);
		
		JButton oder = new JButton("订单管理");
		oder.setBounds(159, 110, 93, 23);
		contentPane.add(oder);
		
		JButton exit = new JButton("退出");
		exit.setBounds(159, 143, 93, 23);
		contentPane.add(exit);
	}

}
