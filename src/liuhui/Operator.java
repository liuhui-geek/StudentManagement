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
 * ����¼��Ա��������
 * @author ����
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

	Operator(String name, String password, String role) {   //���캯��
		super(name, password, role);
		// TODO Auto-generated constructor stub
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
