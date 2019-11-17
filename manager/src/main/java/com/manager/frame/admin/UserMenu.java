package com.manager.frame.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;

public class UserMenu extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserMenu frame = new UserMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton add = new JButton("添加用户");
		add.setBounds(10, 10, 93, 23);
		contentPane.add(add);
		
		JButton delete = new JButton("删除用户");
		delete.setBounds(113, 10, 93, 23);
		contentPane.add(delete);
		
		JButton update = new JButton("修改信息");
		update.setBounds(216, 10, 93, 23);
		contentPane.add(update);
		
		JButton search = new JButton("查找用户");
		search.setBounds(319, 10, 93, 23);
		contentPane.add(search);
		
		table = new JTable();
		table.setBounds(10, 43, 405, 408);
		contentPane.add(table);
	}

}
