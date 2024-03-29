package com.manager.frame.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.manager.domain.Administrator;
import com.manager.domain.Commodity;
import com.manager.mapper.CommodityMapper;
import com.manager.mapper.SqlSessionUtil;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class CommodityMenu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;



	/**
	 * Create the frame.
	 */
	public CommodityMenu(Administrator admin) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 291, 152);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton insert = new JButton("添加");
		insert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CommodityAction frame = new CommodityAction();
				frame.setVisible(true);
			}
		});
		insert.setBounds(16, 44, 93, 23);
		contentPane.add(insert);

		JButton select = new JButton("查找");
		select.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText()!="") {
					CommodityMapper mapper = SqlSessionUtil.getSqlSession().getMapper(CommodityMapper.class);
					Commodity res = mapper.selectById(Integer.valueOf(textField.getText()));
					if(res==null) {
						JOptionPane.showMessageDialog(contentPane, "没有找到该商品", "错误",
								JOptionPane.WARNING_MESSAGE);
					}else {
						CommodityShow fr = new CommodityShow(res);
						fr.setVisible(true);
					}
				}



			}
		});
		select.setBounds(155, 44, 93, 23);
		contentPane.add(select);

		JButton update = new JButton("修改");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText()!="") {
					CommodityMapper mapper = SqlSessionUtil.getSqlSession().getMapper(CommodityMapper.class);
					Commodity res = mapper.selectById(Integer.valueOf(textField.getText()));
					if(res==null) {
						JOptionPane.showMessageDialog(contentPane, "没有找到该商品", "错误",
								JOptionPane.WARNING_MESSAGE);
					}else {
						CommodityAction fr = new CommodityAction(res);
						fr.setVisible(true);
					}
				}
			}
		});
		update.setBounds(155, 77, 93, 23);
		contentPane.add(update);

		JButton delet = new JButton("删除");
		delet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText()!="") {
					CommodityMapper mapper = SqlSessionUtil.getSqlSession().getMapper(CommodityMapper.class);
					try {
						if(mapper.deleteById(Integer.valueOf(textField.getText()))==1) {
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
		delet.setBounds(16, 77, 93, 23);
		contentPane.add(delet);

		textField = new JTextField();
		textField.setBounds(119, 10, 129, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("请输入商品编号");
		lblNewLabel.setBounds(10, 13, 99, 15);
		contentPane.add(lblNewLabel);
	}
}
