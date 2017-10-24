package liuhui;



import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Scanner;
/*************************
 * 档案录入员操作界面
 * @author 刘辉
 *
 */
public class Operator extends User{

	
	String uploadpath2 = "e:\\";
	private Scanner ao;
	private Scanner b;
	private Scanner c;
	private Scanner d;
	private String bSystem;
	private String cSystem;
	private String aSystem;

	Operator(String name, String password, String role) {   //构造函数
		super(name, password, role);
		// TODO Auto-generated constructor stub
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

	public String getbSystem() {
		return bSystem;
	}

	public void setbSystem(String bSystem) {
		this.bSystem = bSystem;
	}

	public String getcSystem() {
		return cSystem;
	}

	public void setcSystem(String cSystem) {
		this.cSystem = cSystem;
	}

	public String getaSystem() {
		return aSystem;
	}

	public void setaSystem(String aSystem) {
		this.aSystem = aSystem;
	}


}
