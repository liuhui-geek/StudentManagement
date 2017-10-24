package liuhui;

import java.sql.*;
import java.util.Enumeration;
import java.util.Vector;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.mysql.jdbc.StatementInterceptorV2;
/********************
 * 哈希图存储用户信息
 * @author 刘辉
 *
 ********************/

	public class DataProcessing{
		public static Connection connection = null;
		public static Statement statement;
		public static PreparedStatement preparedStatement;
		public static ResultSet resultSet;
		public static boolean connectedToDatabase = false;
		
		public static void connectToDatebase (String dirverName,String url,String user,String password) throws ClassNotFoundException, SQLException
		{   //加载数据库驱动类
				Class.forName(dirverName);
				connection = DriverManager.getConnection(url, user, password);
				connectedToDatabase = true;
		}
		public static void disconnectFromDatabase() {
			if(connectedToDatabase)
			{
				try {
					resultSet.close();
					statement.close();
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					connectedToDatabase = false;
				}
			}
		}
		
		public static User searchUser(String name, String password) throws SQLException{
			User temp = null;
			if(!connectedToDatabase)
				throw new SQLException("not connected to database");
			statement = connection.createStatement(
					resultSet.TYPE_SCROLL_INSENSITIVE, 
					resultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM user_info WHERE username='" + name + "'";
					resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				String name1 = resultSet.getString("username");
				String password1 = resultSet.getString("password");
				if (!password1.equals(password))
					return null;
				String role = resultSet.getString("role");
				if(role.equals("administrator"))
					temp = new Administrator(name1, password1, role);
				else if(role.equals("browser"))
					temp = new Browser(name1, password1, role);
				else 
					temp = new Operator(name1, password1, role);
			}
			return temp;
		}
		
		public static Enumeration<User> getAllUser() throws SQLException
		{
			Vector<User> e = new Vector<User>();
			User temp;
			if(!connectedToDatabase)
				throw new SQLException("not connected to database");
			statement = connection.createStatement(
					resultSet.TYPE_SCROLL_INSENSITIVE,
					resultSet.CONCUR_READ_ONLY);
			String sql = "select * from user_info";
			resultSet = statement.executeQuery(sql);
			while(resultSet.next())
			{
				String name1 = resultSet.getString("username");
				String password1 = resultSet.getString("password");
				String role = resultSet.getString("role");
				
				if(role.equals("administrator"))
					temp = new Administrator(name1, password1, role);
				else if(role.equals("browser"))
					temp = new Browser(name1, password1, role);
				else 
					temp = new Operator(name1, password1, role);
				e.addElement(temp);
			}
			return e.elements();
		}
		public static boolean updateUser(String name, String password, String role) throws SQLException{
			if(!connectedToDatabase)
				throw new SQLException("not connected to database");
			String sql = "UPDATE user_info SET password=?, role=? WHERE username=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, role);
			preparedStatement.setString(3, name);
			preparedStatement.executeUpdate();
			return true;
		}
		
		public static boolean insertUser(String name, String password, String role) throws SQLException
		{
			if(!connectedToDatabase)
				throw new SQLException("not connected to database");
			statement = connection.createStatement(
					resultSet.TYPE_SCROLL_SENSITIVE,
					resultSet.CONCUR_UPDATABLE);
			String sql = "INSERT INTO user_info Values(?,?,?);";
			PreparedStatement insertuser = connection.prepareStatement(sql);
			insertuser.setString(1, name);
			insertuser.setString(2, password);
			insertuser.setString(3, role);
			insertuser.executeUpdate();
			return true;
		}
		
		public static boolean delete(String name) throws SQLException{
			if(!connectedToDatabase)
				throw new SQLException("not connected to database");
			statement = connection.createStatement(
					resultSet.TYPE_SCROLL_SENSITIVE,
					resultSet.CONCUR_UPDATABLE);
			String sql = "delete from user_info where username=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.execute();
			return true;
		}
	public static void main(String[] args) {		
		String driverName="com.mysql.jdbc.Driver";               // 加载数据库驱动类
	    	String url="jdbc:mysql://localhost:3306/document";       // 声明数据库的URL
	    	String user="root";                                      // 数据库用户
	    	String password="123456";
	    	try{
	    		connectToDatebase(driverName, url, user, password);
			statement = connection.createStatement( 
			         ResultSet.TYPE_SCROLL_INSENSITIVE,
			         ResultSet.CONCUR_READ_ONLY );
			String sql="select * from user_info";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()){
				String username=resultSet.getString("username");
				String pwd=resultSet.getString("password");
				String role=resultSet.getString("role");
				System.out.println(username+";"+pwd+";"+role);
			}
			disconnectFromDatabase();
	    	}catch(SQLException e){
	    		System.out.println("数据库错误");
	    		//e.printStackTrace();
	   	} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
	
	
	//public  class DataProcessing {
//	private static boolean connectToDB=false;
//	
//	public static Hashtable<String, User> users;
//	static Hashtable<String, Doc> docs;
//
//	static {
//		users = new Hashtable<String, User>();
//		users.put("jack", new Operator("jack","123","operator"));
//		users.put("rose", new Browser("rose","123","browser"));
//		users.put("kate", new Administrator("kate","123","administrator"));
//		Init();
//		//定义时间
//		//初始化对象docs
//		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//		docs = new Hashtable<String,Doc>();
//		docs.put("0001",new Doc("0001","jack",timestamp,"Doc Source Java","Doc.java"));
//	}
///******************************
// * 异常处理源头
// ******************************/
//	public static  void Init(){
//		// connect to database
//		
//		// update database connection status
//		if (Math.random()>0.2)
//			connectToDB = true;
//		else
//			connectToDB = false;
//		
//	}	
//	
///*****************************
// * 根据传递的档案号，判断Doc的对象
// * @param ID
// * @return Doc的对象
// * @throws SQLException
// */
//	public static Doc searchDoc(String ID) throws SQLException
//	{
//		if(docs.containsKey(ID))
//		{
//			Doc temp = docs.get(ID);
//			return temp;
//		}
//		return null;
//	}
///**********************
// * 遍历doc的所有对象
// * @return
// * @throws SQLException
// */
//	
//	public static Enumeration<Doc> getAllDoc() throws SQLException{
//		Enumeration<Doc> e  = docs.elements();
//		return e;
//	}
///**********************
//  * 插入Doc的对象，即 输入文件
//  * @param ID
//  * @param creator
//  * @param timestamp
//  * @param description
//  * @param filename
//  * @return
//  * @throws SQLException
//  */
//	public static boolean insertDoc(String ID, String creator, Timestamp timestamp,String description,String filename) throws SQLException{
//		Doc doc;
//		if (docs.containsKey(ID))
//			return false;
//		else{
//			doc = new Doc(ID,creator,timestamp,description,filename);
//			docs.put(ID, doc);
//			return true;	
//		}
//	}
//	
//	
//	
///******************************
// * 根据传递的用户名和密码，查找对应的用户
// */
//	
//	
//	public static User search(String name, String password) throws SQLException {
//		try {                        //异常处理机制（捕获异常）
//			if ( !connectToDB ) 
//		        throw new SQLException( "Not Connected to Database" );
//			double ranValue=Math.random();
//			if (ranValue>0.5)
//				throw new SQLException( "Error in excecuting Query" );	
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		if (users.containsKey(name)) {
//			User temp =users.get(name);
//			if ((temp.getPassword()).equals(password))
//				return temp;
//		}
//		return null;
//	}
//	
///*****************************
// *遍历所有的User对象
// * @return e
// * @throws SQLException
// */
//	
//	public static Enumeration<User> getAllUser() throws SQLException{
//		try {                            //异常处理机制（捕获异常）
//			if ( !connectToDB ) 
//		        throw new SQLException( "Not Connected to Database" );
//			
//			double ranValue=Math.random();
//			if (ranValue>0.5)
//				throw new SQLException( "Error in excecuting Query" );
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		Enumeration<User> e  = users.elements();
//		return e;
//	}
//
//	
///********************************
// * 更新user的对象
// * @param name
// * @param password
// * @param role
// * @return
// * @throws SQLException
// */
//	public static boolean update(String name, String password, String role) throws SQLException{
//		User user;
//		try {                                         //异常处理机制（捕获异常）
//			if ( !connectToDB ) 
//		        throw new SQLException( "Not Connected to Database" );
//			
//			double ranValue=Math.random();
//			if (ranValue>0.5)
//				throw new SQLException( "Error in excecuting Update" );
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		if (users.containsKey(name)) {
//			if (role.equalsIgnoreCase("administrator"))
//				user = new Administrator(name,password, role);
//			else if (role.equalsIgnoreCase("operator"))
//				user = new Operator(name,password, role);
//			else
//				user = new Browser(name,password, role);
//			users.put(name, user);
//			return true;
//		}else
//			return false;
//		
//	}
//	
//	
///*******************************
// * 插入User的对象
// * @param name
// * @param password
// * @param role
// * @return
// * @throws SQLException
// */
//	public static boolean insert(String name, String password, String role) throws SQLException{
//		User user;
//		try {                                    //异常处理机制（捕获异常）
//			if ( !connectToDB ) 
//		        throw new SQLException( "Not Connected to Database" );
//			
//			double ranValue=Math.random();
//			if (ranValue>0.5)
//				throw new SQLException( "Error in excecuting Insert" );
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		if (users.containsKey(name))
//			return false;
//		else{
//			if (role.equalsIgnoreCase("administrator"))
//				user = new Administrator(name,password, role);
//			else if (role.equalsIgnoreCase("operator"))
//				user = new Operator(name,password, role);
//			else
//				user = new Browser(name,password, role);
//			users.put(name, user);
//			return true;
//		}
//	}
//	
//	
///*******************************
// * 删除user对象
// * @param name
// * @return
// * @throws SQLException
// */
//	public static boolean delete(String name) throws SQLException{
//		try {                                       //异常处理机制（捕获异常）
//			if ( !connectToDB ) 
//		        throw new SQLException( "Not Connected to Database" );
//			
//			double ranValue=Math.random();
//			if (ranValue>0.5)
//				throw new SQLException( "Error in excecuting Delete" );
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		if (users.containsKey(name)){
//			users.remove(name);
//			return true;
//		}else
//			return false;
//		
//	}	
//	
//	
//            
//	public void disconnectFromDB() {
//		if ( connectToDB ){
//			// close Statement and Connection            
//			try{                                    //异常处理机制（捕获异常）
//			    if (Math.random()>0.5)
//					throw new SQLException( "Error in disconnecting DB" );
//			}catch ( SQLException sqlException ){                                            
//			    sqlException.printStackTrace();           
//			}finally{                                            
//				connectToDB = false;              
//			}                             
//		} 
//   }           
//
//	
