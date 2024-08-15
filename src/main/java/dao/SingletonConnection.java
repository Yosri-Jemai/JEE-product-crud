package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
	private static Connection connection;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	// New driver name for MySQL 8.0.x and later
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Product_DB","admin","admin123");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}

}
