package fff.ccl.mettingmanger.pojo;

/**
 * @PS 会议室管理系统的用户类
 * @author caochunlin Email: chunlincao@foxmail.com
 * @Date 2017年5月22日下午8:58:16
 * @Version 1.8
 * @Since
 */

public class User {

	private String id;
	private String realname;
	private String username;
	private String password;
	private long phone;
	private String email;
	/**
	 * 用户的状态，分三种 1 ➡ 待审批，员工已注册但还未审批 2 ➡ 已审批，员工已注册并且已审批 3 ➡ 已关闭，员工已离职并不再使用 ️
	 */
	private int state;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the realname
	 */
	public String getRealname() {
		return realname;
	}

	/**
	 * @param realname
	 *            the realname to set
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the phone
	 */
	public long getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(long phone) {
		this.phone = phone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the state
	 */
	public int getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(int state) {
		this.state = state;
	}

	/**
	 * 员工的无参构造方法
	 */
	public User() {
		super();
	}

	/**
	 * 员工的全参构造方法用于注册员工
	 * 
	 * @param id
	 *            员工账号
	 * @param realname
	 *            员工真实姓名
	 * @param username
	 *            员工的用户名
	 * @param password
	 *            员工登陆用的密码
	 * @param phone
	 *            员工的手机好吗
	 * @param email
	 *            员工的邮箱
	 * @param state
	 *            员工的审批状态
	 * @see field state
	 */
	public User(String id, String realname, String username, String password, long phone, String email, int state) {
		super();
		this.id = id;
		this.realname = realname;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.email = email;
		this.state = state;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + (int) (phone ^ (phone >>> 32));
		result = prime * result + ((realname == null) ? 0 : realname.hashCode());
		result = prime * result + state;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone != other.phone)
			return false;
		if (realname == null) {
			if (other.realname != null)
				return false;
		} else if (!realname.equals(other.realname))
			return false;
		if (state != other.state)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", realname=" + realname + ", username=" + username + ", password=" + password
				+ ", phone=" + phone + ", email=" + email + ", state=" + state + "]";
	}

}
