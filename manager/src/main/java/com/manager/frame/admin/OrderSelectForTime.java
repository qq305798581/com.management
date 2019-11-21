package com.manager.frame.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.manager.domain.Merchant;
import com.manager.mapper.SqlSessionUtil;
import com.manager.mapper.TransactionMapper;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Timestamp;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class OrderSelectForTime extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> startmonth;
	private JComboBox<String> startday;
	private JComboBox<String> endmonth;
	private JComboBox<String> endday;
	


	ComboBoxModel<String> twoEight = new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"});
	ComboBoxModel<String> threeZero = new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"});
	ComboBoxModel<String> threeOne = new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"});
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton radioButton;

	

	/**
	 * Create the frame.
	 */
	public OrderSelectForTime() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 240, 218);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"2019"}));
		comboBox.setBounds(10, 10, 72, 21);
		contentPane.add(comboBox);


		startmonth = new JComboBox<String>();
		startmonth.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		startmonth.setBounds(92, 10, 54, 21);
		contentPane.add(startmonth);

		startday = new JComboBox<String>();
		startday.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		startday.setBounds(156, 10, 54, 21);
		contentPane.add(startday);

		JLabel label = new JLabel("到");
		label.setBounds(102, 41, 54, 15);
		contentPane.add(label);

		JComboBox<String> comboBox_3 = new JComboBox<String>();
		comboBox_3.setModel(new DefaultComboBoxModel<String>(new String[] {"2019"}));
		comboBox_3.setBounds(10, 66, 72, 21);
		contentPane.add(comboBox_3);

		endmonth = new JComboBox<String>();
		endmonth.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		endmonth.setBounds(92, 66, 54, 21);
		contentPane.add(endmonth);

		endday = new JComboBox<String>();
		endday.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		endday.setBounds(156, 66, 54, 21);
		contentPane.add(endday);

		startmonth.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				switch(startmonth.getSelectedIndex()) {
				case 0:startday.setModel(threeOne);
				case 1:startday.setModel(twoEight);
				case 2:startday.setModel(threeOne);
				case 3:startday.setModel(threeZero);
				case 4:startday.setModel(threeOne);
				case 5:startday.setModel(threeZero);
				case 6:startday.setModel(threeOne);
				case 7:startday.setModel(threeOne);
				case 8:startday.setModel(threeOne);
				case 9:startday.setModel(threeZero);
				case 10:startday.setModel(threeOne);
				case 11:startday.setModel(threeZero);
				case 12:startday.setModel(threeOne);
				}
			}

		});

		endmonth.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				switch(endmonth.getSelectedIndex()) {
				case 0:endday.setModel(threeOne);
				case 1:endday.setModel(twoEight);
				case 2:endday.setModel(threeOne);
				case 3:endday.setModel(threeZero);
				case 4:endday.setModel(threeOne);
				case 5:endday.setModel(threeZero);
				case 6:endday.setModel(threeOne);
				case 7:endday.setModel(threeOne);
				case 8:endday.setModel(threeOne);
				case 9:endday.setModel(threeZero);
				case 10:endday.setModel(threeOne);
				case 11:endday.setModel(threeZero);
				case 12:endday.setModel(threeOne);
				}
			}

		});

		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Integer.valueOf(startmonth.getSelectedItem().toString())>
				Integer.valueOf(endmonth.getSelectedItem().toString())) {
					JOptionPane.showMessageDialog(contentPane, "日期不合法", "错误",
							JOptionPane.WARNING_MESSAGE);
				}else if(Integer.valueOf(startmonth.getSelectedItem().toString())==
				Integer.valueOf(endmonth.getSelectedItem().toString())) {
					if(Integer.valueOf(startmonth.getSelectedItem().toString())>=
				Integer.valueOf(endmonth.getSelectedItem().toString())) {
						JOptionPane.showMessageDialog(contentPane, "日期不合法", "错误",
								JOptionPane.WARNING_MESSAGE);
					}else {
						String start = "2019-"+String.valueOf(startmonth.getSelectedIndex()+1)+"-"+String.valueOf(startday.getSelectedIndex()+1);
						String end = "2019-"+String.valueOf(endmonth.getSelectedIndex()+1)+"-"+String.valueOf(endday.getSelectedIndex()+1);
						TransactionMapper mapper = SqlSessionUtil.getSqlSession().getMapper(TransactionMapper.class);
						if(rdbtnNewRadioButton.isSelected()) {
							long res = mapper.selectAllOrderQuantityBetweenSomeTimes(start, end);
							JOptionPane.showMessageDialog(contentPane, "该段时间内订单数量为"+res, "",
									JOptionPane.INFORMATION_MESSAGE);
						}else {
							long res = mapper.selectAllProductAmountBetweenSomeTimes(start, end);
							JOptionPane.showMessageDialog(contentPane, "该段时间内订单总金额为"+res, "",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}else {
					String start = "2019-"+String.valueOf(startmonth.getSelectedIndex()+1)+"-"+String.valueOf(startday.getSelectedIndex()+1);
					String end = "2019-"+String.valueOf(endmonth.getSelectedIndex()+1)+"-"+String.valueOf(endday.getSelectedIndex()+1);
					TransactionMapper mapper = SqlSessionUtil.getSqlSession().getMapper(TransactionMapper.class);
					if(rdbtnNewRadioButton.isSelected()) {
						long res = mapper.selectAllOrderQuantityBetweenSomeTimes(start, end);
						JOptionPane.showMessageDialog(contentPane, "该段时间内订单数量为"+res, "",
								JOptionPane.INFORMATION_MESSAGE);
					}else {
						long res = mapper.selectAllProductAmountBetweenSomeTimes(start, end);
						JOptionPane.showMessageDialog(contentPane, "该段时间内订单总金额为"+res, "",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		btnNewButton.setBounds(63, 146, 93, 23);
		contentPane.add(btnNewButton);
		
		rdbtnNewRadioButton = new JRadioButton("订单数量");
		rdbtnNewRadioButton.setBounds(10, 105, 93, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		radioButton = new JRadioButton("订单金额");
		radioButton.setBounds(117, 105, 93, 23);
		contentPane.add(radioButton);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(radioButton);
	}

}
