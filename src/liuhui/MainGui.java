package liuhui;

import java.sql.SQLException;

import myGUI.LoginFrame;
/************************
 * GUIִ�����
 * @author lenovo
 *
 */
public class MainGui {
	public static void main(String[] args) {
		
		String driverName="com.mysql.jdbc.Driver";               // �������ݿ�������
		String url="jdbc:mysql://localhost:3306/document";       // �������ݿ��URL
		String user="liutao";                                      // ���ݿ��û�
		String password="199608";
		LoginFrame run = new LoginFrame();
		run.setTitle("ϵͳ��¼");
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
