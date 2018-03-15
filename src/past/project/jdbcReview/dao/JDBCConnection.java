package past.project.jdbcReview.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	private static String jdbcurl;
	private static String nm;
	private static String pwd;

	private static JDBCConnection db = new JDBCConnection();

	/**
	 * This method is to guarantee single pattern
	 */
	private JDBCConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			jdbcurl = "jdbc:mysql://localhost:3306/mybatis";
			nm = "root";
			pwd = "root";

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is synchronized method and provides connection. The thread
	 * would be wait if there is not connection in the pool.
	 * 
	 * @return return the connection
	 */
	public static Connection getCon() {
		synchronized (JDBCConnection.class) {
			Connection con;
			try {
				con = DriverManager.getConnection(jdbcurl, nm, pwd);
				return con;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	}

	public static void returnCon(Connection con) {
		synchronized (JDBCConnection.class) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
