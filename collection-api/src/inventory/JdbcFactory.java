package inventory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public final class JdbcFactory {
	private JdbcFactory() {
		
	}
	public static Connection getConnection() throws SQLException{
	String url = "jdbc:mysql://localhost:3306/training";
	DriverManager.registerDriver(new Driver()); //driver manager in jvm
	Connection conn = DriverManager.getConnection(url,"root","EYbangalore31#");
	return conn;
	}
}
