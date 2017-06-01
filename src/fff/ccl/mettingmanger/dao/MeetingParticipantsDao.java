package fff.ccl.mettingmanger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fff.ccl.mettingmanger.datautil.conn.ConnectionFactoryMysql;
import fff.ccl.mettingmanger.excetion.InsertException;
import fff.ccl.mettingmanger.excetion.SelectException;
import fff.ccl.mettingmanger.excetion.UpdateException;
import fff.ccl.mettingmanger.pojo.MeetingParticipants;
import fff.ccl.mettingmanger.pojo.Role;

/**
 * @author caochunlin Email: chunlincao@foxmail.com
 * @Date 2017年5月27日下午8:15:12
 * @Version 1.8
 * @Since
 * @PS 会议和员工对应关系的增删改查
 */
public class MeetingParticipantsDao {

	/**
	 * @PS 用于添加员工与会议的关系
	 * @param mp
	 * @return
	 * @throws InsertException
	 */
	public boolean insertMeetingParticipants(MeetingParticipants mp) throws InsertException {
		Connection connection = ConnectionFactoryMysql.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection.prepareStatement("insert into MeetingParticipants values(?,?,?)");
			ps.setInt(1, mp.getId());
			ps.setInt(2, mp.getMeetingId());
			ps.setInt(3, mp.getParticipantId());
			int i = ps.executeUpdate();
			if (i != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new InsertException("添加员工会议信息失败，信息有误！");
	}

	/**
	 * @PS 用于更新员工与会议的关系
	 * @param mp
	 * @return
	 * @throws UpdateException
	 */
	public boolean updateMeetingParticipants(MeetingParticipants mp) throws UpdateException {
		Connection connection = ConnectionFactoryMysql.getConnection();
		PreparedStatement ps = null;
		try {
			ps = connection
					.prepareStatement("update MeetingParticipants set meetingId = ?, participantId = ? where id = ? ");
			ps.setInt(3, mp.getId());
			ps.setInt(1, mp.getMeetingId());
			ps.setInt(2, mp.getParticipantId());
			int i = ps.executeUpdate();
			if (i != 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new UpdateException("员工会议信息更新失败！");
	}

	/**
	 * @PS 根据ID查找员工与会议信息
	 * @param id
	 * @return
	 * @throws SelectException
	 */
	public MeetingParticipants selectMeetingParticipantsById(int id) throws SelectException {
		Connection connection = ConnectionFactoryMysql.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		MeetingParticipants mp = null;
		try {
			ps = connection.prepareStatement("select * from MeetingParticipants where id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				mp = new MeetingParticipants(rs.getInt("id"), rs.getInt("meetingId"), rs.getInt("participantId"));
			}
			if (mp != null) {
				return mp;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new SelectException("未找到对应的员工与会议信息");
	}
	
	public List<MeetingParticipants> selectMeetingParticipantsByparticipantId(int participantId) throws SelectException {
		Connection connection = ConnectionFactoryMysql.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		MeetingParticipants mp = null;
		List<MeetingParticipants> list = new ArrayList<MeetingParticipants>();
		try {
			ps = connection.prepareStatement("select * from MeetingParticipants where participantId = ?");
			ps.setInt(1, participantId);
			rs = ps.executeQuery();
			while (rs.next()) {
				mp = new MeetingParticipants(rs.getInt("id"), rs.getInt("meetingId"), rs.getInt("participantId"));
				list.add(mp);
			}
			if (list.size() != 0) {
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		throw new SelectException("该员工暂时没有任何会议");
	}

}
