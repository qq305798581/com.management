package com.manager.frame.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CategoryMenu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
		setBounds(100, 100, 351, 146);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton select = new JButton("类别查找");
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		select.setBounds(10, 70, 93, 23);
		contentPane.add(select);
		
		JButton add = new JButton("添加类别");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		add.setBounds(113, 70, 93, 23);
		contentPane.add(add);
		
		JButton update = new JButton("修改类别");
		update.setBounds(216, 70, 93, 23);
		contentPane.add(update);
		
		JRadioButton first = new JRadioButton("一级类别");
		first.setBounds(63, 41, 93, 23);
		contentPane.add(first);
		
		JRadioButton second = new JRadioButton("二级类别");
		second.setBounds(170, 41, 93, 23);
		contentPane.add(second);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(first);
		bg.add(second);
		
		textField = new JTextField();
		textField.setBounds(113, 10, 196, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("请输入类别名称");
		lblNewLabel.setBounds(10, 13, 93, 15);
		contentPane.add(lblNewLabel);
	}
}
