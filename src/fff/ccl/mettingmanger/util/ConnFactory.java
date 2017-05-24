package fff.ccl.mettingmanger.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ChulinCao E-mail: caochunlin@chinasofti.com
 * @date 2016��12��20�� ����11:25:31
 * @version 1.7
 * @parameter ���ݿ����ӹ���
 */
public class ConnFactory {
	static Connection connection;

	// ��ȡ���ӵľ�̬����
	public static Connection getConnection() {
		try {
			// ��ȡSPI��DriveClass
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// ���ӵ����ݿ⣬���������ݿ����Ӷ���
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "ccl", "ccl");

			System.out.println("连接成功");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	// �ر����Ӷ���
	public static void closeConnection() {
		if (null != connection) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// ���������Ƿ�ɹ�
	public static void main(String[] args) {
		Connection connection = ConnFactory.getConnection();
	}

}
