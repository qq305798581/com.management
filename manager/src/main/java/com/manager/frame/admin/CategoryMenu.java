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
	private JRadioButton first;
	private JRadioButton second;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 214, 114);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton add = new JButton("添加类别");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(first.isSelected()) {
					CategoryAction ca = new CategoryAction(true);
					ca.setVisible(true);
				}else {
					CategoryAction ca = new CategoryAction(false);
					ca.setVisible(true);
				}
			}
		});
		add.setBounds(55, 39, 93, 23);
		contentPane.add(add);
		
		first = new JRadioButton("一级类别");
		first.setBounds(6, 6, 93, 23);
		contentPane.add(first);
		
		second = new JRadioButton("二级类别");
		second.setBounds(113, 6, 93, 23);
		contentPane.add(second);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(first);
		bg.add(second);
	}
}
