package com.work.layout;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.work.utils.RecordScoreUtil;
import javax.swing.JCheckBox;

/**
 * 学生成绩预览以及模糊查询界面
 * 
 * @version 1.0.0
 * 
 * @author 曹毅
 *
 */
public class ScoreListSortLayout extends JDialog {
	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 3359209727928155111L;

	/**
	 * 学生成绩预览以及模糊查询
	 * 
	 * @param parent 父容器
	 * @param score 学生成绩信息
	 * @param root 根目录
	 */
	public ScoreListSortLayout(JFrame parent, String[][] score,final String root) {
		super(parent, "学生成绩信息预览", true);
		
		// 表格中显示的抬头
		String columns[] = { "学号", "姓名", "学科", "等级" };
		TableModel model = new DefaultTableModel(score, columns);
		final JTable table = new JTable(model);
		RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
		table.setRowSorter(sorter);
		final JScrollPane pane = new JScrollPane(table);
		pane.setBounds(0, 45, 497, 248);
		setBounds(100, 100, 501, 327);
		getContentPane().setLayout(null);
		getContentPane().add(pane);

		JButton findBy = new JButton("查询");
		findBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent paramActionEvent) {
				
				// 选择的过滤条件序号
				// 0:学号;1:姓名;2:学科;3等级;
				int itemIndex = 0;
				
				// 过滤条件的输入文字列
				String itemValue = null;
				
				//是否要模糊查询
				boolean isLike = false;
				
				RecordScoreUtil recordScoreUtil = new RecordScoreUtil(root);
				Component[] components = getContentPane().getComponents();
				for(Component c : components){
					if(c instanceof JTextField){
						// 获取输入文字列
						itemValue = ((JTextField) c).getText();
					}
					if(c instanceof JComboBox){
						// 获取过滤条件序号
						itemIndex = ((JComboBox<?>) c).getSelectedIndex();
					}
					if(c instanceof JCheckBox){
						// 获取是否要模糊查询
						isLike = ((JCheckBox) c).isSelected();
					}
				}
				
				// 获取table数据对象
				DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
				
				// 清除table
				tableModel.getDataVector().removeAllElements();
				
				// 根据条件再检索
				for(String[] arg:recordScoreUtil.readFromCsvBy(itemIndex, itemValue,isLike))
				tableModel.addRow(arg);
				
				// 表格再初始化
				tableModel.fireTableDataChanged();
			}
		});
		
		findBy.setBounds(10, 10, 76, 25);
		getContentPane().add(findBy);

		JTextField textField = new JTextField();
		textField.setBounds(251, 12, 116, 21);
		getContentPane().add(textField);
		textField.setColumns(10);

		JComboBox<Object> comboBox = new JComboBox<Object>(new String[] { "学号", "姓名", "学科", "等级" });
		comboBox.setBounds(123, 12, 86, 21);
		getContentPane().add(comboBox);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("模糊查询");
		chckbxNewCheckBox.setBounds(385, 11, 102, 23);
		getContentPane().add(chckbxNewCheckBox);
		RecordScoreUtil.setCenter(this);
	}
}