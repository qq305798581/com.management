package com.manager.frame.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.manager.domain.Merchant;
import com.manager.mapper.CommodityMapper;
import com.manager.mapper.MerchantMapper;
import com.manager.mapper.SqlSessionUtil;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MerchantMenu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MerchantMenu frame = new MerchantMenu();
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
	public MerchantMenu() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 266, 149);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton add = new JButton("添加商家");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MerchantAction mc = new MerchantAction();
				mc.setVisible(true);
			}
		});
		add.setBounds(10, 38, 93, 23);
		contentPane.add(add);
		
		JButton delete = new JButton("删除商家");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText()!="") {
					MerchantMapper mapper = SqlSessionUtil.getSqlSession().getMapper(MerchantMapper.class);
					try {
						if(mapper.deleteMerchantById(Integer.valueOf(textField.getText()))==1) {
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
		delete.setBounds(135, 38, 93, 23);
		contentPane.add(delete);
		
		JButton update = new JButton("修改信息");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MerchantMapper mapper = SqlSessionUtil.getSqlSession().getMapper(MerchantMapper.class);
				Merchant mer = mapper.selectMerchantById(Integer.valueOf(textField.getText()));
				if(mer==null) {
					JOptionPane.showMessageDialog(contentPane, "没有找到该商家", "错误",
							JOptionPane.WARNING_MESSAGE);
				}else {
					System.out.print(mer.getMId());
					MerchantAction ac = new MerchantAction(mer);
					ac.setVisible(true);
				}
				
			}
		});
		update.setBounds(10, 71, 93, 23);
		contentPane.add(update);
		
		JButton search = new JButton("查找商家");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MerchantMapper mapper = SqlSessionUtil.getSqlSession().getMapper(MerchantMapper.class);
				Merchant mer = mapper.selectMerchantById(Integer.valueOf(textField.getText()));
				if(mer==null) {
					JOptionPane.showMessageDialog(contentPane, "没有找到该商家", "错误",
							JOptionPane.WARNING_MESSAGE);
				}else {
					MerchantAction ac = new MerchantAction(mer,true);
					ac.setVisible(true);
				}
			}
		});
		search.setBounds(135, 71, 93, 23);
		contentPane.add(search);
		
		JLabel lblNewLabel = new JLabel("请输入商家ID");
		lblNewLabel.setBounds(10, 10, 93, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(101, 7, 127, 21);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
