package fff.ccl.mettingmanger.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ChulinCao E-mail: caochunlin@chinasofti.com
 * @date 2017年5月23日 下午12:21:18
 * @version 1.8
 * @since
 * @parameter
 * @PS 用于获取数据库(MySQL数据库)连接
 */
public class ConnectionFactoryMysql {
	static Connection connection;

	// 获取数据库连接对象
	public static Connection getConnection() {
		try {
			// 获取SPI中DriveClass
			Class.forName("com.mysql.jdbc.Driver");
			// 获取数据库连接对象
			// connection =
			// DriverManager.getConnection("jdbc:mysql:@localhost:3306:test",
			// "ccl", "ccl");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "root");
			System.out.println("连接成功");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * @PS 关闭数据库连接对象
	 * @pram Connection 对象
	 * @return void
	 */
	public static void closeConnection(Connection connection) {
		if (null != connection) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
