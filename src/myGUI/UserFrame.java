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
	 * 用户操作界面
	 */
	static User aUser=null;
	static String title;
	private static final long serialVersionUID = 1L;
	//用户构造方法，传递用户参数
	public UserFrame(User a) {
		aUser = a;
		JMenuBar menuBar = new JMenuBar();
		getContentPane().add(menuBar, BorderLayout.NORTH);
		
		JMenu mnNewMenu = new JMenu("用户管理");
		menuBar.add(mnNewMenu);
		//如果不是administrator,则注销掉用户管理菜单
		if(!aUser.getRole().equals("administrator"))
			mnNewMenu.setEnabled(false);
		JMenuItem menuItem = new JMenuItem("新增用户");
		mnNewMenu.add(menuItem);
		//新增用户响应
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
		
		JMenuItem menuItem_1 = new JMenuItem("删除用户");
		mnNewMenu.add(menuItem_1);
		//删除用户响应
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
		
		JMenuItem menuItem_2 = new JMenuItem("修改用户");
		mnNewMenu.add(menuItem_2);
		//修改用户响应
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
		
		JMenu mnNewMenu_2 = new JMenu("个人信息管理");
		menuBar.add(mnNewMenu_2);
		
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("信息修改");
		mntmNewMenuItem_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		mnNewMenu_2.add(mntmNewMenuItem_2);
		mntmNewMenuItem_2.addActionListener(new passwordChange());
	}
	//修改个人信息
	static class passwordChange implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			passwordFrame apasswordFrame = new passwordFrame();
			apasswordFrame.setSize(500,400);
			apasswordFrame.setLocationRelativeTo(null);
			apasswordFrame.setTitle("个人信息管理");
			
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
