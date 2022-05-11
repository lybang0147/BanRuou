package vn.liquor.connection;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnect {
	private final String serverName = "localhost";
	private final String dbName = "BanRuou";
	private final String portNumber = "1433";
	private final String instance = "";// MSSQLSERVER LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
	private final String userID = "sa";
	private final String password = "1234567@a$";
	public Connection getConnection() throws Exception {
		 try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/banruou?useSSL=false&useUnicode=true&characterEncoding=UTF-8", "root",
	                    "12345678");
	            return conn;

	        } catch (Exception e) {
	            System.out.println(e);
	            return null;
	        }
	}
	public static void main(String[] args) {
	try {
		System.out.println(new DBConnect().getConnection());
	} catch (Exception e) { 
	 
	}
}
}
