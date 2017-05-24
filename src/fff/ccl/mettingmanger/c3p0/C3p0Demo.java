package fff.ccl.mettingmanger.c3p0;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author ChulinCao E-mail: caochunlin@chinasofti.com
 * @date 2016��12��21�� ����3:08:41
 * @version 1.7
 * @parameter c3p0 ���ݿ����ӳ�
 */
public class C3p0Demo {

	public static void main(String[] args) throws SQLException {
		DataSource dataSource = new ComboPooledDataSource();
		Connection connection = dataSource.getConnection();
		System.out.println(connection);

	}

	public void sss() {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		try {
			cpds.setDriverClass("");
			cpds.setJdbcUrl("");
			cpds.setUser("");
			cpds.setPassword("");
			cpds.setMaxPoolSize(10);

		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}

	}

}
