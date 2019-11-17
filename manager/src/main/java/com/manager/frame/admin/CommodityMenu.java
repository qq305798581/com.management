package com.manager.frame.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.manager.domain.Administrator;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTable;

public class CommodityMenu extends JFrame {

	private JPanel contentPane;
	private JTable table;



	/**
	 * Create the frame.
	 */
	public CommodityMenu(Administrator admin) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton insert = new JButton("添加");
		insert.setBounds(10, 10, 93, 23);
		contentPane.add(insert);
		
		JButton select = new JButton("查找");
		select.setBounds(319, 10, 93, 23);
		contentPane.add(select);
		
		JButton update = new JButton("修改");
		update.setBounds(216, 10, 93, 23);
		contentPane.add(update);
		
		JButton delet = new JButton("删除");
		delet.setBounds(113, 10, 93, 23);
		contentPane.add(delet);
		
		table = new JTable();
		table.setBounds(10, 43, 405, 408);
		contentPane.add(table);
	}
}
