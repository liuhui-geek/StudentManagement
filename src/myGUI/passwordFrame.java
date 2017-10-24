package myGUI;

import java.awt.Container;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import liuhui.DataProcessing;
import liuhui.User;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class passwordFrame extends JFrame implements ActionListener{
	/**
	 * 修改个人信息
	 */
	private static final long serialVersionUID = 1L;
	static private JTextField textField;
	static private JTextField textField_4;
	static String username,oldpassword,newpassword1,newpassword2,role;
	private static JPasswordField passwordField;
	private static JPasswordField passwordField_1;
	private static JPasswordField passwordField_2;
	public passwordFrame() {
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("用户名");
		lblNewLabel.setBounds(117, 21, 54, 15);
		getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(229, 21, 66, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("原口令");
		lblNewLabel_1.setBounds(117, 56, 54, 15);
		getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(229, 52, 66, 21);
		getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("新口令");
		lblNewLabel_2.setBounds(117, 91, 54, 15);
		getContentPane().add(lblNewLabel_2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(229, 88, 66, 21);
		getContentPane().add(passwordField_1);
		
		JLabel lblNewLabel_3 = new JLabel("确认新口令");
		lblNewLabel_3.setBounds(117, 126, 54, 15);
		getContentPane().add(lblNewLabel_3);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(229, 123, 66, 21);
		getContentPane().add(passwordField_2);
		
		JLabel lblNewLabel_4 = new JLabel("角色");
		lblNewLabel_4.setBounds(117, 165, 54, 15);
		getContentPane().add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(229, 162, 66, 21);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("修改");
		btnNewButton.setBounds(95, 206, 93, 23);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new changePassword());
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.setBounds(245, 206, 93, 23);
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		
	}
	static class changePassword implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			username = textField.getText();
			oldpassword = passwordField.getText();
			newpassword1 = passwordField_1.getText();
			newpassword2 = passwordField_2.getText();
			role = textField_4.getText();
			User a;
			try {
				a = DataProcessing.searchUser(username, oldpassword);
				if(a!=null)
				{
					if(newpassword1.equals(newpassword2))
					{
						if(DataProcessing.updateUser(username, newpassword1, role))
							JOptionPane.showMessageDialog(null, "密码修改成功");
					}
					else
						JOptionPane.showMessageDialog(null, "密码输入不一致");
				}
				else
					JOptionPane.showMessageDialog(null, "不存在该用户");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
//		passwordFrame passwordframe = new passwordFrame();
//		passwordframe.setTitle("个人信息管理");
//		passwordframe.setSize(500,400);
//		passwordframe.setVisible(true);
//		passwordframe.setLocationRelativeTo(null);
//		Container container = passwordframe.getContentPane();
//		container.setLayout(null);
	}
}
