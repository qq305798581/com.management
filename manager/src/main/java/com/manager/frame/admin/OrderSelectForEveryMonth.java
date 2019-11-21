package com.manager.frame.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.manager.domain.Commodity;
import com.manager.mapper.ClassMapper;
import com.manager.mapper.SqlSessionUtil;
import com.manager.mapper.TransactionMapper;

public class OrderSelectForEveryMonth extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	private DefaultTableModel model ;
	


	/**
	 * Create the frame.
	 */
	public OrderSelectForEveryMonth() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 415, 342);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel(null,new String[] {
				"月份","销量","销售额"
		});
		for(int i=1;i<=12;i++) {
			TransactionMapper mapper = SqlSessionUtil.getSqlSession().getMapper(TransactionMapper.class);
			model.addRow(new String[] {
					String.valueOf(i),
					String.valueOf(mapper.selectAllOrderQuantityBetweenSomeTimes("2019-"+i+"-1","2019-"+i+"-"+getLastDay(i))),
					String.valueOf(mapper.selectAllProductAmountBetweenSomeTimes("2019-"+i+"-1","2019-"+i+"-"+getLastDay(i)))
			});
		}
		table.setModel(model);
		scrollPane.setViewportView(table);
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
