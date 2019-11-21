package com.manager.frame.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.manager.domain.Commodity;
import com.manager.domain.Merchant;
import com.manager.frame.merchant.OrderSelectForTopTen;
import com.manager.mapper.SqlSessionUtil;
import com.manager.mapper.TransactionMapper;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;

public class OrderAction extends JFrame {

	private JPanel contentPane;
	
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private JRadioButton radioButton_2;
	
	private JRadioButton radioButton_3;
	private JRadioButton radioButton_4;
	private JRadioButton rdbtnNewRadioButton_1;
	private JRadioButton radioButton_5;
	private JRadioButton radioButton_6;

	/**
	 * Create the frame.
	 */
	public OrderAction() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 270, 216);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					OrderSelectForTime ot = new OrderSelectForTime();
					ot.setVisible(true);
				}else if(radioButton.isSelected()) {
					OrderSelectForClass oc = new OrderSelectForClass();
					oc.setVisible(true);
				}else if(radioButton_1.isSelected()) {
					TransactionMapper mapper = SqlSessionUtil.getSqlSession().getMapper(TransactionMapper.class);
					List<Commodity> res = mapper.selectTopTenSalesCommoditys();
					OrderSelectForTopTen ott = new OrderSelectForTopTen(res);
					ott.setVisible(true);
				}else if(radioButton_2.isSelected()){
					TransactionMapper mapper = SqlSessionUtil.getSqlSession().getMapper(TransactionMapper.class);
					List<Commodity> res = mapper.selectTopTenItemsCommoditys(10);
					OrderSelectForTopTen ott = new OrderSelectForTopTen(res);
					ott.setVisible(true);
				}else if(radioButton_3.isSelected()){
					OrderSelectForMerchant om = new OrderSelectForMerchant();
					om.setVisible(true);
				}else if(radioButton_4.isSelected()){
					
					OrderSelectForTopTenMerchant ottm = new OrderSelectForTopTenMerchant();
					ottm.setVisible(true);
				}else if(radioButton_5.isSelected()){
					OrderSelectForOneDay ood = new OrderSelectForOneDay();
					ood.setVisible(true);
				}else if(radioButton_6.isSelected()){
					OrderSelectForTopTenUser ottu = new OrderSelectForTopTenUser();
					ottu.setVisible(true);
				}else {
					OrderSelectForEveryMonth oem = new OrderSelectForEveryMonth();
					oem.setVisible(true);
				}
			}
		});
		button.setBounds(90, 144, 64, 23);
		contentPane.add(button);
		
		rdbtnNewRadioButton = new JRadioButton("按时间段查询");
		rdbtnNewRadioButton.setBounds(10, 6, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		radioButton = new JRadioButton("按类别查询");
		radioButton.setBounds(121, 6, 89, 23);
		contentPane.add(radioButton);
		
		radioButton_1 = new JRadioButton("查询热门商品");
		radioButton_1.setBounds(10, 31, 109, 23);
		contentPane.add(radioButton_1);
		
		radioButton_2 = new JRadioButton("查询好评商品");
		radioButton_2.setBounds(121, 31, 109, 23);
		contentPane.add(radioButton_2);
		
		
		radioButton_3 = new JRadioButton("按商家查询");
		radioButton_3.setBounds(10, 56, 109, 23);
		contentPane.add(radioButton_3);
		
		radioButton_4 = new JRadioButton("查询热门商家");
		radioButton_4.setBounds(121, 56, 109, 23);
		contentPane.add(radioButton_4);
		
		rdbtnNewRadioButton_1 = new JRadioButton("每月订单分布");
		rdbtnNewRadioButton_1.setBounds(10, 81, 109, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		
		radioButton_5 = new JRadioButton("24小时订单分布");
		radioButton_5.setBounds(121, 81, 121, 23);
		contentPane.add(radioButton_5);
		
		
		radioButton_6 = new JRadioButton("查询活跃用户");
		radioButton_6.setBounds(10, 106, 109, 23);
		contentPane.add(radioButton_6);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(radioButton);
		bg.add(radioButton_1);
		bg.add(radioButton_2);
		bg.add(radioButton_3);
		bg.add(radioButton_4);
		bg.add(radioButton_5);
		bg.add(radioButton_6);
		bg.add(rdbtnNewRadioButton_1);
		
	}
}
