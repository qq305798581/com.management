package com.manager.frame.merchant;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.manager.domain.Commodity;
import com.manager.mapper.ClassMapper;
import com.manager.mapper.SqlSessionUtil;

public class OrderSelectForTopTen extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	private DefaultTableModel model ;
	
	private List<Commodity> res;


	/**
	 * Create the frame.
	 */
	public OrderSelectForTopTen(List<Commodity> res) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 451, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 415, 342);
		contentPane.add(scrollPane);
		
		table = new JTable();
		model = new DefaultTableModel(null,new String[] {
				"商品ID","商品名称","商品描述","商品类别","商品价格"
		});
		for(int i=0;i<res.size();i++) {
			ClassMapper mapper = SqlSessionUtil.getSqlSession().getMapper(ClassMapper.class);
			String className = mapper.getSecondName(res.get(i).getSId());		
			model.addRow(new String[] {
					String.valueOf(res.get(i).getMId()),
					res.get(i).getPName(),
					res.get(i).getPDescribe(),
					className,
					String.valueOf(res.get(i).getPPrise())
			});
		}
		table.setModel(model);
		scrollPane.setViewportView(table);
	}
}
