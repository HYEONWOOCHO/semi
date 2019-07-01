package Mugic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class music_DB {
	static Connection con;
	static Statement stmt;
	static ResultSet rs;
	static PreparedStatement pstmt;
	 
	
	
	
	public static Connection getDB() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "scott";
		String password = "123456";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		con = DriverManager.getConnection(url, user, password);
		System.out.println("立加");
		
		return con;
	}
	
	public static String savemusic(String title , String singer) throws Exception {
		String sql = "insert into music values(?,?)";
		
		con = getDB();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, singer);
		rs = pstmt.executeQuery(); //角青巩
		
		
		
		
		return null;
	}
	
	public static String[] selectmusic(String title, String singer) throws Exception {
		String sql = "select * from music where title = ? and singer = ?";
		
		
		con = getDB();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, title);
		pstmt.setString(2, singer);
		rs = pstmt.executeQuery(); //角青巩
		
		rs.next();
		String two [] = new String[2];
		two[0] = rs.getString("title");
		two[1] = rs.getString("singer");
		return two;
		
	}
	
	public static void delete(String singer) throws Exception {
		String sql = "delete music where singer = ?";
		
		con = getDB();
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1 , singer);
		rs = pstmt.executeQuery();
		System.out.println("test");
	}
}
