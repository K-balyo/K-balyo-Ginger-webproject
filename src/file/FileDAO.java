package file;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FileDAO {
	
	private Connection conn;
	
	public FileDAO() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/projectginger?"
					+ "characterEncoding=UTF-8&serverTimezone=UTC";
			String dbID = "root";
			String dbPassword = "java";
			Class.forName(driver);
			conn = DriverManager.getConnection(url, dbID, dbPassword);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public int upload(String name, String kind, int price, int price2, int price3 , 
			String tag,  String content, int state, String address,String image	, String bestyn) {
		String sql = "INSERT INTO PRODUCT(NAME,KIND,PRICE1,PRICE2,PRICE3,TAG,CONTENT,STATE,ADDRESS,IMAGE,BESTYN,CRE_DATE) VALUES (?,?,?,?,?,?,?,?,?,?,?,now())";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, kind);
			pstmt.setInt(3, price);
			pstmt.setInt(4, price2);        
			pstmt.setInt(5, price3);
			pstmt.setString(6, tag);
			pstmt.setString(7, content);
			pstmt.setInt(8, state);
			pstmt.setString(9, address);
			pstmt.setString(10, image);
			pstmt.setString(11, bestyn);
			return pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
