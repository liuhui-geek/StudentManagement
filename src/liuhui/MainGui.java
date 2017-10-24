package liuhui;

import java.sql.SQLException;

import myGUI.LoginFrame;
/************************
 * GUI执行入口
 * @author lenovo
 *
 */
public class MainGui {
	public static void main(String[] args) {
		
		String driverName="com.mysql.jdbc.Driver";               // 加载数据库驱动类
		String url="jdbc:mysql://localhost:3306/document";       // 声明数据库的URL
		String user="liutao";                                      // 数据库用户
		String password="199608";
		LoginFrame run = new LoginFrame();
		run.setTitle("系统登录");
		run.setSize(350, 225);
		run.setResizable(false);
		run.setLocationRelativeTo(null);
		run.setVisible(true);
		try {
			DataProcessing.connectToDatebase(driverName, url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
