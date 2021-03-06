package com.manager.frame.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.ibatis.session.SqlSession;

import com.manager.domain.Administrator;

import javax.swing.JButton;
import java.awt.Button;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminMenu extends JFrame {

	private JPanel contentPane;
	private Administrator administrator;
	/**
	 * Create the frame.
	 */
	public AdminMenu(Administrator admin) {
		setTitle("Administrator Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.administrator = admin;
		
		JLabel welcom = new JLabel("欢迎回来：");
		welcom.setBounds(30, 81, 77, 15);
		contentPane.add(welcom);
		
		JLabel username = new JLabel(admin.getANAme());
		username.setBounds(30, 110, 54, 50);
		contentPane.add(username);
		
		JButton commodity = new JButton("商品管理");
		commodity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CommodityMenu commodity = new CommodityMenu(administrator);
				commodity.setVisible(true);
			}
		});
		commodity.setBounds(159, 38, 93, 23);
		contentPane.add(commodity);
		
		JButton user = new JButton("用户管理");
		user.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserMenu m = new UserMenu();
				m.setVisible(true);
			}
		});
		user.setBounds(159, 71, 93, 23);
		contentPane.add(user);
		
		JButton category = new JButton("类别管理");
		category.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CategoryMenu cm  = new CategoryMenu();
				cm.setVisible(true);
			}
		});
		category.setBounds(159, 104, 93, 23);
		contentPane.add(category);
		
		JButton merchant = new JButton("商家管理");
		merchant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MerchantMenu mm = new MerchantMenu();
				mm.setVisible(true);
			}
		});
		merchant.setBounds(159, 137, 93, 23);
		contentPane.add(merchant);
		
		JButton oder = new JButton("订单查询");
		oder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderAction oc = new OrderAction();
				oc.setVisible(true);
			}
		});
		oder.setBounds(159, 170, 93, 23);
		contentPane.add(oder);
		
		JButton exit = new JButton("退出");
		exit.setBounds(159, 203, 93, 23);
		contentPane.add(exit);
	}
}
