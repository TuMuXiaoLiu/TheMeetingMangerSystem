package fff.ccl.mettingmanger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import fff.ccl.mettingmanger.pojo.Department;
import fff.ccl.mettingmanger.util.ConnectionFactoryMysql;

/**
 * @author ChulinCao E-mail: caochunlin@chinasofti.com
 * @date 2017年5月25日 上午8:55:19
 * @version 1.8
 * @since
 * @PS 部门的增删改查
 */
public class DepartmentDao {
	/**
	 * @PS 插入部门
	 * @param d
	 * @return
	 */
	public boolean insertDepartment(Department d) {
		Connection connection = ConnectionFactoryMysql.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("insert into department values(?, ?, ?)");
			ps.setInt(1, d.getDepartmentId());
			ps.setString(2, d.getDepartmentName());
			ps.setString(3, d.getRemark());
			int i = ps.executeUpdate();
			if (i!=0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new 
	}

	/**
	 * @PS TODO
	 * @param d
	 * @return
	 */
	public boolean updateDepartment(Department d) {
		Connection connection = ConnectionFactoryMysql.getConnection();
		PreparedStatement ps = null;

		return false;
	}

	/**
	 * @PS TODO
	 * @param departmentId
	 * @return
	 */
	public Department selectDepartmentById(int departmentId) {
		Connection connection = ConnectionFactoryMysql.getConnection();
		PreparedStatement ps = null;

		return null;
	}

	/**
	 * @PS TODO
	 * @param departmentName
	 * @return
	 */
	public Department selectDepartmentByName(String departmentName) {
		Connection connection = ConnectionFactoryMysql.getConnection();
		PreparedStatement ps = null;

		return null;
	}

}
