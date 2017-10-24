package liuhui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Scanner;
/**************************
 * 系统管理人员操作界面
 * 
 * @author 刘辉
 *
 */
public class Administrator extends User{
	
	private Scanner b1;
	
	Administrator(String name, String password, String role) {
		super(name,password,role);
	}
	
/*********************
 * 更新用户，使用dataprocessing中的类
 * @param name
 * @param password
 * @param role
 * @return
 */
public static boolean update(String name, String password, String role) {  //继承父类，更新用户
		// TODO Auto-generated method stub
		try {
			return DataProcessing.updateUser(name, password, role);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
/***************************
 * 列举用户
 */
//public void ListUser()            //列举用户
//{
//	Enumeration<User> e  = DataProcessing.users.elements();
//	User user;
//	while(e.hasMoreElements())
//	{
//		user = e.nextElement();
//		System.out.println("Name:"+user.getName()+"\t password:"+user.getPassword()+"\t Role:"+user.getRole()+"\n");
//	}
//}


/*****************
 * 删除用户 使用dataprocessing中的类
 * @param name
 * @return
 */
public static boolean delete(String name)   
{
	try {
		return DataProcessing.delete(name);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}


/*********************
 * 新增用户 ,使用dataprocessing中的类
 * @param name
 * @param password
 * @param role
 * @return
 */
public static boolean insert(String name, String password, String role) 
{
	try {
		return DataProcessing.insertUser(name, password, role);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}
/********************
 * 修改密码,通过用户类的update函数
 * @param name
 * @param password
 * @param role
 * @return
 */
public boolean changeUserInfo(String name,String password,String role)   //修改密码
{
	try {
		return DataProcessing.updateUser(name, password, role);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}

}
