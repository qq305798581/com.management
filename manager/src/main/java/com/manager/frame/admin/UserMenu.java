package com.manager.frame.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.manager.domain.User;
import com.manager.mapper.CommodityMapper;
import com.manager.mapper.SqlSessionUtil;
import com.manager.mapper.UserMapper;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserMenu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 314, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton add = new JButton("添加用户");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserAction uf = new UserAction();
				uf.setVisible(true);
			}
		});
		add.setBounds(10, 35, 93, 23);
		contentPane.add(add);
		
		JButton delete = new JButton("删除用户");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText()!="") {
					UserMapper mapper = SqlSessionUtil.getSqlSession().getMapper(UserMapper.class);
					try {
						if(mapper.deleteById(textField.getText())==1) {
							JOptionPane.showMessageDialog(contentPane, "删除成功", "成功",
									JOptionPane.YES_OPTION);
						}else {
							JOptionPane.showMessageDialog(contentPane, "该商品不存在", "错误",
									JOptionPane.WARNING_MESSAGE);
						}
					}catch (Exception e1) {
						JOptionPane.showMessageDialog(contentPane, "该商品不存在", "错误",
								JOptionPane.WARNING_MESSAGE);
					}
					SqlSessionUtil.getSqlSession().commit();
				}
			}
		});
		delete.setBounds(10, 68, 93, 23);
		contentPane.add(delete);
		
		JButton update = new JButton("修改信息");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = SqlSessionUtil.getSqlSession().getMapper(UserMapper.class).selectUserByTele(textField.getText());
				if(user==null) {
					JOptionPane.showMessageDialog(contentPane, "该用户不存在", "错误",
							JOptionPane.WARNING_MESSAGE);
				}else {
					UserAction uf = new UserAction(user);
					uf.setVisible(true);
				}
			}
		});
		update.setBounds(167, 68, 93, 23);
		contentPane.add(update);
		
		JButton search = new JButton("查找用户");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User user = SqlSessionUtil.getSqlSession().getMapper(UserMapper.class).selectUserByTele(textField.getText());
				if(user==null) {
					JOptionPane.showMessageDialog(contentPane, "该用户不存在", "错误",
							JOptionPane.WARNING_MESSAGE);
				}else {
					UserAction uf = new UserAction(user,true);
					uf.setVisible(true);
				}
			}
		});
		search.setBounds(167, 35, 93, 23);
		contentPane.add(search);
		
		textField = new JTextField();
		textField.setBounds(114, 7, 151, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("请输入用户账户");
		lblNewLabel.setBounds(10, 10, 94, 15);
		contentPane.add(lblNewLabel);
	}

}
