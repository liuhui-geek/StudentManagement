package liuhui;

import java.io.*;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Scanner;

/******************
 * @父类操作界面
 * @author 刘辉
 *
 ****************/



public abstract class User {
	private String name;
	private String password;
	private String role;
	private Scanner b;
	
	public User(String name,String password,String role){     //构造方法
		this.name=name;
		this.password=password;
		this.role=role;				
	}
/**********************
 * 修改用户密码
 * @param password
 * @return
 * @throws SQLException
 */
	public boolean changeUserInfo(String password)throws SQLException{     //修改密码
		                                                //写用户信息到存储
		if (DataProcessing.updateUser(name, password, role)){
			this.password=password;
			System.out.println("修改成功");
			return true;
		}else
			return false;
	}

/**********************************
 * 优化子类的修改密码
 */
	public void changePossword()                  //优化子类的修改密码
	{
		System.out.println("修改本人密码");
		System.out.println("请输入新口令：");
		String bPossword;
		b = new Scanner(System.in);
		bPossword = b.next();
		try {
			if(!changeUserInfo(bPossword))
				System.out.print("修改失败！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}

