package webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBAction {
	private static DBAction instance = new DBAction();
	private Connection conn;
	public DBAction() {
		/*실습1 properties
		try {
			Properties properties = new Properties();
			String path = DBAction.class.getResource
					("database.properties").getPath();
			path= URLDecoder.decode(path, "utf-8"); //데이타 손실을 발생하지 않기 위한 코드
			properties.load(new FileReader(path));
			String driver = properties.getProperty("driver");
			String url = properties.getProperty("url");
			String username = properties.getProperty("username");
			String password = properties.getProperty("password");
			Class.forName(driver);
			conn =DriverManager.getConnection(url, username, password);
		}catch (Exception e) {
			e.printStackTrace();
		}
		*/
//		실습2 JDBC 기본 //요건 제출용 서버
		 String driver = "com.mysql.cj.jdbc.Driver";
//		 String url = "jdbc:mysql://192.168.0.157:3306/user20?"
//					+ "characterEncoding=UTF-8&serverTimezone=UTC";
		 String url = "jdbc:mysql://localhost:3306/projectginger?"   //요건 내꺼 44번이랑 같이 활성화 해줘야함
				+ "characterEncoding=UTF-8&serverTimezone=UTC";
		try {
			Class.forName(driver);
//			conn = DriverManager.getConnection(url, "user20", "user");
			conn = DriverManager.getConnection(url, "root", "java"); //내꺼 코드
		}catch(Exception e) {
			e.printStackTrace();
		}
		 
		
	}
	public static DBAction getInstance() {
		if(instance == null)
			instance = new DBAction();
		return instance;
	}
	public Connection getConnection() {
		return conn;
	}
	public void close() {
		try {
			if( conn != null ) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
