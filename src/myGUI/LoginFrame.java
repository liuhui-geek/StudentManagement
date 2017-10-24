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
	 * ��½��������
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public  static JTextField textField;
	private static String username;
	private static String password;
	public static JPasswordField passwordField;
	public LoginFrame() {
		//��¼���
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
		
		JLabel label = new JLabel("�û���");
		panel_5.add(label);
		//�û����ı���
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
		
		JLabel label_1 = new JLabel("����");
		panel_6.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		panel_6.add(passwordField);
		
		JPanel panel_7 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_7.getLayout();
		flowLayout_7.setVgap(10);
		flowLayout_7.setHgap(60);
		panel_1.add(panel_7);
		
		JButton button = new JButton("ȷ��");	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
		panel_7.add(button);
		//ȷ����ť��Ч��
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				User a;
				try {
					//����ı��������������
					username = textField.getText();
					password = passwordField.getText();
					a = DataProcessing.searchUser(username, password);
					//�ж��ı��������û�����������
					if(a.getRole().equals("browser"))
					{
						UserFrame browserframe = new UserFrame(a);
						browserframe.setTitle("�������Ա����");
						browserframe.setSize(800,600);
						browserframe.setLocationRelativeTo(null);
						browserframe.setVisible(true);
					}
					else if(a.getRole().equals("operator"))
					{
						UserFrame operator = new UserFrame(a);
						operator.setSize(800,600);
						operator.setTitle("��������Ա����");
						operator.setLocationRelativeTo(null);
						operator.setVisible(true);
					}
					else if(a.getRole().equals("administrator"))
					{
						UserFrame administrator = new UserFrame(a);
						administrator.setSize(800,600);
						administrator.setTitle("ϵͳ������Ա����");
						administrator.setLocationRelativeTo(null);
						administrator.setVisible(true);
					}
					else 
						//��ʾ�������
					JOptionPane.showMessageDialog(null, "�û���������������", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
			}
		});
		
		JButton btnNewButton = new JButton("ȡ��");
		panel_7.add(btnNewButton);
		//ȡ����ť��Ӧ
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
