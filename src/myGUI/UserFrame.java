package myGUI;

import java.awt.event.ActionListener;

import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import java.awt.BorderLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import liuhui.User;

import java.awt.Font;

public class UserFrame extends JFrame implements ActionListener{
	/**
	 * �û���������
	 */
	static User aUser=null;
	static String title;
	private static final long serialVersionUID = 1L;
	//�û����췽���������û�����
	public UserFrame(User a) {
		aUser = a;
		JMenuBar menuBar = new JMenuBar();
		getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnNewMenu = new JMenu("�û�����");
		menuBar.add(mnNewMenu);
		//�������administrator,��ע�����û�����˵�
		if(!aUser.getRole().equals("administrator"))
			mnNewMenu.setEnabled(false);
		JMenuItem menuItem = new JMenuItem("�����û�");
		mnNewMenu.add(menuItem);
		//�����û���Ӧ
		menuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SelfFrame addusers = new SelfFrame(1);
				addusers.setSize(430, 350);
				addusers.setLocationRelativeTo(null);
				addusers.setVisible(true);
			}
		});
		
		JMenuItem menuItem_1 = new JMenuItem("ɾ���û�");
		mnNewMenu.add(menuItem_1);
		//ɾ���û���Ӧ
		menuItem_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SelfFrame addusers = new SelfFrame(2);
				addusers.setSize(430, 350);
				addusers.setLocationRelativeTo(null);
				addusers.setVisible(true);
			}
		});
		
		JMenuItem menuItem_2 = new JMenuItem("�޸��û�");
		mnNewMenu.add(menuItem_2);
		//�޸��û���Ӧ
		menuItem_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SelfFrame addusers = new SelfFrame(3);
				addusers.setSize(430, 350);
				addusers.setLocationRelativeTo(null);
				addusers.setVisible(true);
			}
		});
		
		JMenu mnNewMenu_2 = new JMenu("������Ϣ����");
		menuBar.add(mnNewMenu_2);
		
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("��Ϣ�޸�");
		mntmNewMenuItem_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		mnNewMenu_2.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.addActionListener(new passwordChange());
	}
	//�޸ĸ�����Ϣ
	static class passwordChange implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			passwordFrame apasswordFrame = new passwordFrame();
			apasswordFrame.setSize(500,400);
			apasswordFrame.setLocationRelativeTo(null);
			apasswordFrame.setTitle("������Ϣ����");
			
			apasswordFrame.setVisible(true);
		}
		
	}
	
	public static void main(String[] args) {
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
