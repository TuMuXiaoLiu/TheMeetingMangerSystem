package fff.ccl.mettingmanger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fff.ccl.mettingmanger.datautil.conn.ConnectionFactoryMysql;
import fff.ccl.mettingmanger.excetion.InsertException;
import fff.ccl.mettingmanger.excetion.SelectException;
import fff.ccl.mettingmanger.excetion.UpdateException;
import fff.ccl.mettingmanger.pojo.Role;

/**
 * @author caochunlin Email: chunlincao@foxmail.com
 * @Date 2017年5月27日下午5:58:08
 * @Version 1.8
 * @Since
 * @PS 用于添加角色的增删改查类
 */
public class RoleDao {

	/**
	 * @PS 用于向数据库添加角色
	 * @param r角色对象
	 * @return 如果更新成功则返回true，否则抛出InsertException
	 * @throws InsertException
	 *             当角色插入失败时抛出此异常
	 */
	public boolean insertRole(Role r) throws InsertException {
		Connection connection = ConnectionFactoryMysql.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("insert into Role values(?,?,?)");
			ps.setInt(1, r.getRoleId());
			ps.setString(2, r.getRoleName());
			ps.setString(3, r.getRemark());
			int i = ps.executeUpdate();
			if (i != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new InsertException("添加角色失败，信息有误！");
	}

	/**
	 * @PS 用于更新Role信息
	 * @param r
	 * @return
	 * @throws UpdateException
	 */
	public boolean updateRole(Role r) throws UpdateException {
		Connection connection = ConnectionFactoryMysql.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("update Role set roleName = ?, remark = ? where roleId = ? ");
			ps.setInt(3, r.getRoleId());
			ps.setString(1, r.getRoleName());
			ps.setString(2, r.getRemark());
			int i = ps.executeUpdate();
			if (i != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new UpdateException("角色信息更新失败！");
	}

	/**
	 * @PS 根据ID查找对应的角色信息
	 * @param roleId
	 * @return
	 * @throws SelectException
	 */
	public Role selectRoleById(int roleId) throws SelectException {
		Connection connection = ConnectionFactoryMysql.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Role r = null;
		try {
			ps = connection.prepareStatement("select * from role where roleId = ?");
			ps.setInt(1, roleId);
			rs = ps.executeQuery();
			while (rs.next()) {
				r = new Role(rs.getInt("roleId"), rs.getString("roleName"), rs.getString("remark"));
			}
			if (r != null) {
				return r;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new SelectException("未找到对应的角色");
	}

	public Role selectRoleByName(String roleName) throws SelectException {
		Connection connection = ConnectionFactoryMysql.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Role r = null;
		try {
			ps = connection.prepareStatement("select * from role where roleName = ?");
			ps.setString(1, roleName);
			rs = ps.executeQuery();
			while (rs.next()) {
				r = new Role(rs.getInt("roleId"), rs.getString("roleName"), rs.getString("remark"));
			}
			if (r != null) {
				return r;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new SelectException("未找到对应的角色信息");
	}
}
