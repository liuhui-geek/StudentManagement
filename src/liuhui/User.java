package liuhui;

import java.io.*;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Scanner;

/******************
 * @�����������
 * @author ����
 *
 ****************/



public abstract class User {
	private String name;
	private String password;
	private String role;
	private Scanner b;
	
	public User(String name,String password,String role){     //���췽��
		this.name=name;
		this.password=password;
		this.role=role;				
	}
/**********************
 * �޸��û�����
 * @param password
 * @return
 * @throws SQLException
 */
	public boolean changeUserInfo(String password)throws SQLException{     //�޸�����
		                                                //д�û���Ϣ���洢
		if (DataProcessing.updateUser(name, password, role)){
			this.password=password;
			System.out.println("�޸ĳɹ�");
			return true;
		}else
			return false;
	}

/**********************************
 * �Ż�������޸�����
 */
	public void changePossword()                  //�Ż�������޸�����
	{
		System.out.println("�޸ı�������");
		System.out.println("�������¿��");
		String bPossword;
		b = new Scanner(System.in);
		bPossword = b.next();
		try {
			if(!changeUserInfo(bPossword))
				System.out.print("�޸�ʧ�ܣ�");
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

