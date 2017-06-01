package fff.ccl.mettingmanger.datautil.c3p0;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * @author ChulinCao E-mail: caochunlin@chinasofti.com
 * @date 2016年12月21日 下午3:08:41
 * @version 1.7
 * @parameter c3p0 数据库连接池
 */
public class C3p0Demo {

	public static void main(String[] args) throws SQLException {
		DataSource dataSource = new ComboPooledDataSource();
		Connection connection = dataSource.getConnection();
		System.out.println(connection);

	}

}
