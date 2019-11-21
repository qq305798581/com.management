package com.manager.frame.merchant;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.manager.domain.Commodity;
import com.manager.domain.Merchant;
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
	private JTextField textField;
	
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton radioButton;
	private JRadioButton radioButton_1;
	private JRadioButton radioButton_2;
	
	private Merchant merchant;

	/**
	 * Create the frame.
	 */
	public OrderAction(Merchant mer) {
		this.merchant = mer;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 270, 167);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(67, 10, 82, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("订单号");
		lblNewLabel.setBounds(10, 13, 54, 15);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("发货");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransactionMapper mapper = SqlSessionUtil.getSqlSession().getMapper(TransactionMapper.class);
				if(mapper.selectTransactionStateByOderId(Integer.valueOf(textField.getText()),merchant)==1) {
					mapper.updateState(Integer.valueOf(textField.getText()));
					SqlSessionUtil.getSqlSession().commit();
					JOptionPane.showMessageDialog(contentPane, "修改成功", "成功",
							JOptionPane.OK_OPTION);
				}else {
					JOptionPane.showMessageDialog(contentPane, "该订单已发货", "错误",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(164, 9, 64, 23);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnNewRadioButton.isSelected()) {
					OrderSelectForTime ot = new OrderSelectForTime(merchant);
					ot.setVisible(true);
				}else if(radioButton.isSelected()) {
					OrderSelectForClass oc = new OrderSelectForClass(merchant);
					oc.setVisible(true);
				}else if(radioButton_1.isSelected()) {
					TransactionMapper mapper = SqlSessionUtil.getSqlSession().getMapper(TransactionMapper.class);
					List<Commodity> res = mapper.selectTopTenSalesCommodity(merchant);
					OrderSelectForTopTen ott = new OrderSelectForTopTen(res);
					ott.setVisible(true);
				}else {
					TransactionMapper mapper = SqlSessionUtil.getSqlSession().getMapper(TransactionMapper.class);
					List<Commodity> res = mapper.selectTopTenItemsCommodity(10, merchant);
					OrderSelectForTopTen ott = new OrderSelectForTopTen(res);
					ott.setVisible(true);
				}
			}
		});
		button.setBounds(85, 95, 64, 23);
		contentPane.add(button);
		
		rdbtnNewRadioButton = new JRadioButton("按时间段查询");
		rdbtnNewRadioButton.setBounds(10, 41, 109, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		radioButton = new JRadioButton("按类别查询");
		radioButton.setBounds(121, 41, 89, 23);
		contentPane.add(radioButton);
		
		radioButton_1 = new JRadioButton("查询热门商品");
		radioButton_1.setBounds(10, 66, 109, 23);
		contentPane.add(radioButton_1);
		
		radioButton_2 = new JRadioButton("查询好评商品");
		radioButton_2.setBounds(119, 66, 109, 23);
		contentPane.add(radioButton_2);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(radioButton);
		bg.add(radioButton_1);
		bg.add(radioButton_2);
	}
}
