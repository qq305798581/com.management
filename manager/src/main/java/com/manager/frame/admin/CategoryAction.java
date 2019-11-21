package com.manager.frame.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.ibatis.session.SqlSession;

import com.manager.domain.FirstClass;
import com.manager.domain.SecondClass;
import com.manager.mapper.CategoryMapper;
import com.manager.mapper.ClassMapper;
import com.manager.mapper.SqlSessionUtil;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class CategoryAction extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JComboBox<String> comboBox;
	
	private boolean isFirstClass;
	private SqlSession session = SqlSessionUtil.getSqlSession();
	List<FirstClass> fl = session.getMapper(ClassMapper.class).getFirstClass();

	/**
	 * Create the frame.
	 */
	public CategoryAction(boolean isfclass) {
		this.isFirstClass = isfclass;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 242, 138);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(74, 10, 135, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("类别名称");
		lblNewLabel.setBounds(10, 13, 54, 15);
		contentPane.add(lblNewLabel);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(74, 39, 135, 21);
		contentPane.add(comboBox);
		if(isFirstClass) {
			comboBox.setEnabled(false);
		}else {
			comboBox.setEnabled(true);
			for(FirstClass i:fl) {
				comboBox.addItem(i.getFName());
			}
		}
		
		JLabel lblNewLabel_1 = new JLabel("所属类别");
		lblNewLabel_1.setBounds(10, 42, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JButton button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isFirstClass) {
					comboBox.setEnabled(false);
					
					SqlSession session = SqlSessionUtil.getSqlSession();
					CategoryMapper mapper = session.getMapper(CategoryMapper.class);
					try {
						FirstClass fc = new FirstClass();
						fc.setFName(textField.getText());
						if(mapper.addFirstCategory(fc)==1) {
							JOptionPane.showMessageDialog(contentPane, "添加成功", "成功",
									JOptionPane.OK_OPTION);
						}else {
							JOptionPane.showMessageDialog(contentPane, "添加失败", "错误",
									JOptionPane.WARNING_MESSAGE);
						}
						
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(contentPane, "添加失败", "错误",
								JOptionPane.WARNING_MESSAGE);
					}
				}else {
					comboBox.setEnabled(true);
					
					SqlSession session = SqlSessionUtil.getSqlSession();
					CategoryMapper mapper1 = session.getMapper(CategoryMapper.class);
					ClassMapper mapper2 = session.getMapper(ClassMapper.class);
					List<FirstClass> fl = mapper2.getFirstClass();
					
					for(FirstClass i:fl) {
						comboBox.addItem(i.getFName());
					}
				
					try {
						SecondClass sc = new SecondClass();
						sc.setSName(textField.getText());
						sc.setFId(comboBox.getSelectedIndex()+1);
						if(mapper1.addSecondCategory(sc)==1) {
							JOptionPane.showMessageDialog(contentPane, "添加成功", "成功",
									JOptionPane.OK_OPTION);
						}else {
							JOptionPane.showMessageDialog(contentPane, "添加失败", "错误",
									JOptionPane.WARNING_MESSAGE);
						}
					}catch(Exception e1) {
						JOptionPane.showMessageDialog(contentPane, "添加失败", "错误",
								JOptionPane.WARNING_MESSAGE);
					}
					
				}
			}
		});
		button.setBounds(59, 70, 93, 23);
		contentPane.add(button);
	}
}
