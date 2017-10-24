package myGUI;

import liuhui.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.util.concurrent.CancellationException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import liuhui.DataProcessing;


import javax.swing.JButton;
import javax.swing.JPasswordField;


public class LoginFrame extends JFrame implements ActionListener{
	/**
	 * 登陆操作界面
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public  static JTextField textField;
	private static String username;
	private static String password;
	public static JPasswordField passwordField;
	public LoginFrame() {
		//登录面板
		JPanel panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setVgap(10);
		flowLayout_1.setHgap(10);
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(10);
		getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_5.getLayout();
		flowLayout_5.setVgap(10);
		flowLayout_5.setHgap(60);
		panel_1.add(panel_5);
		
		JLabel label = new JLabel("用户名");
		panel_5.add(label);
		//用户名文本框
		textField = new JTextField();
		panel_5.add(textField);
		textField.setColumns(10);
		textField.addActionListener(this);
		//textField.addActionListener(new userActionListener());
		
		JPanel panel_6 = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel_6.getLayout();
		flowLayout_6.setVgap(10);
		flowLayout_6.setHgap(70);
		panel_1.add(panel_6);
		
		JLabel label_1 = new JLabel("密码");
		panel_6.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		panel_6.add(passwordField);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_7.getLayout();
		flowLayout_7.setVgap(10);
		flowLayout_7.setHgap(60);
		panel_1.add(panel_7);
		
		JButton button = new JButton("确定");	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
		panel_7.add(button);
		//确定按钮的效用
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				User a;
				try {
					//获得文本框中输入的内容
					username = textField.getText();
					password = passwordField.getText();
					a = DataProcessing.searchUser(username, password);
					//判断文本内输入用户名所属对象
					if(a.getRole().equals("browser"))
					{
						UserFrame browserframe = new UserFrame(a);
						browserframe.setTitle("档案浏览员界面");
						browserframe.setSize(800,600);
						browserframe.setLocationRelativeTo(null);
						browserframe.setVisible(true);
					}
					else if(a.getRole().equals("operator"))
					{
						UserFrame operator = new UserFrame(a);
						operator.setSize(800,600);
						operator.setTitle("档案操作员界面");
						operator.setLocationRelativeTo(null);
						operator.setVisible(true);
					}
					else if(a.getRole().equals("administrator"))
					{
						UserFrame administrator = new UserFrame(a);
						administrator.setSize(800,600);
						administrator.setTitle("系统管理人员界面");
						administrator.setLocationRelativeTo(null);
						administrator.setVisible(true);
					}
					else 
						//提示输入错误
					JOptionPane.showMessageDialog(null, "用户名错误或密码错误", "提示", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
			}
		});
		
		JButton btnNewButton = new JButton("取消");
		panel_7.add(btnNewButton);
		//取消按钮响应
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		
		
	}
	public static void main(String[] args) {
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		username = textField.getText();
		password = passwordField.getText();
	}

}
