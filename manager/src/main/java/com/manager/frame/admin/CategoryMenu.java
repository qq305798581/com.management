package com.manager.frame.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class CategoryMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CategoryMenu frame = new CategoryMenu();
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
	public CategoryMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 151);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton select = new JButton("类别查找");
		select.setBounds(10, 74, 93, 23);
		contentPane.add(select);
		
		JButton add = new JButton("添加类别");
		add.setBounds(113, 74, 93, 23);
		contentPane.add(add);
		
		JButton update = new JButton("修改类别");
		update.setBounds(216, 74, 93, 23);
		contentPane.add(update);
		
		JButton delete = new JButton("删除类别");
		delete.setBounds(319, 74, 93, 23);
		contentPane.add(delete);
		
		JRadioButton first = new JRadioButton("一级类别");
		first.setBounds(33, 23, 93, 23);
		contentPane.add(first);
		
		JRadioButton second = new JRadioButton("二级类别");
		second.setBounds(171, 22, 93, 23);
		contentPane.add(second);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(first);
		bg.add(second);
	}
}
