package context;

import java.sql.*;

public class DbContext {
	public Connection getConnection()throws Exception {
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection("jdbc:sqlserver://localhost:1433; databaseName=SHOPPET; user=sa; password=123; encrypt=false;");
	} 
	public static void main(String[] args) {
		try {
			System.out.println(new DbContext().getConnection());
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("no");
		}
	}
}
