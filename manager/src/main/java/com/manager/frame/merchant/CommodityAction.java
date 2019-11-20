package com.manager.frame.merchant;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.ibatis.session.SqlSession;

import com.manager.domain.Commodity;
import com.manager.domain.FirstClass;
import com.manager.domain.Merchant;
import com.manager.domain.SecondClass;
import com.manager.mapper.ClassMapper;
import com.manager.mapper.CommodityMapper;
import com.manager.mapper.MerchantMapper;
import com.manager.mapper.SqlSessionUtil;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CommodityAction extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField description;
	private JTextField prise;
	private JTextField merchantAccount;
	private JComboBox<FirstClass> firstClass;
	private JComboBox<SecondClass> secondClass;
	private JLabel warning;

	private SqlSession session = SqlSessionUtil.getSqlSession();
	private boolean isMerchantExist;
	private Integer merchantId;
	private Merchant merchant;

	List<FirstClass> fl = session.getMapper(ClassMapper.class).getFirstClass();
	List<SecondClass> sl = session.getMapper(ClassMapper.class).getSecondClass();

	

	/**
	 * Create the frame.
	 */
	public CommodityAction(Merchant mer) {
		this.merchant = mer;

		setTitle("添加商品");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 313, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		name = new JTextField();
		name.setBounds(74, 10, 213, 21);
		contentPane.add(name);
		name.setColumns(10);

		description = new JTextField();
		description.setColumns(10);
		description.setBounds(74, 136, 213, 125);
		contentPane.add(description);

		prise = new JTextField();
		prise.setColumns(10);
		prise.setBounds(74, 41, 213, 21);
		contentPane.add(prise);

		firstClass = new JComboBox<FirstClass>();
		firstClass.setBounds(74, 105, 103, 21);
		for(FirstClass i:fl) {
			firstClass.addItem(i);
		}

		contentPane.add(firstClass);

		secondClass = new JComboBox<SecondClass>();
		secondClass.setBounds(194, 105, 93, 21);
		for(SecondClass i:sl) {
			if(i.getFId()==fl.get(firstClass.getSelectedIndex()).getFId()) {
				secondClass.addItem(i);
			}

		}
		contentPane.add(secondClass);

		firstClass.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				secondClass.removeAllItems();
				for(SecondClass i:sl) {
					if(i.getFId()==fl.get(firstClass.getSelectedIndex()).getFId()) {
						secondClass.addItem(i);
					}

				}
			}

		});

		JLabel lblNewLabel = new JLabel("商品名称");
		lblNewLabel.setBounds(10, 13, 54, 15);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("价格");
		label.setBounds(10, 44, 54, 15);
		contentPane.add(label);

		JLabel label_1 = new JLabel("所属类别");
		label_1.setBounds(10, 108, 54, 15);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("商品描述");
		label_2.setBounds(10, 191, 54, 15);
		contentPane.add(label_2);

		JButton submit = new JButton("提交");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(isMerchantExist) {
						Commodity com = new Commodity();
						com.setPName(name.getText());
						com.setPPrise(Integer.valueOf(prise.getText()));
						com.setMId(merchantId);
						int si = 0;
						for(int i=0,count=0;i<sl.size();i++) {
							if(sl.get(i).getFId()==firstClass.getSelectedIndex()) {
								if(count==secondClass.getSelectedIndex()) {
									si=i;
									break;
								}else {
									count++;
								}
							}
						}
						com.setSId(si);
						com.setPDescribe(description.getText());

						CommodityMapper mapper = session.getMapper(CommodityMapper.class);
						mapper.addCommodity(com);
						session.commit();
						JOptionPane.showMessageDialog(contentPane, "添加成功", "成功",
								JOptionPane.OK_OPTION);
						dispose();
					}else {
						JOptionPane.showMessageDialog(contentPane, "添加失败", "错误",
								JOptionPane.WARNING_MESSAGE);
					}
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(contentPane, "添加失败", "错误",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		submit.setBounds(106, 271, 93, 23);
		contentPane.add(submit);

		merchantAccount = new JTextField();
		merchantAccount.setBounds(74, 72, 125, 21);
		contentPane.add(merchantAccount);
		merchantAccount.setColumns(10);
		merchantAccount.setText(merchant.getMName());
		merchantAccount.setEnabled(false);

		JLabel label_3 = new JLabel("商家账号");
		label_3.setBounds(10, 75, 54, 15);
		contentPane.add(label_3);

		warning = new JLabel("");
		warning.setForeground(Color.RED);
		warning.setBounds(209, 72, 78, 21);
		contentPane.add(warning);
	}

	public CommodityAction(Commodity com) {


		setTitle("修改商品");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 313, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		name = new JTextField();
		name.setBounds(74, 10, 213, 21);
		name.setText(com.getPName());
		contentPane.add(name);
		name.setColumns(10);

		description = new JTextField();
		description.setColumns(10);
		description.setBounds(74, 136, 213, 125);
		description.setText(com.getPDescribe());
		contentPane.add(description);

		prise = new JTextField();
		prise.setColumns(10);
		prise.setBounds(74, 41, 213, 21);
		prise.setText(String.valueOf(com.getPPrise()));
		contentPane.add(prise);

		firstClass = new JComboBox<FirstClass>();
		firstClass.setBounds(74, 105, 103, 21);
		for(FirstClass i:fl) {
			firstClass.addItem(i);
		}
		int fi = sl.get(com.getSId()-1).getFId()-1;
		//int fi = session.getMapper(ClassMapper.class).getFirstIdBySecondId(com.getSId());
		firstClass.setSelectedIndex(fi);
		contentPane.add(firstClass);

		secondClass = new JComboBox<SecondClass>();
		secondClass.setBounds(194, 105, 93, 21);
		int index = 0,count = 0;
		for(SecondClass i:sl) {
			if(i.getFId()==fi+1) {
				if(i.getSId()==com.getSId()) {
					index = count;
				}
				secondClass.addItem(i);
				count++;
			}
		}
		secondClass.setSelectedIndex(index);
		contentPane.add(secondClass);

		firstClass.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// TODO 自动生成的方法存根
				secondClass.removeAllItems();
				for(SecondClass i:sl) {
					if(i.getFId()==fl.get(firstClass.getSelectedIndex()).getFId()) {
						secondClass.addItem(i);
					}

				}
			}

		});

		JLabel lblNewLabel = new JLabel("商品名称");
		lblNewLabel.setBounds(10, 13, 54, 15);
		contentPane.add(lblNewLabel);

		JLabel label = new JLabel("价格");
		label.setBounds(10, 44, 54, 15);
		contentPane.add(label);

		JLabel label_1 = new JLabel("所属类别");
		label_1.setBounds(10, 108, 54, 15);
		contentPane.add(label_1);

		JLabel label_2 = new JLabel("商品描述");
		label_2.setBounds(10, 191, 54, 15);
		contentPane.add(label_2);

		JButton submit = new JButton("提交");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Commodity com = new Commodity();
				com.setPName(name.getText());
				com.setPPrise(Integer.valueOf(prise.getText()));
				com.setMId(merchantId);

				int si = 0;
				for(int i=0,count=0;i<sl.size();i++) {
					if(sl.get(i).getFId()==firstClass.getSelectedIndex()) {
						if(count==secondClass.getSelectedIndex()) {
							si=i;
							break;
						}else {
							count++;
						}
					}
				}
				com.setSId(si);
				com.setPDescribe(description.getText());

				CommodityMapper mapper = session.getMapper(CommodityMapper.class);
				mapper.updateInfo(com);
				session.commit();


			}
		});
		submit.setBounds(106, 271, 93, 23);
		contentPane.add(submit);

		merchantAccount = new JTextField();
		merchantAccount.setBounds(74, 72, 125, 21);
		merchantAccount.setEditable(false);
		merchantAccount.setText(session.getMapper(MerchantMapper.class).selectAccountById(com.getMId()));
		contentPane.add(merchantAccount);
		merchantAccount.setColumns(10);

		JLabel label_3 = new JLabel("商家账号");
		label_3.setBounds(10, 75, 54, 15);
		contentPane.add(label_3);

		warning = new JLabel("");
		warning.setForeground(Color.RED);
		warning.setBounds(209, 72, 78, 21);
		contentPane.add(warning);
	}

}
