package fff.ccl.mettingmanger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

	public Employee selectById(int employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Employee selectByIdPassword(int employeeId, String userpassword) {
		// TODO Auto-generated method stub
		return null;
	}

}
