package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	public static Connection getDBConnection() {

		Connection conn = null;

		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Insurance", "root", "132617");

		} catch (SQLException e) {

		}

		return conn;

	}

}
