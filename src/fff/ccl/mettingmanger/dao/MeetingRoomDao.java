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
import fff.ccl.mettingmanger.pojo.MeetingRoom;

/**
 * @author caochunlin Email: chunlincao@foxmail.com
 * @Date 2017年5月26日下午11:35:23
 * @Version 1.8
 * @Since
 * @PS 会议室类的增删改查
 */
public class MeetingRoomDao {

	/**
	 * @PS 用于添加会议室
	 * @param m
	 *            会议室对象
	 * @return 如果会议室添加成功则返回true，否则抛出InsertException
	 * @throws InsertException
	 *             当添加失败时抛出此异常
	 */

	public boolean insertMeetingRoom(MeetingRoom m) throws InsertException {
		Connection connection = ConnectionFactoryMysql.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("insert into MeetingRoom values(?,?,?,?,?,?)");
			ps.setInt(1, m.getRoomId());
			ps.setString(2, m.getRoomCode());
			ps.setString(3, m.getRoomName());
			ps.setInt(4, m.getRoomCapacity());
			ps.setInt(5, m.getRoomStatus());
			ps.setString(6, m.getDescription());
			int i = ps.executeUpdate();
			if (i != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new InsertException("添加会议室失败，信息有误！");
	}

	/**
	 * @PS 更新会议室信息
	 * @param m
	 *            被更新的会议室对象
	 * @return 如果更新成功则返回true，否则抛出 UpdateException
	 * @throws UpdateException
	 *             当更新会议室信息失败时抛出此异常
	 */
	public boolean updateMeetingRoom(MeetingRoom m) throws UpdateException {
		Connection connection = ConnectionFactoryMysql.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement(
					"update MeetingRoom set roomcode = ?, roomname = ?, roomcapacity = ?, roomstatus = ?, description = ? where room id = ?");
			ps.setInt(6, m.getRoomId());
			ps.setString(1, m.getRoomCode());
			ps.setString(2, m.getRoomName());
			ps.setInt(3, m.getRoomCapacity());
			ps.setInt(4, m.getRoomStatus());
			ps.setString(5, m.getDescription());
			int i = ps.executeUpdate();
			if (i != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new UpdateException("修改会议室信息失败，参数有误！");
	}

	/**
	 * @PS 根据会议室ID查找会议室
	 * @param roomId
	 *            会议室ID
	 * @return 对应的会议室对象，否则抛出 SelectException
	 * @throws SelectException
	 *             当为查找到会议室时抛出此异常
	 */
	public MeetingRoom selectByRoomId(int roomId) throws SelectException {
		Connection connection = ConnectionFactoryMysql.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		MeetingRoom m = null;
		try {
			ps = connection.prepareStatement("select * from MeetingRoom where roomid = ?");
			ps.setInt(1, roomId);
			rs = ps.executeQuery();
			while (rs.next()) {
				m = new MeetingRoom(rs.getInt("roomId"), rs.getString("roomCode"), rs.getString("roomName"),
						rs.getInt("roomCapacity"), rs.getInt("roomStatus"), rs.getString("description"));
			}
			if (m != null) {
				return m;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new SelectException("未找到对应的部门！会议室ID有误！");
	}

	/**
	 * @PS 根据会议室名称查找会议室
	 * @param roomName
	 *            会议室名字
	 * @return 返回会议室对象，否则抛出 SelectException
	 * @throws SelectException
	 *             当未查找此会议室时，抛出此异常
	 */
	public MeetingRoom selectByRoomName(String roomName) throws SelectException {
		Connection connection = ConnectionFactoryMysql.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		MeetingRoom m = null;
		try {
			ps = connection.prepareStatement("select * from MeetingRoom where roomName = ?");
			ps.setString(1, roomName);
			rs = ps.executeQuery();
			while (rs.next()) {
				m = new MeetingRoom(rs.getInt("roomId"), rs.getString("roomCode"), rs.getString("roomName"),
						rs.getInt("roomCapacity"), rs.getInt("roomStatus"), rs.getString("description"));
			}
			if (m != null) {
				return m;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new SelectException("未找到对应的部门！会议室名称有误！");
	}

}
