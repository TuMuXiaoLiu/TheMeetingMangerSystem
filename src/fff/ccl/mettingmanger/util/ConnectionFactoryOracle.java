package fff.ccl.mettingmanger.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ChulinCao E-mail: caochunlin@chinasofti.com
 * @date 17.5.24
 * @version 1.8
 * @parameter 用于获取数据库(Oracle数据库)连接
 */
public class ConnectionFactoryOracle {
	static Connection connection;

	// 获取数据库连接对象
	public static Connection getConnection() {
		try {
			// 获取SPI中DriveClass
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 获取数据库连接对象
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ccl", "ccl");

			System.out.println("连接成功");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * 
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
