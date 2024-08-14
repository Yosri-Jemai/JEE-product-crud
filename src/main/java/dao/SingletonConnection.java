package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
	private static Connection connection;
	
	static {
		try {
			Class.forName("com.sql.jdbc.driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Product_DB","admin","admin123");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}

}
