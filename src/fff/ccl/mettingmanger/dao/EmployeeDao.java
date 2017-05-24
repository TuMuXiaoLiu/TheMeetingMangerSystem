package fff.ccl.mettingmanger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fff.ccl.mettingmanger.pojo.Employee;
import fff.ccl.mettingmanger.util.ConnectionFactoryOracle;

/**
 * @author caochunlin E-mail: caochunlin@chinasofti.com
 * @date 创建时间：2017年5月24日 上午11:02:14
 * @version 1.8
 * @param
 * @since
 * @PS 员工类的增删改查
 */
public class EmployeeDao {

	/**
	 * @PS 插入用户
	 * @pram Employee e用户对象
	 * @return boolean 插入成功则返回true，否则返回false
	 */
	public boolean insert(Employee e) {
		Connection connection = ConnectionFactoryOracle.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("insert into employee values(?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, e.getEmployeeId());
			ps.setString(2, e.getEmployeeName());
			ps.setString(3, e.getUserName());
			ps.setString(4, e.getUserPassword());
			ps.setLong(5, e.getPhone());
			ps.setString(6, e.getEmail());
			ps.setInt(7, e.getDeptid());
			ps.setInt(8, e.getRoleId());
			ps.setInt(9, e.getEmployeeStatus());
			ps.setString(10, e.getRemark());
			ps.execute();
			return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	/**
	 * 
	 * @PS TODO
	 * @pram e 用户对象
	 * @return boolean 更新成功则返回true，否则返回false
	 */
	public boolean update(Employee e) {
		Connection connection = ConnectionFactoryOracle.getConnection();
		PreparedStatement ps = null;
		try {
			Employee employee = selectById(e.getEmployeeId());
			/*
			 * // 判断修改的是否是密码
			 * if(e.getUserPassword().equals(employee.getUserPassword())) {
			 * 
			 * }
			 */

			ps = connection.prepareStatement(
					"update  employee set employeeName =?,username=?, userpassword = ?, phone = ?, email = ?, deptid = ?, roleid = ?, employeestatus = ?, remark = ? where employeeid = ?");
			ps.setInt(10, e.getEmployeeId());
			ps.setString(1, e.getEmployeeName());
			ps.setString(2, e.getUserName());
			ps.setString(3, e.getUserPassword());
			ps.setLong(4, e.getPhone());
			ps.setString(5, e.getEmail());
			ps.setInt(6, e.getDeptid());
			ps.setInt(7, e.getRoleId());
			ps.setInt(8, e.getEmployeeStatus());
			ps.setString(9, e.getRemark());
			ps.execute();
			return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	/**
	 * @PS 根据ID查找用户
	 * @param employeeId
	 * @return Employee 返回用户对象
	 */

	public Employee selectById(int employeeId) {
		Connection connection = ConnectionFactoryOracle.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee employee = null;
		try {
			ps = connection.prepareStatement("select * from employee where id = ?");
			ps.setInt(1, employeeId);
			rs = ps.executeQuery();
			while (rs.next()) {
				employee = new Employee(rs.getInt("employeeId"), rs.getString("employeeName"), rs.getString("userName"),
						rs.getString("userPassword"), rs.getLong("phone"), rs.getString("email"), rs.getInt("deptid"),
						rs.getInt("roleId"), rs.getInt("employeeStatus"), rs.getString("remark"));
			}
			if (null != employee) {
				return employee;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * @PS 根据ID和密码查找用户
	 * @param employeeId
	 * @return Employee 返回用户对象
	 */

	public Employee selectByIdPassword(int employeeId, String userpassword) {
		Connection connection = ConnectionFactoryOracle.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Employee employee = null;
		try {
			ps = connection.prepareStatement("select * from employee where id = ? and userpassword = ?");
			ps.setInt(1, employeeId);
			ps.setString(2, userpassword);
			rs = ps.executeQuery();
			while (rs.next()) {
				employee = new Employee(rs.getInt("employeeId"), rs.getString("employeeName"), rs.getString("userName"),
						rs.getString("userPassword"), rs.getLong("phone"), rs.getString("email"), rs.getInt("deptid"),
						rs.getInt("roleId"), rs.getInt("employeeStatus"), rs.getString("remark"));
			}
			if (null != employee) {
				return employee;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
