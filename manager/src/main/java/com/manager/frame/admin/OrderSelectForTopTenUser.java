package com.manager.frame.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.manager.domain.Commodity;
import com.manager.domain.Merchant;
import com.manager.domain.User;
import com.manager.mapper.ClassMapper;
import com.manager.mapper.SqlSessionUtil;
import com.manager.mapper.TransactionMapper;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrderSelectForTopTenUser extends JFrame {

	private JPanel contentPane;
	private JTable table;

	private DefaultTableModel model ;

	private List<Commodity> res;
	private JLabel label;
	private JButton btnNewButton;
	private JComboBox<String> startmonth;
	private JComboBox<String> startday;
	private JComboBox<String> endmonth;
	private JComboBox<String> endday;


	ComboBoxModel<String> twoEight = new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28"});
	ComboBoxModel<String> threeZero = new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"});
	ComboBoxModel<String> threeOne = new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"});
	private JButton button;
	/**
	 * Create the frame.
	 */
	public OrderSelectForTopTenUser() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 101, 415, 342);
		contentPane.add(scrollPane);

		table = new JTable();
		model = new DefaultTableModel(null,new String[] {
				"用户ID","用户姓名","用户性别","用户电话"
		});
		
		table.setModel(model);
		scrollPane.setViewportView(table);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"2019"}));
		comboBox.setBounds(50, 10, 72, 21);
		contentPane.add(comboBox);


		startmonth = new JComboBox<String>();
		startmonth.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		startmonth.setBounds(132, 10, 54, 21);
		contentPane.add(startmonth);

		startday = new JComboBox<String>();
		startday.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		startday.setBounds(196, 10, 54, 21);
		contentPane.add(startday);

		JLabel label = new JLabel("到");
		label.setBounds(142, 41, 54, 15);
		contentPane.add(label);

		JComboBox<String> comboBox_3 = new JComboBox<String>();
		comboBox_3.setModel(new DefaultComboBoxModel<String>(new String[] {"2019"}));
		comboBox_3.setBounds(50, 66, 72, 21);
		contentPane.add(comboBox_3);

		endmonth = new JComboBox<String>();
		endmonth.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		endmonth.setBounds(132, 66, 54, 21);
		contentPane.add(endmonth);

		endday = new JComboBox<String>();
		endday.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		endday.setBounds(196, 66, 54, 21);
		contentPane.add(endday);

		button = new JButton("查询");
		button.addActionListener(new ActionListener() {
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
						List<User> res = mapper.selectTopTenUsersBetweenSomeTime(start, end, 10);
						for(int i=0;i<res.size();i++) {
							model.addRow(new String[] {
									String.valueOf(res.get(i).getUId()),
									res.get(i).getUName(),
									res.get(i).getUSex(),
									res.get(i).getUTele()
							});
						}
						table.setModel(model);
					}
				}else {
					String start = "2019-"+String.valueOf(startmonth.getSelectedIndex()+1)+"-"+String.valueOf(startday.getSelectedIndex()+1);
					String end = "2019-"+String.valueOf(endmonth.getSelectedIndex()+1)+"-"+String.valueOf(endday.getSelectedIndex()+1);
					TransactionMapper mapper = SqlSessionUtil.getSqlSession().getMapper(TransactionMapper.class);
					List<User> res = mapper.selectTopTenUsersBetweenSomeTime(start, end, 10);
					for(int i=0;i<res.size();i++) {
						model.addRow(new String[] {
								String.valueOf(res.get(i).getUId()),
								res.get(i).getUName(),
								res.get(i).getUSex(),
								res.get(i).getUTele()
						});
					}
					table.setModel(model);
				}
			}

		});
		button.setBounds(296, 37, 93, 23);
		contentPane.add(button);

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
	}
}
