package com.manager.frame.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.ibatis.session.SqlSession;

import com.manager.domain.Commodity;
import com.manager.mapper.CommodityMapper;
import com.manager.mapper.MerchantMapper;
import com.manager.mapper.SqlSessionUtil;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CommodityShow extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField description;
	private JTextField prise;
	private JTextField merchantAccount;
	private JLabel warning;
	
	private SqlSession session;
	private boolean isMerchantExist;
	private Integer merchantId;

	

	/**
	 * Create the frame.
	 */
	public CommodityShow(Commodity res) {
		session = SqlSessionUtil.getSqlSession();
		
		setTitle("商品详情");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 313, 313);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		name = new JTextField();
		name.setEnabled(false);
		name.setBounds(74, 10, 213, 21);
		name.setText(res.getPName());
		contentPane.add(name);
		name.setColumns(10);
		
		description = new JTextField();
		description.setEnabled(false);
		description.setColumns(10);
		description.setBounds(74, 136, 213, 125);
		description.setText(res.getPDescribe());
		contentPane.add(description);
		
		prise = new JTextField();
		prise.setEnabled(false);
		prise.setColumns(10);
		prise.setBounds(74, 41, 213, 21);
		prise.setText(String.valueOf(res.getPPrise()));
		contentPane.add(prise);
		
		JComboBox firstClass = new JComboBox();
		firstClass.setEnabled(false);
		firstClass.setBounds(74, 105, 103, 21);
		contentPane.add(firstClass);
		
		JComboBox secondClass = new JComboBox();
		secondClass.setEnabled(false);
		secondClass.setBounds(194, 105, 93, 21);
		contentPane.add(secondClass);
		
		JLabel lblNewLabel = new JLabel("商品名称");
		lblNewLabel.setBounds(10, 13, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("价格");
		label.setBounds(10, 44, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("所属类别");
		label_1.setBounds(10, 108, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("商品描述");
		label_2.setBounds(10, 191, 54, 15);
		contentPane.add(label_2);
		
		merchantAccount = new JTextField();
		merchantAccount.setEnabled(false);
		merchantAccount.setBounds(74, 72, 125, 21);
		merchantAccount.setText(session.getMapper(MerchantMapper.class).selectAccountById(res.getMId()));
		contentPane.add(merchantAccount);
		merchantAccount.setColumns(10);
		
		JLabel label_3 = new JLabel("商家账号");
		label_3.setBounds(10, 75, 54, 15);
		contentPane.add(label_3);
		
		warning = new JLabel("");
		warning.setForeground(Color.RED);
		warning.setBounds(209, 72, 78, 21);
		contentPane.add(warning);
	}


}