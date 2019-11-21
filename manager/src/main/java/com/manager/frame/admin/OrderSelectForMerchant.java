package com.manager.frame.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import org.apache.ibatis.session.SqlSession;

import com.manager.domain.FirstClass;
import com.manager.domain.Merchant;
import com.manager.domain.SecondClass;
import com.manager.mapper.ClassMapper;
import com.manager.mapper.MerchantMapper;
import com.manager.mapper.SqlSessionUtil;
import com.manager.mapper.TransactionMapper;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class OrderSelectForMerchant extends JFrame {

	private JPanel contentPane;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton radioButton;
	

	private SqlSession session = SqlSessionUtil.getSqlSession();
	
	List<FirstClass> fl = session.getMapper(ClassMapper.class).getFirstClass();
	List<SecondClass> sl = session.getMapper(ClassMapper.class).getSecondClass();
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel label;
	
	private int merchantId;
	private boolean isMerchantExist;
	/**
	 * Create the frame.
	 */
	public OrderSelectForMerchant() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 351, 130);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		rdbtnNewRadioButton = new JRadioButton("订单数量");
		rdbtnNewRadioButton.setBounds(56, 34, 93, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		radioButton = new JRadioButton("订单金额");
		radioButton.setBounds(192, 34, 93, 23);
		contentPane.add(radioButton);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(radioButton);
		
		JButton btnNewButton = new JButton("查找");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isMerchantExist) {
					TransactionMapper mapper = session.getMapper(TransactionMapper.class);
					if(rdbtnNewRadioButton.isSelected()) {
						long res = mapper.selectOrderQuantityByMerchant(merchantId);
						JOptionPane.showMessageDialog(contentPane, "该段时间内订单数量为"+res, "",
								JOptionPane.INFORMATION_MESSAGE);
					}else {
						long res = mapper.selectOrderAmountByMerchant(merchantId);
						JOptionPane.showMessageDialog(contentPane, "该段时间内订单金额为"+res, "",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setBounds(118, 63, 93, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("请输入商家账号");
		lblNewLabel.setBounds(10, 10, 93, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(113, 7, 124, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addFocusListener(new FocusListener(){

			public void focusGained(FocusEvent e) {
			}

			public void focusLost(FocusEvent e) {
				if(textField.getText()!="") {
					MerchantMapper mapper = session.getMapper(MerchantMapper.class);
					Integer temp = mapper.selectIdByAccount(textField.getText());
					if(temp==null) {
						label.setText("账号不存在");
						isMerchantExist = false;
					}else {
						label.setText("");
						isMerchantExist = true;
						merchantId = temp;
					}
				}

			}

		});
		
		label = new JLabel("");
		label.setForeground(Color.RED);
		label.setBounds(247, 7, 78, 21);
		contentPane.add(label);
	}
}
