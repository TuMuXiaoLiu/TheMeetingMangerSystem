package fff.ccl.mettingmanger.pojo;

/**
 * @author ChulinCao E-mail: caochunlin@chinasofti.com
 * @date 2017年5月23日 下午5:58:42
 * @version 1.8
 * @since
 * @parameter
 * @PS 会议室
 */
public class MeetingRoom {
	/**
	 * 会议室ID
	 */
	private int rootId;
	/**
	 * 会议室门牌号
	 */
	private String roomCode;
	/**
	 * 会议室名称
	 */
	private String roomName;
	/**
	 * 会议室容量
	 */
	private int roomCapacity;
	/**
	 * 会议室状态 1表示可用，2表示停用
	 */
	private int roomStatus;
	/**
	 * 会议室描述
	 */
	private String description;

	public int getRootId() {
		return rootId;
	}

	public void setRootId(int rootId) {
		this.rootId = rootId;
	}

	public String getRoomCode() {
		return roomCode;
	}

	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int getRoomCapacity() {
		return roomCapacity;
	}

	public void setRoomCapacity(int roomCapacity) {
		this.roomCapacity = roomCapacity;
	}

	public int getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(int roomStatus) {
		this.roomStatus = roomStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MeetingRoom() {
	}

	public MeetingRoom(int rootId, String roomCode, String roomName, int roomCapacity, int roomStatus,
			String description) {
		super();
		this.rootId = rootId;
		this.roomCode = roomCode;
		this.roomName = roomName;
		this.roomCapacity = roomCapacity;
		this.roomStatus = roomStatus;
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + roomCapacity;
		result = prime * result + ((roomCode == null) ? 0 : roomCode.hashCode());
		result = prime * result + ((roomName == null) ? 0 : roomName.hashCode());
		result = prime * result + roomStatus;
		result = prime * result + rootId;
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
		MeetingRoom other = (MeetingRoom) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (roomCapacity != other.roomCapacity)
			return false;
		if (roomCode == null) {
			if (other.roomCode != null)
				return false;
		} else if (!roomCode.equals(other.roomCode))
			return false;
		if (roomName == null) {
			if (other.roomName != null)
				return false;
		} else if (!roomName.equals(other.roomName))
			return false;
		if (roomStatus != other.roomStatus)
			return false;
		if (rootId != other.rootId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MeetingRoom [rootId=" + rootId + ", roomCode=" + roomCode + ", roomName=" + roomName + ", roomCapacity="
				+ roomCapacity + ", roomStatus=" + roomStatus + ", description=" + description + "]";
	}

}
