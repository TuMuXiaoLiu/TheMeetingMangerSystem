package fff.ccl.mettingmanger.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ChulinCao E-mail: caochunlin@chinasofti.com
 * @date 2016��12��21�� ����4:53:18
 * @version 1.7
 * @parameter
 */
public class ConnectionMysqlFactory {
	static Connection connection;

	// ��ȡ���ӵľ�̬����
	public static Connection getConnection() {
		try {
			// ��ȡSPI��DriveClass
			Class.forName("com.mysql.jdbc.Driver");
			// ���ӵ����ݿ⣬���������ݿ����Ӷ���
//			connection = DriverManager.getConnection("jdbc:mysql:@localhost:3306:test", "ccl", "ccl");
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", "ccl");
			System.out.println("���ӳɹ�");

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
