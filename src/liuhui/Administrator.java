package liuhui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Scanner;
/**************************
 * ϵͳ������Ա��������
 * 
 * @author ����
 *
 */
public class Administrator extends User{
	
	private Scanner b1;
	
	Administrator(String name, String password, String role) {
		super(name,password,role);
	}
	
/*********************
 * �����û���ʹ��dataprocessing�е���
 * @param name
 * @param password
 * @param role
 * @return
 */
public static boolean update(String name, String password, String role) {  //�̳и��࣬�����û�
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
 * �о��û�
 */
//public void ListUser()            //�о��û�
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
 * ɾ���û� ʹ��dataprocessing�е���
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
 * �����û� ,ʹ��dataprocessing�е���
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
 * �޸�����,ͨ���û����update����
 * @param name
 * @param password
 * @param role
 * @return
 */
public boolean changeUserInfo(String name,String password,String role)   //�޸�����
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
