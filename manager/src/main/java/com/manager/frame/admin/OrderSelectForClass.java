package com.manager.frame.admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import org.apache.ibatis.session.SqlSession;

import com.manager.domain.FirstClass;
import com.manager.domain.Merchant;
import com.manager.domain.SecondClass;
import com.manager.mapper.ClassMapper;
import com.manager.mapper.SqlSessionUtil;
import com.manager.mapper.TransactionMapper;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class OrderSelectForClass extends JFrame {

	private JPanel contentPane;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton radioButton;
	private JComboBox<String> comboBox;
	private JComboBox<String> comboBox_1;
	

	private SqlSession session = SqlSessionUtil.getSqlSession();
	
	List<FirstClass> fl = session.getMapper(ClassMapper.class).getFirstClass();
	List<SecondClass> sl = session.getMapper(ClassMapper.class).getSecondClass();
	/**
	 * Create the frame.
	 */
	public OrderSelectForClass() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 351, 159);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("第一类");
		lblNewLabel.setBounds(10, 10, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("第二类");
		label.setBounds(172, 10, 54, 15);
		contentPane.add(label);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(65, 7, 97, 21);
		for(FirstClass i:fl) {
			comboBox.addItem(i.getFName());
		}
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(218, 7, 97, 21);
		for(SecondClass i:sl) {
			if(i.getFId()==fl.get(comboBox.getSelectedIndex()).getFId()) {
				comboBox_1.addItem(i.getSName());
			}
		}
		contentPane.add(comboBox_1);
		
		comboBox.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				comboBox_1.removeAllItems();
				for(SecondClass i:sl) {
					if(i.getFId()==fl.get(comboBox.getSelectedIndex()).getFId()) {
						comboBox_1.addItem(i.getSName());
					}

				}
			}
			
		});
		
		rdbtnNewRadioButton = new JRadioButton("订单数量");
		rdbtnNewRadioButton.setBounds(38, 44, 93, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		radioButton = new JRadioButton("订单金额");
		radioButton.setBounds(172, 44, 93, 23);
		contentPane.add(radioButton);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNewRadioButton);
		bg.add(radioButton);
		
		JButton btnNewButton = new JButton("查找");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransactionMapper mapper = SqlSessionUtil.getSqlSession().getMapper(TransactionMapper.class);
				
				int si = 0;
				for(int i=0;i<sl.size();i++) {
					if(sl.get(i).getSName().equals(comboBox_1.getSelectedItem().toString())) {
						
						si=i;
						break;
					}
				}
				if(rdbtnNewRadioButton.isSelected()) {
					System.out.print(si);
					long res = mapper.selectProductQuantityBySecondclassBetweenSomeTimes(si+1);
					JOptionPane.showMessageDialog(contentPane, "该类别下订单数量为"+res, "",
							JOptionPane.INFORMATION_MESSAGE);
				}else {
					System.out.print(si);
					long res = mapper.selectProductAmountBySecondclassBetweenSomeTimes(si+1);
					JOptionPane.showMessageDialog(contentPane, "该类别下订单金额为"+res, "",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(113, 73, 93, 23);
		contentPane.add(btnNewButton);
	}
}
