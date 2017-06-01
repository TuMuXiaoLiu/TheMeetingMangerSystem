package fff.ccl.mettingmanger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fff.ccl.mettingmanger.datautil.conn.ConnectionFactoryMysql;
import fff.ccl.mettingmanger.excetion.InsertException;
import fff.ccl.mettingmanger.excetion.SelectException;
import fff.ccl.mettingmanger.excetion.UpdateException;
import fff.ccl.mettingmanger.pojo.Department;

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
	 * @throws InsertException
	 */
	public boolean insertDepartment(Department d) throws InsertException {
		Connection connection = ConnectionFactoryMysql.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("insert into department values(?, ?, ?)");
			ps.setInt(1, d.getDepartmentId());
			ps.setString(2, d.getDepartmentName());
			ps.setString(3, d.getRemark());
			int i = ps.executeUpdate();
			if (i != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new InsertException("部门信息添加失败！");
	}

	/**
	 * @PS 更新部门信息
	 * @param d
	 * @return
	 * @throws UpdateException 
	 */
	public boolean updateDepartment(Department d) throws UpdateException  {
		Connection connection = ConnectionFactoryMysql.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection
					.prepareStatement("update department set departmentName = ?, remark = ? where departmentId = ? ");
			ps.setInt(3, d.getDepartmentId());
			ps.setString(1, d.getDepartmentName());
			ps.setString(2, d.getRemark());
			int i = ps.executeUpdate();
			if (i != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new UpdateException("部门参信息更新失败！");
	}

	/**
	 * @PS 根据部门ID查找对应的部门
	 * @param departmentId 部门编号
	 * @return 返回部门对象，否则抛出 SelectException
	 * @throws SelectException
	 *             当未查到对应的部门时，抛出此异常
	 */
	public Department selectDepartmentById(int departmentId) throws SelectException {
		Connection connection = ConnectionFactoryMysql.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Department d = null;
		try {
			ps = connection.prepareStatement("select * from department where DepartmentId = ?");
			ps.setInt(1, departmentId);
			rs = ps.executeQuery();
			while (rs.next()) {
				d = new Department(rs.getInt("departmentId"), rs.getString("departmentName"), rs.getString("remark"));
			}
			if (d != null) {
				return d;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new SelectException("未找到对应的部门");
	}

	/**
	 * @PS 根据部门名字查找部门
	 * @param departmentName
	 *            部门名称
	 * @return 返回部门对象，否则抛出 SelectException
	 * @throws SelectException
	 *             当未查到对应的部门时，抛出此异常
	 */
	public Department selectDepartmentByName(String departmentName) throws SelectException {
		Connection connection = ConnectionFactoryMysql.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Department d = null;
		try {
			ps = connection.prepareStatement("select * from department where departmentName = ?");
			ps.setString(1, departmentName);
			rs = ps.executeQuery();
			while (rs.next()) {
				d = new Department(rs.getInt("departmentId"), rs.getString("departmentName"), rs.getString("remark"));
			}
			if (d != null) {
				return d;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new SelectException("未找到对应的部门");
	}

}
