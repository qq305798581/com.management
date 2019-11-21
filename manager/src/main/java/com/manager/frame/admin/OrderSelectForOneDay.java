package com.manager.frame.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.manager.domain.Commodity;
import com.manager.mapper.ClassMapper;
import com.manager.mapper.SqlSessionUtil;
import com.manager.mapper.TransactionMapper;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderSelectForOneDay extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> startmonth;
	private JComboBox<String> startday;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton radioButton;
	
	ComboBoxModel<String> twoEight = new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"});
	ComboBoxModel<String> threeZero = new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"});
	ComboBoxModel<String> threeOne = new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"});
	private JComboBox<String> starthour;
	private JButton search;

	/**
	 * Create the frame.
	 */
	public OrderSelectForOneDay() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 332, 142);
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
		
		starthour = new JComboBox<String>();
		starthour.setModel(new DefaultComboBoxModel(new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"}));
		starthour.setBounds(240, 10, 54, 21);
		contentPane.add(starthour);
		
		rdbtnNewRadioButton = new JRadioButton("订单数量");
		rdbtnNewRadioButton.setBounds(59, 37, 93, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		radioButton = new JRadioButton("订单金额");
		radioButton.setBounds(166, 37, 93, 23);
		contentPane.add(radioButton);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(radioButton);
		
		search = new JButton("查询");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String start = "2019-"+String.valueOf(startmonth.getSelectedIndex()+1)+"-"+String.valueOf(startday.getSelectedIndex()+1)+
						" "+starthour.getSelectedIndex()+":00:00";
				String end = "2019-"+String.valueOf(startmonth.getSelectedIndex()+1)+"-"+String.valueOf(startday.getSelectedIndex()+2)+
						" "+starthour.getSelectedIndex()+":00:00";
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
		});
		search.setBounds(111, 66, 93, 23);
		contentPane.add(search);
		
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
	}
	
	private int getLastDay(int month) {
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12) {
			return 31;
		}else if(month==4||month==6||month==9||month==11) {
			return 30;
		}else {
			return 28;
		}
	}
}
