package myGUI;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import java.util.Enumeration;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import liuhui.DataProcessing;

import liuhui.User;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;

public class SelfFrame extends JFrame implements ActionListener{
	private static JTextField textField_1;
	public static Object[][]  users  = new Object[20][5];
	public static Object[][]  user1s  = new Object[20][5];
	public static String role[] = {"browser","operator","administrator"};
	public static String user[] = {"jack","rose","kate"};
	public static String[] columnNames = {"用户名","口令","角色"};
	public static JTable table = new JTable(users,columnNames);
	public static JComboBox comboBox = new JComboBox(user);
	public static JComboBox comboBox_2 = new JComboBox(role);
	public static JComboBox comboBox_1 = new JComboBox(role);
	public static int k;
	private static JPasswordField passwordField;
	private static JPasswordField passwordField_1;
	public SelfFrame(int index) {
		getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 430, 350);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("新增用户", null, panel, null);
		panel.setLayout(null);
		
		JLabel label_3 = new JLabel("用户名");
		label_3.setBounds(98, 42, 54, 15);
		panel.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(228, 39, 66, 21);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_4 = new JLabel("密码");
		label_4.setBounds(98, 93, 54, 15);
		panel.add(label_4);
		
		
		JLabel label_5 = new JLabel("角色");
		label_5.setBounds(98, 142, 54, 15);
		panel.add(label_5);
		
		
		comboBox_2.setBounds(228, 139, 66, 21);
		panel.add(comboBox_2);
		
		JButton button = new JButton("增加");
		button.setBounds(84, 179, 93, 23);
		panel.add(button);
		button.addActionListener(new adduser());
		
		
		JButton button_1 = new JButton("取消");
		button_1.setBounds(216, 179, 93, 23);
		panel.add(button_1);
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		
		passwordField = new JPasswordField();
		passwordField.setBounds(228, 90, 66, 21);
		panel.add(passwordField);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("修改用户", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("用户名");
		label.setBounds(98, 42, 54, 15);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("密码");
		label_1.setBounds(98, 93, 54, 15);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("角色");
		label_2.setBounds(98, 142, 54, 15);
		panel_1.add(label_2);
		
		comboBox.setBounds(228, 39, 66, 21);
		panel_1.add(comboBox);
		
		
		comboBox_1.setBounds(228, 139, 66, 21);
		panel_1.add(comboBox_1);
		
		JButton btnNewButton = new JButton("修改");
		btnNewButton.setBounds(84, 179, 93, 23);
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(new changeuser());
		
		
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setBounds(216, 179, 93, 23);
		panel_1.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(228, 90, 66, 21);
		panel_1.add(passwordField_1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("删除用户", null, panel_2, null);
		panel_2.setLayout(null);
		
		GenerateTable();
		
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setBorder(null);
		table.setCellSelectionEnabled(true);
		
		TableColumn column = null;
		table.setBounds(0, 0, 5, 3);
		int columns = table.getColumnCount();
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(60, 21, 330, 180);
		panel_2.add(scrollPane);
		
		JButton btnNewButton_2 = new JButton("删除");
		btnNewButton_2.setBounds(70, 207, 93, 23);
		panel_2.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new deleteuser());
		
		
		JButton button_2 = new JButton("返回");
		button_2.setBounds(259, 207, 93, 23);
		panel_2.add(button_2);
		// TODO Auto-generated constructor stub
		button_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		
		
		if(index==2)
			tabbedPane.setSelectedComponent(panel_2);
		else if(index==3){
			tabbedPane.setSelectedComponent(panel_1);
		}
		else 
			tabbedPane.setSelectedComponent(panel);
			
	}
	
	//新增用户
	static class adduser implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int copy = JOptionPane.showConfirmDialog(null, "确定要增加用户吗？","确定",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(copy == JOptionPane.YES_OPTION)
			{
				String name2 = textField_1.getText();
				String password1 = passwordField.getText();
				String role1 = (String) comboBox_2.getSelectedItem();
				try {
					if(DataProcessing.insertUser(name2, password1, role1))
					{
						GenerateTable();
						JOptionPane.showMessageDialog(null, "用户添加成功！");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
	}
	
	//修改用户
	static class changeuser implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int copy = JOptionPane.showConfirmDialog(null, "确定要修改用户吗？","确定",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(copy  == JOptionPane.YES_OPTION)
			{
				 String role1 = (String) comboBox_1.getSelectedItem();
				 String name1 = (String) comboBox.getSelectedItem();
				 String password = passwordField_1.getText();
				 try {
					if(DataProcessing.updateUser(name1, password, role1))
					 {
						JOptionPane.showMessageDialog(null, "修改成功！");
						GenerateTable();
					 }
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 //String role2 = (String) comboBox_2.getSelectedItem();
			}
		}
		
	}
	
	//删除用户
	static class deleteuser implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int copy = JOptionPane.showConfirmDialog(null, "确定要修改用户吗？","确定",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(copy  == JOptionPane.YES_OPTION)
			{
				int row = table.getSelectedRow();
				String x = (String) table.getValueAt(row, 0);
				try {
					if(DataProcessing.delete(x))
					{
						GenerateTable();
						JOptionPane.showMessageDialog(null, "删除成功！");
						//int data1 = filldata();
					}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						
			}
			
		}
		
	}
	
	//刷表，填充表格
//	static public int filldata()
//	{
//		Enumeration<User> e  = DataProcessing.users.elements();
// 		int i=-1;
//		User user2;
//		while(e.hasMoreElements())
//		{
//			i++;
//			user2 = e.nextElement();
//			for(int j=0;j<3;j++)
//			{
//				switch(j)
//				{
//					case 0:users[i][j]=user2.getName();
//					break;
//					case 1:users[i][j]=user2.getPassword();
//					break;
//					case 2:users[i][j]=user2.getRole();
//					break;
//				}
//			}
//		}
//		return i;
//	}
	
	//清空表格
	static void GenerateTable()
	{
		Vector header = new Vector();
		header.add("用户名");
		header.add("口令");
		header.add("角色");
		Vector content = new Vector();
		try
		{
			Enumeration<User> user = DataProcessing.getAllUser();
			User it;
			while (user.hasMoreElements())
			{
				it = user.nextElement();
				Vector temp = new Vector();
				temp.add(it.getName());
				temp.add(it.getPassword());
				temp.add(it.getRole());
				content.add(temp);
				System.out.println(it.getName());
			}
			if(content.size()<15)
				content.setSize(15);
		}
		catch (SQLException exp)
		{
			JOptionPane.showMessageDialog(null, "SQL Error.", "Error", JOptionPane.PLAIN_MESSAGE);
		}
		DefaultTableModel model = new DefaultTableModel(content, header);
		table.setModel(model);
	}

	
	static public void clearTable()
	{
		Enumeration<User> e;
		try {
			e = DataProcessing.getAllUser();
			int i=-1;
			User user2;
			while(e.hasMoreElements())
			{
				i++;
				user2 = e.nextElement();
				for(int j=0;j<3;j++)
				{
					switch(j)
					{
						case 0:user1s[i][j]=null;
						break;
						case 1:user1s[i][j]=null;
						break;
						case 2:user1s[i][j]=null;
						break;
					}
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		SelfFrame selfFrame = new SelfFrame(1);
		selfFrame.setSize(430, 350);
		selfFrame.setLocationRelativeTo(null);
		selfFrame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
