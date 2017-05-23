/**
 * 
 */
package fff.ccl.mettingmanger.pojo;

/**
 * @author ChulinCao E-mail: caochunlin@chinasofti.com
 * @date 2017年5月23日 下午6:12:59
 * @version 1.8
 * @since
 * @parameter
 * @PS 会议与员工的关系
 */
public class MeetingParticipants {
	/**
	 * ID 标识
	 */
	private int id;
	/**
	 * 会议ID标识
	 */
	private int meetingId;
	/**
	 * 参加会议的员工
	 */
	private int participantId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(int meetingId) {
		this.meetingId = meetingId;
	}

	public int getParticipantId() {
		return participantId;
	}

	public void setParticipantId(int participantId) {
		this.participantId = participantId;
	}

	public MeetingParticipants() {
	}

	public MeetingParticipants(int id, int meetingId, int participantId) {
		this.id = id;
		this.meetingId = meetingId;
		this.participantId = participantId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + meetingId;
		result = prime * result + participantId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MeetingParticipants other = (MeetingParticipants) obj;
		if (id != other.id)
			return false;
		if (meetingId != other.meetingId)
			return false;
		if (participantId != other.participantId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MeetingParticipants [id=" + id + ", meetingId=" + meetingId + ", participantId=" + participantId + "]";
	}

}
